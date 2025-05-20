package org.example.services.tp2;

public class Consulta {
    private final Paciente paciente;
    private final double valorConsulta;

    public Consulta(Paciente paciente, double valorConsulta) {
        this.paciente = paciente;
        this.valorConsulta = valorConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }
}
