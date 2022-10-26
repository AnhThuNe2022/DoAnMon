/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Bill;
import com.at.pojo.Chitiethoadon;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Hoadon;
import com.at.pojo.User;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.repository.HoaDonChiTietRepository;
import com.at.repository.HoaDonRepository;
import com.at.repository.UserRepository;
import com.at.service.HoaDonService;
import com.at.service.UserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.transaction.RollbackException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    ChuyenXeChoNgoiRepository chuyenXeChoNgoiRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Override
    public List<Hoadon> listHDByCX(int maCX) {
        return this.hoaDonRepository.listHDByCX(maCX);
    }

    @Override
    public boolean addHoaDon(Hoadon h, User u, List<Bill> b, int k) {

        Chuyenxe cx = null;
        for (Bill bi : b) {
            cx = bi.getCxcn().getMaChuyenXe();
            break;
        }
        if (k == 1) {
            h.setMaKH(u.getKhachhang());
            h.setHinhThucTT('O');
        } else if (k == 0) {
            h.setMaNV(u.getNhanvien());
            h.setHinhThucTT('T');
        }

        if (h.getTrangThaiThanhToan().equals("1")) {
            h.setTrangThaiTT(Boolean.TRUE);

        } else {
            h.setTrangThaiTT(Boolean.FALSE);
        }
        h.setMaChuyenXe(cx);

        h.setNgayDatVe(new Date());
        if (this.hoaDonRepository.addHoaDon(h, b) == 1) {
            return true;
        }
        return false;

    }

    @Override
    public Map<Integer, List<Hoadon>> getHoaDonByUser(String u) {
        Map<Integer, List<Hoadon>> map = new HashMap<>();
        List<Hoadon> hdcurrent = new ArrayList<>();
        List<Hoadon> hdpast = new ArrayList<>();
        List<Hoadon> hdHuy = new ArrayList<>();

        List<Hoadon> hd = this.hoaDonRepository.listHDByUser(u);

        Date currentDate = new Date();

        for (Hoadon h : hd) {
           List<Chitiethoadon> ct = new ArrayList<>(h.getChitiethoadonSet());
           if(ct.get(0).getTrangThai() == false)
           {
                  hdHuy.add(h);
                  continue;
           }          
            if (h.getMaChuyenXe().getGioXuatPhat().after(currentDate)) {
                hdcurrent.add(h);
            } else {
                hdpast.add(h);
            }
        }
        
      
        map.put(1, hdcurrent);
        map.put(2, hdpast);
        map.put(3, hdHuy);

        return map;

    }

    @Override
    public boolean setTTHoaDonTrue(int maHD) {
        return this.hoaDonRepository.setTTHoaDonTrue(maHD);
    }

}
