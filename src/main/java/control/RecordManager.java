//　自分が格納されているフォルダ名
package control;

//  自分が格納されているフォルダの外にある必要なクラス
import java.sql.Connection;
import java.util.List;

import beans.Record;
import dao.RecordDAO;

public class RecordManager {

	// 属性
	private Connection connection = null;

	// 引数を持たないコンストラクタ
	public RecordManager() {
	}

	// 追加
	// 引数はmondaiオブジェクト
	public void registRecord(Record record) {

		// MondaiDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// MondaiオブジェクトをDataBaseに登録する
		recordDAO.registRecord(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

	// 検索
	public Record searchRecord(Record record) {

		// MondaiDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// 検索する
		record = recordDAO.searchRecord(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return record;
	}
	
	// 検索
	public List<Record> searchRecord2(Record record) {

		// ManyKaitoouDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// 検索する

		List<Record> list = recordDAO.searchRecord2(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return list;
	}

	
	public List<Record> searchRecord3(Record record) {

		// ManyKaitoouDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// 検索する

		List<Record> list = recordDAO.searchRecord3(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return list;
	}
	
	public List<Record> searchRecord4(Record record) {

		// ManyKaitoouDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// 検索する

		List<Record> list = recordDAO.searchRecord4(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return list;
	}
	
	public List<Record> searchRecord5(Record record) {

		// ManyKaitoouDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// 検索する

		List<Record> list = recordDAO.searchRecord5(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

		return list;
	}
	
	public void deleteRecord(Record record) {

		// ManyKaitouDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// ManyKaitouオブジェクトをDataBaseに登録する
		recordDAO.deleteRecord(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}
	
	
	public void updateRecord(Record record) {

		// ManyKaitouDAOオブジェクト生成
		RecordDAO recordDAO = new RecordDAO();

		// DataBaseへ接続し、コネクションオブジェクトを生成する
		this.connection = recordDAO.createConnection();

		// ManyKaitouオブジェクトをDataBaseに登録する
		recordDAO.updateRecord(record, this.connection);

		// DataBaseとの接続を切断する
		recordDAO.closeConnection(this.connection);

		// コネクションオブジェクトを破棄する
		this.connection = null;

	}

}
