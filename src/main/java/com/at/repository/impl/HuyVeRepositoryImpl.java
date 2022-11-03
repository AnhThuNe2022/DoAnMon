/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository.impl;

import com.at.pojo.Chuyenxe;
import com.at.pojo.Hoadon;
import com.at.pojo.Huyve;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.repository.ChuyenXeRepository;
import com.at.repository.HoaDonChiTietRepository;
import com.at.repository.HoaDonRepository;
import com.at.repository.HuyVeRepository;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author thu
 */
@Repository
@Transactional
public class HuyVeRepositoryImpl implements HuyVeRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;
    @Autowired
    ChuyenXeChoNgoiRepository chuyenXeChoNgoiRepository;
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    ChuyenXeRepository chuyenXeRepository; 

    @Override
    public boolean huyVe(List<Huyve> h, Hoadon hd) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Chuyenxe cx = hd.getMaChuyenXe();
            cx.setSoChoConDu(cx.getSoChoConDu() + hd.getSoVe());
            for (Huyve hv : h) {
                if (!hoaDonChiTietRepository.setTTHDCT(hv.getIdhuyve())) {
                    return false;
                }
                if (!chuyenXeChoNgoiRepository.updateTT(hv.getChitiethoadon().getMaGhe().getIdCXMG(), 0)) {
                    return false;
                }
                if (!chuyenXeRepository.UpdateCX2(cx)) {
                    return false;
                }
                    s.save(hv);

            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteHuyVe(int maHV) {
        try {
            Session s = this.sessionFactory.getObject().getCurrentSession();
            Huyve h = s.get(Huyve.class, maHV);
            if(h != null)
                s.remove(h);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
