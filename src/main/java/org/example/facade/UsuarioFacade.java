package org.example.facade;

import org.example.exception.UsuarioJaExisteException;
import org.example.model.Aluno;
import org.example.service.AlunoService;
import org.example.service.CoordenadorService;
import org.example.factory.ServiceFactory;

import java.util.List;

public class UsuarioFacade {
    private final AlunoService alunoService;
    private final CoordenadorService coordenadorService;

    public UsuarioFacade() {
        this.alunoService = ServiceFactory.getAlunoService();
        this.coordenadorService = ServiceFactory.getCoordenadorService();
    }

    public void cadastrarAluno(String email, String senha, String matricula, String nome) throws UsuarioJaExisteException {
        alunoService.cadastrarAluno(email, senha, matricula, nome);
    }

    public void atualizarPerfilAluno(Aluno aluno) {
        alunoService.atualizarAluno(aluno);
    }

    public List<Aluno> retornarAlunos() {
        return alunoService.retornarAlunos();
    }

    public void cadastrarCoordenador(String email, String senha) throws UsuarioJaExisteException {
        coordenadorService.cadastrarCoordenador(email, senha);
    }

    public boolean existeCoordenadorCadastrado() {
        return coordenadorService.existeCoordenadorCadastrado();
    }
}