/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.restaurant;

import abstractt.visual.Panel;
import static domain.General.mensaje;
import static domain.General.sucursal;
import domain.tabla.ComandaDetalle;
import domain.tabla.Platillo;
import javax.swing.TransferHandler;

/**
 *
 * @author Developer GAGS
 */
public class ComandaDetallePanel extends Panel {

    public ComandaDetalle comanda_detalle;
    public Double total;

    /**
     * Creates new form ComandaDetallePanel
     */
    public ComandaDetallePanel() {

        initComponents();
        total = 0.0;
        
        table1.setEditable(false);
    }

    public void grabar() {

        table1.grabar();

    }

    /**
     *
     * @param platillo
     * @param comensal
     */
    public void agregarPlatillo(Platillo platillo, Integer comensal) {

        Integer fila;

        fila = this.table1.agregarFila(jScrollPane1);

        table1.setValueAt(sucursal.id_sucursal, fila, 0);
        table1.setValueAt(comanda_detalle.id_comanda, fila, 1);
        table1.setValueAt(comanda_detalle.id_comanda_detalle, fila, 2);
        table1.setValueAt(platillo.id_platillo, fila, 3);
        table1.setValueAt(platillo.nombre, fila, 4);
        table1.setValueAt(comensal, fila, 5);
        table1.setValueAt("Pendiente", fila, 6);
        table1.setValueAt("", fila, 7);
        table1.setValueAt(platillo.precio, fila, 8);
        table1.setValueAt(0, fila, 9);

        calcular_totales();
    }

    private void calcular_totales() {

        total = 0.0;

        for (int i = 0; i < table1.getRowCount(); i++) {

            total += table1.getValorDouble(i, 8);
        }

        this.tf_subtotal.setDouble(total);
        this.tf_total.setDouble(total);
    }

    public ComandaDetalle quitarPlatillo() {

        Integer fila;

        fila = table1.getSelectedRow();

        if (fila < 0) {
            mensaje("Seleccione un registo");
            return null;
        }

        ComandaDetalle comanda_detalle;
        comanda_detalle = new ComandaDetalle();

        comanda_detalle.setRegistro(table1, fila);

        table1.eliminarFila(fila);
        calcular_totales();

        return comanda_detalle;
    }

    public void quitarPlatillo(ComandaDetalle comanda_detalle) {

        Integer fila;
        ComandaDetalle comanda_detalle_2 = new ComandaDetalle();

        for (int i = 0; i < table1.getRowCount(); i++) {

            comanda_detalle_2.setRegistro(table1, i);

            if (comanda_detalle_2.equals(comanda_detalle)) {

                table1.eliminarFila(i);
            }
        }

        calcular_totales();
    }

    /**
     *
     * @param comanda_detalle
     */
    public void setComandaDetalle(ComandaDetalle comanda_detalle) {

        this.comanda_detalle = comanda_detalle;

        ComandaDetalle.cargarComandaDetalle(table1, comanda_detalle.id_comanda, comanda_detalle.num_comensal);

        table1.setDragEnabled(true);
        table1.setTransferHandler(new TransferHandler("text"));

        calcular_totales();
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
        label3 = new abstractt.visual.Label();
        label2 = new abstractt.visual.Label();
        label1 = new abstractt.visual.Label();
        tf_subtotal = new abstractt.visual.TextFieldMoneda();
        tf_impuesto = new abstractt.visual.TextFieldMoneda();
        tf_total = new abstractt.visual.TextFieldMoneda();

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
        jScrollPane1.setViewportView(table1);

        jPanel1.setOpaque(false);

        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("Subtotal:");

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Impuesto:");

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Total:");

        tf_subtotal.setEditable(false);
        tf_subtotal.setBackground(new java.awt.Color(255, 255, 255));
        tf_subtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_subtotalActionPerformed(evt);
            }
        });

        tf_impuesto.setEditable(false);
        tf_impuesto.setBackground(new java.awt.Color(255, 255, 255));
        tf_impuesto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tf_total.setEditable(false);
        tf_total.setBackground(new java.awt.Color(255, 255, 255));
        tf_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_impuesto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_impuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tf_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_subtotalActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Label label3;
    private abstractt.visual.Table table1;
    private abstractt.visual.TextFieldMoneda tf_impuesto;
    private abstractt.visual.TextFieldMoneda tf_subtotal;
    private abstractt.visual.TextFieldMoneda tf_total;
    // End of variables declaration//GEN-END:variables
}
