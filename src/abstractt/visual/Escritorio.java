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
import javax.swing.JDesktopPane;

/**
 *
 * @author Developer GAGS
 */
public class Escritorio extends JDesktopPane{

    
     @Override
    protected void paintComponent(Graphics g) {

        Color color = this.getBackground();

        Graphics2D g2 = (Graphics2D) g.create();
        Rectangle clip = g2.getClipBounds();
        

        g2.setPaint(new GradientPaint(0.0f, 0.0f, color.darker(),
                0.0f, getHeight(), color.brighter()));
        g2.fillRect(clip.x, clip.y, clip.width, clip.height);
    }
}
