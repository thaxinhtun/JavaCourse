package lms.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import lms.LMS_Main;
import lms.model.entity.Authors;
import lms.model.entity.Books;
import lms.model.entity.Categories;
import lms.model.service.DatabaseService;

public class BookController implements Initializable{
	//public static int checkavailable;
	public static Books bookavailable;
	 @FXML
	    private ComboBox<String> cbo_author;

	    @FXML
	    private ComboBox<String> cbo_category;

	    @FXML
	    private TableColumn<Authors, String> col_author;

	    @FXML
	    private TableColumn<Books, Integer> col_avaliable;

	    @FXML
	    private TableColumn<Categories, String> col_category;

	    @FXML
	    private TableColumn<Books, Integer> col_code;

	    @FXML
	    private TableColumn<Books, String> col_title;

	    @FXML
	    private TableView<Books> tbl_data;

	    @FXML
	    private TextField txt_avaliable;

	    @FXML
	    private TextField txt_code;

	    @FXML
	    private TextField txt_title;
	    
	    @FXML
	    private TextField search_author;

	    @FXML
	    private TextField search_available;

	    @FXML
	    private TextField search_category;
	    
	    @FXML
	   
	    void btn_add(ActionEvent event) {
	    	
	    	int code =Integer.parseInt(txt_code.getText()); 
	    	String title = txt_title.getText();
	    	//int avaliable = 1;
	    	int author_index = cbo_author.getSelectionModel().getSelectedIndex();
	    	int category_index = cbo_category.getSelectionModel().getSelectedIndex();
	    	/*if()		
	    		ShowAlert(AlertType.WARNING, "Please enter code");
	    		return;
	    	}*/
	    	if(title.isEmpty()) {
	    		ShowAlert(AlertType.WARNING, "Please enter title");
	    		return;
	    	}
	    	/*if(avaliable != 0 || avaliable !=1) {
	    		ShowAlert(AlertType.WARNING, "Please choose available or not");
	    		return;
	    	}*/
	    	if(author_index == -1) {
	    		ShowAlert(AlertType.WARNING, "Please choose author");
	    		return;
	    	}
	    	if(category_index == -1) {
	    		ShowAlert(AlertType.WARNING, "Please choose category");
	    		return;
	    	}
	    	//save
	    	Books book = new Books();
	    	book.setCode(code);
	    	book.setTitle(title);
	    	book.setIs_avaliable(1);
	    	book.setCategory(categoryList.get(category_index));
	    	book.setAuthor(authorList.get(author_index));
	    	
	    	if(lms.model.service.DatabaseService.addBook(book)) {
	    		tbl_data.getItems().add(book);
	    	}
	    	else {
	    		ShowAlert(AlertType.ERROR, "Something is wrong! Please try again");
	    		
	    	}
	    }
	 
	    
	    private void ShowAlert(AlertType type, String body) {
			// TODO Auto-generated method stub
			Alert alert = new Alert(type);
			alert.setTitle("Message");
			alert.setHeaderText(null);
			alert.setContentText(body);
			alert.showAndWait();
	
		}


	    @FXML
	    void btn_back(ActionEvent event) throws IOException {
	    	LMS_Main.changeScene("view/Main.fxml");
	    }

	    @FXML
	    void btn_edit(ActionEvent event) {
	    	
	    	Books book = new Books();
	    	book.setCode(Integer.parseInt(txt_code.getText()));
	    	book.setTitle(txt_title.getText());
	    	book.setIs_avaliable(1);
	    	
	    	int author_index = cbo_author.getSelectionModel().getSelectedIndex();
	    	int cat_index = cbo_category.getSelectionModel().getSelectedIndex();
	    	
	    	book.setAuthor(authorList.get(author_index));
	    	book.setCategory(categoryList.get(cat_index));
	    	if(txt_code.getText()!=null || txt_title.getText()!=null || txt_avaliable.getText()!=null) {
	    		
	    	}
	    	if(lms.model.service.DatabaseService.EditBook(book)) {
	    		ShowAlert(AlertType.INFORMATION, "Update Success");
	    		txt_code.setText(null);
	    		txt_title.setText(null);
	    		txt_avaliable.setText(null);
	    		cbo_author.getSelectionModel().clearSelection();
	    		cbo_category.getSelectionModel().clearSelection();
	    		LoadBooks();
	    		LoadAuthors();
	    		LoadCategories();	
	    	}
	    	
	    	else {
	    		ShowAlert(AlertType.ERROR, "Something is wrong");
	    	}
	    }

	    @FXML
	    void btn_reset(ActionEvent event) {
	    	txt_code.setText(null);
	    	txt_title.setText(null);
	    	txt_avaliable.setText(null);
	    	cbo_author.getSelectionModel().clearSelection();
	    	cbo_category.getSelectionModel().clearSelection();
	    }

	    @FXML
	    void btn_search(ActionEvent event) {
	   
	    	String avaliable = search_available.getText();
	    	String author = search_author.getText();
	    	String category = search_category.getText();
	    	
	    	List<Books> bookList = DatabaseService.findAllBooks(avaliable,author,category);
	    	if(bookList.size() > 0) {
	    		tbl_data.setItems(FXCollections.observableArrayList(bookList));
	    	}
	    	else {
	    		tbl_data.setItems(null);
	    	}
	    }
	    private List<Authors> authorList;
	    private List<Categories> categoryList;
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			col_avaliable.setCellValueFactory(new PropertyValueFactory<>("is_avaliable"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			tbl_data.getSelectionModel().selectedItemProperty().addListener(
					(obs,OldSelect,newSelect)->{
						if(newSelect!=null) {
							Books book = tbl_data.getSelectionModel().getSelectedItem();
							txt_code.setText(String.valueOf(book.getCode()));
							txt_title.setText(book.getTitle());
							txt_avaliable.setText(String.valueOf(book.getIs_avaliable()));
							cbo_author.getSelectionModel().select(book.getAuthorName());
							cbo_category.getSelectionModel().select(book.getCategoryName());
						}
					}
					);
			LoadBooks();
			LoadAuthors();
			LoadCategories();
			
		}

		private void LoadBooks() {
			// TODO Auto-generated method stub
			
			
			List<Books> booklist = lms.model.service.DatabaseService.getAllBooks();
			tbl_data.setItems(FXCollections.observableArrayList(booklist));
		}

		private void LoadCategories() {
			// TODO Auto-generated method stub
			categoryList= lms.model.service.DatabaseService.getAllCategories();

			List<String> names = categoryList.stream()
										.map(obj -> obj.getName())
										.collect(Collectors.toList());
			cbo_category.setItems(FXCollections.observableArrayList(names));
		}

		private void LoadAuthors() {
			// TODO Auto-generated method stub
			authorList = lms.model.service.DatabaseService.getAllAuthors();
			
			List<String> names = authorList.stream()
										.map(obj -> obj.getName())
										.collect(Collectors.toList());
			cbo_author.setItems(FXCollections.observableArrayList(names));
		}
}
