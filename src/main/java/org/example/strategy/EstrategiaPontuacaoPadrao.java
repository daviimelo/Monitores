package org.example.strategy;

import org.example.interfaces.IEstrategiaPontuacao;
import org.example.model.Inscricao;

public class EstrategiaPontuacaoPadrao implements IEstrategiaPontuacao {

    @Override
    public double calcular(Inscricao inscricao) {
        double pesoCre = inscricao.getDisciplina().getEdital().getPesoCre();
        double pesoMedia = inscricao.getDisciplina().getEdital().getPesoMedia();
        double creAluno = inscricao.getAlunoCRE();
        double mediaAluno = inscricao.getAlunoMedia();

        return (pesoCre * creAluno) + (pesoMedia * mediaAluno);
    }
}
