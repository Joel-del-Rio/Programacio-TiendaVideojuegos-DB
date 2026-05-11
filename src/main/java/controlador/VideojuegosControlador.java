/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import modelo.DataBase;
import modelo.Videojuego;

/**
 *
 * @author joeli
 */
public class VideojuegosControlador {

    private static DataBase db = new DataBase();

    private static Connection con = db.getCon();

    //CRUD
    //CREATE
    public static void anadir(Videojuego v) {

        String query = "insert into inventario(codigo, titulo, desarrollador, precio) values(?,?,?,?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, v.getCodigo());
            ps.setString(2, v.getTitulo());
            ps.setString(3, v.getDesarrollador());
            ps.setDouble(4, v.getPrecio());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Videojuego añadido correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al añadir el videojuego");
        }

    }

    //READ
    public static Videojuego buscarPorCodigo(int codigo) {
        String query = "select * from inventario where codigo = ?";
        Videojuego v = null;

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                v = new Videojuego(
                        rs.getInt("codigo"),
                        rs.getString("titulo"),
                        rs.getString("desarrollador"),
                        rs.getDouble("precio")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    //UPDATE
    public static void update(int codigo, double precio) {
        String query = "update inventario set precio = ? where codigo = ?";
        
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setDouble(1, precio);
            ps.setInt(2, codigo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Videojuego actualizado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //DELETE
    public static void eliminarPorCodigo(int codigo) {
        String sql = "delete from inventario where codigo = ?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Videojuego eliminado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static DefaultListModel<String> lista() {

        String query = "select codigo from inventario";
        DefaultListModel<String> modelo = new DefaultListModel<>();

        try (PreparedStatement ps = con.prepareStatement(query); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                modelo.addElement(rs.getString("codigo"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelo;
    }

}
