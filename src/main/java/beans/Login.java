//  自分が格納されているフォルダ名
package beans;

import java.io.Serializable;

public class Login implements Serializable {
	
	private static final long serialVersionUID = 1L;
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