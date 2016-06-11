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
public class Marca extends TablaBD {

    public String id_marca;
    private String descripcion;
    private String activo;
    // private ManejadorBD manejadorBD;

    public Marca() {

        id_marca = "";
        descripcion = "";
        activo = "";
    }

    public void cargarPorDescripcion(String sDescripcion) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_marca, descripcion, activo\n"
                + "FROM  marca\n"
                + "WHERE descripcion = '" + sDescripcion + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    public void obtenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_marca, descripcion, activo\n"
                + "FROM  marca\n"
                + "WHERE id_marca = '" + id + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }
    
    private void asignarValores() {

        id_marca = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
        activo = manejadorBD.getValorString(0, 2);
    }

    public void setRegistro(Table table, long i) {

        id_marca = (String) table.getValueAt((int) i, 0);
        descripcion = (String) table.getValueAt((int) i, 1);
        activo = (String) table.getValueAt((int) i, 2);

        if (id_marca == null) {

            id_marca = "";
        }
        if (activo == null) {

            activo = "S";
        }
    }

    public static void cargarMarcas(Table tabla) {

        crearTablaMarcas(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_marca, descripcion, activo, crea, modifica\n"
                + "FROM     marca\n"
                + "WHERE    activo = 'S'\n"
                + "ORDER BY descripcion ");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(2);
        tabla.ocultarcolumna(3);
        tabla.ocultarcolumna(4);

        desconectarBD();
    }

    public static Table crearTablaMarcas(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Marca", "Descripcion", "Activo", "Crea",
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

        Marca marca = new Marca();

        tabla.setTablaBD(marca);

        return tabla;
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_marca, "varId_marca", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(activo, "varActivo", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarMarca(?,?,?) }") == 0) {

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
        manejadorBD.parametrosSP.agregarParametro(id_marca, "varId_marca", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call eliminarMarca(?) }") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

    public static ArrayList<String> cargarMarcas() {

        ArrayList<String> lista;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   marca\n"
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

    public static ArrayList<Marca> marcas() {

        ArrayList<Marca> lista;

        Marca marca;

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_marca, descripcion, activo \n"
                + "FROM   marca");

        lista = new ArrayList<Marca>();

        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                marca = new Marca();
                marca.setId_marca(manejadorBD.getValorString(i, 0));
                marca.setDescripcion(manejadorBD.getValorString(i, 1));
                marca.setActivo(manejadorBD.getValorString(i, 2));

                lista.add(marca);
            }
        }

        desconectarBD();

        return lista;
    }

    /**
     * @return the id_marca
     */
    public String getId_marca() {
        return id_marca;
    }

    /**
     * @param id_marca the id_marca to set
     */
    public void setId_marca(String id_marca) {
        this.id_marca = id_marca;
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
