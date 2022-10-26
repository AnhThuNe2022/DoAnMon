<%-- 
    Document   : taiXeChiTiet
    Created on : Sep 3, 2022, 7:57:51 PM
    Author     : thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>


<div class="container-fluid p-0" style="margin-top: 70px">
    <div class="row" id="body-row">
        <%@ include file="admin.jsp" %>


        <!-- MAIN -->
        <div class="col" style="margin-top: 10px">

            <h3 style="text-align: center" >
                DANH SÁCH HÀNH KHÁCH CHUYẾN XE ${idCX}
            </h3>

                <form method="post" action="<c:url value='/taixe/chuyenxe/${idCX}'/>">
                    <input name="maHD" id="maHD" hidden>
                  <div class="container">
                <table class="table table-hover" style = "margin-top: 10px">
                    <thead>
                        <tr>
                            <th>Họ Tên</th>
                            <th>SĐT</th>
                            <th>Ghi Chú</th>
                            <th>Ghế Số</th>
                            <th>Tổng Tiền</th>
                            <th>TT Thanh Toán</th>
                        </tr>
                    </thead>
                  
                           <c:forEach var="p" items="${listHD}" >
                        <tbody>
                            <tr>
                                <td>${p.hoTen}</td>
                                <td>${p.sdt}</td>
                                <td>${p.ghiChu}</td>                
                                <td>
                                     <c:forEach items="${p.chitiethoadonSet}" var="s">      
                                     ${s.maGhe.maGhe}
                                    </c:forEach>
               
                                </td>
                                                                <td><fmt:formatNumber value = "${p.tongTien}" maxFractionDigits="3" type ="number"/> VND</td>

                                <c:if test="${p.trangThaiTT == true}">
                                    <td> <i  class="bi bi-clipboard-check" style=" font-size: 1.7em;padding-left: 30px"></i></td> 
                                </c:if>
                                 <c:if test="${p.trangThaiTT == false}">
                                 <td>  <button type="submit" style="background-color: #dc3545" onclick="setTT(${p.maHoaDon})" class="btn btn-primary" >Đã TT</button></td>
                                  </c:if>
                       
                        </tr>

                        </tbody>
                    </c:forEach>

                </table>


                                <br>
                                <br>
            </div>
                
            </form>
          



            <!--               
                           
            
            
            
                    </div><!-- Main Col END -->

        </div><!-- body-row END -->
    </div><!-- container -->
</div>
<script>
    function setTT(id)
    {
        document.getElementById("maHD").value = id;
        alert( document.getElementById("maHD").value)
    }
</script>

