package org.example.controller;

import org.example.view.TelaAgenda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdicionarContato implements ActionListener {

    private TelaAgenda tela;

    public AdicionarContato(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tela.addContato();
    }
}
