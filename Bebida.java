/**
 * Esta clase es donde se crean los atributos propios de las bebidas
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 20/10/2023
 */
public class Bebida extends Producto {
    private int ml;
    private String tipo;

    /*
     * Class constructor
     */
    public Bebida(int id, String nombre, int cantDisponible, int cantVendidos, String estado, double precio, int ml,
            String tipo) {
        super(id, nombre, cantDisponible, cantVendidos, estado, precio);
        this.ml = ml;
        this.tipo = tipo;
    }

    /*
     * setters y getters
     */
    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Método para mostrar los datos del producto usando polimorfismo
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un String
     */
    @Override
    public String toString() {
        return super.toString() + "Mililitros: " + getMl() + "Tipo: " + getTipo();
    }

}