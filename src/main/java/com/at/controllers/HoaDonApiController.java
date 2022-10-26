/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Bill;
import com.at.pojo.ChuyennxeChongoi;
import com.at.pojo.Hoadon;
import com.at.pojo.User;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.service.ChuyenXeChoNgoiService;
import com.at.service.HoaDonService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu
 */
@RestController
@RequestMapping("api/hoadon")
public class HoaDonApiController {
    
    @Autowired
    ChuyenXeChoNgoiService chuyenXeChoNgoiService;
    
        @Autowired
    HoaDonService hoaDonService;
    @PostMapping("/chuyenTT")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void chuyenTT(HttpSession session)
    {
        Map<Integer, Bill> b = (Map<Integer, Bill>) session.getAttribute("bill");
        List<Bill> listB = b.values().stream().collect(Collectors.toList());
        List<ChuyennxeChongoi> listcxcn = new ArrayList<>();
        for(Bill bi: listB)
        {
            listcxcn.add(bi.getCxcn());
        }  
        this.chuyenXeChoNgoiService.updateTTFalse(listcxcn);
        session.setAttribute("bill", null);

    }
    
//    @PostMapping("/thanhtoan")
//    public ResponseEntity<Integer> addHoaDon(@ModelAttribute(value = "HoaDon") Hoadon h,  HttpSession session) {
//        int result ;
//        Map<Integer, Bill> b = (Map<Integer, Bill>) session.getAttribute("bill");
//        List<Bill> listB = b.values().stream().collect(Collectors.toList());
//       
//        User u = (User) session.getAttribute("currentUser");
//        int k =1;
//        if(u.getNhanvien() != null)
//            k =0;
//        
//        if (this.hoaDonService.addHoaDon(h,u ,listB,k )) {
//
//            session.setAttribute("bill", null);
//            result = 1;
//        }
//        else
//        {
//            if(this.chuyenXeChoNgoiService.getTTFalse(listB))
//                 result = -1;
//            result = -2;
//        }
//         return new ResponseEntity<>(result,HttpStatus.OK);
//    }
    
}
