/*
 * To change this license header, choose License Haders in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import abstractt.visual.Table;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.manejadorBD;
import static domain.General.sucursal;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Developer GAGS
 */
public class PagoDetalle extends TablaBD {

    public String id_sucursal;
    public String id_pago;
    public String id_pago_detalle;
    public TipoPago tipo_pago;
    public Double importe;

    /**
     *
     */
    public PagoDetalle() {

        id_pago = "";
        id_pago_detalle = "";
        tipo_pago = new TipoPago();
        importe = 0.00;
    }

    /*
     select pd.id_sucursal, pd.id_pago, pd.id_pago_detalle, tp.id_tipo_pago, tp.descripcion,
     COALESCE(pd.importe, 0.00) as importe
     from  pago_detalle pd right join tipo_pago tp on
     pd.id_tipo_pago = tp.id_tipo_pago
     and pd.id_sucursal = ''
     and   pd.id_pago		=	''
     and	  pd.id_pago_detalle  = ''; 
     */
    /**
     *
     * @param tabla
     */
    public void cargarTabla(Table tabla, Pago pago) {

        crearTabla(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "select pd.id_sucursal, pd.id_pago, pd.id_pago_detalle,\n"
                + "       tp.id_tipo_pago, tp.descripcion,\n"
                + "       COALESCE(pd.importe, 0.00) as importe, pd.crea,\n"
                + "        pd.modifica\n"
                + "from pago_detalle pd right join tipo_pago tp on\n"
                + "	    pd.id_tipo_pago = tp.id_tipo_pago\n"
                + "	and pd.id_sucursal  = '" + sucursal.id_sucursal + "'\n"
                + "     and pd.id_pago	    = '" + pago.id_pago + "';");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();
        /*
         tabla.ocultarcolumna(0);
         tabla.ocultarcolumna(3);
         tabla.ocultarcolumna(4);
         */
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
            "Id Sucursal", "Id Pago", "Id Pago Detalle", "Id Tipo Pago",
            "Descripcion", "Importe", "Crea", "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.letra, Table.numero_double, Table.letra, Table.letra});
        tabla.tamañoColumna(new int[]{
            100, 100, 100, 100,
            100, 100, 100, 100});
        
        tabla.setTablaBD(this);

        return tabla;
    }

    @Override
    public void setRegistro(Table table, Integer fila) {

        id_pago = table.getValorString(fila, 1);
        id_pago_detalle = table.getValorString(fila, 2);
        tipo_pago.obtenerPorId(new ArrayList(Arrays.asList(table.getValorString(fila, 3))));
        importe = table.getValorDouble(fila, 4);
    }

}
