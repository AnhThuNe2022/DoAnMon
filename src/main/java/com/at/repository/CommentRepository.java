/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.repository;

import com.at.pojo.Comment;
import java.util.List;


/**
 *
 * @author thu
 */

public interface CommentRepository {
    
   List<Comment> getListCmtToCX(int cx);
   Comment addComment(Comment c);
   boolean deleteComment(int cmt);
}
