import dto.CajaDeAhorro;
import dto.Cuenta;
import dto.CuentaCorriente;
import service.LogicaCuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main{
    public static void main(String[] args) {
        int totalops = 0;
        LogicaCuenta logica = new LogicaCuenta();
        List<CompletableFuture<?>> futuros = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i<10;i++){
            double saldoinicial = random.nextDouble() * 100000;
            if (random.nextBoolean()){
                logica.crearCuentas(new CajaDeAhorro(saldoinicial));
            }else {
                logica.crearCuentas(new CuentaCorriente(saldoinicial));
            }
        }
        for (int i = 0; i < 10000; i++){
            int cuenta = random.nextInt(logica.getCuentas().size());
            double monto = random.nextDouble();
            if (random.nextBoolean()){
                futuros.add(logica.agregarSaldo(cuenta,monto));
            }else {
                futuros.add(logica.quitarSaldo(cuenta,monto));
            }
        }
        CompletableFuture.allOf(futuros.toArray(new CompletableFuture[0])).join();

        for(Cuenta cuenta: logica.getCuentas()){
            cuenta.apagarEjecutor();
        }
        for (int i = 0; i < logica.getCuentas().size(); i++) {
            Cuenta cuenta = logica.getCuentas().get(i);
            String salida = String.format("Cuenta %d: Tiene $ %.2f y %d operaciones", i, cuenta.getSaldo(), cuenta.getOperaciones());
            System.out.println(salida);
        }
    }
}