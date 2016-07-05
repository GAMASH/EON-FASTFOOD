/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt.visual;

/**
 *
 * @author Developer GAGS
 */
public class TextFieldPassword extends javax.swing.JPasswordField {

    public TextFieldPassword() {
        addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPerformed(evt);
            }
        });

        setFont(new java.awt.Font("Arial", 0, 11));
        
        
        
    }

    /**
     *
     * @param evt
     */
    private void ActionPerformed(java.awt.event.ActionEvent evt) {

        transferFocus();
    }

}
