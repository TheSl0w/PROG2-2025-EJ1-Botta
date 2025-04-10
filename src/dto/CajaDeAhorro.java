package dto;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo{
int operaciones;
    @Override
    public boolean agregarSaldo(double monto) {
        this.saldo = this.saldo + monto;
        operaciones = operaciones+1;
        return true;
    }

    @Override
    public boolean quitarSaldo(double monto) {
        if (monto<this.saldo) {
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
