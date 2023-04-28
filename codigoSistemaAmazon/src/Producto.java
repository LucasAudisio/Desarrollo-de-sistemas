public class Producto {
    private float precio;
    private String descripcion;

    public Producto(float precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Producto() {
        this.precio = 0;
        this.descripcion = "";
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
