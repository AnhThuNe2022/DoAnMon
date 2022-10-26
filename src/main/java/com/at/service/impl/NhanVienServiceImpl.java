/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Nhanvien;
import com.at.repository.NhanVienRepository;
import com.at.service.NhanVienService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */

@Service
public class NhanVienServiceImpl implements NhanVienService{

    @Autowired
    NhanVienRepository nhanVienRepository;  
    @Override
    public Map<Integer,List<Object>> getListNV(String kw, int page) {
        return this.nhanVienRepository.getListNV(kw,page);
    }

    @Override
    public boolean addNV(Nhanvien nv) {
        if(nv!=null)
        {
            return this.nhanVienRepository.addNV(nv);     
        }
        else
            return false;
    }

    @Override
    public boolean deleteNV(int id) {
        return this.nhanVienRepository.deleteNV(id);
   
    }

    @Override
    public boolean updateNV(Nhanvien nv) {
        return this.nhanVienRepository.updateNV(nv);
    }

    @Override
    public Nhanvien getNV(int id) {
        return this.nhanVienRepository.getNV(id);
    }

    @Override
    public List<Nhanvien> getListNVPage(List<Nhanvien> ListNV, int page) {
        return this.nhanVienRepository.getListNVPage(ListNV, page);
    }

    @Override
    public String getUserNV(int id) {
        return this.nhanVienRepository.getUserNV(id);
    }

   
    
}
