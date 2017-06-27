/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PFormularios;

import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Navarro
 */
public class FPedidos extends javax.swing.JFrame {

    private int x;
    private int y;
private final ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/PImagenes/oie_canvas.png"));
   
    public FPedidos() {
        initComponents();
        setLocationRelativeTo(null);
        txtCodigo.setText(NumeroAleatorio());
    }
    public void setTitle(String title) {
        super.setTitle(title);
        lblTitulo.setText(title);
    }
    
    private void restaurarVentana() {
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
    
    public String NumeroAleatorio(){
    long numero = 0;
    Random rd=new Random();
    numero = rd.nextInt(99999999)+1;
    /*try {
        String sql = "select * from ventas where cod_venta= '"+numero+"'";
        ResultSet rs= operaciones.Consultar(sql);
        while(rs.next()){
        numero = Long.parseLong(this.NumeroAleatorio());
        }
    } catch (SQLException e) {
       JOptionPane.showMessageDialog(null, e.getMessage());    
    }*/
    return String.valueOf(numero);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        lblTitulo18 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        lblTitulo13 = new javax.swing.JLabel();
        lblTitulo14 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        lblTitulo9 = new javax.swing.JLabel();
        lblTitulo15 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        lblTitulo19 = new javax.swing.JLabel();
        lblTitulo20 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        lblTitulo35 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        lblTitulo32 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jTextField21 = new javax.swing.JTextField();
        lblTitulo27 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        lblTitulo16 = new javax.swing.JLabel();
        lblTitulo17 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        lblTitulo28 = new javax.swing.JLabel();
        lblTitulo29 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        lblTitulo30 = new javax.swing.JLabel();
        lblTitulo33 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        lblTitulo34 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        lblTitulo31 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Control de Acceso");
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
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 0, 30, 30));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/minimizar.png"))); // NOI18N
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 30, 30));

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jPanel3.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jLabel1.setBackground(new java.awt.Color(255, 102, 0));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(1);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 650, 130));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton5.setText("Salir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 100, 30));

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497379748_edit-clear.png"))); // NOI18N
        jButton9.setText("Borrar");
        jPanel1.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 100, 30));

        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 130, -1));

        lblTitulo18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo18.setText("Cedula/RIF");
        jPanel1.add(lblTitulo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 20));

        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField7.setEnabled(false);
        jPanel1.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 120, -1));

        lblTitulo13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo13.setText("Nombre");
        jPanel1.add(lblTitulo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 50, 20));

        lblTitulo14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo14.setText("Apellido");
        jPanel1.add(lblTitulo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 60, 20));

        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField16.setEnabled(false);
        jPanel1.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 130, -1));

        lblTitulo9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo9.setText("Descripcion Detallada:");
        jPanel1.add(lblTitulo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        lblTitulo15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo15.setText("Fecha");
        jPanel1.add(lblTitulo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 20));

        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 90, -1));

        lblTitulo19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo19.setText("Cantidad Productos");
        jPanel1.add(lblTitulo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 130, 20));

        lblTitulo20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo20.setText("Precio Total");
        jPanel1.add(lblTitulo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 80, 20));

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 90, -1));

        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField13.setEnabled(false);
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 120, -1));

        lblTitulo35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo35.setText("Fecha Entrega");
        jPanel1.add(lblTitulo35, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, 20));

        jTextField30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField30.setEnabled(false);
        jPanel1.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 130, -1));

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497479197_floppy_disk_save.png"))); // NOI18N
        jButton15.setText("Guardar");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 100, 30));

        lblTitulo32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo32.setText("Codigo del Pedido");
        jPanel1.add(lblTitulo32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, 20));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCodigo.setEnabled(false);
        jPanel1.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 90, -1));

        jTabbedPane1.addTab("Nuevo Pedido", jPanel1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0), 4));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/agt_action_fail.png"))); // NOI18N
        jButton12.setText("Salir");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 100, 30));

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497313212_trash.png"))); // NOI18N
        jButton13.setText("Eliminar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 100, 30));

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PImagenes/1497631492_edit.png"))); // NOI18N
        jButton14.setText("Editar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 100, 30));

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 120, -1));

        lblTitulo27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo27.setText("Cedula/RIF");
        jPanel4.add(lblTitulo27, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 70, 20));

        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField22.setEnabled(false);
        jPanel4.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 120, -1));

        lblTitulo16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo16.setText("Nombre");
        jPanel4.add(lblTitulo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 70, 20));

        lblTitulo17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo17.setText("Apellido");
        jPanel4.add(lblTitulo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 50, 20));

        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField23.setEnabled(false);
        jPanel4.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 150, -1));

        lblTitulo28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo28.setText("Descripcion del Pedido:");
        jPanel4.add(lblTitulo28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 20));

        lblTitulo29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo29.setText("Fecha");
        jPanel4.add(lblTitulo29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 40, 20));

        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField24.setEnabled(false);
        jPanel4.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 90, -1));

        lblTitulo30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo30.setText("Cantidad Productos");
        jPanel4.add(lblTitulo30, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 140, 20));

        lblTitulo33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo33.setText("Precio Total");
        jPanel4.add(lblTitulo33, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 80, 20));

        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField27.setEnabled(false);
        jPanel4.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 90, -1));

        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField28.setEnabled(false);
        jPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 130, -1));

        lblTitulo34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo34.setText("Fecha Entrega");
        jPanel4.add(lblTitulo34, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, -1, 20));

        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextField29.setEnabled(false);
        jPanel4.add(jTextField29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 120, -1));

        lblTitulo31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTitulo31.setText("Codigo del Pedido");
        jPanel4.add(lblTitulo31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 20));

        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel4.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 90, -1));

        jTextArea2.setColumns(1);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(1);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setEnabled(false);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 650, 130));

        jTabbedPane1.addTab("Consultar Pedidos", jPanel4);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 680, 360));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 470));

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

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged

    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
//  Para actulizar la consulta de pedidos en caso de que se inserte uno nuevo
        System.out.println(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTitulo13;
    private javax.swing.JLabel lblTitulo14;
    private javax.swing.JLabel lblTitulo15;
    private javax.swing.JLabel lblTitulo16;
    private javax.swing.JLabel lblTitulo17;
    private javax.swing.JLabel lblTitulo18;
    private javax.swing.JLabel lblTitulo19;
    private javax.swing.JLabel lblTitulo20;
    private javax.swing.JLabel lblTitulo27;
    private javax.swing.JLabel lblTitulo28;
    private javax.swing.JLabel lblTitulo29;
    private javax.swing.JLabel lblTitulo30;
    private javax.swing.JLabel lblTitulo31;
    private javax.swing.JLabel lblTitulo32;
    private javax.swing.JLabel lblTitulo33;
    private javax.swing.JLabel lblTitulo34;
    private javax.swing.JLabel lblTitulo35;
    private javax.swing.JLabel lblTitulo9;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}