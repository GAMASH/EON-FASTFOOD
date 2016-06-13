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
import gui.controles.OrigenSelector;
import gui.controles.TipoPlatilloSelector;

/**
 *
 * @author Developer GAGS
 */
public class Platillo extends TablaBD {

    public String id_platillo;
    public TipoPlatillo tipo_platillo;
    public String nombre;
    public String descripcion;
    public String carta;
    public Double precio;
    public String origen;

    public Platillo() {

        id_platillo = "";
        tipo_platillo = new TipoPlatillo();
        nombre = "";
        descripcion = "";
        carta = "";
        precio = 0.00;
        origen = "";
    }

    public void obetenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_platillo, id_tipo_platillo, nombre, descripcion,\n"
                + "      carta,       precio,           origen, crea,\n"
                + "      modifica\n"
                + "FROM  platillo\n"
                + "WHERE id_platillo = '" + id + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    private void asignarValores() {

        String id_tipo_platillo;

        id_platillo = manejadorBD.getValorString(0, 0);
        id_tipo_platillo = manejadorBD.getValorString(0, 1);
        nombre = manejadorBD.getValorString(0, 2);
        descripcion = manejadorBD.getValorString(0, 3);
        carta = manejadorBD.getValorString(0, 4);
        precio = manejadorBD.getValorDouble(0, 5);
        origen = manejadorBD.getValorString(0, 6);

        tipo_platillo.obtenerPorId(id_tipo_platillo);
    }

    public static void cargarFramePlatillo(Table tabla) {

        crearTablaFramePlatillo(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_platillo, t.descripcion, nombre, p.descripcion, \n"
                + "       carta, precio, origen, \n"
                + "       p.crea, p.modifica\n"
                + "FROM   platillo p, tipo_platillo t\n"
                + "WHERE p.id_tipo_platillo = t.id_tipo_platillo\n"
                + "ORDER  BY p.nombre");

        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();

        TipoPlatilloSelector tipo_platillo_selector = new TipoPlatilloSelector();
        OrigenSelector origenSelector = new OrigenSelector();

        tabla.agregarComboBox(tipo_platillo_selector, 1);
        tabla.agregarCheckBox(4);
        tabla.agregarComboBox(origenSelector, 6);

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(7);
        tabla.ocultarcolumna(8);

        desconectarBD();
    }

    public static Table crearTablaFramePlatillo(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Platillo", "Tipo Platillo", "Nombre", "Descripcion",
            "Carta", "Precio", "Origen", "Crea",
            "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.letra, Table.numero_double, Table.letra, Table.letra,
            Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 100, 120, 600,
            50, 100, 100, 0,
            0
        });

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);

        Platillo platillo = new Platillo();

        tabla.setTablaBD(platillo);

        return tabla;
    }

    public void setRegistro(Table table, int i) {

        String tipo_platillo_des;
        OrigenSelector origenSelector;
        origenSelector = new OrigenSelector();
        origenSelector.cargar();

        id_platillo = table.getValorString(i, 0);
        tipo_platillo.cargarPorDescripcion(table.getValorString( i, 1));
        nombre = table.getValorString( i, 2);
        descripcion = table.getValorString( i, 3);
                
        carta = table.getValorBoolean(i,4);
        
        precio = table.getValorDouble( i, 5);
                                    
        origen = origenSelector.getData(table.getValorString( i, 6));
        
                
        System.out.println("carta: "+carta);
    }
    
    public boolean grabar() {

        boolean error;
        conectarBD();
                
        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(id_platillo, "varId_platillo", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(tipo_platillo.id_tipo_platillo, "varId_tipo_platillo", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(nombre, "varNombre", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(descripcion, "varDescripcion", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(carta, "varCarta", "STRING", "IN");     
        manejadorBD.parametrosSP.agregarParametro(precio.toString(), "varPrecio", "DOUBLR", "IN");      
        manejadorBD.parametrosSP.agregarParametro(origen, "varOrigen", "STRING", "IN");
        
        if (manejadorBD.ejecutarSP("{ call grabarPlatillo(?,?,?,?,?,?,?,?,?) }") == 0) {

            error = true;          
        } else {

            error = false;
        }

        desconectarBD();
        return error;
    }

}
