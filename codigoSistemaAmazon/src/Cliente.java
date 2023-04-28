import java.lang.reflect.Array;
import java.util.HashSet;

public class Cliente {
    private int id;
    private String nombre;
    private String direccionEnvio;
    private String direccionPago;
    private String email;
    private boolean esPreferencial;
    private HashSet<Carrito> carritos;
    private HashSet<TarjetaCredito> tarjetas;

    public Cliente(int id, String nombre, String direccionEnvio, String direccionPago, String email,
                   boolean esPreferencial, HashSet<Carrito> carritos, HashSet<TarjetaCredito> tarjetas) {
        this.id = id;
        this.nombre = nombre;
        this.direccionEnvio = direccionEnvio;
        this.direccionPago = direccionPago;
        this.email = email;
        this.esPreferencial = esPreferencial;
        this.carritos = carritos;
        this.tarjetas = tarjetas;
    }

    public void aniadirAlCaro(Producto producto, int cantidad, Carrito carrito){
        if(this.carritos.contains(carrito)){
            if(carrito.aniadirProducto(producto, cantidad)){
                System.out.println("Se añadio correctamente");
            }
            else{
                System.out.println("Hubo un problema");
            }
        }
        else{
            System.out.println("este carrito no existe dentro de este usuario");
        }
    }

    public void quitarDelCarro(Producto producto, int cantidad, Carrito carrito){
        if(this.carritos.contains(carrito)){
            if(carrito.quitarProducto(producto, cantidad)){
                System.out.println("Se elimino correctamente");
            }
            else{
                System.out.println("Hubo un problema");
            }
        }
        else{
            System.out.println("este carrito no existe dentro de este usuario");
        }
    }

    public boolean solicitarCompra(Carrito carrito, TarjetaCredito tarjetaCredito){
        if(this.carritos.contains(carrito) && this.tarjetas.contains(tarjetaCredito)) {
            if (tarjetaCredito.restarSaldo(carrito.calcularTotal())) {
                carrito.vaciarCarrito();
                return true;
            }
            System.out.println("no tiene saldo suficiente");
        }
        else{
            System.out.println("el carrito o la tarjeta no pertenece a este cliente");
        }
        return false;
    }
}
