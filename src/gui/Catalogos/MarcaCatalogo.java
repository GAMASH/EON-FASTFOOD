/*
 * tipos.java
 *
 * Created on 18 de febrero de 2008, 12:18 PM
 */
package gui.Catalogos;

import static domain.tabla.Marca.cargarMarcas;
import java.awt.event.KeyEvent;

/**
 *
 * @author Developer GAGS
 */
public class MarcaCatalogo extends abstractt.visual.InternalFrameAbstracto {

    /**
     * Creates new form tipos
     */
    public MarcaCatalogo() {
        initComponents();

        setLocation(30, 30);
    }

    public void cargaValores() {

        cargarMarcas(table1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bEliminar = new javax.swing.JButton();
        bCerrar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        bNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new abstractt.visual.Table();

        setClosable(false);
        setIconifiable(false);
        setMaximizable(false);
        setResizable(false);
        setTitle("Marcas");
        setFrameIcon(null);

        jPanel1.setLayout(null);

        bEliminar.setToolTipText("Eliminar Marca");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(bEliminar);
        bEliminar.setBounds(110, 10, 40, 40);

        bCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bCerrar.setMnemonic('C');
        bCerrar.setToolTipText("Cerrar");
        bCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCerrarActionPerformed(evt);
            }
        });
        jPanel1.add(bCerrar);
        bCerrar.setBounds(210, 410, 40, 40);

        bGuardar.setToolTipText("Guardar Tipo de Producto");
        bGuardar.setBorder(null);
        bGuardar.setBorderPainted(false);
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(bGuardar);
        bGuardar.setBounds(60, 10, 40, 40);

        bNuevo.setToolTipText("Nuevo");
        bNuevo.setBorder(null);
        bNuevo.setBorderPainted(false);
        bNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(bNuevo);
        bNuevo.setBounds(10, 10, 40, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nuevo");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 50, 40, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Guardar");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 50, 60, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Eliminar");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(110, 50, 40, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cerrar");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 450, 40, 20);

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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 80, 240, 320);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void bNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNuevoActionPerformed

      bNuevo.transferFocus();
      table1.agregarFila(jScrollPane1);
  }//GEN-LAST:event_bNuevoActionPerformed

    private void grabar() {

        table1.grabar();
    }

  private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed

      grabar();
  }//GEN-LAST:event_bGuardarActionPerformed

  private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed

      if (table1.validaCambios() == 0) {

          setVisible(false);
      }
  }//GEN-LAST:event_bCerrarActionPerformed

    private String agregar(java.awt.event.KeyEvent e) {

        char caracter = e.getKeyChar();

        if (((caracter < '0') || (caracter > '9')) && ((caracter < 'a') || (caracter > 'z')) && (caracter != KeyEvent.VK_BACK_SPACE)) {

        } else {

            return caracter + "";
        }

        return "";
    }

  private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed

      int filaSeleccionada = table1.getSelectedRow();
      if (filaSeleccionada != -1) {

          table1.eliminarFila(filaSeleccionada);
      }
  }//GEN-LAST:event_bEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCerrar;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private abstractt.visual.Table table1;
    // End of variables declaration//GEN-END:variables

    private int numeroFilas;
    private int filaSeleccionada;
    private int filaTipoAnterior = -1;

    private String tipoAnterior;
    private String nuevo = "";
    private String agregaTipo = "";

    private boolean cerrar = false;
    private boolean actualiza = false;
    private boolean enter = false;
}
