/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controles;

/**
 *
 * @author Developer GAGS
 */
public class SelectorRangoFechas extends javax.swing.JPanel {

    /**
     * Creates new form SelectorRangoFechas
     */
    public SelectorRangoFechas() {
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

        calendar_fin = new abstractt.visual.Calendar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        calendar_ini = new abstractt.visual.Calendar();
        boton1 = new abstractt.visual.Boton();

        setAlignmentX(0.1F);
        setAlignmentY(0.1F);
        setLayout(null);

        calendar_fin.setAlignmentX(0.01F);
        calendar_fin.setAlignmentY(0.01F);
        add(calendar_fin);
        calendar_fin.setBounds(150, 0, 100, 20);
        calendar_fin.getAccessibleContext().setAccessibleName("");
        calendar_fin.getAccessibleContext().setAccessibleDescription("");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("hasta");
        add(jLabel1);
        jLabel1.setBounds(120, 0, 30, 20);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("de");
        add(jLabel2);
        jLabel2.setBounds(0, 0, 20, 20);
        add(calendar_ini);
        calendar_ini.setBounds(20, 0, 100, 20);

        boton1.setText("boton1");
        add(boton1);
        boton1.setBounds(260, 0, 30, 20);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Boton boton1;
    private abstractt.visual.Calendar calendar_fin;
    private abstractt.visual.Calendar calendar_ini;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
