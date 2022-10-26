/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Chuyenxe;
import com.at.pojo.Nhanvien;
import com.at.pojo.Taixe;
import com.at.pojo.Tuyenxe;
import com.at.service.ChuyenXeService;
import com.at.service.LoaiNVService;
import com.at.service.NhanVienService;
import com.at.service.TaiXeService;
import com.at.service.TuyenXeService;
import com.at.service.UserService;
import com.at.service.XeService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu
 */
@Controller
@PropertySource("classpath:page.properties")

public class AdminNhanVienController {

    @Autowired
    NhanVienService nhanVienService;
    
    @Autowired
    LoaiNVService loaiNVService;
    
    @Autowired
    UserService userService; 
    
    @Autowired
    Environment env;
    
   

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
        
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateF, false));
    }

    @RequestMapping("/admin/nhanvien")
    public String showListNV( Model model,@RequestParam(value="kw", defaultValue = "" ) String kw,
            @RequestParam(value = "page" , required = false,defaultValue = "1" ) int page)    {
        int activePage = page;
       
        Map<Integer,List<Object>> map =nhanVienService.getListNV(kw,page);
        List<Object> ListNV =  map.get(0);
        
       model.addAttribute("keyw",kw);
       model.addAttribute("onePage",env.getProperty("page.count"));
       model.addAttribute("nv",ListNV);
       model.addAttribute("countPage",map.get(1).size());
       model.addAttribute("Nhanvien", new Nhanvien());
       model.addAttribute("loaiNV", loaiNVService.getListLoaiNV() );
       model.addAttribute("MaU",userService.getUserNull(1));
        return "adminNhanVien";
    }

    @PostMapping("/admin/nhanvien/add")
    public String addNV(@ModelAttribute(value = "Nhanvien") Nhanvien nv) {

        if (nhanVienService.addNV(nv)) {
            return "redirect:/admin/nhanvien";
        }
        return "index";
    }

    @PostMapping("/admin/nhanvien/update")
    public String updateNV(@ModelAttribute(value = "Nhanvien") Nhanvien nv) {

        if (nhanVienService.updateNV(nv)) {
            return "redirect:/admin/nhanvien";
        }
        return "index";
    }

    
//    ------------------TuyenXe-------------------------
    
    
//    ----------------------- chuyến Xe-------------------
    
   
}
