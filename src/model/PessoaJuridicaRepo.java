/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaJuridicaRepo {
    private List<PessoaJuridica> listaPessoaJuridica;

    // Construtor
    public PessoaJuridicaRepo() {
        this.listaPessoaJuridica = new ArrayList<>();
    }

    // Método inserir
    public void inserir(PessoaJuridica pessoaJuridica) {
        listaPessoaJuridica.add(pessoaJuridica);
    }

    // Método alterar
    public void alterar(PessoaJuridica pessoaJuridica) {
        for (int i = 0; i < listaPessoaJuridica.size(); i++) {
            if (listaPessoaJuridica.get(i).getId() == pessoaJuridica.getId()) {
                listaPessoaJuridica.set(i, pessoaJuridica);
                return;
            }
        }
    }

    // Método excluir
    public void excluir(int id) {
        listaPessoaJuridica.removeIf(pessoaJuridica -> pessoaJuridica.getId() == id);
    }

    // Método obter por ID
    public PessoaJuridica obter(int id) {
        for (PessoaJuridica pessoaJuridica : listaPessoaJuridica) {
            if (pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    // Método obterTodos
    public List<PessoaJuridica> obterTodos() {
        return new ArrayList<>(listaPessoaJuridica);
    }

    // Método persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaJuridica);
        }
    }

    // Método recuperar
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaJuridica = (List<PessoaJuridica>) ois.readObject();
        }
    }
}