package com.example;

//classe pessoa/ criação de atributos privados
public class Pessoa {
    private int idPessoa;
    private String nomePessoa;
    private String email;

    /* construtores que recebem os dados-atributos da pessoa e os utiliza para
     inicializar os atributos correspondentes.*/
    public Pessoa() {
    }

    public Pessoa(String nomePessoa, String email) {
        super();
        this.nomePessoa = nomePessoa;
        this.email = email;
    }

    public Pessoa(int idPessoa, String nomePessoa, String email) {
        super();
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.email = email;
    }

    /* toString(): Retorna uma string contendo a representação textual da pessoa,
     incluindo seus valores de idPessoa, nomePessoa e email.
     anotação @Override serve principalmente para informar ao compilador Java que
     o método está sobrescrevendo um método herdado da superclasse. */
    @Override
    public String toString() {
        return "Pessoa [idPessoa=" + idPessoa + ", nomePessoa=" + nomePessoa + ", email=" + email + "]";
    }

    // get - obtém o valor do atributo, set - define o valor do atributo
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
