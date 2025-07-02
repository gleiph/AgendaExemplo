package org.example.persistence;

import org.example.model.Contato;

import java.util.List;

public interface ContatoPersistence {

    String DIRECTORY = "data";
    public void save(List<Contato> itens);
    public List<Contato> findAll();

}
