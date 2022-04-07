package lms.model.entity;

public class Books {
	private int code;
	private String title;
	private int is_avaliable ;
	private Categories category;
	private Authors author;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getIs_avaliable() {
		return is_avaliable;
	}
	public void setIs_avaliable(int checkavailable) {
		this.is_avaliable = checkavailable;
	}
	public Categories getCategory() {
		return category;
	}
	public void setCategory(Categories category) {
		this.category = category;
	}
	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}
	public String getAuthorName() {
		return this.author.getName();
	}
	public String getCategoryName() {
		return this.category.getName();
	}
}
