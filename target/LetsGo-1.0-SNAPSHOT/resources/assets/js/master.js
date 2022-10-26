/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.onload = function () {


    if (window.location.href.indexOf('thanhtoan') > -1)
    {
        var fiveMinutes = 15;
        display = document.querySelector('#time');
        startTimer(fiveMinutes, display);
    } else {

//        if(window.location.href.indexOf('chitiet') > -1)
//        {
//            if(document.getElementById("messchitiet").value == 1)
//                alert("Ghế của quý khách chọn đã có người đặt! Vui lòng chọn ghế khác")
//        }
         if (window.location.href.indexOf('timve') > -1)
        {
          setDateNe('hdDate','dateHomeNe');
          setMinDate('dateHomeNe')

        }
       
        k = document.getElementById("flag-ghe").value;
        if (k == 1)
        {
            updateTTFalse();
        }

    }
};


function setDateNe(id1,id2)
{
    d = document.getElementById(id1).value
    k = d.split('-')
    kq = k[2] + "-" + k[1] + "-" + k[0]
    document.getElementById(id2).value = kq;
}


function setMinDate(id)
{
    var d = new Date();
    dt = d.getDate();
    mn = d.getMonth();
    mn++;
    yy = d.getFullYear();
    var kq;
    if (dt < 10)
    {
        kq = yy + "-" + mn + "-0" + dt
        if (mn < 10)
            kq = yy + "-0" + mn + "-0" + dt
    } else if (mn < 10)
        kq = yy + "-0" + mn + "-" + dt
    else
        kq = yy + "-" + mn + "-" + dt
    k = document.getElementById(id);
 
    k.min = kq;
}



function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    var timeoutID = setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);
        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            alert("Đã quá thời gian đặt chỗ");
            updateTTFalse();
            clearTimeout(timeoutID);
        }
    }, 1000);
}



function updateTTFalse()
{
    fetch("/LetsGo/api/hoadon/chuyenTT", {
        method: "post"

    }).then(function (res)
    {


        if (res.status === 204)
            window.location.href = "/LetsGo";
        else
            alert("Có lỗi xảy ra");

    }).catch(function (err)
    {
        console.error(err);
    });
}






