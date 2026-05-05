/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.Videojuego;
import persistencia.FicheroVideojuegos;

/**
 *
 * @author joeli
 */
public class VideojuegosControlador {

    private static ArrayList<Videojuego> inventario = new ArrayList<Videojuego>();

    public static void guardar() {

        FicheroVideojuegos.guardar(inventario);

    }

    public static void cargar() {

        inventario = FicheroVideojuegos.cargar();

    }

    public static void anadir(Videojuego v) {

        if (comprove(v) == true) {
            inventario.add(v);
            JOptionPane.showMessageDialog(null, "Videojuego anadido correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "Videojuego ya registrado");
        }

    }

    public static Videojuego buscarPorCodigo(String codigo) {

        Videojuego v = null;
        for (Videojuego vi : inventario) {
            if(vi.getCodigo().equalsIgnoreCase(codigo)){
                v = vi;
                break;
            }
        }
        if (v == null) {
            JOptionPane.showMessageDialog(null, "No existe este videojuego");
        }
        return v;
    }
    
    public static void eliminarPorCodigo(String codigo) {
    
        for(Videojuego v : inventario){
            if(v.getCodigo().equalsIgnoreCase(codigo)){
                inventario.remove(v);  
                JOptionPane.showMessageDialog(null, "Videojuego eliminado correctamente");
                break;
            }
        }
    }
    
    public static ArrayList<Videojuego> listarVideojuegos(){
    
        return inventario;
    
    }


    public static boolean comprove(Videojuego v) {

        boolean comprove = true;

        for (Videojuego vi : inventario) {

            if (vi.getCodigo().equalsIgnoreCase(v.getCodigo())) {
                comprove = false;
                break;
            }
        }
        return comprove;
    }
    
    public static DefaultListModel<String> lista(){
    
        DefaultListModel<String> model = new DefaultListModel<String>();
        for(Videojuego v : inventario){
            model.addElement(v.getCodigo());
        }
    return model;    
    }

}
