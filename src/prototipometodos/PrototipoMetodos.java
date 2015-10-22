/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipometodos;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.Scanner;
/**
 *
 * @author Coke
    */
public class PrototipoMetodos {

    public static String ingresarRuta(){
        String ruta=null;
        JFileChooser explorador = new JFileChooser("");
        explorador.setDialogTitle("Abrir juego");
        explorador.setFileFilter(new FileNameExtensionFilter("Ejecutables", "exe"));
        
        int seleccion = explorador.showDialog(null, "Abrir!");
        switch(seleccion) {
        case JFileChooser.APPROVE_OPTION:
        //seleccionó abrir
            File archivo = explorador.getSelectedFile();
            ruta = archivo.getPath();
        break;
        case JFileChooser.CANCEL_OPTION:
            ruta=(null);
        break;
        case JFileChooser.ERROR_OPTION:
        //dio click en cancelar o cerro la ventana
        //llega aqui si sucede un error
            ruta=(null);
        break;
        }
        return ruta;
    }
    
    public static void ejecutarJuego(String ruta){
    try{    
    Runtime.getRuntime().exec("cmd.exe /c start \"\" \""+ruta+"\"");
    }catch(Exception e){
        System.exit(0);
    }  
    }
    
    public static String leerNombre(Scanner leer){
    
    System.out.println("Ingrese el nombre que desee asignarle al juego");
    String nombre=leer.next();
    //for(i=0; i<arreglo.lenght; i++){
    //    nombre=arreglo[i];
    //}
    
    return nombre;
    
}
    public static void agregarJuego(String arreglo[][],String ruta, String nombre,Scanner leer){
        //Si fuera un arreglo
        //arreglo y leer solo si fuera un arreglo (prototipo)
        System.out.println("Ingrese columna donde agregar juego");
        int opt=leer.nextInt();
        arreglo[0][opt]=nombre;
        arreglo[1][opt]=ruta;
    }
    
    public static String buscarJuego(){
        Scanner leer = new Scanner(System.in);
        String ruta;
        System.out.println("Ingrese el nombre del juego que desea buscar");
        String nombre = leer.next();
        System.out.println("El juego se está buscando, espere..."); // Aquí se debería buscar en el arreglo cuando este hecho
        // for(int i = 0; i < arreglo.lenght; i++){
        //      if(nombre == arreglo[i]){
        //          System.out.println("Se ha encontrado el juego");
        //          ruta = ruta del arreglo;
        //  }
        // }
        
        ruta = "RUTA DE JUEGO";
        return ruta;
    }
    
    
    public static void eliminarJuegos(String juego){
        File archivo = new File(juego);
	
	if(archivo.delete()){
            System.out.println("El juego ha sido eliminado satisfactoriamente");
       }
}
    
    public static void main(String[] args) {
        
        
       System.out.println("La ruta es: "+ingresarRuta());
       
    }
    
}