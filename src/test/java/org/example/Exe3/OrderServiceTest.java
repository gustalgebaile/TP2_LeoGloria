package org.example.Exe3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private PaymentProcessor paymentProcessor;
    private OrderService orderService;

    @BeforeEach
    void setUp() {
        paymentProcessor = Mockito.mock(PaymentProcessor.class);
        orderService = new OrderService(paymentProcessor);
    }

    @Test
    void deveConfirmarPedidoQuandoPagamentoAprovado() {
        when(paymentProcessor.processPayment(100.0)).thenReturn(true);

        boolean resultado = orderService.processOrder(100.0);

        assertTrue(resultado, "O pedido deveria ser confirmado.");
        verify(paymentProcessor, times(1)).processPayment(100.0);
    }

    @Test
    void deveRecusarPedidoQuandoPagamentoRejeitado() {
        when(paymentProcessor.processPayment(200.0)).thenReturn(false);

        boolean resultado = orderService.processOrder(200.0);

        assertFalse(resultado, "O pedido deveria ser recusado.");
        verify(paymentProcessor, times(1)).processPayment(200.0);
    }
}

