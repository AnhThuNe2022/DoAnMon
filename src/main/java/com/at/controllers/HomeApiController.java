/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Tuyenxe;
import com.at.service.TuyenXeService;
import java.util.List;
import jdk.internal.net.http.frame.Http2Frame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu
 */
@RestController    
@RequestMapping("/api/search")
public class HomeApiController {
    
    @Autowired
    TuyenXeService tuyenXeService; 
    
    @GetMapping("/{location}")
    public ResponseEntity<List<Tuyenxe>> search(
            @PathVariable(value = "location") String loca)
    {
      return new ResponseEntity<>(this.tuyenXeService.getListTX(loca),HttpStatus.OK);
    }
    
    @GetMapping(value ="/maTX/{diemKH}/{diemDen}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> search(@PathVariable(value="diemKH") String from ,
            @PathVariable(value = "diemDen") String to)
    {
      return new ResponseEntity<>(this.tuyenXeService.getMaTX(from, to),HttpStatus.OK);
    }
    
}
