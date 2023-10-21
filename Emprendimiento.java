
/**
 * Esta clase es donde se crea el archivo .csv
 * 
 * @author: Dulce Ambrosio - 231143 , sección 20
 * @version: 20/10/2023
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Emprendimiento {
    private File archivo; // se crea la variable de tipo File

    /*
     * Class constructor
     */
    public Emprendimiento(String nombreArchivo) {
        archivo = new File(nombreArchivo);
    }

    /**
     * Método para crear el archivo .csv
     * 
     * @param param1 los valores son de tipo String
     * @return devuelve un archivo .csv
     */
    public void escribirProductos(List<Producto> productos) {
        try (FileWriter escritor = new FileWriter(archivo)) {
            escritor.write("Id, Nombre, Cantidad Disponible, Cantidad Vendidos, Estado, Precio, Categoría, Detalles\n");

            for (Producto prod : productos) {
                escritor.write(prod.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
