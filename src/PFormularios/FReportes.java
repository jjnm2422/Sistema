/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.sun.awt.AWTUtilities;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Navarro
 */
public class FReportes extends javax.swing.JFrame{

    private int x;
    private int y;
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    PClases.CFecha fecha = new PClases.CFecha();
    private String hora = "";
     TextAutoCompleter txtAuto;
     TextAutoCompleter txtAuto2;
    private String ampm;
    private String minutos;
    private String segundos;
    private String usuario;
    private long i = 0;
    private String ruta;
    PBD.Conexion_DB conexion = new PBD.Conexion_DB();
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        
    public FReportes() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.txtAuto = new TextAutoCompleter(txtCedula2);
        this.txtAuto2 = new TextAutoCompleter(txtCedula4);
        getTipoProducto();
        i=0;
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
    
     public void LlenarLista(int x) {
        txtAuto.removeAllItems();
        switch (x) {
            case 1:
                try {
                    String sql = "select * from clientes";
                    ResultSet rs = acciones.Consultar(sql);
                    while (rs.next()) {
                        this.AddLista(rs.getString("cedcli"));
                    }
                    acciones.conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
                }
    }
     
     public void LlenarLista2(int x) {
        txtAuto2.removeAllItems();
        switch (x) {
            case 1:
                try {
                    String sql = "select * from ventas";
                    ResultSet rs = acciones.Consultar(sql);
                    while (rs.next()) {
                        this.AddLista2(rs.getString("codven"));
                    }
                    acciones.conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
                break;
                }
    }
     
     public void AddLista(Object x) {
        txtAuto.addItem(x);
    }
     
     public void AddLista2(Object x) {
        txtAuto2.addItem(x);
    }
    
public String getRuta() {
        try {
            String sql = "select ruta from variables";
            ResultSet rs= acciones.Consultar(sql);
            while(rs.next()){
            ruta = rs.getString("ruta"); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ruta;
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
    
    
    private void restaurarVentana(JFrame frame) {
        if(getExtendedState() == frame.MAXIMIZED_BOTH){//1
            setExtendedState(frame.NORMAL);//2
        }else{
            setExtendedState(frame.MAXIMIZED_BOTH);//3
        }
    }
    
    private void restaurarVentana2() {
        if(getExtendedState() == JFrame.MAXIMIZED_BOTH){//1
            setExtendedState(JFrame.NORMAL);//2
        }else{
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }
    
    public void Ajustar(JLabel label, ImageIcon icon){
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

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jMonthChooser2 = new com.toedter.calendar.JMonthChooser();
        jYearChooser2 = new com.toedter.calendar.JYearChooser();
        jLabel13 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        txtCedula2 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        txtCedula4 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jFrame2 = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        cbxEstado = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jFrame3 = new javax.swing.JFrame();
        jPanel4 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtCedula3 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jButton31 = new javax.swing.JButton();
        cbxTipo1 = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblResponsable = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jFrame1.setUndecorated(true);
        jFrame1.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/cerrar.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 30, 30));

        jLabel2.setBackground(new java.awt.Color(0, 255, 255));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Por Año");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 20));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Reportes Graficos de Ventas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 420, 30));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Por Fecha");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 20));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Por Mes");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 20));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Por Ventas a Clientes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 160, 20));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Todas las Ventas");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 20));

        jButton3.setText("Generar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 140, -1));
        jPanel1.add(jMonthChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 140, -1));
        jPanel1.add(jYearChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 140, -1));

        jButton9.setText("Generar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        jButton12.setText("Generar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jButton13.setText("Generar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Reportes de Ventas");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 40, 420, 30));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Por Diarias por Año");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 140, 20));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Por Mes");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, 20));
        jPanel1.add(jMonthChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 140, -1));
        jPanel1.add(jYearChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 140, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Anuales");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 100, 20));

        jButton14.setText("Generar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, -1, -1));

        jButton15.setText("Generar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, -1, -1));

        jButton16.setText("Generar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, -1, -1));

        txtCedula2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedula2ActionPerformed(evt);
            }
        });
        txtCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula2KeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, 20));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Codigo de Venta");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 120, 10));

        jButton17.setText("Generar");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Por Cliente especifico");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 160, 20));

        jButton18.setText("Generar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Detalle de Venta por Codigo");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 200, 20));

        jButton21.setText("Generar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, -1, -1));

        txtCedula4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedula4ActionPerformed(evt);
            }
        });
        txtCedula4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula4KeyTyped(evt);
            }
        });
        jPanel1.add(txtCedula4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 120, 20));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Cedula del Cliente");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 140, 10));

        jFrame1.getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 430));

        jFrame2.setUndecorated(true);
        jFrame2.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/cerrar.png"))); // NOI18N
        jButton20.setBorderPainted(false);
        jButton20.setContentAreaFilled(false);
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 30, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Reportes Graficos de Pedidos");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 420, 30));

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Todas las Pedidos");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 120, 20));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Reportes de Pedidos");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 40, 420, 30));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Por Estado");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 100, 20));

        jButton27.setText("Generar");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        jButton28.setText("Generar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Por Estado");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 130, 20));

        jButton29.setText("Generar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, -1, -1));

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pendiente", "completado" }));
        cbxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEstadoActionPerformed(evt);
            }
        });
        jPanel2.add(cbxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 150, -1));

        jLabel16.setBackground(new java.awt.Color(0, 255, 255));
        jLabel16.setOpaque(true);
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 30));

        jFrame2.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 250));

        jFrame3.setUndecorated(true);
        jFrame3.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/cerrar.png"))); // NOI18N
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 30, 30));

        jLabel5.setBackground(new java.awt.Color(0, 255, 255));
        jLabel5.setOpaque(true);
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 30));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Productos Bajo Minimo");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, 20));

        jLabel20.setBackground(new java.awt.Color(255, 255, 255));
        jLabel20.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Por Fecha");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 100, 20));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Por Tipo de Producto");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, 20));

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Todos los Productos");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 140, 20));

        jButton19.setText("Generar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));
        jPanel4.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 140, -1));

        jButton22.setText("Generar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jButton23.setText("Generar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Reportes de Inventario");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 40, 420, 30));

        txtCedula3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedula3ActionPerformed(evt);
            }
        });
        txtCedula3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCedula3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula3KeyTyped(evt);
            }
        });
        jPanel4.add(txtCedula3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 140, 20));

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Rif del Proveedor");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 140, 10));

        jButton30.setText("Generar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel33.setText("Por Proveedor");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 160, 20));

        jButton31.setText("Generar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, -1, -1));

        cbxTipo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipo1ActionPerformed(evt);
            }
        });
        jPanel4.add(cbxTipo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 140, 20));

        jFrame3.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 260));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reportes");
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 610, 50));

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 30));

        lblHora.setBackground(new java.awt.Color(255, 255, 255));
        lblHora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHora.setForeground(new java.awt.Color(255, 255, 255));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel3.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 140, 20));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/Clientes.png"))); // NOI18N
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/ClientesR.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 210, 130));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/ventas.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/Ventas2.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 200, 170));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/Pedidos.png"))); // NOI18N
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/Pedidos2.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 200, 170));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/Proveedores.png"))); // NOI18N
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/ProveedoresR.png"))); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 210, 130));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/Inventario.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/InventarioR.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 210, 130));

        lblResponsable.setText("acmk");
        jPanel3.add(lblResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, 120, 20));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/suniaga.png"))); // NOI18N
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 200, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 410));

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
    this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
restaurarVentana2();
setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
//    this.requestFocus();     
    }//GEN-LAST:event_formWindowLostFocus

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 
    }//GEN-LAST:event_formWindowOpened

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteC.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
jFrame1.setSize(430,430);
jFrame1.setLocationRelativeTo(null);
jFrame1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
jFrame2.setSize(380,250);
jFrame2.setLocationRelativeTo(null);
jFrame2.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() +"\\reporteP.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
jFrame3.setSize(430,260);
jFrame3.setLocationRelativeTo(null);
jFrame3.setVisible(true);    
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
jFrame1.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtCedula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedula2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2ActionPerformed

    private void txtCedula2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2KeyReleased

    private void txtCedula2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula2KeyTyped
char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtCedula2.getText().length();
            LlenarLista(1) ;
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 9)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2KeyTyped

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteV.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
    if (txtCedula2.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Campo de cedula vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVporcliente.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("cedula", txtCedula2.getText());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
    if (jDateChooser1.getDate()==null) {
    JOptionPane.showMessageDialog(null, "Campo de fecha vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVpordia.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("fecha", formateador.format(jDateChooser1.getDate()));
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    if (jMonthChooser1.getMonth()<0) {
    JOptionPane.showMessageDialog(null, "Campo de mes invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        String mes = "";
        String fecha = "";
        switch (jMonthChooser1.getMonth()) {
            case 0:
                mes = "Enero";
                fecha = "01";
                break;
            case 1:
                mes = "Febrero";
                fecha = "02";
                break;
            case 2:
                mes = "Marzo";
                fecha = "03";
                break;
            case 3:
                mes = "Abril";
                fecha = "04";
                break;
            case 4:
                mes = "Mayo";
                fecha = "05";
                break;
            case 5:
                mes = "Junio";
                fecha = "06";
                break;
            case 6:
                mes = "Julio";
                fecha = "07";
                break;
            case 7:
                mes = "Agosto";
                fecha = "08";
                break;
            case 8:
                mes = "Septiembre";
                fecha = "09";
                break;
            case 9:
                mes = "Octubre";
                fecha = "10";
                break;
            case 10:
                mes = "Noviembre";
                fecha = "11";
                break;
            case 11:
                mes = "Diciembre";
                fecha = "12";
                break;
        }
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVpormes.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("fecha", fecha);
            p2.put("mes", mes);
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
x = evt.getX();
        y = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
    Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
    jFrame1.setLocation(ubicacion.x - x, ubicacion.y - y);//3        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
  if (jYearChooser1.getYear()<2000) {
    JOptionPane.showMessageDialog(null,"Fecha Incorrecta o menor al año 2000", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVporano.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("fecha", jYearChooser1.getYear());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
  if (jYearChooser2.getYear()<2000) {
    JOptionPane.showMessageDialog(null,"Fecha Incorrecta o menor al año 2000", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVgraficadiarias.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("año", jYearChooser2.getYear());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
 if (jMonthChooser2.getMonth()<0) {
    JOptionPane.showMessageDialog(null, "Campo de mes invalido", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        String mes = "";
        String fecha = "";
        switch (jMonthChooser2.getMonth()) {
            case 0:
                mes = "Enero";
                fecha = "01";
                break;
            case 1:
                mes = "Febrero";
                fecha = "02";
                break;
            case 2:
                mes = "Marzo";
                fecha = "03";
                break;
            case 3:
                mes = "Abril";
                fecha = "04";
                break;
            case 4:
                mes = "Mayo";
                fecha = "05";
                break;
            case 5:
                mes = "Junio";
                fecha = "06";
                break;
            case 6:
                mes = "Julio";
                fecha = "07";
                break;
            case 7:
                mes = "Agosto";
                fecha = "08";
                break;
            case 8:
                mes = "Septiembre";
                fecha = "09";
                break;
            case 9:
                mes = "Octubre";
                fecha = "10";
                break;
            case 10:
                mes = "Noviembre";
                fecha = "11";
                break;
            case 11:
                mes = "Diciembre";
                fecha = "12";
                break;
        }
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVgraficames.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("fecha", fecha);
            p2.put("mes", mes);
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVgraficaano.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("fecha", jYearChooser2.getYear());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}          // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteVgraficaclientes.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}      // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
   jFrame2.dispose();    // TODO add your handling code here:
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reportePEgrafica.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reportePE.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        if (cbxEstado.getSelectedIndex()==0) {
            try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reportePEpendientes.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        } else {
            try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reportePEcompletados.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
    Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
    jFrame2.setLocation(ubicacion.x - x, ubicacion.y - y);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
x = evt.getX();
        y = evt.getY();         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MousePressed

    private void cbxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEstadoActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
jFrame3.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() +"\\reporteIportipo.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("tipo", cbxTipo1.getSelectedItem().toString());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() +"\\reporteIdebajodelminimo.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
   if (jDateChooser2.getDate()==null) {
    JOptionPane.showMessageDialog(null, "Campo de fecha vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteIporfecha.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("fecha", formateador.format(jDateChooser2.getDate()));
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() +"\\reporteI.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
   if (txtCedula3.getText().equals("")) {
    JOptionPane.showMessageDialog(null, "Campo de rif vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
        try {
            Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteIporproveedor.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("rif", txtCedula3.getText());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
}
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
    Point ubicacion = MouseInfo.getPointerInfo().getLocation();//1
    jFrame3.setLocation(ubicacion.x - x, ubicacion.y - y);         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
x = evt.getX();
        y = evt.getY();         // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MousePressed

    private void txtCedula3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula3KeyTyped

    private void txtCedula3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula3KeyReleased

    private void txtCedula3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedula3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula3ActionPerformed

    private void cbxTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTipo1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if (txtCedula4.getText().equals("")) {
            JOptionPane.showMessageDialog(null,"Campo Codigo Vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            
         try {
              Connection conn = PBD.Conexion_DB.geConnection();
            String dir = getRuta() + "\\reporteV2.jrxml";
            Map<String, Object> p2 = new HashMap<>();
            p2.put("usuario", lblResponsable.getText());
            p2.put("ruta", getRuta());
            p2.put("registro", txtCedula4.getText());
            JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, p2, conn);
            JasperViewer visor = new JasperViewer(mostrarReporte, false);
            visor.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL CARGAR EL REPORTE SIN EMBARGO LA VENTA SE REALIZO CON EXITO.\n" + ex, "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
        
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton21ActionPerformed

    private void txtCedula4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedula4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula4ActionPerformed

    private void txtCedula4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula4KeyReleased

    private void txtCedula4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedula4KeyTyped
char c = evt.getKeyChar();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtCedula4.getText().length();
            LlenarLista2(1);
            //cambie este numero que es el limite
            if (this.EventoKeyType(lim, 8)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }          // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula4KeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FReportes().setVisible(true);
            }
        });
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxTipo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private com.toedter.calendar.JMonthChooser jMonthChooser2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JYearChooser jYearChooser2;
    private javax.swing.JLabel lblHora;
    public javax.swing.JLabel lblResponsable;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JTextField txtCedula3;
    private javax.swing.JTextField txtCedula4;
    // End of variables declaration//GEN-END:variables

private boolean EventoKeyType(int valor, int limitacion){
            //pido el valor del text y pido el valor limitante
            if (valor >= limitacion) {
                return true;
            }else{
                return false;
            }
    }
}
