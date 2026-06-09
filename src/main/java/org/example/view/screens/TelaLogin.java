package org.example.view.screens;

import org.example.enums.TipoPerfil;
import org.example.facade.AuthFacade;
import org.example.interfaces.UsuarioAutenticavel;
import org.example.model.Aluno;
import org.example.view.components.base.BaseTela;
import org.example.view.components.buttons.BotaoPrimario;
import org.example.view.components.input.InputSenha;
import org.example.view.components.input.InputTexto;
import org.example.view.components.links.LinkTexto;
import org.example.view.components.text.LabelTexto;
import org.example.view.components.text.LabelTitulo;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends BaseTela {

    private LabelTitulo labelTitulo;
    private LabelTexto labelEmail;
    private LabelTexto labelSenha;
    private InputTexto campoEmail;
    private InputSenha campoSenha;
    private BotaoPrimario btnEntrar;
    private LinkTexto rotaCadastroAluno;

    // Agora usamos a Fachada de Autenticação
    private AuthFacade authFacade;

    public TelaLogin() {
        super("Login", 400, 500);

        // Inicializa a fachada
        this.authFacade = new AuthFacade();

        initView();
    }

    @Override
    public void initComponents() {
        labelTitulo = new LabelTitulo("Login");
        labelEmail = new LabelTexto("Email:");
        labelSenha = new LabelTexto("Senha:");
        campoEmail = new InputTexto();
        campoSenha = new InputSenha();
        btnEntrar = new BotaoPrimario("Logar");
        rotaCadastroAluno = new LinkTexto("Clique aqui se você ainda não tem uma conta", SwingConstants.RIGHT);
    }

    @Override
    public void initListeners() {
        btnEntrar.addActionListener(e -> {
            String email = campoEmail.getText();
            String senha = new String(campoSenha.getPassword());

            // Chamada via Fachada
            UsuarioAutenticavel usuario = authFacade.fazerLogin(email, senha);

            if (usuario == null) {
                JOptionPane.showMessageDialog(this, "Email ou senha inválidos, tente novamente!");
            }
            else if (usuario.getTipoPerfil() == TipoPerfil.ALUNO) {
                dispose();
                new TelaHomeAluno((Aluno) usuario).setVisible(true);
            }
            else if (usuario.getTipoPerfil() == TipoPerfil.COORDENADOR) {
                dispose();
                new TelaHomeCoordenador().setVisible(true);
            }
        });

        rotaCadastroAluno.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new TelaCadastroAluno().setVisible(true);
            }
        });
    }

    @Override
    public void initLayout() {
        labelTitulo.setBounds(0, 60, 400, 30);
        add(labelTitulo);

        labelEmail.setBounds(50, 120, 300, 20);
        add(labelEmail);

        campoEmail.setBounds(50, 145, 300, 40);
        add(campoEmail);

        labelSenha.setBounds(50, 200, 300, 20);
        add(labelSenha);

        campoSenha.setBounds(50, 225, 300, 40);
        add(campoSenha);

        rotaCadastroAluno.setBounds(50, 270, 300, 20);
        add(rotaCadastroAluno);

        btnEntrar.setBounds(50, 310, 300, 45);
        add(btnEntrar);
    }
}