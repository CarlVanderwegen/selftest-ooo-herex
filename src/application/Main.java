package application;

import javafx.application.Application;
import javafx.stage.Stage;
import controller.SelftestController;

public class Main extends Application {

	SelftestController controller;

	@Override
	public void start(Stage primaryStage) {

		try {
			controller = new SelftestController(primaryStage);
			controller.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
