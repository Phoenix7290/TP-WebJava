package org.example.services.tp2;

public class AuditoriaSpy implements Auditoria {
    private int chamadas = 0;
    private Consulta ultimaConsulta;

    @Override
    public void registrarConsulta(Consulta consulta) {
        chamadas++;
        this.ultimaConsulta = consulta;
    }

    public int getChamadas() {
        return chamadas;
    }

    public Consulta getUltimaConsulta() {
        return ultimaConsulta;
    }
}