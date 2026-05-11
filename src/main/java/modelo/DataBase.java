/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author joeli
 */
public class DataBase {

    private static String datosConexion = "jdbc:mysql://localhost:3306/";
    private static String baseDatos = "videojuegosTienda";
    private static String user = "root";
    private static String pwrd = "";

    private static Connection con;

    public DataBase() {
        try {
            con = DriverManager.getConnection(datosConexion, user, pwrd);
            crearDB();
            con = DriverManager.getConnection(datosConexion + baseDatos, user, pwrd);
            try {
                crearTabla();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void crearDB() throws SQLException {

        String query = "create database if not exists " + baseDatos + ";";
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }

    private static void crearTabla() throws Exception {
        String query = """
                create table if not exists inventario(
                codigo int not null primary key,
                titulo varchar(100) not null,
                desarrollador varchar(100) not null,
                precio double not null
                );
                """;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
        }
    }

    public static Connection getCon() {
        return con;
    }

}
