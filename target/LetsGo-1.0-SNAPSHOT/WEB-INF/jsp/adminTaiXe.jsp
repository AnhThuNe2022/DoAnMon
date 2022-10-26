<%-- 
    Document   : adminTaiXe
    Created on : Aug 21, 2022, 4:53:47 PM
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
                QUẢN LÝ TÀI XẾ
            </h3>



            <div class="container mt-4">
                <button  type="button" onclick="alertform('form-insert', 1);closebt('form-is');" style="background-color: #35322d" class="btn btn-primary"><span class='bi bi-person-plus'></span></button>

                <table class="table table-hover" style = "margin-top: 10px">
                    <thead>
                        <tr>
                            <th>Mã Tài xế</th>
                            <th>Tên Tài Xế</th>
                            <th>Ngày Sinh</th>
                            <th>Giới Tính</th>
                            <th>Địa Chỉ</th>
                            <th>CMND</th>
                            <th>Loại TX</th>
                            <th>Mã Bằng lái xe</th>
                            <th>User</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="p" items="${ListTaiXe}" >
                        <tbody>
                            <tr>
                                <td>${p.maTaiXe}</td>
                                <td>${p.tenTaiXe}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value ="${p.ngaySinh}"/></td>
                                <td>
                                    <c:if test="${p.gioiTinh.toString() == '1'}" >
                                        Nam
                                    </c:if>
                                    <c:if test="${p.gioiTinh.toString() == '0'}" >
                                        Nữ
                                    </c:if>
                                </td>
                                <td>${p.diaChi}</td>
                                <td>${p.cmnd}</td>
                                <td><c:if test="${p.loaitx.toString() == '1'}" >
                                        TX Chính
                                    </c:if>
                                    <c:if test="${p.loaitx.toString() == '2'}" >
                                        TX Phụ
                                    </c:if></td>
                                <td>${p.maBangLaiXe}
                                <td>${p.maUser.maUser}</td>
                                <td>
                                    <div class="spinner-border text-warning"  id="loading${p.maTaiXe}" style = "display:none"></div>
                                    <c:url value ="/api/admin/taixe/delete/${p.maTaiXe}" var="del" /> 
                                    <button type="button" id="delete${p.maTaiXe}" style="background-color: #dc3545" class="btn btn-primary" onclick="Fdelete('${del}',${p.maTaiXe});" ><span  class="bi bi-trash"></span></button>
                                    <button type="button" id="edit${p.maTaiXe}" style="background-color: #ffa012" class="btn btn-primary"   onclick="alertform('form-update', 1);updateTX(${p.maTaiXe});"><span class='bi bi-pencil-square'></span></button>
                                </td>
                            </tr>

                        </tbody>
                    </c:forEach>
                </table>


                <form action="<c:url value = "/admin/taixe/"/>" >
                    <button type="submit" style="float: right;background: #132644" id="click" style="background: #04414d" class="btn btn-primary">Search</button>

                    <input type="text" style="float: right;padding-right: 20px"  name="kw" value ="${keyw}" placeholder="Search..">
                    <ul class="pagination" >
                        <c:forEach begin="1" end= "${Math.ceil(countPage/onePage)}" var ="i" >

                            <c:url value = "" var = "u"> 
                                <c:param name = "page" value = "${i}"/>
                            </c:url>
                            <li class="page-item //active//"><a class="page-link" onclick="getUrlne(${i})" href="javascript:;">${i}</a></li>
                            </c:forEach>
                    </ul>
                    <input type="hidden" name="page" id="Hpage"/>
                </form>

                <div>


                    <c:url value ="/admin/taixe/add" var="addTX"/>


                    <form:form id ='form-is' action="${addTX}" method="post" modelAttribute="TaiXe" >
                        <div id ="form-insert" style="display: none" > 
                            <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                                <div class="box-formNV">
                                    <h3 style="margin: 15px;color: #ffffff" >Thêm Tài Xế</h3>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="tenTaiXe" type="text" placeholder="Tên Tài Xế" id="name"/>
                                    </div>
                                    <div class="textbox-admin"  >
                                        <i class="fas fa-user"></i>
                                        <form:select path="gioiTinh" class ="sex" style ="width: 50%; float: right">
                                            <option value="1">Nam</option>
                                            <option value="0">Nữ</option>
                                        </form:select>
                                        <input type="date" value="2001-10-18" id="dt" style ="width: 50%; float: left" onchange=""/>
                                        <form:hidden path ="ngaySinh" style ="width: 50%; float: left" id="ndt"/>
                                    </div>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input  path="cmnd" type="text" placeholder="CMND" id="name"/>
                                    </div>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="diaChi" type="text" placeholder="Địa chỉ" id="name"/>
                                    </div>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:select path="loaitx" class ="sex" >
                                            <option value="1">Tài xế chính </option>
                                            <option value="2">Tài Xế Phụ</option>
                                        </form:select>                                   
                                    </div>



                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="maBangLaiXe" type="text" placeholder="Mã Bằng lái" id="name"/>
                                    </div>

                                    <div class="button">
                                        <button id="send" style ="width: 50%; float: left" onclick="alertform('form-insert', 0);mydate1('dt', 'ndt');">Thêm</button>
                                        <button id="close" style ="width: 50%; float: right" onclick="alertform('form-insert', 0);return false">Close</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>



                <c:url  value ="/admin/taixe/update" var="updateTX"/>
                <form:form action="${updateTX}" method="post" modelAttribute="TaiXe" >
                    <div id ="form-update" style="display: none" > 
                        <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                            <div class="box-formNV">
                                <h3 style="margin: 15px;color: #ffffff" >Cập Nhật Tài Xế</h3>
                                <div class="textbox-admin">
                                    <i class="fas fa-user"></i>
                                    <form:input path="maTaiXe" type="text" style ="width: 30%; float: left"  value="iii" id="maTX" readonly="true"/>

                                    <form:input path="tenTaiXe" type="text" style ="width: 70%; float: right" placeholder="Tên nhân viên" id="UtenTX"/>

                                </div>
                                <div class="textbox-admin"  >
                                    <i class="fas fa-user"></i>
                                    <form:select path="gioiTinh" class ="sex"  id="Usex" style ="width: 50%; float: right">
                                        <option value="1">Nam</option>
                                        <option value="0">Nữ</option>
                                    </form:select>
                                    <input type="date" id="Udt" style ="width: 50%; float: left" onchange="mydate1('Udt', 'Undt');"/>
                                    <form:hidden path ="ngaySinh" style ="width: 50%; float: left" id="Undt"/>
                                </div>
                                <div class="textbox-admin">
                                    <i class="fas fa-user"></i>
                                    <form:input  path="cmnd" type="text" placeholder="CMND" id="Ucmnd"/>
                                </div>
                                <div class="textbox-admin">
                                    <i class="fas fa-user"></i>
                                    <form:input path="diaChi" type="text" placeholder="Địa chỉ" id="Udiachi"/>
                                </div>
                                
                                 <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:select path="loaitx" class ="sex" id="UloaiTX" >
                                            <option value='1'>Tài xế chính </option>
                                            <option value='2'>Tài Xế Phụ</option>
                                        </form:select>                                   
                                    </div>


                                <div class="textbox-admin">
                                    <i class="fas fa-user"></i>
                                    <form:input path="maBangLaiXe" type="text" placeholder="Chứng Chỉ" id="UmaBang"/>
                                </div>
                                <div class="textbox-admin" id="textbox-user">
                                    <i class="fas fa-user" ></i>
                                    <form:select path="maU" class ="sex" id="Uuser" >
                                        <option value=""  id="optionNV"></option>
                                        <option value="null">----Không chọn---</option>

                                        <c:forEach var ="l" items ="${MaU}" >    
                                            <option value="${l.maUser}">${l.maUser}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="button">
                                    <button id="send" style ="width: 50%; float: left"  onclick="mydate1('Udt', 'Undt');">Cập Nhật</button>
                                    <button id="close" style ="width: 50%; float: right" onclick="alertform('form-update', 0);return false">Close</button>

                                </div>

                            </div>
                        </div>
                    </div>
                </form:form>        
            </div>


            <!--                
                           
            
            
            
                    </div><!-- Main Col END -->

        </div><!-- body-row END -->
    </div><!-- container -->
</div>
