/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.inventarios;

import abstractt.visual.InternalFrameAbstracto;
import abstractt.visual.Panel;
import domain.tabla.Articulo;
import domain.tabla.ArticuloProveedor;
import domain.tabla.ArticuloSucursal;
import static gui.Principal.escritorio;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Developer GAGS
 */
public class ArticuloCaptura extends InternalFrameAbstracto {

    public Articulo articulo;

    /**
     * Creates new form Articulos
     */
    public ArticuloCaptura() {
        initComponents();

        articulo = new Articulo();

        this.cargar();

        sucursalesTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                Integer row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {

                    consultarArticuloSucursal(row);
                }
            }
        });
        
        jTabbedPane1.setOpaque(false);
        
        jScrollPane1.setOpaque(false);
        
        jPanel1.setOpaque(false);
         jPanel2.setOpaque(false);
    }

    public void consultarArticuloSucursal(int fila) {

        ArticuloSucursal articuloSucursal;
        articuloSucursal = new ArticuloSucursal();

        articuloSucursal.id_sucursal = sucursalesTable.getValueAt(fila, 0).toString();
        articuloSucursal.id_articulo = sucursalesTable.getValueAt(fila, 1).toString();

        articuloSucursal.cargarPorId();

        inciarArticuloCaptura();
        articuloSucursalCaptura.setArticuloSucursal(articuloSucursal);

    }

    public void setArticulo(Articulo articulo) {

        this.articulo = articulo;
        articuloPanel.setArticulo(articulo);
        ArticuloSucursal.cargarSucursalesArticulo(sucursalesTable, articulo);
        ArticuloProveedor.cargarArticuloProveedor(proveedoresTable, articulo);
        
        
    }

    public void cargar() {

        this.articuloPanel.cargar();
        ArticuloSucursal.cargarSucursalesArticulo(sucursalesTable, articulo);
        ArticuloProveedor.cargarArticuloProveedor(proveedoresTable, articulo);       
    }

    public void grabar() {

        articulo = this.articuloPanel.getArticulo();
        if (articulo.grabar()) {

            for (int i = 0; i < proveedoresTable.getRowCount(); i++) {

                proveedoresTable.setValueAt(articulo.id_articulo, i, 1);

            }
            this.proveedoresTable.grabar();
        }
    }
    
    public void eliminar(){
        
        articulo = this.articuloPanel.getArticulo();
        
        if(articulo.borrar()){
            
        }        
    }    

    private void inciarArticuloCaptura() {

        if (articuloSucursalCaptura == null) {

            articuloSucursalCaptura = new gui.inventarios.ArticuloSucursalCaptura();
        }
        if (!articuloSucursalCaptura.isVisible()) {

            articuloSucursalCaptura = new gui.inventarios.ArticuloSucursalCaptura();

            articuloSucursalCaptura.cargar();

            escritorio.remove(articuloSucursalCaptura);
            escritorio.add(articuloSucursalCaptura);
            articuloSucursalCaptura.centrado(escritorio.getSize());
            articuloSucursalCaptura.setModal(true);

        } else {

            articuloSucursalCaptura.setVisible(false);
        }
    }

    ArticuloSucursalCaptura articuloSucursalCaptura;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new Panel();
        articuloPanel = new gui.inventarios.ArticuloPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sucursalesTable = new abstractt.visual.Table();
        boton1 = new abstractt.visual.Boton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        proveedoresTable = new abstractt.visual.Table();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();

        setTitle("Articulo");

        jPanel3.setLayout(null);
        jPanel3.add(articuloPanel);
        articuloPanel.setBounds(0, 0, 490, 208);

        jPanel1.setLayout(null);

        sucursalesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(sucursalesTable);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 10, 480, 242);

        boton1.setText("ver detalle");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        jPanel1.add(boton1);
        boton1.setBounds(510, 10, 83, 23);

        jTabbedPane1.addTab("Sucursales", jPanel1);

        jPanel2.setLayout(null);

        proveedoresTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(proveedoresTable);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(10, 10, 452, 250);

        jTabbedPane1.addTab("Proveedores", jPanel2);

        jPanel3.add(jTabbedPane1);
        jTabbedPane1.setBounds(10, 210, 610, 295);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Grabar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Eliminar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);
        jMenu1.add(jSeparator1);

        jMenuItem2.setText("Cerrar");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        grabar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        eliminar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.inventarios.ArticuloPanel articuloPanel;
    private abstractt.visual.Boton boton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private abstractt.visual.Table proveedoresTable;
    private abstractt.visual.Table sucursalesTable;
    // End of variables declaration//GEN-END:variables
}
