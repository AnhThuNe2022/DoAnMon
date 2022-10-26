/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Comment;
import com.at.service.ChuyenXeService;
import com.at.service.CommentService;
import com.at.service.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/binhluan")
public class BinhLuanChuyenDiController {

    @Autowired
    ChuyenXeService chuyenXeServices;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @GetMapping("/{idcx}")
    public String binhLuan(@PathVariable(value = "idcx") int id, @RequestParam(value = "page" ,required = false,defaultValue = "1") int page, Model model) {
        model.addAttribute("chuyenxe", chuyenXeServices.getChuyenXe(id));
        model.addAttribute("u", userService.getU("KH1"));
        model.addAttribute("comment", new Comment());

        List<Comment> listCmt = commentService.getListCmtToCX(id);
        
        int max = 7;
        int index = (page - 1) * max;
        List<Comment> cmt = new ArrayList<>();
        for (int i = index; i < (max + index); i++) {
            if (i >= listCmt.size()) {
                break;
            }
            cmt.add(listCmt.get(i));
        }
        
        model.addAttribute("onePage", 7);
        model.addAttribute("countPage", listCmt.size());
        model.addAttribute("cmt", cmt);

        return "binhLuanChuyenDi";

    }

//    @PostMapping("/add")
//    public String binhLuan1(@ModelAttribute(value ="comment") Comment comment, Model model)
//    {
//        if(commentService.addComment(comment.getContent(), 84)!= null)
//        {
//            return "index";
//        }
//    return "index";
//    }
}
