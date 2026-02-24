/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudinventario;

/**
 *
 * @author Joel Flores
 */
public class clsArticulo {
    //atributos que necesito que tenga mi objeto
    private String codigo;
    private String descripcion;
    private Double precio;
    
    
    //constructor
    public clsArticulo(String codigo, String descripcion, Double precio){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        
    }
    // imprimir en consola los datos del articulo
    public String aTexto(){
        String articulo = this.codigo + "|" + this.descripcion + "|" + this.precio;
        System.out.print(articulo);
        return articulo;
        
        
    }
    
    // guardar informacion
    public void guardar(){
        System.out.println(this.aTexto());
        
    }
}
