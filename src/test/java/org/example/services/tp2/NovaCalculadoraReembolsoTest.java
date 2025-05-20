package org.example.services.tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NovaCalculadoraReembolsoTest {
    @Test
    public void testAuditoriaChamadoAoCalcularReembolso() {
        AuditoriaSpy auditoria = new AuditoriaSpy();
        NovaCalculadoraReembolso calculadora = new NovaCalculadoraReembolso(auditoria);
        PlanoSaude plano = new PlanoSaudeStub(70.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;

        calculadora.calcularReembolso(valorConsulta, plano, paciente);

        assertEquals(1, auditoria.getChamadas(), "O método registrarConsulta deve ser chamado uma vez");
        assertEquals(valorConsulta, auditoria.getUltimaConsulta().getValorConsulta(), 0.01, "A consulta registrada deve ter o valor correto");
        assertEquals(paciente, auditoria.getUltimaConsulta().getPaciente(), "A consulta registrada deve ter o paciente correto");
    }
}
