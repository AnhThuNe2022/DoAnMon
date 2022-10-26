/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.User;
import com.at.repository.ChuyenXeRepository;
import com.at.repository.HoaDonRepository;
import com.at.service.ChuyenXeService;
import com.at.service.HoaDonService;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu
 */
@Controller
@RequestMapping("/taixe")
public class TaiXeController {
    
    @Autowired
    ChuyenXeService chuyenXeService; 
    
    @Autowired
    HoaDonService hoaDonService;
    
   @GetMapping("/")
    public String ListCXTX(HttpSession session,Model model)
    {
     
        User u = (User) session.getAttribute("currentUser");
        model.addAttribute("listCX",chuyenXeService.getCXByTaiXe(u));
        model.addAttribute("user",u);

        return "taixe";
    }
    
    @GetMapping("/chuyenxe/{id}")
    public String ListCXTX(@PathVariable(value="id")int id,Model model)
    {
        
        model.addAttribute("listHD",this.hoaDonService.listHDByCX(id));
        model.addAttribute("idCX",id);
         return "taiXeChiTiet";
    }
    
    @PostMapping("/chuyenxe/{id}")
    public String ListCXTX(@PathVariable(value="id")int id,@RequestParam(value="maHD") int maHD)
    {
        
            if(hoaDonService.setTTHoaDonTrue(maHD)) 
               return "redirect:/taixe/chuyenxe/"+id;
            return "index";  
    }
    
    
}
