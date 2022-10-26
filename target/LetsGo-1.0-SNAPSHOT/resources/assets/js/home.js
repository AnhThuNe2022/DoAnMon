/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function al()
{
    alert("ssss");
}

window.addEventListener('DOMContentLoaded', function() {
    if(document.getElementById("resultTT").value != null)
        alert("Thanh Toán Thành Công,Vào mục vé của tôi để xem vé đã đặt nhé!")
    
    
});
function trangThaiTT()
{
    alert("Thanh Toán Thành Công");
}

function getValueSearch()
{
       var valueop = document.getElementById("XuatPhat").value;
       var point = document.getElementById("DiemDenNe");
    fetch(`/LetsGo/api/search/${valueop}`).then(function (res) {
        return res.json();
    }).then(function (data) {
             point.length =data.length

        for(j = 0 ; j < data.length ; j++)
        {
           point.options[j].text = data[j].noiDen;
           

        }
    

        if(point.disabled == true){
            var today = getCurrentDate();
            document.getElementById("dateHome").value =today;
            document.getElementById("dateHome").min= today;
            document.getElementById("dateHome").disabled =false;
             point.disabled = false;
             

        }
            
    })
}


function getCurrentDate(){
    var date = new Date();

    var day = date.getDate();
    var month = date.getMonth() + 1;
    var year = date.getFullYear();

    if (month < 10) month = "0" + month;
    if (day < 10) day = "0" + day;

    var today = year + "-" + month + "-" + day; 
    return today;
}

function timVe()
{
       var valueFrom = document.getElementById("XuatPhat").value;
       var valueTo = document.getElementById("DiemDenNe").value;   
    fetch(`/LetsGo/api/search/maTX/${valueFrom}/${valueTo}`).then(function (res) {

        return res.json();
    }).then(function (data) {
        document.getElementById("maTX").value = data.maTuyenXe;
        d = document.getElementById("dateHome").value
        k = d.split('-')
        kq = k[2] + "-" + k[1] + "-" + k[0]
        document.getElementById("date").value = kq;
        document.getElementById("buttonForm").click();
    })
}

