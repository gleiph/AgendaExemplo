package org.example.model;

public class Contato {

    private String nome;
    private String telefone;
    private String email;
    private String descricao;

    public Contato() {
    }

    public Contato(String nome, String telefone, String email, String descricao) {
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


