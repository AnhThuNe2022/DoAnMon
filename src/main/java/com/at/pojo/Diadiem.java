/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

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
@Table(name = "diadiem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diadiem.findAll", query = "SELECT d FROM Diadiem d"),
    @NamedQuery(name = "Diadiem.findByMaDiaDiem", query = "SELECT d FROM Diadiem d WHERE d.maDiaDiem = :maDiaDiem"),
    @NamedQuery(name = "Diadiem.findByTenDiaDiem", query = "SELECT d FROM Diadiem d WHERE d.tenDiaDiem = :tenDiaDiem"),
    @NamedQuery(name = "Diadiem.findByTinh", query = "SELECT d FROM Diadiem d WHERE d.tinh = :tinh")})
public class Diadiem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "MaDiaDiem")
    private String maDiaDiem;
    @Size(max = 100)
    @Column(name = "TenDiaDiem")
    private String tenDiaDiem;
    @Size(max = 100)
    @Column(name = "Tinh")
    private String tinh;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diadiem")
    private Set<TuyenxeDiadiem> tuyenxeDiadiemSet;

    public Diadiem() {
    }

    public Diadiem(String maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    public String getMaDiaDiem() {
        return maDiaDiem;
    }

    public void setMaDiaDiem(String maDiaDiem) {
        this.maDiaDiem = maDiaDiem;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public String getTinh() {
        return tinh;
    }

    public void setTinh(String tinh) {
        this.tinh = tinh;
    }

    @XmlTransient
    public Set<TuyenxeDiadiem> getTuyenxeDiadiemSet() {
        return tuyenxeDiadiemSet;
    }

    public void setTuyenxeDiadiemSet(Set<TuyenxeDiadiem> tuyenxeDiadiemSet) {
        this.tuyenxeDiadiemSet = tuyenxeDiadiemSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDiaDiem != null ? maDiaDiem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diadiem)) {
            return false;
        }
        Diadiem other = (Diadiem) object;
        if ((this.maDiaDiem == null && other.maDiaDiem != null) || (this.maDiaDiem != null && !this.maDiaDiem.equals(other.maDiaDiem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Diadiem[ maDiaDiem=" + maDiaDiem + " ]";
    }
    
}
