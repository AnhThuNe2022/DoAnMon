/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "taixe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Taixe.findAll", query = "SELECT t FROM Taixe t"),
    @NamedQuery(name = "Taixe.findByMaTaiXe", query = "SELECT t FROM Taixe t WHERE t.maTaiXe = :maTaiXe"),
    @NamedQuery(name = "Taixe.findByTenTaiXe", query = "SELECT t FROM Taixe t WHERE t.tenTaiXe = :tenTaiXe"),
    @NamedQuery(name = "Taixe.findByNgaySinh", query = "SELECT t FROM Taixe t WHERE t.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Taixe.findByDiaChi", query = "SELECT t FROM Taixe t WHERE t.diaChi = :diaChi"),
    @NamedQuery(name = "Taixe.findByCmnd", query = "SELECT t FROM Taixe t WHERE t.cmnd = :cmnd"),
    @NamedQuery(name = "Taixe.findByMaBangLaiXe", query = "SELECT t FROM Taixe t WHERE t.maBangLaiXe = :maBangLaiXe")})
public class Taixe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaTaiXe")
    private Integer maTaiXe;
    @Size(max = 100)
    @Column(name = "TenTaiXe")
    private String tenTaiXe;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngaySinh;
    @Column(name = "GioiTinh")
    private Character gioiTinh;
    
    @Column(name = "LoaiTX")
    private Character loaitx;

    @Size(max = 200)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 20)
    @Column(name = "CMND")
    private String cmnd;
    @Size(max = 100)
    @Column(name = "MaBangLaiXe")
    private String maBangLaiXe;
    @OneToMany(mappedBy = "maTaiXeChinh")
    @JsonIgnore
    private Set<Chuyenxe> chuyenxeSet;
    @OneToMany(mappedBy = "maTaiXePhu")
    @JsonIgnore
    private Set<Chuyenxe> chuyenxeSet1;
    @JoinColumn(name = "MaUser", referencedColumnName = "MaUser")
    @OneToOne
    private User maUser;
    
    @Transient
    @JsonIgnore
    private String maU;

    public Taixe() {
    }

    public Taixe(Integer maTaiXe) {
        this.maTaiXe = maTaiXe;
    }

    public Integer getMaTaiXe() {
        return maTaiXe;
    }

    public void setMaTaiXe(Integer maTaiXe) {
        this.maTaiXe = maTaiXe;
    }

    public String getTenTaiXe() {
        return tenTaiXe;
    }

    public void setTenTaiXe(String tenTaiXe) {
        this.tenTaiXe = tenTaiXe;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getMaBangLaiXe() {
        return maBangLaiXe;
    }

    public void setMaBangLaiXe(String maBangLaiXe) {
        this.maBangLaiXe = maBangLaiXe;
    }

    @XmlTransient
    public Set<Chuyenxe> getChuyenxeSet() {
        return chuyenxeSet;
    }

    public void setChuyenxeSet(Set<Chuyenxe> chuyenxeSet) {
        this.chuyenxeSet = chuyenxeSet;
    }

    @XmlTransient
    public Set<Chuyenxe> getChuyenxeSet1() {
        return chuyenxeSet1;
    }

    public void setChuyenxeSet1(Set<Chuyenxe> chuyenxeSet1) {
        this.chuyenxeSet1 = chuyenxeSet1;
    }

    public User getMaUser() {
        return maUser;
    }

    public void setMaUser(User maUser) {
        this.maUser = maUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTaiXe != null ? maTaiXe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taixe)) {
            return false;
        }
        Taixe other = (Taixe) object;
        if ((this.maTaiXe == null && other.maTaiXe != null) || (this.maTaiXe != null && !this.maTaiXe.equals(other.maTaiXe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Taixe[ maTaiXe=" + maTaiXe + " ]";
    }

    /**
     * @return the gioiTinh
     */
    public Character getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(Character gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the maU
     */
    public String getMaU() {
        return maU;
    }

    /**
     * @param maU the maU to set
     */
    public void setMaU(String maU) {
        this.maU = maU;
    }

    /**
     * @return the loaitx
     */
    public Character getLoaitx() {
        return loaitx;
    }

    /**
     * @param loaitx the loaitx to set
     */
    public void setLoaitx(Character loaitx) {
        this.loaitx = loaitx;
    }
    
}
