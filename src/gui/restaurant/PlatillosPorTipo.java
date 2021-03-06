/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.restaurant;

import abstractt.visual.InternalFrameAbstracto;
import abstractt.visual.Table;
import domain.tabla.Platillo;
import static domain.tabla.Platillo.cargarPlatilloPorTipo;
import domain.tabla.TipoPlatillo;
import static gui.Principal.escritorio;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Developer GAGS
 */
public class PlatillosPorTipo extends InternalFrameAbstracto {

    public TipoPlatillo tipo_platillo;

    /**
     * Creates new form PlatillosPorTipo
     */
    public PlatillosPorTipo() {

        initComponents();
        this.tipo_platillo = new TipoPlatillo();

        table1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                Table table = (Table) me.getSource();
                Point p = me.getPoint();
                Integer row = table.rowAtPoint(p);
                if (me.getClickCount() == 1) {

                    seleccionar(row);
                }
            }
        });
        
        table1.setEditable(false);
    }

    public void seleccionar(Integer fila) {

        Platillo platillo;
        ComandaCaptura comandaCaptura;

        comandaCaptura = (ComandaCaptura) escritorio.buscarInternalFrame("ComandaCaptura");

        if (comandaCaptura == null) {
            //ventana cerrada 
            return;
        }

        platillo = new Platillo();
        platillo.obtenerPorId(new ArrayList(Arrays.asList(table1.getValorString(fila, 0))));
        comandaCaptura.agregarPlatillo(platillo);
    }

    public void setTipoPlatillo(TipoPlatillo tipo_platillo) {

        this.tipo_platillo = tipo_platillo;
    }

    public void cargaValores() {

        cargarPlatilloPorTipo(table1, tipo_platillo);
        setTitle(tipo_platillo.descripcion);
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

        getContentPane().setLayout(new java.awt.GridLayout());

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

        getContentPane().add(jScrollPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private abstractt.visual.Table table1;
    // End of variables declaration//GEN-END:variables
}
