/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "tuyenxe_diadiem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TuyenxeDiadiem.findAll", query = "SELECT t FROM TuyenxeDiadiem t"),
    @NamedQuery(name = "TuyenxeDiadiem.findByMaTuyenXe", query = "SELECT t FROM TuyenxeDiadiem t WHERE t.tuyenxeDiadiemPK.maTuyenXe = :maTuyenXe"),
    @NamedQuery(name = "TuyenxeDiadiem.findByMaDiaDiem", query = "SELECT t FROM TuyenxeDiadiem t WHERE t.tuyenxeDiadiemPK.maDiaDiem = :maDiaDiem"),
    @NamedQuery(name = "TuyenxeDiadiem.findBySoGioDen", query = "SELECT t FROM TuyenxeDiadiem t WHERE t.soGioDen = :soGioDen"),
    @NamedQuery(name = "TuyenxeDiadiem.findByLoaiDiaDiem", query = "SELECT t FROM TuyenxeDiadiem t WHERE t.loaiDiaDiem = :loaiDiaDiem")})
public class TuyenxeDiadiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TuyenxeDiadiemPK tuyenxeDiadiemPK;
    @Column(name = "SoGioDen")
    private Integer soGioDen;
    @Column(name = "LoaiDiaDiem")
    private Character loaiDiaDiem;
    @JoinColumn(name = "MaDiaDiem", referencedColumnName = "MaDiaDiem", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diadiem diadiem;
    @JoinColumn(name = "MaTuyenXe", referencedColumnName = "MaTuyenXe", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tuyenxe tuyenxe;

    public TuyenxeDiadiem() {
    }

    public TuyenxeDiadiem(TuyenxeDiadiemPK tuyenxeDiadiemPK) {
        this.tuyenxeDiadiemPK = tuyenxeDiadiemPK;
    }

    public TuyenxeDiadiem(String maTuyenXe, String maDiaDiem) {
        this.tuyenxeDiadiemPK = new TuyenxeDiadiemPK(maTuyenXe, maDiaDiem);
    }

    public TuyenxeDiadiemPK getTuyenxeDiadiemPK() {
        return tuyenxeDiadiemPK;
    }

    public void setTuyenxeDiadiemPK(TuyenxeDiadiemPK tuyenxeDiadiemPK) {
        this.tuyenxeDiadiemPK = tuyenxeDiadiemPK;
    }

    public Integer getSoGioDen() {
        return soGioDen;
    }

    public void setSoGioDen(Integer soGioDen) {
        this.soGioDen = soGioDen;
    }

    public Character getLoaiDiaDiem() {
        return loaiDiaDiem;
    }

    public void setLoaiDiaDiem(Character loaiDiaDiem) {
        this.loaiDiaDiem = loaiDiaDiem;
    }

    public Diadiem getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(Diadiem diadiem) {
        this.diadiem = diadiem;
    }

    public Tuyenxe getTuyenxe() {
        return tuyenxe;
    }

    public void setTuyenxe(Tuyenxe tuyenxe) {
        this.tuyenxe = tuyenxe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tuyenxeDiadiemPK != null ? tuyenxeDiadiemPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TuyenxeDiadiem)) {
            return false;
        }
        TuyenxeDiadiem other = (TuyenxeDiadiem) object;
        if ((this.tuyenxeDiadiemPK == null && other.tuyenxeDiadiemPK != null) || (this.tuyenxeDiadiemPK != null && !this.tuyenxeDiadiemPK.equals(other.tuyenxeDiadiemPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.TuyenxeDiadiem[ tuyenxeDiadiemPK=" + tuyenxeDiadiemPK + " ]";
    }
    
}
