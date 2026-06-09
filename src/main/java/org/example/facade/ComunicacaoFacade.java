package org.example.facade;

import jakarta.mail.MessagingException;
import org.example.util.Mensageiro;

public class ComunicacaoFacade {

    public void enviarEmail(String destinatario, String assunto, String mensagem) throws MessagingException {
        Mensageiro.enviarEmail(destinatario, assunto, mensagem);
    }
}