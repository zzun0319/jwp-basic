<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>SLiPP Java Web Programming</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="<c:url value='/jwp-basic/webapp/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/jwp-basic/webapp/css/styles.css' />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-fixed-top header">
	    <div class="col-md-12">
	        <div class="navbar-header">
	
	            <a href="/" class="navbar-brand">SLiPP</a>
	            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse1">
	                <i class="glyphicon glyphicon-search"></i>
	            </button>
	
	        </div>
	        <div class="collapse navbar-collapse" id="navbar-collapse1">
	            <form class="navbar-form pull-left">
	                <div class="input-group" style="max-width:470px;">
	                    <input type="text" class="form-control" placeholder="Search" name="srch-term" id="srch-term">
	                    <div class="input-group-btn">
	                        <button class="btn btn-default btn-primary" type="submit"><i class="glyphicon glyphicon-search"></i></button>
	                    </div>
	                </div>
	            </form>
	            <ul class="nav navbar-nav navbar-right">
	                <li>
	                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-bell"></i></a>
	                    <ul class="dropdown-menu">
	                        <li><a href="https://slipp.net" target="_blank">SLiPP</a></li>
	                        <li><a href="https://facebook.com" target="_blank">Facebook</a></li>
	                    </ul>
	                </li>
	                <li><a href="../user/list.html"><i class="glyphicon glyphicon-user"></i></a></li>
	            </ul>
	        </div>
	    </div>
	</nav>
	<div class="navbar navbar-default" id="subnav">
	    <div class="col-md-12">
	        <div class="navbar-header">
	            <a href="#" style="margin-left:15px;" class="navbar-btn btn btn-default btn-plus dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-home" style="color:#dd1111;"></i> Home <small><i class="glyphicon glyphicon-chevron-down"></i></small></a>
	            <ul class="nav dropdown-menu">
	                <li><a href="../user/profile.html"><i class="glyphicon glyphicon-user" style="color:#1111dd;"></i> Profile</a></li>
	                <li class="nav-divider"></li>
	                <li><a href="#"><i class="glyphicon glyphicon-cog" style="color:#dd1111;"></i> Settings</a></li>
	            </ul>
	        </div>
	        <div class="collapse navbar-collapse" id="navbar-collapse2">
	            <ul class="nav navbar-nav navbar-right">
	                <c:choose>
	                	<c:when test="${empty sessionScope.user}">
	                		<li><a href="/user/login" role="button">로그인</a></li>
	                		<li><a href="../user/form.html" role="button">회원가입</a></li>
	                	</c:when>
	                	<c:otherwise>
	                		<li><a href="/user/logout" role="button">로그아웃</a></li>
	               			 <li><a href="/user/edit?userId=${sessionScope.user.userId}" role="button">개인정보수정</a></li>
	                	</c:otherwise>
	                </c:choose>
	            </ul>
	        </div>
	    </div>
	</div>
</body>
</html>