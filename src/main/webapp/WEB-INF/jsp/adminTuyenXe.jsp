<%-- 
    Document   : adminChuyenXe
    Created on : Aug 17, 2022, 10:46:21 PM
    Author     : thu
--%>

<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value='/resources/assets/js/admin.js' />"></script>
<!DOCTYPE html>

<div class="container-fluid p-0" style="margin-top: 70px">
    <div class="row" id="body-row">
       <%@ include file="admin.jsp" %>

 
  <!-- MAIN -->
        <div class="col" style="margin-top: 10px">
            
            <h3 style="text-align: center" >
                QUẢN LÝ TUYẾN XE
            </h3>
            <div class="container mt-4">
                    <button  type="button" onclick="alertform('form-insert',1);closebt('form-is');" style="background-color: #35322d" class="btn btn-primary"><span class='bi bi-person-plus'></span></button>

                    <table class="table table-hover" style = "margin-top: 10px">
                        <thead>
                            <tr>
                                <th>Mã Tuyến Xe</th>
                                <th>Nơi khởi hành</th>
                                <th>Nơi đến</th>
                                <th>Số Km</th>
                                <th>Số giờ</th>
                                
                                <th></th>
                            </tr>
                        </thead>
                        <c:forEach var="p" items="${ListTuyenXe}" >
                            <tbody>
                                <tr>
                                    <td>${p.maTuyenXe}</td>
                                    <td>${p.noiKhoiHanh}</td>
                                    <td>${p.noiDen}</td>
                                    <td>${p.soKm}</td>
                                    <td>${p.soGio}</td>
                                    <td>
                                        <div class="spinner-border text-warning"  id="loading${p.maTuyenXe}" style = "display:none"></div>
                                          <c:url value ="/api/admin/tuyenxe/delete/${p.maTuyenXe}" var="del" /> 
                                        <button type="button" id="delete${p.maTuyenXe}" style="background-color: #dc3545" class="btn btn-primary" onclick="Fdelete('${del}','${p.maTuyenXe}');" ><span  class="bi bi-trash"></span></button>
                                        <button type="button" id="edit${p.maTuyenXe}" style="background-color: #ffa012" class="btn btn-primary"   onclick="alertform('form-update',1);updateTuyenXe('${p.maTuyenXe}');"><span class='bi bi-pencil-square'></span></button>
                                    </td>
                                </tr>

                            </tbody>
                        </c:forEach>
                    </table>
                    
                     <form action="<c:url value = "/admin/tuyenxe/"/>" >
                    <button type="submit" style="float: right;background: #132644" id="click" style="background: #04414d" class="btn btn-primary">Search</button>

                    <input type="text" style="float: right;padding-right: 20px"  name="kw" value ="${keyw}" placeholder="Search..">
                <ul class="pagination" >
                        <c:forEach begin="1" end= "${Math.ceil(countPage/onePage)}" var ="i" >
                             
                      
                        <li class="page-item //active//"><a class="page-link" onclick="getUrlne(${i})" href="javascript:;">${i}</a></li>
                        </c:forEach>
                </ul>
                 <input type="hidden" name="page" id="Hpage"/>
                </form>
                    
                    
                    <div>
                    <c:url value ="/admin/tuyenxe/add" var="addTX"/>
    
                    <form:form id='form-is' action="${addTX}" method="post" modelAttribute="TuyenXe" >
                    <div id ="form-insert" style="display: none" > 
                        <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                            <div class="box-formNV">
                                <h3 style="margin: 15px;color: #ffffff" >Thêm Tuyến Xe</h3>
                                <div class="textbox-admin">
                                    <i class="bi bi-train-front"></i>
                                    <form:input path="maTuyenXe" type="text" placeholder="Mã Tuyến" />
                                </div>
                                
                                <div class="textbox-admin">
                                   <i class="bi bi-train-front"></i>
                                    <form:input path="noiKhoiHanh" type="text" placeholder="Nơi Khởi Hành" />
                                </div>
                                
                                    <div class="textbox-admin">
                                    <i class="bi bi-train-front"></i>
                                    <form:input path="NoiDen" type="text" placeholder="Nơi Đến" />
                                </div>
                                
                                    <div class="textbox-admin">
                                   <i class="bi bi-train-front"></i>
                                    <form:input path="soKm" type="number" placeholder="Số KM" />
                                </div>
                                <div class="textbox-admin">
                                    <i class="bi bi-train-front"></i>
                                    <form:input path="soGio" type="number" placeholder="Số giờ" />
                                </div>
                                <a href="adminTuyenXe.jsp"></a>
                     
                                <div class="button">
                                    <button id="send" style ="width: 50%; float: left" onclick="">Thêm Tuyến Xe</button>
                                    <button id="close" style ="width: 50%; float: right" onclick="alertform('form-insert',0);return false">Close</button>

                                </div>
                                <div class="message">
                                    <div class="success" id="success">Your Message Successfully Sent!</div>
                                    <div class="danger" id="danger">Feilds Can't be Empty!</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
                    </div>
                    
                    <div>
                    <c:url value ="/admin/tuyenxe/update" var="updateTX"/>
    
                    <form:form action="${updateTX}" method="post" modelAttribute="TuyenXe" >
                    <div id ="form-update" style="display: none" > 
                        <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                            <div class="box-formNV">
                                <h3 style="margin: 15px;color: #ffffff" >Cập Nhật Tuyến Xe</h3>
                                <div class="textbox-admin">
                                   <i class="bi bi-train-front"></i>
                                    <form:input path="maTuyenXe" id="MaTX" type="text" placeholder="Mã Tuyến" readonly="true" />
                                </div>
                                
                                <div class="textbox-admin">
                                    <i class="bi bi-train-front"></i>
                                    <form:input path="noiKhoiHanh" id="NoiKH" type="text" placeholder="Nơi Khởi Hành" />
                                </div>
                                
                                    <div class="textbox-admin">
                                    <i class="bi bi-train-front"></i>
                                    <form:input path="noiDen" id ="Den" type="text" placeholder="Nơi Đến" />
                                </div>
                                
                                    <div class="textbox-admin">
                                   <i class="bi bi-train-front"></i>
                                    <form:input path="soKm" id="SoKM" type="number" placeholder="Số KM" />
                                </div>
                                <div class="textbox-admin">
                                    <i class="bi bi-train-front"></i>
                                    <form:input path="soGio" id ="SoGio" type="number" placeholder="Số giờ" />
                                </div>
                     
                                <div class="button">
                                    <button id="send" style ="width: 50%; float: left" onclick="">Cập Nhật</button>
                                    <button id="close" style ="width: 50%; float: right" onclick="alertform('form-update',0);return false">Close</button>

                                </div>
                                <div class="message">
                                    <div class="success" id="success">Your Message Successfully Sent!</div>
                                    <div class="danger" id="danger">Feilds Can't be Empty!</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </form:form>
                    </div>
                   

            </div>



        </div><!-- Main Col END -->
        
        </div><!-- body-row END -->
    </div><!-- container -->
