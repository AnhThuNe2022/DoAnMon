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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author thu
 */
@Entity
@Table(name = "xe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Xe.findAll", query = "SELECT x FROM Xe x"),
    @NamedQuery(name = "Xe.findByMaXe", query = "SELECT x FROM Xe x WHERE x.maXe = :maXe"),
    @NamedQuery(name = "Xe.findByBienSo", query = "SELECT x FROM Xe x WHERE x.bienSo = :bienSo"),
    @NamedQuery(name = "Xe.findByNgayMua", query = "SELECT x FROM Xe x WHERE x.ngayMua = :ngayMua"),
    @NamedQuery(name = "Xe.findByPic", query = "SELECT x FROM Xe x WHERE x.pic = :pic")})
public class Xe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaXe")
    private Integer maXe;
    @Size(max = 15)
    @Column(name = "BienSo")
    private String bienSo;
    @Column(name = "NgayMua")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayMua;
    @Size(max = 200)
    @Column(name = "Pic")
    private String pic;
    @OneToMany(mappedBy = "maXe")
    @JsonIgnore
    private Set<Chuyenxe> chuyenxeSet;
    @JoinColumn(name = "MaLoaiXe", referencedColumnName = "MaLoaiXe")
    @ManyToOne
    private Loaixe maLoaiXe;

    public Xe() {
    }

    public Xe(Integer maXe) {
        this.maXe = maXe;
    }

    public Integer getMaXe() {
        return maXe;
    }

    public void setMaXe(Integer maXe) {
        this.maXe = maXe;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @XmlTransient
    public Set<Chuyenxe> getChuyenxeSet() {
        return chuyenxeSet;
    }

    public void setChuyenxeSet(Set<Chuyenxe> chuyenxeSet) {
        this.chuyenxeSet = chuyenxeSet;
    }

    public Loaixe getMaLoaiXe() {
        return maLoaiXe;
    }

    public void setMaLoaiXe(Loaixe maLoaiXe) {
        this.maLoaiXe = maLoaiXe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maXe != null ? maXe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Xe)) {
            return false;
        }
        Xe other = (Xe) object;
        if ((this.maXe == null && other.maXe != null) || (this.maXe != null && !this.maXe.equals(other.maXe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.at.pojo.Xe[ maXe=" + maXe + " ]";
    }
    
}
