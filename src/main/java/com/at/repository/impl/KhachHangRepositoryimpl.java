/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Khachhang;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.at.repository.KhachHangRepository;

/**
 *
 * @author thu
 */
@Repository
@Transactional
public class KhachHangRepositoryimpl implements KhachHangRepository{
    @Autowired  
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public Khachhang getKH() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Khachhang k = s.get(Khachhang.class, 1);
        return k;
    }
    
 @Override
    public boolean addKH(Khachhang h) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            
            s.save(h);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
//         System.err.println(ex.getMessage());

        }
        return false;
    }
    
    
    
}
