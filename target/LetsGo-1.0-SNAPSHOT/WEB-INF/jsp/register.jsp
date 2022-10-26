<%-- 
    Document   : register
    Created on : Aug 23, 2022, 9:33:41 PM
    Author     : NguyenThiNgocNhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<c:if test="${errMgs != null}">
    <div class="alert alert-danger">
        ${errMgs}
    </div>
</c:if>

<section id="dangnhap" class="dangnhap">
    <div class="container">

        <div class="section-title" style="margin-top: 40px;">
            <h3>Đăng <span>Kí</span></h3>
        </div>

        <c:url value = "/register" var = "action"/>

        <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user">
            
            <form:errors  path ="*" cssClass="alert alert-danger" element="div"></form:errors>
            <div class="col-lg-4 col-md-6 form-group" style="float: right;width: 40%; margin-right: 380px; margin-top: 5px; margin-bottom: 10px;">
                <form:input type="file" path="file" name="file" class="form-control" placeholder="Ảnh đại diện" data-rule="minlen:4" data-msg="Please enter at least 4 chars"/>   
            </div>
            <div style="float: left; width: 80%; margin-left: 300px;">
                <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
                    <form:input type="text" path="sdt" value ="04545454568" class="form-control" placeholder="Your Phone" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />   
                </div>

                <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
                    <form:input type="password" value="1234" path="pass" class="form-control" placeholder="Your Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars " />   
                </div>

                <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
                    <form:input type="password" value="1234" path="confirmPassword" class="form-control" placeholder="Confirm Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars " />   
                </div>

                <div  class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
                    <form:input type="email" path="email" value="anhthu123@gmail.com" class="form-control"  placeholder="Your Email" data-rule="minlen:4" data-msg="Please enter at least 4 chars"/>    
                </div>

            </div>

            <form:form method="post" action="${action}" modelAttribute="khachhang">
                <div style="float: right; width: 80%; margin-right: -400px; margin-top: -190px;"> 
                    <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
        <form:input type="text" path="tenKH" value="Ho hjhjs"  name="tenKH" class="form-control" id="register"  placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars"/>   
                    </div>


                    <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
                        <div class="form-control" id="register" placeholder= data-rule="minlen:4" data-msg="Please enter at least 4 chars"> 
                            <form:select class="select" path="gioiTinh" type="text" name="Your Gender" >
                                <option value="0">Nu</option>
                                <option value="1">Nam</option>

                            </form:select>
                        </div>   
                    </div>
                    <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">

                        <input type="date" id="dt" value ="2001-10-18" />
                        <form:hidden path ="ngaySinh"  style ="width: 50%; float: left" id="ndt"/>

                    </div>

                    <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 10px;">
                        <form:input type="text" path="diaChi" value="123456" name="diaChi" class="form-control" placeholder="Your Address" data-rule="minlen:4" data-msg="Please enter at least 4 chars"/>    
                    </div>
                </div>


                <div class="col-lg-4 col-md-6 form-group" style="float: right;width: 40%; margin-right: 380px; margin-top: 5px;">
                    <form:input type="text" path="cmnd" name="cmnd" value="4545457878" class="form-control" placeholder="Your Identity Card" data-rule="minlen:4" data-msg="Please enter at least 4 chars"/>   
                </div>

                <div class="section-title">
                    <button type="submit" onclick="mydate1('dt', 'ndt')"  class="dangki" style="width: 50%; height: 45px; margin-top: 34px; margin-left: 35px;  margin-right: 35px;  margin-bottom: -25px; background-color: rgb(255, 199, 0); border-radius: 5px; text-transform: uppercase; font-weight: bold; color: rgb(72, 72, 72); ">
                        <span>Đăng kí</span>
                    </button>
                </div>
            </form:form>


        </form:form>



    </div>
</section>

<script>

    function mydate1(id1, id2) {

        d = new Date(document.getElementById(id1).value);
        dt = d.getDate();

        mn = d.getMonth();
        mn++;
        yy = d.getFullYear();

        document.getElementById(id2).value = dt + "/" + mn + "/" + yy
    }

</script>
