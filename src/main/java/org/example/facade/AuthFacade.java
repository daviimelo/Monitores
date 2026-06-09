package org.example.facade;

import org.example.interfaces.UsuarioAutenticavel;
import org.example.service.LoginService;
import org.example.factory.ServiceFactory;

public class AuthFacade {
    private final LoginService loginService;

    public AuthFacade() {
        this.loginService = ServiceFactory.getLoginService();
    }

    public UsuarioAutenticavel fazerLogin(String email, String senha) {
        return loginService.fazerLogin(email, senha);
    }
}
