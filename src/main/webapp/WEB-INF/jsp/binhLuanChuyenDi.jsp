<%-- 
    Document   : binhLuanChuyenDi
    Created on : Aug 30, 2022, 2:33:33 PM
    Author     : thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<script src="<c:url value='/resources/assets/js/comment.js' />"></script>


<div class ="container border" style ="margin-top: 100px; margin-bottom: 50px; width: 100%;" >

    <div class="container border" style="height:300px; width:1000px ; margin-bottom: 50px" >
        <div class="container-i" >
            <img class="card-img-top card-i" style="width:100%;height:93%;padding-left: 10px" src="${chuyenxe.maXe.pic}"  alt="Card image">
            <h3 style="padding-left: 40px; text-align: center"> </h3>
        </div>
        <div class="container border" style="width:100%;height:100%;padding-top: 10px">
            <h3>Mã chuyến xe:${chuyenxe.maChuyenXe} </h3>
            <h4>Giường nằm ${chuyenxe.maXe.maLoaiXe.soGhe} chỗ</h4>
            <h4>Ngày khởi hành:<fmt:formatDate pattern="dd/MM/YYYY HH:mm" value ="${chuyenxe.gioXuatPhat}"/>  </h4>
        </div>
<br>
    </div>
        
           
        
        <div style="width: 70%;" >
            <div class='form-group'>
                <textarea class ='form-control' id='textcomment' placeholder="Nhập Đánh Giá..."></textarea>
                <br>
                <input type="submit" value="Gửi bình luận" onclick="addComment(${chuyenxe.maChuyenXe})" class="btn btn-outline-success" />
        </div>
        <br>
        </div>
        
        
     
                <ul class="pagination" >
                        <c:forEach begin="1" end= "${Math.ceil(countPage/onePage)}" var ="i" >
                         
                            <c:url value = "/binhluan/${chuyenxe.maChuyenXe}" var = "u"> 
                                <c:param name = "page" value = "${i}"/>
                            </c:url>
                           
                        <li class="page-item //active//"><a class="page-link" href="${u}">${i}</a></li>
                        </c:forEach>
                </ul>
                
        
        <div id = "List-comment">
             <c:forEach items="${cmt}" var ="p" >
                
                <div class ="row">
             <div class ="col-md-2" style="padding: 10px">
                 <img class="rounded-circle img-fluid" src="${p.maUser.avatar}" >   
            </div>
             <div class="col-md-10 cmt">
                 <p><b>${p.maUser.khachhang.tenKH}</b></p>
                 <p>${p.content}</p>
                 <i>${p.createDate}</i>
             </div>
       
             </div>
            </c:forEach>
        
        </div>
        
           
         
        
        
        
    
</div>
