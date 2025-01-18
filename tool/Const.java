/**
 * 
 */
package tool;

/**
 * 定数クラス
 * @author c3user
 *
 */
public class Const {
	/* データソースURL*/
	public static final String DATASOURCE_URL = "java:/comp/env/jdbc/book";

	/* リクエストパラメータ ID*/
	public static final String PARAM_ID = "id";
	/* リクエストパラメータ 商品コード*/
	public static final String PARAM_P_ID = "p_id";
	/* リクエストパラメータ ログイン*/
	public static final String PARAM_LOGIN = "login";
	/* リクエストパラメータ パスワード*/
	public static final String PARAM_PASSWORD = "password";
	/* リクエストパラメータ 顧客email*/
	public static final String PARAM_EMAIL = "email";
	/* リクエストパラメータ 顧客tel*/
	public static final String PARAM_TEL = "tel";
	/* リクエストパラメータ 顧客名：氏*/
	public static final String PARAM_L_NAME = "l_name";
	/* リクエストパラメータ 顧客名：名*/
	public static final String PARAM_F_NAME = "f_name";
	/* リクエストパラメータ 顧客住所：郵便番号*/
	public static final String PARAM_POST_CODE = "post_code";
	/* リクエストパラメータ 顧客住所：都道府県*/
	public static final String PARAM_PREFECTURE = "prefecture";
	/* リクエストパラメータ 顧客住所：市町村*/
	public static final String PARAM_CITY = "city";
	/* リクエストパラメータ 顧客住所：その他住所*/
	public static final String PARAM_O_ADDRESS = "o_address";
	/* リクエストパラメータ キーワード*/
	public static final String PARAM_KEYWORD = "keyword";
	/* リクエストパラメータ リスト*/
	public static final String PARAM_LIST = "list";
	/* リクエストパラメータ 購入リスト*/
	public static final String PARAM_PURCHASE_LIST = "purchase_list";
	/* リクエストパラメータ カート*/
	public static final String PARAM_CART = "cart";
	/* リクエストパラメータ 名前*/
	public static final String PARAM_NAME = "name";
	/* リクエストパラメータ 住所*/
	public static final String PARAM_ADDRESS = "address";
	/* リクエストパラメータ 個数*/
	public static final String PARAM_COUNT = "count";
	/* リクエストパラメータ 個数*/
	public static final String PARAM_PRICE = "price";
	/* リクエストパラメータ 個数*/
	public static final String PARAM_CHANGE = "change";
	/* リクエストパラメータ  購入確認 */
	public static final String PARAM_PURCHASE_CONFIRM = "confirm";
	/* リクエストパラメータ  購入確認　同意済 */
	public static final String PARAM_PURCHASE_Y = "Y";
	/* リクエストパラメータ  購入確認　同意前 */
	public static final String PARAM_PURCHASE_N = "N";
	/* リクエストパラメータ  新規IDPASS登録　許可文字パターン */
	public static final String PARAM_REGEX_PATTERN_LOGINPASS = "^(?=.*[A-Za-z0-9])(?=.*[-_.]).{6,}$";
	/* リクエストパラメータ  新規メールアドレス登録　許可文字パターン */
	public static final String PARAM_REGEX_PATTERN_MAIL = "^[0-9a-zA-Z_.-]+@[0-9a-zA-Z_.-]+.[0-9a-zA-Z_.-]+$";
	/* リクエストパラメータ  都道府県 */
	public static final String[] PARAM_PREFECTURES = 
			{"北海道",
			"青森県",
			"岩手県",
			"宮城県",
			"秋田県",
			"山形県",
			"福島県",
			"茨城県",
			"栃木県",
			"群馬県",
			"埼玉県",
			"千葉県",
			"東京都",
			"神奈川県",
			"新潟県",
			"富山県",
			"石川県",
			"福井県",
			"山梨県",
			"長野県",
			"岐阜県",
			"静岡県",
			"愛知県",
			"三重県",
			"滋賀県",
			"京都府",
			"大阪府",
			"兵庫県",
			"奈良県",
			"和歌山県",
			"鳥取県",
			"島根県",
			"岡山県",
			"広島県",
			"山口県",
			"徳島県",
			"香川県",
			"愛媛県",
			"高知県",
			"福岡県",
			"佐賀県",
			"長崎県",
			"熊本県",
			"大分県",
			"宮崎県",
			"鹿児島県",
			"沖縄県" };

	/* SQLプロパティ名 商品新設*/
	public static final String SQL_PRODUCT_INSERT = "INS_B01";
	/* SQLプロパティ名 商品検索*/
	public static final String SQL_PRODUCT_SEARCH = "SEL_PRODUCT01";
	/* SQLプロパティ名 IDPASS検索*/
	public static final String SQL_LOGIN_SEARCH = "SEL_CUSTOMER01";
	/* SQLプロパティ名 IDPASS検索*/
	public static final String SQL_CUSTOMER_SEARCH = "SEL_CUSTOMER02";
	/* SQLプロパティ名 ID新設*/
	public static final String SQL_LOGIN_INSERT = "INS_CUSTOMER01";
	/* SQLプロパティ名 ID新設*/
	public static final String SQL_PURCHASE_INSERT = "INS_PURCHASE01";
	/* SQLプロパティ名 ID新設ver2-1*/
	public static final String SQL_PURCHASE_INSERT2 = "INS_PURCHASE02";
	/* SQLプロパティ名 ID新設ver2-2*/
	public static final String SQL_PURCHASE_INSERT3 = "INS_PURCHASE03";

	/* セッション  顧客情報 */
	public static final String SESSION_CUSTOMER = "customer";
	/* セッション  ログイン成功時 */
	public static final String SESSION_LOGIN_OUT = "login-out.jsp";
	/* セッション  ログイン失敗時 */
	public static final String SESSION_LOGIN_IN = "login-in.jsp";
	/* セッション  ログイン失敗 */
	public static final String SESSION_ERROR_LIST = "errorList";
	/* セッション  購入失敗 */
	public static final String SESSION_PURCHASE_ERROR_LIST = "purchaseErrorList";
	/* セッション  ログアウト成功時 */
	public static final String SESSION_LOGOUT_OUT = "logout-out.jsp";
	/* セッション  ログアウト失敗時 */
	public static final String SESSION_LOGOUT_ERROR = "logout-error.jsp";
	/* セッション  商品一覧表示 */
	public static final String SESSION_PRODUCT = "product.jsp";
	/* セッション  カート一覧表示 */
	public static final String SESSION_CART = "cart.jsp";
	/* セッション  ログイン情報無し */
	public static final String SESSION_LOGIN_NULL = "preview-error-login.jsp";
	/* セッション  カート情報無し */
	public static final String SESSION_CART_NULL = "preview-error-cart.jsp";
	/* セッション  購入ページ */
	public static final String SESSION_PURCHASE_IN = "purchase-in.jsp";
	/* セッション  購入完了ページ */
	public static final String SESSION_PURCHASE_OUT = "purchase-out.jsp";
	/* セッション  購入失敗ページ */
	public static final String SESSION_PURCHASE_ERROR = "purchase-error-insert.jsp";
	/* セッション  購入金額合計 */
	public static final String SESSION_SUMPRICE = "priceSum";
	/* セッション  購入数合計 */
	public static final String SESSION_SUMCOUNT = "countSum";
	/* セッション  カート情報全削除 */
	public static final int SESSION_CART_DELETE = 0;
	/* セッション  カート情報変更時 */
	public static final int SESSION_CART_CHANGE = 1;
	/* セッション  新規ID登録 */
	public static final String SESSION_REGISTER = "register.jsp";
	/* セッション  新規ID登録失敗 */
	public static final String SESSION_REGISTER_ERROR_LIST = "registerErrorList";
	/* セッション  顧客情報ページ */
	public static final String SESSION_CUSTOMER_INF = "customer-inf.jsp";
	
	

	/* エラーメッセージ  IDPASS相違時 */
	public static final String MESSAGE_ERROR_LOGIN = "ログイン名またはパスワードが違います";
	/* エラーメッセージ  ログイン名未入力 */
	public static final String MESSAGE_BLANK_LOGIN = "ログイン名が未入力です";
	/* エラーメッセージ  パスワード未入力 */
	public static final String MESSAGE_BLANK_PASS = "パスワードが未入力です";
	/* エラーメッセージ  名前未入力 */
	public static final String MESSAGE_BLANK_NAME = "お名前が未入力です";
	/* エラーメッセージ  住所未入力 */
	public static final String MESSAGE_BLANK_ADDRESS = "ご住所が未入力です";
	/* エラーメッセージ  ID新設失敗時 */
	public static final String MESSAGE_ERROR_REGISTER = "IDが重複しています、別のIDを入力してください";
	/* エラーメッセージ  ID新設失敗時 */
	public static final String MESSAGE_ERROR_REGISTER_LOGIN = "ログイン名は6文字以上、かつ半角英数字と記号（-_.）を一つ以上含んで入力してください";
	/* エラーメッセージ  ID新設失敗時 */
	public static final String MESSAGE_ERROR_REGISTER_PASS = "パスワードは6文字以上、かつ半角英数字と記号（-_.）を一つ以上含んで入力してください";
	/* エラーメッセージ  ID新設成功時 */
	public static final String MESSAGE_SUCCESS_REGISTER = "正常に新規登録が終了しました、ログインしてください。";

}
