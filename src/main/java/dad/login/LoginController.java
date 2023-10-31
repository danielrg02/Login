package dad.login;

import dad.login.auth.AuthService;
import dad.login.auth.FileAuthService;
import dad.login.auth.LdapAuthService;

public class LoginController {

    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;
    }

    public void onLoginButtonClicked() throws Exception {
        String username = view.getUsername();
        String password = view.getPassword();

        if (model.authenticate(username, password)) {
            view.showMessage("Acceso permitido");
            view.clearPassword();
        } else {
            view.showMessage("Acceso denegado");
            view.clearPassword();
        }
    }

    public void autenticar(boolean useLDAP) throws Exception {
        AuthService auth = useLDAP ? new LdapAuthService() : new FileAuthService();
        boolean result1 = auth.login("cnorris", "patada");
        boolean result2 = auth.login("cbronson", "Metrallet@1");
        boolean result3 = auth.login("dcarradine", "kungfu");
        boolean result4 = auth.login("dcarradine", "karate");
        boolean result5 = auth.login("mknight", "kit");

        System.out.println("Chuck Norris    : " + result1);
        System.out.println("Charles Bronson : " + result2);
        System.out.println("David Carradine : " + result3);
        System.out.println("David Carradine : " + result4);
        System.out.println("Michael Knight  : " + result5);
    }
}