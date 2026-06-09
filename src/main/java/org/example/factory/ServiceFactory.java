package org.example.factory;

import org.example.interfaces.*;
import org.example.repository.*;
import org.example.service.*;
import org.example.strategy.EstrategiaPontuacaoPadrao;

public class ServiceFactory {

    // Instâncias únicas dos repositórios e estratégias (Singleton)
    private static IAlunoRepository alunoRepository;
    private static ICoordenadorRepository coordenadorRepository;
    private static IEditalRepository editalRepository;
    private static IInscricaoRepository inscricaoRepository;
    private static IEstrategiaPontuacao estrategiaPontuacao;

    // Métodos privados para garantir que os repositórios só sejam criados uma vez (Lazy Initialization)
    private static IAlunoRepository getAlunoRepository() {
        if (alunoRepository == null) {
            alunoRepository = new AlunoRepository();
        }
        return alunoRepository;
    }

    private static ICoordenadorRepository getCoordenadorRepository() {
        if (coordenadorRepository == null) {
            coordenadorRepository = new CoordenadorRepository();
        }
        return coordenadorRepository;
    }

    private static IEditalRepository getEditalRepository() {
        if (editalRepository == null) {
            editalRepository = new EditalRepository();
        }
        return editalRepository;
    }

    private static IInscricaoRepository getInscricaoRepository() {
        if (inscricaoRepository == null) {
            inscricaoRepository = new InscricaoRepository();
        }
        return inscricaoRepository;
    }

    private static IEstrategiaPontuacao getEstrategiaPontuacao() {
        if (estrategiaPontuacao == null) {
            estrategiaPontuacao = new EstrategiaPontuacaoPadrao();
        }
        return estrategiaPontuacao;
    }

    // Métodos Públicos

    public static AlunoService getAlunoService() {
        return new AlunoService(getAlunoRepository(), getCoordenadorRepository());
    }

    public static CoordenadorService getCoordenadorService() {
        return new CoordenadorService(getAlunoRepository(), getCoordenadorRepository());
    }

    public static EditalService getEditalService() {
        return new EditalService(getEditalRepository());
    }

    public static InscricaoService getInscricaoService() {
        return new InscricaoService(getInscricaoRepository(), getEstrategiaPontuacao());
    }

    public static LoginService getLoginService() {
        return new LoginService(getAlunoRepository(), getCoordenadorRepository());
    }
}
