package lms.model.entity;

import java.time.LocalDate;

public class Members {
	private int cardid;
	private String name;
	private String rollno;
	private String classyear;
	private String academic;
	private LocalDate create;
	private LocalDate expire;
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getClassyear() {
		return classyear;
	}
	public void setClassyear(String classyear) {
		this.classyear = classyear;
	}
	public String getAcademic() {
		return academic;
	}
	public void setAcademic(String academic) {
		this.academic = academic;
	}
	public LocalDate getCreate() {
		return create;
	}
	public void setCreate(LocalDate create) {
		this.create = create;
	}
	public LocalDate getExpire() {
		return expire;
	}
	public void setExpire(LocalDate expire) {
		this.expire = expire;
	}
	
}
