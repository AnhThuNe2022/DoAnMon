/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Nhanvien;
import com.at.pojo.Tuyenxe;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author thu
 */
public interface TuyenXeService {

    Map<Integer,List<Object>> getListTuyenXe(String kw,int page);

    List<Tuyenxe> getListTXPage(List<Tuyenxe> ListTX, int page);

    boolean addTuyenXe(Tuyenxe tx);

    boolean updateTuyenXe(Tuyenxe tx);

    Tuyenxe getTuyenXe(String id);

    boolean deleteTX(String id);

    Map<Integer, Set<String>> ListKhoiHanhDiemDen();

    List<Tuyenxe> getListTX( String s);
        Object getMaTX(String khoiHanh, String diemDen);


}
