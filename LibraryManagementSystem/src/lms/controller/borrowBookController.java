package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.model.entity.Authors;
import lms.model.entity.Books;
import lms.model.entity.Categories;
import lms.model.entity.Libarians;
import lms.model.entity.Members;
import lms.model.entity.borrowBooks;
import lms.model.service.DatabaseService;

public class borrowBookController implements Initializable{
	 @FXML
	    private TableColumn<borrowBooks, LocalDate> col_DueDate;

	    @FXML
	    private TableColumn<borrowBooks, LocalDate> col_borrowDate;

	    @FXML
	    private TableColumn<borrowBooks, Integer> col_borrowid;

	    @FXML
	    private TableColumn<borrowBooks, Integer> col_fees;
	    
	    @FXML
	    private TableColumn<Libarians, String> col_librian;

	    @FXML
	    private TableColumn<Members, String> col_member;

	    @FXML
	    private TableColumn<Books, String> col_title;

	    @FXML
	    private TableColumn<Books, LocalDate> col_returnDate;
	    
	    @FXML
	    private TableView<borrowBooks> tbl_data;

	    @FXML
	    private TextField txt_bookcode;

	    @FXML
	    private TextField txt_memberID;

	    @FXML
	    void btn_back(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/Main.fxml");
	    }

	    @FXML
	    void btn_borrow(ActionEvent event) throws SQLException {
	    	
	    	borrowBooks borrowbook = new borrowBooks();
	    	
	    	String member_id = txt_memberID.getText();
	    	String book_code = txt_bookcode.getText();
	    	
	    	if(txt_memberID.getText().isEmpty()) {
	    		showAlert(AlertType.ERROR, "Please enter member id");
	    		return;
	    	}
	    		
	    	if(txt_bookcode.getText().isEmpty()) {
	    		showAlert(AlertType.ERROR, "Please enter book code");
	    		return;
	    	}
	    	
	    	Members mem = DatabaseService.FindMemberByID(member_id);
	    	
	    	if(mem == null) {
	    		showAlert(AlertType.ERROR, "Member does not exist.");
	    		return;
	    		}
	    	
	    	    if(DatabaseService.checkMemberReturn(member_id)) {
	    	    	showAlert(AlertType.ERROR, "This member borrowed book but not return yet!");
	    	    	return;
	    	    }
	    		
	    	
	    	LocalDate date = LocalDate.now();
	    	if(date.compareTo(mem.getExpire()) > 0 ) {//expire
    			showAlert(AlertType.ERROR, "Member card is expired on "+mem.getExpire());
    			return;
    	    	}
	    	
	    	/*List<borrowBooks> borrowbooklist= DatabaseService.checkMemberReturn(member_id); 
	    	System.out.println(borrowbooklist.size());
    	    if(borrowbooklist.size() <= 0) {
    	    	showAlert(AlertType.ERROR, "This member borrowed book but not return yet!");
    	    	return;
    	    }*/
	    	System.out.println(mem.getCardid());
	    	
    	    
	    	Books book = DatabaseService.FindBookByID(book_code);
	    	
	    	if(book == null) {
	    		showAlert(AlertType.ERROR, "Book does not exist");
	    		return;
	    	}
	    	System.out.println("FindBookID: "+ book.getCode());
	    	
	    	book = DatabaseService.CheckBookAvailable(book_code);
	    	
	    	if(book == null) {
	    		showAlert(AlertType.ERROR, "This book is not available now.");
	    		return;
	    	}
	    	System.out.println("CheckBookAvailable: "+ book.getCode());
	    	
	    	borrowbook.setCode(book);
	    	borrowbook.setCard_id(mem);
	    	borrowbook.setBorrow_date(date);
	    	borrowbook.setDue_date(date.plusDays(7));
	   // System.out.println(borrowbook.getCode());
	   // System.out.println(book.getCode());
	    	boolean result = DatabaseService.addBorrowBooks(borrowbook);
	    	if(result == true) {
	    		showAlert(AlertType.INFORMATION, "Successfully inserted borrowed book.");
				LoadBorrow();
	    	}
	    	else {
	    		showAlert(AlertType.ERROR, "Something is wrong!Please try again.");
	    	}
			
	    	}
	    
	    private void showAlert(AlertType type, String msg) {
			// TODO Auto-generated method stub
	    	Alert alert = new Alert(type);
			alert.setTitle("Message");
			alert.setContentText(msg);
			alert.setHeaderText(null);
			alert.showAndWait();
		}
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			col_borrowid.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("bookName"));
			col_member.setCellValueFactory(new PropertyValueFactory<>("memberName"));
			col_borrowDate.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
			col_DueDate.setCellValueFactory(new PropertyValueFactory<>("due_date"));
			//col_returnDate.setCellValueFactory(new PropertyValueFactory<>("return_date"));
			col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
			col_librian.setCellValueFactory(new PropertyValueFactory<>("libarianName"));
			//tbl_data.getSelectionModel().selectedItemProperty();
			LoadBorrow();
			//LoadBooks();
			//LoadMembers();
			//LoadLibarians();
		}
		private void LoadBorrow() {
			// TODO Auto-generated method stub
			List<borrowBooks> borrowbooklist = lms.model.service.DatabaseService.getAllBorrowBooks();
			tbl_data.setItems(FXCollections.observableArrayList(borrowbooklist));
		}
}
