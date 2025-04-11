package dto;

public class CuentaCorrienteBuilder {
    private double saldoInicial = 0;
    public CuentaCorrienteBuilder setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
        return this;
    }
    public CuentaCorriente build() {
        return new CuentaCorriente(saldoInicial);
    }
}
