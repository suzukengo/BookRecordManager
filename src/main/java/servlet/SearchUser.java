package servlet;

//自分が格納されているフォルダの外にある必要なクラス

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import control.UserManager;

@WebServlet("/SearchUser3")
// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class SearchUser extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/searchmanykaitoufin.jsp");
		dispatcher.forward(request, response);
	}

	// requestオブジェクトには、フォームで入力された文字列などが格納されている。
	// responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// kaitouのオブジェクトに情報を格納
		User user = new User();
		
		// KaitouManagerオブジェクトの生成
		UserManager manager = new UserManager();
		User user2 = manager.searchUser2(user);

		// requestオブジェクトにオブジェクトを登録
		request.setAttribute("list", user2);
		// 情報表示画面を表示する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);

	}
}
