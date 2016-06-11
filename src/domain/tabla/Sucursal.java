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

/**
 *
 * @author Developer GAGS
 */
public class Sucursal extends TablaBD{

    private String id_sucursal;
    public DatosFiscales datos_fiscales;
    
    public Sucursal(){
        
        datos_fiscales = new DatosFiscales();
    }
    
    public void obenterPorId(String id){
             
        conectarBD();

        manejadorBD.consulta(""
                + "SELECT   id_sucursal, id_datos_fiscales, crea, modifica\n"
                + "FROM     sucursal\n"
                + "WHERE    id_sucursal = '"+id+"'");
        
        asignarValores();        
        
        desconectarBD();
    }
    
    public void asignarValores(){
        
        String id_datos_fiscales;
        String crea;
        String modifica;
        
        id_sucursal         =   manejadorBD.getValorString(0, 0);
        id_datos_fiscales   =   manejadorBD.getValorString(0, 1);
        
        datos_fiscales.obenterPorId(id_datos_fiscales);
        
        //System.out.println(datos_fiscales.getNombre_comercial());
    }    
    
    /**
     * @return the id_sucursal
     */
    public String getId_sucursal() {
     
        return id_sucursal;
    }

    /**
     * @param id_sucursal the id_sucursal to set
     */
    public void setId_sucursal(String id_sucursal) {
        
        id_sucursal = id_sucursal;
    }    
}
