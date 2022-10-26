/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Nhanvien;
import com.at.pojo.Tuyenxe;
import com.at.repository.NhanVienRepository;
import com.at.repository.TuyenXeRepository;
import com.at.service.ChuyenXeService;
import com.at.service.NhanVienService;
import com.at.service.TuyenXeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service

public class TuyenXeServiceImpl implements TuyenXeService {

    @Autowired
    TuyenXeRepository tuyenXeRepository;
    
    @Autowired
    ChuyenXeService chuyenXeService; 

    @Override
    public Map<Integer,List<Object>> getListTuyenXe(String kw, int page) {
        return this.tuyenXeRepository.getListTuyenXe(kw,page);
    }

    @Override
    public boolean addTuyenXe(Tuyenxe tx) {
//        List<Tuyenxe> listTX = this.getListTuyenXe();
//        for (Tuyenxe x : listTX) {
//            if (tx.getNoiDen().equals(x.getNoiDen()) && tx.getNoiKhoiHanh().equals(x.getNoiKhoiHanh())) {
//                return false;
//            }
//        }
        return this.tuyenXeRepository.addTuyenXe(tx);
    }

    @Override
    public boolean updateTuyenXe(Tuyenxe tx) {
        if (tx != null) {
            return this.tuyenXeRepository.updateTuyenXe(tx);
        }
        return false;
    }

    @Override
    public Tuyenxe getTuyenXe(String id) {
        return this.tuyenXeRepository.getTuyenXe(id);
    }

    @Override
    public List<Tuyenxe> getListTXPage(List<Tuyenxe> Tuyenxe, int page) {
            int max = 7;
            int index = (page - 1) * max;
            List<Tuyenxe> tx = new ArrayList<>();
            for(int i =index; i< (max+index);i++)
            {
                if(i >= Tuyenxe.size())
                    break;
                tx.add(Tuyenxe.get(i));
            }
            return tx;  
    
    }

    @Override
    public boolean deleteTX(String id) {
        return this.tuyenXeRepository.deleteTuyenXe(id);
    }

    @Override
    public Map<Integer, Set<String>> ListKhoiHanhDiemDen() {
        return this.tuyenXeRepository.ListKhoiHanhDiemDen();
    }

    @Override
    public List<Tuyenxe> getListTX( String s) {
        return this.tuyenXeRepository.getListTX( s);
    }

    @Override
    public Object getMaTX(String khoiHanh, String diemDen) {
       return this.tuyenXeRepository.getMaTX(khoiHanh, diemDen);

    }

}
