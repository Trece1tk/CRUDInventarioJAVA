package crudinventario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Joel Flores
 */
public class mClientes {

    public void Insertar(String cadenaCliente) {
        try {
            FileWriter archivo = new FileWriter("listado_clientes.txt", true);
            BufferedWriter buffer = new BufferedWriter(archivo);

            buffer.write(cadenaCliente);
            buffer.newLine();
            buffer.close();

        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public ArrayList<String> Consultar() {
        ArrayList<String> listaRegistros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("listado_clientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Salta líneas vacías

                String[] datos = linea.split("\\|");

                // Verificamos que la línea tenga los 4 campos esperados
                if (datos.length >= 4) {
                    String datoBonito = "No. Cliente: " + datos[0] + ", Nombre: " + datos[1] + 
                                       ", Tipo: " + datos[2] + ", Razon Social: " + datos[3];
                    listaRegistros.add(datoBonito);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
        return listaRegistros;
    }
}
