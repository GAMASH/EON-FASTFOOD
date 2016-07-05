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
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

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

    @Override
    public void obtenerPorId(ArrayList pk) {

        this.pk = pk;

        conectarBD();

        manejadorBD.consulta(""
                + "Select id_usuario, u.id_persona, login, \n"
                + "       password \n"
                + "From	usuario u left join persona p on\n"
                + "	u.id_persona = p.id_persona "
                + "where id_usuario = '"+pk.get(0)+"'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    private void asignarValores() {

        String id_persona;

        id_usuario = manejadorBD.getValorString(0, 0);
        id_persona = manejadorBD.getValorString(0, 1);
        login = manejadorBD.getValorString(0, 2);
        password = manejadorBD.getValorString(0, 3);

        persona.obtenerPorId(new ArrayList(Arrays.asList(id_persona)));

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
    
    public boolean grabar(){
        
        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(this.id_usuario, "varId_usuario", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(persona.id_persona, "varId_persona", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(this.login, "varLogin", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(this.password, "varPassword", "STRING", "IN");
        
        if (manejadorBD.ejecutarSP("{ call grabarUsuario(?,?,?,?) }") == 0) {

            error = true;
            //si se esta cambiando el password del usuario logeado
            if( login.equals(manejadorBD.usuario)){
                
                //actualiza el password de la conexion actual
                manejadorBD.palabraClave = this.password;
            }
        } else {                                    
            
            error = false;
        }

        desconectarBD();

        return error;
    }        

    public String toString() {

        String Sreturn;
        Sreturn = "Usuario: " + id_usuario + "; Login: " + login;
        return Sreturn;
    }
}
