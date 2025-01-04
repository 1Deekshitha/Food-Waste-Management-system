<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">
<head>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>
.container{
height:80vh;
width;100%;
display:flex;
align-items:center;
justify-content:center;
}
button{
font-size:20px;
font-family:cursive;
border:10px;
border-color:white;
width:250px;
outline:10px;
padding:20px 12px;
border-radius:10px;
background-color:#8B008B;
color:white;
align:center;
cursor:pointer;
}

button:hover {
  background-color: #9932CC;
}
body
{
background:linear-gradient(purple,red);

}
</style>
</head>
<body>
<button type="button" onclick="window.location.href='tab.html'"><i class="fa fa-home" aria-hidden="true"></i>HOME</button>
<div class="container">
<button type="button" onclick="window.location.href='home.html'"><i class="fa fa-cutlery" aria-hidden="true"></i>     UPLOAD FOOD<br> DETAILS</button>
<br><br>
<button type="button" onclick="window.location.href='hom.html'"><i class="fa fa-list" aria-hidden="true"></i>       AVAILABLE FOOD<br> LIST</BUTTON>
</div>
</body>
</html>
    