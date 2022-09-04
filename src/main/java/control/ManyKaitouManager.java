//　自分が格納されているフォルダ名
package control;

//不要かも
//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.List;

import beans.Kaitou;
import dao.ManyKaitouDAO;

public class ManyKaitouManager {

	// 属性
	private Connection connection = null;

	// 引数を持たないコンストラクタ
	public ManyKaitouManager() {
	}

	// 追加
	// 引数はStudentオブジェクト
	public void registKaitou(Kaitou kaitou) {

		// ManyKaitouDAOオブジェクト生成
		ManyKaitouDAO kaitouDAO = new ManyKaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// kaitouオブジェクトをDataBaseに登録する
		kaitouDAO.registKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;
	}

	// 検索
	public List<Kaitou> searchKaitou(Kaitou kaitou) {

		// ManyKaitoouDAOオブジェクト生成
		ManyKaitouDAO kaitouDAO = new ManyKaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// 検索する

		List<Kaitou> list = kaitouDAO.searchKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return list;
	}

	public void deleteKaitou(Kaitou kaitou) {

		// ManyKaitouDAOオブジェクト生成
		ManyKaitouDAO kaitouDAO = new ManyKaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// ManyKaitouオブジェクトをDataBaseに登録する
		kaitouDAO.deleteKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

	public void updateKaitou(Kaitou kaitou) {

		// ManyKaitouDAOオブジェクト生成
		ManyKaitouDAO kaitouDAO = new ManyKaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// ManyKaitouオブジェクトをDataBaseに登録する
		kaitouDAO.updateKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

}
