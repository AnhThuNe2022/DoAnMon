/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Taixe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu
 */
public interface TaiXeService {
     Map<Integer,List<Object>> listTX(String kw,int page);  
         List<Taixe> getListTXPage(List<Taixe> ListTX, int page);
    boolean deleTX(int id);

    boolean addTX(Taixe tx);
        Taixe getTaiXe(int id);
    boolean updateTX(Taixe tx);
    Map<Integer,List<Taixe>> listLoaiTX();

//    public Map<Integer, List<Object>> listTX(String kw, int page);


}
