package org.example.services.tp2;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class NovaCalculadoraReembolsoTest {
    @Test
    public void testReembolsoConsultaAutorizada() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        AutorizadorReembolso autorizador = Mockito.mock(AutorizadorReembolso.class);
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria, autorizador);
        PlanoSaude plano = new PlanoSaudeStub(70.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        Consulta consulta = new Consulta(paciente, valorConsulta);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(true);

        double resultado = calculadora.calcularReembolso(valorConsulta, plano, paciente);

        assertEquals(140.0, resultado, 0.01, "O reembolso para R$200 com 70% de cobertura deve ser R$140");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado");
    }

    @Test
    public void testReembolsoConsultaNaoAutorizada() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        AutorizadorReembolso autorizador = Mockito.mock(AutorizadorReembolso.class);
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria, autorizador);
        PlanoSaude plano = new PlanoSaudeStub(70.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        Consulta consulta = new Consulta(paciente, valorConsulta);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(false);

        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                        calculadora.calcularReembolso(valorConsulta, plano, paciente),
                "Deve lançar exceção para consulta não autorizada");

        assertEquals("Consulta não autorizada", exception.getMessage());
        assertEquals(0, auditoria.getChamadas(), "O método registrarConsulta não deve ser chamado");
    }

    @Test
    public void testReembolsoValorConsultaZero() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        AutorizadorReembolso autorizador = Mockito.mock(AutorizadorReembolso.class);
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria, autorizador);
        PlanoSaude plano = new PlanoSaudeStub(70.0);
        Consulta consulta = ConsultaTestHelper.criarConsulta(0.0);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(true);

        double resultado = calculadora.calcularReembolso(consulta.getValorConsulta(), plano, consulta.getPaciente());

        assertEquals(0.0, resultado, 0.01, "O reembolso para consulta de R$0 deve ser R$0");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado");
    }
}