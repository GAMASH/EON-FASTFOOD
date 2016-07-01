/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package abstractt.visual;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Developer GAGS
 */
public class Icono extends Label{

    public String icono;
    
    /**
     * 
     * @param icono 
     */
    public Icono (String icono){
        
        this.icono = "";
    }
    
    /**
     * @param icono the icono to set
     */
    public void setIcono(String icono) {

        this.icono = icono;
        ImageIcon fot = new ImageIcon(getClass().getResource("/resources/images/" + icono));
        Icon icono_2 = new ImageIcon(fot.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
        setIcon(icono_2);
    }
}
