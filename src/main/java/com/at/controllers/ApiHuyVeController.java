/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.controllers;

import com.at.service.HuyVeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
public class ApiHuyVeController {
    
    @Autowired
    HuyVeService huyVeService;

    @PostMapping("/api/huyve/{idHD}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void huyVe(@PathVariable(value="idHD") int id) {
        try {    
               huyVeService.huyVe(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
