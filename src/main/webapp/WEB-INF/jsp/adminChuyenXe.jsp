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
                QUẢN LÝ CHUYẾN XE ${ok}
            </h3>
            <div class="container mt-4">
                <button  type="button" onclick="alertform('form-insert',1);closebt('form-is');setValueDateTime('GioXuatPhat');setValueDateTime('GioDen');" style="background-color: #35322d" class="btn btn-primary"><span class='bi bi-person-plus'></span></button>

                <table class="table table-hover" style = "margin-top: 10px;">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Mã Tuyến</th>
                            <th>Mã Xe</th>
                            <th>Giờ Xuất Phát</th>
                            <th>Giờ Đến</th>
                            <th>Tài Xế Chính</th>
                            <th>Tài Xế Phụ</th>
                            <th>Giá Vé</th>
                            <th>TT</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="p" items="${ListChuyenXe}" >
                        <tbody>
                            <tr>
                                <td>${p.maChuyenXe}</td>
                                <td>${p.maTuyenXe.maTuyenXe}</td>
                                <td>${p.maXe.maXe}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value ="${p.gioXuatPhat}"/></td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy HH:mm" value ="${p.gioDen}"/></td>
                                <td>${p.maTaiXeChinh.tenTaiXe}</td>
                                <td>${p.maTaiXePhu.tenTaiXe}</td>
                                <td>${p.giaVe}</td>
                                <td><c:if test="${p.trangThai.toString() == '0'}">
                                        Chưa Xuất Phát
                                    </c:if>
                                    <c:if test="${p.trangThai.toString() == '1'}">
                                        Đang Xuất Phát
                                    </c:if>
                                    <c:if test="${p.trangThai}.toString() == '3'}">
                                        Đã Xong
                                    </c:if>
                                </td>
                                <td>
                                    <div class="spinner-border text-warning"  id="loading${p.maChuyenXe}" style = "display:none"></div>
                                    <c:url value ="/api/admin/chuyenxe/delete/${p.maChuyenXe}" var="del" /> 
                                    <button type="button" id="delete${p.maChuyenXe}" style="background-color: #dc3545;" class="btn btn-primary" onclick="Fdelete('${del}',${p.maChuyenXe});" ><span  class="bi bi-trash"></span></button>
                                    <button type="button" id="edit${p.maChuyenXe}" style="background-color: #ffa012;" class="btn btn-primary"   onclick="alertform('form-update',1);updateCX(${p.maChuyenXe})"><span class='bi bi-pencil-square'></span></button>
                                </td>
                            </tr>

                        </tbody>
                    </c:forEach>
                </table>

                <form action="<c:url value = "/admin/chuyenxe/"/>" >
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
                    <c:url value ="/admin/chuyenxe/add" var="addCX"/>

                    <form:form  id='form-is' action="${addCX}" method="post" modelAttribute="ChuyenXe" >
                        <div id ="form-insert" style="display: none" > 
                            <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                                <div class="box-formNV">
                                    <h3 style="margin: 15px;color: #ffffff" >Thêm Chuyến Xe</h3>

                                    <div class="textbox-admin">
                                        <i class="bi bi-truck-front"></i>
                                        <form:select path="FTuyenXe" class ="sex"  style ="width: 55%; float:left;" >
                                            <c:forEach var="x" items="${ListTuyenXe}" >
                                                <option value="${x.maTuyenXe}">Tuyến: ${x.maTuyenXe}</option>
                                            </c:forEach>
                                        </form:select>
                                         <i class="bi bi-truck-front"></i>      
                                        <form:select path="FMaXe" class ="sex" style ="width: 45%; float:right;" >
                                            <c:forEach var="x" items="${ListXe}" >
                                                <option value="${x.maXe}">Xe Mã: ${x.maXe}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>

                                    <div class="textbox-admin">
                                      
                                        <span style="color: #ffffff;float:left;padding-top: 20px">Giờ đi</span>
                                        <input type="datetime-local" onchange="checkValueDateTime('GioXuatPhat','GioDen')" id="GioXuatPhat" style ="width: 75%;float:right"/>
                                        <form:hidden path ="gioXuatPhat" style ="width: 50%; float: left" id="hdGioXuatPhat"/>

                                    </div>

                                    <div class="textbox-admin">
                                        <span style="color: #ffffff;float:left;padding-top: 20px">Giờ đến</span>
                                        <input type="datetime-local" onchange="checkValueDateTime('GioXuatPhat','GioDen')" id="GioDen" style ="width: 75%;float:right"/>
                                        <form:hidden path ="gioDen" style ="width: 50%; float: left" id="hdGioDen"/>

                                    </div>     



                                    <div class="textbox-admin">
                                        <span style="color: #ffffff;float:left;padding-top: 20px" >Tài xế chính:  </span>
                                        <form:select path="FTaiXeChinh" class ="sex"  style ="width: 75%;float:right"  >
                                            
                                            <c:forEach var ="l" items ="${ListTaiXeC}" >
                                                <option value="${l.maTaiXe}">${l.maTaiXe}. ${l.tenTaiXe}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>

                                    <div class="textbox-admin">
                                        <span style="color: #ffffff;float:left;padding-top: 20px" >Tài xế phụ:  </span>
                                        <form:select path="FTaiXePhu" class ="sex" style="width: 75%;float:right" >
                                            <c:forEach var ="l" items ="${ListTaiXeP}" >
                                                <option value="${l.maTaiXe}">${l.maTaiXe}. ${l.tenTaiXe}</option>
                                            </c:forEach>
                                        </form:select>
                                     </div>

                                        <div class="textbox-admin">
                                            <i class="bi bi-truck-front"></i>
                                            <form:input path="giaVe"  type="number" placeholder="Giá Vé" />
                                        </div>


                                        <div class="textbox-admin">
                                            <div class="button">
                                    <button id="send" style ="width: 50%; float: left" onclick="alertform('form-insert',0);mydatetime('GioXuatPhat', 'hdGioXuatPhat');mydatetime('GioDen', 'hdGioDen')">Thêm</button>
                                    <button id="close" style ="width: 50%; float: right" onclick="alertform('form-insert',0);return false">Close</button>
                                </div>
                                        </div>


                                   
                                </div>
                            </div>
                        </form:form>
                    </div>

                    
                     <div>
                    <c:url value ="/admin/chuyenxe/update" var="updateCX"/>

                    <form:form action="${updateCX}" method="post" modelAttribute="ChuyenXe" >
                        <div id ="form-update" style="display: none" > 
                            <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                                <div class="box-formNV">
                                    <h3 style="margin: 15px;color: #ffffff" >Cập Nhật Chuyến Xe</h3>
                                    
                                    <div class="textbox-admin">
                                    <i class="bi bi-truck-front"></i>
                                    <form:input path="maChuyenXe" type="text" style ="width: 30%; float: left"  id="maCX" readonly="true"/>
                                
                                           <form:select path="FMaXe" class ="sex" id="maXe" style ="width: 70%; float:right;" >
                                            <c:forEach var="x" items="${ListXe}" >
                                                <option value="${x.maXe}">Xe Mã: ${x.maXe}</option>
                                            </c:forEach>
                                        </form:select>                                    
                                    </div>
                                    
                                    
                                    <div class="textbox-admin">
                                       <i class="bi bi-truck-front"></i>
                                        
                                        <form:select path="FTuyenXe" class ="sex"  id="maTuyenXe"  style ="width: 100%; float:left;" >
                                            <c:forEach var="x" items="${ListTuyenXe}" >
                                                <option value="${x.maTuyenXe}" >Tuyến: ${x.maTuyenXe}</option>
                                            </c:forEach>
                                        </form:select>
                                                
                                        
                                    </div>

                                    <div class="textbox-admin">
                                        <span style="color: #ffffff;float:left;padding-top: 20px">Giờ đi</span>
                                        <input  type="datetime-local"  id="UGioXP" style ="width: 75%;float:right"/>
                                        <form:hidden path ="gioXuatPhat" style ="width: 50%; float: left" id="hdUGioXP"/>

                                    </div>

                                    <div class="textbox-admin">
                                        <span style="color: #ffffff;float:left;padding-top: 20px">Giờ đến</span>
                                        <input type="datetime-local" id="UGioDen" value="2022-08-13T13:20" style ="width: 75%;float:right"/>
                                        <form:hidden path ="gioDen" style ="width: 50%; float: left" id="hdUGioDen"/>

                                    </div>     

                                    <div class="textbox-admin">
                                        <span style="color: #ffffff;float:left;padding-top: 20px" >Tài xế chính:  </span>
                                        <form:select path="FTaiXeChinh" class ="sex" id="taiXeChinh" style ="width: 75%;float:right"  >
                                            <c:forEach var ="l" items ="${ListTaiXeC}" >
                                                <option value="${l.maTaiXe}">${l.maTaiXe}. ${l.tenTaiXe}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>

                                    <div class="textbox-admin">
=                                        <span style="color: #ffffff;float:left;padding-top: 20px" >Tài xế phụ:  </span>
                                        <form:select path="FTaiXePhu" class ="sex" id ="taiXePhu" style="width: 75%;float:right" >
                                            <c:forEach var ="l" items ="${ListTaiXeP}" >
                                                <option value="${l.maTaiXe}">${l.maTaiXe}. ${l.tenTaiXe}</option>
                                            </c:forEach>
                                        </form:select>
                                     </div>

                                        <div class="textbox-admin">
                                            <i class="bi bi-truck-front"></i>
                                            <form:input path="giaVe" id="giaVeNe" type="number" placeholder="Giá Vé" />
                                        </div>


                                        <div class="textbox-admin">
                                            <div class="button">
                                                <button id="send" style ="width: 50%; float: left" onclick="mydatetime('UGioXP', 'hdUGioXP');mydatetime('UGioDen', 'hdUGioDen');">Cập nhật</button>
                                               
                                    <button id="close" style ="width: 50%; float: right" onclick="alertform('form-update',0);return false">Close</button>

                                </div>
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
