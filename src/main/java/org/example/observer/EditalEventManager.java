package org.example.observer;

import java.util.ArrayList;
import java.util.List;

public class EditalEventManager {

    // Padrão Singleton para termos apenas um gerenciador no sistema inteiro
    private static EditalEventManager instance;
    private final List<EditalObserver> listeners = new ArrayList<>();

    private EditalEventManager() {}

    public static EditalEventManager getInstance() {
        if (instance == null) {
            instance = new EditalEventManager();
        }
        return instance;
    }

    public void inscrever(EditalObserver observer) {
        listeners.add(observer);
    }

    public void desinscrever(EditalObserver observer) {
        listeners.remove(observer);
    }

    public void notificarAlteracao() {
        for (EditalObserver observer : listeners) {
            observer.onEditalAlterado();
        }
    }
}