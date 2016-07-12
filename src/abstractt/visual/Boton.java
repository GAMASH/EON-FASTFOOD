/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt.visual;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Developer GAGS
 */
public class Boton extends JButton {

    public Boton() {
      //  this.setBackground(FormatoControles.color1);
        // this.setForeground(FormatoControles.color2);

        // this.setFont(FormatoControles.Fuente1);
        //  setContentAreaFilled(false);
        // this.setOpaque(true);
        // this.icono = icono;
        setFocusPainted(false);
    }

    public void redimensionarIcono() {

        if (this.getIcon() != null) {
            /*
             Image i = null;

             //this.icono = this.getIcon();
             ImageIcon fot = new ImageIcon(((ImageIcon) getIcon()).getImage());
             Icon icono_2 = new ImageIcon(fot.getImage().getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, Image.SCALE_DEFAULT));
             setIcon(icono_2);
             */           

            ImageIcon icon = new ImageIcon(((ImageIcon) getIcon()).getImage());
            Image img = icon.getImage(); //convertimos icon en una imagen
            Image otraimg = img.getScaledInstance(this.getPreferredSize().width, this.getPreferredSize().height, java.awt.Image.SCALE_REPLICATE); //creamos una imagen nueva dándole las dimensiones que queramos a la antigua
            ImageIcon otroicon = new ImageIcon(otraimg);
            setIcon(otroicon);

        }
    }

    public void cambiar() {
        //this.setBackground(FormatoControles.color5);
        //this.setForeground(FormatoControles.color3);

        //this.setFont(FormatoControles.Fuente1);
        //setContentAreaFilled(false);
        //    this.setOpaque(true);
    }

}
