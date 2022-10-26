/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Tuyenxe;
import com.at.service.BieuDoService;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author thu
 */
@Controller
@RequestMapping("/admin/thongke")
public class AdminThongKeController {

    @Autowired
    BieuDoService bieuDoService;

    @GetMapping("/doanhthu")
    public String thongKeDoanhThu(Model model, @RequestParam(value = "tk", required = false, defaultValue = "0") int tk,
            @RequestParam(value = "year",required = false, defaultValue = "0" ) int y) {

        if(y == 0)
            y = new Date().getYear() + 1900;
        
        model.addAttribute("doanhThu", this.bieuDoService.thongKeDoanhThu(tk,y));
        if (tk != 2) {
            model.addAttribute("year", this.bieuDoService.thongKeDoanhThu(2,y).keySet());
        }
        model.addAttribute("type", tk);
        model.addAttribute("nam", y);

        return "adminThongKeDoanhThu";
    }

    @GetMapping("/matdo")
    public String thongKeMatDo(Model model) {

        model.addAttribute("matDo", this.bieuDoService.matDoChuyenXe());
        return "adminThongKeMatDo";
    }

}
