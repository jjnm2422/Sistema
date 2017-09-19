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
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
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
public class FInventario extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private PClases.CFecha cFecha = new PClases.CFecha();
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    public DefaultTableModel model;
    private int iva = 0;
    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    private DecimalFormat format = new DecimalFormat("#0.00",simbolos);
    private DefaultTableModel model2;

    public FInventario() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.restringir();
        this.Llenar();
        this.Llenar2();
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
        RestrictedTextField restricted4 = new RestrictedTextField(this.txtPrecio1, "0123456789.");
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

    public void getTipoProducto() {
        try {
            String sql = "select * from tipoproducto where not codtip = 1";
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
                fila[4] = format.format(rs.getFloat("preprod"));
                model.addRow(fila);
            }
            tbl.setModel(model);
            Ajustar();
            acciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
        }
    }

    private void Llenar2() {
        try {
            String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible"};
            String sql = "select * from inventario inner join tipoproducto"
                    + " on tipoproducto.codtip = inventario.tippro";
            model2 = new DefaultTableModel(null, titulos);
            ResultSet rs = acciones.Consultar(sql);
            String[] fila = new String[6];
            while (rs.next()) {
                fila[0] = rs.getString("codprod");
                fila[1] = rs.getString("tipprod");
                fila[2] = rs.getString("desprod");
                fila[3] = rs.getString("canprod");
                fila[4] = rs.getString("minprod");
                fila[5] = rs.getString("maxprod");
                model2.addRow(fila);
            }
            tbl1.setModel(model2);
            Ajustar1();
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
        btnBorrar2 = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();
        btnIngresar2 = new javax.swing.JButton();
        lblTitulo22 = new javax.swing.JLabel();
        cbxProveedor2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        lblTitulo23 = new javax.swing.JLabel();
        cbxTipo2 = new javax.swing.JComboBox<>();
        lblTitulo24 = new javax.swing.JLabel();
        lblTitulo25 = new javax.swing.JLabel();
        txtConsultar2 = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtPrecio2 = new javax.swing.JTextField();
        txtCantidad2 = new javax.swing.JTextField();
        txtTotal2 = new javax.swing.JTextField();
        txtMinimo2 = new javax.swing.JTextField();
        txtMaximo2 = new javax.swing.JTextField();
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
        btnSalir5 = new javax.swing.JButton();
        lblTitulo18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lblTitulo7 = new javax.swing.JLabel();
        txtMinimo4 = new javax.swing.JTextField();
        btnBorrar3 = new javax.swing.JButton();
        btnSalir3 = new javax.swing.JButton();
        btnIngresar3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        lblTitulo8 = new javax.swing.JLabel();
        txtCodigo4 = new javax.swing.JTextField();
        lblTitulo9 = new javax.swing.JLabel();
        txtIngreso = new javax.swing.JTextField();
        lblTitulo32 = new javax.swing.JLabel();
        lblTitulo33 = new javax.swing.JLabel();
        txtCantidad4 = new javax.swing.JTextField();
        txtMaximo4 = new javax.swing.JTextField();
        lblTitulo26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txtB1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        cbxFiltro1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 30));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo5.setText("Cantidad que Ingresa");
        jPanel2.add(lblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, 20));

        lblTitulo10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo10.setText("Maximo Inventario");
        jPanel2.add(lblTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 120, 20));

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setText("Minimo Inventario");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 120, 20));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo12.setText("Precio + IVA");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 130, 20));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Descripcion");
        jPanel2.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 20));

        txtDescripcion1.setColumns(1);
        txtDescripcion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescripcion1.setLineWrap(true);
        txtDescripcion1.setRows(1);
        txtDescripcion1.setWrapStyleWord(true);
        txtDescripcion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcion1KeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtDescripcion1);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 510, 60));

        txtCantidad1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidad1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidad1KeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 100, -1));

        txtMaximo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaximo1.setToolTipText("Cantidad máxima de mercancía que se puede almacenar");
        txtMaximo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaximo1ActionPerformed(evt);
            }
        });
        txtMaximo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaximo1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaximo1KeyTyped(evt);
            }
        });
        jPanel2.add(txtMaximo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 100, -1));

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
        jPanel2.add(txtMinimo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 100, -1));

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
        jPanel2.add(txtTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 130, -1));

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBorrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 100, 30));

        btnSalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir1.setText("Salir");
        btnSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 100, 30));

        btnIngresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar1.setText("Ingresar");
        btnIngresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnIngresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, 30));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setText("Tipo Producto");
        jPanel2.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, 20));

        cbxProveedor1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedor1ActionPerformed(evt);
            }
        });
        jPanel2.add(cbxProveedor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 160, -1));

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo16.setText("Proveedor");
        jPanel2.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 90, 20));

        jPanel2.add(cbxTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, -1));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo14.setText("Precio");
        jPanel2.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 130, 20));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio1KeyTyped(evt);
            }
        });
        jPanel2.add(txtPrecio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 130, -1));

        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo6.setText("Cantidad Disponible");
        jPanel4.add(lblTitulo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 140, 20));

        lblTitulo17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo17.setText("Maximo Inventario");
        jPanel4.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, 20));

        lblTitulo19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo19.setText("Minimo Inventario");
        jPanel4.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 120, 20));

        lblTitulo20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo20.setText("Precio + IVA");
        jPanel4.add(lblTitulo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 130, 20));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo21.setText("Descripcion");
        jPanel4.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 20));

        txtDescripcion2.setColumns(1);
        txtDescripcion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescripcion2.setLineWrap(true);
        txtDescripcion2.setRows(1);
        txtDescripcion2.setWrapStyleWord(true);
        txtDescripcion2.setEnabled(false);
        txtDescripcion2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcion2KeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtDescripcion2);

        jPanel4.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 530, 60));

        btnBorrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 100, 30));

        btnSalir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir2.setText("Salir");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 100, 30));

        btnIngresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497631492_edit.png"))); // NOI18N
        btnIngresar2.setText("Editar");
        btnIngresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnIngresar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, 30));

        lblTitulo22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo22.setText("Consultar");
        jPanel4.add(lblTitulo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 20));

        cbxProveedor2.setEditable(true);
        cbxProveedor2.setEnabled(false);
        cbxProveedor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedor2ActionPerformed(evt);
            }
        });
        jPanel4.add(cbxProveedor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 130, -1));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 160, -1));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo23.setText("Proveedor");
        jPanel4.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 100, 20));

        cbxTipo2.setEditable(true);
        cbxTipo2.setEnabled(false);
        jPanel4.add(cbxTipo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 140, -1));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo24.setText("Precio");
        jPanel4.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 130, 20));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo25.setText("Tipo Producto");
        jPanel4.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 90, 20));

        txtConsultar2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtConsultar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtConsultar2KeyTyped(evt);
            }
        });
        jPanel4.add(txtConsultar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 140, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497642935_search_magnifying_glass_find.png"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 30, 20));

        txtPrecio2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecio2.setEnabled(false);
        txtPrecio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecio2ActionPerformed(evt);
            }
        });
        txtPrecio2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecio2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecio2KeyTyped(evt);
            }
        });
        jPanel4.add(txtPrecio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 130, -1));

        txtCantidad2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad2.setEnabled(false);
        txtCantidad2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidad2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidad2KeyTyped(evt);
            }
        });
        jPanel4.add(txtCantidad2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 130, -1));

        txtTotal2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotal2.setEnabled(false);
        txtTotal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotal2ActionPerformed(evt);
            }
        });
        txtTotal2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTotal2KeyReleased(evt);
            }
        });
        jPanel4.add(txtTotal2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, 130, -1));

        txtMinimo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMinimo2.setToolTipText("Cantidad minima que se dispone para atender a la demanda");
        txtMinimo2.setEnabled(false);
        txtMinimo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinimo2ActionPerformed(evt);
            }
        });
        txtMinimo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinimo2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinimo2KeyTyped(evt);
            }
        });
        jPanel4.add(txtMinimo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 100, -1));

        txtMaximo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaximo2.setToolTipText("Cantidad máxima de mercancía que se puede almacenar");
        txtMaximo2.setEnabled(false);
        txtMaximo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaximo2ActionPerformed(evt);
            }
        });
        txtMaximo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaximo2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaximo2KeyTyped(evt);
            }
        });
        jPanel4.add(txtMaximo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 100, -1));

        jTabbedPane1.addTab("Modificar", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Productos Disponibles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 60, 20));

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
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 250, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Tipo", "Descripcion" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 150, 20));

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

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 630, 130));

        btnSalir5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir5.setText("Salir");
        btnSalir5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir5ActionPerformed(evt);
            }
        });
        jPanel6.add(btnSalir5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 110, 30));

        lblTitulo18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo18.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo18.setText("Doble Clic en la tabla para Actualizar");
        jPanel6.add(lblTitulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 210, 20));

        jTabbedPane1.addTab("Listado", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 4));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo7.setText("Minimo");
        jPanel5.add(lblTitulo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 60, 20));

        txtMinimo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMinimo4.setEnabled(false);
        txtMinimo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMinimo4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMinimo4KeyTyped(evt);
            }
        });
        jPanel5.add(txtMinimo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 50, -1));

        btnBorrar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar3.setText("Borrar");
        btnBorrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar3ActionPerformed(evt);
            }
        });
        jPanel5.add(btnBorrar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 100, 30));

        btnSalir3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        btnSalir3.setText("Salir");
        btnSalir3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir3ActionPerformed(evt);
            }
        });
        jPanel5.add(btnSalir3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 100, 30));

        btnIngresar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        btnIngresar3.setText("Añadir");
        btnIngresar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresar3ActionPerformed(evt);
            }
        });
        jPanel5.add(btnIngresar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, 30));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        tbl1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbl1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl1KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tbl1);

        jPanel5.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 630, 110));

        lblTitulo8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo8.setText("Codigo del Producto");
        jPanel5.add(lblTitulo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 20));

        txtCodigo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo4.setEnabled(false);
        txtCodigo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigo4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigo4KeyTyped(evt);
            }
        });
        jPanel5.add(txtCodigo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 90, -1));

        lblTitulo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo9.setText("Cantidad que Ingresa");
        jPanel5.add(lblTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 140, 20));

        txtIngreso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtIngreso.setEnabled(false);
        txtIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIngresoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIngresoKeyTyped(evt);
            }
        });
        jPanel5.add(txtIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 90, -1));

        lblTitulo32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo32.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo32.setText("Cantidad Disponible");
        jPanel5.add(lblTitulo32, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 130, 20));

        lblTitulo33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo33.setText("Maximo");
        jPanel5.add(lblTitulo33, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 60, 20));

        txtCantidad4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad4.setEnabled(false);
        txtCantidad4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidad4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidad4KeyTyped(evt);
            }
        });
        jPanel5.add(txtCantidad4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 90, -1));

        txtMaximo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMaximo4.setEnabled(false);
        txtMaximo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaximo4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaximo4KeyTyped(evt);
            }
        });
        jPanel5.add(txtMaximo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 50, -1));

        lblTitulo26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblTitulo26.setForeground(new java.awt.Color(255, 51, 51));
        lblTitulo26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo26.setText("Doble Clic en la tabla para Actualizar");
        jPanel5.add(lblTitulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 20));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel27.setText("BUSQUEDA");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 60, 20));

        txtB1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtB1ActionPerformed(evt);
            }
        });
        txtB1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtB1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtB1KeyTyped(evt);
            }
        });
        jPanel5.add(txtB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 160, 20));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel28.setText("FILTROS:");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 60, 20));

        cbxFiltro1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Tipo", "Descripcion" }));
        cbxFiltro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltro1ActionPerformed(evt);
            }
        });
        jPanel5.add(cbxFiltro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 150, 20));

        jTabbedPane1.addTab("Añadir", jPanel5);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 670, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/suniaga.png"))); // NOI18N
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 84));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 430));

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

    private void cbxFiltro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltro1ActionPerformed

    private void txtB1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtB1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtB1KeyTyped

    private void txtB1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtB1KeyReleased
        int c = evt.getKeyChar();
        if (!txtB1.getText().equals("")) {
            int var = cbxFiltro1.getSelectedIndex();
            if (var==0) {
                if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                        + " on tipoproducto.codtip = inventario.tippro "
                        + "where codprod = '" + txtB1.getText() + "' and not codprod = '1'";
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
                        tbl1.setModel(model);
                        Ajustar1();
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese solo Numeros o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtB1.setText("");
                    this.Llenar2();
                }
            }
            //compuebo el cbx opcion 2
            if (var==1) {
                if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK|| c == KeyEvent.VK_SPACE) {
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                        + " on tipoproducto.codtip = inventario.tippro "
                        + "where tipprod like '" + txtB1.getText() + "%'";
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
                        tbl1.setModel(model);
                        Ajustar1();
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese solo letras o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtB1.setText("");
                    this.Llenar2();
                }
            }
            //compuebo el cbx opcion 3
            if (var==2) {
                if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK|| c == KeyEvent.VK_SPACE) {
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                        + " on tipoproducto.codtip = inventario.tippro "
                        + "where desprod like '" + txtB1.getText() + "%'";
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
                        tbl1.setModel(model);
                        Ajustar1();
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese solo letras o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtB1.setText("");
                    this.Llenar2();
                }
            }
        } else {
            this.Llenar2();
        }
    }//GEN-LAST:event_txtB1KeyReleased

    private void txtB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtB1ActionPerformed

    private void txtMaximo4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaximo4KeyTyped

    private void txtMaximo4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaximo4KeyReleased

    private void txtCantidad4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad4KeyTyped

    private void txtCantidad4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad4KeyReleased

    private void txtIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoKeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtIngreso.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 3)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtIngresoKeyTyped

    private void txtIngresoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoKeyReleased
        int lim = txtIngreso.getText().length();
        if (!txtIngreso.getText().equals("")) {
            if (lim >= 0 && Integer.parseInt(txtIngreso.getText()) > 0) {
                txtIngreso.setBackground(Color.GREEN);
            }
        }
        if (lim == 0) {
            txtIngreso.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtIngresoKeyReleased

    private void txtCodigo4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo4KeyTyped

    }//GEN-LAST:event_txtCodigo4KeyTyped

    private void txtCodigo4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigo4KeyReleased

    private void tbl1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyReleased

    private void tbl1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl1KeyPressed

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked
        if (evt.getClickCount() == 2) {
            this.Llenar2();
        } else {
            txtIngreso.setEnabled(true);
            this.Pintar(4);
            int fila = this.tbl1.getSelectedRow();
            String codigo = tbl1.getValueAt(fila, 0).toString();
            if (codigo.equals("1")) {
            JOptionPane.showMessageDialog(null, "No se Puede Modificar Este Producto",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            txtIngreso.setText("");
            } else {
                try {
                String sql = "select * from inventario inner join tipoproducto"
                + " on tipoproducto.codtip = inventario.tippro where codprod = '" + codigo + "'";
                ResultSet rs = acciones.Consultar(sql);
                while (rs.next()) {
                    if (rs.getString("codprod") != "") {
                        this.txtCodigo4.setText(rs.getString("codprod"));
                    }

                    if (rs.getString("canprod") != "") {
                        this.txtCantidad4.setText(rs.getString("canprod"));
                    }

                    if (rs.getString("maxprod") != "") {
                        this.txtMaximo4.setText(rs.getString("maxprod"));
                    }

                    if (rs.getString("minprod") != "") {
                        this.txtMinimo4.setText(rs.getString("minprod"));
                    }
                }
                acciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Datos incompletos\n" + e);
            }
            }
        }
    }//GEN-LAST:event_tbl1MouseClicked

    private void btnIngresar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar3ActionPerformed
        if (Verificacion3()) {
            try {
                String sql = "update inventario set canprod=?, fecprod=? where codprod= '" + txtCodigo4.getText() + "'";
                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setInt(1, Integer.parseInt(txtIngreso.getText()) + Integer.parseInt(txtCantidad4.getText()));
                ps.setString(2, cFecha.getFecha());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Cantidad Actualizada con exito",
                        "Correcto", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Borrar(3);
                    this.Habilitar(3);
                    this.Pintar(3);
                    this.Llenar2();
                }
                acciones.conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar Producto\nCodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
        }
    }//GEN-LAST:event_btnIngresar3ActionPerformed

    private void btnSalir3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir3ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir3ActionPerformed

    private void btnBorrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar3ActionPerformed
        this.Borrar(3);
    }//GEN-LAST:event_btnBorrar3ActionPerformed

    private void txtMinimo4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimo4KeyTyped

    private void txtMinimo4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimo4KeyReleased

    private void btnSalir5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir5ActionPerformed
        this.dispose();     // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir5ActionPerformed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        if (evt.getClickCount() == 2) {
            this.Llenar();
            this.txtB.setText("");
        }
    }//GEN-LAST:event_tblMouseClicked

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void txtBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyTyped

    }//GEN-LAST:event_txtBKeyTyped

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
        int c = evt.getKeyChar();
        if (!txtB.getText().equals("")) {
            int var = cbxFiltro.getSelectedIndex();
            if (var==0) {
                if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
                    try {
                        String[] titulos = {"Codigo", "Tipo", "Descripcion", "Disponible",
                            "Precio"};
                        String sql = "select * from inventario inner join tipoproducto"
                        + " on tipoproducto.codtip = inventario.tippro "
                        + "where codprod = '" + txtB.getText() + "' and not codprod = '1'";
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
                        Ajustar();
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese solo Numeros o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtB.setText("");
                }
            }
            //compuebo el cbx opcion 2
            if (var==1) {
                if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK|| c == KeyEvent.VK_SPACE) {
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
                        Ajustar();
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese solo letras o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtB.setText("");
                }
            }
            //compuebo el cbx opcion 3
            if (var==2) {
                if (c >= 48 && c <= 57 || c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK|| c == KeyEvent.VK_SPACE) {
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
                        Ajustar();
                        acciones.conn.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al consultar productos\ncodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ingrese solo letras o seleccione otro filtro", "Advertencia",
                        JOptionPane.PLAIN_MESSAGE, iconAd);
                    this.txtB.setText("");
                }
            }
        } else {
            this.Llenar();
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtMaximo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo2KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtMaximo2.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 3)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaximo2KeyTyped

    private void txtMaximo2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo2KeyReleased
        int lim = txtMaximo2.getText().length();
        if (!txtMaximo2.getText().equals("")) {
            if (lim >= 0 && Integer.parseInt(txtMaximo2.getText()) > 0) {
                txtMaximo2.setBackground(Color.GREEN);
            }
        }
        if (lim == 0) {
            txtMaximo2.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtMaximo2KeyReleased

    private void txtMaximo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaximo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaximo2ActionPerformed

    private void txtMinimo2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo2KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtMinimo2.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 3)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMinimo2KeyTyped

    private void txtMinimo2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo2KeyReleased
        int lim = txtMinimo2.getText().length();
        if (!txtMinimo2.getText().equals("")) {
            if (lim >= 0 && Integer.parseInt(txtMinimo2.getText()) > 0) {
                txtMinimo2.setBackground(Color.GREEN);
            }
        }
        if (lim == 0) {
            txtMinimo2.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtMinimo2KeyReleased

    private void txtMinimo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimo2ActionPerformed

    private void txtTotal2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal2KeyReleased

    private void txtTotal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal2ActionPerformed

    private void txtCantidad2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidad2KeyTyped

    private void txtCantidad2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad2KeyReleased
        if (txtCantidad2.getText().equals("0")) {
            txtCantidad2.setText("");
        }
        int lim = txtCantidad2.getText().length();
        if (lim >= 1 && Integer.parseInt(txtCantidad2.getText()) > 0) {
            txtCantidad2.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtCantidad2.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtCantidad2KeyReleased

    private void txtPrecio2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio2KeyTyped
        char c = evt.getKeyChar();
        int lim = txtPrecio2.getText().length();
        if (c >= 48 && c <= 57 || c == 46 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecio2KeyTyped

    private void txtPrecio2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio2KeyReleased
        char c = evt.getKeyChar();
        if (txtPrecio2.getText().equals("0")) {
            txtPrecio2.setText("");
        }
        if (!txtPrecio2.getText().equals("") && c != 46) {
            int lim = txtPrecio2.getText().length();
            if (lim >= 0 && Float.parseFloat(txtPrecio2.getText()) > 0) {
                float total = Float.parseFloat(txtPrecio2.getText()) + (Float.parseFloat(txtPrecio2.getText()) * (getIva() / 100));
                txtTotal2.setText(String.valueOf(format.format(total)));
                txtPrecio2.setBackground(Color.GREEN);
            }
            if (lim == 0) {
                txtPrecio2.setBackground(Color.RED);
            }
        } else {
            txtTotal2.setText("0");
        }
    }//GEN-LAST:event_txtPrecio2KeyReleased

    private void txtPrecio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio2ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //    selecciono el codigo del cliente para no tener problemas al no copiar la cedula completa
        boolean resultado = false;
        txtConsultar2.setEnabled(false);
        Pintar(1);
        int codigo = 0;
        cbxTipo2.removeAllItems();
        cbxProveedor2.removeAllItems();
        if(!txtConsultar2.getText().equals("")){
            if(Integer.parseInt(txtConsultar2.getText())==1){
                JOptionPane.showMessageDialog(null, "No se Puede Modificar Este Producto",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                Habilitar(2);
            }else{
             String cedula = this.txtConsultar2.getText();
            if (!cedula.equals("")) {
                float total = 0;
                try {
                    String sql = "select * from inventario "
                    + "inner join tipoproducto on tippro = codtip "
                    + "inner join proveedores on \"proveedores\".\"rifpro\"=\"inventario\".\"codpro\" "
                    + "where codprod = '" + cedula + "'";
                    ResultSet rs = acciones.Consultar(sql);
                    while (rs.next()) {
                        resultado = true;
                        cbxTipo2.addItem(rs.getString("tipprod"));
                        total = rs.getFloat("preprod") / (1 + getIva() / 100);
                        txtPrecio2.setText(String.valueOf(total));
                        txtTotal2.setText(format.format(rs.getFloat("preprod")));
                        txtCantidad2.setText(rs.getString("canprod"));
                        txtMinimo2.setText(rs.getString("minprod"));
                        txtMaximo2.setText(rs.getString("maxprod"));
                        cbxProveedor2.addItem(rs.getString("nompro"));
                        txtDescripcion2.setText(rs.getString("desprod"));
                        Habilitar(1);
                    }
                    if (resultado == false) {
                        JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia",
                            JOptionPane.PLAIN_MESSAGE, iconAd);
                        txtConsultar2.setEnabled(true);
                        //                this.Habilitar(3);
                        resultado = false;
                    }
                    acciones.conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al consultar cliente\ncodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Campo Cedula vacio",
                    "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            }   
            }
        }else{
            JOptionPane.showMessageDialog(null, "No debe estar el campo vacio");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtConsultar2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtConsultar2KeyTyped
        char c = evt.getKeyChar();
        int lim = txtConsultar2.getText().length();
        if (c >= 48 && c <= 57 || c == 46 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtConsultar2KeyTyped

    private void cbxProveedor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedor2ActionPerformed

    private void btnIngresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar2ActionPerformed
        String codigo = this.txtConsultar2.getText();
        if (Verificacion2()) {
            try {
                String sql = "update inventario set codprod=?, desprod=?, canprod=?, preprod=?,"
                + " minprod=?, maxprod=? where codprod= '" + codigo + "'";
                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setInt(1, Integer.parseInt(txtConsultar2.getText()));
                ps.setString(2, this.txtDescripcion2.getText());
                ps.setInt(3, Integer.parseInt(txtCantidad2.getText()));
                ps.setFloat(4, Float.parseFloat(this.txtTotal2.getText()));
                ps.setInt(5, Integer.parseInt(txtMinimo2.getText()));
                ps.setInt(6, Integer.parseInt(txtMaximo2.getText()));
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Producto Actualizado con exito",
                        "Correcto", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Borrar(2);
                    this.Habilitar(2);
                    this.Pintar(2);
                }
                acciones.conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar Producto\nCodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
        }
    }//GEN-LAST:event_btnIngresar2ActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir2ActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
        Borrar(2);
        Pintar(2);
        Habilitar(2);
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void txtDescripcion2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcion2KeyReleased
        if (txtDescripcion2.getText().equals("")) {
            txtDescripcion2.setBackground(Color.RED);
        } else {
            txtDescripcion2.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtDescripcion2KeyReleased

    private void txtPrecio1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio1KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtPrecio1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio1KeyTyped

    private void txtPrecio1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecio1KeyReleased

        if (txtPrecio1.getText().equals("0")) {
            txtPrecio1.setText("");
        }
        if (!txtPrecio1.getText().equals("")) {
            int lim = txtPrecio1.getText().length();
            if (lim >= 0 && Integer.parseInt(txtPrecio1.getText()) > 0) {
                float total = Float.parseFloat(txtPrecio1.getText()) + (Float.parseFloat(txtPrecio1.getText()) * (getIva() / 100));
                txtTotal1.setText(String.valueOf(format.format(total)));
                txtPrecio1.setBackground(Color.GREEN);
            }
            if (lim == 0) {
                txtPrecio1.setBackground(Color.RED);
            }
        } else {
            txtTotal1.setText("0");
        }
    }//GEN-LAST:event_txtPrecio1KeyReleased

    private void txtPrecio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecio1ActionPerformed

    private void cbxProveedor1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedor1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProveedor1ActionPerformed

    private void btnIngresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresar1ActionPerformed
        if (Verificacion1()) {
            float total = 0;
            try {
                String sql = "insert into inventario(tippro, desprod, canprod,"
                + "preprod, minprod, maxprod, codpro, fecprod) values(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = acciones.Ingresar(sql);
                total = Integer.parseInt(txtPrecio1.getText()) + (Integer.parseInt(txtPrecio1.getText()) * (getIva() / 100));
                ps.setInt(1, getCodTipoProducto(cbxTipo1.getSelectedItem().toString()));
                ps.setString(2, txtDescripcion1.getText());
                ps.setInt(3, Integer.parseInt(txtCantidad1.getText()));
                ps.setFloat(4, total);
                ps.setInt(5, Integer.parseInt(txtMinimo1.getText()));
                ps.setInt(6, Integer.parseInt(txtMaximo1.getText()));
                ps.setInt(7, getCodProveedores(cbxProveedor1.getSelectedItem().toString()));
                ps.setString(8, cFecha.getFecha());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Producto ingresado con exito al inventario",
                        "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Borrar(1);
                    Pintar(1);
                    this.Llenar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al guardar cliente\ncodigo error:" + e.getMessage(),
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            }
        }
    }//GEN-LAST:event_btnIngresar1ActionPerformed

    private void btnSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir1ActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalir1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        Borrar(1);
        Pintar(1);// this.Borrar(1);
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void txtTotal1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotal1KeyReleased

    }//GEN-LAST:event_txtTotal1KeyReleased

    private void txtTotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotal1ActionPerformed

    private void txtMinimo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo1KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtMinimo1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 3)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMinimo1KeyTyped

    private void txtMinimo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinimo1KeyReleased
        int lim = txtMinimo1.getText().length();
        if (!txtMinimo1.getText().equals("")) {
            if (lim >= 0 && Integer.parseInt(txtMinimo1.getText()) > 0) {
                txtMinimo1.setBackground(Color.GREEN);
            }
        }
        if (lim == 0) {
            txtMinimo1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtMinimo1KeyReleased

    private void txtMinimo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinimo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinimo1ActionPerformed

    private void txtMaximo1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo1KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtMaximo1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 3)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtMaximo1KeyTyped

    private void txtMaximo1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaximo1KeyReleased
        int lim = txtMaximo1.getText().length();
        if (!txtMaximo1.getText().equals("")) {
            if (lim >= 0 && Integer.parseInt(txtMaximo1.getText()) > 0) {
                txtMaximo1.setBackground(Color.GREEN);
            }
        }
        if (lim == 0) {
            txtMaximo1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtMaximo1KeyReleased

    private void txtMaximo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaximo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaximo1ActionPerformed

    private void txtCantidad1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad1KeyTyped
        char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtCantidad1.getText().length();
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 3)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidad1KeyTyped

    private void txtCantidad1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidad1KeyReleased
        if (txtCantidad1.getText().equals("0")) {
            txtCantidad1.setText("");
        }
        int lim = txtCantidad1.getText().length();
        if (lim >= 1 && Integer.parseInt(txtCantidad1.getText()) > 0) {
            txtCantidad1.setBackground(Color.GREEN);
        }
        if (lim == 0) {
            txtCantidad1.setBackground(Color.RED);
        }
    }//GEN-LAST:event_txtCantidad1KeyReleased

    private void txtDescripcion1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcion1KeyReleased
        if (txtDescripcion1.getText().equals("")) {
            txtDescripcion1.setBackground(Color.RED);
        } else {
            txtDescripcion1.setBackground(Color.green);
        }
    }//GEN-LAST:event_txtDescripcion1KeyReleased
    
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
    private javax.swing.JButton btnBorrar3;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnIngresar1;
    private javax.swing.JButton btnIngresar2;
    private javax.swing.JButton btnIngresar3;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnSalir3;
    private javax.swing.JButton btnSalir5;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxFiltro1;
    private javax.swing.JComboBox<String> cbxProveedor1;
    private javax.swing.JComboBox<String> cbxProveedor2;
    private javax.swing.JComboBox<String> cbxTipo1;
    private javax.swing.JComboBox<String> cbxTipo2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
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
    private javax.swing.JLabel lblTitulo18;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo20;
    private javax.swing.JLabel lblTitulo21;
    private javax.swing.JLabel lblTitulo22;
    private javax.swing.JLabel lblTitulo23;
    private javax.swing.JLabel lblTitulo24;
    private javax.swing.JLabel lblTitulo25;
    private javax.swing.JLabel lblTitulo26;
    private javax.swing.JLabel lblTitulo32;
    private javax.swing.JLabel lblTitulo33;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo6;
    private javax.swing.JLabel lblTitulo7;
    private javax.swing.JLabel lblTitulo8;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tbl1;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtB1;
    private javax.swing.JTextField txtCantidad1;
    private javax.swing.JTextField txtCantidad2;
    private javax.swing.JTextField txtCantidad4;
    private javax.swing.JTextField txtCodigo4;
    private javax.swing.JTextField txtConsultar2;
    private javax.swing.JTextArea txtDescripcion1;
    private javax.swing.JTextArea txtDescripcion2;
    private javax.swing.JTextField txtIngreso;
    private javax.swing.JTextField txtMaximo1;
    private javax.swing.JTextField txtMaximo2;
    private javax.swing.JTextField txtMaximo4;
    private javax.swing.JTextField txtMinimo1;
    private javax.swing.JTextField txtMinimo2;
    private javax.swing.JTextField txtMinimo4;
    private javax.swing.JTextField txtPrecio1;
    private javax.swing.JTextField txtPrecio2;
    private javax.swing.JTextField txtTotal1;
    private javax.swing.JTextField txtTotal2;
    // End of variables declaration//GEN-END:variables

    private boolean Verificacion1() {
        if (!txtDescripcion1.getText().equals("") && !txtMinimo1.getText().equals("")
                && !txtMaximo1.getText().equals("") && !txtCantidad1.getText().equals("") && !txtPrecio1.getText().equals("")
                && !txtTotal1.getText().equals("")) {
            if (Integer.parseInt(txtCantidad1.getText()) <= Integer.parseInt(txtMaximo1.getText())) {
                if (Integer.parseInt(txtMinimo1.getText()) < Integer.parseInt(txtMaximo1.getText())) {
                    if (txtPrecio1.getText().charAt(txtPrecio1.getText().length() - 1) == '.') {
                        JOptionPane.showMessageDialog(null, "Corrija el precio", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El minimo de inventario debe ser menor al maximo de inventario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad que ingresa no puede ser mayor que el maximo del inventario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique que los campos esten llenos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        }
    }

    private boolean Verificacion2() {
        if (!txtDescripcion2.getText().equals("") && !txtMinimo2.getText().equals("")
                && !txtMaximo2.getText().equals("") && !txtCantidad2.getText().equals("") && !txtPrecio2.getText().equals("")
                && !txtTotal2.getText().equals("")) {
            if (Integer.parseInt(txtCantidad2.getText()) <= Integer.parseInt(txtMaximo2.getText())) {
                if (Integer.parseInt(txtMinimo2.getText()) < Integer.parseInt(txtMaximo2.getText())) {
                    if (txtPrecio2.getText().charAt(txtPrecio2.getText().length() - 1) == '.') {
                        JOptionPane.showMessageDialog(null, "Precio ingresado incorrecto", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                        return false;
                    } else {
                        if (Integer.parseInt(txtCantidad2.getText()) <= Integer.parseInt(txtMinimo2.getText())) {
                            JOptionPane.showMessageDialog(null, "Atencion...\nEl minimo de inventario supera la cantidad disponible, debera añadir mas productos", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                            return true;
                        } else {
                            return true;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El minimo de inventario debe ser menor al maximo de inventario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad disponible no puede ser mayor que el maximo del inventario", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
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
            case 2:
                txtDescripcion2.setText("");
                txtMaximo2.setText("");
                txtMinimo2.setText("");
                txtCantidad2.setText("");
                txtPrecio2.setText("");
                txtTotal2.setText("");
                break;
            case 3:
                txtCantidad4.setText("");
                txtMaximo4.setText("");
                txtMinimo4.setText("");
                txtCodigo4.setText("");
                txtIngreso.setText("");
                break;
            default:
                throw new AssertionError();
        }
    }

    private void Habilitar(int x) {
        switch (x) {
            case 1:
                txtDescripcion2.setEnabled(true);
                txtMaximo2.setEnabled(true);
                txtMinimo2.setEnabled(true);
                txtPrecio2.setEnabled(true);
                break;
            case 2:
                txtConsultar2.setEnabled(true);
                txtDescripcion2.setEnabled(false);
                txtMaximo2.setEnabled(false);
                txtMinimo2.setEnabled(false);
                txtPrecio2.setEnabled(false);
                break;
            case 3:
                txtCantidad4.setEnabled(false);
                txtMaximo4.setEnabled(false);
                txtMinimo4.setEnabled(false);
                txtCodigo4.setEnabled(false);
                txtIngreso.setEnabled(false);
                break;
            default:
        }
    }

    private void Pintar(int num) {
        switch (num) {
            case 1:
                txtDescripcion1.setBackground(Color.WHITE);
                txtMaximo1.setBackground(Color.WHITE);
                txtMinimo1.setBackground(Color.WHITE);
                txtCantidad1.setBackground(Color.WHITE);
                txtPrecio1.setBackground(Color.WHITE);
                txtTotal1.setBackground(Color.WHITE);
                break;
            case 2:
                txtDescripcion2.setBackground(Color.WHITE);
                txtMaximo2.setBackground(Color.WHITE);
                txtMinimo2.setBackground(Color.WHITE);
                txtCantidad2.setBackground(Color.WHITE);
                txtPrecio2.setBackground(Color.WHITE);
                txtTotal2.setBackground(Color.WHITE);
                break;
            case 3:
                txtIngreso.setBackground(new Color(240, 240, 240));
                break;
            case 4:
                txtIngreso.setBackground(Color.WHITE);
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

    private boolean Verificacion3() {
        if (!txtIngreso.getText().equals("") && tbl1.getSelectedRow() > -1) {
            int total = Integer.parseInt(txtIngreso.getText()) + Integer.parseInt(txtCantidad4.getText());
            int maximo = Integer.parseInt(txtMaximo4.getText());
            int minimo = Integer.parseInt(txtMinimo4.getText());
            int disponible = Integer.parseInt(txtCantidad4.getText());
            if (total > maximo) {
                JOptionPane.showMessageDialog(null, "Cantidad ingresada supera el limite del inventario maximo\nIngrese otra cantidad o cambie el maximo del inventario para el producto seleccionado.",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                return false;
            } else {
                if (total <= minimo) {
                    JOptionPane.showMessageDialog(null, "La cantidad ingresada aun no supera el minimo de inventario",
                            "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    return true;
                } else {
                    return true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique que este selecionada una sola fila y que la cantidad sea correcta",
                    "Error", JOptionPane.PLAIN_MESSAGE, iconError);
            return false;
        }
    }
    
    private void Ajustar1() {
        tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl1.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl1.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl1.getColumnModel().getColumn(2).setPreferredWidth(410);
        tbl1.getColumnModel().getColumn(3).setPreferredWidth(70);
    }
    
    private void Ajustar() {
        tbl.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tbl.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl.getColumnModel().getColumn(1).setPreferredWidth(80);
        tbl.getColumnModel().getColumn(2).setPreferredWidth(330);
        tbl.getColumnModel().getColumn(3).setPreferredWidth(70);
        tbl.getColumnModel().getColumn(4).setPreferredWidth(80);
    }
}
