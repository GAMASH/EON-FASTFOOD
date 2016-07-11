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
import java.util.ArrayList;

/**
 *
 * @author Developer GAGS
 */
public class TipoPlatillo extends TablaBD {
    
    public String id_tipo_platillo;
    public String descripcion;
    
     public TipoPlatillo() {

        id_tipo_platillo = "";
        descripcion = "";
    }

    public void cargarPorDescripcion(String sDescripcion) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_tipo_platillo, descripcion\n"
                + "FROM  tipo_platillo\n"
                + "WHERE descripcion = '" + sDescripcion + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    public void obtenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_tipo_platillo, descripcion\n"
                + "FROM  tipo_platillo\n"
                + "WHERE id_tipo_platillo = '" + id + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }
    
    private void asignarValores() {

        id_tipo_platillo = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
        
    }

    public void setRegistro(Table table, Integer i) {

        id_tipo_platillo = (String) table.getValueAt( i, 0);
        descripcion = (String) table.getValueAt( i, 1);
        

        if (id_tipo_platillo == null) {

            id_tipo_platillo = "";
        }
        
    }

    public static void cargarTiposPlatillo(Table tabla) {

        crearTablaTiposPlatillo(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_tipo_platillo, descripcion, crea, modifica\n"
                + "FROM     tipo_platillo\n"
                + "ORDER BY descripcion ");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(2);
        tabla.ocultarcolumna(3);
        

        desconectarBD();
    }

    public static Table crearTablaTiposPlatillo(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Tipo Platillo", "Descripcion", "Crea",
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

        TipoPlatillo tipo_platillo = new TipoPlatillo();

        tabla.setTablaBD(tipo_platillo);

        return tabla;
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_tipo_platillo, "varId_tipo_platillo", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        
        if (manejadorBD.ejecutarSP("grabarTipoPlatillo") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

    public boolean borrar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_tipo_platillo, "varId_tipo_platillo", "STRING", "IN");

        if (manejadorBD.ejecutarSP("eliminarTipoPlatillo") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

    public static ArrayList<String> cargarTipoPlatillos() {

        ArrayList<String> lista;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   tipo_platillo\n"
                + "ORDER BY descripcion");

        lista = new ArrayList<String>();

        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                lista.add(manejadorBD.getValorString(i, 0));
            }
        }

        desconectarBD();

        return lista;
    }

    public static ArrayList<TipoPlatillo> tipo_platillos() {

        ArrayList<TipoPlatillo> lista;

        TipoPlatillo tipo_platillo;

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_tipo_platillo, descripcion \n"
                + "FROM   tipo_platillo");

        lista = new ArrayList<TipoPlatillo>();

        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                tipo_platillo = new TipoPlatillo();
                tipo_platillo.setId_tipo_platillo(manejadorBD.getValorString(i, 0));
                tipo_platillo.setDescripcion(manejadorBD.getValorString(i, 1));
               
                lista.add(tipo_platillo);
            }
        }

        desconectarBD();

        return lista;
    }

    /**
     * @return the id_tipo_platillo
     */
    public String getId_tipo_platillo() {
        return id_tipo_platillo;
    }

    /**
     * @param id_tipo_platillo the id_tipo_platillo to set
     */
    public void setId_tipo_platillo(String id_tipo_platillo) {
        this.id_tipo_platillo = id_tipo_platillo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    
}
