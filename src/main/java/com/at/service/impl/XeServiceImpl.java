/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Xe;
import com.at.repository.XeRepository;
import com.at.service.XeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class XeServiceImpl implements XeService{

    @Autowired
    XeRepository xeRepository; 
    
    @Override
    public List<Xe> listXe() {
        return xeRepository.listXe();
    }
    
}
