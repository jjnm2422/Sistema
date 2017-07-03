/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Navarro
 */
public class FLoginR extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    PClases.CFecha fecha = new PClases.CFecha();
    private String hora = "";
    private String ampm;
    private String minutos;
    private String segundos;
    private String usuario;

    public FLoginR() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
    }

    public String getPass() {
        char[] arrayC1 = txtPin.getPassword();
        String c1 = new String(arrayC1);
        return c1;
    }

    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }

    public void setlook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ActualizarUsuario() {
        try {
            String sql1 = "update usuarios set fecult=?, horult=? where nomusu= '" + usuario + "'";
            PreparedStatement ps = acciones.Actualizar(sql1);
            ps.setString(1, fecha.getFecha());
            int n = ps.executeUpdate();
            acciones.conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR ULTIMO ACCESO" + e.getMessage());
        }
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

    public void BloquearPin(int cod) {
        switch (cod) {
            case 1:
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                break;
            case 2:
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                break;
        }
    }

    public boolean ComprobarUsuario() throws SQLException {
        boolean nombre = false;
        try {
            String sql = "select * from usuarios where nomusu= '" + txtUsuario.getText() + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                nombre = true;
            }
            if (nombre == false) {
                nombre = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas con la base de datos\n" + e);
        }
        acciones.conn.close();
        return nombre;
    }

    public boolean ComprobarPin() throws SQLException {
        boolean pin = false;
        try {
            String sql = "select * from usuarios where nomusu= '" + txtUsuario.getText() + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                if (rs.getString("pinusu").equals(getPass())) {
                    pin = true;
                }
            }
            if (pin == false) {
                pin = false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas con la base de datos\n" + e);
        }
        acciones.conn.close();
        return pin;
    }

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
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtClave = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        txtPin = new javax.swing.JPasswordField();
        lblTitulo19 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblTitulo20 = new javax.swing.JLabel();
        lblTitulo21 = new javax.swing.JLabel();
        txtClave2 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambio de Clave");
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 30));

        btnIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel3.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel3.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 90, -1));

        txtClave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtClave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497311482_key_16.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 40, 30));

        btn1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 40, 20));

        btn2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel3.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 140, 40, 20));

        btn3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel3.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 40, 20));

        btn4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel3.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 40, 20));

        btn5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel3.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 40, 20));

        btn6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel3.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 40, 20));

        btn9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel3.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 40, 20));

        btn8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel3.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 40, 20));

        btn7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel3.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 40, 20));

        btnC.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnC.setText("C");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });
        jPanel3.add(btnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 40, 20));

        txtPin.setEditable(false);
        txtPin.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 70, -1));

        lblTitulo19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo19.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo19.setText("Repita Clave");
        jPanel3.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497311482_key_16.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 40, 30));

        lblTitulo20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo20.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo20.setText("Pin Seguridad");
        jPanel3.add(lblTitulo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 130, 30));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo21.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo21.setText("Nueva Clave");
        jPanel3.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 140, 30));

        txtClave2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtClave2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtClave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClave2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 140, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_family.png"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 40, 30));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 140, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 260));

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

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        char[] arrayC1 = txtClave.getPassword();
        String c1 = new String(arrayC1);
        char[] arrayC2 = txtClave2.getPassword();
        String c2 = new String(arrayC2);
        char[] arrayC3 = txtPin.getPassword();
        String c3 = new String(arrayC3);
        if (c2.equals("") || (c1.equals("")) || c3.equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
        } else {
            if (c2.equals(c1)) {
                try {
                    if (ComprobarUsuario()) {
                        if (ComprobarPin()) {
                            try {
                                usuario = txtUsuario.getText();
                                String sql = "update usuarios set clausu=? where nomusu = '" + usuario + "'";
                                PreparedStatement ps = acciones.Actualizar(sql);
                                ps.setString(1, c1);
                                int n = ps.executeUpdate();
                                if (n > 0) {
                                    JOptionPane.showMessageDialog(null, "Clave actualizada correctamente", "Informacion",
                                            JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                                    txtUsuario.setText("");
                                    txtClave.setText("");
                                    txtClave2.setText("");
                                    txtPin.setText("");
                                }
                                acciones.conn.close();
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null, "Error al actualizar datos " + e.getMessage(),
                                        "Error", JOptionPane.PLAIN_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png")));
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Pin Incorrecto", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FLoginR.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las Claves no coinciden", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            }
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "1");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "2");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "3");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "4");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "5");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "6");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "9");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "8");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (getPass().length() < 4) {
            txtPin.setText(getPass() + "7");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        txtPin.setText("");
        BloquearPin(2);
    }//GEN-LAST:event_btnCActionPerformed

    private void txtClave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClave2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClave2ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FLoginR().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo20;
    private javax.swing.JLabel lblTitulo21;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtClave2;
    private javax.swing.JPasswordField txtPin;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
