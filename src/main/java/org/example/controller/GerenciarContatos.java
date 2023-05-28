package org.example.controller;

import org.example.model.Contato;
import org.example.persistence.ContatoPersistence;
import org.example.persistence.Persistence;
import org.example.view.TelaAgenda;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class GerenciarContatos implements WindowListener {

    private final TelaAgenda tela;

    public GerenciarContatos(TelaAgenda tela) {
        this.tela = tela;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Persistence<Contato> contatoPersistence = new ContatoPersistence();
        List<Contato> all = contatoPersistence.findAll();
        tela.carregaContatos(all);

    }

    @Override
    public void windowClosing(WindowEvent e) {
        Persistence<Contato> contatoPersistence = new ContatoPersistence();
        contatoPersistence.save(tela.listaContatos());
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
