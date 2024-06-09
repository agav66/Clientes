/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex_acosta.java_crud_sqlserver_ci_inmobiliaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

        
        

/**
 *
 * @author Usuario
 */
public class CConexion {
    
    Connection conectar = null;
    
    String conexionUrl = "jdbc:sqlserver://DESKTOP-IT7TIK7\\SQLEXPRESS:1433;" 
            + "database=bdCInmobiliaria;"
            + "user=sa;"
            + "password=123;"
            + "loginTimeout=30";
    
    
    public Connection establecerConexion() {
        
        try {
            conectar = DriverManager.getConnection(conexionUrl);
            System.out.println("conexion exitosa");
            return conectar;
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
        
        
    }
}

