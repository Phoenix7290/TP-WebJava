package org.example.services.tp2;

public class ConsultaTestHelper {
    public static Consulta criarConsulta(double valorConsulta) {
        return new Consulta(new Paciente(), valorConsulta);
    }
}