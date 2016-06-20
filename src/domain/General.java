/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractt.visual.InternalFrameAbstracto;
import domain.tabla.Sucursal;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
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

    //Label
    public static Font font_label;
    public static Color color_font_label;
    //TextArea
    public static Font font_textarea;

    public static SimpleDateFormat formatoDateTime;
    public static SimpleDateFormat formatoDateTime_1;
    public static SimpleDateFormat formatoDateTime_11;
    public static SimpleDateFormat formatoDateTime_2;
    public static SimpleDateFormat formatoDateTime_21;
    public static SimpleDateFormat formatoDateTime3;
    public static SimpleDateFormat formatoDate;

    /**
     *
     */
    public static ManejadorBD manejadorBD;

    public static void cargarConfiguracion() {

        propiedades_generales = ResourceBundle.getBundle("resorces.general-conf");
        propiedades_visuales = ResourceBundle.getBundle("resorces.visual-conf");
        propiedades_datahardcored = ResourceBundle.getBundle("resorces.data-hard-cored");

        cargarParametrosVisuales();

        formatoDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        formatoDateTime_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formatoDateTime_11 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");

        formatoDateTime_2 = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        formatoDateTime_21 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        formatoDateTime3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");

        formatoDate = new SimpleDateFormat("yyyy-MM-dd");

    }

    public static void cargarParametrosVisuales() {

        if (propiedades_visuales.getString("gradient").equals("true")) {

            gradient = true;
        }

        if (propiedades_visuales.getString("escala_grises").equals("true")) {

            escala_grises = true;
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

    public static void mensajeError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
