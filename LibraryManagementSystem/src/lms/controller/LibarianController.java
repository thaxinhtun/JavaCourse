package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.model.entity.Authors;
import lms.model.entity.Libarians;
import lms.model.service.DatabaseService;

public class LibarianController implements Initializable{
	  	@FXML
	    private TableColumn<Libarians, LocalDate> col_create;

	    @FXML
	    private TableColumn<Libarians, String> col_email;

	    @FXML
	    private TableColumn<Libarians, Integer> col_id;

	    @FXML
	    private TableColumn<Libarians, String> col_nrc;

	    @FXML
	    private TableColumn<Libarians, String> col_pass;

	    @FXML
	    private TableColumn<Libarians, String> col_ph;

	    @FXML
	    private TableView<Libarians> tbl_data;

	    @FXML
	    private TextField txt_email;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private TextField txt_nrc;

	    @FXML
	    private TextField txt_ph;

	  
	    @FXML
	    void btn_add(ActionEvent event) {
	    
	    	String email = txt_email.getText();
	    	String nrc = txt_nrc.getText();
	    	String phno = txt_ph.getText();
	    	
	    	Libarians searchLibarians = DatabaseService.checkLogin(email);
	    	
	    	if(txt_id.getText() == null){
	    		if(searchLibarians == null) {
	    		DatabaseService.addLibarian(email,nrc,phno);
	    		showAlert(AlertType.INFORMATION, "Successfully inserted");
	    	}
	    		else {
	    			showAlert(AlertType.ERROR, "This email is already existed.");
	    		}
	    		}
	    
	    	else
	    		{
	    		showAlert(AlertType.ERROR, "This id is already existed.");
	    		}
	    	
	    	loadLibarians();
	    }
	    private void showAlert(AlertType type, String msg) {
				// TODO Auto-generated method stub
		    	Alert alert = new Alert(type);
	    		alert.setTitle("Message");
	    		alert.setContentText(msg);
	    		alert.setHeaderText(null);
	    		alert.showAndWait();
			}
	    
	   /* private void boolean ValidateEmail()  {
	    	Pattern p = Pattern.compile([a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+));
	    }*/

	    @FXML
	    void btn_back(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/Main.fxml");
	    }

	    @FXML
	    void btn_edit(ActionEvent event) {
	    	Libarians lib = new Libarians();
	    	lib.setId(Integer.parseInt(txt_id.getText()));
	    	
	    	String email = txt_email.getText();
	    	lib.setEmail(email);
	    	
	    	lib.setNrc(txt_nrc.getText());
	    	lib.setPhno(txt_ph.getText());
	    	
	    	Libarians searchLibarians = DatabaseService.checkLogin(email);
	    	if(searchLibarians == null) {
	    		lms.model.service.DatabaseService.editLibarian(lib);
	    		showAlert(AlertType.INFORMATION, "Successfully updated.");
	    	}
	    	else if(searchLibarians != null && searchLibarians.getId() == Integer.parseInt(txt_id.getText())) {
	    		lms.model.service.DatabaseService.editLibarian(lib);
	    		showAlert(AlertType.INFORMATION, "Successfully updated.");
	    	}
	    	else
	    		showAlert(AlertType.ERROR, "This email is already exist.");
	    		loadLibarians();;
	    }

	    @FXML
	    void btn_reset(ActionEvent event) {
	    	txt_id.setText(null);
	    	txt_email.setText(null);
	    	txt_nrc.setText(null);
	    	txt_ph.setText(null);
	    	tbl_data.getSelectionModel().clearSelection();
	    }

	    @FXML
	    void btn_search(ActionEvent event) {
	    	String email = txt_email.getText();
	    	String nrc = txt_nrc.getText();
	    	String phno = txt_ph.getText();
	    	List<Libarians> liblist = DatabaseService.FindAllLibarians(email,nrc,phno);
	    	
	    	if(liblist.size() > 0) {
	    		tbl_data.setItems(FXCollections.observableArrayList(liblist));
	    		
	    	}
	    	else {
	    		tbl_data.setItems(null);
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
			col_pass.setCellValueFactory(new PropertyValueFactory<>("pass"));
			col_nrc.setCellValueFactory(new PropertyValueFactory<>("nrc"));
			col_ph.setCellValueFactory(new PropertyValueFactory<>("phno"));
			col_create.setCellValueFactory(new PropertyValueFactory<>("createDate"));
			loadLibarians();
			tbl_data.getSelectionModel().selectedItemProperty().addListener(
					(obs,OldSelect,newSelect)->{
						if(newSelect!=null) {
							Libarians lib = tbl_data.getSelectionModel().getSelectedItem();
							txt_id.setText(String.valueOf(lib.getId()));
							txt_email.setText(lib.getEmail());
							txt_ph.setText(lib.getPhno());
							txt_nrc.setText(lib.getNrc());
							
						}
					}
					);
		}

		private void loadLibarians() {
			// TODO Auto-generated method stub
			List<Libarians> libarianList = lms.model.service.DatabaseService.getAllLibarians();
			tbl_data.setItems(FXCollections.observableArrayList(libarianList));
		}
}
