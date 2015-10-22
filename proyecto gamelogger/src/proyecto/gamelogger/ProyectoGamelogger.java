/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.gamelogger;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.*;
/**
 *
 * @author juan pablo
 */
public class ProyectoGamelogger {
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
    public static String ingresarRutaImg(){
        String ruta=null;
        JFileChooser explorador = new JFileChooser("");
        explorador.setDialogTitle("Seleecionar Imagen (opcional)");
        explorador.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "jpeg","png"));
        int seleccion = explorador.showDialog(null, "Seleccionar");
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
    
    public static String buscarJuego(String nombre){
        return "";
    }
    
    
    public static void eliminarJuegos(String juego){
	String ruta;
        ruta = buscarJuego(juego);
        File archivo = new File(ruta);
	
	if(archivo.delete()){
            System.out.println("El juego ha sido eliminado satisfactoriamente");
        }
}
    public static String leerNombre(String nombre){
    
    Scanner leer=new Scanner (System.in);
    System.out.println("Ingrese el nombre que desee asignarle al juego");
    nombre=leer.next();
    //for(i=0; i<arreglo.lenght; i++){
    //    nombre=arreglo[i];
    //}
    
    return nombre;
    
}

   
    
    
    public static void main(String[] args) {
        //ignorar todo
         int op;
        String ruta;
        Scanner leer=new Scanner(System.in);
        ruta=ingresarRuta();
        System.out.println("La ruta del juego es: "+ruta);
        System.out.println("Desea agregar una imagen?");
        op=leer.nextInt();
        if(op==1){
        ingresarRutaImg();
        }
        
        System.out.println("¿Desea ejecutar el juego?: ");
        op=leer.nextInt();
        if(op==1){
            ejecutarJuego(ruta);
        }else{
            
        }
       
        // TODO code application logic here
    }
    
}
