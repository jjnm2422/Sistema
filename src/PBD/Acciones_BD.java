/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PBD;

import PBD.Conexion_DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;


public class Acciones_BD {
    
    public java.sql.Connection conn;
    public Statement st;
    
    public ResultSet Consultar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        ResultSet resultado = st.executeQuery(sql);
        conn.close();
        return resultado;
    }
    
    public PreparedStatement Actualizar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        PreparedStatement st = conn.prepareCall(sql);
        return st;
    }
    
    public PreparedStatement Ingresar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        st = conn.createStatement();
        PreparedStatement st = conn.prepareCall(sql);
        return st;
    }
    
    public Statement Eliminar(String sql) throws SQLException{
        conn= Conexion_DB.geConnection();
        return st;
    }
            
}
