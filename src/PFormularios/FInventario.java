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
public class FInventario extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    public DefaultTableModel model;
    private int iva = 0;

    public FInventario() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.restringir();
        this.Llenar();
        this.getProveedores();
        getTipoProducto();
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
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtMinimo1);
        restricted3.setOnlyNums(true);
        RestrictedTextField restricted4 = new RestrictedTextField(this.txtPrecio1,"0123456789.");
        RestrictedTextField restricted = new RestrictedTextField(this.txtCantidad1);
        restricted.setOnlyNums(true);
    }

    public void getProveedores() {
        try {
            String sql = "select * from proveedores";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                cbxProveedor1.addItem(rs.getString("nompro"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
    }
    
    public int getCodProveedores(String nombre) {
        int cod = 0;
        try {
            String sql = "select * from proveedores where nompro = '"+nombre+"'";
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

    public void getTipoProducto() {
        try {
            String sql = "select * from tipoproducto";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                cbxTipo1.addItem(rs.getString("tipprod"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
    }
    
       public int getCodTipoProducto(String nombre) {
        int cod =0;
        try {
            String sql = "select * from tipoproducto where tipprod = '"+nombre+"'";
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

    private void Llenar() {
        try {
            String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                "Precio"};
            String sql = "select * from inventario inner join tipoproducto"
                    + " on tipoproducto.codtip = inventario.tippro";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = acciones.Consultar(sql);
            String[] fila = new String[5];
            while (rs.next()) {
                fila[0] = rs.getString("codprod");
                fila[1] = rs.getString("tipprod");
                fila[2] = rs.getString("desprod");
                fila[3] = rs.getString("canprod");
                fila[4] = rs.getString("preprod");
                model.addRow(fila);
            }
            tbl.setModel(model);
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
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
        lblTitulo5 = new javax.swing.JLabel();
        lblTitulo10 = new javax.swing.JLabel();
        lblTitulo11 = new javax.swing.JLabel();
        lblTitulo12 = new javax.swing.JLabel();
        lblTitulo13 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtDescripcion1 = new javax.swing.JTextArea();
        txtCantidad1 = new javax.swing.JTextField();
        txtMaximo1 = new javax.swing.JTextField();
        txtMinimo1 = new javax.swing.JTextField();
        txtTotal1 = new javax.swing.JTextField();
        btnBorrar1 = new javax.swing.JButton();
        btnSalir1 = new javax.swing.JButton();
        btnIngresar1 = new javax.swing.JButton();
        lblTitulo15 = new javax.swing.JLabel();
        cbxProveedor1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        lblTitulo16 = new javax.swing.JLabel();
        cbxTipo1 = new javax.swing.JComboBox<>();
        lblTitulo14 = new javax.swing.JLabel();
        txtPrecio1 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo6 = new javax.swing.JLabel();
        lblTitulo17 = new javax.swing.JLabel();
        lblTitulo19 = new javax.swing.JLabel();
        lblTitulo20 = new javax.swing.JLabel();
        lblTitulo21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcion2 = new javax.swing.JTextArea();
        txtCantidad2 = new javax.swing.JTextField();
        txtMaximo2 = new javax.swing.JTextField();
        txtMinimo2 = new javax.swing.JTextField();
        txtTotal2 = new javax.swing.JTextField();
        btnBorrar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        btnIngresar2 = new javax.swing.JButton();
        lblTitulo22 = new javax.swing.JLabel();
        cbxProveedor2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        lblTitulo23 = new javax.swing.JLabel();
        cbxTipo2 = new javax.swing.JComboBox<>();
        lblTitulo24 = new javax.swing.JLabel();
        txtPrecio2 = new javax.swing.JTextField();
        lblTitulo25 = new javax.swing.JLabel();
        txtConsultar2 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btnSalir4 = new javax.swing.JButton();
        btnSalir5 = new javax.swing.JButton();

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

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 30));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo5.setText("Cantidad que Ingresa");
        jPanel2.add(lblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 140, 20));

        lblTitulo10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo10.setText("Maximo Inventario");
        jPanel2.add(lblTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 20));

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setText("Minimo Inventario");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo12.setText("Precio + IVA");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 20));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Descripcion");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 20));

        txtDescripcion1.setColumns(1);
        txtDescripcion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescripcion1.setLineWrap(true);
        txtDescripcion1.setRows(1);
        txtDescripcion1.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtDescripcion1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 440, 40));

        txtCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidad1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidad1KeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 130, -1));

        txtMaximo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaximo1.setToolTipText("Cantidad máxima de mercancía que se puede almacenar");
        txtMaximo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaximo1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaximo1KeyTyped(evt);
            }
        });
        jPanel2.add(txtMaximo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));

        txtMinimo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMinimo1.setToolTipText("Cantidad minima que se dispone para atender a la demanda");
        txtMinimo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimo1ActionPerformed(evt);
            }
        });
        txtMinimo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinimo1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinimo1KeyTyped(evt);
            }
        });
        jPanel2.add(txtMinimo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, -1));

        txtTotal1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal1.setEnabled(false);
        txtTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotal1ActionPerformed(evt);
            }
        });
        txtTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotal1KeyReleased(evt);
            }
        });
        jPanel2.add(txtTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 130, -1));

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 100, 30));

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 100, 30));

        btnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar1.setText("Ingresar");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 100, 30));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setText("Tipo Producto");
        jPanel2.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 20));

        cbxProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedor1ActionPerformed(evt);
            }
        });
        jPanel2.add(cbxProveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 160, -1));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, -1));

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo16.setText("Proveedor");
        jPanel2.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 90, 20));

        jPanel2.add(cbxTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 150, -1));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo14.setText("Precio");
        jPanel2.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 130, 20));

        txtPrecio1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio1ActionPerformed(evt);
            }
        });
        txtPrecio1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecio1KeyReleased(evt);
            }
        });
        jPanel2.add(txtPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 130, -1));

        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo6.setText("Cantidad que Ingresa");
        jPanel4.add(lblTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 140, 20));

        lblTitulo17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo17.setText("Maximo Inventario");
        jPanel4.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 20));

        lblTitulo19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo19.setText("Minimo Inventario");
        jPanel4.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 20));

        lblTitulo20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo20.setText("Precio + IVA");
        jPanel4.add(lblTitulo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 130, 20));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo21.setText("Descripcion");
        jPanel4.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 80, 20));

        txtDescripcion2.setColumns(1);
        txtDescripcion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescripcion2.setLineWrap(true);
        txtDescripcion2.setRows(1);
        txtDescripcion2.setWrapStyleWord(true);
        txtDescripcion2.setEnabled(false);
        jScrollPane5.setViewportView(txtDescripcion2);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 440, 40));

        txtCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad2.setEnabled(false);
        jPanel4.add(txtCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 130, -1));

        txtMaximo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaximo2.setEnabled(false);
        jPanel4.add(txtMaximo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 100, -1));

        txtMinimo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMinimo2.setEnabled(false);
        txtMinimo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimo2ActionPerformed(evt);
            }
        });
        jPanel4.add(txtMinimo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 100, -1));

        txtTotal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal2.setEnabled(false);
        txtTotal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotal2ActionPerformed(evt);
            }
        });
        jPanel4.add(txtTotal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 130, -1));

        btnBorrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 100, 30));

        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 100, 30));

        btnIngresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar2.setText("Ingresar");
        btnIngresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnIngresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 100, 30));

        lblTitulo22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo22.setText("Consultar");
        jPanel4.add(lblTitulo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        cbxProveedor2.setEnabled(false);
        cbxProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedor2ActionPerformed(evt);
            }
        });
        jPanel4.add(cbxProveedor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 100, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, -1));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo23.setText("Proveedor");
        jPanel4.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 100, 20));

        cbxTipo2.setEnabled(false);
        jPanel4.add(cbxTipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 140, -1));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo24.setText("Precio");
        jPanel4.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 130, 20));

        txtPrecio2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecio2.setEnabled(false);
        txtPrecio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio2ActionPerformed(evt);
            }
        });
        jPanel4.add(txtPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 130, -1));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo25.setText("Tipo Producto");
        jPanel4.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, 20));

        txtConsultar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(txtConsultar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 30, 20));

        jTabbedPane1.addTab("Modificar", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
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
        });
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Tipo", "Descripcion" }));
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
        jScrollPane6.setViewportView(tbl);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 530, 100));

        btnSalir4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497913416_gtk-refresh.png"))); // NOI18N
        btnSalir4.setText("Actualizar");
        btnSalir4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir4ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 110, 30));

        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 110, 30));

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

    private void txtTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1ActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        if (Verificacion1()) {
        try {
	String sql = "insert into inventario(tippro, desprod, canprod,"
                + "preprod, minprod, maxprod, codpro) values(?,?,?,?,?,?,?)";
	PreparedStatement ps = acciones.Ingresar(sql);
        float total = Float.parseFloat(txtPrecio1.getText())+(Float.parseFloat(txtPrecio1.getText()) * getIva());
	ps.setInt(1,getCodTipoProducto(cbxTipo1.getSelectedItem().toString()));
	ps.setString(2, txtDescripcion1.getText().toLowerCase());
	ps.setInt(3, Integer.parseInt(txtCantidad1.getText()));
	ps.setFloat(4, total);
	ps.setInt(5, Integer.parseInt(txtMinimo1.getText()));
	ps.setInt(6, Integer.parseInt(txtMaximo1.getText()));
	ps.setInt(7, getCodProveedores(cbxProveedor1.getSelectedItem().toString()));
	int n = ps.executeUpdate();
		if (n > 0) {
			JOptionPane.showMessageDialog(null, "Producto ingresado con exito al inventario"
                        ,"Informacion",JOptionPane.PLAIN_MESSAGE,iconCorrecto);
                        this.Borrar(1);
                        this.Llenar();
		}
	} catch (Exception e) {
	JOptionPane.showMessageDialog(null,"Error al guardar producto\ncodigo error:"+e.getMessage()
        ,"Error",JOptionPane.PLAIN_MESSAGE,iconError);
}
}
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        Borrar(1);        // this.Borrar(1);
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void cbxProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedor1ActionPerformed

    private void txtPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio1ActionPerformed

    private void txtMinimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimo1ActionPerformed

    private void txtMinimo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimo2ActionPerformed

    private void txtTotal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal2ActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnIngresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIngresar2ActionPerformed

    private void cbxProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedor2ActionPerformed

    private void txtPrecio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //    selecciono el codigo del cliente para no tener problemas al no copiar la cedula completa
        boolean resultado = false;
//        this.Borrar(3);
        int codigo = 0;
        cbxTipo2.removeAllItems();
        String cedula = this.txtConsultar2.getText();
        try {
            String sql = "select * from inventario inner join tipoproducto on tippro = codtip where codprod = '" + cedula + "'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                resultado = true;
                cbxTipo2.addItem(rs.getString("tipprod"));
                cbxProveedor2.addItem(rs.getString("codpro"));
//                this.Habilitar(2);
//                codigo = rs.getInt("codcli");
//                txtNombre2.setText(rs.getString("nomcli"));
//                txtApellido2.setText(rs.getString("apecli"));
//                txtConsultar2.setText(rs.getString("cedcli"));
//                txtTelefono21.setText(rs.getString("telcli"));
//                txtTelefono22.setText(rs.getString("tel2cli"));
//                txtDireccion2.setText(rs.getString("dircli"));
//                txtComentario2.setText(rs.getString("comcli"));
            }
            if (resultado == false) {
                JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
//                this.Habilitar(3);
                resultado = false;
            }
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar cliente\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
        if (!txtB.getText().equals("")) {
            int var = cbxFiltro.getSelectedIndex();
            switch (var) {
                case 0:
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                                + " on tipoproducto.codtip = inventario.tippro "
                                + "where codprod = '" + txtB.getText() + "'";
                        model = new DefaultTableModel(null, titulos);
                        ResultSet rs = acciones.Consultar(sql);
                        String[] fila = new String[5];
                        while (rs.next()) {
                            fila[0] = rs.getString("codprod");
                            fila[1] = rs.getString("tipprod");
                            fila[2] = rs.getString("desprod");
                            fila[3] = rs.getString("canprod");
                            fila[4] = rs.getString("preprod");
                            model.addRow(fila);
                        }
                        tbl.setModel(model);
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                                "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                    break;
                case 1:
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                                + " on tipoproducto.codtip = inventario.tippro "
                                + "where tipprod like '" + txtB.getText() + "%'";
                        model = new DefaultTableModel(null, titulos);
                        ResultSet rs = acciones.Consultar(sql);
                        String[] fila = new String[5];
                        while (rs.next()) {
                            fila[0] = rs.getString("codprod");
                            fila[1] = rs.getString("tipprod");
                            fila[2] = rs.getString("desprod");
                            fila[3] = rs.getString("canprod");
                            fila[4] = rs.getString("preprod");
                            model.addRow(fila);
                        }
                        tbl.setModel(model);
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                                "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                    break;
                case 2:
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                                + " on tipoproducto.codtip = inventario.tippro "
                                + "where desprod like '" + txtB.getText() + "%'";
                        model = new DefaultTableModel(null, titulos);
                        ResultSet rs = acciones.Consultar(sql);
                        String[] fila = new String[5];
                        while (rs.next()) {
                            fila[0] = rs.getString("codprod");
                            fila[1] = rs.getString("tipprod");
                            fila[2] = rs.getString("desprod");
                            fila[3] = rs.getString("canprod");
                            fila[4] = rs.getString("preprod");
                            model.addRow(fila);
                        }
                        tbl.setModel(model);
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                                "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                    break;
                default:

            }
        } else {
            this.Llenar();
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked

    }//GEN-LAST:event_tblMouseClicked

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void btnSalir4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir4ActionPerformed
        this.Llenar();
        this.txtB.setText("");
    }//GEN-LAST:event_btnSalir4ActionPerformed

    private void btnSalir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir5ActionPerformed
        this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void txtPrecio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio1KeyReleased
        if (!txtPrecio1.getText().equals("")) {
        float total = Float.parseFloat(txtPrecio1.getText())+(Float.parseFloat(txtPrecio1.getText()) * (getIva()/100));
        txtTotal1.setText(String.valueOf(total));           
        } else {
        txtTotal1.setText("0");
        }

    }//GEN-LAST:event_txtPrecio1KeyReleased

    private void txtTotal1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyReleased
    
    }//GEN-LAST:event_txtTotal1KeyReleased

    private void txtMaximo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo1KeyReleased
      int lim = txtMaximo1.getText().length();
        if (lim >= 1&& Integer.parseInt(txtCantidad1.getText())>0) {
            txtMaximo1.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtMaximo1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtMaximo1KeyReleased

    private void txtMaximo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo1KeyTyped
    char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtMaximo1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaximo1KeyTyped

    private void txtMinimo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo1KeyReleased
     int lim = txtMinimo1.getText().length();
        if (!txtCantidad1.getText().equals("")) {
            if (lim >= 1 && Integer.parseInt(txtCantidad1.getText())>0) {
            txtMinimo1.setBackground(Color.GREEN);
        }
        }
        if (lim == 0) {
            txtMinimo1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtMinimo1KeyReleased

    private void txtMinimo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo1KeyTyped
    char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtMinimo1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMinimo1KeyTyped

    private void txtCantidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad1KeyTyped
     char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtCantidad1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidad1KeyTyped

    private void txtCantidad1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad1KeyReleased
      int lim = txtCantidad1.getText().length();
        if (lim >= 1 && Integer.parseInt(txtCantidad1.getText())>0) {
            txtCantidad1.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtCantidad1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtCantidad1KeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JButton btnIngresar2;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir4;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxProveedor1;
    private javax.swing.JComboBox<String> cbxProveedor2;
    private javax.swing.JComboBox<String> cbxTipo1;
    private javax.swing.JComboBox<String> cbxTipo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo12;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo14;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo17;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo20;
    private javax.swing.JLabel lblTitulo21;
    private javax.swing.JLabel lblTitulo22;
    private javax.swing.JLabel lblTitulo23;
    private javax.swing.JLabel lblTitulo24;
    private javax.swing.JLabel lblTitulo25;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCantidad1;
    private javax.swing.JTextField txtCantidad2;
    private javax.swing.JTextField txtConsultar2;
    private javax.swing.JTextArea txtDescripcion1;
    private javax.swing.JTextArea txtDescripcion2;
    private javax.swing.JTextField txtMaximo1;
    private javax.swing.JTextField txtMaximo2;
    private javax.swing.JTextField txtMinimo1;
    private javax.swing.JTextField txtMinimo2;
    private javax.swing.JTextField txtPrecio1;
    private javax.swing.JTextField txtPrecio2;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtTotal2;
    // End of variables declaration//GEN-END:variables

    private boolean Verificacion1() {
        if (!txtDescripcion1.getText().equals("") && !txtMinimo1.getText().equals("")
                && !txtMaximo1.getText().equals("") && !txtCantidad1.getText().equals("") && !txtPrecio1.getText().equals("")
                && !txtTotal1.getText().equals("")) {
            if (Integer.parseInt(txtCantidad1.getText())<Integer.parseInt(txtMaximo1.getText())) {
                if (Integer.parseInt(txtMinimo1.getText())<Integer.parseInt(txtMaximo1.getText())){
                    if (txtPrecio1.getText().charAt(txtPrecio1.getText().length()-1)=='.') {
                        JOptionPane.showMessageDialog(null, "Corrija el precio", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El minimo de inventario debe ser menor al maximo de inventario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    return false;
                }
            }else{
               JOptionPane.showMessageDialog(null, "La cantidad que ingresa no puede ser mayor que el maximo del inventario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
               return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        }
    }

    private void Borrar(int i) {
        switch (i) {
            case 1:
                txtDescripcion1.setText("");
                txtMaximo1.setText("");
                txtMinimo1.setText("");
                txtCantidad1.setText("");
                txtPrecio1.setText("");
                txtTotal1.setText("");
                break;
            default:
                throw new AssertionError();
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
