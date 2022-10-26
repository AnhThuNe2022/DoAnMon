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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "hoadon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoadon.findAll", query = "SELECT h FROM Hoadon h"),
    @NamedQuery(name = "Hoadon.findByMaHoaDon", query = "SELECT h FROM Hoadon h WHERE h.maHoaDon = :maHoaDon"),
    @NamedQuery(name = "Hoadon.findByHinhThucTT", query = "SELECT h FROM Hoadon h WHERE h.hinhThucTT = :hinhThucTT"),
    @NamedQuery(name = "Hoadon.findByTrangThaiTT", query = "SELECT h FROM Hoadon h WHERE h.trangThaiTT = :trangThaiTT"),
    @NamedQuery(name = "Hoadon.findByNgayDatVe", query = "SELECT h FROM Hoadon h WHERE h.ngayDatVe = :ngayDatVe"),
    @NamedQuery(name = "Hoadon.findBySdt", query = "SELECT h FROM Hoadon h WHERE h.sdt = :sdt"),
    @NamedQuery(name = "Hoadon.findByGhiChu", query = "SELECT h FROM Hoadon h WHERE h.ghiChu = :ghiChu"),
    @NamedQuery(name = "Hoadon.findByHoTen", query = "SELECT h FROM Hoadon h WHERE h.hoTen = :hoTen"),
    @NamedQuery(name = "Hoadon.findByEmail", query = "SELECT h FROM Hoadon h WHERE h.email = :email"),
    @NamedQuery(name = "Hoadon.findBySoVe", query = "SELECT h FROM Hoadon h WHERE h.soVe = :soVe")})
public class Hoadon implements Serializable {

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaHoaDon")
    private Integer maHoaDon;
    @Column(name = "HinhThucTT")
    private Character hinhThucTT;
    @Column(name = "TrangThaiTT")
    private Boolean trangThaiTT;
    @Column(name = "NgayDatVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDatVe;
    @Size(max = 11)
    @Column(name = "SDT")
    private String sdt;
    @Size(max = 100)
    @Column(name = "GhiChu")
    private String ghiChu;
    @Size(max = 45)
    @Column(name = "HoTen")
    private String hoTen;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "Email")
    private String email;
    @Column(name = "SoVe")
    private Integer soVe;
    @JoinColumn(name = "MaChuyenXe", referencedColumnName = "MaChuyenXe")
    @ManyToOne
    private Chuyenxe maChuyenXe;
    @JoinColumn(name = "MaKH", referencedColumnName = "MaKH")
    @ManyToOne
    private Khachhang maKH;

    @JoinColumn(name = "MaNV", referencedColumnName = "MaNV")
    @ManyToOne
    private Nhanvien maNV;
    @OneToMany(mappedBy = "maHD", fetch = FetchType.EAGER)
    private Set<Chitiethoadon> chitiethoadonSet;

    @Transient
    @JsonIgnore
    private String trangThaiThanhToan;

    public Hoadon() {
    }

    public Hoadon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Integer getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(Integer maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Character getHinhThucTT() {
        return hinhThucTT;
    }

    public void setHinhThucTT(Character hinhThucTT) {
        this.hinhThucTT = hinhThucTT;
    }

    public Boolean getTrangThaiTT() {
        return trangThaiTT;
    }

    public void setTrangThaiTT(Boolean trangThaiTT) {
        this.trangThaiTT = trangThaiTT;
    }

    public Date getNgayDatVe() {
        return ngayDatVe;
    }

    public void setNgayDatVe(Date ngayDatVe) {
        this.ngayDatVe = ngayDatVe;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSoVe() {
        return soVe;
    }

    public void setSoVe(Integer soVe) {
        this.soVe = soVe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maHoaDon != null ? maHoaDon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hoadon)) {
            return false;
        }
        Hoadon other = (Hoadon) object;
        if ((this.maHoaDon == null && other.maHoaDon != null) || (this.maHoaDon != null && !this.maHoaDon.equals(other.maHoaDon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Hoadon[ maHoaDon=" + maHoaDon + " ]";
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
     * @return the chitiethoadonSet
     */
    public Set<Chitiethoadon> getChitiethoadonSet() {
        return chitiethoadonSet;
    }

    /**
     * @param chitiethoadonSet the chitiethoadonSet to set
     */
    public void setChitiethoadonSet(Set<Chitiethoadon> chitiethoadonSet) {
        this.chitiethoadonSet = chitiethoadonSet;
    }

    /**
     * @return the trangThaiThanhToan
     */
    public String getTrangThaiThanhToan() {
        return trangThaiThanhToan;
    }

    /**
     * @param trangThaiThanhToan the trangThaiThanhToan to set
     */
    public void setTrangThaiThanhToan(String trangThaiThanhToan) {
        this.trangThaiThanhToan = trangThaiThanhToan;
    }

    /**
     * @return the maChuyenXe
     */
    public Chuyenxe getMaChuyenXe() {
        return maChuyenXe;
    }

    /**
     * @param maChuyenXe the maChuyenXe to set
     */
    public void setMaChuyenXe(Chuyenxe maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    /**
     * @return the maKH
     */
    public Khachhang getMaKH() {
        return maKH;
    }

    /**
     * @param maKH the maKH to set
     */
    public void setMaKH(Khachhang maKH) {
        this.maKH = maKH;
    }

    /**
     * @return the maNV
     */
    public Nhanvien getMaNV() {
        return maNV;
    }

    /**
     * @param maNV the maNV to set
     */
    public void setMaNV(Nhanvien maNV) {
        this.maNV = maNV;
    }

}
