/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Chuyenxe;
import com.at.pojo.Comment;
import com.at.repository.CommentRepository;
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
public class CommentRepositoryImpl implements CommentRepository{
   @Autowired
    private LocalSessionFactoryBean sessionFactory;
  
    @Override
    public List<Comment> getListCmtToCX(int cx) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root rootCm = q.from(Comment.class);
        Root rootCX = q.from(Chuyenxe.class);

       Predicate p2 = b.equal(rootCX.get("maChuyenXe"), rootCm.get("maChuyenXe"));
        q.select(rootCm);
        Predicate p1 = b.equal(rootCX.get("maChuyenXe"), cx); 
        q = q.where(b.and(p2,p1));

        q = q.orderBy(b.desc(rootCm.get("createDate")));

        Query query = s.createQuery(q);
        
        return query.getResultList();

    }

    @Override
    public Comment addComment(Comment c) {
                Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
          
            s.save(c);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteComment(int cmt) {
     Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
           Comment c = s.get(Comment.class, cmt);
           s.remove(c);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
