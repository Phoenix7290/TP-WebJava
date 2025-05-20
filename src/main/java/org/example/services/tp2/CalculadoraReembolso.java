package org.example.services.tp2;

public class CalculadoraReembolso {
    // Exercicio 1
    // Mudei para Portugues o que não é interessante
    // Mas como foi pedido estritamente no exercício os nomes assim, os comentários também serão.
    public double calcularReembolso(double valorConsulta, double percentualCobertura) {
        return valorConsulta * (percentualCobertura / 100.0);
    }

    public double calcularReembolsoAprimorado(double valorConsulta, double percentualCobertura, Paciente paciente) {
        return valorConsulta * (percentualCobertura / 100.0);
    }

    // Os nomes de variável perderam qualidade imaginativa
    public double calcularReembolsoSuperAprimorado(double valorConsulta, PlanoSaude plano, Paciente paciente) {
        return valorConsulta * (plano.getPercentualCobertura() / 100.0);
    }

}
