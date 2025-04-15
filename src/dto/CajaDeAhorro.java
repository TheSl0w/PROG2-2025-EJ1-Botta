package dto;

import java.util.concurrent.CompletableFuture;

public class CajaDeAhorro extends Cuenta implements IGestionSaldo{
int operaciones;
    public CajaDeAhorro(double saldoInicial) {
        super(saldoInicial);
        this.operaciones = 0;
    }
    @Override
    public CompletableFuture<Boolean> agregarSaldo(double monto) {
        return CompletableFuture.supplyAsync(()-> {
            this.saldo = this.saldo + monto;
            operaciones = operaciones + 1;
            return true;
        }, ejecutor);
    }

    @Override
    public CompletableFuture<Boolean> quitarSaldo(double monto) {
        return CompletableFuture.supplyAsync(()-> {
            if (monto < this.saldo) {
                this.saldo = this.saldo - monto;
                operaciones = operaciones + 1;
                return true;
            }
            return false;
        },ejecutor);
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
