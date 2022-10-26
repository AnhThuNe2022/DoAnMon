<%-- 
    Document   : timve
    Created on : Aug 12, 2022, 4:37:39 PM
    Author     : thu
--%>

<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value='/resources/assets/js/timveKH.js' />"></script>
<script src="<c:url value='/resources/assets/js/master.js' />"></script>


<div class ="container-fluid " >
    <div class = "container  " style ="margin-top: 100px; margin-bottom: 50px; width: 100%;text-align: center ">

        <form action="<c:url value = "/timve/"/>">  
            <span > Chọn ngày khác</span>

            <span class="search-contend-item">
                <i class="fas fa-calendar-alt"></i>
                <input type="date"  onchange="setDate()"  id="dateHomeNe" > 
            </span>
            <a href="<c:url value='/'/>" class="btn" style="border-radius: 12px;background-color: #FFC800;float: right">Quay Lại Chọn Tuyến Khác</a>
            <div class="container" style="margin-top: 20px">


                <span margin-left: 80px>Sắp Xếp Theo: </span>

                <input name="maTX" value="${maTuyenXe}" type="hidden" >  
                <input id="hdDate" name="date" value="${date}" type="hidden" >  

                <input name="sort" value="${sort}" id ="sort" type="hidden" > 
                <button style ="margin-left: 50px" type="submit" class="btn btn-outline-success" onclick="setValue('sort', 0)">Giờ đi sớm nhất</button>
                <button style ="margin-left: 50px"type="submit" class="btn btn-outline-info" onclick="setValue('sort', 1)">Giờ đi muộn nhất</button>
                <button style ="margin-left: 50px" type="submit" class="btn btn-outline-warning" onclick="setValue('sort', 2)">Giá tăng dần</button>
                <button style ="margin-left: 50px" type="submit" class="btn btn-outline-dark" onclick="setValue('sort', 3)">Giá giảm dần</button>    
            </div>

            <ul class="pagination" >
                <c:forEach begin="1" end= "${Math.ceil(countPage/onePage)}" var ="i" >

                    <li class="page-item "><a class="page-link" onclick="setValue('Hpage',${i});
                                setSubmitPage()" href="javascript:;">${i}</a></li>
                    </c:forEach>
            </ul>
            <input type="hidden" name="page" id="Hpage"/>
            <button type="submit" id ="submitpage" hidden></button>


        </form>


    </div>
    <c:if test="${ListCX.size()== 0}">
        <h5 style="text-align: center">Hiện Chưa có chuyến xe nào vào thời gian này,Quý khách vui lòng chọn chuyến xe hoặc thời gian khác nhé</h5>

    </c:if>
    <c:if test="${ListCX.size() != 0}">


        <c:forEach begin="0" end="${ListCX.size()-1}" var="i">

            <div class="container border" style="height:300px; width:1000px ; margin-bottom: 50px" >
                <div class="container-i" >
                    <img class="card-img-top card-i" style="width:100%;height:93%;padding-left: 10px" src="${ListCX[i].maXe.pic}"  alt="Card image">
                    <h3 style="padding-left: 40px; text-align: center"><fmt:formatNumber value = "${ListCX[i].giaVe}" maxFractionDigits="3" type ="number"/> VND</h3>
                </div>
                <div class="container" style="width:60%;float: right;height:50%;padding-top: 10px">
                    <h3  >Mã chuyến xe: ${ListCX[i].maChuyenXe}</h3>
                    <h4>Giường nằm ${ListCX[i].maXe.maLoaiXe.soGhe} chỗ</h4>
                    <h4>Giờ khởi hành:<fmt:formatDate pattern="HH:mm" value ="${ListCX[i].gioXuatPhat}"/> </h4>
                </div>
                <div class="container-i2 " >
                    <h5>Còn ${ListCX[i].soChoConDu} chỗ</h5>
                    <form action="<c:url value='/timve/chitiet/${ListCX[i].maChuyenXe}'/>">
                        <button type="submit"  style="border: 20px" class="book-a-table-btn">Đặt vé</button>
                    </form>
                    <h6>KHÔNG CẦN THANH TOÁN TRƯỚC</h6>
                </div>
            </div>


        </c:forEach>
    </c:if>

</div>


<script>
    function setDate()
    {
        d = document.getElementById("dateHomeNe").value;
        k = d.split('-')
        kq = k[2] + "-" + k[1] + "-" + k[0]
        document.getElementById("hdDate").value = kq;
        setSubmitPage()
    }

</script>

