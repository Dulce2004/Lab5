/**
 * Esta clase es donde se crean los atributos que hereden las clases hijas, es
 * decir que está es la clase padre
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 20/10/2023
 */
public class Producto {
    protected int id;
    protected String nombre;
    protected int cantDisponible;
    protected int cantVendidos;
    protected String Estado;
    protected double precio;

    /*
     * Class constructor
     */
    public Producto(int id, String nombre, int cantDisponible, int cantVendidos, String estado, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantDisponible = cantDisponible;
        this.cantVendidos = cantVendidos;
        Estado = estado;
        this.precio = precio;
    }

    /*
     * setters y getters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(int cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public int getCantVendidos() {
        return cantVendidos;
    }

    public void setCantVendidos(int cantVendidos) {
        this.cantVendidos = cantVendidos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Método para calcular la comisión de los productos
     * 
     * @param param1 los valores son de tipo double o int
     * @return devuelve un double
     */
    public double comision() {
        return getPrecio() * 0.12;
    }

    /**
     * Método para imprimir los datos que se ingresaron
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un String
     */
    public String toString() {
        return "Id" + getId() + "Nomrbe: " + getNombre() + "Cantidad Disponible" + getCantDisponible()
                + "Cantidad Venidas: " + getCantVendidos() + "Estado: " + getEstado() + "Precio: " + getPrecio();
    }

    /**
     * Método para las ventas
     * 
     * @param param1 los valores son de tipo int
     * @return devuelve un entero
     */
    public int calcularVentas() {
        return getCantVendidos();
    }

}