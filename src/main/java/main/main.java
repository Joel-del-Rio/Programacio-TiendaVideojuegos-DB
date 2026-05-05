/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import persistencia.FicheroVideojuegos;
import vista.VentanaPrincipal;

/**
 *
 * @author joeli
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static FicheroVideojuegos fv = new FicheroVideojuegos();
    
    public static VentanaPrincipal vp = new VentanaPrincipal();
    
    public static void main(String[] args) {
       
        fv.crear();
        
        vp.setVisible(true);
        
    }
    
}
