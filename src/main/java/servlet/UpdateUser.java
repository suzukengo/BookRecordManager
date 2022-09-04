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

//アノテーションの記述
@WebServlet("/UpdateUser")

// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class UpdateUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static int count=0;
	

	// doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		// forwardはrequestオブジェクトを引数として、次のページに渡すことができる
		RequestDispatcher dispatcher = request.getRequestDispatcher("/finish.jsp");
		dispatcher.forward(request, response
				);
	}

	// requestオブジェクトには、フォームで入力された文字列などが格納されている。
	// responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// KaitouManagerオブジェクトの生成
		UserManager manager = new UserManager();
		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		Integer Id = Integer.valueOf(request.getParameter("id")).intValue();
		String Sex = request.getParameter("sex");
		String Password = request.getParameter("password");
		String Password2 = manager.SHA2(Password).toString();
		Integer Age = Integer.valueOf(request.getParameter("age")).intValue();
		String Name = request.getParameter("name");
		
		Sex = escape(Sex);
		Password2 = escape(Password2);
		Name = escape(Name);

		// コンソールに確認するために出力
		System.out.println("取得した文字列は" + Id + "です！");
		System.out.println("取得した文字列は" + Sex + "です！");
		System.out.println("取得した文字列は" + Password2 + "です！");
		System.out.println("取得した文字列は" + Age + "です！");
		System.out.println("取得した文字列は" + Name + "です！");

		// kaitouオブジェクトに情報を格納
		User user = new User(Id, Password2, Name,Sex,Age,0);

		// 更新
		User user1=manager.updateUser(user);
		
		if(user1.getCount()==1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/updatekakunin.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/fail.jsp");
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
