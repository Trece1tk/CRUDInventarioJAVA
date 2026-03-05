/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class mArticulo {

    public void Insertar(String cadenaArticulo) {
        try {
            // Esta linea crea el archivo donde se guarda la informacion
            FileWriter archivo = new FileWriter("listado_articulos.txt", true);
            // Buffer temporal que se encarga de guardar los datos en el archivo
            BufferedWriter buffer = new BufferedWriter(archivo);

            // Escribe en el archivo de texto
            buffer.write(cadenaArticulo);
            // Agrega un salto de linea al registro
            buffer.newLine();
            // Guarda los registros en el archivo
            buffer.close();
            // lblSaludo.setText("¡Archivo guardado con éxito!");

        } catch (IOException e) {
            // lblSaludo.setText("Error al guardar el archivo: " + e.getMessage());
        }

    }

    public ArrayList<String> Consultar() {
        ArrayList<String> listaRegistros = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("listado_articulos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\\|");

                // 1. Corregimos el formato: agregamos espacios y cambiamos ';' por ':'
                String datoBonito = "Codigo: " + datos[0] + "| Descripcion: " + datos[1] + "| Precio: " + datos[2];

                listaRegistros.add(datoBonito);
            }
        } catch (IOException e) {
            System.out.print("Mensaje de error: " + e.getMessage());
            listaRegistros.add("Error al cargar los datos");
        }

        return listaRegistros; 
    }
}
