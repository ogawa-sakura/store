/**
 * 
 */
package c24;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import bean.CustomerInf;
import dao.CustomerInfDAO;
import dao.DAO;
import tool.Action;
import tool.Const;

/**
 * 顧客注文履歴アクション
 * @author c3user
 *
 */
public class CustomerInfAction extends Action {

	@Override
	public String exectute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// セッション取得
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute(Const.SESSION_CUSTOMER);
		// コネクションオブジェクト作成
		Connection con = null;
		try {
			if (customer == null) {
				return "../c24/login-in.jsp";
			}
			// 検索実施
			CustomerInfDAO dao = new CustomerInfDAO();
			// コネクション取得
			con = DAO.getConnection();
			List<CustomerInf> list = dao.search(customer, con);
			// セッション属性を設定
			session.setAttribute(Const.PARAM_PURCHASE_LIST, list);
		} finally {
			// コネクションクローズ
			if (con != null) {
				con.close();
			}
		}
		
		
		
		return Const.SESSION_CUSTOMER_INF;

	}
}
