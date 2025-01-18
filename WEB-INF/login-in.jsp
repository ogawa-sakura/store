<%@page import="tool.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="../header.html"%>
<%@include file="../c25/menu.jsp"%>

<form action="Login.action" method="post">
	<div>
		<label for="login">ログイン名</label> 
		<input id="login" type="text" name="<%= Const.PARAM_LOGIN %>" value="${param.login}">
	</div>
	<div>
		<label for="pass">パスワード</label>
		<input id="pass" type="password" name="<%= Const.PARAM_PASSWORD %>" value="${param.password}">
	</div>
	<div>新規登録は<a href="register.jsp">こちら</a>から</div>
	<input type="submit" value="ログイン">
</form>
<c:forEach var="errorList" items="${errorList}">
	<div class="color_red">${errorList}</div>
</c:forEach>

<script type="text/javascript">
  // ログイン欄にフォーカスを与える
  document.getElementById("login").focus();
</script>
<%@include file="../footer.html"%>
