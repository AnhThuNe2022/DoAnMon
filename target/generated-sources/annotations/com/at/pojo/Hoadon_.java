package com.at.pojo;

import com.at.pojo.Chitiethoadon;
import com.at.pojo.Chuyenxe;
import com.at.pojo.Khachhang;
import com.at.pojo.Nhanvien;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-26T15:53:55")
@StaticMetamodel(Hoadon.class)
public class Hoadon_ { 

    public static volatile SingularAttribute<Hoadon, String> sdt;
    public static volatile SingularAttribute<Hoadon, Khachhang> maKH;
    public static volatile SingularAttribute<Hoadon, Character> hinhThucTT;
    public static volatile SingularAttribute<Hoadon, String> ghiChu;
    public static volatile SingularAttribute<Hoadon, Nhanvien> maNV;
    public static volatile SetAttribute<Hoadon, Chitiethoadon> chitiethoadonSet;
    public static volatile SingularAttribute<Hoadon, Date> ngayDatVe;
    public static volatile SingularAttribute<Hoadon, Chuyenxe> maChuyenXe;
    public static volatile SingularAttribute<Hoadon, String> hoTen;
    public static volatile SingularAttribute<Hoadon, Boolean> trangThaiTT;
    public static volatile SingularAttribute<Hoadon, String> email;
    public static volatile SingularAttribute<Hoadon, Integer> soVe;
    public static volatile SingularAttribute<Hoadon, Integer> maHoaDon;

}