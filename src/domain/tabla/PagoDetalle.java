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
import static domain.General.formatoDateTime_11;
import static domain.General.manejadorBD;
import static domain.General.sucursal;
import domain.ParametrosSP;
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
                + "       round(COALESCE(pd.importe, 0.00),2) as importe, \n"
                + "       pd.crea,\n"
                + "       pd.modifica\n"
                + "from pago_detalle pd right join tipo_pago tp on\n"
                + "	    pd.id_tipo_pago = tp.id_tipo_pago\n"
                + "	and pd.id_sucursal  = '" + sucursal.id_sucursal + "'\n"
                + "     and pd.id_pago	    = '" + pago.id_pago + "';");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();

        tabla.ocultarColumnas(new int[]{
            0, 1, 2, 3, 6, 7});

        tabla.setEditables(new boolean[]{
            false, false, false, false,
            false, true, false, false});

        tabla.alinear();

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
            "Descripción", "Importe", "Crea", "Modifica",};

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
        importe = table.getValorDouble(fila, 5);
    }

    
    /**
     *
     * @return
     */
    public boolean grabar() {

        boolean error = true;

        conectarBD();

        System.out.println(this);

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_pago, "varId_pago", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_pago_detalle, "varId_pago_detalle", "STRING", "INOUT");                    
        manejadorBD.parametrosSP.agregarParametro(tipo_pago.id_tipo_pago, "varId_tipo_pago", "STRING", "IN");                    
        manejadorBD.parametrosSP.agregarParametro(importe.toString(), "varImporte", "DOUBLE", "IN");

        if (manejadorBD.ejecutarSP("grabarPagoDetalle") == 0) {

            error = true;
            id_pago_detalle = manejadorBD.parametrosSP.get(2).getValor();
            
        } else {

            error = false;
        }

        desconectarBD();

        return error;
    }
    
    
}
