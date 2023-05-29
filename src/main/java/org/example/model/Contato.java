package org.example.model;

import org.example.exception.EmailException;

public class Contato {

    private String nome;
    private String telefone;
    private Email email;
    private String descricao;

    public Contato() {
    }

    public Contato(String nome, String telefone, Email email, String descricao) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public void setEmail(String email) throws EmailException {
        this.email = new Email(email);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}


