//  自分が格納されているフォルダ名
package beans;

public class User {

	// 属性
	private Integer id = null; 
	private String password = null; 
	private String name = null;
	private String sex=null;
	private Integer age=null;
	private Integer count=0;
	
	

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	// 初期値を引数に持ったコンストラクタ
	public User(Integer id,String password,String name,String sex,Integer age) {
		this.id=id;
		this.password=password;
		this.name=name;
		this.sex=sex;
		this.age=age;
		}
	
	public User(Integer id,String password,String name,String sex,Integer age,Integer count) {
		this.id=id;
		this.password=password;
		this.name=name;
		this.sex=sex;
		this.age=age;
		}

	// 初期値を引数に持たないコンストラクタ
	// Java beansは初期値を持たないコンストラクタが必ず必要
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

 
}
