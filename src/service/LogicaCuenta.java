package service;

import dto.Cuenta;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LogicaCuenta {
    private static volatile LogicaCuenta instance;
    private List<Cuenta> cuentas;
    private LogicaCuenta() {
        cuentas = new ArrayList<>();
    }
    public static LogicaCuenta getInstance() {
        if (instance == null) {
            synchronized (LogicaCuenta.class) {
                if (instance == null) {
                    instance = new LogicaCuenta();
                }
            }
        }
        return instance;
    }
    public CompletableFuture<Boolean> agregarSaldo(int cuenta, double monto){
        if(cuenta>= 0 && cuenta<cuentas.size()){
            return cuentas.get(cuenta).agregarSaldo(monto);
        }
        return CompletableFuture.completedFuture(false);
    }
    public CompletableFuture<Boolean> quitarSaldo(int cuenta, double monto){
        if(cuenta>= 0 && cuenta<cuentas.size()){
            return cuentas.get(cuenta).quitarSaldo(monto);
        }
        return CompletableFuture.completedFuture(false);
    }
    public double consultarSaldo(int cuenta){
        if(cuenta>= 0 && cuenta<cuentas.size()){
            return cuentas.get(cuenta).getSaldo();
        }
        return 0;
    }
    public double consultarOperaciones(int cuenta){
        if(cuenta>= 0 && cuenta<cuentas.size()){
            return cuentas.get(cuenta).getOperaciones();
        }
        return 0;
    }
    public Boolean crearCuentas(Cuenta cuenta){
        cuentas.add(cuenta);
        return true;
    }
    public List<Cuenta> getCuentas() {
        return cuentas;
    }
}
