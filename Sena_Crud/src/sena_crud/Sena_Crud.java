/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sena_crud;

/**
 *
 * @author Lucho
 */


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sena_Crud {

    public static void main(String[] args) {

        String usuario = "root";
        String password = "OmicronPersei8*";
        String url = "jdbc:mysql://localhost:3306/Construempleo";
        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Sena_Crud.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            statement.executeUpdate("DELETE FROM eps;");        // <----- aqui va la consulta SQL
            rs = statement.executeQuery("SELECT * FROM eps");
            while (rs.next()) {
                System.out.println(rs.getInt("id_eps") + " : " + rs.getString("nombre_eps"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Sena_Crud.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
}
    
