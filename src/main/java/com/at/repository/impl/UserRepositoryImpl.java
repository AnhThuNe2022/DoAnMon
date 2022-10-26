/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Khachhang;
import com.at.pojo.Nhanvien;
import com.at.pojo.Taixe;
import com.at.pojo.User;
import com.at.repository.KhachHangRepository;
import com.at.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.jdbc.core.JdbcOperationsExtensionsKt.query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public List<User> Listu(String kw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        if (kw != null) {
            Predicate p1 = b.like(root.get("maUser").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p2 = b.like(root.get("sdt").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p3 = b.like(root.get("email").as(String.class),
                    String.format("%%%s%%", kw));
            Predicate p4 = b.notLike(root.get("userRole").as(String.class), "ROLE_KH");
            q = q.where(b.and(b.or(p1, p2, p3), p4));
        }

        q = q.orderBy(b.desc(root.get("maUser")));

        Query query = s.createQuery(q);

        return query.getResultList();
    }

    @Override
    public boolean addU(User u) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            u.setMaUser(this.findIdUser(u.getUserRole().substring(5)));
            s.save(u);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> checkUser(String role, String idUser) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE userRole =:p");

        q.setParameter("p", role);
        List<User> us = q.getResultList();
        List<User> us2 = new ArrayList<>();
        if (role.contains("AD") || role.contains("NV")) {
            for (User u : us) {
                if (u.getNhanvien() == null) {
                    us2.add(u);

                }
            }
        } else {
            for (User u : us) {
                if (u.getTaixe() == null) {
                    us2.add(u);
                }
            }
        }

        if (idUser != null) {
            us2.add(s.get(User.class, idUser));
        }
        return us2;

    }

    @Override
    public String findIdUser(String USER) {
        Session s = sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        Predicate p1 = b.like(root.get("maUser").as(String.class),
                String.format("%%%s%%", USER));

        q = q.where(p1);

        q = q.orderBy(b.desc(root.get("maUser")));

        Query query = s.createQuery(q);

        if (query.getResultList().isEmpty()) {
            return String.format("%s%d", USER, 1);
        }

        List<User> Listu = query.getResultList();
//        List<Integer> result = Listu.stream().sorted(Comparator.comparing(User::getMaUser)).map(u -> Integer.parseInt(u.getMaUser().substring(2))).collect(Collectors.toList());

        int listid[] = new int[Listu.size()];
        int i = 0;
        for (User u1 : Listu) {
            int k = Integer.parseInt(u1.getMaUser().substring(2));
            listid[i++] = k;
        }
        Arrays.sort(listid);
        int ma = listid[Listu.size() - 1];
        String kq = String.format("%s%d", USER, ++ma);
        return kq;

    }

    @Override
    public User getU(String id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            return s.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateUser(User u) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            User us = s.get(User.class, u.getMaUser());
            if (u.getPass() != null) {
                us.setPass(u.getPass());
            }
            us.setEmail(u.getEmail());
            us.setNhanvien(u.getNhanvien());
            us.setSdt(u.getSdt());
            us.setUserRole(u.getUserRole());
            us.setTaixe(u.getTaixe());

            s.update(us);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            User u = s.get(User.class, id);
            if (u.getNhanvien() == null && u.getTaixe() == null) {
                s.remove(u);
            } else if (u.getNhanvien() != null || u.getTaixe() != null);
            {
                if (id.contains("AD") || id.contains("NV")) {
                    u.getNhanvien().setMaUser(null);
                } else if (id.contains("TX")) {
                    u.getTaixe().setMaUser(null);
                }

                s.remove(u);
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getUserNull(int i) {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User");
        List<User> Listu = q.getResultList();
        List<User> us2 = new ArrayList<>();
        if (i == 1) {
            for (User u : Listu) {
                if (!u.getMaUser().contains("KH")) {
                    if (u.getTaixe() == null && u.getNhanvien() == null && (u.getMaUser().contains("NV") || u.getMaUser().contains("AD"))) {
                        us2.add(u);
                    }
                }

            }
        } else if (i == 2) {
            for (User u : Listu) {
                if (!u.getMaUser().contains("KH")) {
                    if (u.getTaixe() == null && u.getNhanvien() == null && u.getMaUser().contains("TX")) {
                        us2.add(u);
                    }
                }

            }
        }

        return us2;

    }

    @Override
    public boolean addUKH(User u, Khachhang kh) {
        Session s = sessionFactory.getObject().getCurrentSession();
        try {
            String makh =this.findIdUser(u.getUserRole().substring(5)); 
            u.setMaUser(makh);
            s.save(u);
            System.out.println("====================="+makh);
            kh.setMaUser(u);
            this.khachHangRepository.addKH(kh);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
//            System.err.println(ex.getMessage());

        }
        return false;
    }

    @Override
    public User getUserByUsername(String sdt) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);
        q.where(b.equal(root.get("sdt"), sdt));

        org.hibernate.query.Query query = session.createQuery(q);
        return (User) query.getSingleResult();
    }

    @Override
    public boolean register(User u, Khachhang h) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(u);
            session.save(h);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Integer> getUNe() {
        String USER = "KH";
        Session s = sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<User> q = b.createQuery(User.class);
        Root root = q.from(User.class);
        q.select(root);

        Predicate p1 = b.like(root.get("maUser").as(String.class),
                String.format("%%%s%%", USER));

        q = q.where(p1);

        q = q.orderBy(b.desc(root.get("maUser")));

        Query query = s.createQuery(q);

//        if (query.getResultList().isEmpty()) {
//            return String.format("%s%d", USER, 1);
//        }

        List<User> Listu = query.getResultList();
        List<Integer> result= null;
//        result = Listu.stream().sorted(Comparator.comparing(Integer.parseInt(User::getMaUser).substring(2)))
//                .map(u -> Integer.parseInt(u.getMaUser().substring(2)))
//                .collect(Collectors.toList());

        
        return result;
//        int listid[] = new int[Listu.size()];
//        int i = 0;
//        for (User u1 : Listu) {
//            int k = Integer.parseInt(u1.getMaUser().substring(2));
//            listid[i++] = k;
//        }
//        Arrays.sort(listid);
//        int ma = listid[Listu.size() - 1];
//        String kq = String.format("%s%d", USER, ++ma);
//        return kq;
    }


}
