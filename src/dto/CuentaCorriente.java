package dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{
    double giroDescubierto=2000;
    int operaciones;
    public CuentaCorriente(double saldoInicial) {
        super(saldoInicial);
        this.operaciones = 0;
    }
    @Override
    public synchronized boolean agregarSaldo(double monto) {
        this.saldo = this.saldo + monto;
        operaciones = operaciones+1;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (giroDescubierto<=Math.abs(this.saldo-monto)) {
                this.saldo = this.saldo - monto;
                operaciones = operaciones+1;
                return true;
        }

        return false;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    @Override
    public int getOperaciones() {
        return operaciones;
    }
}
