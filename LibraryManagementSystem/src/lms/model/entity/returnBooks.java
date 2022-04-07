package lms.model.entity;

import java.time.LocalDate;

public class returnBooks {
	private int id;
	private Books code;
	private Members card_id;
	private LocalDate borrow_date;
	private LocalDate return_date;
	private LocalDate due_date;
	private int fees;
	private Libarians lib_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Books getCode() {
		return code;
	}
	public void setCode(Books code) {
		this.code = code;
	}
	public Members getCard_id() {
		return card_id;
	}
	public void setCard_id(Members card_id) {
		this.card_id = card_id;
	}
	public LocalDate getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(LocalDate borrow_date) {
		this.borrow_date = borrow_date;
	}
	public LocalDate getReturn_date() {
		return return_date;
	}
	public void setReturn_date(LocalDate return_date) {
		this.return_date = return_date;
	}
	public LocalDate getDue_date() {
		return due_date;
	}
	public void setDue_date(LocalDate due_date) {
		this.due_date = due_date;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public Libarians getLib_id() {
		return lib_id;
	}
	public void setLib_id(Libarians lib_id) {
		this.lib_id = lib_id;
	}
}
