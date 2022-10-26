<%-- 
    Document   : thanhtoan
    Created on : Aug 26, 2022, 10:48:22 PM
    Author     : thu
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value='/resources/assets/js/master.js' />"></script>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>


<div class ="container " style ="margin-top: 100px; margin-bottom: 50px; width: 50%;" >
    <h4 style="text-align: center">TRANG THANH TOÁN</h4>
    <div class="container " style="text-align: center">
   <div>Chúng tôi đang giữ vé cho bạn trong vòng <span id="time">01:00</span> phút nữa !!!</div>

        <c:url value ="/thanhtoan"  var="action"/>
        <form:form method = "post" action="${action}" modelAttribute="HoaDon"  >
            <div class="form-floating mb-3 mt-3"> 
                <form:input type="text" path="hoTen" value = "${u.khachhang.tenKH}" class="form-control" id="name" placeholder="Tên" name="name" />
                <label for="Họ Tên">Họ Tên</label>
            </div>
            <div class="form-floating mb-3 mt-3">
                <form:input type="text" path="sdt" value ="${u.sdt}" class="form-control" id="SDT" placeholder="SDT" name="SDT" />
                <label for="SDT">Số điện thoại</label>
            </div>
        
                 <div class="form-floating mb-3 mt-3">
                <form:input type="text" path="ghiChu" class="form-control"  placeholder="Ghichú" />
                <label for="ghi chú"> Ghi Chú</label>
            </div>
               
                 <div class="form-floating mb-3 mt-3">
                <form:input type="email" path="email" value="${u.email}" class="form-control" id="Email" placeholder="Email" />
                <label for="Email">Email</label>
            </div>

             </div>
            <div class="form-floating mb-3 mt-3">
                   <h5>Số Ghế : ${Ghe}</h5>
                  <form:hidden path="soVe" value="${TongCho}" />
            </div>
                
                <div class="form-floating mb-3 mt-3">
                   <h5>Tổng tiền : <fmt:formatNumber value = "${TongTien}" maxFractionDigits="3" type ="number"/> VND</h5>
            </div>
                  
                  <div class="form-floating mb-3 mt-3"> 
                  <form:select path="trangThaiThanhToan" >
                      <sec:authorize access="hasRole('ROLE_KH')">
                      <option  value ="1"> "Thanh Toán Online Ngay </option>
                      <option  value="0"> Thanh Toán Sau </option>
                  </sec:authorize>
                      <sec:authorize access="hasRole('ROLE_NV')">
                        <option  value ="1"> Thanh Toán Ngay </option>
                      </sec:authorize>

                  </form:select>
            </div>
              
            <div>
                <br>
                <input type="submit" value="Xác Nhận Thanh Toán" class="btn btn-danger" />
            </div>
        </form:form>



    </div>


</div>
