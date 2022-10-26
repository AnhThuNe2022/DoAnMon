/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "huyve")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Huyve.findAll", query = "SELECT h FROM Huyve h"),
    @NamedQuery(name = "Huyve.findByIdhuyve", query = "SELECT h FROM Huyve h WHERE h.idhuyve = :idhuyve"),
    @NamedQuery(name = "Huyve.findByMaChinhSachHuyVe", query = "SELECT h FROM Huyve h WHERE h.maChinhSachHuyVe = :maChinhSachHuyVe"),
    @NamedQuery(name = "Huyve.findBySoTienHoan", query = "SELECT h FROM Huyve h WHERE h.soTienHoan = :soTienHoan"),
    @NamedQuery(name = "Huyve.findByNgayHuyVe", query = "SELECT h FROM Huyve h WHERE h.ngayHuyVe = :ngayHuyVe")})
public class Huyve implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhuyve")
    private Integer idhuyve;
    @JoinColumn(name = "MaChinhSachHuyVe", referencedColumnName = "MaCXHuyVe")
    @ManyToOne
    private Chinhsachhuyve maChinhSachHuyVe;
    @Column(name = "SoTienHoan")
    private BigDecimal soTienHoan;
    @Column(name = "NgayHuyVe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayHuyVe;
    @JoinColumn(name = "idhuyve", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Chitiethoadon chitiethoadon;

    public Huyve() {
    }

    public Huyve(Integer idhuyve) {
        this.idhuyve = idhuyve;
    }

    public Integer getIdhuyve() {
        return idhuyve;
    }

    public void setIdhuyve(Integer idhuyve) {
        this.idhuyve = idhuyve;
    }

   
    public BigDecimal getSoTienHoan() {
        return soTienHoan;
    }

    public void setSoTienHoan(BigDecimal soTienHoan) {
        this.soTienHoan = soTienHoan;
    }

    public Date getNgayHuyVe() {
        return ngayHuyVe;
    }

    public void setNgayHuyVe(Date ngayHuyVe) {
        this.ngayHuyVe = ngayHuyVe;
    }

    public Chitiethoadon getChitiethoadon() {
        return chitiethoadon;
    }

    public void setChitiethoadon(Chitiethoadon chitiethoadon) {
        this.chitiethoadon = chitiethoadon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhuyve != null ? idhuyve.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Huyve)) {
            return false;
        }
        Huyve other = (Huyve) object;
        if ((this.idhuyve == null && other.idhuyve != null) || (this.idhuyve != null && !this.idhuyve.equals(other.idhuyve))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Huyve[ idhuyve=" + idhuyve + " ]";
    }

    /**
     * @return the maChinhSachHuyVe
     */
    public Chinhsachhuyve getMaChinhSachHuyVe() {
        return maChinhSachHuyVe;
    }

    /**
     * @param maChinhSachHuyVe the maChinhSachHuyVe to set
     */
    public void setMaChinhSachHuyVe(Chinhsachhuyve maChinhSachHuyVe) {
        this.maChinhSachHuyVe = maChinhSachHuyVe;
    }
    
}
