package dto;

import java.util.concurrent.CompletableFuture;

public interface IGestionSaldo {
CompletableFuture<Boolean> agregarSaldo(double monto);
CompletableFuture<Boolean> quitarSaldo(double monto);
double getSaldo();
int getOperaciones();
}
