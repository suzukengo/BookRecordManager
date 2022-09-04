package servlet;

//自分が格納されているフォルダの外にある必要なクラス
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Record;
import control.RecordManager;

//アノテーションの記述
@WebServlet("/UpdateRecord")

// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class UpdateRecord extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// doPostメソッドから呼び出される(リダイレクトされる)
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		// forwardはrequestオブジェクトを引数として、次のページに渡すことができる
		RequestDispatcher dispatcher = request.getRequestDispatcher("/finish.jsp");
		dispatcher.forward(request, response);
	}

	// requestオブジェクトには、フォームで入力された文字列などが格納されている。
	// responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");

		// requestオブジェクトから登録情報の取り出し
		Integer Id = Integer.valueOf(request.getParameter("id")).intValue();
		Double Review = Double.valueOf(request.getParameter("review")).doubleValue();
		String Title = request.getParameter("title");
		String Thinking = request.getParameter("thinking");
		
		Title = escape(Title);
		Thinking = escape(Thinking);
		

		// コンソールに確認するために出力
		System.out.println("取得した文字列は" + Id + "です！");
		System.out.println("取得した文字列は" + Title + "です！");
		System.out.println("取得した文字列は" + Review + "です！");
		System.out.println("取得した文字列は" + Thinking + "です！");

		// kaitouオブジェクトに情報を格納
		Record record = new Record("","", Thinking, "", Title, Review, Id);

		// KaitouManagerオブジェクトの生成
		RecordManager manager = new RecordManager();

		// 更新
		manager.updateRecord(record);

		// 成功画面を表示する

		RequestDispatcher dispatcher = request.getRequestDispatcher("/finish.jsp");
		dispatcher.forward(request, response);
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
