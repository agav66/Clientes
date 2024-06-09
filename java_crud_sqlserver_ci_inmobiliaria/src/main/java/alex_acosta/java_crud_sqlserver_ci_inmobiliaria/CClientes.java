/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alex_acosta.java_crud_sqlserver_ci_inmobiliaria;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class CClientes {    
    
    int Codigo;
    String nombresCliente;
    String ApellidosCliente;

    public int getId() {
        return Codigo;
    }

    public void setId(int Id) {
        this.Codigo = Id;
    }

    public String getNombresCliente() {
        return nombresCliente;
    }

    public void setNombresCliente(String nombresCliente) {
        this.nombresCliente = nombresCliente;
    }

    public String getApellidosCliente() {
        return ApellidosCliente;
    }

    public void setApellidosCliente(String ApellidosCliente) {
        this.ApellidosCliente = ApellidosCliente;
    }
    
    public void MostrarClientes (JTable paramTablaTotalClientes){
        
        CConexion objetoConexion = new CConexion();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql="";
        
        modelo.addColumn("Id");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        
        paramTablaTotalClientes.setModel(modelo);
        
        sql ="select * from Clientes;";
        
        String [] datos = new String[3];
        
        Statement st;
        
            try {

                st = objetoConexion.establecerConexion().createStatement();

                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    datos[0]= rs.getString(1);
                    datos[1]= rs.getString(2);
                    datos[2]= rs.getString(3);

                    modelo.addRow(datos);
                }


                paramTablaTotalClientes.setModel(modelo);

                }catch (SQLException ex) {

                System.out.println(ex.toString());
            
                }
    
    }
    
    public void InsertarClientes(JTextField paramNombres, JTextField paramApellidos){
        
        setNombresCliente(paramNombres.getText());
        setApellidosCliente(paramApellidos.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "insert into Clientes (nombres,apellidos) values (?, ?);";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta) ;
            cs.setString(1, getNombresCliente());
            cs.setString(1, getApellidosCliente());
            
            cs.execute();
            
            System.out.println("Se inserto corrextamente!!!");
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            
        }
        
    }
    
    public void SeleccionarClientes (JTable paramTablaClientes, JTextField paramId, JTextField paramNombres, JTextField paramApellidos){
        
        int fila = paramTablaClientes.getSelectedRow();
        if (fila>=0) {
            
            paramId.setText(paramTablaClientes.getValueAt(fila, 0).toString());
            paramNombres.setText(paramTablaClientes.getValueAt(fila, 1).toString());
            paramApellidos.setText(paramTablaClientes.getValueAt(fila, 2).toString());
            
        }
        
        else {
            
            System.out.println("Filas no seleccionadas!!!");
            
        }
        
        
        
    }
    
    public void ModificarClientes(JTextField paramIdCliente, JTextField paramNombres, JTextField paramApellidos){
        
        
        setId(Integer.parseInt(paramIdCliente.getText()));
        setNombresCliente(paramNombres.getText());
        setApellidosCliente(paramApellidos.getText());
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "insert into Clientes (nombres,apellidos) values (?, ?);";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta) ;
            cs.setString(1, getNombresCliente());
            cs.setString(1, getApellidosCliente());
            
            cs.execute();
            
            System.out.println("Se Inserto corrextamente!!!");
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            
        }
        
    }
    
    public void EliminarClientes(JTextField paramCodigo){
        
        
        setCodigo(Integer.parseInt(paramCodigo.getText()));
        
        
        CConexion objetoConexion = new CConexion();
        
        String consulta = "delete from Clientes WHERE Clientes.id = ? ";
        
        try {
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta) ;
            int getCodigo = 0;
            cs.setInt(1, getCodigo) ;           
            
            cs.execute();
            
            System.out.println("Se Elimino   corrextamente!!!");
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            
        }
        
    }

    private void setCodigo(int parseInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
    
    
