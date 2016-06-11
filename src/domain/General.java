/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import abstractt.InternalFrameAbstracto;
import domain.tabla.Sucursal;
import java.util.ResourceBundle;

/**
 *
 * @author Developer GAGS
 */
public class General {

    public static ResourceBundle rb;
    public static Sucursal sucursal;

    /**
     *
     */
    public static ManejadorBD manejadorBD;
    
    public static void cargarConfiguracion(){
        
        rb = ResourceBundle.getBundle("resorces.general-conf");
    }
    
    public static void cargarParametrosIniciales(){
                        
        sucursal = new Sucursal();
        sucursal.obenterPorId(rb.getString("sucursal"));
    }
    
   
}
