/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt.visual;

import static domain.General.escala_grises;
import static domain.General.gradient;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JDesktopPane;

/**
 *
 * @author Developer GAGS
 */
public class Escritorio extends JDesktopPane {

    @Override
    protected void paintComponent(Graphics g) {

        Color color = this.getBackground();

        int color_med;

        if (escala_grises) {

            color_med = (color.getRed() + color.getGreen() + color.getBlue()) / 3;

            color = new Color(color_med, color_med, color_med);
        }

        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();

        if (gradient) {
            g2.setPaint(new GradientPaint(0.0f, 0.0f, color.darker(),
                    0.0f, getHeight(), color.brighter()));
        } else {
            g2.setPaint(new GradientPaint(0.0f, 0.0f, color,
                    0.0f, getHeight(), color));
        }
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }

    public InternalFrameAbstracto buscarInternalFrame(String nombreInternalFrameAbstracto) {

        InternalFrameAbstracto frame = null;
        
        for (int i = 0; i < getComponentCount(); i++) {

            frame = (InternalFrameAbstracto) getComponent(i);
            
            if (frame.getClass().getName().contains(nombreInternalFrameAbstracto)){
                return frame;
            }                                  
        }
        
        return frame;
    }
}
