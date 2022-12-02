
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Record;

public class RecordDAO {

	// 属性

	// データベースの接続先アドレスを静的変数として記述
	private final static String DRIVER_URL = "jdbc:mysql://localhost:3306/book_record?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
	// DockerでMysqlを起動した場合
	// private final static String DRIVER_URL =
	// "jdbc:mysql://localhost:3307/student?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";

	// データベース接続ドライバの名前を静的変数として記述
	// Mysql5.系
	// private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	// Mysql8.系
	private final static String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	// データベースのユーザー名 （デフォルトではroot）

	//private final static String USER_NAME = "root";
	private final static String USER_NAME = "kengo";
	
	// データベースのユーザーのパスワード (デフォルトでは設定なし)
	//private final static String PASSWORD = "root";
	private final static String PASSWORD = "Suzuki1021#";

	

	// DockerでMysqlを起動した場合
	// private final static String PASSWORD = "root";

	// データベースとの接続を行う
	// データベースの接続情報を持ったConnectionオブジェクトを返す
	public Connection createConnection() {
        String JAVA_ENV = System.getenv("JAVA_ENV");
        String DRIVER_URL = "jdbc:mysql://localhost:3306/db?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";

        if (JAVA_ENV.equals("development")) {
            // 自分自身のPC内で　docker-compose　立ち上げ
            DRIVER_URL = "jdbc:mysql://local_springwork2000g0_db:3306/db?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
        } else if (JAVA_ENV.equals("production")) {
            // 本番環境
            DRIVER_URL = "jdbc:mysql://springwork2000g0_db:3306/db?allowPublicKeyRetrieval=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true";
        } else{
            // gradleなどで起動の場合
            DRIVER_URL = "jdbc:mysql://localhost:3306/db?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9:00&rewriteBatchedStatements=true"; 
        }
        try {
            Class.forName(DRIVER_NAME);
            Connection con = DriverManager.getConnection(DRIVER_URL, USER_NAME, PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Can't Find JDBC Driver.\n");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return null;
    }

	// Connectionオブジェクトを使って、データベースとの接続を切断する
	// 引数Connectionオブジェクト
	public void closeConnection(Connection con) {

		try {
			con.close();
		} catch (Exception ex) {
		}
	}

	// 情報をデータベースに登録する
	// 引数はStudentオブジェクトと、Connectionオブジェクト
	public void registRecord(Record record, Connection connection) {

		try {

			// SQLコマンド
			String sql = "insert into Readingrecord(janru, privacy, thinking,isbn,title,review,id) values(?, ?, ?,?,?,?,?)";

			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			// SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setString(1, record.getJanru());
			stmt.setString(2, record.getPrivacy());
			stmt.setString(3, record.getThinking());
			stmt.setString(4, record.getIsbn());
			stmt.setString(5, record.getTitle());
			stmt.setDouble(6, record.getReview());
			stmt.setInt(7, record.getId());

			stmt.executeUpdate();

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}
	
	public Record searchRecord(Record record, Connection connection) {

		try {
			// SQLコマンド
			String sql = "select janru,thinking,isbn,title,review from readingrecord where privacy=? and title=? or isbn=? or review=?";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, record.getPrivacy());
			stmt.setString(2, record.getTitle());
			stmt.setString(3, record.getIsbn());
			stmt.setDouble(4, record.getReview());
			
			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();

			if (rs.first()) { // DBに存在した場合
				// rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
				record.setJanru(rs.getString("janru"));
				record.setThinking(rs.getString("thinking"));
				record.setIsbn(rs.getString("isbn"));
				record.setTitle(rs.getString("title"));
				record.setReview(rs.getDouble("review"));
				
			} else { // DBに存在しなかった場合
				record = null; // studentオブジェクトをnullにする
			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return record;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}

	public List<Record> searchRecord2(Record record, Connection connection) {

		List<Record> list = new ArrayList<Record>();

		try {
			// SQLコマンド
			String sql = "select janru,thinking,isbn,title,review from readingrecord where privacy=? and review=? and janru=?";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, "公開");
			stmt.setDouble(2, record.getReview());
			stmt.setString(3, record.getJanru());
			
			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
				String janru=rs.getString("janru");
				String thinking=rs.getString("thinking");
				String privacy="公開";
				String isbn=rs.getString("isbn");
				String title=rs.getString("title");
				Double review=rs.getDouble("review");
				Integer id =null; 
				
				Record tmp = new Record(janru,privacy,thinking,isbn,title,review,id);
				list.add(tmp);

			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return list;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}
	
	public List<Record> searchRecord3(Record record, Connection connection) {

		List<Record> list = new ArrayList<Record>();

		try {
			// SQLコマンド
			String sql = "select*from readingrecord where id=?";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, record.getId());
			
			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
				String janru=rs.getString("janru");
				String thinking=rs.getString("thinking");
				String privacy=rs.getString("privacy");
				String isbn=rs.getString("isbn");
				String title=rs.getString("title");
				Double review=rs.getDouble("review");
				Integer id =rs.getInt("id"); 
				
				Record tmp = new Record(janru,privacy,thinking,isbn,title,review,id);
				list.add(tmp);

			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return list;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}

	public List<Record> searchRecord4(Record record, Connection connection) {

		List<Record> list = new ArrayList<Record>();

		try {
			// SQLコマンド
			String sql = "select title,avg(review) as review from readingrecord  group by title order by review desc limit 0,10";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();
			

			while (rs.next()) {
				// rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
				
				String title=rs.getString("title");
				Double review=rs.getDouble("review");
				
				
				Record tmp = new Record("","","","",title,review,0);
				list.add(tmp);

			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return list;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}
	
	public List<Record> searchRecord5(Record record, Connection connection) {

		List<Record> list = new ArrayList<Record>();

		try {
			// SQLコマンド
			String sql = "select title,avg(review) as review from readingrecord where janru=? group by title order by review desc limit 0,10";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, record.getJanru());
			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
				
				String title=rs.getString("title");
				Double review=rs.getDouble("review");
				
				
				Record tmp = new Record("","","","",title,review,0);
				list.add(tmp);

			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return list;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}
	
	public void deleteRecord(Record record, Connection connection) {

		try {

			// SQLコマンド
			String sql = "delete from readingrecord where id=? and title=?";

			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			// SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setInt(1, record.getId());
			stmt.setString(2, record.getTitle());

			stmt.executeUpdate();

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}
	

	public void updateRecord(Record record, Connection connection) {

		try {
			// SQLコマンド
			String sql = "update readingrecord set thinking=?,review=? where id=? and title=?";

			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			// SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setString(1, record.getThinking());
			stmt.setDouble(2, record.getReview());
			stmt.setInt(3, record.getId());
			stmt.setString(4, record.getTitle());

			stmt.executeUpdate();

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}
}
