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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Navarro
 */
public class FProveedores extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    DefaultTableModel model;

    public FProveedores() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.restringir();
        this.LlenarTabla();
    }

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

    public void restringir() {
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtCedula1);
        restricted3.setOnlyNums(true);
        restricted3.setLimit(9);
        RestrictedTextField restricted4 = new RestrictedTextField(this.txtTelefono11);
        restricted4.setOnlyNums(true);
        restricted4.setLimit(11);
        RestrictedTextField restricted = new RestrictedTextField(this.txtTelefono12);
        restricted.setOnlyNums(true);
        restricted.setLimit(11);
        RestrictedTextField restricted5 = new RestrictedTextField(this.txtNombre1,"qwertyuiopasdfghjklñzxcvbnm0123456789 ");
        restricted5.setLimit(20);
        RestrictedTextField restricted6 = new RestrictedTextField(this.txtPagina1);
        restricted6.setLimit(30);
    }

    public void LlenarTabla() {
        try {
            String[] titulos = {"Rif", "Nombre", "Telefono", "Telefono",
                "Direccion", "Pagina Web", "Horario", "Comentario"};
            String sql = "select * from proveedores where not rifpro = '1'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = acciones.Consultar(sql);
            String[] fila = new String[8];
            while (rs.next()) {
                fila[0] = rs.getString("rifpro");
                fila[1] = rs.getString("nompro");
                fila[2] = rs.getString("telpro");
                fila[3] = rs.getString("tel2pro");
                fila[4] = rs.getString("dirpro");
                fila[5] = rs.getString("pagpro");
                fila[6] = rs.getString("horpro");
                fila[7] = rs.getString("despro");
                model.addRow(fila);
            }
            tbl.setModel(model);
            Ajustar1();
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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

    private void Habilitar(int x) {
        switch (x) {
            case 2:
                txtNombre2.setEnabled(true);
//            txtApellido2.setEnabled(true);
                txtComentario2.setEnabled(true);
                txtTelefono22.setEnabled(true);
                txtTelefono21.setEnabled(true);
                txtDireccion2.setEnabled(true);
                cbx1.setEnabled(true);
                cbx2.setEnabled(true);
                txtPagina2.setEnabled(true);
                cbxEst.setEnabled(true);
                break;
            case 3:
                txtNombre2.setEnabled(false);
                txtCedula2.setEnabled(true);
                txtComentario2.setEnabled(false);
                txtTelefono21.setEnabled(false);
                txtTelefono22.setEnabled(false);
                txtDireccion2.setEnabled(false);
                cbx1.setEnabled(false);
                cbx2.setEnabled(false);
                txtPagina2.setEnabled(false);
                cbxEst.setEnabled(false);
                break;
            default:
        }
    }

    private void Borrar(int x) {
        switch (x) {
            case 1:
                txtNombre1.setText("");
                txtPagina1.setText("");
                cbx3.setSelectedIndex(7);
                cbx4.setSelectedIndex(12);
                txtComentario1.setText("");
                txtCedula1.setText("");
                txtCedula1.setEnabled(true);
                txtTelefono11.setText("");
                txtTelefono12.setText("");
                txtDireccion1.setText("");
                break;
            case 2:
                txtNombre2.setText("");
                txtPagina2.setText("");
                cbx1.setSelectedIndex(7);
                cbx2.setSelectedIndex(12);
                txtComentario2.setText("");
                txtCedula2.setText("");
                txtTelefono21.setText("");
                txtTelefono22.setText("");
                txtDireccion2.setText("");
                break;
            case 3:
                txtNombre2.setText("");
                txtPagina2.setText("");
                cbx1.setSelectedIndex(7);
                cbx2.setSelectedIndex(12);
                txtComentario2.setText("");
                txtTelefono21.setText("");
                txtTelefono22.setText("");
                txtDireccion2.setText("");
                break;
            default:
        }
    }

    private boolean Verificacion1() {
        if (txtNombre1.getText().equals("")
                || txtCedula1.getText().equals("")|| txtCedula1.getText().length()<5 || txtTelefono11.getText().equals("")
                || txtDireccion1.getText().equals("") || txtTelefono11.getBackground().equals(Color.RED) || txtCedula1.getBackground().equals(Color.RED)
                || txtTelefono12.getBackground().equals(Color.RED)) {
            JOptionPane.showMessageDialog(null, "Verifique:\n"
                    + "1. Que los Campos no esten vacios\n"
                    + "2. Que los numeros telefonicos tenga 11 digitos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                return false;
        } else {
             if (cbx3.getSelectedIndex()>=cbx4.getSelectedIndex()) {
                JOptionPane.showMessageDialog(null, "Corrija el horario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                return false;
            }else{
                return true;
            }
        }
    }

    private boolean Verificacion2() {
        if (txtNombre2.getText().equals("")
                || txtCedula2.getText().equals("") || txtTelefono21.getText().equals("")
                || txtDireccion2.getText().equals("") || txtTelefono21.getBackground().equals(Color.RED) || txtCedula2.getBackground().equals(Color.RED)
                || txtTelefono22.getBackground().equals(Color.RED)) {
            JOptionPane.showMessageDialog(null, "Verifique:\n"
                    + "1. Que los Campos no esten vacios\n"
                    + "2. Que los numeros telefonicos tenga 11 digitos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        } else {
            if (cbx1.getSelectedIndex()>=cbx2.getSelectedIndex()) {
                JOptionPane.showMessageDialog(null, "Corrija el horario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                return false;
            }else{
                return true;
            }
        }
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
        jPanel2 = new javax.swing.JPanel();
        lblTitulo5 = new javax.swing.JLabel();
        lblTitulo9 = new javax.swing.JLabel();
        lblTitulo10 = new javax.swing.JLabel();
        lblTitulo11 = new javax.swing.JLabel();
        lblTitulo12 = new javax.swing.JLabel();
        lblTitulo13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentario1 = new javax.swing.JTextArea();
        lblTitulo14 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDireccion1 = new javax.swing.JTextArea();
        txtNombre1 = new javax.swing.JTextField();
        txtTelefono12 = new javax.swing.JTextField();
        txtCedula1 = new javax.swing.JTextField();
        txtTelefono11 = new javax.swing.JTextField();
        btnBorrar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnIngresar1 = new javax.swing.JButton();
        lblTitulo15 = new javax.swing.JLabel();
        txtPagina1 = new javax.swing.JTextField();
        lblTitulo19 = new javax.swing.JLabel();
        lblTitulo21 = new javax.swing.JLabel();
        lblTitulo25 = new javax.swing.JLabel();
        cbx3 = new javax.swing.JComboBox<>();
        cbx4 = new javax.swing.JComboBox<>();
        lblTitulo27 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        lblTitulo7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario2 = new javax.swing.JTextArea();
        lblTitulo8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion2 = new javax.swing.JTextArea();
        txtNombre2 = new javax.swing.JTextField();
        txtTelefono22 = new javax.swing.JTextField();
        txtTelefono21 = new javax.swing.JTextField();
        btnSalir2 = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JButton();
        btnBorrar2 = new javax.swing.JButton();
        txtPagina2 = new javax.swing.JTextField();
        lblTitulo16 = new javax.swing.JLabel();
        lblTitulo17 = new javax.swing.JLabel();
        txtCedula2 = new javax.swing.JTextField();
        lblTitulo18 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        lblTitulo22 = new javax.swing.JLabel();
        lblTitulo23 = new javax.swing.JLabel();
        lblTitulo24 = new javax.swing.JLabel();
        cbx1 = new javax.swing.JComboBox<>();
        cbx2 = new javax.swing.JComboBox<>();
        lblTitulo26 = new javax.swing.JLabel();
        lblTitulo20 = new javax.swing.JLabel();
        cbxEst = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnSalir5 = new javax.swing.JButton();
        lblTitulo28 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proveedores");
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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(204, 0, 204));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo5.setText("Telefono 2");
        jPanel2.add(lblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 70, 20));

        lblTitulo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo9.setText("Nombre");
        jPanel2.add(lblTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, 20));

        lblTitulo10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo10.setText("No obligatorio");
        jPanel2.add(lblTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 170, -1));

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setText("Cedula/RIF");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setText("Telefono");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 20));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Direccion");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 70, 20));

        txtComentario1.setColumns(1);
        txtComentario1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtComentario1.setLineWrap(true);
        txtComentario1.setRows(1);
        txtComentario1.setWrapStyleWord(true);
        txtComentario1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComentario1KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(txtComentario1);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 180, 50));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo14.setText("Comentarios");
        jPanel2.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 80, 20));

        txtDireccion1.setColumns(1);
        txtDireccion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion1.setLineWrap(true);
        txtDireccion1.setRows(1);
        txtDireccion1.setWrapStyleWord(true);
        txtDireccion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccion1KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtDireccion1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, 50));

        txtNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 170, -1));

        txtTelefono12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefono12KeyReleased(evt);
            }
        });
        jPanel2.add(txtTelefono12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 180, -1));

        txtCedula1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula1KeyReleased(evt);
            }
        });
        jPanel2.add(txtCedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, -1));

        txtTelefono11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono11ActionPerformed(evt);
            }
        });
        txtTelefono11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefono11KeyReleased(evt);
            }
        });
        jPanel2.add(txtTelefono11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 100, 30));

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 100, 30));

        btnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar1.setText("Ingresar");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 100, 30));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setText("Pagina Web");
        jPanel2.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 80, 20));

        txtPagina1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPagina1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagina1KeyReleased(evt);
            }
        });
        jPanel2.add(txtPagina1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        lblTitulo19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo19.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo19.setText("Horario");
        jPanel2.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 80, 20));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo21.setText("No obligatorio");
        jPanel2.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, -1));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo25.setText("-");
        jPanel2.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 30, -1));

        cbx3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12am", "1am", "2am", "3am", "4am", "5am", "6am", "7am", "8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "10pm", "11pm" }));
        cbx3.setSelectedIndex(7);
        cbx3.setToolTipText("");
        jPanel2.add(cbx3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 70, -1));

        cbx4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12am", "1am", "2am", "3am", "4am", "5am", "6am", "7am", "8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "10pm", "11pm" }));
        cbx4.setSelectedIndex(12);
        cbx4.setToolTipText("");
        jPanel2.add(cbx4, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 70, -1));

        lblTitulo27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo27.setText("No obligatorio");
        jPanel2.add(lblTitulo27, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 170, -1));

        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 204), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo1.setText("Telefono 2");
        jPanel1.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 70, 20));

        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo2.setText("Nombre");
        jPanel1.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, 20));

        lblTitulo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo6.setText("Telefono");
        jPanel1.add(lblTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 70, 20));

        lblTitulo7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo7.setText("Estado");
        jPanel1.add(lblTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 70, 20));

        txtComentario2.setColumns(1);
        txtComentario2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtComentario2.setLineWrap(true);
        txtComentario2.setRows(1);
        txtComentario2.setWrapStyleWord(true);
        txtComentario2.setEnabled(false);
        txtComentario2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComentario2KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtComentario2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 180, 50));

        lblTitulo8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo8.setText("Comentarios");
        jPanel1.add(lblTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 80, 20));

        txtDireccion2.setColumns(1);
        txtDireccion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDireccion2.setLineWrap(true);
        txtDireccion2.setRows(1);
        txtDireccion2.setWrapStyleWord(true);
        txtDireccion2.setEnabled(false);
        txtDireccion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccion2KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtDireccion2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 170, 50));

        txtNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre2.setEnabled(false);
        txtNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre2KeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txtTelefono22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono22.setEnabled(false);
        txtTelefono22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefono22KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono22KeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono22, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 180, -1));

        txtTelefono21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono21.setEnabled(false);
        txtTelefono21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefono21KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono21KeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));

        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 100, 30));

        btnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497631492_edit.png"))); // NOI18N
        btnEditar2.setText("Editar");
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 100, 30));

        btnBorrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 100, 30));

        txtPagina2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPagina2.setEnabled(false);
        txtPagina2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPagina2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPagina2KeyTyped(evt);
            }
        });
        jPanel1.add(txtPagina2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo16.setText("Pagina Web");
        jPanel1.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 80, 20));

        lblTitulo17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo17.setText("Horario");
        jPanel1.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 80, 20));

        txtCedula2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula2KeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, -1));

        lblTitulo18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo18.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo18.setText("Cedula/RIF");
        jPanel1.add(lblTitulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 70, 20));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 30, 20));

        lblTitulo22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo22.setText("-");
        jPanel1.add(lblTitulo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 30, -1));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo23.setText("No obligatorio");
        jPanel1.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 170, -1));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo24.setText("No obligatorio");
        jPanel1.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 170, -1));

        cbx1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12am", "1am", "2am", "3am", "4am", "5am", "6am", "7am", "8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "10pm", "11pm" }));
        cbx1.setSelectedIndex(7);
        cbx1.setToolTipText("");
        cbx1.setEnabled(false);
        jPanel1.add(cbx1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 70, -1));

        cbx2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "12am", "1am", "2am", "3am", "4am", "5am", "6am", "7am", "8am", "9am", "10am", "11am", "12pm", "1pm", "2pm", "3pm", "4pm", "5pm", "6pm", "7pm", "8pm", "9pm", "10pm", "11pm" }));
        cbx2.setSelectedIndex(12);
        cbx2.setToolTipText("");
        cbx2.setEnabled(false);
        jPanel1.add(cbx2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 70, -1));

        lblTitulo26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo26.setText("No obligatorio");
        jPanel1.add(lblTitulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 170, -1));

        lblTitulo20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo20.setText("Direccion");
        jPanel1.add(lblTitulo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 70, 20));

        cbxEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        cbxEst.setEnabled(false);
        cbxEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstActionPerformed(evt);
            }
        });
        jPanel1.add(cbxEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 110, -1));

        jTabbedPane1.addTab("Modificar", jPanel1);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Proveedores Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 60, 20));

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
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Rif" }));
        cbxFiltro.setSelectedIndex(1);
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 150, 20));

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

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 590, 150));

        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 110, 30));

        lblTitulo28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo28.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo28.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo28.setText("Doble Clic en la tabla para Actualizar");
        jPanel6.add(lblTitulo28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 220, 20));

        jTabbedPane1.addTab("Listado", jPanel6);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 620, 290));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/suniaga.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 84));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
        System.out.println("Coordenadas: (" + ubicacion.x + "," + ubicacion.y + ")");//2
        setLocation(ubicacion.x - x, ubicacion.y - y);//3
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        restaurarVentana();
        setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
        String cedula = txtCedula2.getText();
        if (Verificacion2()) {
            try {
                String sql = "update proveedores set nompro=?, pagpro=?, rifpro=?,"
                        + "telpro=?, tel2pro=?, dirpro=?, despro=?, horpro=?, estpro=? where rifpro = '" + cedula + "'";

                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setString(1, this.txtNombre2.getText().toLowerCase());
                ps.setString(2, this.txtPagina2.getText().toLowerCase());
                ps.setString(3, this.txtCedula2.getText().toLowerCase());
                ps.setString(4, this.txtTelefono21.getText().toLowerCase());
                ps.setString(5, this.txtTelefono22.getText().toLowerCase());
                ps.setString(6, this.txtDireccion2.getText().toLowerCase());
                ps.setString(7, this.txtComentario2.getText().toLowerCase());
                ps.setString(8, cbx1.getSelectedItem().toString() + "-" + cbx2.getSelectedItem().toString());
                ps.setString(9, cbxEst.getSelectedItem().toString());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Informacion",
                             JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Habilitar(3);
                    this.Borrar(3);
                    Pintar(2);
                    acciones.conn.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar datos " + e.getMessage(),
                         "Error", JOptionPane.PLAIN_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png")));
            }
        }
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
        this.dispose();

    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void txtTelefono11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono11ActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        if (Verificacion1()) {
            try {
                String sql = "insert into proveedores(nompro, rifpro, telpro,"
                        + "tel2pro, dirpro, pagpro, despro, horpro, estpro) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = acciones.Ingresar(sql);
                ps.setString(1, txtNombre1.getText().toLowerCase());
                ps.setString(2, txtCedula1.getText().toLowerCase());
                ps.setString(3, txtTelefono11.getText().toLowerCase());
                ps.setString(4, txtTelefono12.getText().toLowerCase());
                ps.setString(5, txtDireccion1.getText().toLowerCase());
                ps.setString(6, txtPagina1.getText().toLowerCase());
                ps.setString(7, txtComentario1.getText().toLowerCase());
                ps.setString(8, cbx1.getSelectedItem().toString() + "-" + cbx2.getSelectedItem().toString());
                ps.setString(9, "Activo");
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Proveedor ingresado con exito",
                             "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Borrar(1);
                    this.Pintar(1);
                    acciones.conn.close();
                }
            } catch (SQLException e) {
                /*
                con esto se el codigo unico del error para poder controlarlo
                System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                "SLQState: " + e.getSQLState() + "\n" +
                "Mensaje: " + e.getMessage() + "\n");
                 */
                // error clave primaria duplicada y muestro mensaje 
                if (e.getSQLState().equals("23505")) {
                    JOptionPane.showMessageDialog(null, "Ya existe un Proveedor vinculado a el numero de cedula ingresado",
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar cliente\nCodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            }
        }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        this.Borrar(1);
        Pintar(1);
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //    selecciono el codigo del cliente para no tener problemas al no copiar la cedula completa
        txtCedula2.setEnabled(false);
        boolean resultado = false;
        this.Borrar(3);
        int codigo = 0;
        String cedula = this.txtCedula2.getText();
         if (Integer.parseInt(txtCedula2.getText())==1) {
                JOptionPane.showMessageDialog(null, "Proveedor No Disponible", "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            this.Habilitar(3);
                resultado = false;
         } else {
        try {
            String sql = "select * from proveedores  where rifpro = '" + cedula + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                resultado = true;
                this.Habilitar(2);
                codigo = rs.getInt("codpro");
                txtNombre2.setText(rs.getString("nompro"));
                txtPagina2.setText(rs.getString("pagpro"));
                this.Desencadenar(rs.getString("horpro"));
                txtCedula2.setText(rs.getString("rifpro"));
                txtTelefono21.setText(rs.getString("telpro"));
                txtTelefono22.setText(rs.getString("tel2pro"));
                txtDireccion2.setText(rs.getString("dirpro"));
                txtComentario2.setText(rs.getString("despro"));
                cbxEst.setSelectedItem(rs.getString("estpro"));
            }
            if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia",
                         JOptionPane.PLAIN_MESSAGE, iconAd);
                this.Habilitar(3);
                resultado = false;
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar cliente\ncodigo error:" + e.getMessage(),
                     "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
        try {
            acciones.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(FProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
        this.Borrar(2);
        txtCedula2.setEnabled(true);
        this.Habilitar(3);
        this.Pintar(2);
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
     int c = evt.getKeyChar();
        int var = cbxFiltro.getSelectedIndex();
        if (var == 1) {
            if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
                switch (var) {
                    case 1:
                        try {
                            String[] titulos = {"Rif", "Nombre", "Telefono", "Telefono",
                                "Direccion", "Pagina Web", "Horario", "Comentario"};
                            String sql = "select * from proveedores where rifpro like '" + txtB.getText() + "%' and not rifpro = '1'";
                            model = new DefaultTableModel(null, titulos);
                            ResultSet rs = acciones.Consultar(sql);
                            String[] fila = new String[8];
                            while (rs.next()) {
                                fila[0] = rs.getString("rifpro");
                                fila[1] = rs.getString("nompro");
                                fila[2] = rs.getString("telpro");
                                fila[3] = rs.getString("tel2pro");
                                fila[4] = rs.getString("dirpro");
                                fila[5] = rs.getString("pagpro");
                                fila[6] = rs.getString("horpro");
                                fila[7] = rs.getString("despro");
                                model.addRow(fila);
                            }
                            tbl.setModel(model);
                            Ajustar1();
                            acciones.conn.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                }
            } else {
                txtB.setText("");
                JOptionPane.showMessageDialog(null, "Ingrese solo numeros o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
            }
        } else {
            if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122 || c==evt.VK_SPACE || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK || c >= 46) {
                switch (var) {
                    case 0:
                        try {
                            String[] titulos = {"Rif", "Nombre", "Telefono", "Telefono",
                                "Direccion", "Pagina Web", "Horario", "Comentario"};
                            String sql = "select * from proveedores where nompro like '"+txtB.getText()+"%'";
                            model = new DefaultTableModel(null, titulos);
                            ResultSet rs = acciones.Consultar(sql);
                            String[] fila = new String[8];
                            while (rs.next()) {
                                fila[0] = rs.getString("rifpro");
                                fila[1] = rs.getString("nompro");
                                fila[2] = rs.getString("telpro");
                                fila[3] = rs.getString("tel2pro");
                                fila[4] = rs.getString("dirpro");
                                fila[5] = rs.getString("pagpro");
                                fila[6] = rs.getString("horpro");
                                fila[7] = rs.getString("despro");
                                model.addRow(fila);
                            }
                            tbl.setModel(model);
                            Ajustar1();
                            acciones.conn.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    default:
                }
            } else {
                txtB.setText("");
                JOptionPane.showMessageDialog(null, "Ingrese solo letras o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
            }
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
    if (evt.getClickCount() == 2) {
        this.LlenarTabla();
        this.txtB.setText("");
    }
    }//GEN-LAST:event_tblMouseClicked

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void btnSalir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir5ActionPerformed
        this.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void txtBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyTyped
   
    }//GEN-LAST:event_txtBKeyTyped

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped

    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre2KeyTyped
        char c = evt.getKeyChar();
        int lim = txtNombre2.getText().length();
        if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122 || c==evt.VK_SPACE || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK || c >= 46) {
            if (this.EventoKeyType(lim, 30)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombre2KeyTyped

    private void txtNombre2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre2KeyReleased
        if (txtNombre2.getText().equals("")) {
            txtNombre2.setBackground(Color.RED);
        } else {
            txtNombre2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtNombre2KeyReleased

    private void txtTelefono21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono21KeyTyped
        char c = evt.getKeyChar();
        int lim = txtTelefono21.getText().length();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefono21KeyTyped

    private void txtTelefono21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono21KeyReleased
        int lim = txtTelefono21.getText().length();
        if (lim <= 10) {
            txtTelefono21.setBackground(Color.RED);
        } else {
            txtTelefono21.setBackground(Color.GREEN);
        }
    }//GEN-LAST:event_txtTelefono21KeyReleased

    private void txtTelefono22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono22KeyReleased
        int lim = txtTelefono22.getText().length();
        if (lim <= 10) {
            txtTelefono22.setBackground(Color.RED);
        } else {
            txtTelefono22.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtTelefono22.setBackground(Color.YELLOW);
        }
    }//GEN-LAST:event_txtTelefono22KeyReleased

    private void txtTelefono22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono22KeyTyped
        char c = evt.getKeyChar();
        int lim = txtTelefono22.getText().length();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtTelefono22KeyTyped

    private void txtDireccion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion2KeyReleased
        if (txtDireccion2.getText().equals("")) {
            txtDireccion2.setBackground(Color.RED);
        } else {
            txtDireccion2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtDireccion2KeyReleased

    private void txtComentario2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentario2KeyReleased
        if (txtComentario2.getText().equals("")) {
            txtComentario2.setBackground(Color.YELLOW);
        } else {
            txtComentario2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtComentario2KeyReleased

    private void txtPagina2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagina2KeyReleased
        if (txtPagina2.getText().equals("")) {
            txtPagina2.setBackground(Color.RED);
        } else {
            txtPagina2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtPagina2KeyReleased

    private void txtPagina2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagina2KeyTyped
        char c = evt.getKeyChar();
        int lim = txtPagina2.getText().length();
        if (this.EventoKeyType(lim, 30)) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtPagina2KeyTyped

    private void txtCedula2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2KeyReleased

    private void txtCedula2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtCedula2.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCedula2KeyTyped

    private void txtCedula1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula1KeyReleased
        int lim = txtCedula1.getText().length();
        if (lim >= 5) {
            txtCedula1.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtCedula1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtCedula1KeyReleased

    private void txtTelefono11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono11KeyReleased
        int lim = txtTelefono11.getText().length();
        if (lim <= 10) {
            txtTelefono11.setBackground(Color.RED);
        } else {
            txtTelefono11.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtTelefono11.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtTelefono11KeyReleased

    private void txtTelefono12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono12KeyReleased
        int lim = txtTelefono12.getText().length();
        if (lim <= 10) {
            txtTelefono12.setBackground(Color.RED);
        } else {
            txtTelefono12.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtTelefono12.setBackground(Color.YELLOW);
        }
    }//GEN-LAST:event_txtTelefono12KeyReleased

    private void txtDireccion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccion1KeyReleased
        if (txtDireccion1.getText().equals("")) {
            txtDireccion1.setBackground(Color.RED);
        } else {
            txtDireccion1.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtDireccion1KeyReleased

    private void txtComentario1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentario1KeyReleased
        if (txtComentario1.getText().equals("")) {
            txtComentario1.setBackground(Color.YELLOW);
        } else {
            txtComentario1.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtComentario1KeyReleased

    private void txtNombre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyReleased
        if (txtNombre1.getText().equals("")) {
            txtNombre1.setBackground(Color.RED);
        } else {
            txtNombre1.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtNombre1KeyReleased

    private void txtPagina1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPagina1KeyReleased
        if (txtPagina1.getText().equals("")) {
            txtPagina1.setBackground(Color.YELLOW);
        } else {
            txtPagina1.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtPagina1KeyReleased

    private void cbxEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstActionPerformed

    private void Pintar(int num) {
        switch (num) {
            case 1:
                txtNombre1.setBackground(Color.WHITE);
                txtCedula1.setBackground(Color.WHITE);
                txtPagina1.setBackground(Color.WHITE);
                txtComentario1.setBackground(Color.WHITE);
                txtTelefono11.setBackground(Color.WHITE);
                txtTelefono12.setBackground(Color.WHITE);
                txtDireccion1.setBackground(Color.WHITE);
                break;
            case 2:
                txtNombre2.setBackground(Color.WHITE);
                txtPagina2.setBackground(Color.WHITE);
                txtComentario2.setBackground(Color.WHITE);
                txtTelefono21.setBackground(Color.WHITE);
                txtTelefono22.setBackground(Color.WHITE);
                txtDireccion2.setBackground(Color.WHITE);
                break;
        }
    }

    private boolean EventoKeyType(int valor, int limitacion) {
        //pido el valor del text y pido el valor limitante
        if (valor >= limitacion) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param args the command line arguments
     */

    public void Desencadenar(String datos) {
        //funcion para separar cedula de la letra
        String hor1 = "", hor2 = "";
        int i = 0, j = 0;
        for (i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == '-') {
                break;
            } else {
                hor1 += datos.charAt(i) + "";
            }
        }
        for (j = i + 1; j < datos.length(); j++) {
            if (datos.charAt(j) == ' ') {
                break;
            } else {
                hor2 += datos.charAt(j) + "";
            }
        }
        cbx2.setSelectedItem(hor2);
        cbx1.setSelectedItem(hor1);
    }

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JComboBox<String> cbx1;
    private javax.swing.JComboBox<String> cbx2;
    private javax.swing.JComboBox<String> cbx3;
    private javax.swing.JComboBox<String> cbx4;
    private javax.swing.JComboBox<String> cbxEst;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo1;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo12;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo14;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo17;
    private javax.swing.JLabel lblTitulo18;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo20;
    private javax.swing.JLabel lblTitulo21;
    private javax.swing.JLabel lblTitulo22;
    private javax.swing.JLabel lblTitulo23;
    private javax.swing.JLabel lblTitulo24;
    private javax.swing.JLabel lblTitulo25;
    private javax.swing.JLabel lblTitulo26;
    private javax.swing.JLabel lblTitulo27;
    private javax.swing.JLabel lblTitulo28;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCedula1;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JTextArea txtComentario1;
    private javax.swing.JTextArea txtComentario2;
    private javax.swing.JTextArea txtDireccion1;
    private javax.swing.JTextArea txtDireccion2;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtPagina1;
    private javax.swing.JTextField txtPagina2;
    private javax.swing.JTextField txtTelefono11;
    private javax.swing.JTextField txtTelefono12;
    private javax.swing.JTextField txtTelefono21;
    private javax.swing.JTextField txtTelefono22;
    // End of variables declaration//GEN-END:variables
private void Ajustar1() {
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(80);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(85);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(85);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(5).setPreferredWidth(150);
        tbl.getColumnModel().getColumn(6).setPreferredWidth(80);
        tbl.getColumnModel().getColumn(7).setPreferredWidth(150);
    }

}
