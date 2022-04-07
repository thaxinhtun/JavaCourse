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
import lms.model.service.DatabaseService;

public class AuthorController implements Initializable{
	 @FXML
	    private TableColumn<Authors,String> col_country;

	    @FXML
	    private TableColumn<Authors, Integer> col_id;

	    @FXML
	    private TableColumn<Authors, String> col_name;

	    @FXML
	    private TableView<Authors> tbl_data;

	    @FXML
	    private TextField txt_country;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private TextField txt_name;

	    @FXML
	    void btn_add(ActionEvent event) throws SQLException {
	    
	    	String name = txt_name.getText();
	    	String country = txt_country.getText();
	    	
	    	if(txt_id.getText() == null ) {
	    		DatabaseService.addAuthor(name,country);
	    		showAlert(AlertType.INFORMATION, "Successfully inserted");
	    	}
	    	else
	    	{
	    		showAlert(AlertType.ERROR, "This id is already existed.");
	    	}
	    	
	    	loadAuthors();
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
	    void btn_back(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/Main.fxml");
	    }

	    @FXML
	    void btn_edit(ActionEvent event) {
	    	
	    	Authors author = new Authors();
	    	author.setCountry(txt_country.getText());
	    	author.setName(txt_name.getText());
	    	author.setId(Integer.parseInt(txt_id.getText()));
	    	lms.model.service.DatabaseService.editAuthor(author);
	    	loadAuthors();
	    }

	    @FXML
	    void btn_reset(ActionEvent event) {
	    	txt_country.setText(null);
	    	txt_name.setText(null);
	    	txt_id.setText(null);
	    	tbl_data.getSelectionModel().clearSelection();
	    }

	    @FXML
	    void btn_search(ActionEvent event) throws SQLException {
	    	String name = txt_name.getText();
	    	String country = txt_country.getText();
	    	List<Authors> authlist = DatabaseService.FindAllAuthors(name,country);
	    	
	    	if(authlist.size() > 0) {
	    		tbl_data.setItems(FXCollections.observableArrayList(authlist));
	    		System.out.println(authlist);
	    	}
	    	else {
	    		tbl_data.setItems(null);
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			col_country.setCellValueFactory(new PropertyValueFactory<>("country"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			loadAuthors();
			tbl_data.getSelectionModel().selectedItemProperty().addListener(
					(obs,OldSelect,newSelect)->{
						if(newSelect!=null) {
							Authors auth = tbl_data.getSelectionModel().getSelectedItem();
							txt_country.setText(auth.getCountry());
							txt_name.setText(auth.getName());
							txt_id.setText(String.valueOf(auth.getId()));
						}
					}
					);
		}

		private void loadAuthors() {
			// TODO Auto-generated method stub
			List<Authors> authorList = lms.model.service.DatabaseService.getAllAuthors();
			tbl_data.setItems(FXCollections.observableArrayList(authorList));
		}
	    
}
