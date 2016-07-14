/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import abstractt.visual.Table;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.manejadorBD;
import domain.ParametrosSP;

/**
 *
 * @author Developer GAGS
 */
public class TipoPago extends TablaBD {

    public String id_tipo_pago;
    public String descripcion;

    /**
     * 
     */
    public TipoPago() {

        id_tipo_pago = "";
        descripcion = "";
    }

    /**
     *
     * @param tabla
     */
    public void cargarTabla(Table tabla) {

        crearTabla(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_tipo_pago, descripcion, crea, modifica\n"
                + "FROM     tipo_pago\n"
                + "ORDER BY descripcion ");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();

        tabla.ocultarColumna(0);
        tabla.ocultarColumna(2);
        tabla.ocultarColumna(3);

        desconectarBD();
    }

    /**
     *
     * @param tabla
     * @return
     */
    private Table crearTabla(Table tabla) {

        if (tabla == null) {
            
            tabla = new Table();
        }

        String titulos[] = {
            "Id tipo Pago", "Descripcion", "Crea",
            "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra,
            Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 100, 0, 0
        });
      

        tabla.setTablaBD(this);

        return tabla;
    }

    /**
     * 
     * @param table
     * @param i 
     */
    public void setRegistro(Table table, Integer i) {

        id_tipo_pago = table.getValorString(i, 0);
        descripcion =  table.getValorString(i, 1);
    }
    
    /**
     * 
     * @return 
     */
    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_tipo_pago, "varId_tipo_pago", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");        
        
        if (manejadorBD.ejecutarSP("grabarTipoPago") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

    /**
     * 
     * @return 
     */
    public boolean borrar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_tipo_pago, "varId_tipo_pago", "STRING", "IN");

        if (manejadorBD.ejecutarSP("eliminarTipPago") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }
}
