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
import static domain.General.sucursal;
import domain.ParametrosSP;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Developer GAGS
 */
public class ComandaDetalle extends TablaBD {

    public String id_sucursal;
    public String id_comanda;
    public String id_comanda_detalle;
    public Platillo platillo;
    public Integer num_comensal;
    public String status;
    public String observaciones;
    public Double precio;
    public Integer orden;

    /**
     *
     */
    public ComandaDetalle() {

        id_sucursal = "";
        id_comanda = "";
        id_comanda_detalle = "";
        platillo = new Platillo();
        num_comensal = 0;
        status = "PE";
        observaciones = "";
        precio = 0.00;
        orden = 0;
    }

    /**
     * Carga comanda detalles por Comanda
     */
    public ArrayList<ComandaDetalle> cargarPorComanda(Comanda comanda, Integer num_comensales) {

        ArrayList<ComandaDetalle> comanda_detalle_lista;
        ComandaDetalle comanda_detalle;

        comanda_detalle_lista = new ArrayList<ComandaDetalle>();

        manejadorBD.parametrosSP = new ParametrosSP();

        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(comanda.id_comanda, "varId_comanda", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(num_comensales + "", "varNum_comensales", "STRING", "INOUT");

        if (manejadorBD.ejecutarSP("ComandaDetalle") == 0) {

            manejadorBD.setConsultaSP();

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                comanda_detalle = new ComandaDetalle();

                // comanda_detalle.cargarPorId();
                comanda_detalle_lista.add(comanda_detalle);
            }
        }

        return comanda_detalle_lista;
    }

    /**
     *
     * @param table
     * @param i
     */
    public void setRegistro(Table table, Integer i) {

        id_comanda = table.getValorString(i, 1);
        id_comanda_detalle = table.getValorString(i, 2);
        platillo.obtenerPorId(new ArrayList(Arrays.asList(table.getValorString(i, 3))));
        this.num_comensal = table.getValorInt(i, 5);
        this.status = table.getValorString(i, 6);
        this.observaciones = table.getValorString(i, 7);
        this.precio = table.getValorDouble(i, 8);
        this.orden = table.getValorInt(i, 9);

    }

    private String convierteStatus() {

        switch (status) {
            case "Pendiente":
                return "PE";
            case "Proceso":
                return "PR";
            case "Servido":
                return "SE";
        }

        return "";
    }

    /**
     *
     * @param tabla
     * @param id_comanda
     * @param comensal
     */
    public static void cargarComandaDetalle(Table tabla, String id_comanda, int comensal) {

        crearTablaComandaDetalle(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "select cd.id_sucursal, cd.id_comanda, \n"
                + "       cd.id_comanda_detalle,\n "
                + "       cd.id_platillo, p.nombre, cd.num_comensal, \n"
                + "       case cd.status \n"
                + "        when 'PE' then 'Pendiente'\n"
                + "        when 'PR' then 'Proceso'\n"
                + "        when 'SE' then 'Servido'\n"
                + "       end as status, cd.observaciones, round(cd.precio,2),\n"
                + "       cd.orden\n"
                + "from   comanda_detalle cd, platillo p\n"
                + "where  cd.id_platillo = p.id_platillo\n"
                + "and    cd.id_sucursal = '" + sucursal.id_sucursal + "'\n"
                + "and    cd.id_comanda = '" + id_comanda + "'\n"
                + "and    num_comensal = case " + comensal + " when 0 then num_comensal\n"
                + "                                        when " + comensal + " then " + comensal + " end");

        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();
        tabla.alinear();

        tabla.ocultarColumnas(new int[]{0, 1, 2, 3, 5});

        tabla.setEditables(new boolean[]{
            false, false, false, false,
            false, false, false, true,
            false, true});

        desconectarBD();

    }

    private static Table crearTablaComandaDetalle(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Sucural", "Id Comanda", "Id Comanda Detalle", "Id Platillo",
            "Platillo", "Comensal", "Estatus", "Observaciones",
            "Precio", "Orden"};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.letra, Table.numero_entero, Table.letra, Table.letra,
            Table.numero_double, Table.numero_entero});

        tabla.tamañoColumna(new int[]{
            100, 100, 100, 100,
            100, 100, 100, 300,
            100, 100
        });

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        ComandaDetalle comanda_detalle = new ComandaDetalle();

        tabla.setTablaBD(comanda_detalle);

        return tabla;
    }

    /**
     *
     * @return
     */
    public boolean grabar() {

        boolean error = true;

        conectarBD();

        // System.out.println(this);
        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_comanda, "varId_comanda", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_comanda_detalle, "varId_comanda_detalle", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(platillo.id_platillo, "varId_platillo", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(this.num_comensal.toString(), "varNum_comensal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(convierteStatus(), "varStatus", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(observaciones, "varObservaciones", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(precio.toString(), "varPrecio", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(orden.toString(), "varOrden", "INT", "IN");

        if (manejadorBD.ejecutarSP("grabarComandaDetalle") == 0) {

            error = true;
            id_comanda_detalle = manejadorBD.parametrosSP.get(2).getValor();
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

        boolean error = true;

        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_comanda, "varId_comanda", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_comanda_detalle, "varId_comanda_detalle", "STRING", "IN");
        
        if (manejadorBD.ejecutarSP("eliminarComandaDetalle") == 0) {

            error = true;         
        } else {

            error = false;
        }

        desconectarBD();

        return error;
    }

    public boolean equals(Object obj) {

        if (obj instanceof ComandaDetalle) {

            ComandaDetalle tmpComandaDetalle = (ComandaDetalle) obj;

            if (tmpComandaDetalle.id_comanda.equals(id_comanda)
                    && tmpComandaDetalle.id_comanda_detalle.equals(id_comanda_detalle)
                    && tmpComandaDetalle.platillo.id_platillo.equals(platillo.id_platillo)
                    && tmpComandaDetalle.num_comensal.equals(num_comensal)
                    && tmpComandaDetalle.convierteStatus().equals(convierteStatus())
                    //  && tmpComandaDetalle.observaciones.equals(observaciones)
                    && tmpComandaDetalle.precio.equals(precio)) {
                //  && tmpComandaDetalle.orden.equals(orden)) {

                return true;
            }
        }

        return false;
    }

    public String toString() {

        String sToString;

        sToString = "id_comanda: " + this.id_comanda + ", "
                + "id_comanda_detalle: " + id_comanda_detalle + ", "
                + "Platillo: [" + platillo.toString() + "],"
                + "num_comensal: " + num_comensal + ","
                + "status: " + convierteStatus() + ","
                + "observaciones: " + observaciones + ","
                + "precio: " + precio + ", "
                + "orden: " + orden;

        return sToString;

    }

}
