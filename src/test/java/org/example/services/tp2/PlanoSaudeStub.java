package org.example.services.tp2;

public class PlanoSaudeStub implements PlanoSaude {
    private final double percentualCobertura;

    public PlanoSaudeStub(double percentualCobertura) {
        this.percentualCobertura = percentualCobertura;
    }

    @Override
    public double getPercentualCobertura() {
        return percentualCobertura;
    }
}