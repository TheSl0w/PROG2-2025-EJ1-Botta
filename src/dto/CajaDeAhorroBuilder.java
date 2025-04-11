package dto;

public class CajaDeAhorroBuilder {
    private double saldoInicial = 0;
    public CajaDeAhorroBuilder setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
        return this;
    }
    public CajaDeAhorro build() {
        return new CajaDeAhorro(saldoInicial);
    }
}
