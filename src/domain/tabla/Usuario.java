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

/**
 *
 * @author Developer GAGS
 */
public class Usuario extends TablaBD {

    public String id_usuario;
    public Persona persona;
    public String login;
    public String password;
    
    public Usuario(){
        
        id_usuario = "";
        persona = new Persona();
        login = "";
        password = "";                
    }   
    
    /**
     *
     * @param tabla
     */
    public void cargarTabla(Table tabla) {

        crearTabla(tabla);
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

    /**
     *
     * @param tabla
     * @return
     */
    private Table crearTabla(Table tabla) {

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
    
    
}
