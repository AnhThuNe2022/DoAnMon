/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Chitiethoadon;
import com.at.repository.HoaDonChiTietRepository;
import com.at.repository.HuyVeRepository;
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
public class HoaDonChiTietRepositoryImpl implements HoaDonChiTietRepository{
    @Autowired
     private LocalSessionFactoryBean sessionFactory;
    
    @Autowired
    HuyVeRepository huyVeRepository;


    @Override
    public boolean deleteHDCT(int maCT) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
             Chitiethoadon ct = s.get(Chitiethoadon.class, maCT);
            
            if(ct != null){
            if(!ct.getTrangThai())
            {
                huyVeRepository.deleteHuyVe(maCT);

            }
            s.remove(ct);
            }
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Chitiethoadon findCT(int id) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            return s.get(Chitiethoadon.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addHDCT(Chitiethoadon ct) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(ct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean setTTHDCT(int maCT) {
         Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Chitiethoadon ct = s.get(Chitiethoadon.class,maCT);
            ct.setTrangThai(Boolean.FALSE);
            s.update(ct);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

   
    
}
