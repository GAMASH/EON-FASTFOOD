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
public class UnidadMedida extends TablaBD {

    public String id_unidad_medida;
    public String descripcion;
    public String nombre_corto;
    //private ManejadorBD manejadorBD;

    public UnidadMedida() {

        id_unidad_medida = "";
        descripcion = "";
        nombre_corto = "";
    }

    public void obtenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_unidad_medida, descripcion, nombre_corto, \n"
                + "       crea, modifica\n"
                + "FROM   unidad_medida\n"
                + "WHERE  id_unidad_medida = '" + id + "'");

        if (manejadorBD.getRowCount() > 0) {
            asignarValores();
        }

        desconectarBD();
    }

    public void cargarPorDescripcion(String sDescripcion) {

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_unidad_medida, descripcion, nombre_corto, \n"
                + "       crea, modifica\n"
                + "FROM   unidad_medida\n"
                + "WHERE  descripcion = '" + sDescripcion + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    private void asignarValores() {

        id_unidad_medida = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
        nombre_corto = manejadorBD.getValorString(0, 2);
    }

    public void setRegistro(Table table, long i) {

        id_unidad_medida = (String) table.getValueAt((int) i, 0);
        descripcion = (String) table.getValueAt((int) i, 1);
        nombre_corto = (String) table.getValueAt((int) i, 2);

        if (id_unidad_medida == null) {

            id_unidad_medida = "";
        }
        if (nombre_corto == null) {

            nombre_corto = "";
        }
    }

    public static void cargarUnidadesMedida(Table tabla) {

        crearTablaUnidadesMedida(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_unidad_medida, descripcion, nombre_corto, \n"
                + "       crea, modifica\n"
                + "FROM   unidad_medida\n"
                + "ORDER BY descripcion ");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(3);
        tabla.ocultarcolumna(4);

        desconectarBD();
    }

    public static Table crearTablaUnidadesMedida(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Unidad Medida", "Descripcion", "Nombre Corto", "Crea",
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
            0, 100, 100, 0,
            0
        });

        UnidadMedida unidad_medida = new UnidadMedida();

        tabla.setTablaBD(unidad_medida);

        return tabla;
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_unidad_medida, "varId_unidad_medida", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(nombre_corto, "varNombre_corto", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarUnidadMedida(?,?,?) }") == 0) {

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
        manejadorBD.parametrosSP.agregarParametro(id_unidad_medida, "varId_unidad_medida", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call eliminarUnidadMedida(?) }") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

     public static ArrayList<String> cargarUnidadesMedida() {

        ArrayList<String> lista;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   unidad_medida\n"
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
    
    public static ArrayList<UnidadMedida> unidades_medida() {

        ArrayList<UnidadMedida> lista;

        UnidadMedida unidad_medida;

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_unidad_medida, descripcion, nombre_corto \n"
                + "FROM   unidad_medida");

        lista = new ArrayList<UnidadMedida>();

        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                unidad_medida = new UnidadMedida();
                unidad_medida.setId_unidad_medida(manejadorBD.getValorString(i, 0));
                unidad_medida.setDescripcion(manejadorBD.getValorString(i, 1));
                unidad_medida.setNombrecorto(manejadorBD.getValorString(i, 2));

                lista.add(unidad_medida);
            }
        }

        desconectarBD();

        return lista;
    }

    /**
     * @return the id_unidad_medida
     */
    public String getId_unidad_medida() {
        return id_unidad_medida;
    }

    /**
     * @param id_unidad_medida the id_unidad_medida to set
     */
    public void setId_unidad_medida(String id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
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
     * @return the nombre_corto
     */
    public String getNombrecorto() {
        return nombre_corto;
    }

    /**
     * @param nombre_corto the nombre_corto to set
     */
    public void setNombrecorto(String nombre_corto) {
        this.nombre_corto = nombre_corto;
    }

}
