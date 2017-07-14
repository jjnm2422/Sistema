/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PBD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Flia Navarro Moreno
 */
public class Conexion_DB {

    private static String bd="dbventas", user="postgres",pass="123456", url="jdbc:postgresql://198.168.1.109:5432/"+bd;
    private static Connection conn;
    
public static Connection geConnection(){
    try{
        Class.forName("org.postgresql.Driver");
        conn=DriverManager.getConnection(url,user,pass);
    }   catch (Exception e) {
           JOptionPane.showMessageDialog(null, "error"+e.getMessage());
        }
        return conn;
}
}
