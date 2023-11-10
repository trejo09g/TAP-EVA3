/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author garci
 */
public class EVA3_1_mysql {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer conexion 
            String url = "jdbc:mysql://localhost:3306/sakila";
            connection = DriverManager.getConnection(url, "root", "BaseAT.");

        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
        try {
            //CONSULTA
            Statement statement = connection.createStatement();
            ResultSet resu;
            resu = statement.executeQuery("select  actor_id,first_name,last_name" + " from actor limit 10;");

           String consulta = "select  actor_id,first_name,last_name" + " from actor where actor_id = ?;";
            PreparedStatement pState = connection.prepareStatement(consulta);
            pState.setInt(1, 4);
           // ResultSet resu;
            resu = pState.executeQuery();

            int actorId;
            String firstName, lastName;
            while (resu.next()) { // Regresa true mientras haya datos
                actorId = resu.getInt("actor_id");
                firstName = resu.getString("first_name");
                lastName = resu.getString("last_name");
                System.out.println("Actor:" + actorId);
                System.out.println("Nombre:" + firstName);
                System.out.println("Apellido:" + lastName);

                // INSERTAR VALORES 
                String insertar = "insert into actor(first_name, last_name " + " values (?,?);";

                PreparedStatement pSInsert = connection.prepareStatement(insertar);
                pSInsert.setString(1, "ALONSO");
                pSInsert.setString(2, "FERNADEZ");
                pSInsert.execute();
                
                // ACTUALIZAR VALORES
                String Update = "update from actor " + " set first_name = ?, last_name = ? " + " where actor_id = ?;";

                PreparedStatement pSUpdate = connection.prepareStatement(Update);
                pSUpdate.setString(1, "ALONSO");
                pSUpdate.setString(2, "FERNADEZ");
                pSUpdate.setInt(2,158);
                pSUpdate.execute();
               
               //ELIMINAR VALORES
                String delete = "delete from actor " + " where actor_id = ?;";
                PreparedStatement pSDelete = connection.prepareStatement(delete);
                pSDelete.setInt(1,10);
                pSDelete.execute();

            }
             String delete = "delete from actor " + " where actor_id = ?;";
                PreparedStatement pSDelete = connection.prepareStatement(delete);
                pSDelete.setInt(1,10);
                pSDelete.execute();

        } catch (SQLException ex) {
            
        }
        
    }
}
