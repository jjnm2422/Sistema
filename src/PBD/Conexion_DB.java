/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Flia Navarro Moreno
 */
public class Conexion_DB {

    private static String bd="dbventas", user="postgres",pass="123456", url="jdbc:postgresql://198.168.1.107:5432/"+bd;
    private static Connection conn;
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    
public static Connection geConnection(){
    try{
        Class.forName("org.postgresql.Driver");
        conn=DriverManager.getConnection(url,user,pass);
    }   catch (Exception e) {
           JOptionPane.showMessageDialog(null, "error: "+e.getMessage());
        }
        return conn;
}

}
