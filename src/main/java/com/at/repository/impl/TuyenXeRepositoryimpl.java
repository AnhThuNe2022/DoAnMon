/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Chuyenxe;
import com.at.pojo.Nhanvien;
import com.at.pojo.Tuyenxe;
import com.at.repository.ChuyenXeRepository;
import com.at.repository.TuyenXeRepository;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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

public class TuyenXeRepositoryimpl implements TuyenXeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    ChuyenXeRepository chuyenXeRepository;
    
    @Autowired
    Environment env;

    @Override
    public Map<Integer,List<Object>>  getListTuyenXe(String kw,int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Tuyenxe> q = b.createQuery(Tuyenxe.class);
        Root root = q.from(Tuyenxe.class);
        q.select(root);
        if (kw != null) {
            Predicate p1 = b.like(root.get("noiDen").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p2 = b.like(root.get("noiKhoiHanh").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p3 = b.like(root.get("maTuyenXe").as(String.class),
                    String.format("%%%s%%", kw));

            q = q.where(b.or(p1, p2, p3));
        }
        q = q.orderBy(b.desc(root.get("maTuyenXe")));

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
    public boolean addTuyenXe(Tuyenxe tx) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            s.save(tx);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateTuyenXe(Tuyenxe tx) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.update(tx);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Tuyenxe getTuyenXe(String id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            return s.get(Tuyenxe.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteTuyenXe(String id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Tuyenxe tx = s.get(Tuyenxe.class, id);
            Query q = s.createQuery("FROM Chuyenxe h where h.maTuyenXe.maTuyenXe =:p");
            q.setParameter("p", id);
            List<Chuyenxe> Listcx = q.getResultList();

            for (Chuyenxe x : Listcx) {
                if (!chuyenXeRepository.deleteCX(x.getMaChuyenXe())) {
                    return false;
                }
            }
            s.remove(tx);

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Map<Integer, Set<String>> ListKhoiHanhDiemDen() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Map<Integer, Set<String>> map = new HashMap<>();
            Set<String> diemXuatPhat = new HashSet<>();
            Set<String> diemDen = new HashSet<>();
            Query q = s.createQuery("FROM Tuyenxe");
            List<Tuyenxe> Listtx = q.getResultList();
            for (Tuyenxe tx : Listtx) {
                diemXuatPhat.add(tx.getNoiKhoiHanh());
                diemDen.add(tx.getNoiDen());
            }
            map.put(1, diemXuatPhat);
            map.put(2, diemDen);

            return map;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Tuyenxe> getListTX( String name) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Tuyenxe> q = b.createQuery(Tuyenxe.class);
            Root root = q.from(Tuyenxe.class);
            q.select(root);
            
            Predicate p1 = b.equal(root.get("noiKhoiHanh").as(String.class), name);
            q.where(p1);
            Query query = s.createQuery(q);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getMaTX(String khoiHanh, String diemDen) {
        
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Tuyenxe> q = b.createQuery(Tuyenxe.class);
            Root root = q.from(Tuyenxe.class);
            q.multiselect(root.get("maTuyenXe"));
            
            
            Predicate p1 = b.equal(root.get("noiKhoiHanh").as(String.class), khoiHanh);
            Predicate p2 = b.equal(root.get("noiDen").as(String.class), diemDen);

           q.where(b.and(p1,p2));
            Query query = s.createQuery(q);
            return query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}
