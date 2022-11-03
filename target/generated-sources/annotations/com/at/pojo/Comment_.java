package com.at.pojo;

import com.at.pojo.Chuyenxe;
import com.at.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-11-03T17:30:01")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, User> maUser;
    public static volatile SingularAttribute<Comment, Integer> idComment;
    public static volatile SingularAttribute<Comment, Chuyenxe> maChuyenXe;
    public static volatile SingularAttribute<Comment, String> content;
    public static volatile SingularAttribute<Comment, Date> createDate;

}