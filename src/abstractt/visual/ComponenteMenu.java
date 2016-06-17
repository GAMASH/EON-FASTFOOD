/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt.visual;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sperez
 */
public class ComponenteMenu extends Panel {

    /**
     * M menu O opcion P panel opciones
     */
    private String tipo = "P";
    Color normal;
    Color mouse_entered;
    Color click;
    Color seleccionado;
    String estado;

    ArrayList<ComponenteMenu> componentes;
    boolean expandido = false;
    Integer alto_componentes;
    Integer alto_total;
    Integer ancho;
    private ComponenteMenu parentComponenteAcordeon;
    private String icono;
    private Integer interno;

    /**
     * Creates new form MenuAcordeon
     */
    public ComponenteMenu() {

        initComponents();

        this.setBackground(normal);

        componentes = new ArrayList<ComponenteMenu>();
        alto_componentes = 30;
        alto_total = alto_componentes;

        contraerRetraer();
        estado = "N";
        ancho = 160;
        interno = 4;
    }

    public void setTipo(String aTipo) {

        tipo = aTipo;

        switch (tipo) {
            case "P":

                normal = mouse_entered = click = seleccionado = new Color(109, 201, 229);
                expandido = true;
                break;
            case "M":

                normal = new Color(239, 135, 66);
                mouse_entered = new Color(255, 255, 255);
                click = new Color(255, 155, 0);
                seleccionado = new Color(255, 125, 0);
                break;

            case "O":

                normal = new Color(110, 230, 118);
                mouse_entered = new Color(255, 255, 255);
                click = new Color(125, 255, 0);
                seleccionado = new Color(255, 125, 0);
                break;
        }

        this.setBackground(normal);
    }
/*
    @Override
    protected void paintComponent(Graphics g) {

        Color color = null;

        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        float x = getWidth();
        float y = getHeight();
        label1.setForeground(new java.awt.Color(255, 255, 255));
        switch (estado) {

            case "N":
                color = normal;

                break;
            case "ME":
                color = mouse_entered;
                label1.setForeground(new java.awt.Color(100, 100, 100));
                break;
            case "CL":
                color = click;
                break;
        }

        g2.setPaint(new GradientPaint(0.0f, 0.0f, color.darker(),
                0.0f, getHeight(), color.brighter()));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }
*/
    public void setTexto(String texto) {

        this.label1.setText(texto);
    }

    public void agregar(ComponenteMenu opcion) {

        opcion.setParentComponenteAcordeon(this);

        componentes.add(opcion);
        add(opcion);
        opcion.ancho = this.getWidth() - (interno * 2);

        opcion.setBounds(interno, componentes.size() * alto_componentes, opcion.ancho, alto_componentes);

        if (opcion.tipo.equals("M") && tipo.equals("M")) {
            //colores mas brillantes en 5 del padre
            opcion.normal = new Color(aumNumColor(normal.getRed()), aumNumColor(normal.getGreen()), aumNumColor(normal.getBlue()));
            opcion.mouse_entered = new Color(aumNumColor(mouse_entered.getRed()), aumNumColor(mouse_entered.getGreen()), aumNumColor(mouse_entered.getBlue()));
            opcion.click = new Color(aumNumColor(click.getRed()), aumNumColor(click.getGreen()), aumNumColor(click.getBlue()));
            opcion.seleccionado = new Color(aumNumColor(seleccionado.getRed()), aumNumColor(seleccionado.getGreen()), aumNumColor(seleccionado.getBlue()));
        }

        //  System.out.println("soy " + this.label1.getText() + " ancho  " + opcion.getWidth());
    }

    public int aumNumColor(int numero) {

        numero += 30;

        if (numero > 255) {
            numero = 255;
        }

        return numero;
    }

    public void contraerRetraer() {

        if (tipo.equals("M")) {

            expandido = !expandido;

            resize();
        }
    }

    public void resize() {
        
        if (tipo.equals("M") || tipo.equals("P")) {

            int posicion = alto_componentes;
            //System.out.println("soy " + this.label1.getText() + " ");
            ComponenteMenu c1;

            if (expandido) {
                //Expander
                //System.out.println("Expandiendo");
                alto_total = alto_componentes;

                for (int i = 0; i < componentes.size(); i++) {

                    c1 = componentes.get(i);
                    //        System.out.println("\t" + c1.label1.getText() + " tamaño:" + c1.alto_total + " posicion: " + posicion);
                    
                    c1.setBounds(interno, posicion, c1.ancho, c1.alto_total);
                    
                    posicion += c1.alto_total;
                    alto_total += c1.alto_total;
                }

                if (componentes.size() > 0) {

                    alto_total += interno;
                }
            } else {
                //Contraer
                //  System.out.println("Contrayendo");
                alto_total = alto_componentes;
            }

            if (tipo.equals("M")) {
                this.setSize(this.getWidth(), alto_total);
            }
            //System.out.println("Alto Total:" + alto_total);
            if (parentComponenteAcordeon != null) {

                parentComponenteAcordeon.resize();
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new abstractt.visual.Label();
        label2 = new abstractt.visual.Label();

        setBackground(new java.awt.Color(0, 153, 204));
        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });
        setLayout(null);

        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Opcion");
        label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        add(label1);
        label1.setBounds(39, 2, 160, 28);

        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resorces/images/user.png"))); // NOI18N
        add(label2);
        label2.setBounds(2, -1, 27, 28);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

        this.setBackground(mouse_entered);
        estado = "ME";
        //contraido = true;
        //resize();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited

        this.setBackground(normal);
        estado = "N";
    }//GEN-LAST:event_formMouseExited

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.setBackground(click);
        estado = "CL";
        this.contraerRetraer();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the parentComponenteAcordeon
     */
    public ComponenteMenu getParentComponenteAcordeon() {
        return parentComponenteAcordeon;
    }

    /**
     * @param parentComponenteAcordeon the parentComponenteAcordeon to set
     */
    public void setParentComponenteAcordeon(ComponenteMenu parentComponenteAcordeon) {
        this.parentComponenteAcordeon = parentComponenteAcordeon;
    }

    /**
     * @return the icono
     */
    public String getIcono() {
        return icono;
    }

    /**
     * @param icono the icono to set
     */
    public void setIcono(String icono) {

        this.icono = icono;
        label2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resorces/images/" + icono)));
    }
}
