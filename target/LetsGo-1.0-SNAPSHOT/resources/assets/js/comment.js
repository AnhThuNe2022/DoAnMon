/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




window.onload = function () {
    let date = document.querySelectorAll(".cmt > i")
    for (let i = 0; i < date.length; i++)
    {
        let d = date[i];
        d.innerText = moment(d.innerText).fromNow();
    }
}

function addComment(idcx)
{

    fetch("/LetsGo/api/addComment", {

        method: 'post',
        body: JSON.stringify({
            "content": document.getElementById("textcomment").value,
            "idCX": idcx

        }),
        headers: {
            "Content-Type": "application/json"
        }

    }).then(function (res) {
        return res.json();
    }).then(function (data) {
       
        let a = document.getElementById("List-comment");

        a.innerHTML = `
             <div class ="row">
             <div class ="col-md-2" style="padding: 10px">
                 <img class="rounded-circle img-fluid" src="${data.maUser.avatar}" >   
            </div>
             <div class="col-md-10 cmt">
                 <p><b>${data.maUser.khachhang.tenKH}</b></p>
                 <p>${data.content}</p>
                 <i>${moment(data.createDate).fromNow()}</i>
             </div>
       
             </div> ` + a.innerHTML
    
          document.getElementById("textcomment").value="";

    })
}

function getUrlne(i)
{

    document.getElementById("Hpage").value = i;
    document.getElementById("click").click();
}