/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Taili Jimenez 
 */
public class Docente extends Persona{
    private String salario, fecha_inicio_lab, fecha_ingreso_reg;
    Conexion cn;

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getFecha_inicio_lab() {
        return fecha_inicio_lab;
    }

    public void setFecha_inicio_lab(String fecha_inicio_lab) {
        this.fecha_inicio_lab = fecha_inicio_lab;
    }

    public String getFecha_ingreso_reg() {
        return fecha_ingreso_reg;
    }

    public void setFecha_ingreso_reg(String fecha_ingreso_reg) {
        this.fecha_ingreso_reg = fecha_ingreso_reg;
    }
    
    public DefaultTableModel leer(){
    DefaultTableModel tabla = new DefaultTableModel();
    try{
        cn = new Conexion();
        cn.abrir_conexion();
        String query;
        query = "Select id_Docentes as id_Docentes, Salario, Fecha_ingreso_laborar, Fecha_ingreso_registro from docentes;";
        ResultSet consulta = cn.conexionBD.createStatement().executeQuery(query);
        String encabezado[] = {"ID", "SALARIO", "FECHA_INICIO", "FECHA_INGRESO"};
        tabla.setColumnIdentifiers(encabezado);
        String datos []=new String[4];
        while(consulta.next()){
        datos[0] = consulta.getString("id_Docentes");
        datos[1] = consulta.getString("Salario");
        datos[2] = consulta.getString("Fecha_ingreso_laborar");
        datos[3] = consulta.getString("Fecha_ingreso_registro");
        tabla.addRow(datos);
        }
        cn.cerrar_conexion();
    }catch(SQLException ex){
        cn.cerrar_conexion();
        System.out.println("Error: "+ ex.getMessage());
    }
    return tabla;
    }
    @Override
    public void agregar(){
       try{
           PreparedStatement parametro;
           String query = "INSERT INTO docentes(Salario,Fecha_ingreso_laborar,Fecha_ingreso_registro)VALUES(?,?,?);";
           cn = new Conexion();
           cn.abrir_conexion();
           parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
           parametro.setString(1, this.getSalario());
           parametro.setString(2, this.getFecha_inicio_lab());
           parametro.setString(3, this.getFecha_ingreso_reg());           
           int ejecutar = parametro.executeUpdate();
           cn.cerrar_conexion();
           JOptionPane.showMessageDialog(null,Integer.toString(ejecutar) + "Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
       }catch(HeadlessException | SQLException ex){
           System.out.println("Error..."+ ex.getMessage());
       }
    
    }
    public void actualizar() {
        try {
    PreparedStatement parametro;
    String query = "UPDATE docentes SET Salario,Fecha_ingreso_laborar,Fecha_ingreso_registro WHERE id_Docentes;";
    cn = new Conexion();
    cn.abrir_conexion();
           parametro = (PreparedStatement) cn.conexionBD.prepareStatement(query);
           parametro.setString(1, this.getSalario());
           parametro.setString(2, this.getFecha_inicio_lab());
           parametro.setString(3, this.getFecha_ingreso_reg());           
           int ejecutar = parametro.executeUpdate();
           cn.cerrar_conexion();
           JOptionPane.showMessageDialog(null,Integer.toString(ejecutar) + "Registro Ingresado","Agregar",JOptionPane.INFORMATION_MESSAGE);
       }catch(HeadlessException | SQLException ex){
           System.out.println("Error..."+ ex.getMessage());
       }
}


}
