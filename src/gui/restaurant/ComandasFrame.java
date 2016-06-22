/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.restaurant;

import abstractt.visual.InternalFrameAbstracto;
import static abstractt.visual.StatusBar.etiqueta_centro;
import static abstractt.visual.StatusBar.etiqueta_derecha;
import static abstractt.visual.StatusBar.etiqueta_izquierda;
import abstractt.visual.Table;
import domain.tabla.Comanda;
import static domain.tabla.Comanda.cargarFrameMesaComanda;
import static gui.Principal.escritorio;
import static gui.Principal.statusBar1;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JViewport;

/**
 *
 * @author sperez
 */
public class ComandasFrame extends InternalFrameAbstracto {

    private Table tabla1 = null;
    ArrayList<ComandaPanel> comandas;
    int mouseStartX;
    int mouseStartY;

    /**
     * Creates new form ComandasFrame
     */
    public ComandasFrame() {

        initComponents();
        comandas = new ArrayList<ComandaPanel>();

        MouseAdapter mouseAdapter = new MouseAdapter() {

            public void mouseDragged(MouseEvent e) {

                arrastreMouse(e);
            }

            public void mousePressed(MouseEvent e) {

                clickMouse(e);
            }
        };

        jScrollPane2.getViewport().addMouseListener(mouseAdapter);
        jScrollPane2.getViewport().addMouseMotionListener(mouseAdapter);

    }

    private void arrastreMouse(MouseEvent e) {

        // System.out.println("arrastre");
        JViewport viewPort = jScrollPane2.getViewport();
        Point vpp = viewPort.getViewPosition();
        vpp.translate(mouseStartX - e.getX(), mouseStartY - e.getY());
        panel1.scrollRectToVisible(new Rectangle(vpp, viewPort.getSize()));
    }

    private void clickMouse(MouseEvent e) {

        // System.out.println("CLick");
        mouseStartX = e.getX();
        mouseStartY = e.getY();
    }

    @Override
    public void cargaValores() {

        tabla1 = new Table();

        Comanda comanda = null;
        ComandaPanel comandaPanel;

        cargarFrameMesaComanda(tabla1);

        for (int i = 0; i < tabla1.getRowCount(); i++) {

            comanda = new Comanda();
            comandaPanel = new ComandaPanel();

            //leer datos de la comanda del Table
            comanda.setRegistro(tabla1, i);

            comandaPanel.setComanda(comanda);

            //añadir su listener
            comandaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {

                    // System.out.println("Panel CLik");
                    cargarComanda(evt);
                }

                public void mouseDragged(java.awt.event.MouseEvent e) {

                    // System.out.println("Panel Arrastre");
                    arrastreMouse(e);
                }

                public void mousePressed(java.awt.event.MouseEvent e) {

                    // System.out.println("Pres panel");
                    panel1.requestFocus();
                    clickMouse(e);
                }
            });

            //agregar al panel del frame
            //  comandaPanel.setBackground(asignarColor());
            panel1.add(comandaPanel);
            comandas.add(comandaPanel);
        }

        mostrarComandas();
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

    public void mostrarComandas() {

        int posX = 0, posY = 0;
        int heigth_panel = 110;
        int width_panel = 325;
        int separatorX = 10, separatorY = 10;

        int sum_width = 0;
        int sum_height = posY + heigth_panel;

        ComandaPanel comandaPanel;

        posY += separatorY;

        for (int i = 0; i < comandas.size(); i++) {

            comandaPanel = comandas.get(i);
            posX += separatorX;
            sum_width = posX + width_panel;

            if (sum_width + separatorX > this.jScrollPane2.getWidth() - jScrollPane2.getVerticalScrollBar().getWidth() && i != 0) {

                posX = separatorX;
                posY += heigth_panel + separatorY;
            }

            comandaPanel.setBounds(posX, posY, width_panel, heigth_panel);
            posX += width_panel;
        }

        sum_height = posY + heigth_panel + separatorY;

        if (sum_height > this.jScrollPane2.getHeight()) {

            panel1.setPreferredSize(new Dimension(separatorX + width_panel + separatorX, sum_height));
        } else {

            panel1.setPreferredSize(new Dimension(separatorX + width_panel + separatorX, separatorY + heigth_panel + separatorY));
        }
    }

    public void cargarComanda(java.awt.event.MouseEvent evt) {

        ComandaPanel comandaPanel;
        comandaPanel = (ComandaPanel) evt.getComponent();
        System.out.println(comandaPanel.getComanda().mesa.numero_mesa);
        statusBar1.mensaje("MESA: " + comandaPanel.getComanda().mesa.numero_mesa, etiqueta_izquierda);
        
        if (comandaCaptura == null) {

            comandaCaptura = new ComandaCaptura();
        }
        if (!comandaCaptura.isVisible()) {

            comandaCaptura = new ComandaCaptura();

            comandaCaptura.cargaValores();
            //articulosFrame.centrado(escritorio.getSize());            
            escritorio.remove(comandaCaptura);
            escritorio.add(comandaCaptura);
            comandaCaptura.maximizar(escritorio.getSize());
            comandaCaptura.setVisible(true);
        } else {

            comandaCaptura.setVisible(false);
            comandaCaptura.setVisible(true);
        }
    }
    
    ComandaCaptura comandaCaptura;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        panel1 = new abstractt.visual.Panel();

        setTitle("COMANDAS ");
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jScrollPane2ComponentResized(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(255, 255, 153));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 361, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(panel1);

        getContentPane().add(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        mostrarComandas();
    }//GEN-LAST:event_formComponentResized

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        //      mostrarComandas();
    }//GEN-LAST:event_formAncestorResized

    private void jScrollPane2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jScrollPane2ComponentResized
        //mostrarComandas();
    }//GEN-LAST:event_jScrollPane2ComponentResized


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private abstractt.visual.Panel panel1;
    // End of variables declaration//GEN-END:variables
}
