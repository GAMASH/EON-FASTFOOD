/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accesos;

import abstractt.TablaBD;
import abstractt.visual.CapturaAbstracto;
import abstractt.visual.InternalFrameAbstracto;
import static domain.General.manejadorBD;
import static domain.General.mensaje;
import static domain.General.sucursal;
import domain.tabla.Empleado;
import domain.tabla.TipoEmpleado;
import domain.tabla.Usuario;
import static gui.Principal.escritorio;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author sperez
 */
public class UsuarioCaptura extends CapturaAbstracto {

    public Usuario usuario;
    public Empleado empleado;
    public CambioPassword cambioPassword;

    /**
     * Creates new form UsuarioCaptura
     */
    public UsuarioCaptura() {
        initComponents();
        Dimensionar();
        boton4.setVisible(false);
    }

    /**
     *
     */
    public void cargarValores() {

        tipoEmpleadoSelector.setTablaBD(new TipoEmpleado());
         this.tipoEmpleadoSelector.setTablaBD(empleado.tipo_empleado);
    }

    public void Dimensionar() {
        
        Dimension d = new Dimension();
        d.height = 202;
        d.width = 572;
        setSize(d);
    }

    @Override
    public void setTablaBD(TablaBD usuario) {

        this.usuario = (Usuario) usuario;

        //System.out.println("UsuarioCaptura.setTablaBD: " + usuario);

        this.tf_login.setText(this.usuario.login);
        empleado = new Empleado();
        empleado.obtenerPorUsuario(this.usuario.id_usuario);        
        this.tipoEmpleadoSelector.setTablaBD(empleado.tipo_empleado);
    }

    public void asignarPassword() {

        if (cambioPassword == null) {

            cambioPassword = new CambioPassword();
        }

        if (!cambioPassword.isVisible()) {

            cambioPassword.setPassword_actual(usuario.password);
            escritorio.remove(cambioPassword);
            escritorio.add(cambioPassword);
            cambioPassword.centrado(escritorio.getSize());
            cambioPassword.setModal(true);
            cambioPassword.setVisible(true);

            if (!cambioPassword.password_nueva.equals("")) {

                usuario.password = cambioPassword.password_nueva;
            }
        }
    }

    public void grabar() {

        TipoEmpleado tipo_empleado;

        if (!usuario.grabar()) {

            mensaje("Error al grabar el usuario " + manejadorBD.errorSQL);

        } else {
            tipo_empleado = (TipoEmpleado) tipoEmpleadoSelector.getTablaBD();
            
            if (tipo_empleado != null) {
            
                empleado.id_sucursal = sucursal.id_sucursal;                
                empleado.tipo_empleado = tipo_empleado;
                empleado.usuario.obtenerPorId(new ArrayList(Arrays.asList(usuario.id_usuario)));
                
                if(!empleado.grabar()){
                    mensaje("Error al grabar el empleado "+ manejadorBD.errorSQL);
                    return;
                }                
            }
            mensaje("Se grabó el usuario correctamente");
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

        panel2 = new abstractt.visual.Panel();
        panel1 = new abstractt.visual.Panel();
        label1 = new abstractt.visual.Label();
        label2 = new abstractt.visual.Label();
        tf_login = new abstractt.visual.TextField();
        boton5 = new abstractt.visual.Boton();
        tipoEmpleadoSelector = new abstractt.visual.TablaBDSelector();
        boton2 = new abstractt.visual.Boton();
        boton1 = new abstractt.visual.Boton();
        boton3 = new abstractt.visual.Boton();
        boton4 = new abstractt.visual.Boton();

        setBackground(new java.awt.Color(102, 204, 255));
        setTitle("Captura Usuario");
        getContentPane().setLayout(new java.awt.BorderLayout());

        panel2.setLayout(null);

        panel1.setBackground(new java.awt.Color(204, 255, 204));
        panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 10))); // NOI18N
        panel1.setOpaque(false);

        label1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label1.setText("Login:");

        label2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label2.setText("Password:");

        boton5.setText("Agregar/Cambiar Password");
        boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panel2.add(panel1);
        panel1.setBounds(14, 20, 308, 67);
        panel2.add(tipoEmpleadoSelector);
        tipoEmpleadoSelector.setBounds(334, 54, 212, 20);

        boton2.setText("Cancelar");
        boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton2ActionPerformed(evt);
            }
        });
        panel2.add(boton2);
        boton2.setBounds(309, 98, 144, 39);

        boton1.setText("Aceptar");
        boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton1ActionPerformed(evt);
            }
        });
        panel2.add(boton1);
        boton1.setBounds(113, 98, 144, 39);

        boton3.setText("Agregar/Seleccionar Datos Personales");
        panel2.add(boton3);
        boton3.setBounds(331, 21, 215, 23);

        boton4.setText("Agregar/Seleccionar Datos Empleado");
        panel2.add(boton4);
        boton4.setBounds(333, 53, 212, 23);

        getContentPane().add(panel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton2ActionPerformed

    private void boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton5ActionPerformed

        asignarPassword();

    }//GEN-LAST:event_boton5ActionPerformed

    private void boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton1ActionPerformed
        grabar();
    }//GEN-LAST:event_boton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private abstractt.visual.Boton boton1;
    private abstractt.visual.Boton boton2;
    private abstractt.visual.Boton boton3;
    private abstractt.visual.Boton boton4;
    private abstractt.visual.Boton boton5;
    private abstractt.visual.Label label1;
    private abstractt.visual.Label label2;
    private abstractt.visual.Panel panel1;
    private abstractt.visual.Panel panel2;
    private abstractt.visual.TextField tf_login;
    private abstractt.visual.TablaBDSelector tipoEmpleadoSelector;
    // End of variables declaration//GEN-END:variables
}
