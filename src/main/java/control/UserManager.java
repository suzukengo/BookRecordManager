//　自分が格納されているフォルダ名
package control;

import java.security.MessageDigest;
//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;

import beans.Login;
import beans.User;
import dao.UserDAO;

public class UserManager {

	// 属性
	private Connection connection = null;

	// 引数を持たないコンストラクタ
	public UserManager() {
	}

	// 追加
	// 引数はRiyoushaオブジェクト
	public void registUser(User user) {

		// RiyoushaDAOオブジェクト生成
		UserDAO userDAO = new UserDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = userDAO.createConnection();

		// RiyoushaオブジェクトをDataBaseに登録する
		userDAO.registUser(user, this.connection);

		// DataBaseとの接続を切断する
		userDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

	// 検索
	public User searchUser(User user) {

		// RiyoushaDAOオブジェクト生成
		UserDAO userDAO = new UserDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = userDAO.createConnection();

		// 検索する
		user = userDAO.searchUser(user, this.connection);

		// DataBaseとの接続を切断する
		userDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return user;
	}
	
	public User searchUser2(User user) {

		// RiyoushaDAOオブジェクト生成
		UserDAO userDAO = new UserDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = userDAO.createConnection();

		// 検索する
		user = userDAO.searchUser2(user, this.connection);

		// DataBaseとの接続を切断する
		userDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return user;
	}

	public boolean loginUser(Login login) {

		// RiyoushaDAOオブジェクト生成
		UserDAO userDAO = new UserDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = userDAO.createConnection();

		// 検索する

		login = userDAO.loginUser(login, this.connection);

		// DataBaseとの接続を切断する
		userDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return login != null;
	}

	
	public 	StringBuilder SHA2(String password) {
			                String text = password;
			                byte[] cipher_byte;
			                try{
			                        MessageDigest md = MessageDigest.getInstance("SHA-256");
			                        md.update(text.getBytes());
			                        cipher_byte = md.digest();
			                        StringBuilder sb = new StringBuilder(2 * cipher_byte.length);
			                        for(byte b: cipher_byte) {
			                                sb.append(String.format("%02x", b&0xff) );
			                        }
			                        System.out.println( sb );
									return sb;
			                } catch (Exception e) {
			                        e.printStackTrace();
			                }
							return null;
			        }
	
	public User updateUser(User user) {

		// KaitouDAOオブジェクト生成
		UserDAO userDAO = new UserDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = userDAO.createConnection();

		// KaitouオブジェクトをDataBaseに登録する
		userDAO.updateUser(user, this.connection);

		// DataBaseとの接続を切断する
		userDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;
		return user;

	}



		}


	
