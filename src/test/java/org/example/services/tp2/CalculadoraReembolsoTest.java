package org.example.services.tp2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraReembolsoTest {
    // Exercicio 2
    // Mudei para Portugues o que não é interessante
    // Mas como foi pedido estritamente no exercício os nomes assim, os comentários também serão.
    @Test
    public void testReembolsoBasico() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double valorConsulta = 200.0;
        double percentualCobertura = 70.0;
        double esperado = 140.0;
        double resultado = calculadora.calcularReembolso(valorConsulta, percentualCobertura);
        assertEquals(esperado, resultado, 0.01, "O reembolso para R$200 com 70% de cobertura deve ser R$140");
    }

    @Test
    public void testReembolsoValorConsultaZero() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double valorConsulta = 0.0;
        double percentualCobertura = 70.0;
        double esperado = 0.0;
        double resultado = calculadora.calcularReembolso(valorConsulta, percentualCobertura);
        assertEquals(esperado, resultado, 0.01, "O reembolso para consulta de R$0 deve ser R$0");
    }

    @Test
    public void testReembolsoPercentualCoberturaZero() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double valorConsulta = 200.0;
        double percentualCobertura = 0.0;
        double esperado = 0.0;
        double resultado = calculadora.calcularReembolso(valorConsulta, percentualCobertura);
        assertEquals(esperado, resultado, 0.01, "O reembolso com 0% de cobertura deve ser R$0");
    }

    @Test
    public void testReembolsoPercentualCoberturaCem() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        double valorConsulta = 200.0;
        double percentualCobertura = 100.0;
        double esperado = 200.0;
        double resultado = calculadora.calcularReembolso(valorConsulta, percentualCobertura);
        assertEquals(esperado, resultado, 0.01, "O reembolso com 100% de cobertura deve ser igual ao valor da consulta");
    }

    // Exercicio 4
    // Só adicionei o Dummy, e mudei o nome das variáveis.
    @Test
    public void testReembolsoBasicoAprimorado() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double percentualCobertura = 70.0;
        double esperado = 140.0;
        double resultado = calculadora.calcularReembolsoAprimorado(valorConsulta, percentualCobertura, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso para R$200 com 70% de cobertura deve ser R$140");
    }

    @Test
    public void testReembolsoValorConsultaZeroAprimorado() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Paciente paciente = new Paciente();
        double valorConsulta = 0.0;
        double percentualCobertura = 70.0;
        double esperado = 0.0;
        double resultado = calculadora.calcularReembolsoAprimorado(valorConsulta, percentualCobertura, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso para consulta de R$0 deve ser R$0");
    }

    @Test
    public void testReembolsoPercentualCoberturaZeroAprimorado() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double percentualCobertura = 0.0;
        double esperado = 0.0;
        double resultado = calculadora.calcularReembolsoAprimorado(valorConsulta, percentualCobertura, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso com 0% de cobertura deve ser R$0");
    }

    @Test
    public void testReembolsoPercentualCoberturaCemAprimorado() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double percentualCobertura = 100.0;
        double esperado = 200.0;
        double resultado = calculadora.calcularReembolsoAprimorado(valorConsulta, percentualCobertura, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso com 100% de cobertura deve ser igual ao valor da consulta");
    }

    // Exercicio 6
    @Test
    public void testReembolsoBasicoPlano50Porcento() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        PlanoSaude plano = new PlanoSaudeStub(50.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double esperado = 100.0;
        double resultado = calculadora.calcularReembolsoSuperAprimorado(valorConsulta, plano, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso para R$200 com 50% de cobertura deve ser R$100");
    }

    @Test
    public void testReembolsoBasicoPlano80Porcento() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        PlanoSaude plano = new PlanoSaudeStub(80.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double esperado = 160.0;
        double resultado = calculadora.calcularReembolsoSuperAprimorado(valorConsulta, plano, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso para R$200 com 80% de cobertura deve ser R$160");
    }

    @Test
    public void testReembolsoValorConsultaZeroSuperAprimorado() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        PlanoSaude plano = new PlanoSaudeStub(70.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 0.0;
        double esperado = 0.0;
        double resultado = calculadora.calcularReembolsoSuperAprimorado(valorConsulta, plano, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso para consulta de R$0 deve ser R$0");
    }

    @Test
    public void testReembolsoPlanoCoberturaZero() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        PlanoSaude plano = new PlanoSaudeStub(0.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double esperado = 0.0;
        double resultado = calculadora.calcularReembolsoSuperAprimorado(valorConsulta, plano, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso com 0% de cobertura deve ser R$0");
    }

    @Test
    public void testReembolsoPlanoCoberturaCem() {
        CalculadoraReembolso calculadora = new CalculadoraReembolso();
        PlanoSaude plano = new PlanoSaudeStub(100.0);
        Paciente paciente = new Paciente();
        double valorConsulta = 200.0;
        double esperado = 200.0;
        double resultado = calculadora.calcularReembolsoSuperAprimorado(valorConsulta, plano, paciente);
        assertEquals(esperado, resultado, 0.01, "O reembolso com 100% de cobertura deve ser igual ao valor da consulta");
    }

}
