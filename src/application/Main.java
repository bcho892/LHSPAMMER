
package application;

import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	static App saved = new App();
	int i = 1;
	private static final String HOVERED_BUTTON_STYLE = "-fx-background-color:white; -fx-text-fill:#2c3e50; -fx-font-size:20px; -fx-font-weight:bold;";

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			primaryStage.setTitle("Love & Hate Spammer");
			primaryStage.setResizable(false);
			Label labels[] = new Label[5];
			TextField textField[] = new TextField[5];

			VBox layout = new VBox(10);
			Robot robot = new Robot();
			CheckBox unlimited = new CheckBox("Unlimited? (WARNING MUST ESC TO EXIT)");
			Label firstMessage = new Label("Message 1");

			Button spam = new Button("SPAM");
			spam.setMaxWidth(200);
			spam.setMinHeight(50);

			Tooltip secondsToLaunch = new Tooltip("You Have 3 Seconds After Clicking!");
			Tooltip setMessage = new Tooltip("Prepares Your Messages");
			Tooltip addMessage = new Tooltip("Add a Message Field");
			Tooltip removeMessage = new Tooltip("Removes Highest Order Message (Excl. #1)");
			TextField input1 = new TextField();
			input1.setMaxWidth(200);
			Button remove = new Button("Remove");
			Button save1 = new Button("Set");
			Button add = new Button("Add");
			VBox texts = new VBox();

			save1.setTooltip(setMessage);
			add.setTooltip(addMessage);
			remove.setTooltip(removeMessage);

			textField[0] = input1;

			remove.setOnAction(e -> {
				if (i > 1) {
					texts.getChildren().removeAll(textField[i - 1], labels[i - 1]);
					textField[i - 1] = null;
					i--;
				}
			});

			add.setOnAction(e -> {
				try {
					textField[i] = new TextField();
					textField[i].setMaxWidth(200);
					labels[i] = new Label("Message " + (i + 1));
					texts.getChildren().addAll(labels[i], textField[i]);
					i++;
				} catch (IndexOutOfBoundsException e1) {
					System.err.println("Max of 5!");
					AlertBox.displayWarning("Max Messages Reached!", "Maximum of 5 messages allowed only.");
				}
			});

			texts.getChildren().addAll(firstMessage, input1);
			texts.setAlignment(Pos.CENTER);

			HBox setAndAdd = new HBox();
			setAndAdd.getChildren().addAll(save1, add, remove);
			setAndAdd.setAlignment(Pos.CENTER);
			setAndAdd.setMaxWidth(200);
			setAndAdd.setSpacing(35);
			spam.setStyle(
					"-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-font-size:20px; -fx-font-weight:bold;");
			spam.setOnMouseExited(e -> {
				spam.setStyle(
						"-fx-background-color: #2c3e50; -fx-text-fill: white; -fx-font-size:20px; -fx-font-weight:bold; ");
			});
			spam.setOnMouseEntered(e -> {
				spam.setStyle(HOVERED_BUTTON_STYLE);
			});

			javafx.scene.image.Image logo = new Image("lovehate.png");
			javafx.scene.image.Image shuji = new Image("hanma.png", 50, 50, true, true);
			primaryStage.getIcons().add(new Image("pactontilt.png"));

			secondsToLaunch.setGraphic(new ImageView(shuji));
			secondsToLaunch.setShowDelay(Duration.seconds(0.2));
			spam.setTooltip(secondsToLaunch);

			save1.setOnAction(e -> {
				ArrayList<String> spamtext = new ArrayList<String>();
				for (i = 0; i < textField.length; i++) {
					try {
						String.valueOf(textField[i].getText());
					} catch (java.lang.NullPointerException e3) {
						break;
					}
					try {
						spamtext.add(String.valueOf(textField[i].getText()));
					} catch (java.lang.NullPointerException e3) {
						System.err.println("out of bounds");
						break;
					}
				}
				saved.setText(spamtext);
				AlertBox.displayWarning(null, "Succesfully Set!");

			});

			spam.setOnAction(e -> {

				if (saved.getText() == null) {
					AlertBox.displayWarning("Haven't set yet!", "Please set values.");
					System.err.println("No values entered");
				} else {
					try {
						TimeUnit.SECONDS.sleep(3);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					for (int i = 0; i < saved.getText().size(); i++) {
						for (int j = 0; j < saved.getText().get(i).length(); j++) {

							robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(saved.getText().get(i).charAt(j)));
							robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(saved.getText().get(i).charAt(j)));
						}
						robot.keyPress(KeyEvent.VK_ENTER);
						robot.keyRelease(KeyEvent.VK_ENTER);
					}

					if (unlimited.isSelected()) {
						while (true) {

							for (int i = 0; i < saved.getText().size(); i++) {
								try {
									TimeUnit.SECONDS.sleep(1);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								for (int j = 0; j < saved.getText().get(i).length(); j++) {

									robot.keyPress(
											KeyEvent.getExtendedKeyCodeForChar(saved.getText().get(i).charAt(j)));
									robot.keyRelease(
											KeyEvent.getExtendedKeyCodeForChar(saved.getText().get(i).charAt(j)));
								}
								robot.keyPress(KeyEvent.VK_ENTER);
								robot.keyRelease(KeyEvent.VK_ENTER);
							}
						}
					}
				}
			});
			VBox logoBox = new VBox();
			logoBox.getChildren().add(new ImageView(logo));

			layout.setSpacing(13);
			layout.getChildren().addAll(texts, setAndAdd);
			layout.getChildren().addAll(unlimited, spam);
			root.setLeft(logoBox);

			Hyperlink github = new Hyperlink("Github");

			github.setOnAction(e -> {
				try {
					Desktop.getDesktop().browse(new URI("http://github.com"));
				} catch (IOException e1) {
					System.err.println("IOexception");
				} catch (URISyntaxException e1) {
					System.err.println("URISyntaxException");
				}
			});

			BorderPane bottom = new BorderPane();
			bottom.setBottom(github);

			root.setRight(bottom);
			layout.setAlignment(Pos.CENTER);
			logoBox.setAlignment(Pos.CENTER);
			root.setCenter(layout);
			root.setPadding(new Insets(10));

			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add("application.css");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}
		GlobalScreen.addNativeKeyListener(new GlobalKeyListener());

		launch(args);
	}
}
