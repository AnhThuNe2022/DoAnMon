/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.pojo.Bill;
import com.at.pojo.ChuyennxeChongoi;
import com.at.repository.ChuyenXeChoNgoiRepository;
import com.at.repository.ChuyenXeRepository;
import com.at.service.ChuyenXeChoNgoiService;
import com.at.service.ChuyenXeService;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.Map;
import org.apache.tiles.request.attribute.HasAddableKeys;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thu
 */
@RestController
@RequestMapping("/api/timve")
public class TimVeApiController {
    
    @Autowired
    ChuyenXeService chuyenXeService;
    
    @Autowired
    ChuyenXeChoNgoiService chuyenXeChoNgoiService;
    @PostMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Bill>> datCho(@PathVariable(value ="id") int id,
            @RequestParam(value = "idCXCN") int idCXCN  ,HttpSession session)
    {
        
       Map<Integer,Bill> b = (Map<Integer,Bill>) session.getAttribute("bill");

        if(b == null || b.isEmpty())
        {
            b = new HashMap<>();
        }
        else
        {
            
            int firstKey = (int) b.keySet().toArray()[0];
            Bill f = b.get(firstKey);   
            if(f.getCxcn().getMaChuyenXe().getMaChuyenXe() != id)
            {
                b = null;
                b = new HashMap<>();
            }
            
        }  
      
        if(!b.containsKey(idCXCN))
        {
            
            if(b.size() < 10)
            {
                Bill bi = new Bill();
                ChuyennxeChongoi c = chuyenXeChoNgoiService.getCXCN(idCXCN);
                bi.setCxcn(c);
                BigDecimal price = chuyenXeService.getPrice(id);
                bi.setDonGia(price.doubleValue());
                b.put(idCXCN, bi);
            }
            else {
                for(Bill bi : b.values()){
                    bi.setIsFull(true);
                }
            }
        }
        else{
            if(b.size() == 10){
                 for(Bill bi : b.values()){
                    bi.setIsFull(false);
                }
             }
             b.remove(idCXCN);
             
             
        }
        
 
        session.setAttribute("bill", b);
        return new ResponseEntity<>(b.values(),HttpStatus.OK);    
    }
    
    
   @GetMapping(value = "/bill",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Bill>> getBill(HttpSession session)
    {
       Map<Integer,Bill> b = (Map<Integer,Bill>) session.getAttribute("bill");
       if(b== null || b.isEmpty())
       {
            b = new HashMap<>();
       }
       session.setAttribute("bill",b);
       return new ResponseEntity<>(b.values(),HttpStatus.OK);   
    }


}
