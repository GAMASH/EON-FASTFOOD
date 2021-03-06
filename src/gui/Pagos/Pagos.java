/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Pagos;

import abstractt.visual.InternalFrameAbstracto;
import domain.tabla.Pago;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author Developer GAGS
 */
public class Pagos extends InternalFrameAbstracto {

    public Pago pago;

    /**
     * Creates new form PagosComanda
     */
    public Pagos() {
        
        initComponents();
    }

    /**
     * 
     * @param aPago 
     */
    public void setPago(Pago aPago) {

        pago = aPago;

        this.pagosPanel1.setPago(pago);
    }

    /**
     * @return the pago
     */
    public Pago getPago() {

        return pago;
    }

    /**
     * 
     * @return 
     */
    public int cerrar() {

        return 0;
    }
    
    /**
     * 
     */
    public void grabar(){
       if(this.pagosPanel1.grabar()){
           setVisible(false);
       }
    }

    /**
     * 
     * @param e 
     */
    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

        if (cerrar() != 1) {

            this.dispose();
        } else {

            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
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

        panel1 = new abstractt.visual.Panel();
        pagosPanel1 = new gui.Pagos.PagosPanel();
        boton1 = new abstractt.visual.Boton();
        boton2 = new abstractt.visual.Boton();

        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        setTitle("Realizar Pago");
        getContentPane().setLayout(new java.awt.CardLayout());

        pagosPanel1.setOpaque(false);

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

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pagosPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(pagosPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton2, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(boton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed

        internalFrameClosing(new InternalFrameEvent(this, 1));
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        grabar();
    }//GEN-LAST:event_boton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Boton boton1;
    private abstractt.visual.Boton boton2;
    private gui.Pagos.PagosPanel pagosPanel1;
    private abstractt.visual.Panel panel1;
    // End of variables declaration//GEN-END:variables

}
