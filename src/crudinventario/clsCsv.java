/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Joel Flores
 */
public class clsCsv {
    //atributo de el objeto csv
    String archivo = "Inventario.csv";
    
    public void importarDatos(){    
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){        
            br.readLine();   
            String linea;         
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");

                clsArticulo cArticulo = new clsArticulo(datos[0], datos[1], Double.parseDouble(datos[2]));
                
                cArticulo.guardar();
                }
            br.close();
            System.out.println("Se ha terminado la importacion.");    
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());
        }
    }

    public void importarDatosClientes(){    
        String archivoClientes = "Clientes.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(archivoClientes))){        
            br.readLine();   
            String linea;         
            while ((linea = br.readLine()) != null){
                String[] datos = linea.split(",");

                clsClientes cCliente = new clsClientes(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3]);
                
                cCliente.guardar();
                }
            br.close();
            System.out.println("Se ha terminado la importacion.");    
        }catch(IOException e){
            System.out.println("Mensaje de error" + e.getMessage());
        }
    }
}
