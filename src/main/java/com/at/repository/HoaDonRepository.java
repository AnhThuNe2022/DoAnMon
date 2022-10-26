/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Bill;
import com.at.pojo.Hoadon;
import java.util.List;

/**
 *
 * @author thu
 */
public interface HoaDonRepository {

    List<Hoadon> listHDByCX(int maCX);
//    boolean deleteHDToCX(int maCX);

    boolean deleteHD(int maHD);

    int addHoaDon(Hoadon hd, List<Bill> b);

    List<Hoadon> listHDByUser(String u);

    boolean setTTHoaDonTrue(int maHD);

    Hoadon getHoaDonById(int maHD);

    boolean updateHD(Hoadon hd);

}
