/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Khachhang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.at.repository.KhachHangRepository;
import com.at.service.KhachHangService;

/**
 *
 * @author thu
 */
@Service
public class KhachHangServiceImpl implements KhachHangService{

    @Autowired
    KhachHangRepository khachHangRepository;
    
    @Override
    public Khachhang getKH() {
        return khachHangRepository.getKH(); 
    }
    
}
