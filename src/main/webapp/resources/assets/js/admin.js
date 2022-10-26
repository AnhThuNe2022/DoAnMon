/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function alertform(id, i) {
    let k = document.getElementById(id);
    if (i == 1)
    {
        k.style.display = "block";
    } else if (i == 0) {
        k.style.display = "none";
    }

}

function closebt(id)
{
    document.getElementById(id).reset();

}

function mydate1(id1, id2) {

    d = new Date(document.getElementById(id1).value);
    dt = d.getDate();

    mn = d.getMonth();
    mn++;
    yy = d.getFullYear();

    document.getElementById(id2).value = dt + "/" + mn + "/" + yy
}


function mydatetime(id1, id2) {
    d = new Date(document.getElementById(id1).value);
    dt = d.getDate();
    mn = d.getMonth();
    mn++;
    HH = d.getHours();
    yy = d.getFullYear();
    mm = d.getMinutes();

    document.getElementById(id2).value = dt + "/" + mn + "/" + yy + " " + HH + ":" + mm;
}

function setValueDateTime(id)
{
    var now = new Date();
    now.setMinutes(now.getMinutes() - now.getTimezoneOffset());
    document.getElementById(id).value = now.toISOString().slice(0, 16);
    document.getElementById(id).min = now.toISOString().slice(0, 16);
}

function checkValueDateTime(id1, id2)
{
    let d1 = document.getElementById(id1).value;
    let d2 = document.getElementById(id2).value;
    if (d1 > d2)
    {
        alert("Ngày khởi hành không được xa hơn ngày về");
        setValueDateTime(id1);
        setValueDateTime(id2);
    }
}

function checkTaiXe(id1, id2)
{
    tx1 = document.getElementById(id).value;
    tx2 = document.getElementById(id).value;

    if (tx1 == tx2)
    {
        alert("Không được trùng tài xế chính và phụ");
//       document.getElementById(id).value = ""
    }


}



function Fdelete(endpoint, id)
{
    var p;
    var ob =  new Array(
    "nhanvien",
    "taixe",
    "chuyenxe",
    "tuyenxe",
    "user"
    )
    var kq=new Array(
    "Nhân Viên",
    "Tài Xế",
    "Chuyến Xe",
    "Tuyến Xe",
    "Người Dùng"
    )
    for(let i = 0 ; i < ob.length ;i++)
    {
         if(endpoint.includes(ob[i])){
             p = kq[i]
             break
         }
    }

    
   
    var r = confirm("Bạn Có Muốn Xóa "+ p +" Mã " + id + " Không?");
    if (r == true)
    {
        let d = document.getElementById("loading" + id);
        let p = document.getElementById("delete" + id);
        let q = document.getElementById("edit" + id);
        d.style.display = "block";
        p.style.display = "none";
        q.style.display = "none";

        fetch(endpoint, {
            method: "delete"
        }).then(function (res)
        {

            if (res.status === 204)
            {
                location.reload();
            } else
                alert(res.status)
        }).catch(function (err)
        {
            console.error(err);
        });
        d.style.display = "none";
    }


}

function updateNV(id) {
    fetch(`/LetsGo/api/admin/nhanvien/${id}`, {
        method: "POST"}).then(function (res) {
        return res.json();
    }).then(function (data) {
        document.getElementById("maNV").value = data.maNV;
        document.getElementById("UtenNV").value = data.tenNV;
        document.getElementById("Usex").value = data.gioiTinh;

        let d = new Date(data.ngaySinh);
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

        document.getElementById("Udt").value = kq;
        document.getElementById("Udiachi").value = data.diaChi;
        document.getElementById("Ucmnd").value = data.cmnd;
        document.getElementById("UloaiNV").value = data.loaiNV.maLoaiNV;
        document.getElementById("Uchungchi").value = data.chungChi;

//        var role;
//
//        if (data.loaiNV.maLoaiNV == 1)
//            role = "AD"
//        else if (data.loaiNV.maLoaiNV == 2)
//            role = "NV"

        op = document.getElementById("optionNV");
        if (data.maUser != null)
        {

            maUser = data.maUser.maUser;

            op.value = maUser;
            op.textContent = maUser;
            document.getElementById("Uuser").value = data.maUser.maUser;
            op.disabled = false;

        } else {

            op.disabled = true;
            op.value = "";
            op.textContent = "";
            document.getElementById("Uuser").value = "null";
        }






//        document.getElementById("Uuser").value = data.maUser.maUser;


    })

}


function checkTime(i)
{
    if (i < 10) {
        i = "0" + i;
    }
    return i;
}

function updateCX(id) {

    fetch(`/LetsGo/api/admin/chuyenxe/${id}`, {
        method: "POST"}).then(function (res) {
        return res.json();

    }).then(function (data) {
        document.getElementById("maCX").value = data.maChuyenXe;

        document.getElementById("maTuyenXe").value = data.maTuyenXe.maTuyenXe;
        document.getElementById("maXe").value = data.maXe.maXe;
        document.getElementById("giaVeNe").value = data.giaVe;

        var d = new Date(data.gioXuatPhat);
        var dt = d.getDate();
        var mn = d.getMonth();
        mn++;
        mn = mn.toString();
        var HH = d.getHours();
        var yy = d.getFullYear();
        var mm = d.getMinutes();

        if (dt < 10)
            dt = '0' + dt;
        if (mn < 10)
            mn = '0' + mn;
        if (HH < 10)
            HH = '0' + HH;
        if (mm < 10)
            mm = '0' + mm;
        var kq1 = yy + '-' + mn + '-' + dt + 'T' + HH + ":" + mm;




        var d2 = new Date(data.gioDen);
        var dt2 = d2.getDate();
        var mn2 = d2.getMonth();
        mn2++;
        var HH2 = d2.getHours();
        var yy2 = d2.getFullYear();
        var mm2 = d2.getMinutes();

        if (dt2 < 10)
            dt2 = '0' + dt2;
        if (mn2 < 10)
            mn2 = '0' + mn2;
        if (HH2 < 10)
            HH2 = '0' + HH2;
        if (mm2 < 10)
            mm2 = '0' + mm2;
        var kq2 = yy2 + '-' + mn2 + '-' + dt2 + 'T' + HH2 + ":" + mm2;


        document.getElementById("UGioXP").value = kq1;
        document.getElementById("UGioDen").value = kq2;

        if (data.maTaiXeChinh == null)
        {
            document.getElementById("taiXeChinh").value = "";
        } else
        {
            document.getElementById("taiXeChinh").value = data.maTaiXeChinh.maTaiXe;

        }

        if (data.maTaiXePhu == null)
        {
            document.getElementById("taiXePhu").value = "";
        } else
        {
            document.getElementById("taiXePhu").value = data.maTaiXePhu.maTaiXe;

        }

//      document.getElementById("giaVeNe").value = data.trangThai


    })

}

function updateTuyenXe(id) {
    fetch(`/LetsGo/api/admin/tuyenxe/${id}`, {
        method: "POST"}).then(function (res) {

        return res.json();

    }).then(function (data) {
        document.getElementById("MaTX").value = data.maTuyenXe
        document.getElementById("SoGio").value = data.soGio;
        document.getElementById("SoKM").value = data.soKm;
        document.getElementById("Den").value = data.noiDen;
        document.getElementById("NoiKH").value = data.noiKhoiHanh;

    })


}

function updateTX(id) {


    fetch(`/LetsGo/api/admin/taixe/${id}`, {
        method: "POST"}).then(function (res) {
        return res.json();
    }).then(function (data) {

        document.getElementById("maTX").value = data.maTaiXe
        document.getElementById("UtenTX").value = data.tenTaiXe;
        document.getElementById("Usex").value = data.gioiTinh;
        document.getElementById("UloaiTX").value = data.loaitx;

        let d = new Date(data.ngaySinh);
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

        document.getElementById("Udt").value = kq;
        document.getElementById("Udiachi").value = data.diaChi;
        document.getElementById("Ucmnd").value = data.cmnd;
        document.getElementById("UmaBang").value = data.maBangLaiXe;
        op = document.getElementById("optionNV");
        if (data.maUser != null)
        {

            maUser = data.maUser.maUser;
            op.value = maUser;
            op.textContent = maUser;
            document.getElementById("Uuser").value = data.maUser.maUser;
            op.disabled = false;

        } else {

            op.disabled = true;
            op.value = "";
            op.textContent = "";
            document.getElementById("Uuser").value = "null";
        }


    })


}


function updateUs(id) {

    fetch(`/LetsGo/api/admin/user/${id}`, {
        method: "POST"}).then(function (res) {
        return res.json();


    }).then(function (data) {
        document.getElementById("Uma").value = data.maUser;
        document.getElementById("Usdt").value = data.sdt;

        document.getElementById("Uemail").value = data.email;
        document.getElementById("Urole").value = data.userRole;


    })


}

function getUrlne(i)
{

    document.getElementById("Hpage").value = i;
    document.getElementById("click").click();
}




