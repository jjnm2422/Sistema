/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Navarro
 */
public class FAjustes extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    PClases.CFecha fecha = new PClases.CFecha();
    private PFormularios.FMenu fMenu = new PFormularios.FMenu();
    DefaultTableModel model;
    private String hora;

    public FAjustes() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        LlenarVariables();
        LlenarTabla();
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

    private void restaurarVentana() {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {//1
            setExtendedState(JFrame.NORMAL);//2
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }

    public void LlenarVariables() {
        try {
            String sql = "select * from variables where codvar = '1'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                txtIva.setText(rs.getString("iva"));
                txtRuta.setText(rs.getString("ruta"));
                txtHora.setText(rs.getString("hora"));
            }
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
       public void Ajustar(JLabel label, ImageIcon icon) {
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        txtRuta = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        btnSalir2 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtIva = new javax.swing.JTextField();
        lblTitulo15 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        lblTitulo4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo16 = new javax.swing.JLabel();
        txtNombre3 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        txtB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnAñadir3 = new javax.swing.JButton();
        btnBorrar3 = new javax.swing.JButton();
        btnEliminar3 = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();
        btnActualizar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Variables del Sistema");
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

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo1.setText("Usuario activo");
        jPanel1.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 20));

        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo2.setText("%");
        jPanel1.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 20, 20));

        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo3.setText("Ubicacion de Reportes ");
        jPanel1.add(lblTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 20));

        txtRuta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtRuta.setEnabled(false);
        jPanel1.add(txtRuta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 360, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsuario.setEnabled(false);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 110, -1));

        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 100, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497913416_gtk-refresh.png"))); // NOI18N
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 30, 20));

        txtIva.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIva.setEnabled(false);
        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIvaKeyTyped(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 50, -1));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo15.setText("Hora Actual");
        jPanel1.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 20));

        txtHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtHora.setEnabled(false);
        jPanel1.add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 110, -1));

        lblTitulo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo4.setText("Valor Actual Iva");
        jPanel1.add(lblTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 20));

        jButton2.setText("...");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 30, -1));

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497913416_gtk-refresh.png"))); // NOI18N
        btnBuscar1.setContentAreaFilled(false);
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 30, 20));

        jTabbedPane1.addTab("Variables", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setText("Nombre de Categoria");
        jPanel4.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 20));

        txtNombre3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre3KeyTyped(evt);
            }
        });
        jPanel4.add(txtNombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 180, 20));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categorias Registradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtB.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });
        txtB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBKeyTyped(evt);
            }
        });
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tbl);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 530, 100));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 550, 160));

        btnAñadir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497479141_list-add.png"))); // NOI18N
        btnAñadir3.setText("Anadir");
        btnAñadir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAñadir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadir3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnAñadir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 90, 20));

        btnBorrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar3.setText("Borrar");
        btnBorrar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 90, 20));

        btnEliminar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497313212_trash.png"))); // NOI18N
        btnEliminar3.setText("Eliminar");
        btnEliminar3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 110, 30));

        btnSalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 110, 30));

        btnActualizar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497913416_gtk-refresh.png"))); // NOI18N
        btnActualizar2.setText("Actualizar");
        btnActualizar2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnActualizar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 110, 30));

        jTabbedPane1.addTab("Categorias", jPanel4);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 570, 270));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 340));

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

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtIva.isEnabled()) {
            if (!txtIva.getText().equals("")) {
               try {
                String sql = "update variables set iva=? where codvar = '1'";
                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setInt(1, Integer.parseInt(this.txtIva.getText()));
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "IVA actualizado correctamente", "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    txtIva.setEnabled(false);
                    this.LlenarVariables();
                    acciones.conn.close();
                }
            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar IVA\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            } 
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese el valor del iva",
                    "Error", JOptionPane.PLAIN_MESSAGE, iconAd);
            }
                    } else {
            txtIva.setEnabled(true);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalir3ActionPerformed

    private void btnEliminar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar3ActionPerformed
        int fila = tbl.getSelectedRow();
   
        if (fila!=-1) {
                 int seleccion = JOptionPane.showOptionDialog(
                null,
                "¿Esta seguro que dese Borrar el registro selecionado?", 
                "Advertencia",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
                "Nuevo");
                 if (seleccion == 0) {
                try {
                String sql = "delete from tipoproducto where codtip='" + tbl.getValueAt(fila, 0) + "'";
                Statement st = acciones.Eliminar(sql);
                int n = st.executeUpdate(sql);
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente del sistema", "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    txtNombre3.setText("");
                    this.LlenarTabla();
                    acciones.conn.close();
                }
            } catch (SQLException e) {

                //con esto se el codigo unico del error para poder controlarlo
//                System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
//                "SLQState: " + e.getSQLState() + "\n" +
//                "Mensaje: " + e.getMessage() + "\n");

                // error clave primaria duplicada y muestro mensaje 
                if (e.getSQLState().equals("23503")) {
                    JOptionPane.showMessageDialog(null, "No se puede Elminiar la categoria debido a que esta vinculada a una o varias ventas",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar Categoria\nCodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            }
            }
        }else{
        JOptionPane.showMessageDialog(null, "Debe seleccionar una fila en la tabla",
                        "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
    }
    }//GEN-LAST:event_btnEliminar3ActionPerformed

    private void btnBorrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar3ActionPerformed
        txtNombre3.setText("");
    }//GEN-LAST:event_btnBorrar3ActionPerformed

    private void btnAñadir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadir3ActionPerformed
        if (!txtNombre3.getText().equals("")) {
            if (Verificacion(txtNombre3.getText())) {
                try {
                String sql = "insert into tipoproducto(tipprod) values(?)";
                PreparedStatement ps = acciones.Ingresar(sql);
                ps.setString(1, txtNombre3.getText().toLowerCase());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Categoria Registrada con exito",
                            "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    txtNombre3.setText("");
                    this.LlenarTabla();
                    acciones.conn.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar Categoria\ncodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
        }

    }//GEN-LAST:event_btnAñadir3ActionPerformed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
        if (!txtB.getText().equals("")) {
            try {
                String[] titulos = {"Codigo", "Categoria"};
                String sql = "select * from tipoproducto where tipprod like '" + txtB.getText() + "%'";
                model = new DefaultTableModel(null, titulos);
                ResultSet rs = acciones.Consultar(sql);
                String[] fila = new String[8];
                while (rs.next()) {
                    fila[0] = rs.getString("codtip");
                    fila[1] = rs.getString("tipprod");
                    model.addRow(fila);
                }
                tbl.setModel(model);
                acciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            this.LlenarTabla();
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void txtBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyTyped
        char c = evt.getKeyChar();
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c==evt.VK_SPACE || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtB.getText().length();
            //cambie este numero que es el limite
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtBKeyTyped

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked

    }//GEN-LAST:event_tblMouseClicked

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void btnActualizar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar2ActionPerformed
        this.LlenarTabla();
        this.txtB.setText("");
    }//GEN-LAST:event_btnActualizar2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
   JFileChooser explorador = new JFileChooser("\\home\\");
    explorador.setDialogTitle("Abrir ubicacion de los reportes...");
    explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    int seleccion = explorador.showDialog(null, "Abrir!");
    //Podemos crear un File con lo seleccionado
    File archivo = explorador.getSelectedFile();

    //y guardar una ruta
    String ruta = archivo.getPath();
    //analizamos la respuesta
    switch(seleccion) {
    case JFileChooser.APPROVE_OPTION:
        try {
                String sql = "update variables set ruta=?";
                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setString(1, ruta);    
                int n = ps.executeUpdate();
                if (n > 0) {
                    txtRuta.setText(ruta);
                    JOptionPane.showMessageDialog(null, "Ruta Actualizada con exito",
                            "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    acciones.conn.close();
                }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al Actualizar Ruta\ncodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
     break;

    case JFileChooser.CANCEL_OPTION:
     //dio click en cancelar o cerro la ventana
     break;

    case JFileChooser.ERROR_OPTION:
     //llega aqui si sucede un error
     break;
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtIvaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyTyped
    char c = evt.getKeyChar();
        int lim = txtIva.getText().length();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIvaKeyTyped

    private void txtNombre3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre3KeyTyped
    char c = evt.getKeyChar();
        /*verifico que el caracter sea una letra mayuscula o minuscula o sea la tecla de borrar
         si no emito un sonido e ignoro lo que teclee*/
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtNombre3.getText().length();
            //cambie este numero que es el limite
            if (lim >= 20) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombre3KeyTyped

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        try {
            txtHora.setText(fMenu.Hora());
        } catch (SQLException ex) {
            Logger.getLogger(FAjustes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAjustes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar2;
    private javax.swing.JButton btnAñadir3;
    private javax.swing.JButton btnBorrar3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnEliminar3;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre3;
    private javax.swing.JTextField txtRuta;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void LlenarTabla() {
        try {
            String[] titulos = {"Codigo", "Categoria"};
            String sql = "select * from tipoproducto";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = acciones.Consultar(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("codtip");
                fila[1] = rs.getString("tipprod");
                model.addRow(fila);
            }
            tbl.setModel(model);
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private boolean EventoKeyType(int valor, int limitacion){
            //pido el valor del text y pido el valor limitante
            if (valor >= limitacion) {
                return true;
            }else{
                return false;
            }
    }

    private boolean Verificacion(String cadena) {
        boolean tipo = true;
        try {
            String sql = "select * from tipoproducto where tipprod = '"+cadena+"'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "Categoria ya Existe",
                        "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                tipo = false;
            }
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return tipo;
    }
}
