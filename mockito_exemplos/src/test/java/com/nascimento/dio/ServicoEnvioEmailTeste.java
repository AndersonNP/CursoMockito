package com.nascimento.dio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private Plataforma plataforma;

    @InjectMocks
    private ServicoEnvioEmail servicoEnvioEmail;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaPlataforma(){
        String enderecoEmail = "teste@teste.com";
        String mensagem = "Ola mundo";
        boolean isFormatoHtml = false;

        servicoEnvioEmail.enviaEmail(enderecoEmail,mensagem,isFormatoHtml);

        Mockito.verify(plataforma).enviarEmail(captor.capture());

        Email emailCapturado = captor.getValue();

        Assertions.assertEquals(enderecoEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());

    }
}
