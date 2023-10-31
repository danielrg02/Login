	package dad.login;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {

    private Stage stage;
    private LoginController controller;

    private TextField usernameField;
    private PasswordField passwordField;
    private CheckBox useLDAPCheckBox;
    private Label messageLabel;

    public LoginView(Stage stage) {
        this.stage = stage;
        stage.setResizable(false);

        usernameField = new TextField();
        passwordField = new PasswordField();
        useLDAPCheckBox = new CheckBox("Usar LDAP");
        messageLabel = new Label();

        Button loginButton = new Button("Acceder");
        Button cancelButton = new Button("Cancelar");

        loginButton.setOnAction(event -> {
			try {
				controller.onLoginButtonClicked();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

        cancelButton.setOnAction(event -> System.exit(0));

        VBox root = new VBox(10);
        root.setPadding(new Insets(10));
        root.getChildren().addAll(
                new Label("Usuario:"),
                usernameField,
                new Label("Contraseña:"),
                passwordField,
                useLDAPCheckBox,
                loginButton,
                cancelButton,
                messageLabel
        );

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    public boolean isUseLDAP() {
        return useLDAPCheckBox.isSelected();
    }

    public void showMessage(String message) {
        messageLabel.setText(message);
    }

    public void clearPassword() {
        passwordField.clear();
    }

    public void show() {
        stage.show();
    }
}