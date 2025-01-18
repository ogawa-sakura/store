/**
 * 
 */
package c25;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.DAO;
import dao.ProductDAO;
import tool.Action;
import tool.Const;

/**
 * 商品検索アクション
 * @author c3user
 *
 */
public class ProductAction extends Action {
	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		// コネクションオブジェクト作成
		Connection con = null;
		try {
			// 検索キーワード取得
			String keyword = request.getParameter(Const.PARAM_KEYWORD);
			if (keyword == null) {
				keyword = "";
			}
			// 検索実施
			ProductDAO dao = new ProductDAO();
			// コネクション取得
			con = DAO.getConnection();
			List<Product> list = dao.search(keyword, con);
			// セッション属性を設定
			session.setAttribute(Const.PARAM_LIST, list);
		} finally {
			// コネクションクローズ
			if (con != null) {
				con.close();
			}
		}
		return Const.SESSION_PRODUCT;
	}
}
