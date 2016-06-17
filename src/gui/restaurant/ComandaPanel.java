/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.restaurant;

import abstractt.visual.Panel;
import domain.tabla.Comanda;

/**
 *
 * @author sperez
 */
public class ComandaPanel extends Panel {

    private Comanda comanda;

    /**
     * Creates new form ComandaPanel
     */
    public ComandaPanel() {

        initComponents();
        comanda = new Comanda();
    }

    /**
     * @return the comanda
     */
    public Comanda getComanda() {
        return comanda;
    }

    /**
     * @param comanda the comanda to set
     */
    public void setComanda(Comanda Acomanda) {
        
        comanda = Acomanda;
        
        this.tf_estado.setText(Acomanda.status);
        this.tf_folio.setText(Acomanda.folio);
        this.tf_mesa.setText(comanda.mesa.numero_mesa);
        this.tf_mesero.setText(comanda.mesero.empleado.usuario.persona.nombre_completo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new abstractt.visual.Label();
        tf_folio = new abstractt.visual.TextField();
        fecha = new abstractt.visual.Calendar();
        label2 = new abstractt.visual.Label();
        tf_mesero = new abstractt.visual.TextField();
        label3 = new abstractt.visual.Label();
        label4 = new abstractt.visual.Label();
        tf_mesa = new abstractt.visual.TextField();
        label5 = new abstractt.visual.Label();
        tf_estado = new abstractt.visual.TextField();

        setBackground(new java.awt.Color(255, 255, 200));
        setLayout(null);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Fecha ");
        label1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        add(label1);
        label1.setBounds(176, 47, 38, 16);
        add(tf_folio);
        tf_folio.setBounds(58, 47, 104, 20);
        add(fecha);
        fecha.setBounds(219, 46, 96, 20);

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Folio ");
        label2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        add(label2);
        label2.setBounds(13, 49, 38, 16);
        add(tf_mesero);
        tf_mesero.setBounds(58, 75, 259, 20);

        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("Mesero ");
        label3.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        add(label3);
        label3.setBounds(2, 78, 56, 16);

        label4.setText("M E S A ");
        label4.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        add(label4);
        label4.setBounds(11, 8, 43, 31);
        add(tf_mesa);
        tf_mesa.setBounds(58, 8, 81, 30);

        label5.setText("E S T A D O ");
        label5.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        add(label5);
        label5.setBounds(148, 9, 71, 31);
        add(tf_estado);
        tf_estado.setBounds(215, 8, 104, 30);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Calendar fecha;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Label label3;
    private abstractt.visual.Label label4;
    private abstractt.visual.Label label5;
    private abstractt.visual.TextField tf_estado;
    private abstractt.visual.TextField tf_folio;
    private abstractt.visual.TextField tf_mesa;
    private abstractt.visual.TextField tf_mesero;
    // End of variables declaration//GEN-END:variables

}
