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
@Table(name = "loainv")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loainv.findAll", query = "SELECT l FROM Loainv l"),
    @NamedQuery(name = "Loainv.findByMaLoaiNV", query = "SELECT l FROM Loainv l WHERE l.maLoaiNV = :maLoaiNV"),
    @NamedQuery(name = "Loainv.findByTenLoaiNV", query = "SELECT l FROM Loainv l WHERE l.tenLoaiNV = :tenLoaiNV")})
public class Loainv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaLoaiNV")
    private Integer maLoaiNV;
    @Size(max = 45)
    @Column(name = "TenLoaiNV")
    private String tenLoaiNV;

    public Loainv() {
    }

    public Loainv(Integer maLoaiNV) {
        this.maLoaiNV = maLoaiNV;
    }

    public Integer getMaLoaiNV() {
        return maLoaiNV;
    }

    public void setMaLoaiNV(Integer maLoaiNV) {
        this.maLoaiNV = maLoaiNV;
    }

    public String getTenLoaiNV() {
        return tenLoaiNV;
    }

    public void setTenLoaiNV(String tenLoaiNV) {
        this.tenLoaiNV = tenLoaiNV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiNV != null ? maLoaiNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loainv)) {
            return false;
        }
        Loainv other = (Loainv) object;
        if ((this.maLoaiNV == null && other.maLoaiNV != null) || (this.maLoaiNV != null && !this.maLoaiNV.equals(other.maLoaiNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Loainv[ maLoaiNV=" + maLoaiNV + " ]";
    }
    
}
