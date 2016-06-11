/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt;

import static domain.General.manejadorBD;
import domain.MovUsuario;

/**
 *
 * @author Developer GAGS
 */
public class TablaBD {

    private MovUsuario crea;
    private MovUsuario modifica;

    /**
     * Funcion pendiente
     */
    public void obtenerCreaModifica() {

        int pos;

        pos = manejadorBD.getColumnCount() - 2;

        crea.id_mov_usuario = manejadorBD.getValorString(0, pos);
        //crea.cargarPorId();

        modifica.id_mov_usuario = manejadorBD.getValorString(0, pos + 1);
        //modifica.cargarPorId();                
    }

    /**
     * Busca el Registro de BD por id
     *
     * @param id
     */
    public void obtenerPorId(String id) {

        System.out.println("obtenerPorId-funcion no implementada");
    }

    /**
     * Graba el Objeto en BD si ya tiene id realiza UPDATE si no tiene id
     * realiza INSERT
     *
     * @return
     */
    public boolean grabar() {
        System.out.println("grabar-funcion no implementada");
        return true;
    }

    /**
     * Funion para borrar un registro de BD
     *
     * @return
     */
    public boolean borrar() {
        System.out.println("borrar-funcion no implementada");
        return true;
    }

    /**
     * Funcion para obtener el objeto de BD de una tabla
     *
     * @param table
     * @param i
     */
    public void setRegistro(Table table, long i) {
        System.out.println("setRegistro-funcion no implementada");
    }

    /**
     * @return the crea
     */
    public MovUsuario getCrea() {
        return crea;
    }

    /**
     * @param crea the crea to set
     */
    public void setCrea(MovUsuario crea) {
        this.crea = crea;
    }

    /**
     * @return the modifica
     */
    public MovUsuario getModifica() {
        return modifica;
    }

    /**
     * @param modifica the modifica to set
     */
    public void setModifica(MovUsuario modifica) {
        this.modifica = modifica;
    }
}
