package dad.login;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        LoginModel model = new LoginModel();
        LoginView view = new LoginView(primaryStage);
        LoginController controller = new LoginController(model, view);

        view.setController(controller);
        primaryStage.setTitle("Inicio de Sesión");
        view.show();

        boolean useLdap = true;
        controller.autenticar(useLdap);
    }
}
