<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="referrer" content="no-referrer" />
	<link type="text/css" rel="stylesheet" href="/ami/css/ami.css" />
	<link type="text/css" rel="stylesheet" href="/ami/css/jquery-ui-1.12.1.css" />

	<script type="text/javascript" src="/ami/js/lib/jquery-3.4.1.js"></script>
	<script type="text/javascript" src="/ami/js/lib/jquery-ui-1.12.1.js"></script>
	<script type="text/javascript" src="/ami/js/lib/rsa/jsbn.js"></script>
	<script type="text/javascript" src="/ami/js/lib/rsa/rsa.js"></script>
	<script type="text/javascript" src="/ami/js/lib/rsa/prng4.js"></script>
	<script type="text/javascript" src="/ami/js/lib/rsa/rng.js"></script>
	<script type="text/javascript" src="/ami/js/init.js"></script>
	<script type="text/javascript" src="/ami/js/amiProxy.js"></script>
	<script type="text/javascript" src="/ami/js/amiConst.js"></script>
	<script type="text/javascript" src="/ami/js/account/account.js"></script>
</head>
<body>
	<div class="wrapper wrapper-login">
		<div class="login-container">
			<div class="login-box clearfix">
				<div class="float-left login-logo">
					<div class="logo">
						<img src="/ami/img/logo_home.png" width="230" height="40" alt="로고" />
					</div>
				</div>
				<!-- /float-left  -->
				<div class="float-left login-form" style="padding-top: 0px;">
					<div class="input-group clearfix">
						<h4 class="login-title"><fmt:message key="ami.common.join"/></h4>
						<div class="float-left clearfix ">
							<div class="login-input login-input-id">
								<input type="text" id="loginId" name="loginId" placeholder="<fmt:message key="ami.common.id"/>" required autofocus>
							</div>
							<div class="login-input login-input-pw">
								<input type="password" id="password" name="password" placeholder="<fmt:message key="ami.common.password"/>" required>
							</div>
							<div class="login-input login-input-pw">
								<input type="password" id="passwordCheck" name="passwordCheck" placeholder="<fmt:message key="ami.common.password.check"/>" required>
							</div>
							<div class="login-input login-input-id">
								<input type="text" id="name" name="name" placeholder="<fmt:message key="ami.common.name"/>" required>
							</div>
						</div>
						<div class="float-right ">
							<button type="button" class="login-input-btn" onclick="javascript:addAccount();"><fmt:message key="ami.common.ok"/></button>
						</div>
					</div>
					<!-- /login-form -->
				</div>
				<!-- /float-left  -->
			</div>
			<!-- /login-box  -->

			<div class="login-footer">
				<div class="login-footer-logo">
					<img src="/ami/img/logo_footer.png" width="130" height="30" alt="로고" />
				</div>
				<div class="login-footer-address">
					<div class="address">
						<p><fmt:message key="ami.product.company.address"/></p>
						<p><fmt:message key="ami.product.factory.address"/></p>
					</div>
					<!-- /address  -->
					<div class="copyright"><fmt:message key="ami.product.copyright"/></div>
				</div>
				<!-- /login-footer-address  -->
			</div>
			<!-- /login-footer  -->
		</div>
		<!-- /login-box  -->
	</div>
	<!-- /wrapper  -->
	<div style="display: none;">
		<input type="hidden" id="rsaPublicKeyModulus" value="${publicKeyModulus}" />
		<input type="hidden" id="rsaPublicKeyExponent" value="${publicKeyExponent}" />
	</div>
</body>