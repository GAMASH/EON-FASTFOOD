/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt.visual;

import domain.General;
import javax.swing.JTextArea;

/**
 *
 * @author Developer GAGS
 */
public class TextArea extends JTextArea {

    public TextArea() {
        
        setFont(General.font_textarea);
    }
}
