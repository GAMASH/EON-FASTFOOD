/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import abstractt.Table;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.manejadorBD;
import domain.ParametrosSP;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author Developer GAGS
 */
public class Impuesto extends TablaBD {

    public String id_impuesto;
    public String descripcion;
    public Double porcentaje;

    public Impuesto() {
        id_impuesto = "";
        descripcion = "";
        porcentaje = 0.0;
    }

    public static void cargarImpuestos(Table tabla) {

        crearTablaImpuestos(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_impuesto, descripcion, porcentaje, crea, modifica\n"
                + "FROM     impuesto\n"
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

    public static Table crearTablaImpuestos(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Impuesto", "Descripcion", "Porcentaje", "Crea",
            "Modifica",};

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
            0, 100, 100, 0,
            0
        });

        Impuesto impuesto = new Impuesto();

        tabla.setTablaBD(impuesto);

        return tabla;
    }

    public void obtenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_impuesto, descripcion, porcentaje, \n"
                + "       crea, modifica\n"
                + "FROM   impuesto\n"
                + "WHERE  id_impuesto = '" + id + "'");

        asignarValores();

        desconectarBD();
    }

    public void cargarPorDescripcion(String sDescripcion) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_impuesto, descripcion, porcentaje, \n"
                + "       crea, modifica\n"
                + "FROM  impuesto\n"
                + "WHERE descripcion = '" + sDescripcion + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    public void asignarValores() {

        String crea;
        String modifica;

        id_impuesto = manejadorBD.getValorString(0, 0);
        descripcion = manejadorBD.getValorString(0, 1);
        porcentaje = manejadorBD.getValorDouble(0, 2);

        //System.out.println(datos_fiscales.getNombre_comercial());
    }

    public void setRegistro(Table table, long i) {

        id_impuesto = (String) table.getValueAt((int) i, 0);
        descripcion = (String) table.getValueAt((int) i, 1);
        porcentaje = Double.parseDouble(table.getValueAt((int) i, 2).toString());

        if (id_impuesto == null) {

            id_impuesto = "";
        }
        if (descripcion == null) {

            descripcion = "S";
        }
        if (porcentaje == null) {

            porcentaje = 0.0;
        }
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_impuesto, "varId_impuesto", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(porcentaje.toString(), "varPorcentaje", "DOUBLE", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarImpuesto(?,?,?) }") == 0) {

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
        manejadorBD.parametrosSP.agregarParametro(id_impuesto, "varId_impuesto", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call eliminarImpuesto(?) }") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();

        return error;
    }

     public static ArrayList<String> cargarImpuesto() {

        ArrayList<String> lista;

        conectarBD();
        manejadorBD.consulta(""
                + "SELECT descripcion \n"
                + "FROM   impuesto\n"
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
    
    public static ArrayList<Impuesto> impuestos() {

        ArrayList<Impuesto> lista;

        Impuesto impuesto;

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_impuesto \n"
                + "FROM   impuesto");

        lista = new ArrayList<Impuesto>();

        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                impuesto = new Impuesto();

                impuesto.obtenerPorId(manejadorBD.getValorString(0, 0));

                lista.add(impuesto);
            }
        }

        desconectarBD();

        return lista;
    }

}
