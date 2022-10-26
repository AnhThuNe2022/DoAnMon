<%-- 
    Document   : adminNV
    Created on : Aug 17, 2022, 10:16:00 PM
    Author     : thu
--%>

<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script src="<c:url value='/resources/assets/js/admin.js' />"></script>
 <script src="<c:url value='/resources/assets/js/master.js' />"></script>

<!DOCTYPE html>

<div class="container-fluid p-0" style="margin-top: 70px">
    <div class="row" id="body-row">
        <%@ include file="admin.jsp" %>


        <!-- MAIN -->
        <div class="col" style="margin-top: 10px">

            <h3 style="text-align: center" >
                QUẢN LÝ NHÂN VIÊN
            </h3>
            
            
           
            <div class="container mt-4">
                <button  type="button" onclick="alertform('form-insert', 1);closebt('form-is');" style="background-color: #35322d" class="btn btn-primary"><span class='bi bi-person-plus'></span></button>
                 


                <table class="table table-hover" style = "margin-top: 10px">
                    <thead>
                        <tr>
                            <th>Mã NV</th>
                            <th>Tên NV</th>
                            <th>Ngày Sinh</th>
                            <th>Giới Tính</th>
                            <th>Địa Chỉ</th>
                            <th>CMND</th>
                            <th>Loại NV</th>
                            <th>Chứng Chỉ</th>
                            <th>User</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="p" items="${nv}" >
                        <tbody>
                            <tr>
                                <td>${p.maNV}</td>
                                <td>${p.tenNV}</td>
                                <td><fmt:formatDate pattern="dd/MM/yyyy" value ="${p.ngaySinh}"/></td>
                                <c:if test="${p.gioiTinh.toString() == '1'}" >
                                    <td>Nam</td>
                                </c:if>
                                <c:if test="${p.gioiTinh.toString() == '0'}" >
                                    <td>Nữ</td>
                                </c:if>

                                <td>${p.diaChi}</td>
                                <td>${p.cmnd}</td>
                                <td>${p.loaiNV.maLoaiNV}
                                </td>


                                <td>${p.chungChi}</td>
                                <td>${p.maUser.maUser}</td>

                                
                                
                                <td>
                                    <div class="spinner-border text-warning"  id="loading${p.maNV}" style = "display:none"></div>
                                    <c:url value ="/api/admin/nhanvien/delete/${p.maNV}" var="del" /> 
                                    <button type="button" id="delete${p.maNV}" style="background-color: #dc3545" class="btn btn-primary" onclick="Fdelete('${del}',${p.maNV});" ><span  class="bi bi-trash"></span></button>
                                    <button type="button" id="edit${p.maNV}" style="background-color: #ffa012" class="btn btn-primary"   onclick="alertform('form-update', 1);updateNV(${p.maNV});"><span class='bi bi-pencil-square'></span></button>
                                </td>
                            </tr>

                        </tbody>
                    </c:forEach>
                </table>

                
                <form action="<c:url value = "/admin/nhanvien/"/>" >
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
                 
                    <c:url value ="/admin/nhanvien/add" var="addNV"/>

                    <form:form id ='form-is' action="${addNV}" method="post" modelAttribute="Nhanvien" >
                        <div id ="form-insert" style="display: none" > 
                            <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                                <div class="box-formNV">
                                    <h3 style="margin: 15px;color: #ffffff" >Thêm Nhân Viên</h3>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="tenNV" type="text" placeholder="Tên nhân viên" />
                                    </div>
                                    <div class="textbox-admin"  >
                                        <i class="fas fa-user"></i>
                                        <form:select path="gioiTinh" class ="sex" style ="width: 50%; float: right">
                                            <option value="1">Nam</option>
                                            <option value="0">Nữ</option>
                                        </form:select>
                                        <input type="date" id="dt" value ="2001-10-18" style ="width: 50%; float: left" onchange=""/>
                                        <form:hidden path ="ngaySinh"  style ="width: 50%; float: left" id="ndt"/>
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
                                        <form:select path="loaiNhanVien" class ="sex"  >
                                            <c:forEach var ="l" items ="${loaiNV}" >
                                                <option value="${l.maLoaiNV}">${l.tenLoaiNV}</option>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="chungChi" type="text" placeholder="Chứng Chỉ" id="name"/>
                                    </div>


                                    
                                    
                                    <div class="button">
                                        <button id="send" style ="width: 50%; float: left" onclick="alertform('form-insert', 0);mydate1('dt', 'ndt');">Thêm</button>
                                        <button id="close" style ="width: 50%; float: right" onclick="alertform('form-insert', 0);return false">Close</button>
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

                <c:url  value ="/admin/nhanvien/update" var="updateNV"/>
                <form:form action="${updateNV}" method="post" modelAttribute="Nhanvien" >
                    <div id ="form-update" style="display: none" > 
                        <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                            <div class="box-formNV">
                                <h3 style="margin: 15px;color: #ffffff" >Cập Nhật Nhân Viên</h3>
                                <div class="textbox-admin">
                                    <i class="fas fa-user"></i>
                                    <form:input path="maNV" type="text" style ="width: 30%; float: left"   id="maNV" readonly="true"/>

                                    <form:input path="tenNV" type="text" style ="width: 70%; float: right" placeholder="Tên nhân viên" id="UtenNV"/>

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
                                    <form:select path="loaiNhanVien" class ="sex" id="UloaiNV" >
                                        <c:forEach var ="l" items ="${loaiNV}" >
                                            <option value="${l.maLoaiNV}">${l.tenLoaiNV}</option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                <div class="textbox-admin">
                                    <i class="fas fa-user"></i>
                                    <form:input path="chungChi" type="text" placeholder="Chứng Chỉ" id="Uchungchi"/>
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
                                
                                <form>
                                
                                <div class="button">
                                    <button id="send" style ="width: 50%; float: left"  onclick="mydate1('Udt', 'Undt');">Cập Nhật</button>
                                    <button id="close" style ="width: 50%; float: right" onclick="alertform('form-update', 0);return false">Close</button>

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



        </div><!-- Main Col END -->

    </div><!-- body-row END -->
</div><!-- container -->
