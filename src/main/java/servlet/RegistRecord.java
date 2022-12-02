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
//jspで示してあげると、jspから呼び出さられる
@WebServlet("/RegistRecord")

// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class RegistRecord extends HttpServlet {

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
		
		String Janru = request.getParameter("janru");
		String Privacy = request.getParameter("privacy");
		String Thinking = request.getParameter("thinking");
		String Isbn = request.getParameter("isbn");
		String Title = request.getParameter("title");
		Double Review = Double.valueOf(request.getParameter("review")).doubleValue();
		Integer Id = Integer.valueOf(request.getParameter("id")).intValue();

		
		Janru = escape(Janru);
		Privacy = escape(Privacy);
		Thinking = escape(Thinking);
		Isbn = escape(Isbn);
		Title = escape(Title);
		
		// コンソールに確認するために出力
		
		System.out.println("取得した文字列は" + Janru + "です！");
		System.out.println("取得した文字列は" + Privacy + "です！");
		System.out.println("取得した文字列は" + Thinking + "です！");
		System.out.println("取得した文字列は" + Isbn + "です！");
		System.out.println("取得した文字列は" + Title + "です！");
		System.out.println("取得した文字列は" + Review + "です！");
		System.out.println("取得した文字列は" + Id + "です！");
		// mondaiオブジェクトに情報を格納
		
		Record record = new Record(Janru, Privacy, Thinking, Isbn, Title, Review,Id);
		// MondaiManagerオブジェクトの生成
		RecordManager manager = new RecordManager();

		// 登録
		manager.registRecord(record);

		// 成功画面を表示する
		// System.out.println("OK牧場");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/registcheck.jsp");
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
