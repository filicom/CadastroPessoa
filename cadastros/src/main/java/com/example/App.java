package com.example;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PessoaDao pd = new PessoaDao(); // Cria uma instância de PessoaDao

        try {
            // Incluir pessoas
            Pessoa p1 = new Pessoa(1, "Felipe", "Felipe@gmail.com"); // Cria Pessoa 1
            Pessoa p2 = new Pessoa(2, "Gabriel", "Gabriel@gmail.com"); // Cria Pessoa 2
            pd.incluirPessoa(p1); // Adiciona Pessoa 1 ao banco de dados
            pd.incluirPessoa(p2); // Adiciona Pessoa 2 ao banco de dados

            // Alterar uma pessoa
            // - Consultar pessoa pelo ID 3
            try {
                Pessoa pes = pd.consultarPessoaIndividual(3);

                // Se a pessoa for encontrada, altera o email
                if (pes != null) {
                    pes.setEmail("joao2@gmail.com"); // Altera o email da pessoa
                    pd.alterarPessoa(pes); // Atualiza a pessoa no banco de dados
                } else {
                    System.out.println("Pessoa não encontrada ou falha no acesso ao banco de dados");
                }

                // Listar todas as pessoas
                List<Pessoa> listaPessoas = pd.ListarPessoas();
                for (Pessoa p : listaPessoas) {
                    System.out.println("Id: " + p.getIdPessoa());
                    System.out.println("Nome: " + p.getNomePessoa());
                    System.out.println("Email: " + p.getEmail());
                }
            } catch (Exception ex) {
                System.out.println("Alguma coisa deu errado no acesso ao banco de dados. Contate a TI");
            }

            /*
            // Excluir uma pessoa
            // Consultar pessoa pelo ID 1
            Pessoa pessoa1 = pd.consultarPessoaIndividual(1);
            // Excluir a pessoa encontrada
            pd.excluirPessoa(pessoa1);
            // Listar todas as pessoas novamente
            List<Pessoa> listaPessoas = pd.ListarPessoas();
            for(Pessoa p : listaPessoas){
                System.out.println("Id: " + p.getIdPessoa());
                System.out.println("Nome: " + p.getNomePessoa());
                System.out.println("Email: " + p.getEmail());
            }
            */

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
