/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Chinhsachhuyve;
import com.at.pojo.Chitiethoadon;
import com.at.pojo.Hoadon;
import com.at.pojo.Huyve;
import com.at.repository.ChinhSachHuyVeRepository;
import com.at.repository.HoaDonRepository;
import com.at.repository.HuyVeRepository;
import com.at.service.HuyVeService;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class HuyVeServiceImpl implements HuyVeService {

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    ChinhSachHuyVeRepository chinhSachHuyVeRepository;

    @Autowired
    HuyVeRepository huyVeRepository; 
    @Override
    public boolean huyVe(int idHoaDon) {
        Hoadon h = hoaDonRepository.getHoaDonById(idHoaDon);
        List<Huyve> listhv = new ArrayList<>();
        Date dateCX = h.getMaChuyenXe().getGioXuatPhat();
        BigDecimal TTHoan = BigDecimal.valueOf(0.0);;
        for (Chitiethoadon ct : h.getChitiethoadonSet()) {
            Huyve hv = new Huyve();
            hv.setIdhuyve(ct.getMaCT());
            hv.setChitiethoadon(ct);
            Date currentDay = new Date();
            hv.setNgayHuyVe(currentDay);
            int diff = (int) ((dateCX.getTime() - currentDay.getTime()) / (1000 * 60 * 60 * 24));
            int macxhv;
            
            if(h.getTrangThaiTT())
            {
                if (diff >= 7) {
                macxhv = 1;
                } else if (diff >= 1 && diff <= 6) {
                    macxhv = 2;

                } else {
                    macxhv = 3;
                }
            }
            else
                macxhv = 4;

            Chinhsachhuyve cxhv = chinhSachHuyVeRepository.getCXHV(macxhv);
            
            double phanTram = cxhv.getSoPhanTramHoanTien()*1.0/100;
            BigDecimal tienHoan = ct.getGia().multiply(new BigDecimal(phanTram));
            TTHoan = TTHoan.add(tienHoan);
            hv.setSoTienHoan(tienHoan);
            hv.setMaChinhSachHuyVe(cxhv);
            listhv.add(hv);
        }
        
//        h.setTongTien(h.getTongTien().subtract(TTHoan));

        if(!hoaDonRepository.updateHD(h))
                {
                    return false;
                }  
        if(huyVeRepository.huyVe(listhv,h))
            return true;
        return false;

    }

}
