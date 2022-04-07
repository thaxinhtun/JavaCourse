package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale.Category;
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
import lms.model.entity.Categories;
import lms.model.service.DatabaseService;

public class CategoryController implements Initializable{
	 @FXML
	    private TableColumn<Categories, Integer> col_id;

	    @FXML
	    private TableColumn<Categories, String> col_name;

	    @FXML
	    private TableView<Categories> tbl_data;

	    @FXML
	    private TextField txt_id;

	    @FXML
	    private TextField txt_name;

	    @FXML
	    void brn_search(ActionEvent event) throws SQLException {
	    	String name = txt_name.getText();
	    	List<Categories> catlist = DatabaseService.FindAllCategories(name);
	    	
	    	if(catlist.size() > 0) {
	    		tbl_data.setItems(FXCollections.observableArrayList(catlist));
	    		System.out.println(catlist);
	    	}
	    	else {
	    		tbl_data.setItems(null);
	    	}
	    }

	    @FXML
	    void btn_add(ActionEvent event) {
	    	String name = txt_name.getText();

	    	if(txt_id.getText() == null ) {
	    		DatabaseService.addCategory(name);
	    		showAlert(AlertType.INFORMATION, "Successfully inserted");
	    	}
	    	else
	    	{
	    		showAlert(AlertType.ERROR, "This id is already existed.");
	    	}
	    	
	    	loadCategory();
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
	    	Categories cat = new Categories();
	    	cat.setName(txt_name.getText());
	    	cat.setId(Integer.parseInt(txt_id.getText()));
	    	lms.model.service.DatabaseService.editCategory(cat);
	    	loadCategory();
	    }

	    @FXML
	    void btn_reset(ActionEvent event) {
	    	txt_name.setText(null);
	    	txt_id.setText(null);
	    	tbl_data.getSelectionModel().clearSelection();
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			loadCategory();
			tbl_data.getSelectionModel().selectedItemProperty().addListener(
					(obs,OldSelect,newSelect)->{
						if(newSelect!=null) {
							Categories cat = tbl_data.getSelectionModel().getSelectedItem();
							txt_name.setText(cat.getName());
							txt_id.setText(String.valueOf(cat.getId()));
						}
					}
					);
		}

		private void loadCategory() {
			// TODO Auto-generated method stub
			List<Categories> catlist = lms.model.service.DatabaseService.getAllCategories();
			tbl_data.setItems(FXCollections.observableArrayList(catlist));
		}
}
