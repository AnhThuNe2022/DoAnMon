/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "chitiethoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chitiethoadon.findAll", query = "SELECT c FROM Chitiethoadon c"),
    @NamedQuery(name = "Chitiethoadon.findById", query = "SELECT c FROM Chitiethoadon c WHERE c.id = :id"),
    @NamedQuery(name = "Chitiethoadon.findByMaGhe", query = "SELECT c FROM Chitiethoadon c WHERE c.maGhe = :maGhe"),
    @NamedQuery(name = "Chitiethoadon.findByTrangThai", query = "SELECT c FROM Chitiethoadon c WHERE c.trangThai = :trangThai")})
public class Chitiethoadon implements Serializable {


    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaCT")
    private Integer maCT;
    @Column(name = "Gia")
    private BigDecimal gia;
    @JoinColumn(name = "MaGhe")
    @ManyToOne
    private ChuyennxeChongoi maGhe;
    @Column(name = "TrangThai")
    private Boolean trangThai = true;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "chitiethoadon")
    private Huyve huyve;
    @JoinColumn(name = "MaHD", referencedColumnName = "MaHoaDon")
    @ManyToOne
    private Hoadon maHD;

    public Chitiethoadon() {
    }

    public Chitiethoadon(Integer maCT) {
        this.maCT = maCT;
    }

 


   
    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Huyve getHuyve() {
        return huyve;
    }

    public void setHuyve(Huyve huyve) {
        this.huyve = huyve;
    }

    public Hoadon getMaHD() {
        return maHD;
    }

    public void setMaHD(Hoadon maHD) {
        this.maHD = maHD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getMaCT() != null ? getMaCT().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chitiethoadon)) {
            return false;
        }
        Chitiethoadon other = (Chitiethoadon) object;
        if ((this.getMaCT() == null && other.getMaCT() != null) || (this.getMaCT() != null && !this.maCT.equals(other.maCT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Chitiethoadon[ id=" + getMaCT() + " ]";
    }

    /**
     * @return the maGhe
     */
    public ChuyennxeChongoi getMaGhe() {
        return maGhe;
    }

    /**
     * @param maGhe the maGhe to set
     */
    public void setMaGhe(ChuyennxeChongoi maGhe) {
        this.maGhe = maGhe;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

    /**
     * @return the maCT
     */
    public Integer getMaCT() {
        return maCT;
    }

    /**
     * @param maCT the maCT to set
     */
    public void setMaCT(Integer maCT) {
        this.maCT = maCT;
    }
    
    
    /**
     * @return the gia
     */
    public BigDecimal getGia() {
        return gia;
    }

    /**
     * @param gia the gia to set
     */
    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }
    
}
