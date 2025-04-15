package dto;

import java.net.FileNameMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Cuenta implements IGestionSaldo {
    protected double saldo;
    protected final ExecutorService ejecutor = Executors.newSingleThreadExecutor();
    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    public void apagarEjecutor(){
        ejecutor.shutdown();
    }
}
