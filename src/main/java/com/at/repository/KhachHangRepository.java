/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Khachhang;
import java.util.List;

/**
 *
 * @author thu
 */
public interface KhachHangRepository {
   public Khachhang getKH();
   public boolean addKH(Khachhang h);

    
    
}
