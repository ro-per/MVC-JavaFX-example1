package main;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Model;
import viewEnController.View1Controller;
import viewEnController.View2Controller;

public class Main extends Application {

	private Stage primaryStage;
	private Model m;

	@Override
	public void start(Stage primaryStage) throws Exception {
		m = new Model();
		this.primaryStage = primaryStage;
		initRootLayout();
		showViewMetSlider();
		m.refresh();
	}

	public void initRootLayout() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/viewEnController/View1.fxml"));
		Parent root = loader.load();
		View1Controller controller = loader.getController();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Button view");
		primaryStage.setX(400);
		primaryStage.setY(300);
		primaryStage.show();

		controller.setModel(m);
		m.addObserver(controller);
	}

	public void showViewMetSlider() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/viewEnController/View2.fxml"));
		Parent root = loader.load();
		View2Controller controller = loader.getController();
		Stage stage = new Stage();
		stage.setTitle("Slider view");
		stage.initOwner(primaryStage);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setX(800);
		stage.setY(300);
		stage.show();

		controller.setModel(m);
		m.addObserver(controller);

	}

	public static void main(String[] args) {
		launch(args);
	}

}
