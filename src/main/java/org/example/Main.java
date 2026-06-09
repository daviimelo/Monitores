package org.example;

import org.example.facade.UsuarioFacade;
import org.example.view.screens.TelaCadastroCoordenador;
import org.example.view.screens.TelaLogin;

public class Main {
    public static void main(String[] args) {

        UsuarioFacade usuarioFacade = new UsuarioFacade();

        if (!usuarioFacade.existeCoordenadorCadastrado()) {
            TelaCadastroCoordenador telaCadastroCoordenador = new TelaCadastroCoordenador();
            telaCadastroCoordenador.setVisible(true);
        }
        else {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
        }
    }
}