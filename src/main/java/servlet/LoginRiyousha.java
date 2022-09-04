package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Login;
import control.UserManager;

@WebServlet("/LoginRiyousha")
// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class LoginRiyousha extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// requestオブジェクトには、フォームで入力された文字列などが格納されている。
	// responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		UserManager manager = new UserManager();
		// requestオブジェクトから登録情報の取り出し
		Integer id = Integer.valueOf(request.getParameter("id")).intValue();
		String pass2 = request.getParameter("pass");
		String Password2 = manager.SHA2(pass2).toString();

		Password2 = escape(Password2);
		
		// loginのオブジェクトに情報を格納
		Login login = new Login(id, Password2);
		
		boolean result = manager.loginUser(login);

		if (result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginfin.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/loginNG.jsp");
			dispatcher.forward(request, response);
		}

	}
	
	 private static String escape(String val) {
	       if (val == null) return "";
	       val = val.replaceAll("&", "& amp;");
	       val = val.replaceAll("<", "& lt;");
	       val = val.replaceAll(">", "& gt;");
	       val = val.replaceAll("\"", "&quot;");
	       val = val.replaceAll("'", "&apos;");
	       return val;
	     }
}
