package org.example.Exe4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceTest {

    private CustomerService service;

    @BeforeEach
    void setUp() {
        service = new CustomerService();
    }

    @Test
    void devePermitirCadastroComIdadeMinima18() {
        Customer c = new Customer(1, "Ana", "ana@email.com", 18, true);
        assertTrue(service.registerCustomer(c));
    }

    @Test
    void devePermitirCadastroComIdadeMaxima99() {
        Customer c = new Customer(2, "Bruno", "bruno@email.com", 99, true);
        assertTrue(service.registerCustomer(c));
    }

    @Test
    void naoDeveCadastrarIdadeMenorQue18() {
        Customer c = new Customer(3, "Carlos", "carlos@email.com", 17, true);
        assertFalse(service.registerCustomer(c));
    }

    @Test
    void naoDeveCadastrarIdadeMaiorQue99() {
        Customer c = new Customer(4, "Diana", "diana@email.com", 100, true);
        assertFalse(service.registerCustomer(c));
    }

    @Test
    void devePermitirAtualizarClienteAtivo() {
        Customer c = new Customer(5, "Eva", "eva@email.com", 25, true);
        boolean atualizado = service.updateCustomer(c, "Eva Maria", "eva.maria@email.com", 30);

        assertTrue(atualizado);
        assertEquals("Eva Maria", c.getName());
        assertEquals("eva.maria@email.com", c.getEmail());
        assertEquals(30, c.getAge());
    }

    @Test
    void naoDeveAtualizarClienteInativo() {
        Customer c = new Customer(6, "Felipe", "felipe@email.com", 40, false);
        boolean atualizado = service.updateCustomer(c, "Novo", "novo@email.com", 45);

        assertFalse(atualizado);
        assertEquals("Felipe", c.getName()); // não alterado
    }

    @Test
    void devePermitirExcluirClienteAtivo() {
        Customer c = new Customer(7, "Gabi", "gabi@email.com", 28, true);
        assertTrue(service.deleteCustomer(c));
    }

    @Test
    void naoDeveExcluirClienteInativo() {
        Customer c = new Customer(8, "Henrique", "henrique@email.com", 28, false);
        assertFalse(service.deleteCustomer(c));
    }

    @Test
    void deveAceitarEmailValido() {
        Customer c = new Customer(9, "Iris", "iris@email.com", 30, true);
        assertTrue(service.registerCustomer(c));
    }

    @Test
    void naoDeveAceitarEmailSemArroba() {
        Customer c = new Customer(10, "João", "joaoemail.com", 30, true);
        assertFalse(service.registerCustomer(c));
    }

    @Test
    void naoDeveAceitarEmailSemDominio() {
        Customer c = new Customer(11, "Karen", "karen@", 30, true);
        assertFalse(service.registerCustomer(c));
    }

    @Test
    void deveCadastrarClienteComDadosValidos() {
        Customer c = new Customer(12, "Lucas", "lucas@email.com", 35, true);
        boolean resultado = service.registerCustomer(c);

        assertTrue(resultado);
        assertEquals("Lucas", c.getName());
        assertEquals("lucas@email.com", c.getEmail());
        assertEquals(35, c.getAge());
        assertTrue(c.isActive());
    }
}

