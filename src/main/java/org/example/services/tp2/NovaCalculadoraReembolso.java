package org.example.services.tp2;

public class NovaCalculadoraReembolso {
    private final Auditoria auditoria;

    public NovaCalculadoraReembolso(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public double calcularReembolso(double valorConsulta, PlanoSaude plano, Paciente paciente) {
        Consulta consulta = new Consulta(paciente, valorConsulta);
        auditoria.registrarConsulta(consulta);
        return valorConsulta * (plano.getPercentualCobertura() / 100.0);
    }
}
