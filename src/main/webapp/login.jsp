<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="baseurl" value="${pageContext.request.contextPath}/"></c:set>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>优就业通用管理系统</title>
<link href="${baseurl}css/tloginstyle.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="sz_login">
<div class="admin_main">
<img src="${baseurl}img/img_02.jpg" width="327" height="85">
<img src="${baseurl}img/img_06.jpg" width="327" height="85">
<img src="${baseurl}img/img_07.jpg" width="327" height="84">
<img src="${baseurl}img/img_08.jpg" width="327" height="85">
<div class="cont">
<form action="${baseurl}login" method="post">
 
<table width="327" border="0">
  <tbody><tr height="46" align="center" valign="top">
    <td><h1>优就业通用管理系统</h1></td>
  </tr>
  <tr height="58">
    <td align="center" valign="top"><input type="text" class="user_input" maxlength="20" value="" size="20" name="username"></td>
  </tr>
  <tr height="40">
    <td align="center" valign="top"><input type="password" class="user_input" maxlength="32" value="" size="20" name="password"></td>
  </tr>
  <tr height="39">
    <td align="center"><p style="color: red">${msg} </p></td>
  </tr>
  <tr height="81">
    <td align="center"><input type="submit" class="button" value="登 陆" name="submit"></td>
  </tr>
</tbody></table>
</form>
</div>
<img src="${baseurl}img/img_10.jpg" width="327" height="122">
</div>
</div>

</body></html>