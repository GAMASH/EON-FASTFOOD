/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import abstractt.InternalFrameAbstracto;
import domain.tabla.Sucursal;
import java.awt.Color;
import java.awt.Font;
import java.util.ResourceBundle;

/**
 *
 * @author Developer GAGS
 */
public class General {

    public static ResourceBundle propiedades_generales;
    public static ResourceBundle propiedades_visuales;
    public static ResourceBundle propiedades_datahardcored;
    public static Sucursal sucursal;
    //Label
    public static Font font_label;
    public static Color color_font_label;
    //TextArea
    public static Font font_textarea;

    /**
     *
     */
    public static ManejadorBD manejadorBD;

    public static void cargarConfiguracion() {

        propiedades_generales = ResourceBundle.getBundle("resorces.general-conf");
        propiedades_visuales = ResourceBundle.getBundle("resorces.visual-conf");
        propiedades_datahardcored = ResourceBundle.getBundle("resorces.data-hard-cored");
    }

    public static void cargarParametrosIniciales() {

        sucursal = new Sucursal();
        sucursal.obenterPorId(propiedades_generales.getString("sucursal"));

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
}
