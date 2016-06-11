/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import domain.tabla.Direccion;
import abstractt.TablaBD;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.manejadorBD;

/**
 *
 * @author Developer GAGS
 */
public class DatosFiscales extends TablaBD {

    private String id_datos_fiscales;
    private String razon_social;
    private String nombre_comercial;
    private String rfc;
    private Direccion direccion;

    public void obenterPorId(String id_datos_fiscales) {

        conectarBD();

        manejadorBD.consulta(""
                + "SELECT id_datos_fiscales, razon_social, nombre_comercial, \n"
                + "       rfc, id_direccion, crea, modifica\n"
                + "FROM   datos_fiscales\n"
                + "WHERE    id_datos_fiscales = '" + id_datos_fiscales + "'");

        asignarValores();

        desconectarBD();
    }

    public void asignarValores() {
     
        String crea;
        String modifica;
        String id_direccion;

        id_datos_fiscales = manejadorBD.getValorString(0, 0);
        razon_social = manejadorBD.getValorString(0, 1);
        nombre_comercial = manejadorBD.getValorString(0, 2);
        rfc = manejadorBD.getValorString(0, 3);
        id_direccion = manejadorBD.getValorString(0, 5);
        
        

    }

    /**
     * @return the razon_social
     */
    public String getRazon_social() {
        return razon_social;
    }

    /**
     * @param razon_social the razon_social to set
     */
    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    /**
     * @return the nombre_comercial
     */
    public String getNombre_comercial() {
        return nombre_comercial;
    }

    /**
     * @param nombre_comercial the nombre_comercial to set
     */
    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    /**
     * @return the rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * @param rfc the rfc to set
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * @return the id_datos_fiscales
     */
    public String getId_datos_fiscales() {
        return id_datos_fiscales;
    }

    /**
     * @param id_datos_fiscales the id_datos_fiscales to set
     */
    public void setId_datos_fiscales(String id_datos_fiscales) {
        this.id_datos_fiscales = id_datos_fiscales;
    }

}
