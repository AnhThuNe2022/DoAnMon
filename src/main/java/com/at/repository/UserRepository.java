/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Khachhang;
import com.at.pojo.User;
import java.util.List;

/**
 *
 * @author thu
 */
public interface UserRepository {

    List<User> Listu(String kw);

    boolean addU(User u);

    boolean addUKH(User u, Khachhang kh);

    String findIdUser(String role);

    User getU(String id);

    boolean updateUser(User u);

    boolean deleteUser(String id);

    List<User> checkUser(String role, String idUser);

    List<User> getUserNull(int i);
    
    User getUserByUsername(String sdt);
    boolean register(User user, Khachhang h);
    
    List<Integer> getUNe();

}
