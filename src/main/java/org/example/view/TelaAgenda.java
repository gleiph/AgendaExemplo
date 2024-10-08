package org.example.view;

import org.example.controller.*;
import org.example.exception.EmailException;
import org.example.model.Contato;
import org.example.model.Email;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TelaAgenda {

    private JFrame tela;
    private final int WIDTH = 500;
    private final int HEIGHT = 200;
    private final int V_GAP = 10;
    private final int H_GAP = 5;

    private JTextField tfNome;
    private JTextField tfEmail;
    private JTextField tfTelefone;
    private JTextField tfDescricao;
    private JList<Contato> jlContatos;

    public void desenha(){

        tela = new JFrame("Agenda");
        tela.addWindowListener(new GerenciarContatos(this));
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


        jlContatos = new JList<>(model);
        jlContatos.addListSelectionListener(new SelecionarContato(this));

        painel.add(new JScrollPane(jlContatos), BorderLayout.CENTER);

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
        tfNome = new JTextField(20);
        tfEmail = new JTextField(20);
        tfTelefone = new JTextField(20);
        tfDescricao = new JTextField(20);

        painelField.add(tfNome);
        painelField.add(tfEmail);
        painelField.add(tfTelefone);
        painelField.add(tfDescricao);


        formulario.add(painelLabel);
        formulario.add(painelField);

        painel.setLayout(new BorderLayout());
        painel.add(formulario, BorderLayout.CENTER);

        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(new AdicionarContato(this));

        JButton btnRemover = new JButton("Remover");
        btnRemover.addActionListener(new RemoverContato(this));

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(new EditarContato(this));

        JPanel botoes = new JPanel();
        botoes.add(btnAdicionar);
        botoes.add(btnRemover);
        botoes.add(btnEditar);

        painel.add(botoes, BorderLayout.SOUTH);

        tela.getContentPane().add(painel, BorderLayout.CENTER);

    }

    public void carregaContatos(List<Contato> contatos){

        DefaultListModel<Contato> model = (DefaultListModel<Contato>)jlContatos.getModel();

        for (Contato c: contatos
             ) {
            model.addElement(c);
        }

    }

    public List<Contato> listaContatos(){
        DefaultListModel<Contato> model = (DefaultListModel<Contato>)jlContatos.getModel();
        List<Contato> contatos = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            contatos.add(model.get(i));
        }

        return contatos;
    }


    public void addContato(){

        DefaultListModel<Contato> model = (DefaultListModel<Contato>)jlContatos.getModel();
        try {
            model.addElement(new Contato(tfNome.getText(), 
                    tfTelefone.getText(), new Email(tfEmail.getText())
                    , tfDescricao.getText()));
        } catch (EmailException e) {
            JOptionPane.showMessageDialog(tela, "O email " 
                    +tfEmail.getText() +" é invalido!");
        }

    }

    public void removerContato(){

        int selectedIndex = jlContatos.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Contato> model = 
                    (DefaultListModel<Contato>)jlContatos.getModel();
            model.remove(selectedIndex);
        }
    }

    public void atualizarFormulario(){
        int selectedIndex = jlContatos.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Contato> model = (DefaultListModel<Contato>)jlContatos.getModel();
            Contato contato = model.get(selectedIndex);
            tfNome.setText(contato.getNome());
            tfEmail.setText(contato.getEmail());
            tfTelefone.setText(contato.getTelefone());
            tfDescricao.setText(contato.getDescricao());

        }

    }

    public void editarContato(){

        int selectedIndex = jlContatos.getSelectedIndex();

        if(selectedIndex != -1){

            DefaultListModel<Contato> model = (DefaultListModel<Contato>)jlContatos.getModel();

            Contato contato = model.get(selectedIndex);

            model.remove(selectedIndex);

            try {
                contato.setEmail(tfEmail.getText());
                contato.setNome(tfNome.getText());
                contato.setTelefone(tfTelefone.getText());
                contato.setDescricao(tfDescricao.getText());
                model.add(selectedIndex, contato);
            }catch(EmailException ex){
                JOptionPane.showMessageDialog(tela, "O email " +tfEmail.getText() +" é invalido!");
            }
        }


        tela.pack();

    }

}
