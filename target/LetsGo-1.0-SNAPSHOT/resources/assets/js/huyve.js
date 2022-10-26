/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function huyVe(endpoint)
{
    
var r = confirm("Bạn có Chắc chắn muốn hủy vé không?")
if(r == true){
    fetch(endpoint, {
        method: "post"
    }).then(function (res)
    {
        if (res.status === 204){
           alert("Hủy vé thành công!")
        location.reload();

        }
        else
            alert(res.status)
    }).catch(function (err)
    {
        console.error(err);
    });
}
    
}