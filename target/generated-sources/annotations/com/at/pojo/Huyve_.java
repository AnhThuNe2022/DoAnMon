package com.at.pojo;

import com.at.pojo.Chinhsachhuyve;
import com.at.pojo.Chitiethoadon;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-03T17:30:01")
@StaticMetamodel(Huyve.class)
public class Huyve_ { 

    public static volatile SingularAttribute<Huyve, Integer> idhuyve;
    public static volatile SingularAttribute<Huyve, Chinhsachhuyve> maChinhSachHuyVe;
    public static volatile SingularAttribute<Huyve, Chitiethoadon> chitiethoadon;
    public static volatile SingularAttribute<Huyve, BigDecimal> soTienHoan;
    public static volatile SingularAttribute<Huyve, Date> ngayHuyVe;

}