/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Bill;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Hoadon;
import com.at.pojo.User;
import com.at.service.ChuyenXeChoNgoiService;
import com.at.service.HoaDonChiTietService;
import com.at.service.HoaDonService;
import com.at.service.UserService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author thu
 */
@Controller
public class HoaDonController {

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    ChuyenXeChoNgoiService chuyenXeChoNgoiService;
    
    @Autowired
    UserService userService; 

    @RequestMapping("/thanhtoan")
    public String hoaDon(Model model, HttpSession session) {
        Map<Integer, Bill> b = (Map<Integer, Bill>) session.getAttribute("bill");
       User u = (User) session.getAttribute("currentUser");

        String g = "";
            Double tt = 0.0;
            for (Bill bi : b.values()) {
                g += bi.getCxcn().getMaGhe() + " ";
                tt += bi.getDonGia();
            }
            model.addAttribute("Ghe", g);
            model.addAttribute("TongCho", b.size());
            model.addAttribute("TongTien", tt);
            model.addAttribute("HoaDon", new Hoadon());
            if(u.getKhachhang() != null)
               model.addAttribute("u", userService.getCurrentUser());
   
            return "thanhToan"; 

    }

    @PostMapping("/thanhtoan")
    public String addHoaDon(@ModelAttribute(value = "HoaDon") Hoadon h, Model model, HttpSession session) {
    
        
        Map<Integer, Bill> b = (Map<Integer, Bill>) session.getAttribute("bill");
        
        List<Bill> listB = b.values().stream().collect(Collectors.toList());
        User u = (User) session.getAttribute("currentUser");
        int k =1;
        if(u.getNhanvien() != null)
            k =0;
        
        if (this.hoaDonService.addHoaDon(h,u ,listB,k )) {

            session.setAttribute("bill", null);
             model.addAttribute("resultTT",1);

            return "redirect:/";
            
        }
        else
        {
            if(this.chuyenXeChoNgoiService.getTTFalse(listB))
                 return "index";
        }
         return "index";
        
    }
    
     @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
