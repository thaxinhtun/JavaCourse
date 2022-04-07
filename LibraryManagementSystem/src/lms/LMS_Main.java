package lms;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class LMS_Main extends Application {
	public static Stage primaryStage;
	@Override
	public void start(Stage stage) {
		
		try {
			primaryStage = stage;
			AnchorPane root = (AnchorPane)FXMLLoader.load(LMS_Main.class.getResource("view/Login.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("Library Management System");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void changeScene(String view) throws IOException {
		Parent root = FXMLLoader.load(LMS_Main.class.getResource(view));
		Scene scene = new Scene(root);
		primaryStage.hide();
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
