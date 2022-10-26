/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service.impl;

import com.at.pojo.Chuyenxe;
import com.at.pojo.Comment;
import com.at.pojo.User;
import com.at.repository.ChuyenXeRepository;
import com.at.repository.CommentRepository;
import com.at.repository.UserRepository;
import com.at.service.CommentService;
import com.at.service.UserService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author thu
 */
@Service
public class CommentServiceImpl implements CommentService{
     @Autowired
    CommentRepository commentRepository;
     
     @Autowired
     ChuyenXeRepository chuyenXeRepository; 
     
     @Autowired
     UserRepository userRepository; 
     
     @Autowired
     UserService userService;
    
     
     @Override
    public List<Comment> getListCmtToCX(int cx) {
        return this.commentRepository.getListCmtToCX(cx);
    }

    @Override
    public Comment addComment(String content, User u,int chuyenXe) {
        Comment c = new Comment();
        Chuyenxe cx = this.chuyenXeRepository.getChuyenXe(chuyenXe);   
//        c.setIdComment(82);
        c.setMaChuyenXe(cx);
        c.setContent(content);
        c.setMaUser(u);
        c.setCreateDate(new Date());
       return this.commentRepository.addComment(c);
                  
    }
    
    
    
    
}
