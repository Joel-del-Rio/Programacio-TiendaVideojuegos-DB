/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Videojuego;

/**
 *
 * @author joeli
 */
public class FicheroVideojuegos {

    public static ArrayList<Videojuego> Videojuegoss = new ArrayList<Videojuego>();

    public static String separator = File.separator;

    public static String ruta = System.getProperty("user.dir");

    public static File rutaCarpeta = new File(ruta + separator + "data");

    private static File rutaArchivo = new File(rutaCarpeta + separator + "Videojuegos.txt");

    public static void crear() {

        try {
            if (!rutaCarpeta.exists()) {
                rutaCarpeta.mkdir();
            }

            if (!rutaArchivo.exists()) {
                rutaArchivo.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Error");
        }
    }
    
    
    public static void guardar(ArrayList<Videojuego> Videojuegoss){
    
        try {
            
            FileWriter fw = new FileWriter(rutaArchivo, false);
            BufferedWriter bw = new BufferedWriter(fw);

            for(Videojuego v : Videojuegoss){
            
                bw.write(v.toString());
                bw.newLine();
                bw.flush();
            
            }
            bw.close();
            
        } catch (IOException e) {
            System.out.println("Error");
        }
    
    } 
    
    
    public static ArrayList<Videojuego> cargar(){
    
        try {
            
            FileReader fr = new FileReader(rutaArchivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while((linea = br.readLine()) != null){
                
                String[] atributo = linea.split(";");
                Videojuego v = new Videojuego(atributo[0],atributo[1],atributo[2],Double.parseDouble(atributo[3]));
                Videojuegoss.add(v);
            }
            br.close();
            
        } catch (IOException e) {
            System.out.println("Error");
        }
    
    return Videojuegoss;
    }  
}
