/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.sun.awt.AWTUtilities;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Navarro
 */
public class FReportes extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    public DefaultTableModel model;
    private int iva = 0;
    private DecimalFormat format = new DecimalFormat("#.00 Bsf");
    private DefaultTableModel model2;

 

    public void setlook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }



   

    public int getCodProveedores(String nombre) {
        int cod = 0;
        try {
            String sql = "select * from proveedores where nompro = '" + nombre + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                cod = rs.getInt("rifpro");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
        return cod;
    }

    public float getIva() {
        try {
            String sql = "select * from variables where codvar = '1'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                iva = rs.getInt("iva");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar Iva\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
        return iva;
    }



    public int getCodTipoProducto(String nombre) {
        int cod = 0;
        try {
            String sql = "select * from tipoproducto where tipprod = '" + nombre + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                cod = rs.getInt("codtip");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
        return cod;
    }

    private void restaurarVentana() {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {//1
            setExtendedState(JFrame.NORMAL);//2
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }

  

  

    public void Ajustar(JLabel label, ImageIcon icon) {
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
    }

    /* private void Habilitar(int x) {
        switch (x) {
            case 2:
            txtNombre2.setEnabled(true);
//            txtApellido2.setEnabled(true);
            txtComentario2.setEnabled(true);
            txtTelefono22.setEnabled(true);
            txtTelefono21.setEnabled(true);
            txtDireccion2.setEnabled(true);
            txtHorario2.setEnabled(true);
            txtPagina2.setEnabled(true);
                break; 
            case 3:
           txtNombre2.setEnabled(false);
//            txtApellido2.setEnabled(false);
            txtComentario2.setEnabled(false);
            txtTelefono21.setEnabled(false);
            txtTelefono22.setEnabled(false);
            txtDireccion2.setEnabled(false);
            txtHorario2.setEnabled(false);
            txtPagina2.setEnabled(false);
           
                break;
            default:
        }       
    }*/
 /* private void Borrar(int x) {
        switch (x) {
            case 1:
            txtNombre1.setText("");
            txtPagina1.setText("");
            txtHorario1.setText("");
            txtComentario1.setText("");
            txtCedula1.setText("");
            txtTelefono11.setText("");
            txtTelefono12.setText(""); 
            txtDireccion1.setText("");
                break;
            case 2:
            txtNombre2.setText("");
            txtPagina2.setText("");
            txtHorario2.setText("");
            txtComentario2.setText("");
            txtCedula2.setText("");
            txtTelefono21.setText("");
            txtTelefono22.setText(""); 
            txtDireccion2.setText("");
                break;
            case 3:
            txtNombre2.setText("");
            txtPagina2.setText("");
            txtHorario2.setText("");
            txtComentario2.setText("");
            txtTelefono21.setText("");
            txtTelefono22.setText(""); 
            txtDireccion2.setText("");
                break;
            default:
        }
    }*/
 /* private boolean Verificacion1(){
        if (txtNombre1.getText().equals("")
         || txtCedula1.getText().equals("") || txtTelefono11.getText().equals("")
         || txtDireccion1.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia",JOptionPane.PLAIN_MESSAGE,iconAd);
            return false;
        } else {
            return true;
        }
    }
    
    private boolean Verificacion2(){
        if (txtNombre2.getText().equals("")
         || txtCedula2.getText().equals("") || txtTelefono21.getText().equals("")
         || txtDireccion2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia",JOptionPane.PLAIN_MESSAGE,iconAd);
            return false;
        } else {
            return true;
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario");
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/cerrar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 570, 300));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        restaurarVentana();
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton10ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables

}
