/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Chitiethoadon;
import com.at.pojo.Hoadon;
import java.util.List;

/**
 *
 * @author thu
 */
public interface HoaDonChiTietService {
//    List<Hoadon> listHD(int maCX);
    Chitiethoadon findCT(int id);


}
