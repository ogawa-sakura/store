<%@page import="tool.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file ="../header.html" %>
<%@include file ="menu.jsp" %>

<c:choose>
  <c:when test="${cart.size() > 0}">
    <p>カートには${cart.size()}種類の商品があります。</p>
    <table>
      <tr>
        <th class="td_center">商品番号</th>
        <th class="td_center">商品画像</th>
        <th class="td_center">商品名</th>
        <th class="td_center">値段</th>
        <th class="td_center">個数</th>
        <th class="td_left"></th>
      </tr>
      <c:forEach var="item" items="${cart}">
        <tr>
          <td class="td_center">${item.value.product.p_id}</td>
          <td class="td_center"><img src="../image/${item.value.product.p_id}.jpg" height="96" ></td>
          <td class="td_center">${item.value.product.name}</td>
          <td class="td_center">${item.value.product.price * item.value.count}円</td>
          <td class="td_center">
            <select name="<%= Const.PARAM_COUNT %>"  id="count_${item.value.product.p_id}" onchange="addToCart(${item.value.product.p_id}, ${item.value.count})">
              <c:forEach begin="1" end="20" var="i">
                    <option value="${i}" <c:if test="${i == item.value.count}">selected</c:if>>${i}</option>
              </c:forEach>
            </select>
          </td>
          <td class="td_left"><a href="CartRemove.action?id=${item.value.product.p_id}">カートから削除</a></td>
        </tr>
      </c:forEach>
      <tr>
        <td class="td_center"  colspan="3">合計</td>
        <td class="td_center" ><fmt:formatNumber value="${priceSum}" type="number" pattern="#,##0"/>円</td>
        <td class="td_right"> ${countSum}点 </td>
        <td class="td_left"><a href="CartRemove.action?id=${Const.SESSION_CART_DELETE}">カート内を全て削除</a></td>
      </tr>
    </table>
  </c:when>
  <c:otherwise>
    <p>カートに商品はありません。</p>
  </c:otherwise>
</c:choose>



<%@include file ="../footer.html" %>
<script type="text/javascript">
	//カート個数変更する関数
	function addToCart(productId, selectCount) {
		var count = document.getElementById('count_' + productId).value;
		var url = 'CartAdd.action?id=' + productId + '&count=' + (count) + '&change=1';
		window.location.href = url;
	}
</script>




