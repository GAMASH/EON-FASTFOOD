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

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                FocusGained(evt);
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

    /**
     *
     * @param evt
     */
    private void FocusGained(java.awt.event.FocusEvent evt) {

        seleccionarTexto();
    }

    /**
     * Dado un TextFiledPassword el texto se muestra seleccionado para su
     * edicion rapida
     */
    public String seleccionarTexto() {

        select(0, getText().length());
        return getText();
    }

}
