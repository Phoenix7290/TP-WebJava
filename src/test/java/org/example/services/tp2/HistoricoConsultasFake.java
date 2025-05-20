package org.example.services.tp2;

import java.util.HashMap;
import java.util.Map;

public class HistoricoConsultasFake implements HistoricoConsultas {
    private final Map<Paciente, Double> consultas = new HashMap<>();

    @Override
    public void adicionarConsulta(Paciente paciente, double valorConsulta) {
        consultas.merge(paciente, valorConsulta, Double::sum);
    }

    @Override
    public double getTotalConsultas(Paciente paciente) {
        return consultas.getOrDefault(paciente, 0.0);
    }
}
