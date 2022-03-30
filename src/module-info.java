module lovehate {
	requires javafx.controls;
	requires java.desktop;
	requires com.github.kwhat.jnativehook;
	requires javafx.graphics;

	opens application to javafx.graphics, javafx.fxml;
}
