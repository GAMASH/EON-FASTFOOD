/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.inventarios;

import domain.tabla.Articulo;
import javax.swing.JPanel;
import domain.tabla.Marca;

/**
 *
 * @author Developer GAGS
 */
public class ArticuloPanel extends JPanel {

    public Articulo articulo;

    /**
     * Creates new form ArticuloPanel
     */
    public ArticuloPanel() {

        initComponents();
        articulo = new Articulo();
        this.setOpaque(false);

    }

    public void cargar() {

        tipoArticuloSelector.cargar();              
        unidadMedidaSelector.cargar();
        impuestoSelector.cargar();
        marcaSelector.setTablaBD(new Marca());
    }

    public void setArticulo(Articulo articulo) {

        this.articulo = articulo;
        
        tipoArticuloSelector.setTipoArticulo(articulo.tipo_articulo);
        marcaSelector.setTablaBD(articulo.marca);
        unidadMedidaSelector.setUnidadMedida(articulo.unidad_entrada);
        impuestoSelector.setImpuesto(articulo.impuesto);
        tf_clave.setText(articulo.clave);
        tf_codigo_barras.setText(articulo.codigo_barras_entrada);
        tf_descripcion.setText(articulo.descripcion);
        tf_factor_empaque.setText(articulo.factor_empaque.toString());
                
    }

    public Articulo getArticulo() {
        
        articulo.tipo_articulo = tipoArticuloSelector.getTipoArticulo();
        articulo.marca = (Marca) marcaSelector.getTablaBD();
        articulo.unidad_entrada = unidadMedidaSelector.getUnidadMedida();
        articulo.impuesto = impuestoSelector.getImpuesto();
        articulo.clave = this.tf_clave.getText();
        articulo.codigo_barras_entrada = this.tf_codigo_barras.getText();
        articulo.descripcion = this.tf_descripcion.getText();
        articulo.factor_empaque = this.tf_factor_empaque.getDouble();
        
        return articulo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tf_clave = new abstractt.visual.TextField();
        tipoArticuloSelector = new gui.controles.TipoArticuloSelector();
        jLabel3 = new javax.swing.JLabel();
        tf_codigo_barras = new abstractt.visual.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        impuestoSelector = new gui.controles.ImpuestoSelector();
        unidadMedidaSelector = new gui.controles.UnidadMedidaSelector();
        jLabel7 = new javax.swing.JLabel();
        tf_factor_empaque = new abstractt.visual.TextField();
        jLabel8 = new javax.swing.JLabel();
        label1 = new abstractt.visual.Label();
        jScrollPane1 = new javax.swing.JScrollPane();
        tf_descripcion = new abstractt.visual.TextArea();
        marcaSelector = new abstractt.visual.TablaBDSelector();

        setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Unidad de Medida");
        add(jLabel2);
        jLabel2.setBounds(10, 150, 90, 20);

        tf_clave.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_clave.setMargin(new java.awt.Insets(1, 1, 1, 1));
        tf_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_claveActionPerformed(evt);
            }
        });
        add(tf_clave);
        tf_clave.setBounds(111, 13, 70, 18);
        add(tipoArticuloSelector);
        tipoArticuloSelector.setBounds(110, 120, 130, 20);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripción");
        add(jLabel3);
        jLabel3.setBounds(18, 45, 90, 12);

        tf_codigo_barras.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_codigo_barras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_codigo_barrasActionPerformed(evt);
            }
        });
        add(tf_codigo_barras);
        tf_codigo_barras.setBounds(340, 12, 130, 20);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Impuesto");
        add(jLabel4);
        jLabel4.setBounds(250, 150, 70, 20);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Tipo de Articulo");
        add(jLabel5);
        jLabel5.setBounds(10, 120, 90, 20);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Marca");
        add(jLabel6);
        jLabel6.setBounds(250, 120, 70, 20);
        add(impuestoSelector);
        impuestoSelector.setBounds(330, 150, 138, 20);
        add(unidadMedidaSelector);
        unidadMedidaSelector.setBounds(110, 150, 130, 20);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Factor Empaque");
        add(jLabel7);
        jLabel7.setBounds(10, 180, 90, 20);

        tf_factor_empaque.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_factor_empaque.setText("1.0");
        add(tf_factor_empaque);
        tf_factor_empaque.setBounds(110, 180, 130, 20);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Codigo de Barras");
        add(jLabel8);
        jLabel8.setBounds(240, 12, 90, 20);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Clave:");
        add(label1);
        label1.setBounds(46, 14, 63, 17);

        tf_descripcion.setColumns(20);
        tf_descripcion.setRows(5);
        jScrollPane1.setViewportView(tf_descripcion);

        add(jScrollPane1);
        jScrollPane1.setBounds(110, 39, 357, 77);
        add(marcaSelector);
        marcaSelector.setBounds(330, 123, 138, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_claveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_claveActionPerformed

    private void tf_codigo_barrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_codigo_barrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_codigo_barrasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.controles.ImpuestoSelector impuestoSelector;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private abstractt.visual.Label label1;
    private abstractt.visual.TablaBDSelector marcaSelector;
    private abstractt.visual.TextField tf_clave;
    private abstractt.visual.TextField tf_codigo_barras;
    private abstractt.visual.TextArea tf_descripcion;
    private abstractt.visual.TextField tf_factor_empaque;
    private gui.controles.TipoArticuloSelector tipoArticuloSelector;
    private gui.controles.UnidadMedidaSelector unidadMedidaSelector;
    // End of variables declaration//GEN-END:variables
}
