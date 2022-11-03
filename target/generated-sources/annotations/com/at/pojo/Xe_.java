package com.at.pojo;

import com.at.pojo.Chuyenxe;
import com.at.pojo.Loaixe;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-03T17:30:01")
@StaticMetamodel(Xe.class)
public class Xe_ { 

    public static volatile SingularAttribute<Xe, Integer> maXe;
    public static volatile SetAttribute<Xe, Chuyenxe> chuyenxeSet;
    public static volatile SingularAttribute<Xe, Date> ngayMua;
    public static volatile SingularAttribute<Xe, Loaixe> maLoaiXe;
    public static volatile SingularAttribute<Xe, String> pic;
    public static volatile SingularAttribute<Xe, String> bienSo;

}