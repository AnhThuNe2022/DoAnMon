/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Bill;
import com.at.pojo.ChuyennxeChongoi;
import com.at.pojo.Chuyenxe;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author thu
 */
public interface ChuyenXeChoNgoiService {
        boolean addCXCN(int maCX);
    List<ChuyennxeChongoi> listcxcn(int maCX,int tang);  
    int countColumn(int maCX); 
    ChuyennxeChongoi getCXCN(int maCXCN);
    List<ChuyennxeChongoi> listTT();
    int checkCXCN(List<Bill> b);
    boolean getTTFalse(List<Bill> b);
    boolean updateTTFalse(List<ChuyennxeChongoi> cx);
    List<Integer> listChoNgoiTrong(List<Chuyenxe> cx);




}
