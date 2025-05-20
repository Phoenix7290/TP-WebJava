package org.example.services.tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoricoConsultasTest {
    // Exercicio 5
    @Test
    public void testHistoricoConsultasFake() {
        HistoricoConsultas historico = new HistoricoConsultasFake();
        Paciente paciente = new Paciente();

        historico.adicionarConsulta(paciente, 200.0);
        historico.adicionarConsulta(paciente, 300.0);

        double totalEsperado = 500.0;
        double totalObtido = historico.getTotalConsultas(paciente);
        assertEquals(totalEsperado, totalObtido, 0.01, "O total de consultas deve ser R$500");
    }

    @Test
    public void testHistoricoConsultaPacienteSemConsultas() {
        HistoricoConsultas historico = new HistoricoConsultasFake();
        Paciente paciente = new Paciente();

        double totalEsperado = 0.0;
        double totalObtido = historico.getTotalConsultas(paciente);
        assertEquals(totalEsperado, totalObtido, 0.01, "Paciente sem consultas deve ter total R$0");
    }
}