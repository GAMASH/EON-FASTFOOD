/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accesos;

import abstractt.visual.Panel;
import domain.tabla.Persona;

/**
 *
 * @author Developer GAGS
 */
public class PersonaPanel extends Panel {

    Persona persona;
    
    /**
     * Creates new form PersonaPanel
     */
    public PersonaPanel() {
        
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

        textFieldNombres = new abstractt.visual.TextField();
        label1 = new abstractt.visual.Label();
        label2 = new abstractt.visual.Label();
        textFieldNombres1 = new abstractt.visual.TextField();
        label3 = new abstractt.visual.Label();
        textFieldNombres2 = new abstractt.visual.TextField();
        label4 = new abstractt.visual.Label();
        textFieldNombres3 = new abstractt.visual.TextField();
        datosFiscalesPanel1 = new gui.accesos.DatosFiscalesPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new abstractt.visual.Table();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new abstractt.visual.Table();

        setLayout(null);
        add(textFieldNombres);
        textFieldNombres.setBounds(118, 25, 204, 20);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Nombres:");
        add(label1);
        label1.setBounds(8, 25, 100, 20);

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Apellido Paterno:");
        add(label2);
        label2.setBounds(8, 51, 100, 20);
        add(textFieldNombres1);
        textFieldNombres1.setBounds(118, 51, 129, 20);

        label3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label3.setText("Apellido Materno:");
        add(label3);
        label3.setBounds(8, 77, 100, 20);
        add(textFieldNombres2);
        textFieldNombres2.setBounds(118, 77, 129, 20);

        label4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label4.setText("NSS:");
        add(label4);
        label4.setBounds(8, 103, 100, 20);
        add(textFieldNombres3);
        textFieldNombres3.setBounds(118, 103, 129, 20);
        add(datosFiscalesPanel1);
        datosFiscalesPanel1.setBounds(334, 11, 488, 283);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table1);

        jTabbedPane1.addTab("Telefonos", jScrollPane1);

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(table2);

        jTabbedPane1.addTab("Correos", jScrollPane2);

        add(jTabbedPane1);
        jTabbedPane1.setBounds(12, 125, 310, 90);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.accesos.DatosFiscalesPanel datosFiscalesPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Label label3;
    private abstractt.visual.Label label4;
    private abstractt.visual.Table table1;
    private abstractt.visual.Table table2;
    private abstractt.visual.TextField textFieldNombres;
    private abstractt.visual.TextField textFieldNombres1;
    private abstractt.visual.TextField textFieldNombres2;
    private abstractt.visual.TextField textFieldNombres3;
    // End of variables declaration//GEN-END:variables
}
