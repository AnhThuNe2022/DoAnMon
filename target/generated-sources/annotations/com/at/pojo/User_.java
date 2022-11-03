package com.at.pojo;

import com.at.pojo.Khachhang;
import com.at.pojo.Nhanvien;
import com.at.pojo.Taixe;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-03T17:30:01")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> maUser;
    public static volatile SingularAttribute<User, Khachhang> khachhang;
    public static volatile SingularAttribute<User, String> sdt;
    public static volatile SingularAttribute<User, String> pass;
    public static volatile SingularAttribute<User, Nhanvien> nhanvien;
    public static volatile SingularAttribute<User, Taixe> taixe;
    public static volatile SingularAttribute<User, String> avatar;
    public static volatile SingularAttribute<User, String> userRole;
    public static volatile SingularAttribute<User, String> email;

}