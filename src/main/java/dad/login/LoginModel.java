package dad.login;

import dad.login.auth.AuthService;
import dad.login.auth.LdapAuthService;

public class LoginModel {
    private AuthService authService;

    public LoginModel() {
        authService = new LdapAuthService(); // Cambia a FileAuthService si es necesario
    }

    public boolean authenticate(String username, String password) throws Exception {
        return authService.login(username, password);
    }
}