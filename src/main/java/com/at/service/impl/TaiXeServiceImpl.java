/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Taixe;
import com.at.pojo.Tuyenxe;
import com.at.repository.TaiXeRepository;
import com.at.service.TaiXeService;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class TaiXeServiceImpl implements TaiXeService{

    @Autowired
    TaiXeRepository taiXeRepository; 
    
    @Override
    public Map<Integer,List<Object>> listTX(String kw, int page) {
        return this.taiXeRepository.listTX(kw,page);
    }

    @Override
    public boolean addTX(Taixe tx) {
        return this.taiXeRepository.addTX(tx);
    }

    @Override
    public Taixe getTaiXe(int id) {
        return this.taiXeRepository.getTaiXe(id);
    }

    @Override
    public boolean updateTX(Taixe tx) {
        return this.taiXeRepository.updateTX(tx);
    }

    @Override
    public List<Taixe> getListTXPage(List<Taixe> ListTX, int page) {
             int max = 7;
            int index = (page - 1) * max;
            List<Taixe> tx = new ArrayList<>();
            for(int i =index; i< (max+index);i++)
            {
                if(i >= ListTX.size())
                    break;
                tx.add(ListTX.get(i));
            }
            return tx; 
    }

    @Override
    public boolean deleTX(int id) {
       return this.taiXeRepository.deleTX(id);
    }

    @Override
    public Map<Integer, List<Taixe>> listLoaiTX() {
        
        return taiXeRepository.getTypeTX();
                
    }
    
}
