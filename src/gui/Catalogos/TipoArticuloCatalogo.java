/*
 * tipos.java
 *
 * Created on 18 de febrero de 2008, 12:18 PM
 */
package gui.Catalogos;

import domain.tabla.TipoArticulo;
import java.awt.event.KeyEvent;

/**
 *
 * @author Developer GAGS
 */
public class TipoArticuloCatalogo extends abstractt.visual.InternalFrameAbstracto {

    /**
     * Creates new form tipos
     */
    public TipoArticuloCatalogo() {
        initComponents();

        setLocation(30, 30);

        //jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // jTable1.setSelectionBackground(Color.ORANGE);
    }

    public void cargaValores() {
/*
        this.limpiarTabla(this.jTable1);

        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        mbd.consulta("SELECT descripcion FROM tipo_articulo WHERE id_tipo_articulo <> -1 AND activo = 'S' ORDER BY descripcion");
        numeroFilas = mbd.getRowCount() + 1;

        Object[] arr = new Object[1];

        for (int i = 0; i < mbd.getRowCount(); i++) {

            arr = new Object[1];
            arr[0] = mbd.getValueAt(i, 0).toString();
            modelo.addRow(arr);
        }

        arr = new Object[1];
        modelo.addRow(arr);

        jTable1.setModel(modelo);

        tipoAnterior = "";
        nuevo = "";
        agregaTipo = "";
*/
    //    TipoArticulo.cargarTabla(table1);
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
        setTitle("Tipo Articulo");
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
        table1.setDragEnabled(true);
        table1.setDropMode(javax.swing.DropMode.INSERT_ROWS);
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
      /*
       Rectangle r = table1.getCellRect(table1.getRowCount()-1, 0, false);
       jScrollPane2.getViewport().scrollRectToVisible(r);
      
       table1.changeSelection(table1.getRowCount()-1,0,false,true);
       filaSeleccionada = table1.getRowCount()-1;
       */
  }//GEN-LAST:event_bNuevoActionPerformed

    private void grabar() {

        //grabarTiposArticulo(table1);
        table1.grabar();
    }

  private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed

      grabar();
      /*
      
       String nombre = "";
       int opcion;

       if (jTable1.getValueAt(jTable1.getRowCount() - 1, 0) != null) {

       nombre = jTable1.getValueAt(jTable1.getRowCount() - 1, 0).toString();
       agregar(nombre);
       } else {
       if (!nuevo.equals("")) {

       CellEditor ce = jTable1.getCellEditor();
       ce.cancelCellEditing();
       agregar(nuevo);
       DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
       modelo.removeRow(jTable1.getRowCount() - 1);
       jTable1.setModel(modelo);
       nuevo = "";
       cargaValores();
       }
       }

       if (jTable1.getSelectedRow() != -1 && jTable1.getSelectedRow() != jTable1.getRowCount() - 1) {

       actualiza = true;
       cambio();
       cargaValores();
       actualiza = false;
       }
       */
  }//GEN-LAST:event_bGuardarActionPerformed

  private void bCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCerrarActionPerformed
/*
      String nombre = "";
      int opcion;

      //si dan un enter
      if (jTable1.getValueAt(jTable1.getRowCount() - 1, 0) != null && !nombre.equals("")) {

          nombre = jTable1.getValueAt(jTable1.getRowCount() - 1, 0).toString();
          opcion = dialogoConfirmacionSiNo(this, "Desea Guardar el Tipo de Producto \"" + nombre, "\" Guardar Tipo de Producto", 1);

          if (opcion == 0) {

              agregar(nombre);
          }

      } else {
          //
          if (!nuevo.equals("")) {
              opcion = dialogoConfirmacionSiNo(this, "Desea Guardar el Tipo de Producto \"" + nuevo, "\" Guardar Tipo de Producto", 1);

              if (opcion == 0) {

                  agregar(nuevo);
              }
          }
      }
*/
      
      if ( table1.validaCambios() == 0){
      
        setVisible(false);
      }
 
  }//GEN-LAST:event_bCerrarActionPerformed
/*
    private void tipoAnterior() {

        if (filaSeleccionada == jTable1.getRowCount() - 1) {

            System.out.println("fila registro nuevo");

            if (!nuevo.equals("")) {

                int opcion = dialogoConfirmacionSiNo(this, "Desea Guardar el tipo " + nuevo, " Guardar Tipo", 1);

                if (opcion == 0) {

                    agregar(nuevo);
                } else {
                    cargaValores();
                }
            }
        }

        if (filaTipoAnterior != -1 && filaTipoAnterior < jTable1.getRowCount()) {

            String tipo = jTable1.getValueAt(filaTipoAnterior, 0).toString();
            //if(!tipo.equals("") && !tipoAnterior.equals(""))
            if (!tipoAnterior.equals(tipo)) {
                cambio();
                //return;
            }
        }

        filaSeleccionada = jTable1.getSelectedRow();

        //cambio
        if (filaSeleccionada != -1) {
            if (jTable1.getValueAt(filaSeleccionada, 0) != null) {

                tipoAnterior = jTable1.getValueAt(filaSeleccionada, 0).toString();
                filaTipoAnterior = filaSeleccionada;
            } else {
                tipoAnterior = "";
                filaTipoAnterior = -1;
            }
        }
    }
  */
/*
    public void eventosDelTecladoEnTabla(java.awt.event.KeyEvent evt) {

        switch (evt.getKeyCode()) {
            //Enter
            case 10:
                //nuevo
                System.out.println("");
                if (this.filaSeleccionada == numeroFilas - 1) {
                    if (jTable1.getValueAt(numeroFilas - 1, 0) != null) {
                        //System.out.println("fila Seleccionada "+filaSeleccionada+" numero Filas "+numeroFilas);
                        agregar();
                    } else {

                        this.jTable1.setRowSelectionInterval(numeroFilas - 2, numeroFilas - 2);
                    }
                } //cambio
                else {
                    System.out.println("cambio");
                    enter = true;
                    cambio();
                    enter = false;
                }

                nuevo = "";
                agregaTipo = "";
                break;
            //Suprimir
            case 127:
                borrar();
                cargaValores();
                break;
            default: {
                //System.out.println("fila seleccionada "+filaSeleccionada);
                if (filaSeleccionada == jTable1.getRowCount() - 1) {

                    nuevo += agregar(evt);
                } else {

                    agregaTipo += agregar(evt);
                }
            }
            break;
        }
    }
*/
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
/*
    public void cambio() {

        if (filaTipoAnterior != -1) {

            String tipo = jTable1.getValueAt(filaTipoAnterior, 0).toString();
            if ((cerrar || actualiza || enter) && !agregaTipo.equals("")) {

                tipo += agregaTipo;
            }

            if (!tipo.equals("") && !tipoAnterior.equals("")) {
                if (!tipo.equals(tipoAnterior)) {

                    int opcion = dialogoConfirmacionSiNo(this, " Desea Modificar el Tipo \"" + tipoAnterior.toUpperCase() + "\" por \""
                            + tipo.toUpperCase() + "\"", "Actualizacion de tipo", 1);

                    if (opcion == 0) {

                        //CHECAR SI EL NUEVO YA ESTABA ACTIVADO
                        String consulta = "SELECT * FROM tipo_articulo WHERE descripcion = '" + tipo.toUpperCase() + "' AND activo = 'S'";
                        mbd.consulta(consulta);

                        if (mbd.getRowCount() == 1) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Ya existe el tipo de Producto '" + tipo.toUpperCase() + "'");
                            cargaValores();

                        } else {

                            consulta = "SELECT * FROM tipo_articulo WHERE descripcion = '" + tipo.toUpperCase() + "' AND activo = 'N'";
                            mbd.consulta(consulta);

                            if (mbd.getRowCount() == 1) {

                                String eliminacion = "DELETE * FROM tipo_articulo WHERE descripcion = '" + tipo.toUpperCase() + "'";
                                mbd.eliminacion(eliminacion);
                            }

                            mbd.actualizacion("UPDATE tipo_articulo SET descripcion = '" + tipo.toUpperCase() + "' WHERE descripcion = '" + tipoAnterior.toUpperCase() + "'");
                            cargaValores();

                        }

                    } else {

                        cargaValores();
                    }

                    agregaTipo = "";
                    tipoAnterior = "";
                    filaTipoAnterior = -1;
                }
            }
        }
    }
  */
/*
    private void agregar(String tipoNuevo) {

        if (!tipoNuevo.equals("")) {
            tipoNuevo = tipoNuevo.toUpperCase();

            mbd.consulta("SELECT * FROM tipo_articulo WHERE descripcion = '" + tipoNuevo + "' ");

            if (mbd.getRowCount() == 0) {

                mbd.insercion("INSERT INTO tipo_articulo ( descripcion, activo) values ('" + tipoNuevo.toUpperCase() + "', 'S')");

                cargaValores();
                javax.swing.JOptionPane.showMessageDialog(this, "TIPO \"" + tipoNuevo.toUpperCase() + "\" REGISTRADO");
            } else {

                mbd.consulta("SELECT * FROM tipo_articulo WHERE descripcion = '" + tipoNuevo + "' AND activo = 'N'");
                if (mbd.getRowCount() == 1) {

                    int opcion = this.dialogoConfirmacionSiNo(this, "Ya existe el tipo " + tipoNuevo + ", esta se encuentra desactivado \n�Desea Reactivarlo?", "Reactivacion de tipo", 1);
                    if (opcion == 0) {

                        String actualizacion = "UPDATE tipo_articulo SET activo = 'S' WHERE descripcion = '" + tipoNuevo.toUpperCase() + "'";
                        mbd.actualizacion(actualizacion);
                        cargaValores();
                    } else {
                        nuevo = "";
                        agregaTipo = "";
                        cargaValores();
                    }
                } else {

                    javax.swing.JOptionPane.showMessageDialog(this, "Ya Existe un tipo " + tipoNuevo);
                    cargaValores();
                    jTable1.setValueAt("", jTable1.getRowCount() - 1, 0);
                }
            }
        }
    }
  */
/*
    public void agregar() {

        String descripcion = jTable1.getValueAt(numeroFilas - 1, 0).toString();
        agregar(descripcion);
    }
*/
  /*
    public void borrar() {

        String tipo = jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();

        String consulta = "SELECT idProducto FROM Producto INNER JOIN Tipo ON Producto.id_tipo_articulo = Tipo.id_tipo_articulo "
                + "WHERE Tipo.descripcion = '" + tipo + "'";

        mbd.consulta(consulta);

        int cantidadProductos = mbd.getRowCount();

        String mensaje = "el Tipo \"" + tipo + "\" tiene asignado " + cantidadProductos + " productos \n desea borrarlo";

        int borrar = dialogoConfirmacionSiNo(this, mensaje, "Eliminar Tipo", 1);

        switch (borrar) {

            case 0:

                mbd.actualizacion("UPDATE Tipo SET activo = false where descripcion = '" + tipo + "'");
                if (cantidadProductos != 0) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No Olvide Reclasificar los Productos con el tipo \"" + tipo + "\"");
                }

                consulta = "SELECT id_tipo_articulo FROM Tipo WHERE descripcion = '" + tipo + "'";
                mbd.consulta(consulta);
                int id_tipo_articulo = mbd.getValorInt(0, 0);

                mbd.actualizacion("UPDATE Producto SET id_tipo_articulo = 1 WHERE id_tipo_articulo = " + id_tipo_articulo);

                break;

            default:
                break;
        }

        filaSeleccionada = -1;
        nuevo = "";
        agregaTipo = "";

    }
  */
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
