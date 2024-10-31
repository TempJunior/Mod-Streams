package controller;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ControllerMap {
    static Scanner leitura = new Scanner(System.in);
    List<Pessoa> listaDePessoas = new ArrayList<>();

    public void exibeMenu(){
        System.out.println("Vamos popular nossa lista! ");
        populaLista();
    }

    public void populaLista() {
        System.out.println("Adicione as pessoas conforme solicitado: ");
        boolean continuar = true;
        do {
            try {
                System.out.println("Nome: ");
                String nome = leitura.nextLine();
                if (nome.isEmpty()) {
                    nome = leitura.nextLine();
                }

                System.out.println("Idade: ");
                int idade = leitura.nextInt();

                System.out.println("Sexo: Digite M/F");
                String sexo = leitura.next();
                String sexoFormatado = sexo.substring(0);

                Pessoa pessoa = new Pessoa(nome, idade, sexoFormatado);
                listaDePessoas.add(pessoa);

                System.out.println("Deseja continuar? ");
                String opcao = leitura.next();


                if (opcao.equalsIgnoreCase("sair")) {
                    continuar = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite a informação na formatação correta! " + e.getMessage());
            }


        } while (continuar);

        adicionaPessoaAoMap();
    }

    public void adicionaPessoaAoMap(){
        //LISTA AS PESSOAS DE SEXO MASCULINO E ADICIONA NO MAP. A CHAVE É O SEXO E O VALOR É OS DADOS DA PESSOA
        Map<String, Pessoa> listaMasculina =
                listaDePessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("M"))
                .collect(Collectors.toMap(Pessoa::getSexo, p ->
                        new Pessoa(p.getNome(), p.getIdade(), p.getSexo())));

        System.out.println("Lista masculina: ");
        listaMasculina.forEach((sexo, dados) -> System.out.println("Sexo Masculino: " + sexo + " Dados pessoais: " + dados));

        //LISTA AS PESSOAS DE SEXO FEMININO E ADICIONA NO MAP. A CHAVE É O SEXO E O VALOR É OS DADOS DA PESSOA
        Map<String, Pessoa> listaFeminina =
                listaDePessoas.stream()
                        .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                        .collect(Collectors.toMap(Pessoa::getSexo, p ->
                                new Pessoa(p.getNome(), p.getIdade(), p.getSexo())));

        System.out.println("Lista feminina: ");
        listaFeminina.forEach((sexo, dados) -> System.out.println("Sexo Feminino: " + sexo + " Dados pessoais: " + dados));
    }
}

