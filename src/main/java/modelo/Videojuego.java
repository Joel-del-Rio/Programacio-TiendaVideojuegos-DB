/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author joeli
 */
public class Videojuego {
    
    private String codigo;
    private String titulo;
    private String desarrollador;
    private double precio;

    public Videojuego(String codigo, String titulo, String desarrollador, double precio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.desarrollador = desarrollador;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + ";" + titulo + ";" + desarrollador + ";" + precio;
    }
    
    
    
}
