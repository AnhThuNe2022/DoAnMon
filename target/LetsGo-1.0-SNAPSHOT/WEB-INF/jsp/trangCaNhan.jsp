<%-- 
    Document   : trangCaNhan
    Created on : Oct 26, 2022, 3:47:57 PM
    Author     : thu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class ="container " style ="margin-top: 100px; margin-bottom: 50px; width: 50%;" >
    <h3>Avatar:</h3>
      <img style="width:30px; height:30px;" class="rounded-circle img-fluid" src="${user.avatar}" >   
    <h3>Tên: ${user.khachhang.tenKH}</h3>
    <h3>Ngày Sinh:
        <fmt:formatDate pattern="dd/MM/yyyy" value="${user.khachhang.ngaySinh}"/>
    </h3>
    <h3>Sex:
        <c:if test = "${user.khachhang.gioiTinh.toString() == '0'}">
            Nu
        </c:if>
        <c:if test = "${user.khachhang.gioiTinh.toString() == '1'}">
            Nam
        </c:if>
    </h3>
    <h3>Địa chỉ: ${user.khachhang.diaChi}</h3>
    <h3>Email:${user.email}</h3>
    <h3>CMND:${user.khachhang.cmnd}</h3>     
    <h3>SĐT: ${user.sdt}</h3>     

</div>
