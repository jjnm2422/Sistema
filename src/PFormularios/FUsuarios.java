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

/**
 *
 * @author Navarro
 */
public class FUsuarios extends javax.swing.JFrame {

    private int x;
    private int y;
    private final ImageIcon iconError = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png"));
    private final ImageIcon iconCorrecto = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/correcto.png"));
    private final ImageIcon iconAd = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/escudoA.png"));
    private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
    private PBD.Acciones_BD acciones = new PBD.Acciones_BD();
    private String hora ="";
        private PClases.CFecha fecha = new PClases.CFecha();

    public FUsuarios() {
        this.setlook();
        initComponents();
        setLocationRelativeTo(null);
        this.restringir();
        txtFecha.setText(fecha.getFecha());
    }
    
    public String getPass() {
        char[] arrayC1 = txtPin.getPassword();
        String c1 = new String(arrayC1);
        return c1;
    }
    public String getPass2() {
        char[] arrayC1 = txtPin2.getPassword();
        String c1 = new String(arrayC1);
        return c1;
    }
    public void setlook() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String LlenarHora() {
        try {
            String sql = "select * from variables where codvar = '1'";
            ResultSet rs = acciones.Consultar(sql);
            while (rs.next()) {
                hora = rs.getString("hora");
            }
            acciones.conn.close();
            return hora;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return hora;
        }
    }

    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }

    private void restaurarVentana() {
        if (getExtendedState() == JFrame.MAXIMIZED_BOTH) {//1
            setExtendedState(JFrame.NORMAL);//2
        } else {
            setExtendedState(JFrame.MAXIMIZED_BOTH);//3
        }
    }
    
    public void restringir() {
        RestrictedTextField r3 = new RestrictedTextField(this.txtCedula);
        r3.setOnlyNums(true);
        r3.setLimit(9);
        RestrictedTextField r1 = new RestrictedTextField(this.txtNombre);
        r1.setOnlyText(true);
        r1.setLimit(15);
        RestrictedTextField r6 = new RestrictedTextField(this.txtUsuario,"1234567890qwertyuiopasdfghjklñzxcvbnm");
        r6.setLimit(10);
        RestrictedTextField r5 = new RestrictedTextField(this.txtApellido);
        r5.setOnlyText(true);
        r5.setLimit(15);
        RestrictedTextField r4 = new RestrictedTextField(this.txtClave);
        r4.setOnlyNums(true);
        r4.setLimit(12);
        RestrictedTextField r = new RestrictedTextField(this.txtClave2);
        r.setOnlyNums(true);
        r.setLimit(12);
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
                case 3:
                bnt21.setEnabled(false);
                bnt22.setEnabled(false);
                bnt23.setEnabled(false);
                bnt24.setEnabled(false);
                bnt25.setEnabled(false);
                bnt26.setEnabled(false);
                bnt27.setEnabled(false);
                bnt28.setEnabled(false);
                bnt29.setEnabled(false);
                break;
            case 4:
                bnt21.setEnabled(true);
                bnt22.setEnabled(true);
                bnt23.setEnabled(true);
                bnt24.setEnabled(true);
                bnt25.setEnabled(true);
                bnt26.setEnabled(true);
                bnt27.setEnabled(true);
                bnt28.setEnabled(true);
                bnt29.setEnabled(true);
                break;
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
        jPanel2 = new javax.swing.JPanel();
        lblTitulo5 = new javax.swing.JLabel();
        lblTitulo9 = new javax.swing.JLabel();
        lblTitulo10 = new javax.swing.JLabel();
        lblTitulo11 = new javax.swing.JLabel();
        lblTitulo12 = new javax.swing.JLabel();
        lblTitulo14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        lblTitulo15 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        txtPin = new javax.swing.JPasswordField();
        txtClave = new javax.swing.JPasswordField();
        txtClave2 = new javax.swing.JPasswordField();
        btn3 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        lblTitulo19 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lblTitulo13 = new javax.swing.JLabel();
        lblTitulo20 = new javax.swing.JLabel();
        lblTitulo21 = new javax.swing.JLabel();
        lblTitulo22 = new javax.swing.JLabel();
        lblTitulo23 = new javax.swing.JLabel();
        lblTitulo24 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        txtUsuario2 = new javax.swing.JTextField();
        txtApellido2 = new javax.swing.JTextField();
        lblTitulo25 = new javax.swing.JLabel();
        txtCedula2 = new javax.swing.JTextField();
        txtPin2 = new javax.swing.JPasswordField();
        txtClave21 = new javax.swing.JPasswordField();
        txtClave22 = new javax.swing.JPasswordField();
        bnt23 = new javax.swing.JButton();
        bnt21 = new javax.swing.JButton();
        bnt22 = new javax.swing.JButton();
        bnt24 = new javax.swing.JButton();
        bnt25 = new javax.swing.JButton();
        bnt26 = new javax.swing.JButton();
        btnB1 = new javax.swing.JButton();
        bnt28 = new javax.swing.JButton();
        bnt29 = new javax.swing.JButton();
        bnt27 = new javax.swing.JButton();
        lblTitulo26 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        btnBorrar2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtFecha2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo5.setText("Repita Clave");
        jPanel2.add(lblTitulo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 90, 20));

        lblTitulo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo9.setText("Nombre");
        jPanel2.add(lblTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTitulo10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo10.setText("Nomb. Usuario");
        jPanel2.add(lblTitulo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 90, 20));

        lblTitulo11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo11.setText("Apellido");
        jPanel2.add(lblTitulo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 20));

        lblTitulo12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo12.setText("Clave");
        jPanel2.add(lblTitulo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo14.setText("Creado");
        jPanel2.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 80, 20));

        txtNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, -1));

        txtUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 170, -1));

        txtApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 170, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        jButton3.setText("Borrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 100, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 100, 30));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_success.png"))); // NOI18N
        jButton7.setText("Ingresar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 100, 30));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setText("Cedula");
        jPanel2.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        txtCedula.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        jPanel2.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 170, -1));

        txtPin.setEditable(false);
        jPanel2.add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 40, -1));
        jPanel2.add(txtClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, -1));
        jPanel2.add(txtClave2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 170, -1));

        btn3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel2.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 40, 20));

        btn1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel2.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 40, 20));

        btn2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel2.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 40, 20));

        btn4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel2.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 40, 20));

        btn5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel2.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, 20));

        btn6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel2.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 40, 20));

        btnB.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnB.setText("C");
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });
        jPanel2.add(btnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 40, 20));

        btn8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel2.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 40, 20));

        btn9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn9.setText("9");
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel2.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 40, 20));

        btn7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel2.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 40, 20));

        lblTitulo19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo19.setText("Pin Seguridad");
        jPanel2.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 20));

        txtFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha.setEnabled(false);
        jPanel2.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 170, 20));

        jTabbedPane1.addTab("Nuevo", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo13.setText("Repita Clave");
        jPanel4.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 90, 20));

        lblTitulo20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo20.setText("Nombre");
        jPanel4.add(lblTitulo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 20));

        lblTitulo21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo21.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo21.setText("Nomb. Usuario");
        jPanel4.add(lblTitulo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 90, 20));

        lblTitulo22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo22.setText("Apellido");
        jPanel4.add(lblTitulo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, 20));

        lblTitulo23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo23.setText("Clave");
        jPanel4.add(lblTitulo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 20));

        lblTitulo24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo24.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo24.setText("Utlimo Acceso");
        jPanel4.add(lblTitulo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 120, 20));

        txtNombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNombre2.setEnabled(false);
        txtNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombre2KeyTyped(evt);
            }
        });
        jPanel4.add(txtNombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 170, -1));

        txtUsuario2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtUsuario2.setEnabled(false);
        jPanel4.add(txtUsuario2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 170, -1));

        txtApellido2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtApellido2.setEnabled(false);
        txtApellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellido2KeyTyped(evt);
            }
        });
        jPanel4.add(txtApellido2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 170, -1));

        lblTitulo25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo25.setText("Cedula");
        jPanel4.add(lblTitulo25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 20));

        txtCedula2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCedula2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedula2KeyTyped(evt);
            }
        });
        jPanel4.add(txtCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 140, -1));

        txtPin2.setEditable(false);
        jPanel4.add(txtPin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 40, -1));

        txtClave21.setEnabled(false);
        txtClave21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClave21KeyTyped(evt);
            }
        });
        jPanel4.add(txtClave21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 170, -1));

        txtClave22.setEnabled(false);
        txtClave22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClave22KeyTyped(evt);
            }
        });
        jPanel4.add(txtClave22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 170, -1));

        bnt23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt23.setText("3");
        bnt23.setEnabled(false);
        bnt23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt23ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 40, 20));

        bnt21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt21.setText("1");
        bnt21.setEnabled(false);
        bnt21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt21ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt21, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 40, 20));

        bnt22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt22.setText("2");
        bnt22.setEnabled(false);
        bnt22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt22ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 40, 20));

        bnt24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt24.setText("4");
        bnt24.setEnabled(false);
        bnt24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt24ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt24, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 40, 20));

        bnt25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt25.setText("5");
        bnt25.setEnabled(false);
        bnt25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt25ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt25, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 40, 20));

        bnt26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt26.setText("6");
        bnt26.setEnabled(false);
        bnt26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt26ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt26, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 40, 20));

        btnB1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnB1.setText("C");
        btnB1.setEnabled(false);
        btnB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnB1ActionPerformed(evt);
            }
        });
        jPanel4.add(btnB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 40, 20));

        bnt28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt28.setText("8");
        bnt28.setEnabled(false);
        bnt28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt28ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt28, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 40, 20));

        bnt29.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt29.setText("9");
        bnt29.setEnabled(false);
        bnt29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt29ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt29, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 40, 20));

        bnt27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        bnt27.setText("7");
        bnt27.setEnabled(false);
        bnt27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnt27ActionPerformed(evt);
            }
        });
        jPanel4.add(bnt27, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 40, 20));

        lblTitulo26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo26.setText("Pin Seguridad");
        jPanel4.add(lblTitulo26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 90, 20));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497312816_edit-find-replace.png"))); // NOI18N
        jButton8.setText("Editar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 100, 30));

        btnBorrar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        btnBorrar2.setText("Borrar");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });
        jPanel4.add(btnBorrar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 100, 30));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497313212_trash.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 100, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 100, 30));

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
        jPanel4.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 30, 20));

        txtFecha2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtFecha2.setEnabled(false);
        jPanel4.add(txtFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 170, 20));

        jTabbedPane1.addTab("Modificar", jPanel4);

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

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
if (getPass().length() < 4) {
            txtPin.setText(getPass() + "3");
        } else {
            BloquearPin(1);
        }  
    }//GEN-LAST:event_btn3ActionPerformed

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

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
txtPin.setText("");
        BloquearPin(2);
    }//GEN-LAST:event_btnBActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
if (getPass().length() < 4) {
            txtPin.setText(getPass() + "8");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
if (getPass().length() < 4) {
            txtPin.setText(getPass() + "9");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
if (getPass().length() < 4) {
            txtPin.setText(getPass() + "7");
        } else {
            BloquearPin(1);
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void bnt23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt23ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "3");
        } else {
            BloquearPin(3);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bnt23ActionPerformed

    private void bnt21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt21ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "1");
        } else {
            BloquearPin(3);
        }
    }//GEN-LAST:event_bnt21ActionPerformed

    private void bnt22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt22ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "2");
        } else {
            BloquearPin(3);
        }
    }//GEN-LAST:event_bnt22ActionPerformed

    private void bnt24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt24ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "4");
        } else {
            BloquearPin(3);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bnt24ActionPerformed

    private void bnt25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt25ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "5");
        } else {
            BloquearPin(3);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bnt25ActionPerformed

    private void bnt26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt26ActionPerformed
 if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "6");
        } else {
            BloquearPin(3);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_bnt26ActionPerformed

    private void btnB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnB1ActionPerformed
txtPin2.setText("");
        BloquearPin(4);
    }//GEN-LAST:event_btnB1ActionPerformed

    private void bnt28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt28ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "8");
        } else {
            BloquearPin(3);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_bnt28ActionPerformed

    private void bnt29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt29ActionPerformed
 if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "9");
        } else {
            BloquearPin(3);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_bnt29ActionPerformed

    private void bnt27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnt27ActionPerformed
if (getPass2().length() < 4) {
            txtPin2.setText(getPass2() + "7");
        } else {
            BloquearPin(3);
        }         // TODO add your handling code here:
    }//GEN-LAST:event_bnt27ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    if (Verificacion2()) {
            char[] arrayC1 = txtClave21.getPassword();
            String c1 = new String(arrayC1);
            char[] arrayC2 = txtClave22.getPassword();
            String c2 = new String(arrayC2);
            char[] arrayC3 = txtPin2.getPassword();
            String c3 = new String(arrayC3);
            try {
                String sql = "update usuarios set nomtra=?, apetra=?, nomusu=?, clausu=?,"
                        + "pinusu=? where cedtra = '" + txtCedula2.getText() + "'";

                PreparedStatement ps = acciones.Actualizar(sql);
                ps.setString(1, txtNombre2.getText().toLowerCase());
                ps.setString(2, txtApellido2.getText().toLowerCase());
                ps.setString(3, txtUsuario2.getText());
                ps.setString(4, c1);
                ps.setInt(5, Integer.parseInt(c3));
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Datos actualizados correctamente", "Informacion",
                            JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Habilitar2();
                    txtCedula2.setText("");
                    txtCedula2.setEnabled(true);
                    this.Borrar3();
                }
                acciones.conn.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al actualizar datos " + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, new javax.swing.ImageIcon(getClass().getResource("/PImagenes/error.png")));
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
if (txtCedula2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo Cedula Vacio",
                        "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
        } else {
        int seleccion = JOptionPane.showOptionDialog(
   null,
   "¿Esta seguro que dese Borrar los datos del Usuario "+txtNombre2.getText()+" "+txtApellido2.getText() +"?", 
   "Advertencia",
   JOptionPane.YES_NO_OPTION,
   JOptionPane.QUESTION_MESSAGE,
   null,    // null para icono por defecto.
   new Object[] { "Si", "No" },   // null para YES, NO y CANCEL
   "No");
    if (seleccion == 0) {
        try {
            String sql = "delete from usuarios where cedtra='" + txtCedula2.getText() + "'";
            Statement st = acciones.Eliminar(sql);
            int n = st.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente del sistema", "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                this.Borrar2();
                this.Habilitar2();
            }
            acciones.conn.close();
        }catch (SQLException e) {
                // error clave dependiente y muestro mensaje 
                if (e.getSQLState().equals("23503")) {
                    JOptionPane.showMessageDialog(null, "El usuario esta relacionado a una venta por tanto no puede ser Eliminado",
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }else{
                    JOptionPane.showMessageDialog(null, "Error al guardar usuario\nCodigo error:" + e.getMessage(),
                        "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            }
    }
}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (Verificacion1()) {
            char[] arrayC1 = txtClave.getPassword();
            String c1 = new String(arrayC1);
            char[] arrayC2 = txtClave2.getPassword();
            String c2 = new String(arrayC2);
            char[] arrayC3 = txtPin.getPassword();
            String c3 = new String(arrayC3);
            
            try {
                String sql = "insert into usuarios(nomtra, apetra, nomusu, clausu,"
                        + "pinusu, feccre, fecult, horult, cedtra) values(?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = acciones.Ingresar(sql);
                ps.setString(1, txtNombre.getText().toLowerCase());
                ps.setString(2, txtApellido.getText().toLowerCase());
                ps.setString(3, txtUsuario.getText());
                ps.setString(4, c1);
                ps.setInt(5, Integer.parseInt(c3));
                ps.setString(6, txtFecha.getText());
                ps.setString(7, txtFecha.getText());
                ps.setString(8, LlenarHora());
                ps.setString(9,txtCedula.getText());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario Creado con exito",
                            "Informacion", JOptionPane.PLAIN_MESSAGE, iconCorrecto);
                    this.Borrar();
                }

                //Cambie Exception por SQLException para poder controlar el error
            } catch (SQLException e) {
                
                System.out.println("Código de Error: " + e.getErrorCode() + "\n" +
                "SLQState: " + e.getSQLState() + "\n" +
                "Mensaje: " + e.getMessage() + "\n");
                
                // error clave primaria duplicada y muestro mensaje 
                if (e.getSQLState().equals("23505")) {
                    JOptionPane.showMessageDialog(null, "Ya existe un cliente vinculado a el numero de cedula o nombre de usuario ingresado",
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar cliente\nCodigo error:" + e.getMessage(),
                            "Error", JOptionPane.PLAIN_MESSAGE, iconError);
                }
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.Borrar();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
                this.Borrar3();
                int codigo = 0;
                String cedula = this.txtCedula2.getText();
                try {
                    String sql = "select * from usuarios where cedtra = '" + cedula + "'";
                    ResultSet rs = acciones.Consultar(sql);
                    while (rs.next()) {
                        resultado = true;
                        this.Habilitar1();
                        txtNombre2.setText(rs.getString("nomtra"));
                        txtApellido2.setText(rs.getString("apetra"));
                        txtUsuario2.setText(rs.getString("nomusu"));
                        txtFecha2.setText(rs.getString("fecult")+"-"+rs.getString("horult"));
                        txtClave21.setText(rs.getString("clausu"));
                        txtClave22.setText(rs.getString("clausu"));
                        txtPin2.setText(String.valueOf(rs.getInt("pinusu")));
                    }
                    if (resultado == false) {
                        JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda", "Advertencia",
                            JOptionPane.PLAIN_MESSAGE, iconAd);
                        this.Habilitar2();
                        txtCedula2.setText("");
                        txtCedula2.setEnabled(true);
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

    private void btnBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyTyped

    }//GEN-LAST:event_btnBuscarKeyTyped

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
this.Borrar3();
this.Habilitar2();
txtCedula2.setEnabled(true);// TODO add your handling code here:
txtCedula2.setText("");// TODO add your handling code here:
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
      
    }//GEN-LAST:event_txtCedulaKeyTyped

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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedula2KeyTyped

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
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellido2KeyTyped

    private void txtClave21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClave21KeyTyped
      char c = evt.getKeyChar();
      char[] arrayC1 = txtClave21.getPassword();
            String c1 = new String(arrayC1);
            int lim = c1.length();
            //cambie este numero que es el limite
            if (lim >= 15) {
                evt.consume();
                getToolkit().beep();
            }
        
    }//GEN-LAST:event_txtClave21KeyTyped

    private void txtClave22KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClave22KeyTyped
      char[] arrayC1 = txtClave22.getPassword();
            String c1 = new String(arrayC1);
            int lim = c1.length();
            //cambie este numero que es el limite
            if (lim >= 15) {
                evt.consume();
                getToolkit().beep();
            }
    }//GEN-LAST:event_txtClave22KeyTyped

    /**
     * @param args the command line arguments
     */
    private boolean Verificacion1() {
        //verifico que no esten vacios
        if (txtNombre.getText().equals("") || txtApellido.getText().equals("")
                || txtCedula.getText().equals("") || txtCedula.getText().length() <= 4|| txtUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos no esten vacios y que la cedula tenga mas de 5 carecteres", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        } else {
            char[] arrayC1 = txtClave.getPassword();
            String c1 = new String(arrayC1);
            char[] arrayC2 = txtClave2.getPassword();
            String c2 = new String(arrayC2);
            char[] arrayC3 = txtPin.getPassword();
            String c3 = new String(arrayC3);
            if (c2.equals("") || (c1.equals("")) || c3.equals("")) {
                JOptionPane.showMessageDialog(null, "Claves o Pin estan vacios", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                return false;
            } else {
                if (!c2.equals(c1)) {
                    JOptionPane.showMessageDialog(null, "Las Claves no coinciden", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    public static void main(String args[]) {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnt21;
    private javax.swing.JButton bnt22;
    private javax.swing.JButton bnt23;
    private javax.swing.JButton bnt24;
    private javax.swing.JButton bnt25;
    private javax.swing.JButton bnt26;
    private javax.swing.JButton bnt27;
    private javax.swing.JButton bnt28;
    private javax.swing.JButton bnt29;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnB;
    private javax.swing.JButton btnB1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo10;
    private javax.swing.JLabel lblTitulo11;
    private javax.swing.JLabel lblTitulo12;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo14;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo20;
    private javax.swing.JLabel lblTitulo21;
    private javax.swing.JLabel lblTitulo22;
    private javax.swing.JLabel lblTitulo23;
    private javax.swing.JLabel lblTitulo24;
    private javax.swing.JLabel lblTitulo25;
    private javax.swing.JLabel lblTitulo26;
    private javax.swing.JLabel lblTitulo5;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCedula2;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JPasswordField txtClave2;
    private javax.swing.JPasswordField txtClave21;
    private javax.swing.JPasswordField txtClave22;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFecha2;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre2;
    private javax.swing.JPasswordField txtPin;
    private javax.swing.JPasswordField txtPin2;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuario2;
    // End of variables declaration//GEN-END:variables

    private void Borrar() {
txtNombre.setText("");
     txtApellido.setText("");
     txtUsuario.setText("");
     txtCedula.setText("");
     txtClave.setText("");
     txtClave2.setText("");
     txtPin.setText("");
    }
    
        private void Borrar2() {
txtNombre2.setText("");
     txtApellido2.setText("");
     txtUsuario2.setText("");
     txtCedula2.setText("");
     txtClave21.setText("");
     txtClave22.setText("");
     txtPin2.setText("");
    }

    private void Borrar3() {
     txtNombre2.setText("");
     txtApellido2.setText("");
     txtUsuario2.setText("");
     txtClave21.setText("");
     txtClave22.setText("");
     txtPin2.setText("");
     txtFecha2.setText("");
    }

    private void Habilitar2() {
     txtNombre2.setEnabled(false);
     txtApellido2.setEnabled(false);
     txtUsuario2.setEnabled(false);
     txtClave21.setEnabled(false);
     txtClave22.setEnabled(false);
     txtPin2.setEnabled(false);
     btnB1.setEnabled(false);
     bnt21.setEnabled(false);
     bnt22.setEnabled(false);
     bnt23.setEnabled(false);
     bnt24.setEnabled(false);
     bnt25.setEnabled(false);
     bnt26.setEnabled(false);
     bnt27.setEnabled(false);
     bnt28.setEnabled(false);
     bnt29.setEnabled(false);
    }

    private void Habilitar1() {
        btnB1.setEnabled(true);
     txtNombre2.setEnabled(true);
     txtApellido2.setEnabled(true);
     txtUsuario2.setEnabled(true);
     txtClave21.setEnabled(true);
     txtClave22.setEnabled(true);
     txtPin2.setEnabled(true);
     bnt21.setEnabled(true);
     bnt22.setEnabled(true);
     bnt23.setEnabled(true);
     bnt24.setEnabled(true);
     bnt25.setEnabled(true);
     bnt26.setEnabled(true);
     bnt27.setEnabled(true);
     bnt28.setEnabled(true);
     bnt29.setEnabled(true);
    }

    private boolean Verificacion2() {
        //verifico que no esten vacios
        if (txtNombre2.getText().equals("") || txtApellido2.getText().equals("")|| txtUsuario2.getText().equals("") ) {
            JOptionPane.showMessageDialog(null, "Verifique que los campos no esten vacios y que la cedula tenga mas de 5 carecteres", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
            return false;
        } else {
            char[] arrayC1 = txtClave21.getPassword();
            String c1 = new String(arrayC1);
            char[] arrayC2 = txtClave22.getPassword();
            String c2 = new String(arrayC2);
            char[] arrayC3 = txtPin2.getPassword();
            String c3 = new String(arrayC3);
            if (c2.equals("") || (c1.equals("")) || c3.equals("")) {
                JOptionPane.showMessageDialog(null, "Claves o Pin estan vacios", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                return false;
            } else {
                if (!c2.equals(c1)) {
                    JOptionPane.showMessageDialog(null, "Las Claves no coinciden", "Advertencia", JOptionPane.PLAIN_MESSAGE, iconAd);
                    return false;
                } else {
                    return true;
                }
            }
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
