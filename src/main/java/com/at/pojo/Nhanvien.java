/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "nhanvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nhanvien.findAll", query = "SELECT n FROM Nhanvien n"),
    @NamedQuery(name = "Nhanvien.findByMaNV", query = "SELECT n FROM Nhanvien n WHERE n.maNV = :maNV"),
    @NamedQuery(name = "Nhanvien.findByTenNV", query = "SELECT n FROM Nhanvien n WHERE n.tenNV = :tenNV"),
    @NamedQuery(name = "Nhanvien.findByNgaySinh", query = "SELECT n FROM Nhanvien n WHERE n.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "Nhanvien.findByGioiTinh", query = "SELECT n FROM Nhanvien n WHERE n.gioiTinh = :gioiTinh"),
    @NamedQuery(name = "Nhanvien.findByDiaChi", query = "SELECT n FROM Nhanvien n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "Nhanvien.findByCmnd", query = "SELECT n FROM Nhanvien n WHERE n.cmnd = :cmnd")})
public class Nhanvien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaNV")
    private Integer maNV;
    @Size(max = 100)
    @Column(name = "TenNV")
    private String tenNV;
    @Column(name = "NgaySinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "GioiTinh")
    private Character gioiTinh;
    @Size(max = 200)
    @Column(name = "DiaChi")
    private String diaChi;
    @Size(max = 45)
    @Column(name = "CMND")
    private String cmnd;
    @Lob
    @Size(max = 65535)
    @Column(name = "ChungChi")
    private String chungChi;
    @JoinColumn(name = "LoaiNV", referencedColumnName = "MaLoaiNV")
    @ManyToOne
    private Loainv loaiNV;
    @JoinColumn(name = "MaUser", referencedColumnName = "MaUser")
    @OneToOne
    private User maUser;
    
    @Transient
    @JsonIgnore
    private int loaiNhanVien;
    
    
    @Transient
    @JsonIgnore
    private String maU;

    public Nhanvien() {
    }

    public Nhanvien(Integer maNV) {
        this.maNV = maNV;
    }

    public Integer getMaNV() {
        return maNV;
    }

    public void setMaNV(Integer maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public Character getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Character gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public String getChungChi() {
        return chungChi;
    }

    public void setChungChi(String chungChi) {
        this.chungChi = chungChi;
    }

    public Loainv getLoaiNV() {
        return loaiNV;
    }

    public void setLoaiNV(Loainv loaiNV) {
        this.loaiNV = loaiNV;
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
        hash += (maNV != null ? maNV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nhanvien)) {
            return false;
        }
        Nhanvien other = (Nhanvien) object;
        if ((this.maNV == null && other.maNV != null) || (this.maNV != null && !this.maNV.equals(other.maNV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Nhanvien[ maNV=" + maNV + " ]";
    }

    /**
     * @return the loaiNhanVien
     */
    public int getLoaiNhanVien() {
        return loaiNhanVien;
    }

    /**
     * @param loaiNhanVien the loaiNhanVien to set
     */
    public void setLoaiNhanVien(int loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
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
    
}
