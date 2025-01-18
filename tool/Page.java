package tool;

import java.io.PrintWriter;

/**
 * HTMLの先頭と末尾を出力する
 * @author c3user
 *
 */
public class Page {

	/**
	 * HTMLの先頭を出力
	 * @param out	PrintWriter
	 */
	public static void header(PrintWriter out) {
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Servlet/JSP Sample Programs</title>");
		out.println("<link rel='stylesheet' href='../css/table.css'>");
		out.println("</head>");
		out.println("<body>");
	}

	/**
	 * HTMLの末尾を出力する
	 * @param out	PrintWriter
	 */
	public static void footer(PrintWriter out) {
		out.println("</body>");
		out.println("</html>");
	}
}
