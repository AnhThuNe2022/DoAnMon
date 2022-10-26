/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Taixe;
import java.util.List;
import java.util.Map;

/**
 *
 * @author thu
 */
public interface TaiXeRepository {
    Map<Integer,List<Object>> listTX(String kw, int page);
    Map<Integer, List<Taixe>> getTypeTX();
    boolean deleTX(int id);
    boolean addTX(Taixe tx);
    Taixe getTaiXe(int id);
    boolean updateTX(Taixe tx);
}
