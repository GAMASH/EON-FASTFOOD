/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt;

import abstractt.visual.Table;
import static domain.General.manejadorBD;
import domain.MovUsuario;
import java.util.ArrayList;

/**
 *
 * @author Developer GAGS
 */
public class TablaBD {

    private MovUsuario crea;
    private MovUsuario modifica;
    public Integer num_pk = 1;
    public ArrayList pk;

    public TablaBD(){
        pk = new ArrayList();
    }
    
    /**
     * Funcion para cargar la Tabla
     */
    public void cargarTabla(Table table1) {

        System.out.println("TablaBD.cargar: Funcion no Implementada");
    }

    /**
     * Funcion para crear la TABla del frame 
     * @param tabla
     * @return 
     */
    private Table crearTabla(Table tabla) {

        System.out.println("TablaBD.crearTabla: Funcion no Implementada");
        return null;
    }

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
    public void obtenerPorId(ArrayList id) {

       // System.out.println("TablaBD.obtenerPorId-funcion no implementada");
    }
    
    /**
     * 
     */
     private void asignarValores() {
         System.out.println("TablaBD.asignarValores-funcion no implementada");
     }

    /**
     * Graba el Objeto en BD si ya tiene id realiza UPDATE si no tiene id
     * realiza INSERT
     *
     * @return
     */
    public boolean grabar() {
        System.out.println("TablaBD.grabar-funcion no implementada");
        return true;
    }

    /**
     * Funion para borrar un registro de BD
     *
     * @return
     */
    public boolean borrar() {
        System.out.println("TablaBD.borrar-funcion no implementada");
        return true;
    }

    /**
     * Funcion para obtener el objeto de BD de una tabla
     *
     * @param table
     * @param i
     */
    public void setRegistro(Table table, Integer i) {
        System.out.println("TablaBD.setRegistro-funcion no implementada");
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

    /**
     * funcion para generar selector
     *
     * @return
     */
    public ArrayList<String> cargar() {

        System.out.println("TablaBD.cargar funcion no implementada");
        return null;
    }

    /**
     * funcion para buscar en la bd por descripcion
     *
     * @param toString
     */
    public void cargarPorDescripcion(String toString) {
        System.out.println("TablaBD.cargarPorDescripcion funcion no implementada");
    }

    /**
     * funcion para
     *
     * @return
     */
    public String getDescripcion() {
        System.out.println("TablaBD.getDescripcion funcion no implementada");
        return "";
    }
    
    public String toString(){
        
        return this.toString();
    }

  
}
