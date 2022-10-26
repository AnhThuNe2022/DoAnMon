/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Chitiethoadon;
import com.at.repository.HoaDonChiTietRepository;
import com.at.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService
{

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository; 
    @Override
    public Chitiethoadon findCT(int id) {
        return this.hoaDonChiTietRepository.findCT(id);
    }

    
}
