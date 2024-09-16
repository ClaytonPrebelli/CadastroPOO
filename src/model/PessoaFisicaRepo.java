/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private List<PessoaFisica> listaPessoaFisica;

    // Construtor
    public PessoaFisicaRepo() {
        this.listaPessoaFisica = new ArrayList<>();
    }

    // Método inserir
    public void inserir(PessoaFisica pessoaFisica) {
        listaPessoaFisica.add(pessoaFisica);
    }

    // Método alterar
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i = 0; i < listaPessoaFisica.size(); i++) {
            if (listaPessoaFisica.get(i).getId() == pessoaFisica.getId()) {
                listaPessoaFisica.set(i, pessoaFisica);
                return;
            }
        }
    }

    // Método excluir
    public void excluir(int id) {
        listaPessoaFisica.removeIf(pessoaFisica -> pessoaFisica.getId() == id);
    }

    // Método obter por ID
    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : listaPessoaFisica) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    // Método obterTodos
    public List<PessoaFisica> obterTodos() {
        return new ArrayList<>(listaPessoaFisica);
    }

    // Método persistir
    public void persistir(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(listaPessoaFisica);
        }
    }

    // Método recuperar
    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            listaPessoaFisica = (List<PessoaFisica>) ois.readObject();
        }
    }
}