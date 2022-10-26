/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "tuyenxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tuyenxe.findAll", query = "SELECT t FROM Tuyenxe t"),
    @NamedQuery(name = "Tuyenxe.findByMaTuyenXe", query = "SELECT t FROM Tuyenxe t WHERE t.maTuyenXe = :maTuyenXe"),
    @NamedQuery(name = "Tuyenxe.findByNoiKhoiHanh", query = "SELECT t FROM Tuyenxe t WHERE t.noiKhoiHanh = :noiKhoiHanh"),
    @NamedQuery(name = "Tuyenxe.findByNoiDen", query = "SELECT t FROM Tuyenxe t WHERE t.noiDen = :noiDen"),
    @NamedQuery(name = "Tuyenxe.findBySoKm", query = "SELECT t FROM Tuyenxe t WHERE t.soKm = :soKm"),
    @NamedQuery(name = "Tuyenxe.findBySoGio", query = "SELECT t FROM Tuyenxe t WHERE t.soGio = :soGio")})
public class Tuyenxe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MaTuyenXe")
    private String maTuyenXe;
    @Size(max = 100)
    @Column(name = "NoiKhoiHanh")
    private String noiKhoiHanh;
    @Size(max = 100)
    @Column(name = "NoiDen")
    private String noiDen;
    @Size(max = 5)
    @Column(name = "SoKm")
    private String soKm;
    @Column(name = "SoGio")
    private Integer soGio;
    @OneToMany(mappedBy = "maTuyenXe")
    @JsonIgnore
    private Set<Chuyenxe> chuyenxeSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tuyenxe")
//    private Set<TuyenxeDiadiem> tuyenxeDiadiemSet;

    public Tuyenxe() {
    }

    public Tuyenxe(String maTuyenXe) {
        this.maTuyenXe = maTuyenXe;
    }

    public String getMaTuyenXe() {
        return maTuyenXe;
    }

    public void setMaTuyenXe(String maTuyenXe) {
        this.maTuyenXe = maTuyenXe;
    }

    public String getNoiKhoiHanh() {
        return noiKhoiHanh;
    }

    public void setNoiKhoiHanh(String noiKhoiHanh) {
        this.noiKhoiHanh = noiKhoiHanh;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public String getSoKm() {
        return soKm;
    }

    public void setSoKm(String soKm) {
        this.soKm = soKm;
    }

    public Integer getSoGio() {
        return soGio;
    }

    public void setSoGio(Integer soGio) {
        this.soGio = soGio;
    }

    @XmlTransient
    public Set<Chuyenxe> getChuyenxeSet() {
        return chuyenxeSet;
    }

    public void setChuyenxeSet(Set<Chuyenxe> chuyenxeSet) {
        this.chuyenxeSet = chuyenxeSet;
    }

//    @XmlTransient
//    public Set<TuyenxeDiadiem> getTuyenxeDiadiemSet() {
//        return tuyenxeDiadiemSet;
//    }
//
//    public void setTuyenxeDiadiemSet(Set<TuyenxeDiadiem> tuyenxeDiadiemSet) {
//        this.tuyenxeDiadiemSet = tuyenxeDiadiemSet;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTuyenXe != null ? maTuyenXe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tuyenxe)) {
            return false;
        }
        Tuyenxe other = (Tuyenxe) object;
        if ((this.maTuyenXe == null && other.maTuyenXe != null) || (this.maTuyenXe != null && !this.maTuyenXe.equals(other.maTuyenXe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Tuyenxe[ maTuyenXe=" + maTuyenXe + " ]";
    }
    
}
