/**
 * Esta clase es donde se crean los atributos propios de los snacks
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 20/10/2023
 */
public class Snack extends Producto {
    private int gr;
    private String Sabor;
    private String tamano;

    /*
     * Class constructor
     */
    public Snack(int id, String nombre, int cantDisponible, int cantVendidos, String estado, double precio, int gr,
            String sabor, String tamano) {
        super(id, nombre, cantDisponible, cantVendidos, estado, precio);
        this.gr = gr;
        Sabor = sabor;
        this.tamano = tamano;
    }

    /*
     * setters y getters
     */
    public int getGr() {
        return gr;
    }

    public void setGr(int gr) {
        this.gr = gr;
    }

    public String getSabor() {
        return Sabor;
    }

    public void setSabor(String sabor) {
        Sabor = sabor;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamaño(String tamano) {
        this.tamano = tamano;
    }

    /**
     * Método para mostrar los datos del producto usando polimorfismo
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un String
     */
    @Override
    public String toString() {
        return "Snack: " + super.toString() + "Gramos: " + getGr() + "Sabor: " + getSabor() + "Tamaño: " + getTamano();
    }

}