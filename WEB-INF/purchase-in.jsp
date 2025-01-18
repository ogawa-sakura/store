<%@page import="tool.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@include file ="../header.html" %>
<%@include file ="menu.jsp" %>

<p>カートには${cart.size()}種類の商品があります。</p>
<table>
  <tr>
    <th class="td_center">商品番号</th>
    <th class="td_center">商品画像</th>
    <th class="td_center">商品名</th>
    <th class="td_center">値段</th>
    <th class="td_center">個数</th>
  </tr>
  <c:forEach var="item" items="${cart}">
    <tr>
      <td class="td_center">${item.value.product.p_id}</td>
      <td class="td_center"><img src="../image/${item.value.product.p_id}.jpg" height="96"></td>
      <td class="td_center">${item.value.product.name}</td>
      <td class="td_center">${item.value.product.price * item.value.count}円</td>
      <td class="td_center">${item.value.count}個</td>
    </tr>
  </c:forEach>
  <tr>
    <td class="td_right"  colspan="3">合計</td>
    <td class="td_center" ><fmt:formatNumber value="${priceSum}" type="number" pattern="#,##0"/>円</td>
    <td class="td_center" >${countSum}点</td>
  </tr>
</table>
<hr>
<div class="small">※登録情報とは別住所に送付する場合、名前住所を入力してください</div>
<form id="purchaseForm" action="Purchase.action" method="post" >
  <div>お名前 <input type="text" name="<%= Const.PARAM_NAME %>" value="${customer.l_name}${customer.f_name}" id="<%= Const.PARAM_NAME %>"></div>
  <div>ご住所 <input type="text" name="<%= Const.PARAM_ADDRESS %>" value="${customer.prefecture}${customer.city}${customer.o_address}" id="<%= Const.PARAM_ADDRESS %>"></div>
  <div><input type="submit" value="購入を確定"></div>
  <input type="hidden" name="<%= Const.PARAM_PURCHASE_CONFIRM %>" value="${confirm != null ? confirm : 'N'}" id="<%= Const.PARAM_PURCHASE_CONFIRM %>">
</form>

<c:forEach var="purchaseErrorList" items="${purchaseErrorList}">
	<div class="color_red">${purchaseErrorList}</div>
</c:forEach>

<script type="text/javascript">
	// 名前欄にフォーカスを与える
	document.getElementById("name").focus();
	
	// コンファームフラグがある場合、ページ表示時に購入確認ポップアップ表示
	window.addEventListener("load", function() {
		setTimeout(function() {
			var confirmValue = document.getElementById("confirm").value;
			// PurchaseActionで入力欄チェック済か
			if (confirmValue === 'Y') {
				if (confirm("購入を確定しますか？")) {
					// フォームを送信 
					document.getElementById("purchaseForm").submit(); 
					document.getElementById("confirm").value = "N";
				} else {
				// キャンセル時にコンファームフラグをクリア
				document.getElementById("confirm").value = "N";
				}
			} 
		}, 100); // 背景画面更新のため100ミリ秒待機
	});
	
	
	/** フロントのみで名前住所チェック時 
	function validateForm() {
		var name = document.getElementById("name").value;
		var address = document.getElementById("address").value;
		if (name === "" || address === "") {
			 alert("お名前とご住所を入力してください。");
			return false;
		}
		return confirm("購入を確定しますか？");
	}
	*/
	
</script>
<%@include file ="../footer.html" %>
