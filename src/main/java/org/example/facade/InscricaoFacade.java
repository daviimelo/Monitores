package org.example.facade;

import org.example.exception.AlunoJaInscritoException;
import org.example.exception.InscricaoInvalida;
import org.example.model.Aluno;
import org.example.model.Disciplina;
import org.example.model.Edital;
import org.example.model.Inscricao;
import org.example.service.InscricaoService;
import org.example.factory.ServiceFactory;

import java.util.List;

public class InscricaoFacade {
    private final InscricaoService inscricaoService;

    public InscricaoFacade() {
        this.inscricaoService = ServiceFactory.getInscricaoService();
    }

    public void criarInscricao(Aluno aluno, Disciplina disciplina, Double cre, Double media) throws InscricaoInvalida, AlunoJaInscritoException {
        inscricaoService.criarInscricao(aluno, disciplina, cre, media);
    }

    public double calcularPontuacao(Inscricao inscricao) {
        return inscricaoService.calcularPontuacao(inscricao);
    }

    public List<Inscricao> processarResultadoDisciplina(Disciplina disciplina) {
        return inscricaoService.processarResultadoDaDisciplina(disciplina);
    }

    public List<Inscricao> buscarAprovacoesDoAluno(Aluno aluno) {
        return inscricaoService.retornarAprovacoesAluno(aluno);
    }

    public void desistirVagaMonitoria(Aluno aluno, Disciplina disciplina) {
        inscricaoService.desistirInscricao(aluno, disciplina);
    }

    public List<Inscricao> retornarInscricoesDaDisciplina(Disciplina disciplina) {
        return inscricaoService.retornarInscricoesDaDisciplina(disciplina);
    }

    public List<Inscricao> retornarTodasInscricoes() {
        return inscricaoService.retornarTodasInscricoes();
    }

    public List<Inscricao> retornarInscricoesEdital(Edital edital) {
        return inscricaoService.retornarInscricoesEdital(edital);
    }
}