<%-- 
    Document   : adminThongKeMatDo
    Created on : Aug 31, 2022, 4:44:08 PM
    Author     : thu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value='/resources/assets/js/thongKe.js'/>"></script>

<!DOCTYPE html>

<div class="container-fluid p-0" style="margin-top: 70px">
    <div class="row" id="body-row">
        <%@ include file="admin.jsp" %>


        <!-- MAIN -->
        <div class="col" style="margin-top: 10px">

            <h3 style="text-align: center" >
                THỐNG KÊ MẬT ĐỘ CHUYẾN XE
            </h3>
             
           
            
           
 <br>
               
        <div class="container mt-4" style="position: relative;height: 3000px">
                <div style="width:50%;margin-left: 250px" >
                    <canvas id="thongKeMatDo"></canvas>
                </div>
                 <br>
                <br>

                <div class="container" style="width: 50%;text-align: center" >

                    <table class="table table-hover" style = "margin-top: 10px">
                        <thead>
                            <tr>
                                <th>Tên Tuyến</th>
                                <th>Số Chuyến</th>

                            </tr>
                        </thead>

                        <c:forEach var="p" items="${matDo}" >
                            <tbody>
                                <tr>
                                    <td>${p[0]}</td>
                                    <td>${p[1]}</td>
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
                 let labelThongKe=[] ,dataThongKe=[];
                    <c:forEach var="p" items="${matDo}" >
                            labelThongKe.push('${p[0]}');
                            dataThongKe.push(${p[1]});
                        </c:forEach>
            
            
            window.onload = function(){
                thongKeMatDo("thongKeMatDo",labelThongKe,dataThongKe);
            }
            
        </script>
        