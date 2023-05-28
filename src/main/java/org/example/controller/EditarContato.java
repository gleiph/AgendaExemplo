package org.example.controller;

import org.example.view.TelaAgenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditarContato implements ActionListener {
    private final TelaAgenda tela;

    public EditarContato(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.editarContato();
    }
}
