<%-- 
    Document   : adminThongKe
    Created on : Aug 31, 2022, 1:43:04 PM
    Author     : thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value='/resources/assets/js/thongKe.js'/>"></script>
<%@taglib prefix="fmt" uri ="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<div class="container-fluid p-0" style="margin-top: 70px">
    <div class="row" id="body-row">
        <%@ include file="admin.jsp" %>


        <!-- MAIN -->
        <div class="col" style="margin-top: 10px">

            <h3 style="text-align: center" >
                THỐNG KÊ DOANH THU
            </h3>


            <form action="<c:url value = '/admin/thongke/doanhthu'/>">
                <input name="tk" id="tk" value="${type}" hidden >
                <input name="year" id="year" hidden >

                <button style ="margin-left: 50px" type="submit" class="btn btn-outline-success" onclick="setValue('tk',0)">Thống Kê Theo Tháng</button>
                <button style ="margin-left: 50px"type="submit" class="btn btn-outline-info" onclick="setValue('tk',1)">Thống Kê Theo Quý</button>
                <button style ="margin-left: 50px" type="submit" class="btn btn-outline-warning" onclick="setValue('tk',2)">Thống Kê Theo Năm</button> 

                <c:if test="${type == 0 || type == 1}">
                    <h4>Năm</h4> 
                    <select id="selectY">
                        <c:forEach items="${year}" var = "y">
                            <option >${y}</option>
                        </c:forEach>

                    </select>
                    <button style ="margin-left: 50px" type="submit" class="btn btn-outline-success" onclick="setY()">Xác Nhận</button>
                </c:if>
            </form>


            <br>

            <div class="container mt-4">
                <div>
                    <canvas id="thongKeDoanhThu"></canvas>
                </div>
                <br>
                <br>



                <div class="container" style="width: 50%;text-align: center" >

                    <table class="table table-hover" style = "margin-top: 10px">
                        <thead>
                            <tr>
                                <c:if test="${type == 0}">
                                    <th>Tháng</th>
                                </c:if>
                                <c:if test="${type == 2}">
                                    <th>Năm</th>
                                    </c:if>

                                <c:if test="${type == 1}">
                                    <th>Quý</th>
                                    </c:if>
                                <th>Doanh Thu</th>
                                <th>Hủy Vé</th>
                                <th>Doanh Thu Thực</th>

                            </tr>
                        </thead>

                        <c:forEach var="p" items="${doanhThu}" >
                            <tbody>
                                <tr>
                                    <td>${p.key}</td>
                                    
                                    <td><fmt:formatNumber value ="${p.value[0]}" maxFractionDigits="3" type ="number"/> </td>
                                    <td><fmt:formatNumber value ="${p.value[1]}" maxFractionDigits="3" type ="number"/> </td>
                                    <td><fmt:formatNumber value ="${p.value[0]-p.value[1]}" maxFractionDigits="3" type ="number"/> </td>

                                </tr>
                            </tbody>
                        </c:forEach>
                    </table>
                </div>





            </div>


            <!--                
                           
            
            
            
                    </div><!-- Main Col END -->

        </div><!-- body-row END -->
    </div><!-- container -->
</div>

<script>
    let labelThongKe = [], dataThongKe = [];dataHuyVe =[];
    <c:forEach var="p" items="${doanhThu}" >
        labelThongKe.push(${p.key});
        dataThongKe.push(${p.value[0]})
        dataHuyVe.push(${p.value[1]});

    </c:forEach>

    window.onload = function () {
        thongKeDoanhThu("thongKeDoanhThu", labelThongKe, dataThongKe,dataHuyVe);
        document.getElementById("selectY").value = ${nam}
    }
</script>

