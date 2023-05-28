package org.example.view;

import org.example.model.Contato;

import javax.swing.*;
import java.awt.*;

public class TelaAgenda {

    private JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 200;
    private final int V_GAP = 10;
    private final int H_GAP = 5;


    public void desenha(){

        tela = new JFrame("Agenda");
        tela.setSize(WIDTH, HEIGHT);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());

        desenhaLista();
        desenhaFormulario();

        tela.pack();
    }

    private void desenhaLista(){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Contatos"));
        painel.setPreferredSize(new Dimension(WIDTH/3, HEIGHT));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Contato> model = new DefaultListModel<>();
        model.addElement(new Contato());


        JList<Contato> contatos = new JList<>(model);
//        contatos.setSize(WIDTH/3, HEIGHT);


        painel.add(new JScrollPane(contatos));

        painel.add(contatos, BorderLayout.CENTER);

        tela.getContentPane().add(painel, BorderLayout.WEST);
    }

    private void desenhaFormulario(){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder("Formulário"));


        JPanel formulario = new JPanel();
        JPanel painelLabel = new JPanel();
        painelLabel.setLayout(new GridLayout(0, 1, H_GAP,V_GAP));
        painelLabel.add(new JLabel("Nome"));
        painelLabel.add(new JLabel("Email"));
        painelLabel.add(new JLabel("Telefone"));
        painelLabel.add(new JLabel("Descrição"));


        JPanel painelField = new JPanel();
        painelField.setLayout(new GridLayout(0,1, H_GAP,V_GAP));
        painelField.add(new JTextField(20));
        painelField.add(new JTextField(20));
        painelField.add(new JTextField(20));
        painelField.add(new JTextField(20));


        formulario.add(painelLabel);
        formulario.add(painelField);

        painel.setLayout(new BorderLayout());
        painel.add(formulario, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnRemover = new JButton("Remover");
        JButton btnEditar = new JButton("Editar");

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionar);
        botoes.add(btnRemover);
        botoes.add(btnEditar);

        painel.add(botoes, BorderLayout.SOUTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);

    }


}
