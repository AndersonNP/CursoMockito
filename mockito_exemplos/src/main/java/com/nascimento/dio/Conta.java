package com.nascimento.dio;

public class Conta {
    
    private int saldo;

    public Conta(int saldo){ this.saldo = saldo;}

    public void pagaBoleto(int valorAPagar){
        validaSaldo(valorAPagar);
        debita(valorAPagar);
        enviarCreditoParaEmissor(valorAPagar);
    }

    void enviarCreditoParaEmissor(int valorAPagar) {
    
        if (valorAPagar > saldo) {
            throw new IllegalStateException("Saldo insuficiente");
        }
    }

    void debita(int valorAPagar) {
        this.saldo = this.saldo - valorAPagar;
    }

    void validaSaldo(int valorAPagar) {
        if(valorAPagar > saldo){
            throw new IllegalStateException("Saldo insuficiente");
        }
    }


    
}
