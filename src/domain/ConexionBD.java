/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static domain.General.manejadorBD;
import static domain.General.rb;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Developer GAGS
 */
public class ConexionBD {

    public static int conteo_conexion = 0;

    public static void conectarBD() {

        if (conteo_conexion == 0) {

           // rb = ResourceBundle.getBundle("resorces.general-conf");
            boolean mostrarSQL;
            String server = rb.getString("server");
            String database = rb.getString("database");
        //    String user = rb.getString("user");
            //   String pass = rb.getString("pass");
            String port = rb.getString("port");

            if (rb.getString("mostrarSQL").equals("true") ){
                mostrarSQL = true;
            }else{
                mostrarSQL= false;
            }
            
            manejadorBD = new ManejadorBD(mostrarSQL);
                        
            try {
                manejadorBD.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://" + server + ":" + port + "/" + database, manejadorBD.usuario, manejadorBD.palabraClave);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        conteo_conexion++;

       
        
        //return manejadorBD;
    }

    public static void desconectarBD() {

        if (conteo_conexion > 0) {
            conteo_conexion--;
        } 
        
        if (conteo_conexion == 0 ){

            manejadorBD.desconectar();
        }

       
    }
}
