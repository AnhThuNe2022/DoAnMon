<%-- 
    Document   : admin
    Created on : Aug 13, 2022, 11:55:57 AM
    Author     : thu
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
    <!-- Bootstrap row -->
    <a href="admin.jsp"></a>
        <!-- Sidebar -->
        <div id="sidebar-container" class="sidebar-expanded d-none d-md-block" ><!-- d-* hiddens the Sidebar in smaller devices. Its itens can be kept on the Navbar 'Menu' -->
            <!-- Bootstrap List Group -->
            <ul class="list-group">
                <!-- Separator with title -->
                <li class="list-group-item sidebar-separator-title text-muted d-flex align-items-center menu-collapsed">
                    <small>QUẢN LÝ</small>
                </li>
                <!-- /END Separator -->
                <!-- Menu with submenu -->
                
                <sec:authorize access="hasRole('ROLE_TX')">
                    <a href="<c:url value ="/taixe/" />  "  data-toggle="collapse" aria-expanded="false" class=" bg-dark list-group-item list-group-item-action flex-column align-items-start ">
                    <div class=" d-flex w-100 justify-content-start align-items-center  ">
                        <span class="fa fa-dashboard fa-fw mr-3"></span> 
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp " >Các chuyến xe</span>
                        <span class="submenu-icon ml-auto"></span>
                    </div>
                </a>
                    
                </sec:authorize>
                
                
                
                
                <sec:authorize access="hasRole('ROLE_AD')">
                    
               

                <a href="<c:url value ="/admin/tuyenxe" />  "  data-toggle="collapse" aria-expanded="false" class=" bg-dark list-group-item list-group-item-action flex-column align-items-start ">
                    <div class=" d-flex w-100 justify-content-start align-items-center  ">
                        <span class="fa fa-dashboard fa-fw mr-3"><i class="bi bi-train-front"></i></span> 
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp " >Tuyến xe</span>
                        <span class="submenu-icon ml-auto"></span>
                    </div>
                </a>


                <!-- Submenu content -->
                <!--            <div id='submenu1' class="collapse sidebar-submenu">
                                <a href="#" class="list-group-item list-group-item-action bg-dark text-white">
                                    <span class="menu-collapsed">Charts</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action bg-dark text-white">
                                    <span class="menu-collapsed">Reports</span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action bg-dark text-white">
                                    <span class="menu-collapsed">Tables</span>
                                </a>
                            </div>-->
                <a href="<c:url value ="/admin/chuyenxe" />" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class=""><i class="bi bi-truck-front"></i> </span>
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp" style="padding-left: 2px"> Chuyến xe</span>
                        <span class="submenu-icon ml-auto"></span>
                    </div>
                </a>
                <!--             Submenu content 
                            <div id='submenu2' class="collapse sidebar-submenu">
                                <a href="#" class="list-group-item list-group-item-action bg-dark text-white">
                                    <span class="menu-collapsed"></span>
                                </a>
                                <a href="#" class="list-group-item list-group-item-action bg-dark text-white">
                                    <span class="menu-collapsed">Password</span>
                                </a>
                            </div>            -->
                <a href="<c:url value = "/admin/nhanvien"/>" class="bg-dark list-group-item list-group-item-action">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class=""></span>
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp">  <span class='bi bi-people-fill'></span>  Nhân viên</span>    
                    </div>
                </a>

                <!--
                ----------------------->


                <a href="<c:url value = "/admin/taixe"/>" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class="fa fa-user fa-fw mr-3"></span>
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp" >Tài xế công ty</span>
                        <span class="submenu-icon ml-auto"></span>
                    </div>
                </a>
                    
                     <a href="<c:url value = "/admin/user"/>" data-toggle="collapse" aria-expanded="false" class="bg-dark list-group-item list-group-item-action flex-column align-items-start">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class="fa fa-user fa-fw mr-3"></span>
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp" >User</span>
                        <span class="submenu-icon ml-auto"></span>
                    </div>
                </a>

                <!-- Separator with title -->
                <li class="list-group-item sidebar-separator-title text-muted d-flex align-items-center menu-collapsed">
                    <small>THỐNG KÊ</small>
                </li>
                <!-- /END Separator -->
                <a href="<c:url value = "/admin/thongke/matdo"/>" class="bg-dark list-group-item list-group-item-action ">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class="fa fa-calendar fa-fw mr-3"></span>
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp">Mật độ chuyến xe</span>
                    </div>
                </a>
                <a href="<c:url value = "/admin/thongke/doanhthu"/>" class="bg-dark list-group-item list-group-item-action">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class="fa fa-envelope-o fa-fw mr-3"><i class="bi bi-bar-chart-line"></i></span>
                        <span class="menu-collapsed btn-menu animate__animated animate__fadeInUp">Doanh thu</span>
                        <!--                    <span class="badge badge-pill badge-primary ml-2">5</span>-->
                    </div>
                </a>
                    
                    
                     </sec:authorize>

                <!-- Separator without title -->
                <li class="list-group-item sidebar-separator menu-collapsed"></li>            
                <!-- /END Separator -->
                <a href="#" class="bg-dark list-group-item list-group-item-action">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span class="fa fa-question fa-fw mr-3"></span>
                        <span class="menu-collapsed">Help</span>
                    </div>
                </a>
                <a href="#" data-toggle="sidebar-colapse" class="bg-dark list-group-item list-group-item-action d-flex align-items-center">
                    <div class="d-flex w-100 justify-content-start align-items-center">
                        <span id="collapse-icon" class="fa fa-2x mr-3"></span>
                        <span id="collapse-text" class="menu-collapsed">Collapse</span>
                    </div>
                </a>

            </ul><!-- List Group END-->
        </div><!-- sidebar-container END -->

  

