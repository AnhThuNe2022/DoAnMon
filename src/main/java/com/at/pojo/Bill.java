/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author thu
 */
public class Bill {
    private ChuyennxeChongoi cxcn;
    private double DonGia ;
    private boolean isFull = false;

    /**
     * @return the cxcn
     */
    public ChuyennxeChongoi getCxcn() {
        return cxcn;
    }

    /**
     * @param cxcn the cxcn to set
     */
    public void setCxcn(ChuyennxeChongoi cxcn) {
        this.cxcn = cxcn;
    }

    /**
     * @return the DonGia
     */
    public double getDonGia() {
        return DonGia;
    }

    /**
     * @param DonGia the DonGia to set
     */
    public void setDonGia(double DonGia) {
        this.DonGia = DonGia;
    }

    /**
     * @return the isFull
     */
    public boolean isIsFull() {
        return isFull;
    }

    /**
     * @param isFull the isFull to set
     */
    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

  
}
