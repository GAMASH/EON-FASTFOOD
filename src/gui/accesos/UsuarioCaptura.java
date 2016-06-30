/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accesos;

import abstractt.visual.InternalFrameAbstracto;
import domain.tabla.Usuario;

/**
 *
 * @author sperez
 */
public class UsuarioCaptura extends InternalFrameAbstracto {

    public Usuario usuario;
    
    /**
     * Creates new form UsuarioCaptura
     */
    public UsuarioCaptura() {
        initComponents();
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
        textField1 = new abstractt.visual.TextField();
        textField2 = new abstractt.visual.TextField();
        personaPanel1 = new gui.accesos.PersonaPanel();
        boton1 = new abstractt.visual.Boton();
        boton2 = new abstractt.visual.Boton();

        setBackground(new java.awt.Color(102, 204, 255));
        setTitle("Captura Usuario");
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Login:");

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Password:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(textField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panel1);
        panel1.setBounds(11, 223, 308, 67);
        getContentPane().add(personaPanel1);
        personaPanel1.setBounds(0, 0, 831, 301);

        boton1.setText("Aceptar");
        getContentPane().add(boton1);
        boton1.setBounds(175, 303, 144, 39);

        boton2.setText("Cancelar");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        getContentPane().add(boton2);
        boton2.setBounds(435, 302, 144, 39);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Boton boton1;
    private abstractt.visual.Boton boton2;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Panel panel1;
    private gui.accesos.PersonaPanel personaPanel1;
    private abstractt.visual.TextField textField1;
    private abstractt.visual.TextField textField2;
    // End of variables declaration//GEN-END:variables
}