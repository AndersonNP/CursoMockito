package com.nascimento.dio;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    public void validarDadosDeCadastro() {
       DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("MG", "Patos de Minas", "Rua 2", "APT", "Centro");
        Mockito.when(apiDosCorreios.buscarDadosComBaseNoCep("60766035")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Anderson", "111111111", LocalDate.now(), "60766035");
        
        Assertions.assertEquals("Anderson", pessoa.getNome());
    }
}



