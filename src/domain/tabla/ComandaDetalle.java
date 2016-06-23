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
import java.util.ArrayList;

/**
 *
 * @author Developer GAGS
 */
public class ComandaDetalle extends TablaBD {

    public String id_sucursal;
    public String id_comanda;
    public String id_comanda_detalle;
    public Platillo platillo;
    public int num_comensal;
    public String status;
    public String observaciones;
    public Double precio;
    public int orden;

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
    
    public ArrayList<ComandaDetalle> cargarPorId(Comanda comanda, int num_comensales){
    
        ArrayList<ComandaDetalle> comanda_detalle;
        
        comanda_detalle =  new ArrayList<ComandaDetalle>();
        
        
        
        
        return comanda_detalle;    
    }

    public static void cargarComandaDetalle(Table tabla, Comanda comanda, int comensal) {

        crearTablaComandaDetalle(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "select cd.id_sucursal, cd.id_comanda, \n"
                + "       cd.id_comanda_detalle,\n "
                + "       cd.id_platillo, p.descripcion, cd.num_comensal, \n"
                + "       case cd.status \n"
                + "        when 'PE' then 'Pendiente'\n"
                + "        when 'PR' then 'Proceso'\n"
                + "        when 'SE' then 'Servido'\n"
                + "       end as status, cd.observaciones, cd.precio,\n"
                + "       cd.orden\n"
                + "from   comanda_detalle cd, platillo p\n"
                + "where  cd.id_platillo = p.id_platillo\n"
                + "and    cd.id_sucursal = '" + sucursal.id_sucursal + "'\n"
                + "and    cd.id_comanda = '" + comanda.id_comanda + "'\n"
                + "and    num_comensal = case " + comensal + " when 0 then num_comensal\n"
                + "                                        when " + comensal + " then " + comensal + " end");

        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();
        tabla.alinear();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(1);
        tabla.ocultarcolumna(2);
        tabla.ocultarcolumna(3);
        tabla.ocultarcolumna(5);

        desconectarBD();

    }

    private static Table crearTablaComandaDetalle(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Sucursl", "Id Comanda", "Id Comanda Detalle", "Id Platillo",
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
            0, 0, 0, 0,
            100, 0, 100, 100,
            100, 100
        });

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        ComandaDetalle comanda_detalle = new ComandaDetalle();

        tabla.setTablaBD(comanda_detalle);

        return tabla;
    }

}