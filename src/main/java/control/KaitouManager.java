//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;

import beans.Kaitou;
import dao.KaitouDAO;

public class KaitouManager {

	// 属性
	private Connection connection = null;

	// 引数を持たないコンストラクタ
	public KaitouManager() {
	}

	// 追加
	// 引数はKaitouオブジェクト
	public void registKaitou(Kaitou kaitou) {

		// KaitouDAOオブジェクト生成
		KaitouDAO kaitouDAO = new KaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// KaitouオブジェクトをDataBaseに登録する
		kaitouDAO.registKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;
	}

	// 検索
	public Kaitou searchKaitou(Kaitou kaitou) {

		// KaitouDAOオブジェクト生成
		KaitouDAO kaitouDAO = new KaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// 検索する

		kaitou = kaitouDAO.searchKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		// kaitouオブジェクトを返す
		return kaitou;
	}


	public void deleteKaitou(Kaitou kaitou) {

		// KaitouDAOオブジェクト生成
		KaitouDAO kaitouDAO = new KaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// KaitoutオブジェクトをDataBaseに登録する
		kaitouDAO.deleteKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

	public void updateKaitou(Kaitou kaitou) {

		// KaitouDAOオブジェクト生成
		KaitouDAO kaitouDAO = new KaitouDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = kaitouDAO.createConnection();

		// KaitouオブジェクトをDataBaseに登録する
		kaitouDAO.updateKaitou(kaitou, this.connection);

		// DataBaseとの接続を切断する
		kaitouDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

}
