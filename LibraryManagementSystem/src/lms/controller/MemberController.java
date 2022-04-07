package lms.controller;

import java.io.IOException;
import java.lang.reflect.Member;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.model.entity.Authors;
import lms.model.entity.Members;
import lms.model.service.DatabaseService;

public class MemberController implements Initializable{
    @FXML
    private TableColumn<Members, String> col_acedamic;

    @FXML
    private TableColumn<Members, Integer> col_card;

    @FXML
    private TableColumn<Members, String> col_class;

    @FXML
    private TableColumn<Members, LocalDate> col_create;
    @FXML
    private DatePicker txt_create;

    @FXML
    private DatePicker txt_expire;
    @FXML
    private TableColumn<Members, LocalDate> col_expire;

    @FXML
    private TableColumn<Members, String> col_name;

    @FXML
    private TableColumn<Members, String> col_rollno;

    @FXML
    private TextField search_card;

    @FXML
    private DatePicker search_expire;

    @FXML
    private TextField search_name;

    @FXML
    private TextField txt_acedamic;

    @FXML
    private TextField txt_card;

    @FXML
    private TextField txt_class;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_rollno;
    
    @FXML
    private TableView<Members> tbl_data;
    
    @FXML
    void btn_add(ActionEvent event) {

    	String name = txt_name.getText();
    	String rollno = txt_rollno.getText();
    	String classyr = txt_class.getText();
    	String academicyr = txt_acedamic.getText();
    	LocalDate create = txt_create.getValue().now();
    	LocalDate expire = create.plusYears(1);
    	if(txt_card.getText()== null) {
    		DatabaseService.addMembers(name,rollno,classyr,academicyr,create,expire);
    		showAlert(AlertType.INFORMATION, "Successfully inserted");
    	}
    	else
    	{
    		showAlert(AlertType.ERROR, "This id is already existed.");
    	}
    	
    	loadMembers();
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
    	Members mem = new Members();
    	mem.setCardid(Integer.parseInt(txt_card.getText()));
    	mem.setName(txt_name.getText());
    	mem.setRollno(txt_rollno.getText());
    	mem.setClassyear(txt_class.getText());
    	mem.setAcademic(txt_acedamic.getText());
    	mem.setCreate(txt_create.getValue());
    	mem.setExpire(txt_create.getValue().plusYears(1));
    	lms.model.service.DatabaseService.editMembers(mem);
    	loadMembers();
    }

    @FXML
    void btn_reset(ActionEvent event) {
    	txt_card.setText(null);
    	txt_name.setText(null);
    	txt_rollno.setText(null);
    	txt_class.setText(null);
    	txt_acedamic.setText(null);
    	txt_create.setValue(null);
    	txt_expire.setValue(null);
    	tbl_data.getSelectionModel().clearSelection();
    
    }

    @FXML
    void btn_search(ActionEvent event) throws SQLException {
    	String card = search_card.getText();
    	String name = search_name.getText();
    	LocalDate expired =search_expire.getValue();
    	
    	List<Members> memlist = DatabaseService.FindAllMembers(card,name,expired);
    	
    	if(memlist.size() > 0) {
    		tbl_data.setItems(FXCollections.observableArrayList(memlist));
    		System.out.println(memlist);
    	}
    	else {
    		tbl_data.setItems(null);
    	}
    }

    @FXML
    void tbl_data(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		col_card.setCellValueFactory(new PropertyValueFactory<>("cardid"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
		col_class.setCellValueFactory(new PropertyValueFactory<>("classyear"));
		col_acedamic.setCellValueFactory(new PropertyValueFactory<>("academic"));
		col_create.setCellValueFactory(new PropertyValueFactory<>("create"));
		col_expire.setCellValueFactory(new PropertyValueFactory<>("expire"));
		loadMembers();
		tbl_data.getSelectionModel().selectedItemProperty().addListener(
				(obs,OldSelect,newSelect)->{
					if(newSelect!=null) {
						Members mem = tbl_data.getSelectionModel().getSelectedItem();
						txt_card.setText(String.valueOf(mem.getCardid()) );
						txt_name.setText(mem.getName());
						txt_rollno.setText(mem.getRollno());
						txt_class.setText(mem.getClassyear());
						txt_acedamic.setText(mem.getAcademic());
						txt_create.setValue(mem.getCreate());
						txt_expire.setValue(mem.getCreate().plusYears(1));
						
					}
				}
				);	
	}

	private void loadMembers() {
		// TODO Auto-generated method stub
		List<Members> authorList = lms.model.service.DatabaseService.getAllMembers();
		tbl_data.setItems(FXCollections.observableArrayList(authorList));
	}
}
