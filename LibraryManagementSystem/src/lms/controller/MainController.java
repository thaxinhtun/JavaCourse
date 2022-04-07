package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lms.LMS_Main;

public class MainController implements Initializable{
	@FXML
    private Label lbl_libarian;

    @FXML
    void Author_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/Author.fxml");
    }

    @FXML
    void Book_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/Book.fxml");
    }

    @FXML
    void Borrow_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/BorrowBooks.fxml");
    }

    @FXML
    void Category_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/Category.fxml");
    }

    @FXML
    void Libarian_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/Libarian.fxml");
    }

    @FXML
    void Member_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/Members.fxml");
    }

    @FXML
    void Return_click(MouseEvent event) throws IOException {
    	LMS_Main.changeScene("view/ReturnBooks.fxml");
    }

    @FXML
    void btn_logout(ActionEvent event) throws IOException {
    	LMS_Main.changeScene("view/Login.fxml");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		lbl_libarian.setText(LoginLibrarian.login_user.getEmail());
	}
}
