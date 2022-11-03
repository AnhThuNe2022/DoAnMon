/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Chitiethoadon;
import com.at.pojo.Chitiethoadon_;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Hoadon;
import com.at.pojo.Huyve;
import com.at.pojo.Tuyenxe;
import com.at.repository.BieuDoRepository;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ParameterExpression;
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
public class BieuDoRepositoryImpl implements BieuDoRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

   

    @Override
    public List<Object[]> matDoChuyenXe() {
        try {
            Session s = sessionFactory.getObject().getCurrentSession();
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
            Root rootTx = q.from(Tuyenxe.class);
            Root rootCx = q.from(Chuyenxe.class);

            q.where(b.equal(rootCx.get("maTuyenXe"), rootTx.get("maTuyenXe")));

            q.multiselect(rootTx.get("maTuyenXe"), b.count(rootTx.get("maTuyenXe")));

            q.groupBy(rootTx.get("maTuyenXe"));

            Query query = s.createQuery(q);

            return query.getResultList();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Object[]> doanhThu(int tk,int year) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        Root rootCthd = q.from(Chitiethoadon.class);
                
        Join<Object, Object> huyVe = rootCthd.join(Chitiethoadon_.huyve, JoinType.LEFT);
        Join<Object, Object> hoaDon = rootCthd.join(Chitiethoadon_.maHD);

         Expression<Integer> get = null;
            if (tk == 0 || tk == 1) {
                get = b.function("MONTH", Integer.class, hoaDon.get("ngayDatVe"));
            } else if (tk == 2) {
                get = b.function("YEAR", Integer.class, hoaDon.get("ngayDatVe"));
            }
        q.multiselect(get, b.sum(rootCthd.get("gia")), b.sum(huyVe.get("soTienHoan")));
        if(tk != 2){
            Predicate p = b.equal(b.function("YEAR", Integer.class, hoaDon.get("ngayDatVe")),year);
            q.where(p);
        }
        q.groupBy(get);
    
        Query query = s.createQuery(q);
        return query.getResultList();

    }

}
