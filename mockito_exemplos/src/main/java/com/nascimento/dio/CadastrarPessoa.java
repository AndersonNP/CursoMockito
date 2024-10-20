package com.nascimento.dio;

import java.time.LocalDate;

public class CadastrarPessoa {
    
    private ApiDosCorreios apiDosCorreios;

    public CadastrarPessoa(ApiDosCorreios apiDosCorreios) {
        this.apiDosCorreios = apiDosCorreios;
    }

    public Pessoa cadastrarPessoa(String nome, String documento, LocalDate nascimento, String cep){

        Pessoa pessoa = new Pessoa(nome, documento, nascimento);
        DadosLocalizacao dadosLocalizacao = apiDosCorreios.buscarDadosComBaseNoCep(cep);
        pessoa.setDadosLocalizacao(dadosLocalizacao);
        return pessoa;
    }


}
