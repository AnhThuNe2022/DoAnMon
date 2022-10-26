/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "loaixe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Loaixe.findAll", query = "SELECT l FROM Loaixe l"),
    @NamedQuery(name = "Loaixe.findByMaLoaiXe", query = "SELECT l FROM Loaixe l WHERE l.maLoaiXe = :maLoaiXe"),
    @NamedQuery(name = "Loaixe.findByTenLoaiXe", query = "SELECT l FROM Loaixe l WHERE l.tenLoaiXe = :tenLoaiXe"),
    @NamedQuery(name = "Loaixe.findBySoGhe", query = "SELECT l FROM Loaixe l WHERE l.soGhe = :soGhe"),
    @NamedQuery(name = "Loaixe.findByKhongGian", query = "SELECT l FROM Loaixe l WHERE l.khongGian = :khongGian")})
public class Loaixe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MaLoaiXe")
    private String maLoaiXe;
    @Size(max = 100)
    @Column(name = "TenLoaiXe")
    private String tenLoaiXe;
    @Column(name = "SoGhe")
    private Integer soGhe;
    @Size(max = 45)
    @Column(name = "KhongGian")
    private String khongGian;
//    @OneToMany(mappedBy = "maLoaiXe")
//    private Set<Xe> xeSet;

    public Loaixe() {
    }

    public Loaixe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public String getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(String maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    public String getTenLoaiXe() {
        return tenLoaiXe;
    }

    public void setTenLoaiXe(String tenLoaiXe) {
        this.tenLoaiXe = tenLoaiXe;
    }

    public Integer getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(Integer soGhe) {
        this.soGhe = soGhe;
    }

    public String getKhongGian() {
        return khongGian;
    }

    public void setKhongGian(String khongGian) {
        this.khongGian = khongGian;
    }
//
//    @XmlTransient
//    public Set<Xe> getXeSet() {
//        return xeSet;
//    }
//
//    public void setXeSet(Set<Xe> xeSet) {
//        this.xeSet = xeSet;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiXe != null ? maLoaiXe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Loaixe)) {
            return false;
        }
        Loaixe other = (Loaixe) object;
        if ((this.maLoaiXe == null && other.maLoaiXe != null) || (this.maLoaiXe != null && !this.maLoaiXe.equals(other.maLoaiXe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Loaixe[ maLoaiXe=" + maLoaiXe + " ]";
    }

  
    
}
