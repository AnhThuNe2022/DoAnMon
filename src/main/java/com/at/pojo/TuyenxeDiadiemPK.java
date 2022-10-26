/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author thu
 */
@Embeddable
public class TuyenxeDiadiemPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MaTuyenXe")
    private String maTuyenXe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MaDiaDiem")
    private String maDiaDiem;

    public TuyenxeDiadiemPK() {
    }

    public TuyenxeDiadiemPK(String maTuyenXe, String maDiaDiem) {
        this.maTuyenXe = maTuyenXe;
        this.maDiaDiem = maDiaDiem;
    }

    public String getMaTuyenXe() {
        return maTuyenXe;
    }

    public void setMaTuyenXe(String maTuyenXe) {
        this.maTuyenXe = maTuyenXe;
    }

    public String getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(String maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTuyenXe != null ? maTuyenXe.hashCode() : 0);
        hash += (maDiaDiem != null ? maDiaDiem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TuyenxeDiadiemPK)) {
            return false;
        }
        TuyenxeDiadiemPK other = (TuyenxeDiadiemPK) object;
        if ((this.maTuyenXe == null && other.maTuyenXe != null) || (this.maTuyenXe != null && !this.maTuyenXe.equals(other.maTuyenXe))) {
            return false;
        }
        if ((this.maDiaDiem == null && other.maDiaDiem != null) || (this.maDiaDiem != null && !this.maDiaDiem.equals(other.maDiaDiem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.TuyenxeDiadiemPK[ maTuyenXe=" + maTuyenXe + ", maDiaDiem=" + maDiaDiem + " ]";
    }
    
}
