package controller;

import model.Pessoa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PessoaController {
    static Scanner leitura = new Scanner(System.in);
    List<Pessoa> listaDePessoas = new ArrayList<>();

    public void exibeMenu(){
        System.out.println("Vamos adicionar algumas pessoas a nossa lista: ");
        populaLista();
    }

    private void populaLista(){
        System.out.println("Adicione as pessoas conforme solicitado: ");
        boolean continuar = true;
        do {
            try{
                System.out.println("Nome: ");
                String nome = leitura.nextLine();
                if(nome.isEmpty()){
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


                if (opcao.equalsIgnoreCase("sair")){
                    continuar = false;
                }

            }catch (NumberFormatException e){
                System.out.println("Digite a informação na formatação correta! " + e.getMessage());
            }


        }while (continuar);

        verificaLista();
    }

    private void verificaLista(){
        List<Pessoa> listaFeminina = listaDePessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("F"))
                .toList();

        System.out.println("Lista feminina: ");
        listaFeminina.forEach(System.out::println);

        List<Pessoa> listaMasculina = listaDePessoas.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase("M"))
                .toList();

        System.out.println("Lista masculina: ");
        listaMasculina.forEach(System.out::println);
    }
}
