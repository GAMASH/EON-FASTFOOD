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

/**
 *
 * @author Developer GAGS
 */
public class ArticuloSucursal extends TablaBD {

    public String id_sucursal;
    public String id_articulo;
    public Double ultimo_costo;
    public Double costo_promedio;
    public Double precio;
    public Double precio_2;
    public Double precio_3;
    public Double precio_4;
    public Double precio_5;
    public Double margen;
    public Double margen_1;
    public Double margen_2;
    public Double margen_3;
    public Double margen_4;
    public Double margen_5;
    public Double existencia;
    public Double minimo;
    public Double maximo;
    public Double promedio_vta;

    public ArticuloSucursal() {

        id_sucursal = "";
        id_articulo = "";
        ultimo_costo = 0.00;
        costo_promedio = 0.00;
        precio = 0.00;
        precio_2 = 0.00;
        precio_3 = 0.00;
        precio_4 = 0.00;
        precio_5 = 0.00;
        margen = 0.00;
        margen_1 = 0.00;
        margen_2 = 0.00;
        margen_3 = 0.00;
        margen_4 = 0.00;
        margen_5 = 0.00;
        existencia = 0.00;
        minimo = 0.00;
        maximo = 0.00;
        promedio_vta = 0.00;
    }

    public void cargarPorId(String id_suc, String id_art) {

        id_sucursal = id_suc;
        id_articulo = id_art;
        
        cargarPorId();
    }
    
    public void cargarPorId() {

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_sucursal, id_articulo, ultimo_costo, \n"
                + "       costo_promedio,precio,precio_2,precio_3,precio_4\n"
                + "       precio_5,margen,margen_1,margen_2,margen_3,margen_4,\n"
                + "       margen_5,existencia,minimo,maximo,promedio_vta\n"
                + "from   articulo_sucursal\n"
                + "where  id_sucursal = '" + id_sucursal + "'\n"
                + "and    id_articulo = '" + id_articulo + "'");

        asignarValores();

        desconectarBD();
    }

    public void asignarValores() {

        id_sucursal = manejadorBD.getValorString(0, 0);
        id_articulo = manejadorBD.getValorString(0, 1);
        ultimo_costo = manejadorBD.getValorDouble(0, 2);
        costo_promedio = manejadorBD.getValorDouble(0, 3);
        precio = manejadorBD.getValorDouble(0, 4);
        precio_2 = manejadorBD.getValorDouble(0, 5);
        precio_3 = manejadorBD.getValorDouble(0, 6);
        precio_4 = manejadorBD.getValorDouble(0, 7);
        precio_5 = manejadorBD.getValorDouble(0, 8);
        margen = manejadorBD.getValorDouble(0, 9);
        margen_1 = manejadorBD.getValorDouble(0, 10);
        margen_2 = manejadorBD.getValorDouble(0, 11);
        margen_3 = manejadorBD.getValorDouble(0, 12);
        margen_4 = manejadorBD.getValorDouble(0, 13);
        margen_5 = manejadorBD.getValorDouble(0, 14);
        existencia = manejadorBD.getValorDouble(0, 15);
        minimo = manejadorBD.getValorDouble(0, 16);
        maximo = manejadorBD.getValorDouble(0, 17);
        promedio_vta = manejadorBD.getValorDouble(0, 18);
    }

    public static void cargarSucursalesArticulo(Table tabla, Articulo a) {

        crearTablaSucursalesArticulo(tabla);

        conectarBD();

        manejadorBD.consulta(""
                + "select a.id_sucursal, a.id_articulo, nombre_comercial, \n"
                + "       coalesce(existencia,0.00), a.crea, a.modifica\n"
                + "from   articulo_sucursal a, sucursal s ,  datos_fiscales d\n"
                + "where  a.id_sucursal       = s.id_sucursal\n"
                + "and    a.id_articulo       = '" + a.id_articulo + "'\n"
                + "and    s.id_datos_fiscales = d.id_datos_fiscales\n"
                + "order by nombre_comercial");

        //if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        //}

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(1);
        tabla.ocultarcolumna(4);
        tabla.ocultarcolumna(5);

        tabla.setEnabled(false);

        desconectarBD();
    }

    public static Table crearTablaSucursalesArticulo(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Sucursal", "Id Articulo", "Sucursal", "Existencia",
            "Crea", "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.numero_double,
            Table.letra, Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 0, 100, 100,
            0, 0
        });

        //TipoArticulo tipoArticulo = new TipoArticulo();
        //tabla.setTablaBD(tipoArticulo);
        return tabla;
    }

}
