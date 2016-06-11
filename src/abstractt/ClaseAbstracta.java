/*
 * ClaseAbstracta.java
 *
 * Created on 20 de mayo de 2008, 10:39 AM
 *
 */

package abstractt;

import com.toedter.calendar.JDateChooser;
import domain.Fecha;
import domain.ManejadorBD;
import domain.Seguridad;
import java.awt.Component;
import java.sql.SQLException;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberto Adan Gonz�lez Silva
 */
public class ClaseAbstracta {
  
  /** Creates a new instance of ClaseAbstracta */
  public ClaseAbstracta() {
  }
  
  public ManejadorBD getMbd() {
    
    return mbd;
  }
  
  public void setManejadorBD(ManejadorBD mbd) {
    
    this.mbd = mbd;
  }
  
  /**
   *Obtiene el Maximo valor de un CAMPO numerico de una TABLA especifica
   *
   */
  protected int obtenerMaximo(String tabla, String campo,String condicion){
    
    int idCampo = 0;
    String consulta = "SELECT * FROM "+tabla;
    
    ManejadorBD mbdS = mbd.nuevaConexion();
    
    mbdS.consulta(consulta);
    
    if( mbdS.getRowCount() != 0 ){
      
      mbdS.consulta("SELECT MAX("+campo+") FROM "+tabla+" WHERE "+condicion);
      idCampo = Integer.parseInt(mbdS.getValueAt(0,0).toString()) ;
    }
    
    mbdS.desconectar();
    
    return idCampo;
  }
  
  /**
   *Obtiene el Maximo valor de un CAMPO numerico de una TABLA especifica
   *
   */
  protected int obtenerSiguiente(String tabla, String campo,String condicion){
    
    int idCampo = 1;
    String consulta = "SELECT * FROM "+tabla+" WHERE "+condicion;
    ManejadorBD mbdS = mbd.nuevaConexion();
    
    mbdS.consulta(consulta);
    
    if( mbdS.getRowCount() != 0 ){
      
      mbdS.consulta("SELECT MAX("+campo+") FROM "+tabla+" WHERE "+condicion);
      idCampo = Integer.parseInt(mbdS.getValueAt(0,0).toString()) + 1;
    }
    
    mbdS.desconectar();
    
    return idCampo;
  }
  
  /**
   *Obtiene el Maximo valor de un CAMPO numerico de una TABLA especifica
   *
   */
  protected int obtenerSiguiente(String tabla, String campo){
    
    int idCampo = 1;
    String consulta = "SELECT * FROM "+tabla;
    ManejadorBD mbdS = mbd.nuevaConexion();
    
    mbdS.consulta(consulta);
    
    if( mbdS.getRowCount() != 0 ){
      
      mbdS.consulta("SELECT MAX("+campo+") FROM "+tabla);
      idCampo = Integer.parseInt(mbdS.getValueAt(0,0).toString()) + 1;
    }
    
    mbdS.desconectar();
    
    return idCampo;
  }
  
  /**
   *
   */
  protected int dialogoConfirmacionSiNo(Object ventana,String Mensaje,String titulo, int s){
    
    Object[] botones = {"  Si  ", "  No  " };
    
    return JOptionPane.showOptionDialog((Component) ventana, Mensaje, titulo,
            JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, botones, botones[s]);
  }
      
   /**
    *
    */
   protected int dialogoConfirmacionSiNoCancelar(Object ventana,String Mensaje,String titulo, int s){
      
      Object[] botones = {"  Si  ", "  Cancelar  "," No " };
      
      return JOptionPane.showOptionDialog((Component) ventana, Mensaje.toUpperCase(), titulo,
         JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, botones, botones[s]);
   }
  
  public String nombreProceso(){
    
    return nombreProceso;
  }
  
  /**
     * Redondea un valor double en unos decimales especificados
     *
     */
    public static String redondear(double num) {

        boolean negativo = false;
        if (num < 0) {

            num *= -1;
            negativo = true;
        }

        int decimales = 2;

        double expo = Math.pow(10, decimales);
        //siguiente valor despues de los decimales
        double expo2 = Math.pow(10, decimales + 1);

        //numero siguiente al redondeado
        int num1 = ((int) (num * expo2)) - (((int) (num * expo2)) / 10) * 10;

        //si el numero es menor que 5 no aumenta el redondeo
        if (num1 < 5) {
            //num = ( (double)( (int)(num * expo)  ) )/ expo;
        } else {
            //si el numero es 5 o mayor se le suma uno al menor decimal
            num = ((double) ((int) (num * expo) + 1)) / expo;
        }
        int segundoDecimal = ((int) (num * expo)) - (((int) (num * expo)) / 10) * 10;

        // ponerComas(num+"");
        String numero;

        if (segundoDecimal == 0) {
            numero = ponerComas(num + "0");
        } else {
            numero = ponerComas(num + "");
        }

        if (negativo) {
            return "-" + numero;
        } else {
            return numero;
        }
    }


    private static String ponerComas(String num) {

        StringTokenizer stt;

        stt = new StringTokenizer(num, ".");

        String numero = stt.nextToken();
        String decimales = stt.nextToken();

        String orenum = "";
        int cont = 0;
        for (int i = numero.length() - 1; i >= 0; i--) {

            if (cont == 3) {
                orenum += ",";
                cont = 0;
            }
            orenum += numero.charAt(i);

            cont++;
        }

        numero = "";
        for (int i = orenum.length() - 1; i >= 0; i--) {

            numero += orenum.charAt(i);
        }

        return numero + "." + decimales;
    }


  
  protected String nombreProceso = "";
  
  protected ManejadorBD mbd;
  protected Seguridad seguridad;
  protected Fecha fecha;
}
