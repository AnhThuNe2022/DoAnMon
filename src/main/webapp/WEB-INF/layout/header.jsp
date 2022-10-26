<%-- 
    Document   : header
    Created on : Aug 10, 2022, 9:28:30 PM
    Author     : thu
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags" %>


<header id="header" class="fixed-top d-flex align-items-center header-transparent header-scrolled">
    <div class="container-fluid container-xl d-flex align-items-center justify-content-between">

        <div class="logo me-auto">


            <h1><a href="<c:url value = '/'/>">Lets Go!</a></h1>
            <!-- Uncomment below if you prefer to use an image logo -->
            <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
        </div>

        <nav id="navbar" class="navbar order-last order-lg-0">
            <ul>
                <li><a class="nav-link scrollto" href="#thongtin">Thông tin chúng tôi</a></li>
                <li><a class="nav-link scrollto" href="#tim">Tra cứu vé</a></li>

                <input type="hidden" id="flag-ghe" value="${flag}" > 

                <li class="dropdown"><a href="#"><span>Hotline</span> <i class="bi bi-chevron-down"></i></a>
                    <ul>
                        <li><a href="#">093845464</a></li>
                        <!--              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                                        <ul>
                                          <li><a href="#">Deep Drop Down 1</a></li>
                                          <li><a href="#">Deep Drop Down 2</a></li>
                                          <li><a href="#">Deep Drop Down 3</a></li>
                                          <li><a href="#">Deep Drop Down 4</a></li>
                                          <li><a href="#">Deep Drop Down 5</a></li>
                                        </ul>
                                      </li>
                                      <li><a href="#">Drop Down 2</a></li>
                                      <li><a href="#">Drop Down 3</a></li>-->
                        <li><a href="#">Drop Down 4</a></li>
                    </ul>
                </li>

                <!--cat dan vo day-->
                <!<!-- neu da dang xuat thi hien link dn,dk -->
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item" >
                        <a class="nav-link text-danger" href="<c:url value="/login"/>" class="book-a-table-btn scrollto">Đăng Nhập</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-danger" href="<c:url value="/register"/>" class="book-a-table-btn scrollto"></a>
                    </li>
                </sec:authorize>
                <!<!-- neu da dang nhap roi thi hien link logout -->
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/profile"/>">
                            <c:if test="${currentUser.avatar != null}">
                                    <img style="width:50px; height:30px;" src="${currentUser.avatar}" class="rounded-circle" />
                                </c:if>
                                <c:if test="${currentUser.avatar == null}">
                                    <i class="fa-solid fa-user"></i>
                                </c:if>
                            <sec:authorize access="hasRole('ROLE_KH')">
                                

                                ${pageContext.session.getAttribute("currentUser").khachhang.tenKH}

                            </sec:authorize>
                            <sec:authorize access="hasRole('ROLE_TX')">
                                ${pageContext.session.getAttribute("currentUser").taixe.tenTaiXe}
                            </sec:authorize>
                            <sec:authorize access="hasAnyRole('ROLE_AD','ROLE_NV')">
                                ${pageContext.session.getAttribute("currentUser").nhanvien.tenNV}
                            </sec:authorize>


                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/logout"/>" class="book-a-table-btn scrollto">Đăng xuất</a>
                    </li>





                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_KH')">
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/veCuaToi/veHienTai"/>">
                            Vé của tôi 
                        </a>
                    </li>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_TX')">
                    <li class="nav-item">
                        <a class="nav-link text-info" href="<c:url value="/taixe/"/>">
                            Các chuyến xe của tôi
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_AD')">
                    <li class="nav-item" >
                        <a class="nav-link text-primary" href="<c:url value="/admin/nhanvien"/>" class="book-a-table-btn scrollto">Quản Lí</a>
                    </li>
                </sec:authorize>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav><!-- .navbar -->



    </div>
</header>


