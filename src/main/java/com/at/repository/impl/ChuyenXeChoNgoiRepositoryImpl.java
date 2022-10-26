/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.ChuyennxeChongoi;
import com.at.pojo.Chuyenxe;
import com.at.repository.ChuyenXeChoNgoiRepository;
import java.util.ArrayList;
import java.util.List;
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
public class ChuyenXeChoNgoiRepositoryImpl implements ChuyenXeChoNgoiRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public boolean addCXCN(int maCX) {

        try {

            Session s = this.sessionFactory.getObject().getCurrentSession();
            Chuyenxe c = s.get(Chuyenxe.class, maCX);
            String k = c.getMaXe().getMaLoaiXe().getKhongGian();
            String[] listk = k.split(",");
            //10,10,12,6
            String[] chu = {"A", "B", "C", "D"};

            for (int i = 0; i < listk.length; i++) {
                int number = Integer.parseInt(listk[i]);
                for (int j = 1; j <= number; j++) {
                    String maghe = chu[i] + j;
                    ChuyennxeChongoi cxcn = new ChuyennxeChongoi();
                    cxcn.setMaChuyenXe(c);
                    cxcn.setMaGhe(maghe);
                    s.save(cxcn);
                }
            }

            return true;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteCXCN(int macx) {

        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            Query q = s.createQuery("FROM ChuyennxeChongoi");
            List<ChuyennxeChongoi> Listcxcn = q.getResultList();

            if (Listcxcn != null) {
                List<ChuyennxeChongoi> list = new ArrayList<>();
                Chuyenxe cx = s.get(Chuyenxe.class, macx);
                for (ChuyennxeChongoi x : Listcxcn) {
                    if (x.getMaChuyenXe() == cx) {
                        s.remove(x);
                    }
                }

            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<ChuyennxeChongoi> listcxcn(int maCX) {
      Session s = this.sessionFactory.getObject().getCurrentSession();
      CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ChuyennxeChongoi> q = b.createQuery(ChuyennxeChongoi.class);
        Root root = q.from(ChuyennxeChongoi.class);
        Root rootCX = q.from(Chuyenxe.class);
        
        Predicate p1 = b.equal(root.get("maChuyenXe"), rootCX.get("maChuyenXe"));
        
        q.select(root);
        
        Predicate p2 = b.equal(rootCX.get("maChuyenXe"), maCX); 
        q = q.where(b.and(p1,p2));
       

        Query query = s.createQuery(q);

            return query.getResultList();
    }

    @Override
    public int countColumn(int maCX) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
         Chuyenxe c = s.get(Chuyenxe.class, maCX);
          String k = c.getMaXe().getMaLoaiXe().getKhongGian();
          String[] listk = k.split(",");
          return listk.length;
        
    }

    @Override
    public ChuyennxeChongoi getCXCN(int maCXCN) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            return s.get(ChuyennxeChongoi.class, maCXCN);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ChuyennxeChongoi> listTT() {
      
      try{
          
        Session s = this.sessionFactory.getObject().getCurrentSession();
       CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ChuyennxeChongoi> q = b.createQuery(ChuyennxeChongoi.class);
        Root root = q.from(ChuyennxeChongoi.class);
             
        q.select(root);
        
        Predicate p2 = b.equal(root.get("trangThai"), true); 
        q = q.where(p2);
        Query query = s.createQuery(q);

            return query.getResultList();
          
          
       } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     

    }

    @Override
    public int checkCXCN(int id) {
        try{
         Session s = this.sessionFactory.getObject().getCurrentSession();
          ChuyennxeChongoi cx = s.get(ChuyennxeChongoi.class, id);
          if(cx.getTrangThai() == false)    
                return 1;
          else 
              return 0;
       } catch (Exception e) {
            e.printStackTrace();
           return -1;
        }  
        
    }

    @Override
    public boolean updateTT(int id, int i) {
        try{
         Session s = this.sessionFactory.getObject().getCurrentSession();
          ChuyennxeChongoi cx = s.get(ChuyennxeChongoi.class, id);
          if(i == 1){
               cx.setTrangThai(Boolean.TRUE);             
          }
           
          else if(i == 0){
              cx.setTrangThai(Boolean.FALSE);
          }
          s.update(cx);
          return true;
       } catch (Exception e) {
            e.printStackTrace();
           return false;
        }  
        
    }

    @Override
    public int ListSoChoConLai(int maCX) {     
        try{
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<ChuyennxeChongoi> q = b.createQuery(ChuyennxeChongoi.class);
        Root rootCxcn = q.from(ChuyennxeChongoi.class);
        Root rootCx = q.from(Chuyenxe.class);
        
        Predicate p2 = b.equal(rootCx.get("maChuyenXe"), rootCxcn.get("maChuyenXe"));
        
        q.select(rootCxcn);
        
        Predicate p1 = b.equal(rootCx.get("maChuyenXe"),maCX); 
   
        
        Predicate p3 = b.equal(rootCxcn.get("trangThai"),0); 
        q = q.where(b.and(p2,p1,p3));

        Query query = s.createQuery(q);

        return query.getResultList().size();
       } catch (Exception e) {
            e.printStackTrace();
           return -1;
        }  
    }

}
