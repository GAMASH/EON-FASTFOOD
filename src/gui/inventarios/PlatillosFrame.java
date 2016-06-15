/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.inventarios;

import abstractt.visual.InternalFrameAbstracto;
import domain.tabla.Articulo;
import domain.tabla.Platillo;
import static gui.Principal.escritorio;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author sperez
 */
public class PlatillosFrame extends InternalFrameAbstracto {

    /**
     * Creates new form ArticuloCaptura
     */
    public PlatillosFrame() {

        initComponents();
    }

    /**
     *
     */
    public void cargaValores() {

        Platillo.cargarFramePlatillo(table1);
    }

    public void nuevoPlatillo() {

        table1.agregarFila(jScrollPane1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new abstractt.visual.Table();
        jPanel1 = new javax.swing.JPanel();
        boton1 = new abstractt.visual.Boton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        m_recuperar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        m_cerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        m_nuevo = new javax.swing.JMenuItem();
        m_grabar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        m_eliminar = new javax.swing.JMenuItem();

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                table1FocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.setLayout(null);

        boton1.setText("Recuperar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        jPanel1.add(boton1);
        boton1.setBounds(0, 0, 90, 23);

        jMenu1.setText("Archivo");

        m_recuperar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        m_recuperar.setText("Recuperar Información");
        m_recuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_recuperarActionPerformed(evt);
            }
        });
        jMenu1.add(m_recuperar);
        jMenu1.add(jSeparator1);

        m_cerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        m_cerrar.setText("Cerrar");
        m_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_cerrarActionPerformed(evt);
            }
        });
        jMenu1.add(m_cerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edición");

        m_nuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        m_nuevo.setText("Nuevo");
        m_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_nuevoActionPerformed(evt);
            }
        });
        jMenu2.add(m_nuevo);

        m_grabar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        m_grabar.setText("Grabar");
        m_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_grabarActionPerformed(evt);
            }
        });
        jMenu2.add(m_grabar);
        jMenu2.add(jSeparator2);

        m_eliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        m_eliminar.setText("Eliminar");
        jMenu2.add(m_eliminar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void m_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_nuevoActionPerformed

        nuevoPlatillo();

    }//GEN-LAST:event_m_nuevoActionPerformed
    /**
     *
     * @param evt
     */
    private void table1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_table1FocusGained

    }//GEN-LAST:event_table1FocusGained

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton1ActionPerformed

    private void m_recuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_recuperarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_m_recuperarActionPerformed

    private void m_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_cerrarActionPerformed
        dispose();
    }//GEN-LAST:event_m_cerrarActionPerformed

    private void m_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_grabarActionPerformed
        table1.grabar();
    }//GEN-LAST:event_m_grabarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Boton boton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem m_cerrar;
    private javax.swing.JMenuItem m_eliminar;
    private javax.swing.JMenuItem m_grabar;
    private javax.swing.JMenuItem m_nuevo;
    private javax.swing.JMenuItem m_recuperar;
    private abstractt.visual.Table table1;
    // End of variables declaration//GEN-END:variables
}
