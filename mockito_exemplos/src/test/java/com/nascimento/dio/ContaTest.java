package com.nascimento.dio;

import static org.mockito.Mockito.inOrder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContaTest {

    @Spy
    private Conta conta = new Conta(1_000);

    @Test
    public void validarOrdemDeChamadas(){
        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);
        inOrder.verify(conta).pagaBoleto(300);
        inOrder.verify(conta).validaSaldo(300);
        inOrder.verify(conta).debita(300);
        inOrder.verify(conta).enviarCreditoParaEmissor(300);
    }

    @Test
    void validarQuantidadeDeChamadas(){
        
        conta.validaSaldo(300);
        conta.validaSaldo(300);
        conta.validaSaldo(300);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }
}
