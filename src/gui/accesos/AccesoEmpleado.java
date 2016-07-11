/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accesos;

import abstractt.visual.InternalFrameAbstracto;
import static domain.General.mensaje;
import domain.tabla.Empleado;
import domain.tabla.TipoEmpleado;
import domain.tabla.Usuario;

/**
 *
 * @author Developer GAGS
 */
public class AccesoEmpleado extends InternalFrameAbstracto {

    public Empleado empleado;
    TipoEmpleado tipoEmpleado;

    public AccesoEmpleado() {

        initComponents();
        empleado = new Empleado();

    }

    /**
     * 
     */
    public void acceder() {

        String password;

        this.empleado.usuario.cargarPorLogin(UsuarioSelector.getSelectedItem().toString());

        this.empleado.obtenerPorUsuario(empleado.usuario.id_usuario);

        password = this.textFieldPassword1.getText();

        if (!empleado.usuario.password.equals(password)) {

            mensaje("Contraseña incorrecta");
            empleado = new Empleado();
            return;
        }

        if (!empleado.tipo_empleado.id_tipo_empleado.equals(tipoEmpleado.id_tipo_empleado)) {

            mensaje("El usuario no es " + tipoEmpleado.descripcion);
            empleado = new Empleado();
            return;
        }

        setVisible(false);

    }

    /**
     * 
     * @param tipoEmpleado 
     */
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {

        this.tipoEmpleado = tipoEmpleado;
        this.UsuarioSelector.setTablaBD(new Usuario());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNINrG: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new abstractt.visual.Panel();
        boton1 = new abstractt.visual.Boton();
        boton2 = new abstractt.visual.Boton();
        label1 = new abstractt.visual.Label();
        textFieldPassword1 = new abstractt.visual.TextFieldPassword();
        label2 = new abstractt.visual.Label();
        UsuarioSelector = new abstractt.visual.TablaBDSelector();

        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        setTitle("Acceso Usuario");

        panel1.setBackground(new java.awt.Color(240, 240, 240));

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

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Usuario:");

        textFieldPassword1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textFieldPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldPassword1ActionPerformed(evt);
            }
        });

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Password:");

        UsuarioSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioSelectorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UsuarioSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsuarioSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed

        acceder();
    }//GEN-LAST:event_boton1ActionPerformed

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_boton2ActionPerformed

    private void textFieldPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldPassword1ActionPerformed
        acceder();
    }//GEN-LAST:event_textFieldPassword1ActionPerformed

    private void UsuarioSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioSelectorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.TablaBDSelector UsuarioSelector;
    private abstractt.visual.Boton boton1;
    private abstractt.visual.Boton boton2;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Panel panel1;
    private abstractt.visual.TextFieldPassword textFieldPassword1;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param mesero
     */
    public void setEmpleado(Empleado mesero) {

        if (mesero.id_empleado.equals("")) {
            return;
        }

        UsuarioSelector.setTablaBD(mesero.usuario);
        UsuarioSelector.setEnabled(false);

    }

}
