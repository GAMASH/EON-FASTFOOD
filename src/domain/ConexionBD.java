/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static domain.General.manejadorBD;
import static domain.General.propiedades_generales;

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
            String server = propiedades_generales.getString("server");
            String database = propiedades_generales.getString("database");
            //    String user = rb.getString("user");
            //   String pass = rb.getString("pass");
            String port = propiedades_generales.getString("port");

            if (propiedades_generales.getString("mostrarSQL").equals("true")) {
                mostrarSQL = true;
            } else {
                mostrarSQL = false;
            }

            manejadorBD = new ManejadorBD(mostrarSQL);

            // try {
            manejadorBD.conectar("com.mysql.jdbc.Driver", "jdbc:mysql://" + server + ":" + port + "/" + database, manejadorBD.usuario, manejadorBD.palabraClave);
            /* } catch (ClassNotFoundException ex) {
             Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
                
                
             JOptionPane.showConfirmDialog(null, "1.- Error al acceder a la Base de datos\n" + ex.getMessage(), "Mensaje del sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
             } catch (SQLException ex) {
             Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showConfirmDialog(null, "2.- Error al acceder a la Base de datos\n" + ex.getMessage(), "Mensaje del sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
             } catch (InstantiationException ex) {
             Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showConfirmDialog(null, "3.- Error al acceder a la Base de datos\n" + ex.getMessage(), "Mensaje del sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
             } catch (IllegalAccessException ex) {
             Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showConfirmDialog(null, "4.- Error al acceder a la Base de datos\n" + ex.getMessage(), "Mensaje del sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
             }
             */
        }

        conteo_conexion++;

        //return manejadorBD;
    }

    public static void desconectarBD() {

        if (conteo_conexion > 0) {
            conteo_conexion--;
        }

        if (conteo_conexion == 0) {

            manejadorBD.desconectar();
        }

    }
}
