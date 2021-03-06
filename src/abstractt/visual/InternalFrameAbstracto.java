/*
 * frameAbstracto.java
 *
 * Created on 11 de febrero de 2008, 09:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package abstractt.visual;

import domain.Fecha;
import domain.Seguridad;
import java.awt.AWTEvent;
import java.awt.ActiveEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.MenuComponent;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;


/**
 *
 * @author Developer GAGS
 */
public class InternalFrameAbstracto extends javax.swing.JInternalFrame implements
        InternalFrameListener{

    protected String nombreProceso = "";

    protected String consulta;
    protected String insercion;
    protected String actualizacion;
    protected String eliminacion;

    protected Seguridad seguridad;
    protected Fecha fecha;
    private boolean modal;

    /**
     * 0= centrado; 1= maximizado
     */
    private int tipo_visualizacion;

    /**
     * Creates a new instance of frameAbstracto
     */
    public InternalFrameAbstracto() {

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        fecha = new Fecha();
        seguridad = new Seguridad();
        // redondeo = new Redondeo();
         this.addInternalFrameListener(this);
    }

    /**
     *
     * @param tipo
     */
    public void tipoCentrado(int tipo) {
        
        tipo_visualizacion = tipo;
    }

    /**
     *
     * @param d
     */
    public void reacomodo(Dimension d) {
        switch (tipo_visualizacion) {

            case 0:
                this.centrado(d);
                break;
            case 1:
                this.maximizar(d);
                break;
        }
    }

    /**
     *
     * @param d
     */
    public void centrado(Dimension d) {

        Dimension frameSize = getSize();

        if (frameSize.height > d.height) {

            frameSize.height = d.height;
        }

        if (frameSize.width > d.width) {

            frameSize.width = d.width;
        }

        setLocation((d.width - frameSize.width) / 2, (d.height - frameSize.height) / 2);
        tipo_visualizacion = 0;
    }

    /**
     *
     * @param value
     */
    @Override
    public void setVisible(boolean value) {
        super.setVisible(value);
        if (modal) {
            if (value) {
                startModal();
            } else {
                stopModal();
            }
        }
    }

    /**
     *
     */
    private synchronized void stopModal() {
        notifyAll();
    }

    /**
     *
     * @param modal
     */
    public void setModal(boolean modal) {
        this.modal = modal;
    }

    /**
     *
     * @return
     */
    public boolean isModal() {
        return this.modal;
    }

    /**
     *
     */
    public synchronized void startModal() {

        try {
            if (SwingUtilities.isEventDispatchThread()) {
                EventQueue theQueue = getToolkit().getSystemEventQueue();
                while (isVisible()) {
                    AWTEvent event = theQueue.getNextEvent();
                    Object source = event.getSource();
                    boolean dispatch = true;

                    if (event instanceof MouseEvent) {
                        MouseEvent e = (MouseEvent) event;
                        MouseEvent m
                                = SwingUtilities.convertMouseEvent((Component) e.getSource(), e, this);
                        if (!this.contains(m.getPoint()) && e.getID() != MouseEvent.MOUSE_DRAGGED) {
                            dispatch = false;
                        }
                    }

                    if (dispatch) {
                        if (event instanceof ActiveEvent) {
                            ((ActiveEvent) event).dispatch();
                        } else if (source instanceof Component) {
                            ((Component) source).dispatchEvent(
                                    event);
                        } else if (source instanceof MenuComponent) {
                            ((MenuComponent) source).dispatchEvent(
                                    event);
                        } else {
                            System.err.println(
                                    "Unable to dispatch: " + event);
                        }
                    }
                }
            } else {
                while (isVisible()) {
                    wait();
                }
            }
        } catch (InterruptedException ignored) {
        }
    }

    /**
     *
     * @param d
     */
    public void maximizar(Dimension d) {

        this.setSize(d);
        tipo_visualizacion = 1;        
    }

    /**
     *
     */
    public void restaurar() {

        try {

            setMaximum(false);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(InternalFrameAbstracto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     */
    public void cargaValores() {

        System.out.println("InternalFrameAbstracto.cargaValores-Funcion no implementada");
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
