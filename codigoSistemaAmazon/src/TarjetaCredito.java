public class TarjetaCredito {
    private float saldo;

    public TarjetaCredito(float saldo) {
        this.saldo = saldo;
    }

    public TarjetaCredito() {
        this.saldo = 0;
    }

    public boolean restarSaldo(float cant){
        if(this.saldo > cant){
            this.saldo -= cant;
            return true;
        }
        System.out.println("No hay saldo suficiente");
        return false;
    }

    public boolean sumarSaldo(float cant){
        this.saldo += cant;
        return true;
    }
}
