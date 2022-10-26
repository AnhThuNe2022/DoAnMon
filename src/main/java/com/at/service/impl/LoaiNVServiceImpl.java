/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Loainv;
import com.at.repository.LoaiNVRepository;
import com.at.service.LoaiNVService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class LoaiNVServiceImpl implements LoaiNVService{

    @Autowired
    LoaiNVRepository loaiNVRepository;
    
    @Override
    public List<Loainv> getListLoaiNV() {
        return this.loaiNVRepository.getListLoaiNV();
    }
    
}
