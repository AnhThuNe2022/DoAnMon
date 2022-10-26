/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Bill;
import com.at.pojo.ChuyennxeChongoi;
import com.at.pojo.Chuyenxe;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.service.ChuyenXeChoNgoiService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class ChuyenXeChoNgoiServiceImpl implements ChuyenXeChoNgoiService{

    
    @Autowired
    ChuyenXeChoNgoiRepository chuyenXeChoNgoiRepository;
    
    @Override
    public boolean addCXCN(int maCX) {
        return true;
    }

    @Override
    public List<ChuyennxeChongoi> listcxcn(int maCX, int tang) {
      List<ChuyennxeChongoi> Listcxcn =  this.chuyenXeChoNgoiRepository.listcxcn(maCX);
      List<ChuyennxeChongoi> kq = new ArrayList<>();
      if(tang == 1 )
      {
          for(int i = 0 ; i < (Listcxcn.size())/2;i++)
              kq.add(Listcxcn.get(i));
      }
      else if(tang == 2)
      {
           for(int i = (Listcxcn.size())/2 ; i < Listcxcn.size() ;i++)
              kq.add(Listcxcn.get(i));
      
      }
      
      return kq;
    }

    @Override
    public int countColumn(int maCX) {
        return this.chuyenXeChoNgoiRepository.countColumn(maCX);
    }

    @Override
    public ChuyennxeChongoi getCXCN(int maCXCN) {
        return this.chuyenXeChoNgoiRepository.getCXCN(maCXCN);
    }

    @Override
    public List<ChuyennxeChongoi> listTT() {
        return this.chuyenXeChoNgoiRepository.listTT();
    }

    @Override
    public int checkCXCN(List<Bill> b) {
        
        for(Bill bi: b)
        {
            int k = chuyenXeChoNgoiRepository.checkCXCN(bi.getCxcn().getIdCXMG());
          if( k == 0)
                 return 0;
          if(k == -1)
              return -1;
        }
        
        for(Bill bi:b)
        {
            if(!this.chuyenXeChoNgoiRepository.updateTT(bi.getCxcn().getIdCXMG(),1))
               return -1;
        }
        
        return 1;
        
    }

    @Override
    public boolean getTTFalse(List<Bill> b) {
        for(Bill bi : b)
        {
            if(!this.chuyenXeChoNgoiRepository.updateTT(bi.getCxcn().getIdCXMG(), 0))
                return false;
        }
        return true;
    }

    @Override
    public boolean updateTTFalse(List<ChuyennxeChongoi> cx) {
           for(ChuyennxeChongoi c : cx)
           {
               if(!this.chuyenXeChoNgoiRepository.updateTT(c.getIdCXMG(), 0))
                   return false;
           }
           
           return true;
    }

    @Override
    public List<Integer> listChoNgoiTrong(List<Chuyenxe> cx) {
        List<Integer> list = new ArrayList<>();
        for(Chuyenxe x : cx)
        {
            int k = this.chuyenXeChoNgoiRepository.ListSoChoConLai(x.getMaChuyenXe());
            if(k == -1)
                return null;
            list.add(k);
        }
       return list;
    }

  
    
}
