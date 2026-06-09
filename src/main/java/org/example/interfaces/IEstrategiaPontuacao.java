package org.example.interfaces;

import org.example.model.Inscricao;

public interface IEstrategiaPontuacao {
    // Passamos a inscrição inteira. Assim, se no futuro a estratégia precisar da data da inscrição ou de notas de entrevista, ela já tem o objeto!
    double calcular(Inscricao inscricao);
}