/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Joel Flores
 */
public class clsArticulo {
    // atributos que necesito que tenga mi objeto
    private String codigo;
    private String descripcion;
    private Double precio;

    // constructor
    public clsArticulo(String codigo, String descripcion, Double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;

    }
        
    public clsArticulo(){
        
    }
    
    // imprimir en consola los datos del articulo
    public String aTexto() {
        // Solo retornamos la cadena, no imprimimos aquí
        return this.codigo + "|" + this.descripcion + "|" + this.precio;
    }
    
    public String getDescripcion() {
        return this.descripcion;
        
    }

    // guardar informacion
    public void guardar() {
        mArticulo article = new mArticulo();
        String textoArticulo = this.aTexto(); // Obtenemos el texto una sola vez

        // Enviamos la cadena para guardar en el archivo
        article.Insertar(textoArticulo);

        // Si quieres verlo en consola una sola vez:
        System.out.println(textoArticulo);
    }
    public DefaultListModel<String> llenarLista(){
        mArticulo MArticle = new mArticulo();
        
        ArrayList<String> datos = MArticle.Consultar();
        
        DefaultListModel<String> modelLista = new DefaultListModel<>();
        
        for (String registro: datos){
            modelLista.addElement(registro);
        }
        
        return modelLista;
    }
    
    public void actualizar(String newCodigo, String newDescripcion, Double newPrecio){
         String nuevaLinea = newCodigo + "|" + newDescripcion + "|" + newPrecio ;        
         String lineaOriginal = this.codigo + "|" + this.descripcion + "|" + this.precio ;
         //imprimir nuevos valores
         System.out.println("Nuevos valores: " + nuevaLinea);
         System.out.println("Valores anterior: " + lineaOriginal);
         //solicita la actualizacion de registros
         mArticulo mArticle = new mArticulo();
         mArticle.update(lineaOriginal, nuevaLinea, "listado_articulos.txt");
         
         
         
    }
    
    public void eliminar(){
         //resgistro a eliminar 
         String lineaOriginal = this.codigo + "|" + this.descripcion + "|" + this.precio ;
         //imprimir nuevos valores
         System.out.println("Valores anteriores: " + lineaOriginal);
         //solicita la eliminacion de registros
         mArticulo mArticle = new mArticulo();
         mArticle.delete(lineaOriginal, "listado_articulos.txt");
         
         
         
    }
}
