/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.restaurant;

import abstractt.visual.Boton;
import abstractt.visual.InternalFrameAbstracto;
import static domain.General.mensaje;
import domain.tabla.Comanda;
import domain.tabla.ComandaDetalle;
import domain.tabla.Platillo;
import domain.tabla.TipoPlatillo;
import static domain.tabla.TipoPlatillo.cargarTipoPlatillos;
import static gui.Principal.escritorio;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author Developer GAGS
 */
public class ComandaCaptura extends InternalFrameAbstracto {

    Comanda comanda;
    ArrayList<Boton> botones;
    ArrayList<ComandaDetallePanel> comanda_detalles_panel;
    Integer index_panel_total;

    /**
     * Creates new form ComandaCaptura
     */
    public ComandaCaptura() {

        initComponents();
        botones = new ArrayList<Boton>();
        comanda_detalles_panel = new ArrayList<ComandaDetallePanel>();

    }

    /**
     *
     * @param platillo
     */
    public void agregarPlatillo(Platillo platillo) {

        ComandaDetallePanel panel_detalle;
        
        int index = this.jTabbedPane1.getSelectedIndex();

        if (index_panel_total != index) {

            panel_detalle = comanda_detalles_panel.get(index);
            panel_detalle.agregarPlatillo(platillo, index + 1);
            //al panel del total
            panel_detalle = comanda_detalles_panel.get(index_panel_total);
            panel_detalle.agregarPlatillo(platillo, index + 1);
        }
    }

    /**
     *
     */
    public void quitarPlatillo() {

        ComandaDetallePanel panel_detalle;

        //  System.out.println("quitar platillo");
        ComandaDetalle platillo_eliminado;

        int index = this.jTabbedPane1.getSelectedIndex();

        if (index_panel_total != index) {

            panel_detalle = comanda_detalles_panel.get(index);
            platillo_eliminado = panel_detalle.quitarPlatillo();

            if (platillo_eliminado != null) {

                //eliminar del total
                panel_detalle = comanda_detalles_panel.get(index_panel_total);
                panel_detalle.quitarPlatillo(platillo_eliminado);
            }
        } else {

            //quitar del total
            panel_detalle = comanda_detalles_panel.get(index);
            platillo_eliminado = panel_detalle.quitarPlatillo();
            //quitar del detalle
            panel_detalle = comanda_detalles_panel.get(platillo_eliminado.num_comensal - 1);
            platillo_eliminado = panel_detalle.quitarPlatillo();
        }
    }

    /**
     *
     */
    public void cargaValores() {

        ArrayList<String> tiposPlatillo;
        Boton boton;

        int borde = 4;
        int posX = borde, posY = borde;
        int alto_boton = 40;//40
        int ancho_boton = 100;//100

        tiposPlatillo = cargarTipoPlatillos();

        for (int i = 0; i < tiposPlatillo.size(); i++) {

            boton = new Boton();
            boton.setText(tiposPlatillo.get(i));

            /**/
            boton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    boton(evt);
                }
            });
            /**/

            botones.add(boton);

            tiposPaltillo.add(boton);

            boton.setBounds(posX, posY, ancho_boton, alto_boton);

            posY += alto_boton + borde;

            if (posY > alto_boton + (borde * 2)) {

                posY = borde;
                posX += ancho_boton + borde;
            }
        }

        tiposPaltillo.setPreferredSize(new Dimension(posX += ancho_boton + borde, (alto_boton * 2) + (borde * 2)));

        //  ArrayList<ComandaDetalle> comandas_detalle;
        // comandas_detalle.
        for (int i = 0; i < comanda.mesa.num_comensales; i++) {

            agregarDetalle("Comensal " + (i + 1), (i + 1));
        }

        this.index_panel_total = comanda.mesa.num_comensales;

        agregarDetalle("T O T A L ", 0);

        quitar_platillo.redimensionarIcono();
    }

    /**
     *
     * @param evt
     */
    private void boton(java.awt.event.ActionEvent evt) {

        TipoPlatillo tipo_platillo;
        tipo_platillo = new TipoPlatillo();

        tipo_platillo.cargarPorDescripcion(evt.getActionCommand());

        //System.out.println(evt);
        //System.out.println(evt.getActionCommand());
        if (platilloPorTipo == null) {

            platilloPorTipo = new PlatillosPorTipo();
        } else {
            platilloPorTipo.dispose();
        }
        if (!platilloPorTipo.isVisible()) {

            platilloPorTipo = new PlatillosPorTipo();
            platilloPorTipo.setTipoPlatillo(tipo_platillo);
            platilloPorTipo.cargaValores();
            platilloPorTipo.centrado(escritorio.getSize());
            escritorio.remove(platilloPorTipo);
            escritorio.add(platilloPorTipo);
            platilloPorTipo.setVisible(true);
        } else {

            platilloPorTipo.setTipoPlatillo(tipo_platillo);
            platilloPorTipo.cargaValores();
            platilloPorTipo.setVisible(false);
            platilloPorTipo.setVisible(true);
        }

        platilloPorTipo.moveToFront();

    }

    /**
     *
     * @param nombre_tab
     * @param comensal
     */
    private void agregarDetalle(String nombre_tab, int comensal) {

        //  Table tabla_detalle;
        ComandaDetalle comanda_detalle;
        ComandaDetallePanel panel_detalle;

        panel_detalle = new ComandaDetallePanel();
        comanda_detalle = new ComandaDetalle();

        comanda_detalle.id_comanda = comanda.id_comanda;
        comanda_detalle.num_comensal = comensal;

        panel_detalle.setComandaDetalle(comanda_detalle);

        this.comanda_detalles_panel.add(panel_detalle);

        jTabbedPane1.add(panel_detalle, nombre_tab);
    }

    /**
     *
     * @param comanda
     */
    public void setComanda(Comanda comanda) {

        this.comanda = comanda;
        this.comandaPanel1.setComanda(comanda);
        /*
         if (comanda.status.equals("Disponible")) {
            
         comanda.status= "Proceso";
                        
         if (!this.comanda.grabar()){
         mensaje("Error al grabar la comanda "+manejadorBD.errorSQL)   ;
         }
         }
         */
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
        comandaPanel1 = new gui.restaurant.ComandaPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tiposPaltillo = new abstractt.visual.Panel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        quitar_platillo = new abstractt.visual.Boton();
        quitar_platillo1 = new abstractt.visual.Boton();

        setTitle("Comanda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosed(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout tiposPaltilloLayout = new javax.swing.GroupLayout(tiposPaltillo);
        tiposPaltillo.setLayout(tiposPaltilloLayout);
        tiposPaltilloLayout.setHorizontalGroup(
            tiposPaltilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        tiposPaltilloLayout.setVerticalGroup(
            tiposPaltilloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(tiposPaltillo);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTabbedPane1.setOpaque(true);

        quitar_platillo.setBorder(null);
        quitar_platillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/trash_100px.png"))); // NOI18N
        quitar_platillo.setBorderPainted(false);
        quitar_platillo.setContentAreaFilled(false);
        quitar_platillo.setMargin(new java.awt.Insets(0, 0, 0, 0));
        quitar_platillo.setPreferredSize(new java.awt.Dimension(50, 50));
        quitar_platillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitar_platilloActionPerformed(evt);
            }
        });

        quitar_platillo1.setBorder(null);
        quitar_platillo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/images/trash_100px.png"))); // NOI18N
        quitar_platillo1.setBorderPainted(false);
        quitar_platillo1.setContentAreaFilled(false);
        quitar_platillo1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        quitar_platillo1.setPreferredSize(new java.awt.Dimension(50, 50));
        quitar_platillo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitar_platillo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(comandaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(quitar_platillo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quitar_platillo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comandaPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quitar_platillo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitar_platillo1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(panel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameClosed(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosed

        escritorio.cerrarInternalFrame("PlatillosPorTipo");
    }//GEN-LAST:event_formInternalFrameClosed

    private void quitar_platilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitar_platilloActionPerformed

        quitarPlatillo();
    }//GEN-LAST:event_quitar_platilloActionPerformed

    private void quitar_platillo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitar_platillo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quitar_platillo1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.restaurant.ComandaPanel comandaPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private abstractt.visual.Panel panel1;
    private abstractt.visual.Boton quitar_platillo;
    private abstractt.visual.Boton quitar_platillo1;
    private abstractt.visual.Panel tiposPaltillo;
    // End of variables declaration//GEN-END:variables

    private PlatillosPorTipo platilloPorTipo = null;
}
