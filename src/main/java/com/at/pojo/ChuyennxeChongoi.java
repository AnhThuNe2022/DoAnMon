/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.at.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "chuyennxechongoi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChuyennxeChongoi.findAll", query = "SELECT c FROM ChuyennxeChongoi c"),
    @NamedQuery(name = "ChuyennxeChongoi.findByIdCXMG", query = "SELECT c FROM ChuyennxeChongoi c WHERE c.idCXMG = :idCXMG"),
    @NamedQuery(name = "ChuyennxeChongoi.findByMaGhe", query = "SELECT c FROM ChuyennxeChongoi c WHERE c.maGhe = :maGhe"),
    @NamedQuery(name = "ChuyennxeChongoi.findByTrangThai", query = "SELECT c FROM ChuyennxeChongoi c WHERE c.trangThai = :trangThai")})
public class ChuyennxeChongoi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCXMG")
    private Integer idCXMG;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "MaGhe")
    private String maGhe;
    @Column(name = "TrangThai")
    private Boolean trangThai = false;
    @JoinColumn(name = "MaChuyenXe")
    @NotNull
    @ManyToOne
    @JsonIgnore
    private Chuyenxe maChuyenXe;

    public ChuyennxeChongoi() {
    }

    public ChuyennxeChongoi(Integer idCXMG) {
        this.idCXMG = idCXMG;
    }

    public ChuyennxeChongoi(Integer idCXMG, String maGhe) {
        this.idCXMG = idCXMG;
        this.maGhe = maGhe;
    }

    public Integer getIdCXMG() {
        return idCXMG;
    }

    public void setIdCXMG(Integer idCXMG) {
        this.idCXMG = idCXMG;
    }

    public String getMaGhe() {
        return maGhe;
    }

    public void setMaGhe(String maGhe) {
        this.maGhe = maGhe;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Chuyenxe getMaChuyenXe() {
        return maChuyenXe;
    }

    public void setMaChuyenXe(Chuyenxe maChuyenXe) {
        this.maChuyenXe = maChuyenXe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCXMG != null ? idCXMG.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChuyennxeChongoi)) {
            return false;
        }
        ChuyennxeChongoi other = (ChuyennxeChongoi) object;
        if ((this.idCXMG == null && other.idCXMG != null) || (this.idCXMG != null && !this.idCXMG.equals(other.idCXMG))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.ChuyennxeChongoi[ idCXMG=" + idCXMG + " ]";
    }
    
}
