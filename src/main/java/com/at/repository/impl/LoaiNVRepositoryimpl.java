/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Loainv;
import com.at.repository.LoaiNVRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class LoaiNVRepositoryimpl implements LoaiNVRepository{
    @Autowired
    LocalSessionFactoryBean sessionFactory;
    @Override
    public List<Loainv> getListLoaiNV() {
        try{
             Session s = this.sessionFactory.getObject().getCurrentSession();
            Query q = s.createQuery("FROM Loainv");
            return q.getResultList();
        }catch(Exception e)
        {
           e.printStackTrace();
           return null;
        }

    }
    
}
