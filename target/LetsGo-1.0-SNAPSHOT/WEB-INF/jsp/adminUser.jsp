<%-- 
    Document   : adminUser
    Created on : Aug 21, 2022, 8:57:48 PM
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
                QUẢN LÝ USER
            </h3>



            <div class="container mt-4">
                <button  type="button" onclick="alertform('form-insert', 1);closebt('form-is');" style="background-color: #35322d" class="btn btn-primary"><span class='bi bi-person-plus'></span></button>



                <table class="table table-hover" style = "margin-top: 10px">
                    <thead>
                        <tr>
                            <th>Mã User</th>
                            <th>SĐT</th>
                            <th>Email</th>
                            <th>role</th>

                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach var="p" items="${ListUser}" >
                        <tbody>
                            <tr>
                                <td>${p.maUser}</td>
                                <td>${p.sdt}</td>                    

                                <td>${p.email}</td>
                                <td>${p.userRole}
                                </td>



                                <td>
                                    <div class="spinner-border text-warning"  id="loading${p.maUser}" style = "display:none"></div>
                                    <c:url value ="/api/admin/user/delete/${p.maUser}" var="del" /> 
                                    <button type="button" id="delete${p.maUser}" style="background-color: #dc3545" class="btn btn-primary" onclick="Fdelete('${del}', '${p.maUser}');" ><span  class="bi bi-trash"></span></button>
                                    <button type="button" id="edit${p.maUser}" style="background-color: #ffa012" class="btn btn-primary"   onclick="alertform('form-update', 1);updateUs('${p.maUser}')"><span class='bi bi-pencil-square'></span></button>
                                </td>
                            </tr>

                        </tbody>
                    </c:forEach>
                </table>


                <form action="<c:url value = "/admin/user/"/>" >
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


                    <c:url value ="/admin/user/add" var="addU"/>
                    <form:form id ='form-is' action="${addU}" method="post" enctype="multipart/form-data" modelAttribute="User" >
                        <div id ="form-insert" style="display: none" > 
                            <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                                <div class="box-formNV">
                                    <h3 style="margin: 15px;color: #ffffff" >Thêm User</h3>

                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="maUser" value="kk"  type="hidden" placeholder="Số Điện Thoại"/>

                                    </div>


                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="sdt" type="text" placeholder="Số Điện Thoại"/>
                                    </div>

                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="pass" type="text" placeholder="Password"/>
                                    </div>

                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="email" type="text" placeholder="Email"/>
                                    </div>


                                    <div class="textbox-admin"  >
                                        <i class="fas fa-user"></i>
                                        <form:select path="userRole" class ="sex">
                                            <option value="ROLE_NV">Nhân Viên</option>
                                            <option value="ROLE_TX">Tài Xế</option>
                                            <option value="ROLE_AD">Admin</option>

                                        </form:select>
                                    </div>

                                    <div class="textbox-admin"  >
                                        <i class="fas fa-user"></i>
                                        <form:input type="file" path="file" name="file" class="form-control" placeholder="Ảnh đại diện" data-rule="minlen:4" data-msg="Please enter at least 4 chars"/>   
                                    </div>


                                    <div class="button">
                                        <button id="send" style ="width: 50%; float: left" onclick="alertform('form-insert', 0)">Thêm</button>
                                        <button id="close" style ="width: 50%; float: right" onclick="alertform('form-insert', 0);return false">Close</button>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>


                <div>

                    <c:url value ="/admin/user/update" var="updateU"/>
                    <form:form  action="${updateU}" method="post" modelAttribute="User" >
                        <div id ="form-update" style="display: none" > 
                            <div class="container-formNV" style = "margin-top: 50px;background-color: #132644">
                                <div class="box-formNV">
                                    <h3 style="margin: 15px;color: #ffffff" >Cập Nhật User</h3>

                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="maUser" placeholder="Mã" id="Uma" readonly="true"/>

                                    </div>


                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="sdt" type="text" placeholder="Số Điện Thoại" id="Usdt"/>

                                    </div>



                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="email" type="text" placeholder="Email" id="Uemail"/>
                                    </div>
                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="pass" type="text" placeholder="Nhập Chỉ Khi muốn Thay Đổi Pass"/>
                                    </div>



                                    <div class="textbox-admin">
                                        <i class="fas fa-user"></i>
                                        <form:input path="userRole" type="text" placeholder="Role" readonly="true" id="Urole"/>
                                    </div>



       
                                    <div class="button">
                                        <button id="send" style ="width: 50%; float: left"  >Cập Nhật</button>
                                        <button id="close" style ="width: 50%; float: right" onclick="alertform('form-update', 0);return false">Close</button>

                                    </div

                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>







            </div><!-- Main Col END -->

        </div><!-- body-row END -->
    </div><!-- container -->
