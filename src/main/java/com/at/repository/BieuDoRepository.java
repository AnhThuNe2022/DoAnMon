/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import java.util.List;
import java.util.Map;

/**
 *
 * @author thu
 */
public interface BieuDoRepository {
    List<Object[]> matDoChuyenXe();
    List<Object[]> doanhThu(int tk, int year);
}
