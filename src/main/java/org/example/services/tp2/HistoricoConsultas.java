package org.example.services.tp2;

public interface HistoricoConsultas {
    void adicionarConsulta(Paciente paciente, double valorConsulta);
    double getTotalConsultas(Paciente paciente);
}
