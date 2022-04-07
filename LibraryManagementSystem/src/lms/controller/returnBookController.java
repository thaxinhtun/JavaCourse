package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

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
import lms.model.entity.Members;
import lms.model.entity.borrowBooks;
import lms.model.service.DatabaseService;

public class returnBookController implements Initializable{
	 @FXML
	    private TableColumn<Books, String> col_book;

	   @FXML
	    private TableColumn<borrowBooks, LocalDate> col_BorrowDate;
	   
	    @FXML
	    private TableColumn<borrowBooks, Integer> col_borrowID;

	    @FXML
	    private TableColumn<borrowBooks, LocalDate> col_dueDate;

	    @FXML
	    private TableColumn<borrowBooks, Integer> col_fees;

	    @FXML
	    private TableColumn<Members, String> col_name;

	    @FXML
	    private TableColumn<borrowBooks, LocalDate> col_returnDate;

	    @FXML
	    private TableView<borrowBooks> tbl_data;

	    @FXML
	    private TextField txt_cardID;

	    @FXML
	    void btn_back(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/Main.fxml");
	    }

	    @FXML
	    void btn_return(ActionEvent event) throws SQLException {
	    	borrowBooks borrowbook = new borrowBooks();
	    	borrowbook = tbl_data.getSelectionModel().getSelectedItem();
	    	System.out.println(borrowbook.getId());
	    	System.out.println(borrowbook.getBorrow_date());
	    	if(borrowbook.getReturn_date() == null) {//if null can return book
	    		boolean result = DatabaseService.addReturnBooks(borrowbook);
		    	if(result == true) {
		    		showAlert(AlertType.INFORMATION, "Successfully returned");
					LoadBorrow();
		    	}
		    	else {
		    		showAlert(AlertType.ERROR, "Something is wrong!Please try again.");
		    	}
	    	}
	    	else {
	    		showAlert(AlertType.ERROR, "This member already returned for this book.");
	    	}
	    	/*boolean result = DatabaseService.addBorrowBooks(borrowbook);
	    	if(result == true) {
	    		showAlert(AlertType.INFORMATION, "Successfully inserted");
				LoadBorrow();
	    	}
	    	else {
	    		showAlert(AlertType.ERROR, "Something is wrong!Please try again.");
	    	}*/
	    	 
	    }
	    private void showAlert(AlertType type, String msg) {
 			// TODO Auto-generated method stub
 	    	Alert alert = new Alert(type);
 			alert.setTitle("Message");
 			alert.setContentText(msg);
 			alert.setHeaderText(null);
 			alert.showAndWait();
 		}
	    @FXML
	    void btn_search(ActionEvent event) {
	    	String memberId = txt_cardID.getText();
	    	List<borrowBooks> booklist = DatabaseService.FindBorrowMemberByID(memberId);
	    	if(booklist.size() > 0) {
	    		tbl_data.setItems(FXCollections.observableArrayList(booklist));
	    		
	    	}
	    	else {
	    		tbl_data.setItems(null);
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			col_borrowID.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_book.setCellValueFactory(new PropertyValueFactory<>("bookId"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("memberId"));
			col_BorrowDate.setCellValueFactory(new PropertyValueFactory<>("borrow_date"));
			col_dueDate.setCellValueFactory(new PropertyValueFactory<>("due_date"));
			col_returnDate.setCellValueFactory(new PropertyValueFactory<>("return_date"));
			col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
			LoadBorrow();
			/*tbl_data.getSelectionModel().selectedItemProperty().addListener(
					(obs,OldSelect,newSelect)->{
						if(newSelect!=null) {
							borrowBooks bbook = tbl_data.getSelectionModel().getSelectedItem();
						}
						}
					);*/
		}

		private void LoadBorrow() {
			// TODO Auto-generated method stub
			List<borrowBooks> borrowbooklist = lms.model.service.DatabaseService.getAllBorrowBooks();
			tbl_data.setItems(FXCollections.observableArrayList(borrowbooklist));
		}
}
