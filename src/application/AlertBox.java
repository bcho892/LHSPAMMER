package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

	public static void displayWarning(String title, String message) {
		Stage window = new Stage();
		window.setResizable(false);

		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);

		Label label = new Label();
		label.setText(message);
		Button closeButton = new Button("Ok");
		closeButton.setOnAction(e -> window.close());

		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout, 250, 80);
		scene.getStylesheets().add("application.css");

		window.setScene(scene);
		window.showAndWait();
	}

}