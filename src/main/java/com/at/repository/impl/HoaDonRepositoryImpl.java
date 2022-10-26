/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Bill;
import com.at.pojo.Chitiethoadon;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Hoadon;
import com.at.pojo.Khachhang;
import com.at.pojo.Tuyenxe;
import com.at.pojo.User;
import com.at.pojo.Xe;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.repository.ChuyenXeRepository;
import com.at.repository.HoaDonChiTietRepository;
import com.at.repository.HoaDonRepository;
import com.at.repository.XeRepository;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu
 */
@Repository
@Transactional
public class HoaDonRepositoryImpl implements HoaDonRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    ChuyenXeChoNgoiRepository chuyenXeChoNgoiRepository;

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    
    @Autowired
    ChuyenXeRepository chuyenXeRepository; 

    @Override
    public List<Hoadon> listHDByCX(int maCX) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Hoadon> q = b.createQuery(Hoadon.class);
        Root rootHD = q.from(Hoadon.class);
        Root rootHDCT = q.from(Chitiethoadon.class);

        Root rootCX = q.from(Chuyenxe.class);
        q.select(rootHD);

        Predicate p = b.equal(rootHD.get("maHoaDon"), rootHDCT.get("maHD"));
        Predicate p1 = b.equal(rootCX.get("maChuyenXe"), rootHD.get("maChuyenXe"));
        Predicate p2 = b.equal(rootCX.get("maChuyenXe"), maCX);
        Predicate p3 = b.equal(rootHDCT.get("trangThai"), true);

        q.where(b.and(p1, p2,p,p3));
        q.groupBy(rootHD.get("maHoaDon"));

        q = q.orderBy(b.asc(rootHD.get("maHoaDon")));

        Query query = s.createQuery(q);

        return query.getResultList();

    }

//    @Override
//    public boolean deleteHDToCX(int maCX) {
//        try {
//            Session s = this.sessionFactory.getObject().getCurrentSession();
//            Query q = s.createQuery("FROM Hoadon h where h.maChuyenXe.maChuyenXe =:p");
//            q.setParameter("p", maCX);
//            List<Hoadon> Listhd = q.getResultList();
//
//            for (Hoadon x : Listhd) {
//                if (hoaDonChiTietRepository.deleteHDCT(x.getMaHoaDon())) {
//                    s.remove(x);
//                } else {
//                    return false;
//                }
//            }
//
//            return true;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//
//    }
    @Override
    public boolean deleteHD(int maHD) {

        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Hoadon hd = s.get(Hoadon.class, maHD);

            Query q = s.createQuery("FROM Chitiethoadon h where h.maHD.maHoaDon =:p");
            q.setParameter("p", maHD);
            List<Chitiethoadon> Listcthd = q.getResultList();

            for (Chitiethoadon x : Listcthd) {
                if (!this.hoaDonChiTietRepository.deleteHDCT(x.getMaCT())) {
                    return false;
                }
            }

            s.remove(hd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int addHoaDon(Hoadon hd, List<Bill> b) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(hd);
            Chuyenxe cx = hd.getMaChuyenXe();
            cx.setSoChoConDu(cx.getSoChoConDu()-hd.getSoVe());
            for (Bill bi : b) {
                Chitiethoadon ct = new Chitiethoadon();
                ct.setMaHD(hd);
                ct.setMaGhe(bi.getCxcn());
                ct.setGia(new BigDecimal(bi.getDonGia()));
                if (!this.hoaDonChiTietRepository.addHDCT(ct)) {
                    return 0;
                }
            }
            if(!this.chuyenXeRepository.UpdateCX2(cx))
                return 0;
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Hoadon> listHDByUser(String u) {
        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Hoadon> q = b.createQuery(Hoadon.class);
            Root rootHD = q.from(Hoadon.class);
            Root rootKH = q.from(Khachhang.class);
            User user = s.get(User.class, u);

            q.select(rootHD);

            Predicate p1 = b.equal(rootHD.get("maKH"), rootKH.get("maKH"));

            Predicate p2 = b.equal(rootKH.get("maKH"), user.getKhachhang().getMaKH());

            q.where(b.and(p1, p2));

            Query query = s.createQuery(q);
            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean setTTHoaDonTrue(int maHD) {
        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            Hoadon hd = s.get(Hoadon.class, maHD);
            hd.setTrangThaiTT(Boolean.TRUE);
            s.update(hd);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Hoadon getHoaDonById(int maHD) {
        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            return s.get(Hoadon.class, maHD);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateHD(Hoadon hd) {

        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            s.update(hd);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
