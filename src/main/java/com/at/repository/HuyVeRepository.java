/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Hoadon;
import com.at.pojo.Huyve;
import java.util.List;

/**
 *
 * @author thu
 */
public interface HuyVeRepository {
    boolean huyVe(List<Huyve> maCTVe,Hoadon h);
    boolean deleteHuyVe(int maHV);
}
