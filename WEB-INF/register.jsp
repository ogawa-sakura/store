<%@page import="tool.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../header.html"%>
<%@include file="../c25/menu.jsp"%>

<div>IDとパスワードを新規登録します</div>
<div class="color_green">ログイン名パスワードは6文字以上・半角英数字と記号(-_.のみ使用可)を少なくても一つは含む組み合わせで入力してください。</div>
<p></p>
<form action="Register.action" method="post">
	<div>
		<label for="login">ログイン名</label> 
		<input id="login" type="text" name="<%= Const.PARAM_LOGIN %>" value="${param.login}">
	</div>
	<div>
		<label for="pass">パスワード</label>
		<input id="pass" type="password" name="<%= Const.PARAM_PASSWORD %>" value="${param.password}">
	</div>	
	<div>
		<label for="email">メールアドレス</label>
		<input id="email" type="text" name="<%= Const.PARAM_EMAIL %>" value="${param.email}">
	</div>	
	<div>
		<label for="l_name">姓</label>
		<input id="l_name" type="text" name="<%= Const.PARAM_L_NAME %>" value="${param.l_name}">
		<label for="f_name">名</label>
		<input id="f_name" type="text" name="<%= Const.PARAM_F_NAME %>" value="${param.f_name}">
	</div>
	<div>
		<label for="tel">電話番号（数字のみ）</label>
		<input id="tel" type="text" name="<%= Const.PARAM_TEL %>" value="${param.tel}">
	</div>
	<div>
		<label for="post_code">郵便番号（数字のみ）</label>
		<input id="post_code" type="text" name="<%= Const.PARAM_POST_CODE %>" value="${param.post_code}">
	</div>
	<div>
		<label for="prefecture">都道府県</label>
		<select id="prefecture" name="<%= Const.PARAM_PREFECTURE %>" >
			<option value="北海道"<c:if test="${i == param.prefecture}">selected</c:if>>北海道</option>
			<option value="福岡"<c:if test="${i == param.prefecture}">selected</c:if>>福岡</option>
			<option value="東京都"<c:if test="${i == param.prefecture}">selected</c:if>>東京都</option>
		</select>
	</div>
	<div>
		<label for="city">市町村</label>
		<input id="city" type="text" name="<%= Const.PARAM_CITY %>" value="${param.city}">
	</div>
	<div>
		<label for="o_address">その他住所</label>
		<input id="o_address" type="text" name="<%= Const.PARAM_O_ADDRESS %>" value="${param.o_address}">
	</div>
	
	
	<input type="submit" id="registerBtn" value="登録" disabled>
</form>
<c:forEach var="registerErrorList" items="${registerErrorList}">
	<div class="color_red">${registerErrorList}</div>
</c:forEach>

<div class="color_red" id="agreeMessege">※利用規約に同意いただき登録お願いします。</div>
<!-- モーダルウィンドウを開くボタン --> 
<button onclick="openTerms()">利用規約を表示</button>

<!-- モーダルウィンドウのHTML --> 
<div id="termsModal" class="modal"> 
  <div class="modal-content">
    <span class="close">&times;</span>
    <h5>利用規約</h5>
    <div id="termsContent" style="height: 200px; overflow-y: scroll; border: 1px solid #ccc; padding: 10px;">
      <p>寿司オンライン会員は、本サービスの利用にあたり、以下各号のいずれかに該当する行為を行ってはならないものとします。</p>
      <ol>
        <li>本規約に違反する行為</li>
        <li>不正に第三者の本アカウントを利用する行為</li>
        <li>虚偽の情報を登録または提供することで、第三者（架空の第三者を含みます）になりすます行為</li>
        <li>一つの本アカウントを複数人で利用する行為</li>
        <li>犯罪行為、犯罪の指南または犯罪を教唆する行為</li>
        <li>個人情報または個人を特定できる情報を掲載、また第三者の個人情報を収集する行為</li>
        <li>ストーカー行為またはストーカー行為に類似する行為</li>
        <li>当社または他の会員、その他第三者に対する名誉もしくは信用を毀損する行為</li>
        <li>迷惑行為、中傷・嫌がらせ、わいせつ等、他の会員に対して不快感を与える行為</li>
        <li>わいせつ、差別的もしくは暴力的な表現行為、ならびに公序良俗に反する行為</li>
        <li>当社または第三者の特許権、実用新案権、意匠権、商標権、著作権、技術上もしくは営業上のノウハウその他の権利、またはこれらの権利に基づく実施権等の権利を侵害する行為</li>
        <li>当社のサーバーへ過度な負荷をかける行為</li>
        <li>当社が意図しない不正なツールまたはプログラムを使用または提供する行為</li>
        <li>当社または第三者のシステムに不正にアクセスし、本サービスまたは個別サービスのプログラム等を改変、改造、解析およびリバースエンジニアリング等する行為</li>
        <li>当社が意図しない不正なツールまたはアプリケーション等を使用して本サービスを利用する行為</li>
        <li>本サービスの不具合等を意図的に利用する行為</li>
        <li>当社または当社のカスタマーサポートへの法的責任を超えた不当な問い合わせまたは要求を行うことにより、当社の円滑な業務の遂行を妨げる行為</li>
        <li>前各号に該当する行為を援助、助長または準備する行為</li>
        <li>その他、当社が不適切と判断する行為</li>
      </ol>        
      <p>会員が前項各号の禁止事項に該当した場合、以下各号のいずれかまたは全ての措置をとることができるものとします。</p>
      <ol>
        <li>注意または警告</li>
        <li>本サービスおよび個別サービスの提供停止を含む利用の制限</li>
        <li>本アカウントの削除、並びに再度の会員登録の制限</li>
      </ol>
    </div>
    <button id="agreeButton" disabled>同意します</button>
    <button id="disAgreeButton" >同意しません</button>
  </div>
</div>

<script type="text/javascript">
	// ログイン名欄にフォーカスを与える
	document.getElementById("login").focus();
	//モーダルウィンドウを開く関数 
	function openTerms() {
		var modal = document.getElementById("termsModal");
		var span = document.getElementsByClassName("close")[0]; 
		modal.style.display = "block"; 
		
		// モーダルウィンドウを閉じる関数 
		span.onclick = function() {
			modal.style.display = "none";
		} 
		// モーダルウィンドウ外をクリックした場合に閉じる関数 
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		} 
		// スクロール位置を確認して同意ボタンを有効化する関数 
		document.getElementById('termsContent').addEventListener('scroll', function() {
			var termsContent = document.getElementById('termsContent');
			if (termsContent.scrollTop + termsContent.clientHeight >= termsContent.scrollHeight) {
				document.getElementById('agreeButton').disabled = false;
			}
		}); 
		// 同意ボタンがクリックされたらチェックボックスを有効化する関数 
		document.getElementById('agreeButton').addEventListener('click', function() {
			document.getElementById('registerBtn').disabled = false;
			// 同意状態をセッションに保存 
			sessionStorage.setItem('agreed', 'true');
			modal.style.display = "none";
		});
		// 同意しないボタンがクリックされたらウィンドウを閉じる関数 
		document.getElementById('disAgreeButton').addEventListener('click', function() {
			modal.style.display = "none";
		});
		
	}
	// ページ読み込み時に同意状態を確認してボタンを有効化 ,同意警告文を消去
	window.onload = function() {
		if (sessionStorage.getItem('agreed') === 'true') {
			document.getElementById('registerBtn').disabled = false;
			document.getElementById('agreeMessege').innerHTML = ""
		}
	}
</script>
<%@include file="../footer.html"%>
