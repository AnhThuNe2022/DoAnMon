/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Taixe;
import com.at.service.TaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu
 */
@RestController
@RequestMapping("/api/admin/taixe")
public class AdminApiTaiXeController {

@Autowired
TaiXeService taiXeService;
    
     @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Taixe> getTX(@PathVariable(value ="id") int id)
    {
        return new ResponseEntity<>(taiXeService.getTaiXe(id),HttpStatus.OK);    
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTX(@PathVariable(value = "id") int id)
    {
        this.taiXeService.deleTX(id);
    }
    
}
