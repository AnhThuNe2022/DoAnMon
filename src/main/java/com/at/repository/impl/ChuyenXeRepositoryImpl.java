/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.ChuyennxeChongoi;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Comment;
import com.at.pojo.Hoadon;
import com.at.pojo.Loaixe;
import com.at.pojo.Nhanvien;
import com.at.pojo.Taixe;
import com.at.pojo.Tuyenxe;
import com.at.pojo.User;
import com.at.pojo.Xe;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.repository.ChuyenXeRepository;
import com.at.repository.CommentRepository;
import com.at.repository.HoaDonRepository;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu
 */
@Repository
@Transactional
@PropertySource("classpath:page.properties")

public class ChuyenXeRepositoryImpl implements ChuyenXeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    ChuyenXeChoNgoiRepository chuyenXeChoNgoiRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    CommentRepository commentRepository;
    
      @Autowired
     Environment env;

    @Override
    public Map<Integer,List<Object>> listCX(String kw,int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Chuyenxe> q = b.createQuery(Chuyenxe.class);
        Root rootCX = q.from(Chuyenxe.class);
        Root rootTX = q.from(Tuyenxe.class);

        q.select(rootCX);
        if (kw != null) {

            Predicate p = b.like(rootCX.get("maTuyenXe"),rootTX.get("maTuyenXe"));

            Predicate p1 = b.like(rootCX.get("maChuyenXe").as(String.class),
                    String.format("%%%s%%", kw));

            Predicate p2 = b.like(rootTX.get("maTuyenXe").as(String.class),
                    String.format("%%%s%%", kw));

            Predicate p3 = b.like(rootCX.get("gioXuatPhat").as(String.class),
                    String.format("%%%s%%", kw));
            
            Predicate p4 = b.like(rootCX.get("gioDen").as(String.class),
                    String.format("%%%s%%", kw));

            q.where(b.and(b.or(p1,p2,p3,p4),p));
        }
        q = q.orderBy(b.desc(rootCX.get("maChuyenXe")));    
        Query query = s.createQuery(q);
        Map<Integer,List<Object>> map = new HashMap<>();
      
        map.put(1, query.getResultList());
        if (page > 0) {
            int max = Integer.parseInt( env.getProperty("page.count"));
            int index = (page - 1) * max;
            query.setFirstResult(index);
            query.setMaxResults(max);

        }
         map.put(0,query.getResultList());
        
        return map;
    }

    @Override
    public boolean addChuyenXe(Chuyenxe cx) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            cx.setMaTuyenXe(s.get(Tuyenxe.class, cx.getFTuyenXe()));
            cx.setMaXe(s.get(Xe.class, cx.getFMaXe()));
            cx.setMaTaiXeChinh(s.get(Taixe.class, cx.getFTaiXeChinh()));
            cx.setMaTaiXePhu(s.get(Taixe.class, cx.getFTaiXePhu()));
            cx.setSoChoConDu(cx.getMaXe().getMaLoaiXe().getSoGhe());
            s.save(cx);

            if (!chuyenXeChoNgoiRepository.addCXCN(cx.getMaChuyenXe())) {
                return false;
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteChuyenXe(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {

            Chuyenxe cx = s.get(Chuyenxe.class, id);

            for (Hoadon maHD : cx.getHoadonSet()) {
                if (!hoaDonRepository.deleteHD(maHD.getMaHoaDon())) {
                    return false;
                }
            }

            if (chuyenXeChoNgoiRepository.deleteCXCN(id)) {
                for (Comment c : cx.getCommentSet()) {
                    if (!commentRepository.deleteComment(c.getIdComment())) {
                        return false;
                    }
                }
                s.remove(cx);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Chuyenxe getChuyenXe(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Chuyenxe cx = s.get(Chuyenxe.class, id);
            cx.getMaChuyenXe();
            return cx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateCX(Chuyenxe cx) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            cx.setMaTuyenXe(s.get(Tuyenxe.class, cx.getFTuyenXe()));
            cx.setMaXe(s.get(Xe.class, cx.getFMaXe()));
            cx.setMaTaiXeChinh(s.get(Taixe.class, cx.getFTaiXeChinh()));
            cx.setMaTaiXePhu(s.get(Taixe.class, cx.getFTaiXePhu()));
            s.update(cx);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCX(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
         Chuyenxe cx = s.get(Chuyenxe.class, id);
            try{
            for (Hoadon maHD : cx.getHoadonSet()) {
                if (!hoaDonRepository.deleteHD(maHD.getMaHoaDon())) {
                    return false;
                }
            }

            if (chuyenXeChoNgoiRepository.deleteCXCN(id)) {
                for (Comment c : cx.getCommentSet()) {
                    if (!commentRepository.deleteComment(c.getIdComment())) {
                        return false;
                    }
                }
                s.remove(cx);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Chuyenxe> listCXSearch(String maTX, Date day, int so) {
        Session s = this.sessionFactory.getObject().getCurrentSession();  

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Chuyenxe> q = b.createQuery(Chuyenxe.class);
        Root rootCX = q.from(Chuyenxe.class);
        Root rootTX = q.from(Tuyenxe.class);
        
         
        Predicate p2 = b.equal(rootCX.get("maTuyenXe"), rootTX.get("maTuyenXe"));

        q.select(rootCX);
        
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String newDate =f.format(day);
        
        Date today = null;
        try {
            today = f.parse(newDate);
        } catch (ParseException ex) {
            Logger.getLogger(ChuyenXeRepositoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      
       
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        Predicate p1 = b.like(rootTX.get("maTuyenXe").as(String.class), maTX);
        Predicate p3 = b.lessThan(rootCX.get("gioXuatPhat"),tomorrow );
        Predicate p4 =b.and( b.greaterThanOrEqualTo(rootCX.get("gioXuatPhat"), today),
                b.greaterThanOrEqualTo(rootCX.get("gioXuatPhat"), new Date()));
   

        q = q.where(b.and(p1,p2,p4,p3));
        if (so != -1) {
            if (so == 0) {
                q = q.orderBy(b.asc(rootCX.get("gioXuatPhat")));
            } else if (so == 1) {
                q = q.orderBy(b.desc(rootCX.get("gioXuatPhat")));
            } else if (so == 2) {
                q = q.orderBy(b.asc(rootCX.get("giaVe")));
            } else if (so == 3) {
                q = q.orderBy(b.desc(rootCX.get("giaVe")));
            }
        }

        Query query = s.createQuery(q);

 

        return query.getResultList();

    }

    @Override
    public BigDecimal getPrice(int macx) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Chuyenxe cx = s.get(Chuyenxe.class, macx);
        return cx.getGiaVe();

    }

    @Override
    public List<Chuyenxe> getCXByTaiXe(User u) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Chuyenxe> q = b.createQuery(Chuyenxe.class);
            Root rootCX = q.from(Chuyenxe.class);
            Root rootTX = q.from(Taixe.class);
            Taixe t = u.getTaixe();
            Predicate p1 = null;
            q.select(rootCX);

            if (t.getLoaitx() == '1') {
                p1 = b.equal(rootCX.get("maTaiXeChinh"), rootTX.get("maTaiXe"));

            } else if (t.getLoaitx() == '2') {
                p1 = b.equal(rootCX.get("maTaiXePhu"), rootTX.get("maTaiXe"));

            }
//            Predicate p2 = b.equal(rootTX.get("maTaiXe"), t.getMaTaiXe());
            Predicate p3 = b.greaterThanOrEqualTo(rootCX.get("gioDen").as(Date.class), new Date() );


//            q.where(b.and(p1, p2,p3));
            q.where(b.and(p1,p3));
            q = q.orderBy(b.asc(rootCX.get("maChuyenXe")));
            Query query = s.createQuery(q);

            
//             List<Chuyenxe> Listcx = query.getResultList();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//
//        List<Chuyenxe> kq = new ArrayList<>();
//        for (Chuyenxe c : Listcx) {
//            String ngay = formatter.format(c.getGioXuatPhat());
//            if (c.getGioDen().after(new Date())) {
//                kq.add(c);
//            }    
//            
//        }

            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean UpdateCX2(Chuyenxe cx) {
        try{
            Session s = this.sessionFactory.getObject().getCurrentSession();
            Chuyenxe c = s.get(Chuyenxe.class, cx.getMaChuyenXe());
            c.setSoChoConDu(cx.getSoChoConDu());
            s.update(c);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

}
