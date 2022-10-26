/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.at.controllers;

import com.at.pojo.Hoadon;
import com.at.pojo.User;
import com.at.service.HoaDonService;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author NguyenThiNgocNhi
 */
@Controller
@RequestMapping("/veCuaToi")
public class VeCuaToiController {

    @Autowired
    HoaDonService hoaDonService;

    @GetMapping("/{tt}")
    public String VeCuaToi(@PathVariable(value ="tt") String t,Model model, HttpSession session) {
        User u = (User) session.getAttribute("currentUser");
        Map<Integer, List<Hoadon>> map = hoaDonService.getHoaDonByUser(u.getMaUser());
       
        
        int k = 1;
        if(t.equals("veDaDi")){
             k = 2;
           
       }
        else if(t.equals("veDaHuy"))
            k = 3;
        model.addAttribute("ListHD",map.get(k));
        model.addAttribute("t",k);
        return "veCuaToi";
    }

    
}
