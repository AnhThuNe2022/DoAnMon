/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.service;

import com.at.pojo.Comment;
import com.at.pojo.User;
import java.util.List;

/**
 *
 * @author thu
 */
public interface CommentService {
       List<Comment> getListCmtToCX(int cx);
   Comment addComment(String content, User u, int chuyenXe);
   
}
