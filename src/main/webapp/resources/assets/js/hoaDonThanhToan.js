/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);
        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
             alert("Đã quá thời gian đặt chỗ");
            updateTTFalse();
           
        }
    }, 1000);
}

window.onload = function () {
    var fiveMinutes = 15;
    display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};


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
