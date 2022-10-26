/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Khachhang;
import com.at.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author thu
 */
public interface UserService extends UserDetailsService  {
        List<User> Listu (String kw);
         List<User> getListUPage(List<User> ListU, int page);
    boolean addU(User u);
   boolean addUKH(User u,Khachhang kh);

        User getU(String id);
    boolean updateUser(User u);
    boolean deleteUser(String id);
    List<User> checkUser(String role,int idNV);
    List<User> getUserNull(int i);
     User getUserByUsername(String sdt);
    boolean register(User user , Khachhang h);
    User getCurrentUser();


}
