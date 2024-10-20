package com.nascimento.dio;

public class ServicoEnvioEmail {

    private Plataforma plataforma;

    void enviaEmail(String enderecoEmail, String mensagem, boolean formatoHtml){
        Email email = null;

        if (formatoHtml){
            email = new Email(enderecoEmail, mensagem, Formato.HTML);
        }else {
            email = new Email(enderecoEmail, mensagem, Formato.TEXTO);
        }

        plataforma.enviarEmail(email);
    }
}
