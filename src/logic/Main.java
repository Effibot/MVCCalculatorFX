package logic;
	
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	private static final Logger logger = Logger.getLogger(Main.class.getName());
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			logger.info(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
