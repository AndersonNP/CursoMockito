package com.nascimento.dio;

public class Email {
    private final String enderecoEmail;
    private final String mensagem;
    private final Formato formato;

    public Email(String enderecoEmail, String mensagem, Formato formato) {
        this.enderecoEmail = enderecoEmail;
        this.mensagem = mensagem;
        this.formato = formato;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Formato getFormato() {
        return formato;
    }


}
