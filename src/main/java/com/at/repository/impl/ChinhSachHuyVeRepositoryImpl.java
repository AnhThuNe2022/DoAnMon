/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Chinhsachhuyve;
import com.at.repository.ChinhSachHuyVeRepository;
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
public class ChinhSachHuyVeRepositoryImpl implements  ChinhSachHuyVeRepository{

      @Autowired
     private LocalSessionFactoryBean sessionFactory;

    @Override
    public Chinhsachhuyve getCXHV(int maCX) {
       try {   
          Session s = this.sessionFactory.getObject().getCurrentSession();

            return s.get(Chinhsachhuyve.class, maCX);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
