/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import abstractt.Table;
import domain.ParametrosSP;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.manejadorBD;
import java.util.ArrayList;

/**
 *
 * @author Developer GAGS
 */
public class TipoArticulo extends TablaBD {

    public String id_tipo_articulo;
    public String descripcion;
    public String activo;
    // private ManejadorBD manejadorBD;

    public TipoArticulo() {

        id_tipo_articulo = "";
        descripcion = "";
        activo = "";
    }

    public void cargarPorDescripcion(String sDescripcion) {

        conectarBD();
        
        manejadorBD.consulta(
                "SELECT	 id_tipo_articulo, descripcion, activo\n"
                + "FROM  tipo_articulo\n"
                + "WHERE descripcion = '" + sDescripcion + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }
        
        desconectarBD();
    }

    public void obtenerPorId(String id) {

        conectarBD();

       manejadorBD.consulta(
                "SELECT	 id_tipo_articulo, descripcion, activo\n"
                + "FROM  tipo_articulo\n"
                + "WHERE id_tipo_articulo = '" + id + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }
    
    private void asignarValores() {

        id_tipo_articulo = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
        activo = manejadorBD.getValorString(0, 2);
    }

    public void setRegistro(Table table, long i) {

        id_tipo_articulo = (String) table.getValueAt((int) i, 0);
        descripcion = (String) table.getValueAt((int) i, 1);
        activo = (String) table.getValueAt((int) i, 2);

        if (id_tipo_articulo == null) {

            id_tipo_articulo = "";
        }
        if (activo == null) {

            activo = "S";
        }
    }

    public static void cargarTiposArticulos(Table tabla) {

        crearTablaTipoArticulo(tabla);

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_tipo_articulo, descripcion, activo, crea, modifica\n"
                + "FROM     tipo_articulo\n"
                + "WHERE    activo = 'S'\n"
                + "ORDER BY descripcion ");

        //if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        //}

        tabla.agregarItemStatus();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(2);
        tabla.ocultarcolumna(3);
        tabla.ocultarcolumna(4);

        desconectarBD();
    }

    public static Table crearTablaTipoArticulo(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Tipo Articulo", "Descripcion", "Activo", "Crea",
            "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 100, 0, 0,
            0
        });

        TipoArticulo tipoArticulo = new TipoArticulo();

        tabla.setTablaBD(tipoArticulo);

        return tabla;
    }

    public boolean grabar() {

        boolean error;
        //ManejadorBD manejadorBD;

        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_tipo_articulo, "varId_tipo_articulo", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(activo, "varActivo", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarTipoArticulo(?,?,?) }") == 0) {

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
        manejadorBD.parametrosSP.agregarParametro(id_tipo_articulo, "varId_tipo_articulo", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call eliminarTipoArticulo(?) }") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

    public static ArrayList<String> cargarTiposArticulo() {

        ArrayList<String> lista;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   tipo_articulo\n"
                + "WHERE activo = 'S'\n"
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

    public static ArrayList<TipoArticulo> tipos_articulo() {

        ArrayList<TipoArticulo> lista;

        TipoArticulo tipo_articulo;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT id_tipo_articulo, descripcion, activo \n"
                + "FROM   tipo_articulo");

        lista = new ArrayList<TipoArticulo>();

        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                tipo_articulo = new TipoArticulo();
                tipo_articulo.setId_tipo_articulo(manejadorBD.getValorString(i, 0));
                tipo_articulo.setDescripcion(manejadorBD.getValorString(i, 1));
                tipo_articulo.setActivo(manejadorBD.getValorString(i, 2));

                lista.add(tipo_articulo);
            }
        }

        desconectarBD();

        return lista;
    }

    /**
     * @return the id_tipo_articulo
     */
    public String getId_tipo_articulo() {
        return id_tipo_articulo;
    }

    /**
     * @param id_tipo_articulo the id_tipo_articulo to set
     */
    public void setId_tipo_articulo(String id_tipo_articulo) {
        this.id_tipo_articulo = id_tipo_articulo;
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

    /**
     * @return the activo
     */
    public String getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(String activo) {
        this.activo = activo;
    }
}
