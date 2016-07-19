/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accesos;

import abstractt.visual.InternalFrameAbstracto;
import static domain.General.mensaje;
import java.awt.Color;
import javax.swing.BorderFactory;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Developer GAGS
 */
public class CambioPassword extends InternalFrameAbstracto {

    public String password_actual;
    public String password_nueva;
    public boolean password_anterior_erronea = false;
    public boolean password_nva_erronea = false;

    /**
     * Creates new form CambioPassword
     */
    public CambioPassword() {

        initComponents();
    }

    public void valida_password_actual() {

        String pass;

        pass = tf_pass_ant.getText();

        if (!pass.equals(password_actual)) {

            password_anterior_erronea = true;
        } else {

            password_anterior_erronea = false;
        }

        if (password_anterior_erronea) {

            tf_pass_ant.setBorder(BorderFactory.createLineBorder(Color.RED));
            this.tf_pass_nva.setEnabled(false);
            this.tf_pass_nva_2.setEnabled(false);
        } else {

            tf_pass_ant.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            this.tf_pass_nva.setEnabled(true);
            this.tf_pass_nva_2.setEnabled(true);
        }
        
        valida_password_nueva();
    }

    public void valida_password_nueva() {

        String pass_nva;
        String pass_nva_2;

        pass_nva = tf_pass_nva.getText();
        pass_nva_2 = tf_pass_nva_2.getText();

        if (!pass_nva.equals(pass_nva_2) || pass_nva.equals("")) {

            password_nva_erronea = true;
        } else {

            password_nva_erronea = false;
        }

        if (password_nva_erronea) {

            tf_pass_nva_2.setBorder(BorderFactory.createLineBorder(Color.RED));
        } else {

            tf_pass_nva_2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            password_nueva = pass_nva_2;
        }

    }
    
    public void cancelar(){
        
        password_nueva = "";
        this.setVisible(false);
    }
    
    public void aceptar(){
        
        if(password_nva_erronea){
            
            mensaje("La contraseña no es correcta");
            
            return;
        }
        
        this.setVisible(false);
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        
        cancelar();              
    }

    /**
     * @return the password_actual
     */
    public String getPassword_actual() {
        return password_actual;
    }

    /**
     * @param password_actual the password_actual to set
     */
    public void setPassword_actual(String password_actual) {
        
        this.password_actual = password_actual;

        if (!password_actual.equals("") ) {

            this.tf_pass_ant.setEnabled(true);
            this.tf_pass_ant.requestFocus();

            this.tf_pass_nva.setEnabled(false);
            this.tf_pass_nva_2.setEnabled(false);
        }else{
            
            this.tf_pass_ant.setEnabled(false);
            this.tf_pass_nva.requestFocus();
        }
        
        tf_pass_ant.setText("");
        tf_pass_nva.setText("");
        tf_pass_nva_2.setText("");        
    }

    /**
     * @return the password_nueva
     */
    public String getPassword_nueva() {
        return password_nueva;
    }

    /**
     * @param password_nueva the password_nueva to set
     */
    public void setPassword_nueva(String password_nueva) {
        this.password_nueva = password_nueva;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new abstractt.visual.Panel();
        label1 = new abstractt.visual.Label();
        label2 = new abstractt.visual.Label();
        boton1 = new abstractt.visual.Boton();
        boton2 = new abstractt.visual.Boton();
        label3 = new abstractt.visual.Label();
        tf_pass_ant = new abstractt.visual.TextFieldPassword();
        tf_pass_nva = new abstractt.visual.TextFieldPassword();
        tf_pass_nva_2 = new abstractt.visual.TextFieldPassword();

        setTitle("Asignación/ Cambio Contraseña");

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Repite la Contraseña");

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Nueva Contraseña");

        boton1.setText("Aceptar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });

        boton2.setText("Cancelar");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });

        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("Contraseña anterior");

        tf_pass_ant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pass_antActionPerformed(evt);
            }
        });
        tf_pass_ant.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pass_antKeyReleased(evt);
            }
        });

        tf_pass_nva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pass_nvaActionPerformed(evt);
            }
        });
        tf_pass_nva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pass_nvaKeyReleased(evt);
            }
        });

        tf_pass_nva_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_pass_nva_2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_pass_nva, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_pass_ant, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_pass_nva_2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pass_ant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pass_nva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_pass_nva_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
       aceptar();
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        cancelar();
    }//GEN-LAST:event_boton2ActionPerformed

    private void tf_pass_antKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pass_antKeyReleased

        this.valida_password_actual();
    }//GEN-LAST:event_tf_pass_antKeyReleased

    private void tf_pass_nva_2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pass_nva_2KeyReleased
        this.valida_password_nueva();
    }//GEN-LAST:event_tf_pass_nva_2KeyReleased

    private void tf_pass_nvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_pass_nvaKeyReleased
        this.valida_password_nueva();
    }//GEN-LAST:event_tf_pass_nvaKeyReleased

    private void tf_pass_antActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pass_antActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_pass_antActionPerformed

    private void tf_pass_nvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pass_nvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_pass_nvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Boton boton1;
    private abstractt.visual.Boton boton2;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Label label3;
    private abstractt.visual.Panel panel1;
    private javax.swing.JPasswordField tf_pass_ant;
    private javax.swing.JPasswordField tf_pass_nva;
    private javax.swing.JPasswordField tf_pass_nva_2;
    // End of variables declaration//GEN-END:variables

}
