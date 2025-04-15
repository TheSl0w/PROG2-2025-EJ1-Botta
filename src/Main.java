import dto.CajaDeAhorro;
import dto.CuentaCorriente;
import service.LogicaCuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main{
    public static void main(String[] args) {
        LogicaCuenta logica = new LogicaCuenta();
        List<CompletableFuture<?>> futuros = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i<10;i++){
            int saldoinicial = random.nextInt(10000);
            if (saldoinicial> 5000){
                logica.crearCuentas(new CajaDeAhorro(saldoinicial));
            }else {
                logica.crearCuentas(new CuentaCorriente(saldoinicial));
            }
        }
        for (int i = 0; i < 10000; i++){
            int cuenta = random.nextInt(logica.getCuentas().size());
        }
    }
}