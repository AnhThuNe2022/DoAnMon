/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Loainv;
import com.at.pojo.Nhanvien;
import com.at.pojo.User;
import com.at.repository.NhanVienRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class NhanVienRepositoryimpl implements NhanVienRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    Environment env;
    
    @Override
    public Map<Integer,List<Object>> getListNV(String kw,int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Nhanvien> q = b.createQuery(Nhanvien.class);
        Root root = q.from(Nhanvien.class);
        q.select(root);
        if(kw != null)
        {
            Predicate p1 = b.like(root.get("tenNV").as(String.class),
                        String.format("%%%s%%", kw));
            Predicate p2 = b.like(root.get("maNV").as(String.class),
                    String.format("%%%s%%", kw));
         q = q.where(b.or(p1,p2));
        }
        q = q.orderBy(b.desc(root.get("maNV")));

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
    public boolean addNV(Nhanvien nv) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Loainv l = s.get(Loainv.class,nv.getLoaiNhanVien());
            nv.setLoaiNV(l);
            s.save(nv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteNV(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Nhanvien nv = s.get(Nhanvien.class, id);
            s.remove(nv);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateNV(Nhanvien nv) {

        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
             Loainv l = s.get(Loainv.class,nv.getLoaiNhanVien());
             String maU = nv.getMaU();
             
             if(maU != "null")
             {  
                  User u = s.get(User.class,maU);
                  nv.setMaUser(u);
             }
             else
                 nv.setMaUser(null);
  
            nv.setLoaiNV(l);
            s.clear();
            s.update(nv);
            s.flush();
            return true;
        }catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
            
  }

    @Override
    public Nhanvien getNV(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            return s.get(Nhanvien.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Nhanvien> getListNVPage(List<Nhanvien> ListNV, int page) {
            int max = 7;
            int index = (page - 1) * max;
            List<Nhanvien> nv = new ArrayList<>();
            for(int i =index; i< (max+index);i++)
            {
                if(i >= ListNV.size())
                    break;
                nv.add(ListNV.get(i));
            }
            return nv;
    }

    @Override
    public String getUserNV(int id) {
        
         Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Nhanvien nv =  s.get(Nhanvien.class, id);
            String maU = nv.getMaUser().getMaUser();
            if( maU != null && !maU.isEmpty() )
                  return maU;
            else
                return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

   
    
       


}
