import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consumir a quebra de linha

            switch (opcao) {
                case 1: // Incluir
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoIncluir = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    if (tipoIncluir == 1) { // Pessoa Física
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Digite a Idade: ");
                        int idade = scanner.nextInt();
                        scanner.nextLine();
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else if (tipoIncluir == 2) { // Pessoa Jurídica
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Digite o Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Digite o CNPJ: ");
                        String cnpj = scanner.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;

                case 2: // Alterar
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoAlterar = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    if (tipoAlterar == 1) { // Pessoa Física
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pf = repoFisica.obter(id);
                        if (pf != null) {
                            System.out.println("Dados Atuais:");
                            pf.exibir();
                            System.out.print("Digite o Novo Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite o Novo CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Digite a Nova Idade: ");
                            int idade = scanner.nextInt();
                            scanner.nextLine();
                            pf.setNome(nome);
                            pf.setCpf(cpf);
                            pf.setIdade(idade);
                            repoFisica.alterar(pf);
                        } else {
                            System.out.println("Pessoa Física com ID " + id + " não encontrada.");
                        }
                    } else if (tipoAlterar == 2) { // Pessoa Jurídica
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica pj = repoJuridica.obter(id);
                        if (pj != null) {
                            System.out.println("Dados Atuais:");
                            pj.exibir();
                            System.out.print("Digite o Novo Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite o Novo CNPJ: ");
                            String cnpj = scanner.nextLine();
                            pj.setNome(nome);
                            pj.setCnpj(cnpj);
                            repoJuridica.alterar(pj);
                        } else {
                            System.out.println("Pessoa Jurídica com ID " + id + " não encontrada.");
                        }
                    }
                    break;

                case 3: // Excluir
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoExcluir = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    if (tipoExcluir == 1) { // Pessoa Física
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        repoFisica.excluir(id);
                    } else if (tipoExcluir == 2) { // Pessoa Jurídica
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        repoJuridica.excluir(id);
                    }
                    break;

                case 4: // Exibir pelo ID
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoExibir = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    if (tipoExibir == 1) { // Pessoa Física
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaFisica pfExibir = repoFisica.obter(id);
                        if (pfExibir != null) {
                            pfExibir.exibir();
                        } else {
                            System.out.println("Pessoa Física com ID " + id + " não encontrada.");
                        }
                    } else if (tipoExibir == 2) { // Pessoa Jurídica
                        System.out.print("Digite o ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        PessoaJuridica pjExibir = repoJuridica.obter(id);
                        if (pjExibir != null) {
                            pjExibir.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica com ID " + id + " não encontrada.");
                        }
                    }
                    break;

                case 5: // Exibir todos
                    System.out.print("Escolha o tipo (1 - Física, 2 - Jurídica): ");
                    int tipoExibirTodos = scanner.nextInt();
                    scanner.nextLine();  // Consumir a quebra de linha
                    if (tipoExibirTodos == 1) { // Pessoa Física
                        for (PessoaFisica pf : repoFisica.obterTodos()) {
                            pf.exibir();
                        }
                    } else if (tipoExibirTodos == 2) { // Pessoa Jurídica
                        for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                            pj.exibir();
                        }
                    }
                    break;

                case 6: // Salvar dados
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixoSalvar = scanner.nextLine();
                    try {
                        repoFisica.persistir(prefixoSalvar + ".fisica.bin");
                        repoJuridica.persistir(prefixoSalvar + ".juridica.bin");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar os dados: " + e.getMessage());
                    }
                    break;

                case 7: // Recuperar dados
                    System.out.print("Digite o prefixo dos arquivos: ");
                    String prefixoRecuperar = scanner.nextLine();
                    try {
                        repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                        repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Erro ao recuperar os dados: " + e.getMessage());
                    }
                    break;

                case 0: // Sair
                    System.out.println("Finalizando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}