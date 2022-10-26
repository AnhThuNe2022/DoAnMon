/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Chuyenxe;
import com.at.pojo.User;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu
 */
public interface ChuyenXeService {
        Map<Integer,List<Object>> listCX(String kw,int page);
       List<Chuyenxe> getListCXPage(List<Chuyenxe> ListCX, int page);

    boolean addChuyenXe(Chuyenxe cx);
    boolean deleteChuyenXe(int id);
    Chuyenxe getChuyenXe(int id);
    boolean updateCX(Chuyenxe cx);
    List<Chuyenxe> listCXSearch(String maTX, Date day, int so);
    BigDecimal getPrice(int macx);
    List<Chuyenxe> getCXByTaiXe(User u);




}
