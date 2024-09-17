/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Taili Jimenez 
 */
public class Conexion {
    public Connection conexionBD;
    public final String bd = "db_escuela";
    public final String urlConexion = String.format("jdbc:mysql://localhost:3306/%s", bd);
    public final String usuario = "root";
    public final String password = "Taili01";
    public final String jdbc ="com.mysql.cj.jdbc.Driver";
    
    public void abrir_conexion(){
        try{
            Class.forName(jdbc);
            conexionBD = DriverManager.getConnection(urlConexion, usuario, password);
            JOptionPane.showMessageDialog(null, "Conexion Exitosa... ", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            System.out.println("Error..."+ ex.getMessage());
        }
    }
    public void cerrar_conexion(){
    try{
        conexionBD.close();
    }catch(Exception ex){
        System.out.println("Error..."+ex.getMessage());
    }
    }
}
