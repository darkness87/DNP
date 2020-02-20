<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="./include/include.jsp"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="Expires" content="1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="pragma" content="no-store">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
	<meta name="format-detection" content="telephone=no,email=no,address=no" />
	<meta name="author" content="pblee@cnuglobal.com" />
	<meta name="title" content="AMI" />
	<meta name="description" content="AMI" />
	<meta name="keywords" content="AMI" />
	<meta http-equiv="Content-Type" content="application/json; charset=UTF-8" />
	<%-- <meta http-equiv="Content-Type" content="application/xhtml+xml; charset=UTF-8" /> --%>

	<%-- <link rel="favicon" href="/ami/img/favicon.ico"> --%>
	<link type="text/css" rel="stylesheet" href="/ami/css/jquery-ui-1.12.1.css" />
	<link type="text/css" rel="stylesheet" href="/ami/css/ami.css" />
<%-- Library script --%>
	<script type="text/javascript" src="/ami/js/lib/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="/ami/js/lib/jquery-ui-1.12.1.js"></script>
	<script type="text/javascript" src="/ami/js/lib/jquery.history.js"></script>
<%-- Resource script --%>
	<script type="text/javascript" src="/ami/js/res/resController.js"></script>
	<script type="text/javascript" src="/ami/js/res/resString.jsp"></script>
<%-- AMI System --%>
	<script type="text/javascript" src="/ami/js/init.js"></script>
	<script type="text/javascript" src="/ami/js/amiProxy.js"></script>
	<script type="text/javascript" src="/ami/js/amiConst.js"></script>
	<script type="text/javascript" src="/ami/js/pageController.js"></script>
	<script type="text/javascript" src="/ami/js/menu.js"></script>
	<script type="text/javascript" src="/ami/js/common.js"></script>
	<script type="text/javascript" src="/ami/js/account/account.js"></script>
	<script type="text/javascript" src="/ami/js/equipment/equip.js"></script>
	<script type="text/javascript">
		$(document).ready( function () {
			initMenu();
			//var view = PAGE_CONTROLLER.showPopupPage("readPopup");
		});
	</script>

	<%-- <title><fmt:message key="ami.product.name"/></title> --%>
</head>
<body>
	<div class="wrapper">
		<!-- top navigation -->
		<div class="top_nav">
			<div class="logo">
				<a href="/ami/main">
					<img src="./img/logo_home.png" width="230" height="40" alt="<fmt:message key="ami.product.name"/>" />
				</a>
			</div>
			<ul class="user-menu">
				<li class="user-info">
					<i class="icon icon-user"></i>
					<strong id="name">${user.getUsername()}</strong> <fmt:message key="ami.common.name.respect"/>
				</li>
	
				<li class="user-logout">
					<a href="/ami/logout" class="btn-logout">
						<i class="icon icon-logout"></i> <fmt:message key="ami.common.logout"/>
					</a>
				</li>
			</ul>
		</div>
		<!-- /top navigation -->
		<!-- left menu -->
		<div id="menu" class="left-menu">
			<ul class="menu-list">
				<li id="equipment">
					<a href="equipment">
						<i class="icon icon-left-menu-01"></i><fmt:message key="ami.menu.equipment.management"/>
					</a>
				</li>
				<li id="meter">
					<a href="meter">
						<i class="icon icon-left-menu-02"></i><fmt:message key="ami.menu.meter.reading"/>
					</a>
				</li>
				<li id="fault">
					<a href="fault"><i class="icon icon-left-menu-03"></i><fmt:message key="ami.menu.fault.management"/></a>
				</li>
				<li id="">
					<a href=""><i class="icon icon-left-menu-04"></i><fmt:message key="ami.menu.tou"/></a>
				</li>
			</ul>
		</div>
		<!-- /sidebar menu -->
		<div id="mainBody" class="container container-dashboard">
			<%@include file="./dashboard.jsp"%>
		</div>
	</div>
	<!-- wrapper //-->
	<div id="body_pages" class="display_none">
		<%@include file="./topics.jsp"%>
	</div>
	<!-- 팝업창 javascript  $('.modal_wrapper').show();  -->
	<div id="popupBody" class="modal_wrapper">
		
	</div>
	<!-- / .modal_wrapper -->
</body>
</html>