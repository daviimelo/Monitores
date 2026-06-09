package org.example.facade;

import org.example.exception.ListaVaziaException;
import org.example.model.Disciplina;
import org.example.model.Edital;
import org.example.observer.EditalEventManager;
import org.example.service.EditalService;
import org.example.factory.ServiceFactory;

import java.time.LocalDate;
import java.util.List;

public class EditalFacade {
    private final EditalService editalService;

    public EditalFacade() {
        this.editalService = ServiceFactory.getEditalService();
    }

    public void cadastrarEdital(LocalDate dataInicio, LocalDate dataFinal, int maximoInscricoes,
                                double pesoCre, double pesoMedia, List<Disciplina> listaDisciplinas) throws ListaVaziaException {
        editalService.cadastrarEdital(dataInicio, dataFinal, maximoInscricoes, pesoCre, pesoMedia, listaDisciplinas);

        // Avisa a todo mundo que o edital foi criado
        EditalEventManager.getInstance().notificarAlteracao();
    }

    public void salvarEdital(Edital edital) {
        editalService.salvarEdital(edital);

        // Avisa a todo mundo que um edital foi alterado/fechado
        EditalEventManager.getInstance().notificarAlteracao();
    }

    public List<Edital> retornarEditais() {
        return editalService.retornarEditais();
    }


}