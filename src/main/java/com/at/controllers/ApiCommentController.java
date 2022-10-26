/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Comment;
import com.at.pojo.User;
import com.at.repository.CommentRepository;
import com.at.service.CommentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu
 */
@RestController
public class ApiCommentController {
    
    @Autowired
    CommentService commentService;
    
    
    @PostMapping(path = "/api/addComment" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Comment> addComment(@RequestBody Map<String,String> params,HttpSession session)
    {
        try{
            String content = params.get("content");
            int idcx = Integer.parseInt(params.get("idCX"));         
            Comment c = this.commentService.addComment(content, (User) session.getAttribute("currentUser"),idcx);
                
        return new ResponseEntity<>(c,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
