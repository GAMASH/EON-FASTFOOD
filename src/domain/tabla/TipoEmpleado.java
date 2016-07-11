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
public class TipoEmpleado extends TablaBD {

    public String id_tipo_empleado;
    public String descripcion;

    public TipoEmpleado() {

        id_tipo_empleado = "";
        descripcion = "";
    }

    public void obtenerPorId(ArrayList pk) {

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_tipo_empleado, descripcion, crea, modifica\n"
                + "FROM   tipo_empleado\n"
                + "WHERE  id_tipo_empleado = '" + pk.get(0).toString() + "'");

        asignarValores();

        desconectarBD();
    }

    public void cargarPorDescripcion(String sDescripcion) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_tipo_empleado, descripcion, crea, modifica\n"
                + "FROM  tipo_empleado\n"
                + "WHERE descripcion = '" + sDescripcion + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    public void asignarValores() {

        String crea;
        String modifica;

        id_tipo_empleado = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
    }

    /**
     *
     * @param tabla
     */
    @Override
    public void cargarTabla(Table tabla) {

        crearTabla(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_tipo_empleado, descripcion, crea, modifica\n"
                + "FROM     tipo_empleado\n"
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

    private Table crearTabla(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Tipo Empleado", "Descripcion", "Crea", "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.numero_double, Table.letra,
            Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 100, 0, 0
        });

        TipoEmpleado tipo_empleado = new TipoEmpleado();

        tabla.setTablaBD(tipo_empleado);

        return tabla;
    }

    public void setRegistro(Table table, Integer i) {

        id_tipo_empleado = (String) table.getValueAt(i, 0);
        descripcion = (String) table.getValueAt(i, 1);

        if (id_tipo_empleado == null) {

            id_tipo_empleado = "";
        }
        if (descripcion == null) {

            descripcion = "S";
        }

    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_tipo_empleado, "varId_tipo_empleado", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");

        if (manejadorBD.ejecutarSP("grabarTipoEmpleado") == 0) {

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
        manejadorBD.parametrosSP.agregarParametro(id_tipo_empleado, "varId_tipo_empleado", "STRING", "IN");

        if (manejadorBD.ejecutarSP("eliminarTipoEmpleado") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

    public ArrayList<String> cargar() {

        ArrayList<String> lista;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   tipo_empleado\n"
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
    /*
     public static ArrayList<TipoEmpleado> tipos_empleado() {

     ArrayList<TipoEmpleado> lista;

     TipoEmpleado id_tipo_empleado;

     conectarBD();

     manejadorBD.consulta(""
     + "SELECT id_tipo_empleado \n"
     + "FROM   tipo_empleado");

     lista = new ArrayList<TipoEmpleado>();

     if (manejadorBD.getRowCount() > 0) {

     for (int i = 0; i < manejadorBD.getRowCount(); i++) {

     id_tipo_empleado = new TipoEmpleado();

     id_tipo_empleado.obtenerPorId(manejadorBD.getValorString(0, 0));

     lista.add(id_tipo_empleado);
     }
     }

     desconectarBD();

     return lista;
     }
     */
    
    public String getDescripcion(){
        return descripcion;
    }

}
