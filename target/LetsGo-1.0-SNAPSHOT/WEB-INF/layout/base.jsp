<%-- 
    Document   : base
    Created on : Aug 10, 2022, 9:28:13 PM
    Author     : thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
    <head>

        <meta charset="utf-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
        <!-- Favicons -->
  <link href=" <c:url value='/resources/assets/img/favicon.png' />" rel="icon">
  <link href="<c:url value='/resources/assets/img/apple-touch-icon.png' />" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->

  <link href="<c:url value='/resources/assets/vendor/animate.css/animate.min.css' />" rel="stylesheet">
  <link href="<c:url value='/resources/assets/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
  <link href="<c:url value='/resources/assets/vendor/bootstrap-icons/bootstrap-icons.css' />" rel="stylesheet">
  <link href="<c:url value='/resources/assets/vendor/boxicons/css/boxicons.min.css' />" rel="stylesheet">
  <link href="<c:url value='/resources/assets/vendor/lightbox/css/glightbox.min.css' />" rel="stylesheet">
  <link href="<c:url value='/resources/assets/vendor/swiper/swiper-bundle.min.css' />" rel="stylesheet">

  
  
  <!-- Template Main CSS File -->
  <link href="  <c:url value='/resources/assets/css/style.css' />" rel="stylesheet">
  
  <!-- Vendor JS Files -->
<script src="<c:url value='/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/resources/assets/vendor/glightbox/js/glightbox.min.js' />"></script>
<script src="<c:url value='/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js' />"></script>
<script src="<c:url value='/resources/assets/vendor/swiper/swiper-bundle.min.js' />"></script>
<script src="<c:url value='/resources/assets/vendor/php-email-form/validate.js' />"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>

<!-- Template Main JS File -->
<script src="<c:url value='/resources/assets/js/main.js' />"></script>

    <title><tiles:insertAttribute name="title" /></title>
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
</head>
<body>
    <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="content" />
    <tiles:insertAttribute name="footer" />
</body>
</html>