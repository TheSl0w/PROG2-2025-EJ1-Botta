package dto;

public class CuentaCorriente extends Cuenta implements IGestionSaldo{

    int operaciones;
    @Override
    public boolean agregarSaldo(double monto) {
        this.saldo = this.saldo + monto;
        operaciones = operaciones+1;
        return true;
    }

    @Override
    public boolean quitarSaldo(double monto) {
        double giroDescubierto=0;

        if (monto>this.saldo) {
            giroDescubierto = this.saldo - monto;
        }
        if (Math.abs(giroDescubierto)<=this.saldo) {
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
