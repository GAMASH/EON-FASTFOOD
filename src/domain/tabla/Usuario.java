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

    public Usuario() {

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
                + "Select id_usuario, u.id_persona, login, \n"
                + "       concat(p.apellido_paterno,' ',p.apellido_materno,' ',p.nombres) usuario\n"
                + "From	usuario u left join persona p on\n"
                + "	u.id_persona = p.id_persona ");
        
        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(1);

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
            "Id Usuario", "Id Persona", "Login", "Usuario"};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 0, 100, 100
        });
        
        return tabla;
    }
}
