package com.nascimento.dio;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        DadosLocalizacao localizacao =  new DadosLocalizacao("CE", "Fortaleza","Rua 01G","Bloco A", "Passare");
        Mockito.when(apiDosCorreios.buscarDadosComBaseNoCep(Mockito.anyString())).thenReturn(localizacao);
        Pessoa nascimento = cadastrarPessoa.cadastrarPessoa("Anderson", "12345678", LocalDate.now(),"1237891");

        Assertions.assertEquals("Anderson", nascimento.getNome());
        Assertions.assertEquals("Fortaleza", nascimento.getDadosLocalizacao().getCidade());
    }

    @Test
    void lancarErroAoChamarApiDosCorreios(){
        //Mockito.when(apiDosCorreios.buscarDadosComBaseNoCep(Mockito.anyString())).thenThrow(IllegalArgumentException.class);

        Mockito.doThrow(IllegalArgumentException.class).when(apiDosCorreios).buscarDadosComBaseNoCep(Mockito.anyString());
        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa.cadastrarPessoa("Anderson", "12345678", LocalDate.now(),"1237891"));
    }

}



