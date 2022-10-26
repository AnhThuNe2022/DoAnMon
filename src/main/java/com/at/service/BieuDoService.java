/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu
 */
public interface BieuDoService {
    List<Object[]> matDoChuyenXe();
    Map<Integer,BigDecimal> thongKeDoanhThu(int tk,int y);


}
