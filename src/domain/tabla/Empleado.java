/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.manejadorBD;
import static domain.General.sucursal;
import domain.ParametrosSP;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Developer GAGS
 */
public class Empleado extends TablaBD {

    public String id_sucursal;
    public String id_empleado;
    public TipoEmpleado tipo_empleado;
    public Usuario usuario;

    public Empleado() {

        id_empleado = "";
        tipo_empleado = new TipoEmpleado();
        usuario = new Usuario();
    }

    public void obtenerPorUsuario(String id_usuario) {

        conectarBD();

        manejadorBD.consulta(
                "SELECT	 id_sucursal, id_empleado, id_tipo_empleado,\n"
                + "id_usuario, crea, modifica\n"
                + "FROM  empleado\n"
                + "WHERE id_usuario = '" + id_usuario + "'\n"
                + "and id_sucursal = '" + sucursal.id_sucursal + "';");

        if (manejadorBD.getRowCount() > 0) {

            asignarValores();
        }

        desconectarBD();
    }

    public void asignarValores() {

        String id_tipo_empleado;
        String id_usuario;

        id_empleado = manejadorBD.getValorString(0, 1);
        id_tipo_empleado = manejadorBD.getValorString(0, 2);
        id_usuario = manejadorBD.getValorString(0, 3);

        tipo_empleado.obtenerPorId(new ArrayList(Arrays.asList(id_tipo_empleado)));
    }

    public boolean grabar() {

        boolean error;
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(this.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_empleado, "varId_empleado", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(tipo_empleado.id_tipo_empleado, "varId_tipo_empleado", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(usuario.id_usuario, "varId_usuario", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarEmpleado(?,?,?,?) }") == 0) {

            error = true;
        } else {

            error = false;
        }

        desconectarBD();

        return error;
    }
    
    

}
