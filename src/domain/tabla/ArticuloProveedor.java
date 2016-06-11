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
public class ArticuloProveedor extends TablaBD {

    public String id_articulo;
    public String id_proveedor;
    public String clave_catalogo;
    public Double costo;

    public ArticuloProveedor() {

        id_articulo = "";
        id_proveedor = "";
        clave_catalogo = "";
        costo = 0.00;

    }

    public static void cargarArticuloProveedor(Table tabla, Articulo a) {

        crearTablaArticuloProveedor(tabla);

        conectarBD();

        manejadorBD.consulta(""
                + "select ap.id_articulo, ap.id_proveedor, d.nombre_comercial, ap.clave_catalogo,\n"
                + "       ap.costo,       ap.crea,         ap.modifica\n"
                + "from   articulo_proveedor ap, proveedor p, datos_fiscales d\n"
                + "where  ap.id_proveedor     = p.id_proveedor\n"
                + "and    p.id_datos_fiscales = d.id_datos_fiscales\n"
                + "and    ap.id_articulo = '" + a.id_articulo + "'\n"
                + "order by nombre_comercial");

        manejadorBD.asignarTable(tabla);

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(1);
        tabla.ocultarcolumna(5);
        tabla.ocultarcolumna(6);

        tabla.setEnabled(false);

        desconectarBD();
    }

    public static Table crearTablaArticuloProveedor(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Articulo", "Id Proveedor", "Proveedor", "Clave Catalogo",
            "Costo", "Crea", "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.numero_double, Table.letra, Table.letra});

        tabla.tamañoColumna(new int[]{
            000, 0, 100, 100,
            100, 0, 000
        });

        ArticuloProveedor articuloProveedor = new ArticuloProveedor();
        tabla.setTablaBD(articuloProveedor);
        return tabla;
    }

}
