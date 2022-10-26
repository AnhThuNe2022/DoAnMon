/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Bill;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Hoadon;
import com.at.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu
 */
public interface HoaDonService {
    List<Hoadon> listHDByCX(int maCX);
    boolean addHoaDon(Hoadon h, User u, List<Bill> b ,int k);
    Map<Integer,List<Hoadon>> getHoaDonByUser(String u);
    boolean setTTHoaDonTrue(int maHD);

}
