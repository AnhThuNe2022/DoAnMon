package com.at.pojo;

import com.at.pojo.Hoadon;
import com.at.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-26T15:53:55")
@StaticMetamodel(Khachhang.class)
public class Khachhang_ { 

    public static volatile SingularAttribute<Khachhang, User> maUser;
    public static volatile SingularAttribute<Khachhang, String> diaChi;
    public static volatile SingularAttribute<Khachhang, Integer> maKH;
    public static volatile SingularAttribute<Khachhang, String> tenKH;
    public static volatile SingularAttribute<Khachhang, Date> ngaySinh;
    public static volatile SetAttribute<Khachhang, Hoadon> hoadonSet;
    public static volatile SingularAttribute<Khachhang, Character> gioiTinh;
    public static volatile SingularAttribute<Khachhang, String> cmnd;

}