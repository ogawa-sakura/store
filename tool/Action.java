package tool;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;

/**
 * アクション抽象クラス
 * @author c3user
 *
 */
public abstract class Action {
	/**
	 * 各アクションの処理先JSPを返す抽象メソッド
	 * @param request		リクエスト
	 * @param response		レスポンス
	 * @return				フォワード先のJSPファイルアドレス（"list.jsp"など）
	 * @throws Exception	発生例外
	 */
	public abstract String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * list内itemの合計金額・合計点数をセッションにセットする
	 * @param list			カート情報
	 * @param session		セッション情報
	 * @throws Exception	発生例外
	 */
	public void setSum(Map<Integer, Item> list, HttpSession session) throws Exception {
		/* 価格合計 */
		int priceSum = 0;
		/* 点数合計 */
		int countSum = 0;
		// 価格合計と点数合計を計算
		for (Item item : list.values()) {
			priceSum += item.getProduct().getPrice() * item.getCount();
			countSum += item.getCount();
		}
		// セッション情報に価格合計・点数合計を設定
		session.setAttribute(Const.SESSION_SUMPRICE, priceSum);
		session.setAttribute(Const.SESSION_SUMCOUNT, countSum);
	}
}
