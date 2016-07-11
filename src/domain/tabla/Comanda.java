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
import static domain.General.formatoDateTime_11;
import static domain.General.formatoDate_2;
import static domain.General.manejadorBD;
import static domain.General.mensaje;
import static domain.General.sucursal;
import domain.ParametrosSP;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Developer GAGS
 */
public class Comanda extends TablaBD {

    public String id_sucursal;
    public String id_comanda;
    public String folio;
    public Date fecha;
    public Mesa mesa;
    public Empleado mesero;
    public String status;
    public Pago pago;
    public Double Subtotal;
    Double impuesto;
    Double total;
    Double propina;
    Date fecha_termino;
    Integer num_comensales;

    /**
     *
     */
    public Comanda() {

        id_comanda = "";
        folio = "";
        fecha = new Date();
        mesa = new Mesa();
        mesero = new Empleado();
        pago = new Pago();
        Subtotal = 0.00;
        impuesto = 0.00;
        total = 0.00;
        propina = 0.00;
        fecha_termino = new Date();
        num_comensales = 0;

    }

    /**
     *
     * @param table
     * @param i
     */
    public void setRegistro(Table table, Integer i) {

        conectarBD();

        try {
            String id_mesa;
            String id_mesero;

            id_comanda = table.getValorString(i, 0);
            id_mesa = table.getValorString(i, 1);
            fecha = formatoDateTime_11.parse(table.getValorString(i, 5));
            status = table.getValorString(i, 6);
            id_mesero = table.getValorString(i, 7);
            folio = table.getValorString(i, 8);

            mesa.obetenerPorId(id_mesa);
            mesero.obtenerPorId(new ArrayList(Arrays.asList(id_mesero)));

            //status = statusMesaSelector.getData(table.getValorString(i, 4));
        } catch (ParseException ex) {

            mensaje(ex.getMessage());
            //  Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
        }

        desconectarBD();
    }

    /**
     *
     * @param tabla
     */
    public static void cargarFrameMesaComanda(Table tabla) {

        crearTablaFrameMesaComanda(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "select c.id_comanda, m.id_mesa, numero_mesa, \n"
                + "       case m.status \n"
                + "         when 'D' then 'Disponible'\n"
                + "         when 'O' then 'Ocupada'\n"
                + "         when 'R' then 'Reservada' end mes_status,\n"
                + "         coalesce(c.folio,'') com_folio, \n"
                + "         coalesce(c.fecha,NOW()) com_fecha, \n"
                + "         coalesce( case c.status \n"
                + "                   when 'PE' then 'Pendiente'\n"
                + "                   when 'PT' then 'Pedido Tomado'\n"
                + "                   when 'PR' then 'Proceso'\n"
                + "                   when 'SE' then 'Servido' \n"
                + "                   when 'PA' then 'Pagado'                    \n"
                + "                   end, 'Disponible') com_status,\n"
                + "         c.id_mesero, c.folio\n"
                + "from mesa m left outer join comanda c on\n"
                + "         m.id_sucursal = c.id_sucursal\n"
                + "	 and m.id_mesa     = c.id_mesa\n"
                + "where m.id_sucursal = '" + sucursal.id_sucursal + "'\n"
                + "order by numero_mesa; ");

        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();
        tabla.alinear();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(1);

        desconectarBD();

    }

    /**
     *
     * @return
     */
    private String convierteStatus() {

        switch (status) {
            case "Pendiente":
                return "PE";
            case "Pedido Tomado":
                return "PT";
            case "Proceso":
                return "PR";
            case "Servido":
                return "SE";
            case "Pagado":
                return "PA";
        }

        return "";
    }

    /**
     *
     * @param tabla
     * @return
     */
    private static Table crearTablaFrameMesaComanda(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Sucursal", "Id Mesa", "Numero Mesa", "Estatus Mesa",
            "Folio", "Fecha", "Estatus Comanda", "id Mesero", "folio"};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.letra, Table.fecha, Table.letra, Table.letra, Table.letra});

        tabla.tamañoColumna(new int[]{
            0, 100, 120, 600,
            50, 100, 100, 100, 100
        });

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        /*
         Comanda comanda = new Comanda();

         tabla.setTablaBD(comanda);
         */
        return tabla;
    }

    /**
     *
     * @return
     */
    public String toString() {

        String comandaString;

        comandaString = ""
                + "sucursal = " + sucursal.id_sucursal + ", "
                + "comanda = " + this.id_comanda + ", "
                + "folio = " + folio + ", "
                + "fecha = {" + fecha + "}, "
                + "mesa = " + mesa.id_mesa + ", "
                + "mesero = " + mesero.id_empleado + ", "
                + "status = " + status + "{" + convierteStatus() + "}, "
                + "pago = " + pago.id_pago + ", "
                + "subtotal = " + Subtotal + ", "
                + "impuesto = " + impuesto + ", "
                + "total = " + total + ", "
                + "propina = " + propina + ", "
                + "fecha_termino = {" + fecha_termino + "}, "
                + "num_comensales = " + num_comensales.toString();
        return comandaString;
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
        manejadorBD.parametrosSP.agregarParametro(id_comanda, "varId_comanda", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(folio, "varFolio", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(formatoDateTime_11.format(fecha), "varFecha", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(mesa.id_mesa, "varId_mesa", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(mesero.id_empleado, "varId_mesero", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(convierteStatus(), "varStatus", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(pago.id_pago, "varId_pago", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(Subtotal.toString(), "varSubtotal", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(impuesto.toString(), "varImpuesto", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(total.toString(), "varTotal", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(propina.toString(), "varPropina", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(formatoDateTime_11.format(fecha_termino), "varFecha_termino", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(num_comensales.toString(), "varNum_comensales", "INT", "IN");

        if (manejadorBD.ejecutarSP("grabarComanda") == 0) {

            error = true;
            id_comanda = manejadorBD.parametrosSP.get(1).getValor();
            folio = manejadorBD.parametrosSP.get(2).getValor();
        } else {

            error = false;
        }

        desconectarBD();

        return error;
    }

}
