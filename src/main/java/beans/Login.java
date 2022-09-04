//  自分が格納されているフォルダ名
package beans;

public class Login {
	private Integer id;
	private String pass;

	// コンストラクタ(引数あり)
	public Login(Integer id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	public Integer getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}
}