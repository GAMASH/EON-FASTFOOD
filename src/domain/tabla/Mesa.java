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
import static domain.General.sucursal;
import domain.ParametrosSP;
import gui.controles.StatusMesaSelector;

/**
 *
 * @author Developer GAGS
 */
public class Mesa extends TablaBD {

    // public String id_sucursal;
    public String id_mesa;
    public String numero_mesa;
    public String status;
    public Integer num_comensales;

    public Mesa() {

        id_mesa = "";
        numero_mesa = "";
        status = "";
        num_comensales = 0;
    }

    public void obetenerPorId(String id) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_sucursal, id_mesa, numero_mesa,\n"
                + "      num_comensales, status, crea,\n"
                + "      modifica\n"
                + "FROM  mesa\n"
                + "WHERE id_mesa = '" + id + "'\n"
                + "AND id_sucursal = '" + sucursal.id_sucursal + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    private void asignarValores() {

        //id_sucursal  = manejadorBD.getValorString(0, 0);
        id_mesa = manejadorBD.getValorString(0, 1);
        numero_mesa = manejadorBD.getValorString(0, 2);
        num_comensales = manejadorBD.getValorInt(0, 3);
        status = manejadorBD.getValorString(0, 4);
    }

    public void cargarTabla(Table tabla) {

        crearTabla(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_sucursal, id_mesa, numero_mesa, num_comensales,\n"
                + "         case status\n"
                + "         when 'D' then 'Disponible'\n"
                + "         when 'O' then 'Ocupada'\n"
                + "         when 'R' then 'Reservada'\n"
                + "         end as status,      crea,    modifica\n"
                + "FROM     mesa\n"
                + "ORDER BY numero_mesa");

        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();
        tabla.centrar();
        
        StatusMesaSelector statusMesaSelector= new StatusMesaSelector();
        
        tabla.agregarComboBox(statusMesaSelector, 4);
        
        tabla.ocultarColumnas(new int[]{0,1,5,6});        

        desconectarBD();
    }

    public Table crearTabla(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id sucursal", "Id Mesa", "Numero Mesa", "Numero Comensales",
            "Estado", "Crea", "Modifica",};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();

        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.numero_entero,
            Table.letra, Table.letra, Table.letra});

        tabla.tamañoColumna(new int[]{
            0, 0, 40, 80,
            30,0, 0
        });

        Mesa mesa = new Mesa();

        tabla.setTablaBD(mesa);

        return tabla;
    }

    public void setRegistro(Table table, Integer i) {

        StatusMesaSelector statusMesaSelector = new StatusMesaSelector();
        statusMesaSelector.cargar();
        
        //id_sucursal = (String) table.getValueAt((int) i, 0);
        id_mesa = table.getValorString(i, 1);
        numero_mesa = table.getValorString(i, 2);
        num_comensales = table.getValorInt(i, 3);
        status = statusMesaSelector.getData(table.getValorString(i, 4));                
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_mesa, "varId_mesa", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(numero_mesa, "varNumero_mesa", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(num_comensales.toString(), "varNum_comensales", "INT", "IN");
        manejadorBD.parametrosSP.agregarParametro(status, "varStatus", "STRING", "IN");

        if (manejadorBD.ejecutarSP("grabarMesa") == 0) {

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
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_mesa, "varId_mesa", "STRING", "IN");

        if (manejadorBD.ejecutarSP("eliminarMesa") == 0) {

            error = true;
        } else {
            
            error = false;
        }

        desconectarBD();

        return error;
    }
}
