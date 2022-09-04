//  自分が格納されているフォルダ名
package beans;

import java.io.Serializable;

/**
 * JavaBean class used in jsp action tags.
 * 
 * @author Kengo Suzuki
 */
public class Kaitou implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Integer mid;
	private String title;
	private String age;
	private String mondai;
	private String kaitou;
	private String pass;

	// コンストラクタ(引数あり)
	public Kaitou(String id, Integer mid, String title, String age, String mondai, String kaitou, String pass) {
		this.id = id;
		this.mid = mid;
		this.title = title;
		this.age = age;
		this.mondai = mondai;
		this.kaitou = kaitou;
		this.pass = pass;
	}

	// コンストラクタ(引数なし)
	public Kaitou() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getKaitou() {
		return kaitou;
	}

	public void setKaitou(String kaitou) {
		this.kaitou = kaitou;
	}

	public String getMondai() {
		return mondai;
	}

	public void setMondai(String mondai) {
		this.mondai = mondai;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}