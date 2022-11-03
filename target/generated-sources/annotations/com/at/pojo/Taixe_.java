package com.at.pojo;

import com.at.pojo.Chuyenxe;
import com.at.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-03T17:30:01")
@StaticMetamodel(Taixe.class)
public class Taixe_ { 

    public static volatile SingularAttribute<Taixe, User> maUser;
    public static volatile SingularAttribute<Taixe, String> diaChi;
    public static volatile SingularAttribute<Taixe, String> maBangLaiXe;
    public static volatile SetAttribute<Taixe, Chuyenxe> chuyenxeSet;
    public static volatile SingularAttribute<Taixe, Date> ngaySinh;
    public static volatile SetAttribute<Taixe, Chuyenxe> chuyenxeSet1;
    public static volatile SingularAttribute<Taixe, Character> loaitx;
    public static volatile SingularAttribute<Taixe, Character> gioiTinh;
    public static volatile SingularAttribute<Taixe, String> tenTaiXe;
    public static volatile SingularAttribute<Taixe, String> cmnd;
    public static volatile SingularAttribute<Taixe, Integer> maTaiXe;

}