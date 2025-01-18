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
  </tr>
  <c:forEach var="product" items="${list}">
    <tr>
       <td class="td_center">商品${product.p_id}</td>
       <td class="td_center"><img src="../image/${product.p_id}.jpg" height="96"></td>
       <td class="td_left">${product.name}</td>
       <td class="td_right">${product.price}</td>
       <td class="td_right">
         <form action="CartAdd.action" method="post">
           <input type="hidden" name="<%= Const.PARAM_ID %>" value="${product.p_id}"> 
           <select name="<%= Const.PARAM_COUNT %>" >
             <c:forEach begin="1" end="20" var="i">
               <option value="${i}" >${i}</option>
             </c:forEach>
           </select>
           <input type="submit" value="カートに追加">
         </form>
    </tr>
  </c:forEach>
</table>
<%@include file ="../footer.html" %>
<script type="text/javascript">
  // 検索欄にフォーカスを与える
  document.getElementById("search").focus();
</script>

<!--
プルダウン作成用 JavaScript案途中

<form id="quantityForm_${item.product.p_id}" onchange="updateQuantity(${product.p_id})" method="post">
 <select name="quantity" onchange="updateQuantity(${item.product.p_id})">
   <c:forEach begin="1" end="10" var="i">
     <option value="${i}" <c:if test="${i == item.count}">selected</c:if>>${i}</option>
   </c:forEach>
 </select>
<form>

<script> 
  function updateQuantity(productId) {
    document.getElementById('quantityForm_' + productId).submit();
  } 
</script>
 -->