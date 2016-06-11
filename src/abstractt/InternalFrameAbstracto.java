/*
 * frameAbstracto.java
 *
 * Created on 11 de febrero de 2008, 09:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package abstractt;

import domain.Fecha;
import domain.ManejadorBD;

import domain.Redondeo;
import domain.Seguridad;
import java.awt.AWTEvent;
import java.awt.ActiveEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.MenuComponent;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Gilberto Adan Gonz�lez Silva
 */
public class InternalFrameAbstracto extends javax.swing.JInternalFrame {

    protected String nombreProceso = "";

    protected String consulta;
    protected String insercion;
    protected String actualizacion;
    protected String eliminacion;

    protected Seguridad seguridad;
    protected Fecha fecha;
    private boolean modal;

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

        /*
         try {

         setMaximum(true);
         } catch (PropertyVetoException ex) {
         Logger.getLogger(InternalFrameAbstracto.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
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

        System.out.println("cargaValores-Funcion no implementada");
    }

}
