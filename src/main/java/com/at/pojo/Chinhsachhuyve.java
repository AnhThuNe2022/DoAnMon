/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "chinhsachhuyve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chinhsachhuyve.findAll", query = "SELECT c FROM Chinhsachhuyve c"),
    @NamedQuery(name = "Chinhsachhuyve.findByMaCXHuyVe", query = "SELECT c FROM Chinhsachhuyve c WHERE c.maCXHuyVe = :maCXHuyVe"),
    @NamedQuery(name = "Chinhsachhuyve.findByTenCXHuyVe", query = "SELECT c FROM Chinhsachhuyve c WHERE c.tenCXHuyVe = :tenCXHuyVe"),
    @NamedQuery(name = "Chinhsachhuyve.findBySoPhanTramHoanTien", query = "SELECT c FROM Chinhsachhuyve c WHERE c.soPhanTramHoanTien = :soPhanTramHoanTien"),
    @NamedQuery(name = "Chinhsachhuyve.findByMoTa", query = "SELECT c FROM Chinhsachhuyve c WHERE c.moTa = :moTa")})
public class Chinhsachhuyve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCXHuyVe")
    private Integer maCXHuyVe;
    @Size(max = 45)
    @Column(name = "TenCXHuyVe")
    private String tenCXHuyVe;
    @Column(name = "SoPhanTramHoanTien")
    private Integer soPhanTramHoanTien;
    @Size(max = 200)
    @Column(name = "MoTa")
    private String moTa;

    public Chinhsachhuyve() {
    }

    public Chinhsachhuyve(Integer maCXHuyVe) {
        this.maCXHuyVe = maCXHuyVe;
    }

    public Integer getMaCXHuyVe() {
        return maCXHuyVe;
    }

    public void setMaCXHuyVe(Integer maCXHuyVe) {
        this.maCXHuyVe = maCXHuyVe;
    }

    public String getTenCXHuyVe() {
        return tenCXHuyVe;
    }

    public void setTenCXHuyVe(String tenCXHuyVe) {
        this.tenCXHuyVe = tenCXHuyVe;
    }

    public Integer getSoPhanTramHoanTien() {
        return soPhanTramHoanTien;
    }

    public void setSoPhanTramHoanTien(Integer soPhanTramHoanTien) {
        this.soPhanTramHoanTien = soPhanTramHoanTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maCXHuyVe != null ? maCXHuyVe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chinhsachhuyve)) {
            return false;
        }
        Chinhsachhuyve other = (Chinhsachhuyve) object;
        if ((this.maCXHuyVe == null && other.maCXHuyVe != null) || (this.maCXHuyVe != null && !this.maCXHuyVe.equals(other.maCXHuyVe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Chinhsachhuyve[ maCXHuyVe=" + maCXHuyVe + " ]";
    }
    
}
