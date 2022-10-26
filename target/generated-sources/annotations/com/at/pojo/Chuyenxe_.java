package com.at.pojo;

import com.at.pojo.Comment;
import com.at.pojo.Hoadon;
import com.at.pojo.Taixe;
import com.at.pojo.Tuyenxe;
import com.at.pojo.Xe;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-10-26T15:53:55")
@StaticMetamodel(Chuyenxe.class)
public class Chuyenxe_ { 

    public static volatile SingularAttribute<Chuyenxe, BigDecimal> giaVe;
    public static volatile SingularAttribute<Chuyenxe, Xe> maXe;
    public static volatile SetAttribute<Chuyenxe, Comment> commentSet;
    public static volatile SingularAttribute<Chuyenxe, Taixe> maTaiXeChinh;
    public static volatile SingularAttribute<Chuyenxe, Character> trangThai;
    public static volatile SingularAttribute<Chuyenxe, Date> gioXuatPhat;
    public static volatile SetAttribute<Chuyenxe, Hoadon> hoadonSet;
    public static volatile SingularAttribute<Chuyenxe, Integer> maChuyenXe;
    public static volatile SingularAttribute<Chuyenxe, Tuyenxe> maTuyenXe;
    public static volatile SingularAttribute<Chuyenxe, Integer> soChoConDu;
    public static volatile SingularAttribute<Chuyenxe, Taixe> maTaiXePhu;
    public static volatile SingularAttribute<Chuyenxe, Date> gioDen;

}