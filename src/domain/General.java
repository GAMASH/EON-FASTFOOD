/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.tabla.Sucursal;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Developer GAGS
 */
public class General {

    public static ResourceBundle propiedades_generales;
    public static ResourceBundle propiedades_visuales;
    public static ResourceBundle propiedades_datahardcored;
    public static Sucursal sucursal;

    public static boolean gradient = false;
    public static boolean escala_grises = false;
    public static boolean gradient_invert = false;
    

    //Label
    public static Font font_label;
    public static Color color_font_label;
    //TextArea
    public static Font font_textarea;

    public static SimpleDateFormat formatoDateTime_1;
    public static SimpleDateFormat formatoDateTime_11;
    public static SimpleDateFormat formatoDateTime_12;

    public static SimpleDateFormat formatoDateTime_2;
    public static SimpleDateFormat formatoDateTime_21;
    public static SimpleDateFormat formatoDateTime_22;

    public static SimpleDateFormat formatoDate_1;
    
    public static SimpleDateFormat formatoDate_2;

    /**
     *
     */
    public static ManejadorBD manejadorBD;

    public static void cargarConfiguracion() {

        propiedades_generales = ResourceBundle.getBundle("resources.general-conf");
        propiedades_visuales = ResourceBundle.getBundle("resources.visual-conf");
        propiedades_datahardcored = ResourceBundle.getBundle("resources.data-hard-cored");

        cargarParametrosVisuales();

        formatoDateTime_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        formatoDateTime_11 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatoDateTime_12 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");

        formatoDateTime_2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        formatoDateTime_21 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoDateTime_22 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");

        formatoDate_1 = new SimpleDateFormat("yyyy-MM-dd");
        formatoDate_2 = new SimpleDateFormat("dd/MM/yyyy");
    }

    public static void cargarParametrosVisuales() {

        if (propiedades_visuales.getString("gradient").equals("true")) {

            gradient = true;
        }

        if (propiedades_visuales.getString("escala_grises").equals("true")) {

            escala_grises = true;
        }
        
         if (propiedades_visuales.getString("gradient_invert").equals("true")) {

            gradient_invert = true;
        }

        font_label = new Font(
                propiedades_visuales.getString("label_font"),
                Integer.parseInt(propiedades_visuales.getString("label_font_type")),
                Integer.parseInt(propiedades_visuales.getString("label_font_size")));

        color_font_label = new Color(
                Integer.parseInt(propiedades_visuales.getString("label_color_r")),
                Integer.parseInt(propiedades_visuales.getString("label_color_g")),
                Integer.parseInt(propiedades_visuales.getString("label_color_b")));

        font_textarea = new Font(
                propiedades_visuales.getString("textarea_font"),
                Integer.parseInt(propiedades_visuales.getString("textarea_font_type")),
                Integer.parseInt(propiedades_visuales.getString("textarea_font_size")));
    }

    public static void cargarParametrosIniciales() {

        sucursal = new Sucursal();
        sucursal.obenterPorId(propiedades_generales.getString("sucursal"));

    }

    public static void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    
    public int asignarPorcentajeColor() {

        int randomNum;
        int minimum = 0;
        int maximum = 4;
        int porc_color = 51;

        randomNum = minimum + (int) (Math.random() * maximum);

        randomNum *= porc_color;
        if (randomNum < 255) {
            randomNum += porc_color;
        }

        return randomNum;
    }

    public Color asignarColor() {
        int r;
        int g;
        int b;

        r = asignarPorcentajeColor();

        if (r == 51) {
            do {
                g = asignarPorcentajeColor();

            } while (g == 51);
        } else {
            g = asignarPorcentajeColor();
        }

        if (r == 51 || g == 51) {

            do {
                b = asignarPorcentajeColor();

            } while (b == 51);
        } else {
            b = asignarPorcentajeColor();
        }

        System.out.println(r + "," + g + "," + b);

        Color color = new Color(r, g, b);
        return color;
    }
    
    /**
     * Si el numero tiene comas se las quita
     *
     *
     * @param numero
     * @return
     */
    public static String obtenerNumero(String numero) {

        StringTokenizer num = new StringTokenizer(numero, ",");

        numero = "";

        while (num.hasMoreTokens()) {
            numero += num.nextToken();
        }
        return numero;
    }
    
    public static Color escalaGrises(Color color){
        
        int color_med;
        
        if (escala_grises) {

            color_med = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

            color = new Color(color_med, color_med, color_med);
        }
        
        return color;
        
    }

}
