/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function randomcolor()
{
    let r = parseInt(Math.random()*255);
    let g = parseInt(Math.random()*255);
    let b = parseInt(Math.random()*255);
    return `rgb(${r},${g},${b})`
}


function thongKeDoanhThu(id, labelThongKe=[] ,dataThongKe=[]){
let colors = []
let colorborder =[]
for(let i = 0; i < dataThongKe.length;i++)
{
    colors.push(randomcolor())
    colorborder.push(randomcolor())

}
    const data = {
  labels:  labelThongKe,
  datasets: [{
    label: 'THỐNG KÊ DOANH THU',
    data: dataThongKe,
    backgroundColor: colors,
    borderColor:colorborder,
    borderWidth: 1
  }]
};
const config = {
  type: 'bar',
  data: data,
  options: {
    scales: {
      y: {
        beginAtZero: true
      }
    }
  },
};
 let c = document.getElementById(id).getContext("2d");
 new Chart(c,config);
}

function thongKeMatDo(id, labelThongKe=[] ,dataThongKe=[])
{
    let colors = []
for(let i = 0 ; i< dataThongKe.length;i++)
{
    colors.push(randomcolor())
}
    
    const data = {
  labels: labelThongKe ,
  datasets: [{
    label: 'Thống',
    data: dataThongKe,
    backgroundColor:colors ,
    hoverOffset: 3,
    options: {  
    responsive: true,
    maintainAspectRatio: false
}
  }]
};


    const config = {
  type: 'doughnut',
  data: data,
};
let c = document.getElementById(id).getContext("2d");
 new Chart(c,config);
    
}



function setValue(id,i)
{
    let d = document.getElementById(id);
    d.value = i;
}
function setY (){
    let d = document.getElementById("year");
    d.value = document.getElementById("selectY").value;
}