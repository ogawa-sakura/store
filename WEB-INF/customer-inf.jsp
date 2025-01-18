<%@page import="tool.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@include file="../header.html"%>
<%@include file="../c25/menu.jsp"%>
<div>ID登録情報</div>
<table>
	<tr>
		<td>ログイン</td>
		<td>${customer.login}</td>
	</tr>
	<tr>
		<td>パスワード</td>
		<td>******</td>
	</tr>
	<tr>
		<td>メールアドレス</td>
		<td>${customer.email}</td>
	</tr>
	<tr>
		<td>姓　名</td>
		<td>${customer.l_name}　${customer.f_name}</td>
	</tr>
	<tr>
		<td>電話番号</td>
		<td>${customer.tel}</td>
	</tr>
	<tr>
		<td>郵便番号</td>
		<td>${customer.post_code}</td>
	</tr>
	<tr>
		<td>都道府県</td>
		<td>${customer.prefecture}</td>
	</tr>
	<tr>
		<td>市町村</td>
		<td>${customer.city}</td>
	</tr>
	<tr>
		<td>その他住所</td>
		<td>${customer.o_address}</td>
	</tr>
</table>

<c:choose>
  <c:when test="${purchase_list.size() > 0}">
    <p>注文履歴</p>
    <table class	="width_table">
      <tr>
        <th class="td_center">注文番号</th>
        <th class="td_center">注文日時</th>
        <th class="td_center">商品ID</th>
        <th class="td_center">商品名</th>
        <th class="td_center">合計金額</th>
        <th class="td_center">購入数</th>
        <th class="td_center" >送付先名</th>
        <th class="td_center" >送付先住所</th>

      </tr>
      <c:forEach var="item" items="${purchase_list}">
        <tr>
          <td class="td_center">${item.order_id}</td>
          <td class="td_center">${item.ins_datetime}</td>
          <td class="td_center">${item.p_id}</td>
          <td class="td_center">${item.name}</td>
          <td class="td_center">${item.sum_price}</td>
          <td class="td_center">${item.order_count}</td>
          <td class="td_center">${item.send_name}</td>
          <td class="td_center">${item.send_address}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <p>注文履歴はありません。</p>
  </c:otherwise>
</c:choose>


<%@include file="../footer.html"%>
