<%-- 
    Document   : login
    Created on : Aug 23, 2022, 9:00:56 PM
    Author     : NguyenThiNgocNhi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${param.error != null}">
    <div style="text-align: center; margin-top: 100px" class="alert alert-danger">
        Đã có lỗi xảy ra vui lòng quay lại sau
    </div>
</c:if>
<c:if test="${param.accessDenied != null}">
    <div  style="text-align: center; margin-top: 100px" class="alert alert-danger">
        Bạn không có quyền truy cập
    </div>
</c:if>

<c:url value = "/login" var="action"/>
<form method="post" action="${action}">
    <section id="dangnhap" class="dangnhap">
        <div class="container">

            <div class="section-title" >
                <h3 style="margin-top: 50px;">Đăng <span>Nhập</span></h3>
                <p>Đăng nhập để dễ dàng đặt vé hơn nhé!!</p>
            </div>

            <form action="forms/book-a-table.php" method="post" role="form" class="php-email-form">
                <div class="section-title">
                    <div style="margin-left: 400px; width: 110%;">
                        <div class="col-lg-4 col-md-6 form-group" style="margin-bottom: 12px;">
                            <input type="text" name="sdt" class="form-control" id="SDT" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                        </div>

                        <div class="col-lg-4 col-md-6 form-group mt-3 mt-md-0">
                            <input type="password" class="form-control" name="pass" id="Pass" placeholder="Your Password" data-rule="minlen:4" data-msg="Please enter at least 4 chars">
                        </div>
                    </div>
                    
                    <div class="col-lg-5" style="margin-left: 370px;">
                        <input type="submit" value="Đăng nhập" class="dangnhap" style="width: 50%; height: 45px; margin-top: 16px; background-color: rgb(255, 199, 0); border-radius: 5px; text-transform: uppercase; font-weight: bold; color: rgb(72, 72, 72); "/>
                    </div>

                    <div>
                        <p class="col-lg-4" >Chưa có tài khoản?<a href="<c:url value="/register"/>" >Đăng kí ngay</a> 
                        </p>
                    </div>    
                </div>                       
            </form>

        </div>
    </section>
</form>

