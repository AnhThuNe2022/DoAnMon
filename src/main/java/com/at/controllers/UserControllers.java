/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.at.controllers;

import com.at.pojo.Khachhang;
import com.at.pojo.User;
import com.at.service.KhachHangService;
import com.at.service.UserService;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author NguyenThiNgocNhi
 */
@Controller
public class UserControllers {
//    @Autowired
//    private Cloudinary cloudinary;

    @Autowired
    private UserService userDetailsService;

    @Autowired
    private KhachHangService khachHangService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("khachhang", new Khachhang());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute(value = "user") User user, @ModelAttribute(value = "khachhang") Khachhang kh, BindingResult result, Model model) { //tat ca nhap vo se bo do user
        // kiem tra pass va confirm pass dat trong validate . tam thoi de day
        String errMsg = "";

        if (user.getPass().equals(user.getConfirmPassword())) {
            if (this.userDetailsService.addUKH(user, kh)) {
                return "redirect:/login";
            } else {
                errMsg = "Da co loi xay ra";
            }

        } else {
                    errMsg = "Mat khau khong khop";
        }

        model.addAttribute("errMsg", errMsg);

        return "register";

    }
    @GetMapping("/profile")
    public String profile(Model model, HttpSession se){
        User u = (User) se.getAttribute("currentUser");
        model.addAttribute("user", u);
        return "trangCaNhan";
    }
    
    
}
