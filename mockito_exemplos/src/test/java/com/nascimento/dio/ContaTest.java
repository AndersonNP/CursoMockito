package com.nascimento.dio;

import static org.mockito.Mockito.inOrder;

import org.junit.jupiter.api.Assertions;
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
    void validarOrdemDeChamadas(){

        conta.pagaBoleto(300);

        InOrder inOrder = Mockito.inOrder(conta);

        inOrder.verify(conta).pagaBoleto(ArgumentMatchers.anyInt());
        inOrder.verify(conta).validaSaldo(ArgumentMatchers.anyInt());
        inOrder.verify(conta).debita(ArgumentMatchers.anyInt());
        inOrder.verify(conta).enviarCreditoParaEmissor(ArgumentMatchers.anyInt());


    }

    @Test
    void validarQuatidadeDeChamadas(){

        conta.validaSaldo(300);
        conta.validaSaldo(500);
        conta.validaSaldo(600);

        Mockito.verify(conta, Mockito.times(3)).validaSaldo(ArgumentMatchers.anyInt());
    }

    @Test
    void validarDebitoMaiorQueSaldo(){
        Assertions.assertThrows(IllegalStateException.class, () -> conta.validaSaldo(2_000));
    }
}
