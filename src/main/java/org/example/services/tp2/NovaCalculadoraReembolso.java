package org.example.services.tp2;

public class NovaCalculadoraReembolso {
    // Tive que recorrer a comentar para melhorar
//    private final Auditoria auditoria;
//
//    public NovaCalculadoraReembolso(Auditoria auditoria) {
//        this.auditoria = auditoria;
//    }
//
//    public double calcularReembolso(double valorConsulta, PlanoSaude plano, Paciente paciente) {
//        Consulta consulta = new Consulta(paciente, valorConsulta);
//        auditoria.registrarConsulta(consulta);
//        return valorConsulta * (plano.getPercentualCobertura() / 100.0);
//    }

    private final Auditoria auditoria;
    private final AutorizadorReembolso autorizador;

    public NovaCalculadoraReembolso(Auditoria auditoria, AutorizadorReembolso autorizador) {
        this.auditoria = auditoria;
        this.autorizador = autorizador;
    }

    public double calcularReembolso(double valorConsulta, PlanoSaude plano, Paciente paciente) {
        Consulta consulta = new Consulta(paciente, valorConsulta);
        if (!autorizador.autorizarConsulta(consulta)) {
            throw new IllegalStateException("Consulta não autorizada");
        }
        auditoria.registrarConsulta(consulta);
        return valorConsulta * (plano.getPercentualCobertura() / 100.0);
    }


}
