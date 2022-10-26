/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Khachhang;
import com.at.pojo.Tuyenxe;
import com.at.pojo.User;
import com.at.repository.NhanVienRepository;
import com.at.repository.UserRepository;
import com.at.service.UserService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public List<User> Listu(String kw) {
        return this.userRepository.Listu(kw);
    }

    @Override
    public List<User> getListUPage(List<User> ListU, int page) {
        int max = 7;
        int index = (page - 1) * max;
        List<User> u = new ArrayList<>();
        for (int i = index; i < (max + index); i++) {
            if (i >= ListU.size()) {
                break;
            }
            u.add(ListU.get(i));
        }
        return u;
    }

    @Override
    public boolean addU(User u) {
        try {
            String pass = u.getPass();
            u.setPass(this.passwordEncoder.encode(pass));
            Map r = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            u.setAvatar((String) r.get("secure_url"));
            return this.userRepository.addU(u);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public User getU(String id) {
        return this.userRepository.getU(id);
    }

    @Override
    public boolean updateUser(User u) {
        if(u.getPass() != null)
        {
            String pass = u.getPass();
            u.setPass(this.passwordEncoder.encode(pass));
        }
        return this.userRepository.updateUser(u);
    }

    @Override
    public boolean deleteUser(String id) {
        return this.userRepository.deleteUser(id);
    }

    @Override
    public List<User> checkUser(String role, int idNV) {

        String idUser = nhanVienRepository.getUserNV(idNV);
        return this.userRepository.checkUser(role, idUser);
    }

    @Override
    public List<User> getUserNull(int i) {
        return this.userRepository.getUserNull(i);
    }

    @Override
    public UserDetails loadUserByUsername(String sdt) throws UsernameNotFoundException {
        User u = this.getUserByUsername(sdt);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid username!!!");
        }

        Set<GrantedAuthority> authorities = new HashSet<>(); //sua theo cai cua mik
        authorities.add(new SimpleGrantedAuthority(u.getUserRole()));

        return new org.springframework.security.core.userdetails.User(
                u.getSdt(), u.getPass(), authorities);
    }

    @Override
    public User getUserByUsername(String sdt) {
        return this.userRepository.getUserByUsername(sdt);
    }

    @Override
    public boolean register(User user, Khachhang h) {
        user.setPass(this.passwordEncoder.encode(user.getPass()));
        return this.userRepository.register(user, h);
    }

//    @Override
//    public boolean addUKH(User u, Khachhang kh) {
//          String pass = u.getPass();
//        u.setPass(this.passwordEncoder.encode(pass));
//        // mac dinh la role nay cho dki nguoi dung
//        u.setUserRole(User.USER);
//        return this.userRepository.addUKH(u,kh);
//    }
    @Override
    public boolean addUKH(User u, Khachhang kh) {
        try {
            String pass = u.getPass();
            u.setPass(this.passwordEncoder.encode(pass));
            // mac dinh la role nay cho dki nguoi dung
            u.setUserRole(User.USER);

            Map r = this.cloudinary.uploader().upload(u.getFile().getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            u.setAvatar((String) r.get("secure_url"));
            return this.userRepository.addUKH(u, kh);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String sdt = ((UserDetails) principal).getUsername();
        User u = this.userRepository.getUserByUsername(sdt);
        return u;
    }

}
