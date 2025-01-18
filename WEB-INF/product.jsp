<%@page import="tool.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file ="../header.html" %>
<%@include file ="menu.jsp" %>

<p>検索キーワードを入力してください。</p>
<form action="Product.action" method="post">
  <input type="text" name="keyword" value="${param.keyword}" id="search">
  <input type="submit" value="検索">
</form>
<hr>

<table>
  <tr>
    <th class="td_center">商品番号</th>
    <th class="td_center">商品画像</th>
    <th class="td_center">商品名</th>
    <th class="td_center">値段</th>
    <th class="td_center">個数</th>
    <th class="td_center"></th>
  </tr>
  <c:forEach var="product" items="${list}">
    <tr>
       <td class="td_center">商品${product.p_id}</td>
       <td class="td_center"><img src="../image/${product.p_id}.jpg" height="96" ></td>
       <td class="td_center">${product.name}</td>
       <td class="td_right">${product.price}</td>
       <td class="td_right">
           <select name="<%= Const.PARAM_COUNT %>"  id="count_${product.p_id}">
             <c:forEach begin="1" end="20" var="i">
               <option value="${i}" >${i}</option>
             </c:forEach>
           </select>
        <td class="td_center"><a href="#" onclick="addToCart(${product.p_id})">カートに追加</a></td>
    </tr>
  </c:forEach>
</table>
<%@include file ="../footer.html" %>
<script type="text/javascript">
	// 検索欄にフォーカスを与える
	document.getElementById("search").focus();
	
	//カートに追加する関数
	function addToCart(productId) {
		// メッセージを表示 
		var messageWindow = window.open("", "messageWindow", "width=200,height=200");
		messageWindow.document.write("<p>カートに追加しました</p><img  height='96' src='../image/" + productId + ".jpg'>");
		// 1.5秒後にウィンドウを閉じる 
		setTimeout(function() {
			messageWindow.close();
			// リダイレクトを行う 
			var count = document.getElementById('count_' + productId).value;
			var url = 'CartAdd.action?id=' + productId + '&count=' + count + '&change=0';
			window.location.href = url;
		}, 1500);
	}
</script>

