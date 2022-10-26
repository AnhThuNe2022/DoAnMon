/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Chitiethoadon;
import com.at.pojo.Hoadon;
import java.util.List;

/**
 *
 * @author thu
 */
public interface HoaDonChiTietRepository {

//    boolean deleteHDCTMaHD(int maHD);
    boolean deleteHDCT(int maCT);
    Chitiethoadon findCT(int id);
    boolean addHDCT(Chitiethoadon ct);
    boolean setTTHDCT(int maCT);
}
