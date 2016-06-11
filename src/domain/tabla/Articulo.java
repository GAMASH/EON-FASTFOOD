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
import static domain.tabla.Marca.crearTablaMarcas;

/**
 *
 * @author Developer GAGS
 */
public class Articulo extends TablaBD {

    public String id_articulo;
    public TipoArticulo tipo_articulo;
    public String clave;
    public String descripcion;
    public String codigo_barras_entrada;
    public Impuesto impuesto;
    //public Produccion produccion;
    public String id_produccion;
    public Marca marca;
    public UnidadMedida unidad_entrada;
    public UnidadMedida unidad_salida;
    public Double factor_empaque;

    public Articulo() {
        id_articulo = "";
        tipo_articulo = new TipoArticulo();
        clave = "";
        descripcion = "";
        id_produccion = "";
        marca = new Marca();
        impuesto = new Impuesto();
        unidad_entrada = new UnidadMedida();
    }

    public void obetenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_articulo, id_tipo_articulo, clave, descripcion,\n"
                + "codigo_barras_entrada, id_impuesto, id_marca, \n"
                + "id_unidad_entrada, factor_empaque, crea, modifica\n"
                + "FROM  articulo\n"
                + "WHERE id_articulo = '" + id + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    private void asignarValores() {

        String id_tipo_articulo, id_impuesto, id_marca, id_unidad_entrada;

        id_articulo = manejadorBD.getValorString(0, 0);
        id_tipo_articulo = manejadorBD.getValorString(0, 1);
        clave = manejadorBD.getValorString(0, 2);
        descripcion = manejadorBD.getValorString(0, 3);
        codigo_barras_entrada = manejadorBD.getValorString(0, 4);
        id_impuesto = manejadorBD.getValorString(0, 5);
        id_marca = manejadorBD.getValorString(0, 6);
        id_unidad_entrada = manejadorBD.getValorString(0, 7);
        factor_empaque = manejadorBD.getValorDouble(0, 8);

        tipo_articulo.obtenerPorId(id_tipo_articulo);
        impuesto.obtenerPorId(id_impuesto);
        marca.obtenerPorId(id_marca);
        unidad_entrada.obtenerPorId(id_unidad_entrada);
    }

    public static void cargarFrameArticulos(Table tabla) {

        crearTablaFrameArticulos(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_articulo, clave, a.descripcion, \n"
                + "       codigo_barras_entrada, i.descripcion, m.descripcion, \n"
                + "       u.descripcion, a.crea, a.modifica\n"
                + "FROM   articulo a, impuesto i, marca m, unidad_medida u \n"
                + "WHERE a.id_impuesto       = i.id_impuesto\n"
                + "AND   a.id_marca          = m.id_marca\n"
                + "AND   a.id_unidad_entrada = u.id_unidad_medida\n"
                + "ORDER BY a.clave");

        // if (manejadorBD.getRowCount() > 0) {
        manejadorBD.asignarTable(tabla);
        // }

        tabla.agregarItemStatus();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(7);
        tabla.ocultarcolumna(8);

        desconectarBD();
    }

    public static Table crearTablaFrameArticulos(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Articulo", "Clave", "Descripción", "Codigo de Barras",
            "Impuesto", "Marca", "U.M.", "Crea",
            "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.numero_double, Table.letra, Table.letra, Table.letra,
            Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 100, 600, 120,
            80, 100, 100, 0,
            0
        });

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        
        Articulo articulo = new Articulo();

        tabla.setTablaBD(articulo);

        return tabla;
    }

    public boolean grabar() {

        boolean error;
        conectarBD();
                
        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_articulo, "varId_articulo", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(tipo_articulo.id_tipo_articulo, "varId_tipo_articulo", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(clave, "varClave", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(codigo_barras_entrada, "varCodigo_barras_entrada", "STRING", "IN");
        // manejadorBD.parametrosSP.agregarParametro(codigo_barras_salida, "varCodigo_barras_salida", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(impuesto.id_impuesto, "varId_impuesto", "STRING", "IN");
        //manejadorBD.parametrosSP.agregarParametro(id_produccion, "varId_produccion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(marca.id_marca, "varId_marca", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(unidad_entrada.id_unidad_medida, "varId_unidad_entrada", "STRING", "IN");
//        manejadorBD.parametrosSP.agregarParametro(unidad_salida.getId_unidad_medida(), "varId_unidad_salida", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(factor_empaque.toString(), "varFactor_empaque", "DOUBLE", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarArticulo(?,?,?,?,?,?,?,?,?) }") == 0) {

            error = true;
            id_articulo = manejadorBD.parametrosSP.get(0).getValor();
        } else {

            error = false;
        }

        desconectarBD();
        return error;
    }
}
