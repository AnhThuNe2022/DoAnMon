<%-- 
    Document   : veCuaToi
    Created on : Sep 2, 2022, 12:47:05 AM
    Author     : NguyenThiNgocNhi
--%>


<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value='/resources/assets/js/huyve.js' />"></script>

 <c:set var="today" value="<%=new Date()%>"/>
<section class="container" style="text-align: center">
    <div >
        <h3 style="text-align: center;margin-top: 30px">VÉ CỦA TÔI</h3>

        <div style="margin-bottom: 20px; margin-top: 70px;">
            <a style="color: #000;font-weight: bold"; href = "<c:url value='/veCuaToi/veHienTai'/>" >Hiện tại</a>
            <a style="margin-left: 300px; font-weight: bold;" href="<c:url value="/veCuaToi/veDaDi"/>">Ðã đi</a>
            <a style="margin-left: 300px; font-weight: bold;color: #dc3545" href="<c:url value="/veCuaToi/veDaHuy"/>">Vé Đã Hủy</a>

        </div>
        <br>
        <c:if test="${ListHD.size() == 0}">
            <h5 style="text-align: center">Quý Khách Hiện Tại Chưa Có Vé Nào</h5>
        </c:if>
        <c:forEach var="p" items="${ListHD}">
            <br>
            <div style="margin-right: 500px">
                Giờ xuất phát : <a style="font-weight: bold; font-size:large;"><fmt:formatDate pattern="dd/MM/YYYY HH:mm" value ="${p.maChuyenXe.gioXuatPhat}"/>  </a>
            </div>
            <div  style="border: 3px solid #FFDE6C;margin-left:250px ;text-align: left; width: 70%; padding: 10px">
                <div style="color: #FFC700"> 
                    Mã hóa đơn :
                    <a style="color: #615D61"> ${p.maHoaDon}</a>

                    <c:if  test="${t == 1}">
                        <c:if test="${p.trangThaiTT == true}">
                            <a style="margin-left: 600px; background-color:#FFC700;color: #000 ">Ðã thanh toán</a>

                        </c:if>
                        <c:if test="${p.trangThaiTT == false}">
                            <a style="margin-left: 600px; background-color:#FFC700;color: #000 ">Chưa thanh toán</a>

                        </c:if>

                    </c:if>
                    <c:if  test="${t == 2}">
                        <a style="margin-left: 600px; background-color:#FFC700;color: #000 ">Ðã Xong</a>

                    </c:if>
                </div>
                <div>Tuyến xe: <a> Từ ${p.maChuyenXe.maTuyenXe.noiKhoiHanh} Đến ${p.maChuyenXe.maTuyenXe.noiDen}</a> </div>
                <div>Tên loại xe: <a>${p.maChuyenXe.maXe.maLoaiXe.tenLoaiXe}</a></div> 
                <div>Biển số xe: <a>${p.maChuyenXe.maXe.bienSo}</a></div>
                <div>Số ghế: 
                    <c:forEach items="${p.chitiethoadonSet}" var="s">      
                        <a>${s.maGhe.maGhe} </a>
                        <c:set var = "tongTien" value = "${tongTien+s.gia}"/>
                    </c:forEach>
                </div>

                
                
                <div>Tổng Tiền: <a><fmt:formatNumber value = "${tongTien}" maxFractionDigits="3" type ="number"/> VND</a>
                      <c:remove var = "tongTien"/>
                    <!-- <a style="margin-left: 600px; background-color:#FFC700;color: #000 ">Ðã Xong</a>-->
                    <c:if test="${t == 1}">
                        <c:url value ="/api/huyve/${p.maHoaDon}" var="u"/>
                       <button type="button"  style="background-color: #dc3545;float: right" class="btn btn-primary" onclick="huyVe('${u}')" ><span  class="bi bi-trash">Hủy Vé</span></button>

                    </c:if>

                    <c:if test="${t == 2}">
                        <c:choose>
                            <c:when test="${p.trangThaiTT == true}">
                                <a href="<c:url value="/binhluan/${p.maChuyenXe.maChuyenXe}"/>" type="button" id="" style="margin-left: 730px; background-color: #000" class="btn btn-primary"  ><span  class="bi bi-chat-text"> Bình Luận</span></a>
                            </c:when>
                            <c:otherwise>
                                <a type="button"  style="margin-left: 730px; background-color: #000" class="btn btn-primary"  ><span  class="bi bi-chat-text"> Không đi</span></a>
                            </c:otherwise>
                        </c:choose>
                    </c:if>




                </div>



            </div>

        </c:forEach>

    </div>
</section>
