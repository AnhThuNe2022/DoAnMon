/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Taixe;
import com.at.pojo.Tuyenxe;
import com.at.pojo.User;
import com.at.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu
 */
@Controller
public class AdminUserController {
    
    @Autowired
    UserService userService;
    
    
     @RequestMapping("/admin/user")
    public String showListU( Model model,@RequestParam(value="kw", defaultValue = "" ) String kw,
            @RequestParam(value = "page" , required = false,defaultValue = "1" ) int page) {
        int activePage = page;
       
        List<User> ListU = userService.Listu(kw);
        model.addAttribute("keyw",kw);
       model.addAttribute("onePage",7);
       model.addAttribute("ListUser",userService.getListUPage(ListU, page));
       model.addAttribute("countPage",ListU.size());
       
       model.addAttribute("User", new User());

        return "adminUser";
    }
    
    @PostMapping("/admin/user/add")
    public String addU(@ModelAttribute(value = "User") User u) {

        if (userService.addU(u)) {
            return "redirect:/admin/user";
        }
        
        return "index";
    }
    @PostMapping("/admin/user/update")
    public String updateU(@ModelAttribute(value = "User") User u ) {
        
        if (this.userService.updateUser(u)) {
            return "redirect:/admin/user";
        }
        return "index";
    }
    
    
}
