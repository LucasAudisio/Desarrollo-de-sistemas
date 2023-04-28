import java.util.HashMap;

public class Carrito {
    private HashMap<Producto, Integer> productoXCantidad;

    public Carrito(HashMap<Producto, Integer> productoXCantidad) {
        this.productoXCantidad = productoXCantidad;
    }

    public Carrito() {
        this.productoXCantidad = new HashMap<>();
    }

    public float calcularTotal(){
        float total = 0;
        for (Producto productoActual : productoXCantidad.keySet()){
            total += productoActual.getPrecio() * productoXCantidad.get(productoActual);
        }
        return total;
    }

    public void vaciarCarrito(){
        this.productoXCantidad = new HashMap<>();
    }

    public boolean aniadirProducto(Producto producto, int cantidad){
        if(productoXCantidad.keySet().contains(producto)){
            productoXCantidad.put(producto, productoXCantidad.get(producto) + cantidad);
        }
        else{
            productoXCantidad.put(producto, cantidad);
        }

        return true;
    }

    public boolean quitarProducto(Producto producto, int cantidad){
        if(productoXCantidad.keySet().contains(producto)){
            if (productoXCantidad.get(producto) >= cantidad){
                productoXCantidad.put(producto, productoXCantidad.get(producto) - cantidad);
                return true;
            }
            else{
                System.out.printf("Se intento quitar mas de lo que hay en el carrito");
                return false;
            }
        }
        System.out.printf("no existe ese producto en el carrito");
        return false;
    }
}
