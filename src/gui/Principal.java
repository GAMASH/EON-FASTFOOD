/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import abstractt.visual.ComponenteMenu;
import abstractt.visual.InternalFrameAbstracto;
import static domain.General.cargarConfiguracion;
import static domain.General.sucursal;
import gui.inventarios.ArticulosFrame;
import gui.Catalogos.TipoArticuloCatalogo;
import gui.Catalogos.MarcaCatalogo;
import domain.tabla.Impuesto;
import domain.tabla.TipoEmpleado;
import gui.Catalogos.ImpuestoCatalogo2;
import gui.Catalogos.MesaCatalogo;
import gui.Catalogos.TipoPlatilloCatalogo;
import gui.Catalogos.UnidadMedidaCatalogo;
import gui.accesos.TipoEmpleadoCatalogo;
import gui.restaurant.PlatillosFrame;
import gui.restaurant.ComandasFrame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Developer GAGS
 */
public class Principal extends javax.swing.JFrame {

    private static final int tipo_producto_opcion = 1;
    private static final int marcas_opcion = 2;
    private static final int impuestos_opcion = 3;
    private static final int unidades_medida_opcion = 4;
    private static final int mesas_opcion = 5;
    private static final int tipo_platillo_opcion = 6;
    private static final int articulos_opcion = 7;
    private static final int platillos_opcion = 8;
    private static final int comandas_opcion = 9;
    private static final int tipos_empleado_opcion = 10;
    private static final int usuarios_opcion = 11;
    private Integer ancho_opciones;

    /**
     * Creates new form Principal
     */
    public Principal() {

        initComponents();

        cargarConfiguracion();

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ancho_opciones = 200;

        menu_bar.setSize(ancho_opciones, getHeight() - 100);
        // menu_bar.setTipo("P");
        //menu_bar.setTexto("O P C I O N E S");

        statusBar1.progresBarr(0, false, "C A R G A N D O");

        ComponenteMenu c1 = agregarComponente(menu_bar, "Resturante", "M", 0, "");
        {
            ComponenteMenu c11 = agregarComponente(c1, "Comandas", "O", comandas_opcion, "service_bell_25px.png");
        }
        ComponenteMenu c2 = agregarComponente(menu_bar, "Inventarios", "M", 0, "");
        {
            ComponenteMenu c21 = agregarComponente(c2, "Articulos", "O", articulos_opcion, "");
            ComponenteMenu c22 = agregarComponente(c2, "Platillos", "O", platillos_opcion, "");
        }
        ComponenteMenu c3 = agregarComponente(menu_bar, "Catálogo", "M", 0, "");
        {
            ComponenteMenu c31 = agregarComponente(c3, "Inventario", "M", 0, "");
            {
                ComponenteMenu c311 = agregarComponente(c31, "Tipo de producto", "O", tipo_producto_opcion, "");
                ComponenteMenu c312 = agregarComponente(c31, "Marcas", "O", marcas_opcion, "");
                ComponenteMenu c313 = agregarComponente(c31, "Impuestos", "O", impuestos_opcion, "");
                ComponenteMenu c314 = agregarComponente(c31, "Unidades de medida", "O", unidades_medida_opcion, "");
            }
            ComponenteMenu c32 = agregarComponente(c3, "Restaurante", "M", 0, "");
            {
                ComponenteMenu c321 = agregarComponente(c32, "Mesas", "O", mesas_opcion, "table.png");
                ComponenteMenu c322 = agregarComponente(c32, "Tipos de platillos", "O", tipo_platillo_opcion, "user.png");
            }
        }
        ComponenteMenu c4 = agregarComponente(menu_bar, "Accesibilidad", "M", 0, "");
        {
            ComponenteMenu c41 = agregarComponente(c4, "Usuarios", "O", usuarios_opcion, "");

            ComponenteMenu c42 = agregarComponente(c4, "Catalogos", "M", 0, "");
            {
                
                ComponenteMenu c421 = agregarComponente(c42, "Tipos de empleado", "O", tipos_empleado_opcion, "");
            }
        }

        statusBar1.progressBar = false;
    }

    private ComponenteMenu agregarComponente(
            ComponenteMenu parentComponeneteMenu,
            String texto, String tipo, Integer opcion, String icono) {

        ComponenteMenu componeneteMenu;
        componeneteMenu = new ComponenteMenu();
        componeneteMenu.setTexto(texto);
        componeneteMenu.setTipo(tipo);

        componeneteMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                opciones(opcion);
            }
        });

        parentComponeneteMenu.agregar(componeneteMenu);
        componeneteMenu.setIcono(icono);
        return componeneteMenu;
    }

    private void opciones(Integer opcion) {

        statusBar1.progresBarr(0, false, "C A R G A N D O");
        switch (opcion) {
            case tipo_producto_opcion:
                tipo_producto();
                break;
            case marcas_opcion:
                marca();
                break;
            case impuestos_opcion:
                impuesto();
                break;
            case unidades_medida_opcion:
                unidad_medida();
                break;
            case mesas_opcion:
                mesas();
                break;
            case tipo_platillo_opcion:
                tipo_platillo();
                break;
            case articulos_opcion:
                articulos();
                break;
            case platillos_opcion:
                platillos();
                break;
            case comandas_opcion:                
                comandas();
                break;
            case usuarios_opcion:
                break;
            case tipos_empleado_opcion:
                tipo_empleado();
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal dialog = null;
                    Login login = null;

                    dialog = new Principal();
                    login = new Login(null, true);

                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                    login.setVisible(true);
                    dialog.setTitle("EON " + sucursal.datos_fiscales.getNombre_comercial());
                } catch (SQLException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        statusBar1 = new abstractt.visual.StatusBar();
        escritorio = new abstractt.visual.Escritorio();
        menu_bar = new abstractt.visual.ComponenteMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        m_archivo = new javax.swing.JMenu();
        m_configuracionesGenerales = new javax.swing.JMenuItem();
        m_salir = new javax.swing.JMenuItem();
        m_modulos = new javax.swing.JMenu();
        m_inventarios = new javax.swing.JMenu();
        m_articulos = new javax.swing.JMenuItem();
        m_platillos = new javax.swing.JMenuItem();
        m_cCatalogos = new javax.swing.JMenu();
        m_tipoProducto = new javax.swing.JMenuItem();
        m_marcas = new javax.swing.JMenuItem();
        m_impuestos = new javax.swing.JMenuItem();
        m_unidadesMedida = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        m_tipo_platillo = new javax.swing.JMenuItem();
        m_mesas = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        m_ventana = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EON");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(statusBar1);
        statusBar1.setBounds(0, 335, 501, 23);

        escritorio.setBackground(new java.awt.Color(102, 204, 255));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio);
        escritorio.setBounds(148, 0, 353, 331);

        menu_bar.setIcono("user.png");
        menu_bar.setTexto("O P C I O N E S");
        menu_bar.setTipo("P");
        menu_bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_barMouseClicked(evt);
            }
        });
        getContentPane().add(menu_bar);
        menu_bar.setBounds(-2, -2, 151, 335);

        m_archivo.setText("Archivo");

        m_configuracionesGenerales.setText("Configuraciones Generales");
        m_archivo.add(m_configuracionesGenerales);

        m_salir.setText("Salir");
        m_archivo.add(m_salir);

        jMenuBar1.add(m_archivo);

        m_modulos.setText("Modulos");

        m_inventarios.setText("Inventarios");

        m_articulos.setText("Articulos");
        m_articulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_articulosActionPerformed(evt);
            }
        });
        m_inventarios.add(m_articulos);

        m_platillos.setText("Platillos");
        m_platillos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_platillosActionPerformed(evt);
            }
        });
        m_inventarios.add(m_platillos);

        m_modulos.add(m_inventarios);

        m_cCatalogos.setText("Catalogos");

        m_tipoProducto.setText("Tipo de Productos");
        m_tipoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_tipoProductoActionPerformed(evt);
            }
        });
        m_cCatalogos.add(m_tipoProducto);

        m_marcas.setText("Marcas");
        m_marcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_marcasActionPerformed(evt);
            }
        });
        m_cCatalogos.add(m_marcas);

        m_impuestos.setText("Impuestos");
        m_impuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_impuestosActionPerformed(evt);
            }
        });
        m_cCatalogos.add(m_impuestos);

        m_unidadesMedida.setText("Unidades de Medida");
        m_unidadesMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_unidadesMedidaActionPerformed(evt);
            }
        });
        m_cCatalogos.add(m_unidadesMedida);
        m_cCatalogos.add(jSeparator1);

        m_tipo_platillo.setText("Tipo de Platillos");
        m_tipo_platillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_tipo_platilloActionPerformed(evt);
            }
        });
        m_cCatalogos.add(m_tipo_platillo);

        m_mesas.setText("Mesas");
        m_mesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_mesasActionPerformed(evt);
            }
        });
        m_cCatalogos.add(m_mesas);

        m_modulos.add(m_cCatalogos);

        jMenu1.setText("Restaurante");

        jMenuItem3.setText("Comandas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        m_modulos.add(jMenu1);

        jMenuBar1.add(m_modulos);

        m_ventana.setText("Ventana");
        jMenuBar1.add(m_ventana);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tipo_producto() {
        if (tipoProducto == null) {

            tipoProducto = new gui.Catalogos.TipoArticuloCatalogo();
        }
        if (!tipoProducto.isVisible()) {

            tipoProducto = new gui.Catalogos.TipoArticuloCatalogo();
            //   tipoProducto.setManejadorBD(getManejadorBD());
            tipoProducto.cargaValores();
            tipoProducto.centrado(escritorio.getSize());
            escritorio.remove(tipoProducto);
            escritorio.add(tipoProducto);
            tipoProducto.setVisible(true);
        } else {

            tipoProducto.setVisible(false);
            tipoProducto.setVisible(true);
        }
    }

    private void marca() {

        if (marca == null) {

            marca = new gui.Catalogos.MarcaCatalogo();
        }
        if (!marca.isVisible()) {

            marca = new gui.Catalogos.MarcaCatalogo();
            // marca.setManejadorBD(getManejadorBD());
            marca.cargaValores();
            marca.centrado(escritorio.getSize());
            escritorio.remove(marca);
            escritorio.add(marca);
            marca.setVisible(true);
        } else {

            marca.setVisible(false);
            marca.setVisible(true);
        }
    }

    private void impuesto() {

        if (impuesto == null) {

            impuesto = new gui.Catalogos.ImpuestoCatalogo2();
        }
        if (!impuesto.isVisible()) {

            impuesto = new gui.Catalogos.ImpuestoCatalogo2();
            impuesto.Dimensionar();
            // marca.setManejadorBD(getManejadorBD());
            impuesto.setTablaBd(new Impuesto());
            impuesto.cargaValores();
            impuesto.centrado(escritorio.getSize());

            escritorio.remove(impuesto);
            escritorio.add(impuesto);
            impuesto.setVisible(true);

        } else {

            impuesto.setVisible(false);
            impuesto.setVisible(true);
        }
    }

    private void unidad_medida() {

        if (unidadMedida == null) {

            unidadMedida = new gui.Catalogos.UnidadMedidaCatalogo();
        }
        if (!unidadMedida.isVisible()) {

            unidadMedida = new gui.Catalogos.UnidadMedidaCatalogo();

            unidadMedida.cargaValores();
            unidadMedida.centrado(escritorio.getSize());
            escritorio.remove(unidadMedida);
            escritorio.add(unidadMedida);
            unidadMedida.setVisible(true);
        } else {

            unidadMedida.setVisible(false);
            unidadMedida.setVisible(true);
        }
    }

    private void articulos() {
        if (articulosFrame == null) {

            articulosFrame = new gui.inventarios.ArticulosFrame();
        }
        if (!articulosFrame.isVisible()) {

            articulosFrame = new gui.inventarios.ArticulosFrame();

            articulosFrame.cargaValores();
            //articulosFrame.centrado(escritorio.getSize());            
            escritorio.remove(articulosFrame);
            escritorio.add(articulosFrame);
            articulosFrame.maximizar(escritorio.getSize());
            articulosFrame.setVisible(true);
        } else {

            articulosFrame.setVisible(false);
            articulosFrame.setVisible(true);
        }
    }

    private void tipo_platillo() {

        if (tipo_platillo == null) {

            tipo_platillo = new gui.Catalogos.TipoPlatilloCatalogo();
        }
        if (!tipo_platillo.isVisible()) {

            tipo_platillo = new gui.Catalogos.TipoPlatilloCatalogo();
            // marca.setManejadorBD(getManejadorBD());
            tipo_platillo.cargaValores();
            tipo_platillo.centrado(escritorio.getSize());
            escritorio.remove(tipo_platillo);
            escritorio.add(tipo_platillo);
            tipo_platillo.setVisible(true);
        } else {

            tipo_platillo.setVisible(false);
            tipo_platillo.setVisible(true);
        }
    }

    private void platillos() {
        if (platillosFrame == null) {

            platillosFrame = new gui.restaurant.PlatillosFrame();
        }
        if (!platillosFrame.isVisible()) {

            platillosFrame = new gui.restaurant.PlatillosFrame();
            platillosFrame.cargaValores();
            escritorio.remove(platillosFrame);
            escritorio.add(platillosFrame);
            platillosFrame.maximizar(escritorio.getSize());
            platillosFrame.setVisible(true);
        } else {

            platillosFrame.setVisible(false);
            platillosFrame.setVisible(true);
        }
    }

    private void mesas() {
        if (mesa == null) {

            mesa = new gui.Catalogos.MesaCatalogo();
        }
        if (!mesa.isVisible()) {

            mesa = new gui.Catalogos.MesaCatalogo();
            // marca.setManejadorBD(getManejadorBD());
            mesa.cargaValores();
            mesa.centrado(escritorio.getSize());
            escritorio.remove(mesa);
            escritorio.add(mesa);
            mesa.setVisible(true);
        } else {

            mesa.setVisible(false);
            mesa.setVisible(true);
        }
    }
    
     private void tipo_empleado() {

         
           
        if (tipo_empleado == null) {

            tipo_empleado = new TipoEmpleadoCatalogo();
        }
        if (!tipo_empleado.isVisible()) {

            tipo_empleado = new TipoEmpleadoCatalogo();
            tipo_empleado.Dimensionar();
            // marca.setManejadorBD(getManejadorBD());
            tipo_empleado.setTablaBd(new TipoEmpleado());
            tipo_empleado.cargaValores();
            tipo_empleado.centrado(escritorio.getSize());

            escritorio.remove(tipo_empleado);
            escritorio.add(tipo_empleado);
            tipo_empleado.setVisible(true);

        } else {

            tipo_empleado.setVisible(false);
            tipo_empleado.setVisible(true);
        }
    }

    private void comandas() {
        if (comanda == null) {

            comanda = new gui.restaurant.ComandasFrame();
        }
        if (!comanda.isVisible()) {

            comanda = new gui.restaurant.ComandasFrame();
            // marca.setManejadorBD(getManejadorBD());
            // comanda.cargaValores();
            comanda.maximizar(escritorio.getSize());
            escritorio.remove(comanda);
            escritorio.add(comanda);
            comanda.setVisible(true);
            comanda.cargaValores();
        } else {

            comanda.setVisible(false);
            comanda.setVisible(true);
        }
    }

    public void collapsed() {

        colapsed = !colapsed;

        reordenar();
    }

    public void reordenar() {

        statusBar1.setBounds(0, this.getHeight() - 81, this.getWidth() - 15, 22);

        if (colapsed) {

            menu_bar.setSize(10, getHeight() - statusBar1.getHeight() - 58);
        } else {

            menu_bar.setSize(ancho_opciones, getHeight() - statusBar1.getHeight() - 58);
        }

        escritorio.setLocation(menu_bar.getWidth(), 0);
        escritorio.setSize(getWidth() - menu_bar.getWidth() - 15, getHeight() - statusBar1.getHeight() - 60);

        //Ordenar todos los internals frames                                
        for (int i = 0; i < escritorio.getComponentCount(); i++) {

            InternalFrameAbstracto frame = (InternalFrameAbstracto) escritorio.getComponent(i);
            System.out.println("frame " + frame.getClass().getName() + " " + frame);
            frame.reacomodo(escritorio.getSize());
        }

        statusBar1.mostrar();
    }

    boolean colapsed = false;

    public void agregarInternalFrame(InternalFrameAbstracto aInteralFrame) {

        escritorio.add(aInteralFrame);
        reordenar();
    }

    private void m_tipoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_tipoProductoActionPerformed

        tipo_producto();
    }//GEN-LAST:event_m_tipoProductoActionPerformed

    private void m_marcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_marcasActionPerformed

        marca();
    }//GEN-LAST:event_m_marcasActionPerformed

    private void m_impuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_impuestosActionPerformed

        impuesto();
    }//GEN-LAST:event_m_impuestosActionPerformed

    private void m_unidadesMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_unidadesMedidaActionPerformed

        unidad_medida();
    }//GEN-LAST:event_m_unidadesMedidaActionPerformed

    private void m_articulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_articulosActionPerformed

        articulos();
    }//GEN-LAST:event_m_articulosActionPerformed

    private void m_tipo_platilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_tipo_platilloActionPerformed

        tipo_platillo();
    }//GEN-LAST:event_m_tipo_platilloActionPerformed

    private void m_platillosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_platillosActionPerformed


    }//GEN-LAST:event_m_platillosActionPerformed

    private void m_mesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_mesasActionPerformed

        mesas();
    }//GEN-LAST:event_m_mesasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        reordenar();
    }//GEN-LAST:event_formComponentResized

    private void menu_barMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_barMouseClicked
        collapsed();
    }//GEN-LAST:event_menu_barMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static abstractt.visual.Escritorio escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu m_archivo;
    private javax.swing.JMenuItem m_articulos;
    private javax.swing.JMenu m_cCatalogos;
    private javax.swing.JMenuItem m_configuracionesGenerales;
    private javax.swing.JMenuItem m_impuestos;
    private javax.swing.JMenu m_inventarios;
    private javax.swing.JMenuItem m_marcas;
    private javax.swing.JMenuItem m_mesas;
    private javax.swing.JMenu m_modulos;
    private javax.swing.JMenuItem m_platillos;
    private javax.swing.JMenuItem m_salir;
    private javax.swing.JMenuItem m_tipoProducto;
    private javax.swing.JMenuItem m_tipo_platillo;
    private javax.swing.JMenuItem m_unidadesMedida;
    private javax.swing.JMenu m_ventana;
    private abstractt.visual.ComponenteMenu menu_bar;
    public static abstractt.visual.StatusBar statusBar1;
    // End of variables declaration//GEN-END:variables

    private TipoArticuloCatalogo tipoProducto = null;
    private MarcaCatalogo marca = null;
    private ImpuestoCatalogo2 impuesto = null;
    private UnidadMedidaCatalogo unidadMedida = null;
    private ArticulosFrame articulosFrame = null;
    private PlatillosFrame platillosFrame = null;
    private TipoPlatilloCatalogo tipo_platillo = null;
    private MesaCatalogo mesa = null;
    private ComandasFrame comanda = null;
    private TipoEmpleadoCatalogo tipo_empleado = null;
}
