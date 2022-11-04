package servlet;

//自分が格納されているフォルダの外にある必要なクラス

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Record;
import control.RecordManager;

@WebServlet("/SearchRanking")
// HttpServletを継承することで、このクラスはServletとして、働くことができる
public class SearchRank extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/selectmondai.jsp");
		dispatcher.forward(request, response);
	}

	// requestオブジェクトには、フォームで入力された文字列などが格納されている。
	// responseオブジェクトを使って、次のページを表示する
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// requestオブジェクトの文字エンコーディングの設定
		request.setCharacterEncoding("UTF-8");
		String janru = request.getParameter("janru");
		System.out.println(janru);
		
		janru = escape(janru);

		Record record = new Record();
		record.setJanru(janru);

		// MondaiManagerオブジェクトの生成
		RecordManager manager = new RecordManager();
		System.out.println(record.getJanru());
		

		// 問題の検索
		List<Record> list = manager.searchRecord5(record);
		// requestオブジェクトにオブジェクトを登録
		request.setAttribute("list", list);
		
		// 情報表示画面を表示する
		RequestDispatcher dispatcher = request.getRequestDispatcher("/janrurankfin.jsp");
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
