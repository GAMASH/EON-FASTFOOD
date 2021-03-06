/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.inventarios;

import domain.tabla.ArticuloSucursal;

/**
 *
 * @author Developer GAGS
 */
public class ArticuloSucursalPanel extends javax.swing.JPanel {

    ArticuloSucursal articuloSucursal;
    
    /**
     * Creates new form ArticuloSucursal
     */
    public ArticuloSucursalPanel() {
        
        initComponents();
        articuloSucursal = new ArticuloSucursal();        
    }
    
    public void setArticuloSucursal(ArticuloSucursal AarticuloSucursal){
        
        articuloSucursal   = AarticuloSucursal;  
        cargar();
    }
    
    public void cargar(){
        
        this.tf_costo_promedio.setText(articuloSucursal.costo_promedio.toString());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        tf_costo_promedio = new abstractt.visual.TextFieldMoneda();
        jLabel4 = new javax.swing.JLabel();
        tf_ultimo_costo = new abstractt.visual.TextFieldMoneda();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tf_margen_1 = new abstractt.visual.TextField();
        jLabel1 = new javax.swing.JLabel();
        tf_precio_1 = new abstractt.visual.TextFieldMoneda();
        jLabel5 = new javax.swing.JLabel();
        tf_margen_2 = new abstractt.visual.TextField();
        jLabel6 = new javax.swing.JLabel();
        tf_precio_2 = new abstractt.visual.TextFieldMoneda();
        tf_precio_3 = new abstractt.visual.TextFieldMoneda();
        jLabel7 = new javax.swing.JLabel();
        tf_margen_3 = new abstractt.visual.TextField();
        jLabel8 = new javax.swing.JLabel();
        tf_precio_4 = new abstractt.visual.TextFieldMoneda();
        jLabel9 = new javax.swing.JLabel();
        tf_margen_4 = new abstractt.visual.TextField();
        jLabel10 = new javax.swing.JLabel();
        tf_precio_5 = new abstractt.visual.TextFieldMoneda();
        jLabel11 = new javax.swing.JLabel();
        tf_margen_5 = new abstractt.visual.TextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_existencia = new abstractt.visual.TextField();
        jLabel14 = new javax.swing.JLabel();
        tf_promedio_venta = new abstractt.visual.TextField();
        jLabel15 = new javax.swing.JLabel();
        tf_maximo = new abstractt.visual.TextField();
        jLabel16 = new javax.swing.JLabel();
        tf_minimo = new abstractt.visual.TextField();

        setLayout(null);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Ultimo costo");
        add(jLabel3);
        jLabel3.setBounds(10, 100, 70, 20);
        add(tf_costo_promedio);
        tf_costo_promedio.setBounds(270, 100, 90, 22);

        jLabel4.setText("Costo promedio");
        add(jLabel4);
        jLabel4.setBounds(190, 100, 80, 20);

        tf_ultimo_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ultimo_costoActionPerformed(evt);
            }
        });
        add(tf_ultimo_costo);
        tf_ultimo_costo.setBounds(90, 100, 90, 22);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Precios"));
        jPanel1.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("margen 1");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 20, 60, 20);

        tf_margen_1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_margen_1.setText("0.0");
        tf_margen_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_margen_1ActionPerformed(evt);
            }
        });
        jPanel1.add(tf_margen_1);
        tf_margen_1.setBounds(80, 20, 90, 21);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Precio 1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(200, 20, 50, 20);
        jPanel1.add(tf_precio_1);
        tf_precio_1.setBounds(260, 20, 90, 22);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("margen 2");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 50, 60, 20);

        tf_margen_2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_margen_2.setText("0.0");
        tf_margen_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_margen_2ActionPerformed(evt);
            }
        });
        jPanel1.add(tf_margen_2);
        tf_margen_2.setBounds(80, 50, 90, 21);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Precio 2");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(200, 50, 50, 20);
        jPanel1.add(tf_precio_2);
        tf_precio_2.setBounds(260, 50, 90, 22);
        jPanel1.add(tf_precio_3);
        tf_precio_3.setBounds(260, 80, 90, 22);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("margen 3");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 80, 60, 20);

        tf_margen_3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_margen_3.setText("0.0");
        tf_margen_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_margen_3ActionPerformed(evt);
            }
        });
        jPanel1.add(tf_margen_3);
        tf_margen_3.setBounds(80, 80, 90, 21);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Precio 3");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(200, 80, 50, 20);
        jPanel1.add(tf_precio_4);
        tf_precio_4.setBounds(260, 110, 90, 22);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("margen 4");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 110, 60, 20);

        tf_margen_4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_margen_4.setText("0.0");
        tf_margen_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_margen_4ActionPerformed(evt);
            }
        });
        jPanel1.add(tf_margen_4);
        tf_margen_4.setBounds(80, 110, 90, 21);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Precio 4");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(200, 110, 50, 20);
        jPanel1.add(tf_precio_5);
        tf_precio_5.setBounds(260, 140, 90, 22);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("margen 5");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(10, 140, 60, 20);

        tf_margen_5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_margen_5.setText("0.0");
        tf_margen_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_margen_5ActionPerformed(evt);
            }
        });
        jPanel1.add(tf_margen_5);
        tf_margen_5.setBounds(80, 140, 90, 21);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Precio 5");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(200, 140, 50, 20);

        add(jPanel1);
        jPanel1.setBounds(10, 130, 370, 170);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Existencia");
        add(jLabel13);
        jLabel13.setBounds(20, 10, 60, 20);

        tf_existencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_existencia.setText("0.0");
        tf_existencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_existenciaActionPerformed(evt);
            }
        });
        add(tf_existencia);
        tf_existencia.setBounds(90, 10, 90, 21);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("Promedio venta");
        add(jLabel14);
        jLabel14.setBounds(180, 10, 80, 20);

        tf_promedio_venta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_promedio_venta.setText("0.0");
        tf_promedio_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_promedio_ventaActionPerformed(evt);
            }
        });
        add(tf_promedio_venta);
        tf_promedio_venta.setBounds(270, 10, 90, 21);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("Maximo");
        add(jLabel15);
        jLabel15.setBounds(20, 40, 60, 20);

        tf_maximo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_maximo.setText("0.0");
        tf_maximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_maximoActionPerformed(evt);
            }
        });
        add(tf_maximo);
        tf_maximo.setBounds(90, 40, 90, 21);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Minimo");
        add(jLabel16);
        jLabel16.setBounds(20, 70, 60, 20);

        tf_minimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_minimo.setText("0.0");
        tf_minimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_minimoActionPerformed(evt);
            }
        });
        add(tf_minimo);
        tf_minimo.setBounds(90, 70, 90, 21);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_margen_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_margen_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_margen_1ActionPerformed

    private void tf_margen_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_margen_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_margen_2ActionPerformed

    private void tf_margen_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_margen_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_margen_3ActionPerformed

    private void tf_margen_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_margen_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_margen_4ActionPerformed

    private void tf_margen_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_margen_5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_margen_5ActionPerformed

    private void tf_existenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_existenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_existenciaActionPerformed

    private void tf_promedio_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_promedio_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_promedio_ventaActionPerformed

    private void tf_maximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_maximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_maximoActionPerformed

    private void tf_minimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_minimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_minimoActionPerformed

    private void tf_ultimo_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ultimo_costoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ultimo_costoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private abstractt.visual.TextFieldMoneda tf_costo_promedio;
    private abstractt.visual.TextField tf_existencia;
    private abstractt.visual.TextField tf_margen_1;
    private abstractt.visual.TextField tf_margen_2;
    private abstractt.visual.TextField tf_margen_3;
    private abstractt.visual.TextField tf_margen_4;
    private abstractt.visual.TextField tf_margen_5;
    private abstractt.visual.TextField tf_maximo;
    private abstractt.visual.TextField tf_minimo;
    private abstractt.visual.TextFieldMoneda tf_precio_1;
    private abstractt.visual.TextFieldMoneda tf_precio_2;
    private abstractt.visual.TextFieldMoneda tf_precio_3;
    private abstractt.visual.TextFieldMoneda tf_precio_4;
    private abstractt.visual.TextFieldMoneda tf_precio_5;
    private abstractt.visual.TextField tf_promedio_venta;
    private abstractt.visual.TextFieldMoneda tf_ultimo_costo;
    // End of variables declaration//GEN-END:variables
}
