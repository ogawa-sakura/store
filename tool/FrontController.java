package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.action")
/**
 * URLを受け取り各アクションへフォワードする
 * @author c3user
 *
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// リクエストURL内からサーブレットの先頭/を除いたパスを取得（例：c23/Seach.action）
			String path = request.getServletPath().substring(1);
			// .aをAに、/を.に置き換え（例：c23.SeachAction）
			String name = path.replace(".a", "A").replace("/", ".");
			// classオブジェクトを作成し、コンストラクタオブジェクトを元にインスタンスを作成
			Action action = (Action) Class.forName(name).getDeclaredConstructor().newInstance();
			// action毎のフォワード先サーブレット名を取得
			String url = action.exectute(request, response);
			// フォワード実施
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}
}
