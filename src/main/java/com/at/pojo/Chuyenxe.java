/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "chuyenxe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chuyenxe.findAll", query = "SELECT c FROM Chuyenxe c"),
    @NamedQuery(name = "Chuyenxe.findByMaChuyenXe", query = "SELECT c FROM Chuyenxe c WHERE c.maChuyenXe = :maChuyenXe"),
    @NamedQuery(name = "Chuyenxe.findByGiaVe", query = "SELECT c FROM Chuyenxe c WHERE c.giaVe = :giaVe"),
    @NamedQuery(name = "Chuyenxe.findByGioXuatPhat", query = "SELECT c FROM Chuyenxe c WHERE c.gioXuatPhat = :gioXuatPhat"),
    @NamedQuery(name = "Chuyenxe.findByGioDen", query = "SELECT c FROM Chuyenxe c WHERE c.gioDen = :gioDen"),
    @NamedQuery(name = "Chuyenxe.findByTrangThai", query = "SELECT c FROM Chuyenxe c WHERE c.trangThai = :trangThai")})
public class Chuyenxe implements Serializable {

    @Column(name = "GiaVe")
    private BigDecimal giaVe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maChuyenXe")
    @JsonIgnore
    private Set<Comment> commentSet;

    private static long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaChuyenXe")
    private Integer maChuyenXe;
    @Column(name = "GioXuatPhat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gioXuatPhat;
    @Column(name = "GioDen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gioDen;
    @Column(name = "TrangThai")
    private Character trangThai;
    @Column(name = "SoChoConDu")
    private Integer soChoConDu;
    
    @JoinColumn(name = "MaTaiXeChinh", referencedColumnName = "MaTaiXe")
    @ManyToOne
    private Taixe maTaiXeChinh;
    @JoinColumn(name = "MaTaiXePhu", referencedColumnName = "MaTaiXe")
    @ManyToOne
    private Taixe maTaiXePhu;
    @JoinColumn(name = "MaTuyenXe", referencedColumnName = "MaTuyenXe")
    @ManyToOne
    private Tuyenxe maTuyenXe;
    @JoinColumn(name = "MaXe", referencedColumnName = "MaXe")
    @ManyToOne
    private Xe maXe;
    @OneToMany(mappedBy = "maChuyenXe")
    @JsonIgnore
    private Set<Hoadon> hoadonSet;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maChuyenXe")
//    @JsonIgnore
//    private Set<ChuyennxeChongoi> chuyennxeChongoiSet;
    @Transient
    @JsonIgnore
    private String FTuyenXe;
    @Transient
    private int FMaXe;
    @Transient
    @JsonIgnore
    private int FTaiXeChinh;
    @Transient
    @JsonIgnore
    private int FTaiXePhu;
    public Chuyenxe() {
    }

    public Chuyenxe(Integer maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    public Integer getMaChuyenXe() {
        return maChuyenXe;
    }

    public void setMaChuyenXe(Integer maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }


    public Date getGioXuatPhat() {
        return gioXuatPhat;
    }

    public void setGioXuatPhat(Date gioXuatPhat) {
        this.gioXuatPhat = gioXuatPhat;
    }

    public Date getGioDen() {
        return gioDen;
    }

    public void setGioDen(Date gioDen) {
        this.gioDen = gioDen;
    }

    public Character getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Character trangThai) {
        this.trangThai = trangThai;
    }

    public Taixe getMaTaiXeChinh() {
        return maTaiXeChinh;
    }

    public void setMaTaiXeChinh(Taixe maTaiXeChinh) {
        this.maTaiXeChinh = maTaiXeChinh;
    }

    public Taixe getMaTaiXePhu() {
        return maTaiXePhu;
    }

    public void setMaTaiXePhu(Taixe maTaiXePhu) {
        this.maTaiXePhu = maTaiXePhu;
    }

    public Tuyenxe getMaTuyenXe() {
        return maTuyenXe;
    }

    public void setMaTuyenXe(Tuyenxe maTuyenXe) {
        this.maTuyenXe = maTuyenXe;
    }

    public Xe getMaXe() {
        return maXe;
    }

    public void setMaXe(Xe maXe) {
        this.maXe = maXe;
    }

    @XmlTransient
    public Set<Hoadon> getHoadonSet() {
        return hoadonSet;
    }

    public void setHoadonSet(Set<Hoadon> hoadonSet) {
        this.hoadonSet = hoadonSet;
    }

//    @XmlTransient
//    public Set<ChuyennxeChongoi> getChuyennxeChongoiSet() {
//        return chuyennxeChongoiSet;
//    }
//
//    public void setChuyennxeChongoiSet(Set<ChuyennxeChongoi> chuyennxeChongoiSet) {
//        this.chuyennxeChongoiSet = chuyennxeChongoiSet;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getMaChuyenXe() != null ? getMaChuyenXe().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chuyenxe)) {
            return false;
        }
        Chuyenxe other = (Chuyenxe) object;
        if ((this.getMaChuyenXe() == null && other.getMaChuyenXe() != null) || (this.getMaChuyenXe() != null && !this.maChuyenXe.equals(other.maChuyenXe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Chuyenxe[ maChuyenXe=" + getMaChuyenXe() + " ]";
    }

    /**
     * @return the FTuyenXe
     */
    public String getFTuyenXe() {
        return FTuyenXe;
    }

    /**
     * @param FTuyenXe the FTuyenXe to set
     */
    public void setFTuyenXe(String FTuyenXe) {
        this.FTuyenXe = FTuyenXe;
    }

    /**
     * @return the FMaXe
     */
    public int getFMaXe() {
        return FMaXe;
    }

    /**
     * @param FMaXe the FMaXe to set
     */
    public void setFMaXe(int FMaXe) {
        this.FMaXe = FMaXe;
    }

    /**
     * @return the FTaiXeChinh
     */
    public int getFTaiXeChinh() {
        return FTaiXeChinh;
    }

    /**
     * @param FTaiXeChinh the FTaiXeChinh to set
     */
    public void setFTaiXeChinh(int FTaiXeChinh) {
        this.FTaiXeChinh = FTaiXeChinh;
    }

    /**
     * @return the FTaiXePhu
     */
    public int getFTaiXePhu() {
        return FTaiXePhu;
    }

    /**
     * @param FTaiXePhu the FTaiXePhu to set
     */
    public void setFTaiXePhu(int FTaiXePhu) {
        this.FTaiXePhu = FTaiXePhu;
    }

    public BigDecimal getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(BigDecimal giaVe) {
        this.giaVe = giaVe;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
     * @return the soChoConDu
     */
    public Integer getSoChoConDu() {
        return soChoConDu;
    }

    /**
     * @param soChoConDu the soChoConDu to set
     */
    public void setSoChoConDu(Integer soChoConDu) {
        this.soChoConDu = soChoConDu;
    }
    
}
