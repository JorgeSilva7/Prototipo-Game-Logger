/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipometodos;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    
    
    
    
    public static void main(String[] args) {
        
       System.out.println("La ruta es: "+ingresarRuta());
        System.out.println("TEST GIT23"); 
    }
    
}