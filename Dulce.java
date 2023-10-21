/**
 * Esta clase es donde se crean los atributos propios de los Dulces
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 20/10/2023
 */
public class Dulce extends Producto {
    private String tipo2;
    private String marca;

    /*
     * Class constructor
     */
    public Dulce(int id, String nombre, int cantDisponible, int cantVendidos, String estado, double precio,
            String tipo2, String marca) {
        super(id, nombre, cantDisponible, cantVendidos, estado, precio);
        this.tipo2 = tipo2;
        this.marca = marca;
    }

    /*
     * setters y getters
     */
    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Método para mostrar los datos del producto usando polimorfismo y calcular la
     * comisión
     * 
     * @param param1 los valores son de tipo double
     * @return devuelve un double
     */
    @Override
    public double comision() {
        return getPrecio() * 0.2;
    }

    /**
     * Método para mostrar los datos del producto usando polimorfismo
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un String
     */
    @Override
    public String toString() {
        return super.toString() + "Tipo: " + getTipo2() + "Marca: " + getMarca();
    }

}