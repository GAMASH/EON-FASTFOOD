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

    public String getDescripcion(){
        return login;
    }
    
    @Override
    public void obtenerPorId(ArrayList pk) {

        this.pk = pk;

        conectarBD();

        manejadorBD.consulta(""
                + "Select id_usuario, u.id_persona, login, \n"
                + "       password \n"
                + "From	  usuario u left join persona p on\n"
                + "	u.id_persona = p.id_persona "
                + "where id_usuario = '" + pk.get(0) + "'");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }
    
    
    public void cargarPorLogin(String login) {
        
        conectarBD();

        manejadorBD.consulta(""
                + "Select id_usuario, u.id_persona, login, \n"
                + "       password \n"
                + "From	usuario u left join persona p on\n"
                + "	u.id_persona = p.id_persona "
                + "where login = '" + login + "'");

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
                + "Select id_usuario, u.id_persona, \n"
                + "       concat(p.apellido_paterno,' ',p.apellido_materno,' ',p.nombres) usuario,\n"
                + "         login\n"
                + "From	usuario u left join persona p on\n"
                + "	u.id_persona = p.id_persona ");

        manejadorBD.asignarTable(tabla);

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        
        tabla.agregarItemStatus();

        tabla.ocultarColumnas(new int[]{0,1});
        tabla.setEditables(new boolean[]{false,false,false,false});
        

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
            "Id Usuario", "Id Persona", "Nombre","Login"};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra});
        tabla.tamañoColumna(new int[]{
            0, 0, 600, 100
        });

        return tabla;
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(this.id_usuario, "varId_usuario", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(persona.id_persona, "varId_persona", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(this.login, "varLogin", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(this.password, "varPassword", "STRING", "IN");

        if (manejadorBD.ejecutarSP("grabarUsuario") == 0) {

            error = true;
            //si se esta cambiando el password del usuario logeado
            if (login.equals(manejadorBD.usuario)) {

                //actualiza el password de la conexion actual
                manejadorBD.palabraClave = this.password;
            }
             id_usuario = manejadorBD.parametrosSP.get(0).getValor();
            
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
                + "SELECT login \n"
                + "FROM   usuario\n"
                + "ORDER BY login");

        lista = new ArrayList<String>();

        lista.add("");
        
        if (manejadorBD.getRowCount() > 0) {

            for (int i = 0; i < manejadorBD.getRowCount(); i++) {

                lista.add(manejadorBD.getValorString(i, 0));
            }
        }

        desconectarBD();

        return lista;
    }
    
    public String toString() {

        String Sreturn;
        Sreturn = "Usuario: " + id_usuario + "; Login: " + login;
        return Sreturn;
    }
}
