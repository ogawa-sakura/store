<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="../c25/Product.action">商品</a>
<a href="../c25/cart.jsp">カート</a>
<a href="../c25/Preview.action">購入</a>
<a href="../c24/login-in.jsp">ログイン</a>
<a href="../c24/logout-in.jsp">ログアウト</a>

<span style="float: right;">
	<c:choose>
		<c:when test="${not empty countSum}"> 合計：${countSum}点　 </c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${not empty priceSum}"> ${priceSum}円　</c:when>
		<c:otherwise></c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${not empty customer.login}"> <a href="../c24/CustomerInf.action">${customer.login}さん</a> </c:when>
		<c:otherwise>ご注文するには<a href="../c24/login-in.jsp">ログイン</a>してください</c:otherwise>
	</c:choose>
</span>
<hr>