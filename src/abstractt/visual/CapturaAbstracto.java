/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt.visual;

import abstractt.TablaBD;
import gui.inventarios.*;
import abstractt.visual.InternalFrameAbstracto;
import abstractt.visual.Panel;
import domain.tabla.Articulo;
import domain.tabla.ArticuloProveedor;
import domain.tabla.ArticuloSucursal;
import static gui.Principal.escritorio;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Developer GAGS
 */
public class CapturaAbstracto extends InternalFrameAbstracto {

    public TablaBD tablaBD;
    public Dimension d;

    /**
     * Creates new form Articulos
     */
    public CapturaAbstracto() {

        initComponents();
    }

    public void setTablaBD(TablaBD tablaBD) {

        this.tablaBD = tablaBD;
    }  
    
    public void Dimensionar() {

       // this.setSize(d);
        
        d.height = 54;
        d.width = 109;
        setSize(d);
    }

    public void cargar() {
        System.out.println("CapturaAbstracto.cargar funcion no implementada");
    }

    public void grabar() {
        System.out.println("CapturaAbstracto.grabar funcion no implementada");

    }

    public void eliminar() {
        System.out.println("CapturaAbstracto.eliminar funcion no implementada");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new Panel();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_archivo = new javax.swing.JMenu();
        m_grabar = new javax.swing.JMenuItem();
        m_eliminar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        m_cerrar = new javax.swing.JMenuItem();

        setTitle("Captura Abstracta");
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setLayout(null);
        getContentPane().add(jPanel3);

        m_archivo.setText("Archivo");

        m_grabar.setText("Grabar");
        m_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_grabarActionPerformed(evt);
            }
        });
        m_archivo.add(m_grabar);

        m_eliminar.setText("Eliminar");
        m_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_eliminarActionPerformed(evt);
            }
        });
        m_archivo.add(m_eliminar);
        m_archivo.add(jSeparator1);

        m_cerrar.setText("Cerrar");
        m_archivo.add(m_cerrar);

        jMenuBar1.add(m_archivo);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void m_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_grabarActionPerformed
        grabar();
    }//GEN-LAST:event_m_grabarActionPerformed

    private void m_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_eliminarActionPerformed
        eliminar();
    }//GEN-LAST:event_m_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu m_archivo;
    private javax.swing.JMenuItem m_cerrar;
    private javax.swing.JMenuItem m_eliminar;
    private javax.swing.JMenuItem m_grabar;
    // End of variables declaration//GEN-END:variables
}
