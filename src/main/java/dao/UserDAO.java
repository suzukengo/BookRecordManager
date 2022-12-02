
//　自分が格納されているフォルダ名
package dao;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Login;
import beans.User;



public class UserDAO {
		
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

	//private final static String USER_NAME = "root";
	private final static String USER_NAME = "kengo";
	
	// データベースのユーザーのパスワード (デフォルトでは設定なし)
	//private final static String PASSWORD = "root";
	private final static String PASSWORD = "Suzuki1021#";


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
	public void registUser(User user, Connection connection) {

		try {

			// SQLコマンド
			String sql = "insert into user(id, password, name,sex,age) values(?, ?, ?,?,?)";

			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);

			// SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getPassword());
			stmt.setString(3, user.getName());
			stmt.setString(4, user.getSex());
			stmt.setInt(5, user.getAge());

			stmt.executeUpdate();

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
	}

	// 検索する
	// 引数はStudentオブジェクトと、Connectionオブジェクト
	public User searchUser(User user, Connection connection) {

		try {
			// SQLコマンド
			String sql = "select * from user where id = ? ";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, user.getId());
			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();

			if (rs.first()) { // DBに存在した場合
				// rsからそれぞれの情報を取り出し、Studentオブジェクトに設定する
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
			} else { // DBに存在しなかった場合
				user = null; // studentオブジェクトをnullにする
			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return user;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}
	
	public User searchUser2(User user, Connection connection) {

		try {
			// SQLコマンド
			String sql = "select MAX(id) as id from user";

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			
			ResultSet rs = stmt.executeQuery();

			if (rs.first()) { // DBに存在した場合
				user.setId(rs.getInt("id"));
			} else { // DBに存在しなかった場合
				user = null; // studentオブジェクトをnullにする
			}

			// 終了処理
			stmt.close();
			rs.close();

			// Studentオブジェクトを返す
			return user;

		} catch (SQLException e) {

			// エラーが発生した場合、エラーの原因を出力し、nullオブジェクトを返す
			e.printStackTrace();
			return null;

		} finally {
		}
	}

	public Login loginUser(Login login, Connection connection) {
		Connection conn = null;

		try {

			// SQLコマンド
			String sql = "select id,password from user where id = ? and password=?";
			

			// SQLのコマンドを実行する
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, login.getId());
			stmt.setString(2, login.getPass());

			// 実行結果はrsに格納される
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// 結果表からデータを取得
				Integer id = rs.getInt("id");
				String pass = rs.getString("password");
				login = new Login(id, pass);
				
				return login;
			}

			// 終了処理
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}
	
	public User updateUser(User user, Connection connection) {

		try {
			// SQLコマンド
			String sql = "update user set name=?,sex=?,age=? where id=? and password=?";
			String sql2 = "select id,password from user where id = ? and password=?";
			// SQLコマンドの実行
			PreparedStatement stmt = connection.prepareStatement(sql);
			PreparedStatement stmt2 = connection.prepareStatement(sql2);
			
			// SQLコマンドのクエッションマークに値を、1番目から代入する
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getSex());
			stmt.setInt(3, user.getAge());
			stmt.setInt(4, user.getId());
			stmt.setString(5, user.getPassword());
			
			stmt2.setInt(1, user.getId());
			stmt2.setString(2, user.getPassword());
			ResultSet rs = stmt2.executeQuery();
			
			if (rs.next()) {
				// 結果表からデータを取得
				Integer id = rs.getInt("id");
				String pass = rs.getString("password");
				if(user.getId().equals(id)  && user.getPassword().equals(pass)) {
					user.setCount(1);
				}
				
			}

			stmt.executeUpdate();

		} catch (SQLException e) {
			
			// エラーが発生した場合、エラーの原因を出力する
			e.printStackTrace();

		} finally {
		}
		return user;
	}
	
}
