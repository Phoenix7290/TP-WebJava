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
        Consulta consulta = ConsultaTestHelper.criarConsulta(200.0);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(true);

        double resultado = calculadora.calcularReembolso(consulta.getValorConsulta(), plano, consulta.getPaciente());

        TestUtils.assertEqualsWithTolerance(140.0, resultado, "O reembolso para R$200 com 70% de cobertura deve ser R$140");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado");
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

        TestUtils.assertEqualsWithTolerance(0.0, resultado, "O reembolso para consulta de R$0 deve ser R$0");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado");
    }

    @Test
    public void testReembolsoRespeitaTeto150() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        AutorizadorReembolso autorizador = Mockito.mock(AutorizadorReembolso.class);
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria, autorizador);
        PlanoSaude plano = new PlanoSaudeStub(100.0);
        Consulta consulta = ConsultaTestHelper.criarConsulta(200.0);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(true);

        double resultado = calculadora.calcularReembolso(consulta.getValorConsulta(), plano, consulta.getPaciente());

        TestUtils.assertEqualsWithTolerance(150.0, resultado, "O reembolso para R$200 com 100% de cobertura deve ser limitado a R$150");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado");
    }

    @Test
    public void testReembolsoAbaixoTeto() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        AutorizadorReembolso autorizador = Mockito.mock(AutorizadorReembolso.class);
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria, autorizador);
        PlanoSaude plano = new PlanoSaudeStub(70.0);
        Consulta consulta = ConsultaTestHelper.criarConsulta(100.0);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(true);

        double resultado = calculadora.calcularReembolso(consulta.getValorConsulta(), plano, consulta.getPaciente());

        TestUtils.assertEqualsWithTolerance(70.0, resultado, "O reembolso para R$100 com 70% de cobertura deve ser R$70");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado");
    }

    @Test
    public void testIntegracaoCompletaComDubles() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        AutorizadorReembolso autorizador = Mockito.mock(AutorizadorReembolso.class);
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria, autorizador);
        PlanoSaude plano = new PlanoSaudeStub(90.0);
        Consulta consulta = ConsultaTestHelper.criarConsulta(200.0);

        when(autorizador.autorizarConsulta(consulta)).thenReturn(true);

        double resultado = calculadora.calcularReembolso(consulta.getValorConsulta(), plano, consulta.getPaciente());

        TestUtils.assertEqualsWithTolerance(150.0, resultado,
                "O reembolso para R$200 com 90% de cobertura deve ser limitado a R$150");
        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado uma vez");
        assertEquals(consulta.getPaciente(), auditoria.getUltimaConsulta().getPaciente(),
                "A consulta registrada deve ter o paciente correto");
        TestUtils.assertEqualsWithTolerance(consulta.getValorConsulta(), auditoria.getUltimaConsulta().getValorConsulta(),
                "A consulta registrada deve ter o valor correto");
        verify(autorizador, times(1)).autorizarConsulta(consulta);
    }
}