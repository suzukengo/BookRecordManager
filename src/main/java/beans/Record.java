//  自分が格納されているフォルダ名
package beans;

import java.io.Serializable;

public class Record implements Serializable {

	private static final long serialVersionUID = 1L;
	private String janru;
	private String privacy;
	private String thinking;
	private String isbn;
	private String title;
	private double review;
	private Integer id;
	
	public Record(String janru,String privacy,String thinking,String isbn,String title,Double review,Integer id) {
		this.janru=janru;
		this.privacy=privacy;
		this.thinking=thinking;
		this.isbn=isbn;
		this.title=title;
		this.review=review;
		this.id=id;
	}
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Record() {
		
	}
	



	public String getJanru() {
		return janru;
	}
	public void setJanru(String janru) {
		this.janru = janru;
	}
	public String getPrivacy() {
		return privacy;
	}
	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}
	public String getThinking() {
		return thinking;
	}
	public void setThinking(String thinking) {
		this.thinking = thinking;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getReview() {
		return review;
	}
	public void setReview(Double review) {
		this.review = review;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
