package lms.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lms.LMS_Main;
import lms.model.entity.Libarians;
import lms.model.service.DatabaseService;

public class LoginLibrarian {
	public static Libarians login_user;
    @FXML
    private Label lbl_status;

    @FXML
    private TextField txt_name;

    @FXML
    private PasswordField txt_password;

    @FXML
    void btn_login(ActionEvent event) throws IOException {
    	
    	String email = txt_name.getText();
		//System.out.println("Name: "+name);
		String pass = txt_password.getText();
		//System.out.println("Password: "+pass);
		Libarians searchLibarians = DatabaseService.checkLogin(email);
		
		if(searchLibarians != null) {
			if(searchLibarians.getEmail().equals(email) && searchLibarians.getPass().equals(pass)) {
			lbl_status.setText("Login success");
			login_user = searchLibarians;
			LMS_Main.changeScene("view/Main.fxml");
			}
			else
			lbl_status.setText("User name and password do not match!");
			}
		else if(email.isEmpty() || pass.isEmpty()) 
			lbl_status.setText("Please fill all texts");
		else
			lbl_status.setText("This Libarian is not register yet!");
    }
   
}
