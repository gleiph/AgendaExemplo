package org.example.controller;

import org.example.view.TelaAgenda;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SelecionarContato implements ListSelectionListener {

    private final TelaAgenda tela;

    public SelecionarContato(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        tela.atualizarFormulario();
    }
}
