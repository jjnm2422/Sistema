/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class FClientes extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    DefaultTableModel model;

    public FClientes() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.LlenarTabla();
        this.restringir();
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

    public void restringir() {
        RestrictedTextField r3 = new RestrictedTextField(this.txtCedula1);
        r3.setOnlyNums(true);
        r3.setLimit(9);
        RestrictedTextField r1 = new RestrictedTextField(this.txtNombre1);
        r1.setOnlyText(true);
        r1.setLimit(15);
        RestrictedTextField r5 = new RestrictedTextField(this.txtApellido1);
        r5.setOnlyText(true);
        r5.setLimit(15);
        RestrictedTextField r4 = new RestrictedTextField(this.txtTelefono11);
        r4.setOnlyNums(true);
        r4.setLimit(11);
        RestrictedTextField r = new RestrictedTextField(this.txtTelefono12);
        r.setOnlyNums(true);
        r.setLimit(11);
    }

    private void restaurarVentana() {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {//1
            setExtendedState(JFrame.NORMAL);//2
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }

    public void LlenarTabla() {
        try {
            String[] titulos = {"Codigo", "Nombre", "Apellido", "Cedula",
                "Direccion", "Telefono", "Telefono"};
            String sql = "select * from clientes";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = acciones.Consultar(sql);
            String[] fila = new String[7];
            while (rs.next()) {
                fila[0] = rs.getString("codcli");
                fila[1] = rs.getString("nomcli");
                fila[2] = rs.getString("apecli");
                fila[3] = rs.getString("cedcli");
                fila[4] = rs.getString("dircli");
                fila[5] = rs.getString("telcli");
                fila[6] = rs.getString("tel2cli");
                model.addRow(fila);
            }
            tbl.setModel(model);
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

    private boolean Verificacion1() {
        //verifico que no esten vacios
        if (txtNombre1.getText().equals("") || txtApellido1.getText().equals("")
                || txtCedula1.getText().equals("") || txtCedula1.getText().length()>=5 || txtTelefono11.getText().equals("")
                || txtDireccion1.getText().equals("") || txtTelefono11.getBackground().equals(Color.RED) || txtCedula1.getBackground().equals(Color.RED)
                || txtTelefono12.getBackground().equals(Color.RED)) {
            JOptionPane.showMessageDialog(null, "Verifique:\n"
                    + "1. Que los Campos no esten vacios\n"
                    + "2. Que los numeros telefonicos tenga 11 digitos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        } else {
            return true;
        }
    }

    private boolean Verificacion2() {
        if (txtNombre2.getText().equals("") || txtApellido2.getText().equals("")
                || txtCedula2.getText().equals("") || txtTelefono21.getText().equals("")
                || txtDireccion2.getText().equals("") || txtTelefono21.getBackground().equals(Color.RED) || txtCedula2.getBackground().equals(Color.RED)
                || txtTelefono22.getBackground().equals(Color.RED)) {
            JOptionPane.showMessageDialog(null, "Verifique:\n"
                    + "1. Que los Campos no esten vacios\n"
                    + "2. Que los numeros telefonicos tenga 11 digitos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        } else {
            return true;
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
        txtApellido1 = new javax.swing.JTextField();
        txtTelefono11 = new javax.swing.JTextField();
        btnBorrar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnIngresar1 = new javax.swing.JButton();
        lblTitulo23 = new javax.swing.JLabel();
        lblTitulo24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo1 = new javax.swing.JLabel();
        lblTitulo2 = new javax.swing.JLabel();
        lblTitulo3 = new javax.swing.JLabel();
        lblTitulo4 = new javax.swing.JLabel();
        lblTitulo6 = new javax.swing.JLabel();
        lblTitulo7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtComentario2 = new javax.swing.JTextArea();
        lblTitulo8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDireccion2 = new javax.swing.JTextArea();
        txtNombre2 = new javax.swing.JTextField();
        txtTelefono22 = new javax.swing.JTextField();
        txtCedula2 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        txtTelefono21 = new javax.swing.JTextField();
        btnSalir2 = new javax.swing.JButton();
        btnEliminar2 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnBorrar2 = new javax.swing.JButton();
        btnEditar2 = new javax.swing.JButton();
        lblTitulo25 = new javax.swing.JLabel();
        lblTitulo26 = new javax.swing.JLabel();
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
        lblTitulo27 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");
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

        jLabel1.setBackground(new java.awt.Color(255, 255, 0));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo5.setText("Telefono 2");
        jPanel2.add(lblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 20));

        lblTitulo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo9.setText("Nombre");
        jPanel2.add(lblTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 20));

        lblTitulo10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo10.setText("Apellido");
        jPanel2.add(lblTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 70, 20));

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setText("Cedula");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setText("Telefono");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Direccion");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

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

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 180, 50));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setText("Comentarios");
        jPanel2.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 80, 20));

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

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 180, 60));

        txtNombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombre1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre1KeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, -1));

        txtTelefono12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono12ActionPerformed(evt);
            }
        });
        txtTelefono12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefono12KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono12KeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 180, -1));

        txtCedula1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedula1ActionPerformed(evt);
            }
        });
        txtCedula1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula1KeyTyped(evt);
            }
        });
        jPanel2.add(txtCedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, -1));

        txtApellido1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellido1KeyReleased(evt);
            }
        });
        jPanel2.add(txtApellido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 180, -1));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono11KeyTyped(evt);
            }
        });
        jPanel2.add(txtTelefono11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 180, -1));

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 100, 30));

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 100, 30));

        btnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar1.setText("Ingresar");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo23.setText("No obligatorio");
        jPanel2.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 170, -1));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo24.setText("No obligatorio");
        jPanel2.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 170, -1));

        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo1.setText("Telefono 2");
        jPanel1.add(lblTitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 20));

        lblTitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo2.setText("Nombre");
        jPanel1.add(lblTitulo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 20));

        lblTitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo3.setText("Apellido");
        jPanel1.add(lblTitulo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 70, 20));

        lblTitulo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo4.setText("Cedula");
        jPanel1.add(lblTitulo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTitulo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo6.setText("Telefono");
        jPanel1.add(lblTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        lblTitulo7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo7.setText("Direccion");
        jPanel1.add(lblTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 70, 20));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 180, 50));

        lblTitulo8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo8.setText("Comentarios");
        jPanel1.add(lblTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 80, 20));

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

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 180, 60));

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
        jPanel1.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, -1));

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
        jPanel1.add(txtTelefono22, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 180, -1));

        txtCedula2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedula2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula2KeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, -1));

        txtApellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApellido2.setEnabled(false);
        txtApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtApellido2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido2KeyTyped(evt);
            }
        });
        jPanel1.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 180, -1));

        txtTelefono21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTelefono21.setEnabled(false);
        txtTelefono21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefono21ActionPerformed(evt);
            }
        });
        txtTelefono21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefono21KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefono21KeyTyped(evt);
            }
        });
        jPanel1.add(txtTelefono21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 180, -1));

        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 100, 30));

        btnEliminar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497313212_trash.png"))); // NOI18N
        btnEliminar2.setText("Eliminar");
        btnEliminar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 100, 30));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnBuscarKeyTyped(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 30, 20));

        btnBorrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 30));

        btnEditar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497631492_edit.png"))); // NOI18N
        btnEditar2.setText("Editar");
        btnEditar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 100, 30));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo25.setText("No obligatorio");
        jPanel1.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 170, -1));

        lblTitulo26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo26.setText("No obligatorio");
        jPanel1.add(lblTitulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 170, -1));

        jTabbedPane1.addTab("Modificar", jPanel1);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Clientes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
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

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Cedula", "Codigo" }));
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

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 530, 130));

        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 110, 30));

        lblTitulo27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo27.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo27.setText("Doble Clic en la tabla para Actualizar");
        jPanel6.add(lblTitulo27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 220, 20));

        jTabbedPane1.addTab("Listado", jPanel6);

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

    private void btnEliminar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar2ActionPerformed
        if (txtCedula2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Cedula Vacio",
                        "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
        } else {
        
        int seleccion = JOptionPane.showOptionDialog(
   null,
   "¿Esta seguro que dese Borrar los datos del cliente "+txtNombre2.getText()+" "+txtApellido2.getText() +"?", 
   "Advertencia",
   JOptionPane.YES_NO_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,    // null para icono por defecto.
   new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
   "No");
    if (seleccion == 0) {
        try {
            String sql = "delete from clientes where cedcli='" + txtCedula2.getText() + "'";
            Statement st = acciones.Eliminar(sql);
            int n = st.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente del sistema", "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                this.Borrar(2);
                this.Habilitar(3);
            }
            acciones.conn.close();
        }catch (SQLException e) {
                // error clave dependiente y muestro mensaje 
                if (e.getSQLState().equals("23503")) {
                    JOptionPane.showMessageDialog(null, "El cliente esta relacionado a una venta por tanto no puede ser Eliminado",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar cliente\nCodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            }
    }
    }
    }//GEN-LAST:event_btnEliminar2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//    selecciono el codigo del cliente para no tener problemas al no copiar la cedula completa
        if (txtCedula2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que no este vacio el campo cedula", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
        } else {
            if (Integer.parseInt(txtCedula2.getText())==1) {
                JOptionPane.showMessageDialog(null, "Cliente No Disponible", "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            } else {
            this.txtCedula2.setEnabled(false);
            boolean resultado = false;
            this.Borrar(3);
            int codigo = 0;
            String cedula = this.txtCedula2.getText();
            try {
                String sql = "select * from clientes where cedcli = '" + cedula + "'";
                ResultSet rs = acciones.Consultar(sql);
                while (rs.next()) {
                    resultado = true;
                    this.Habilitar(2);
                    codigo = rs.getInt("codcli");
                    txtNombre2.setText(rs.getString("nomcli"));
                    txtApellido2.setText(rs.getString("apecli"));
                    txtCedula2.setText(rs.getString("cedcli"));
                    txtTelefono21.setText(rs.getString("telcli"));
                    txtTelefono22.setText(rs.getString("tel2cli"));
                    txtDireccion2.setText(rs.getString("dircli"));
                    txtComentario2.setText(rs.getString("comcli"));
                }
                if (resultado == false) {
                    JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia",
                            JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.Habilitar(3);
                    resultado = false;
                }
                acciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al consultar cliente\ncodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void txtTelefono11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono11ActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        if (Verificacion1()) {
            try {
                String sql = "insert into clientes(nomcli, apecli, cedcli, telcli,"
                        + "tel2cli, dircli, comcli) values(?,?,?,?,?,?,?)";
                PreparedStatement ps = acciones.Ingresar(sql);
                ps.setString(1, txtNombre1.getText().toLowerCase());
                ps.setString(2, txtApellido1.getText().toLowerCase());
                ps.setString(3, txtCedula1.getText().toLowerCase());
                ps.setString(4, txtTelefono11.getText().toLowerCase());
                ps.setString(5, txtTelefono12.getText().toLowerCase());
                ps.setString(6, txtDireccion1.getText().toLowerCase());
                ps.setString(7, txtComentario1.getText().toLowerCase());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Cliente ingresado con exito",
                            "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Borrar(1);
                    this.Pintar(1);
                }
                
                //Cambie Exception por SQLException para poder controlar el error
            } catch (SQLException e) {
                /*
                con esto se el codigo unico del error para poder controlarlo
                System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                "SLQState: " + e.getSQLState() + "\n" +
                "Mensaje: " + e.getMessage() + "\n");
                */
                // error clave primaria duplicada y muestro mensaje 
                if (e.getSQLState().equals("23505")) {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente vinculado a el numero de cedula ingresado",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar cliente\nCodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            }
        }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void txtTelefono12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono12ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed

        this.Borrar(1);
        this.Pintar(1);
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
        this.Borrar(2);
        this.Habilitar(3);
        this.Pintar(2);
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void btnEditar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar2ActionPerformed
        String cedula = txtCedula2.getText();
        if (Verificacion2()) {
            try {
                String sql = "update clientes set nomcli=?, apecli=?, cedcli=?,"
                        + "telcli=?, tel2cli=?, dircli=?, comcli=? where cedcli = '" + cedula + "'";

                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setString(1, this.txtNombre2.getText().toLowerCase());
                ps.setString(2, this.txtApellido2.getText().toLowerCase());
                ps.setString(3, this.txtCedula2.getText().toLowerCase());
                ps.setString(4, this.txtTelefono21.getText().toLowerCase());
                ps.setString(5, this.txtTelefono22.getText().toLowerCase());
                ps.setString(6, this.txtDireccion2.getText().toLowerCase());
                ps.setString(7, this.txtComentario2.getText().toLowerCase());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Informacion",
                            JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Habilitar(3);
                    txtCedula2.setText("");
                    this.Borrar(3);
                    this.Pintar(2);
                }
                acciones.conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar datos " + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png")));
            }
        }
    }//GEN-LAST:event_btnEditar2ActionPerformed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
int c = evt.getKeyChar();
        int var = cbxFiltro.getSelectedIndex();
        if (var>=1) {
          if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
              if (!txtB.getText().equals("")) {
                switch (var) {
                case 1:
                    try {
                        String[] titulos = {"Codigo", "Nombre", "Apellido", "Cedula",
                            "Direccion", "Telefono", "Telefono"};
                        String sql = "select * from clientes where cedcli like '" + txtB.getText() + "%'";
                        model = new DefaultTableModel(null, titulos);
                        ResultSet rs = acciones.Consultar(sql);
                        String[] fila = new String[7];
                        while (rs.next()) {
                            fila[0] = rs.getString("codcli");
                            fila[1] = rs.getString("nomcli");
                            fila[2] = rs.getString("apecli");
                            fila[3] = rs.getString("cedcli");
                            fila[4] = rs.getString("dircli");
                            fila[5] = rs.getString("telcli");
                            fila[6] = rs.getString("tel2cli");
                            model.addRow(fila);
                        }
                        tbl.setModel(model);
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        String[] titulos = {"Codigo", "Nombre", "Apellido", "Cedula",
                            "Direccion", "Telefono", "Telefono"};
                        String sql = "select * from clientes where codcli = '" + txtB.getText() + "'";
                        model = new DefaultTableModel(null, titulos);
                        ResultSet rs = acciones.Consultar(sql);
                        String[] fila = new String[7];
                        while (rs.next()) {
                            fila[0] = rs.getString("codcli");
                            fila[1] = rs.getString("nomcli");
                            fila[2] = rs.getString("apecli");
                            fila[3] = rs.getString("cedcli");
                            fila[4] = rs.getString("dircli");
                            fila[5] = rs.getString("telcli");
                            fila[6] = rs.getString("tel2cli");
                            model.addRow(fila);
                            acciones.conn.close();
                        }
                        tbl.setModel(model);
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
            }   
              }else{
                  this.LlenarTabla();
              }
           
        } else {
            txtB.setText("");
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros o seleccione otro filtro", "Advertencia",
                    JOptionPane.PLAIN_MESSAGE, iconAd);
        }  
        }else{
            if (var < 1) {
                if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK) {
                switch (var) {
                    case 0:
                        try {
                            String[] titulos = {"Codigo", "Nombre", "Apellido", "Cedula",
                                "Direccion", "Telefono", "Telefono"};
                            String sql = "select * from clientes where nomcli like '" + txtB.getText() + "%'";
                            model = new DefaultTableModel(null, titulos);
                            ResultSet rs = acciones.Consultar(sql);
                            String[] fila = new String[7];
                            while (rs.next()) {
                                fila[0] = rs.getString("codcli");
                                fila[1] = rs.getString("nomcli");
                                fila[2] = rs.getString("apecli");
                                fila[3] = rs.getString("cedcli");
                                fila[4] = rs.getString("dircli");
                                fila[5] = rs.getString("telcli");
                                fila[6] = rs.getString("tel2cli");
                                model.addRow(fila);
                            }
                            tbl.setModel(model);
                            acciones.conn.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                        break;
                    default:
                }
            }else{
                txtB.setText("");
                JOptionPane.showMessageDialog(null, "Ingrese solo letras o seleccione otro filtro", "Advertencia",
                    JOptionPane.PLAIN_MESSAGE, iconAd);
            }
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
        this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void txtNombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyTyped

    }//GEN-LAST:event_txtNombre1KeyTyped

    private void txtCedula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedula1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula1ActionPerformed

    private void txtCedula1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula1KeyTyped

    }//GEN-LAST:event_txtCedula1KeyTyped

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

    private void txtTelefono21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefono21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefono21ActionPerformed

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

    private void txtNombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre2KeyTyped
        char c = evt.getKeyChar();
        /*verifico que el caracter sea una letra mayuscula o minuscula o sea la tecla de borrar
         si no emito un sonido e ignoro lo que teclee*/
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtNombre2.getText().length();
            //cambie este numero que es el limite
            if (lim >= 15) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNombre2KeyTyped

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped

    }//GEN-LAST:event_btnBuscarKeyTyped

    private void txtCedula2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyPressed

    }//GEN-LAST:event_txtCedula2KeyPressed

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
            if (lim >= 11) {
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

    private void txtNombre2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre2KeyReleased
        if (txtNombre2.getText().equals("")) {
            txtNombre2.setBackground(Color.RED);
        } else {
            txtNombre2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtNombre2KeyReleased

    private void txtApellido2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido2KeyReleased

        if (txtApellido2.getText().equals("")) {
            txtApellido2.setBackground(Color.RED);
        } else {
            txtApellido2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtApellido2KeyReleased

    private void txtComentario2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentario2KeyReleased

        if (txtComentario2.getText().equals("")) {
            txtComentario2.setBackground(Color.YELLOW);
        } else {
            txtComentario2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtComentario2KeyReleased

    private void txtApellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido2KeyTyped
        char c = evt.getKeyChar();
        /*verifico que el caracter sea una letra mayuscula o minuscula o sea la tecla de borrar
         si no emito un sonido e ignoro lo que teclee*/
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtApellido2.getText().length();
            //cambie este numero que es el limite
            if (lim >= 15) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtApellido2KeyTyped

    private void txtTelefono11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono11KeyTyped

    }//GEN-LAST:event_txtTelefono11KeyTyped

    private void txtTelefono12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefono12KeyTyped

    }//GEN-LAST:event_txtTelefono12KeyTyped

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

    private void txtNombre1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyReleased
        if (txtNombre1.getText().equals("")) {
            txtNombre1.setBackground(Color.RED);
        } else {
            txtNombre1.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtNombre1KeyReleased

    private void txtApellido1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellido1KeyReleased
        if (txtApellido1.getText().equals("")) {
            txtApellido1.setBackground(Color.RED);
        } else {
            txtApellido1.setBackground(Color.green);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido1KeyReleased

    private void txtCedula1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula1KeyReleased
        int lim = txtCedula1.getText().length();
        if (lim >= 5) {
            txtCedula1.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtCedula1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtCedula1KeyReleased

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

    private void txtBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyTyped
        
    }//GEN-LAST:event_txtBKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar2;
    private javax.swing.JButton btnEliminar2;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JLabel lblTitulo23;
    private javax.swing.JLabel lblTitulo24;
    private javax.swing.JLabel lblTitulo25;
    private javax.swing.JLabel lblTitulo26;
    private javax.swing.JLabel lblTitulo27;
    private javax.swing.JLabel lblTitulo3;
    private javax.swing.JLabel lblTitulo4;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCedula1;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JTextArea txtComentario1;
    private javax.swing.JTextArea txtComentario2;
    private javax.swing.JTextArea txtDireccion1;
    private javax.swing.JTextArea txtDireccion2;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JTextField txtTelefono11;
    private javax.swing.JTextField txtTelefono12;
    private javax.swing.JTextField txtTelefono21;
    private javax.swing.JTextField txtTelefono22;
    // End of variables declaration//GEN-END:variables

    private void Borrar(int x) {
        switch (x) {
            case 1:
                txtNombre1.setText("");
                txtApellido1.setText("");
                txtComentario1.setText("");
                txtCedula1.setText("");
                txtTelefono11.setText("");
                txtTelefono12.setText("");
                txtDireccion1.setText("");
                break;
            case 2:
                txtNombre2.setText("");
                txtApellido2.setText("");
                txtComentario2.setText("");
                txtCedula2.setText("");
                txtTelefono21.setText("");
                txtTelefono22.setText("");
                txtDireccion2.setText("");
                break;
            case 3:
                txtNombre2.setText("");
                txtApellido2.setText("");
                txtComentario2.setText("");
                txtTelefono21.setText("");
                txtTelefono22.setText("");
                txtDireccion2.setText("");
                break;
            default:
        }
    }

    private void Habilitar(int x) {
        switch (x) {
            case 2:
                txtNombre2.setEnabled(true);
                txtApellido2.setEnabled(true);
                txtComentario2.setEnabled(true);
                txtTelefono22.setEnabled(true);
                txtTelefono21.setEnabled(true);
                txtDireccion2.setEnabled(true);
                this.txtCedula2.setEnabled(false);
                break;
            case 3:
                txtNombre2.setEnabled(false);
                txtApellido2.setEnabled(false);
                txtComentario2.setEnabled(false);
                txtTelefono21.setEnabled(false);
                txtTelefono22.setEnabled(false);
                txtDireccion2.setEnabled(false);
                txtCedula2.setEnabled(true);
                break;
            default:
        }
    }

    private void Pintar(int num) {
        switch (num) {
            case 1:
                txtNombre1.setBackground(Color.WHITE);
                txtCedula1.setBackground(Color.WHITE);
                txtApellido1.setBackground(Color.WHITE);
                txtComentario1.setBackground(Color.WHITE);
                txtTelefono11.setBackground(Color.WHITE);
                txtTelefono12.setBackground(Color.WHITE);
                txtDireccion1.setBackground(Color.WHITE);
                break;
            case 2:
                txtNombre2.setBackground(Color.WHITE);
                txtApellido2.setBackground(Color.WHITE);
                txtComentario2.setBackground(Color.WHITE);
                txtTelefono21.setBackground(Color.WHITE);
                txtTelefono22.setBackground(Color.WHITE);
                txtDireccion2.setBackground(Color.WHITE);
                break;
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
}
