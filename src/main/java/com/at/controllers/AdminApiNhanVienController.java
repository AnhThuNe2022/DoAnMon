/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Nhanvien;
import com.at.pojo.User;
import com.at.pojo.Xe;
import com.at.service.NhanVienService;
import com.at.service.UserService;
import com.at.service.XeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu
 */
@RestController
@RequestMapping("/api/admin/nhanvien")
public class AdminApiNhanVienController {
    
    @Autowired
    private NhanVienService nhanvienService;
    
     @Autowired
    XeService xeService ;
      @Autowired
    UserService userService;
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNV(@PathVariable(value = "id") int id)
    {
        this.nhanvienService.deleteNV(id);
    }
    
//    @PutMapping("/update/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateNV(@PathVariable(value = "id") int id)
//    {
//        
//    }
    
    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Nhanvien> getNV(@PathVariable(value ="id") int id)
    {
        return new ResponseEntity<>(nhanvienService.getNV(id),HttpStatus.OK);    
    }
    
    @PostMapping(value = "/getuser/{role}/{id}")
    public ResponseEntity<List<User>> getUserNV(@PathVariable(value ="role") String role,
            @PathVariable(value ="id") int id)
    {
        return new ResponseEntity<>(userService.checkUser(role, id),HttpStatus.OK);    
    }
    
  
    
   
 
    
    
}
