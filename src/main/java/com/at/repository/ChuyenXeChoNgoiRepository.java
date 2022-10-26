/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.ChuyennxeChongoi;
import java.util.List;

/**
 *
 * @author thu
 */
public interface ChuyenXeChoNgoiRepository {
    boolean addCXCN(int macx);
    boolean deleteCXCN(int macx);
    List<ChuyennxeChongoi> listcxcn(int maCX);
    int countColumn(int maCX);
    ChuyennxeChongoi getCXCN(int maCXCN);
    List<ChuyennxeChongoi> listTT();
    int checkCXCN(int id);
    boolean updateTT(int id,int i);
    int ListSoChoConLai(int maCX);
    
}
