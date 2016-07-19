/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import abstractt.TablaBD;
import abstractt.visual.CatalogoAbstracto;
import abstractt.visual.ComponenteMenu;
import abstractt.visual.FrameAbstracto;
import abstractt.visual.InternalFrameAbstracto;
import static domain.General.cargarConfiguracion;
import static domain.General.sucursal;
import gui.inventarios.ArticulosFrame;
import domain.tabla.Impuesto;
import domain.tabla.Marca;
import domain.tabla.Mesa;
import domain.tabla.TipoArticulo;
import domain.tabla.TipoEmpleado;
import domain.tabla.TipoPago;
import domain.tabla.TipoPlatillo;
import domain.tabla.UnidadMedida;
import domain.tabla.Usuario;
import gui.accesos.UsuarioCaptura;
import gui.restaurant.PlatillosFrame;
import gui.restaurant.ComandasFrame;
import java.awt.Dimension;
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
    private static final int tipos_pago_opcion = 12;

    private Integer ancho_opciones;
    boolean colapsed = false;

    /**/
    private FrameAbstracto usuario = null;
    private ArticulosFrame articulos_frame = null;
    private PlatillosFrame platillos_frame = null;
    private ComandasFrame comanda = null;

    private CatalogoAbstracto impuesto = null;
    private CatalogoAbstracto marca = null;
    private CatalogoAbstracto mesa = null;
    private CatalogoAbstracto tipo_empleado = null;
    private CatalogoAbstracto tipo_pago = null;
    private CatalogoAbstracto tipo_platillo = null;
    private CatalogoAbstracto tipo_producto = null;
    private CatalogoAbstracto unidad_medida = null;

    /**
     * Creates new form Principal
     */
    public Principal() {

        initComponents();

        cargarConfiguracion();

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ancho_opciones = 200;

        menu_bar.setSize(ancho_opciones, getHeight() - 100);

        statusBar1.progresBarr(0, false, "C A R G A N D O");

        menu_bar.setIcono("");

        ComponenteMenu c1 = agregarComponente(menu_bar, "Restaurante", "M", 0, "");
        {
            ComponenteMenu c11 = agregarComponente(c1, "Comandas", "O", comandas_opcion, "Comanda.png");
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
                
                ComponenteMenu c313 = agregarComponente(c31, "Unidades de medida", "O", unidades_medida_opcion, "");
                
            }
            ComponenteMenu c32 = agregarComponente(c3, "Restaurante", "M", 0, "");
            {
                ComponenteMenu c321 = agregarComponente(c32, "Mesas", "O", mesas_opcion, "table.png");
                ComponenteMenu c322 = agregarComponente(c32, "Tipos de platillos", "O", tipo_platillo_opcion, "user.png");
            }
            
            ComponenteMenu c33 = agregarComponente(c3, "Impuestos", "O", impuestos_opcion, "");
            ComponenteMenu c34 = agregarComponente(c3, "Tipos de pago", "O", tipos_pago_opcion, "");
            
        }
        ComponenteMenu c4 = agregarComponente(menu_bar, "Accesibilidad", "M", 0, "");
        {
            ComponenteMenu c41 = agregarComponente(c4, "Usuarios", "O", usuarios_opcion, "");

            ComponenteMenu c42 = agregarComponente(c4, "Catalogos", "M", 0, "");
            {

                ComponenteMenu c421 = agregarComponente(c42, "Tipos de empleado", "O", tipos_empleado_opcion, "");
            }
        }

        statusBar1.setProgressBar(false);
    }

    /**
     *
     * @param parentComponeneteMenu
     * @param texto
     * @param tipo
     * @param opcion
     * @param icono
     * @return
     */
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

    /**
     *
     * @param opcion
     */
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
                usuarios();
                break;
            case tipos_empleado_opcion:
                tipo_empleado();
                break;
            case tipos_pago_opcion:
                tipos_pago();
                break;
        }

        statusBar1.setProgressBar(false);
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

                    if (sucursal == null) {
                        System.exit(0);
                    }

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

        escritorio = new abstractt.visual.Escritorio();
        statusBar1 = new abstractt.visual.StatusBar();
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

        escritorio.setBackground(new java.awt.Color(0, 0, 204));
        getContentPane().add(escritorio);
        escritorio.setBounds(151, 1, 348, 330);
        getContentPane().add(statusBar1);
        statusBar1.setBounds(0, 335, 501, 23);

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

    /**
     *
     */
    private void articulos() {
        if (articulos_frame == null) {

            articulos_frame = new gui.inventarios.ArticulosFrame();
        }
        if (!articulos_frame.isVisible()) {

            articulos_frame = new gui.inventarios.ArticulosFrame();

            articulos_frame.cargaValores();
            //articulosFrame.centrado(escritorio.getSize());            
            escritorio.remove(articulos_frame);
            escritorio.add(articulos_frame);
            articulos_frame.maximizar(escritorio.getSize());
            articulos_frame.setVisible(true);
        } else {

            articulos_frame.setVisible(false);
            articulos_frame.setVisible(true);
        }
    }

    /**
     *
     */
    private void platillos() {
        if (platillos_frame == null) {

            platillos_frame = new gui.restaurant.PlatillosFrame();
        }
        if (!platillos_frame.isVisible()) {

            platillos_frame = new gui.restaurant.PlatillosFrame();
            platillos_frame.cargaValores();
            escritorio.remove(platillos_frame);
            escritorio.add(platillos_frame);
            platillos_frame.maximizar(escritorio.getSize());
            platillos_frame.setVisible(true);
        } else {

            platillos_frame.setVisible(false);
            platillos_frame.setVisible(true);
        }
    }

    /**
     *
     */
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

    /**
     *
     */
    private void usuarios() {

        if (usuario == null) {

            usuario = new FrameAbstracto();
        }
        if (!usuario.isVisible()) {

            usuario = new FrameAbstracto();
            usuario.setTablaBD(new Usuario());
            usuario.setCaptura(new UsuarioCaptura());
            usuario.cargaValores();
            escritorio.remove(usuario);
            escritorio.add(usuario);
            usuario.maximizar(escritorio.getSize());
            usuario.setVisible(true);
        } else {

            usuario.setVisible(false);
            usuario.setVisible(true);
        }
    }

    /**
     * CATALOGOS
     */
    /**
     *
     * @param catalogo
     * @param title
     * @param dimension
     * @param tabla
     * @return
     */
    private CatalogoAbstracto muestraCatalogo(CatalogoAbstracto catalogo, String title, Dimension dimension, TablaBD tabla) {

        if (catalogo == null) {

            catalogo = new CatalogoAbstracto(title);
        }
        if (!catalogo.isVisible()) {

            catalogo = new CatalogoAbstracto(title);
            catalogo.Dimensionar(dimension);
            catalogo.setTablaBd(tabla);
            catalogo.cargaValores();
            catalogo.centrado(escritorio.getSize());

            escritorio.remove(catalogo);
            escritorio.add(catalogo);
            catalogo.setVisible(true);

        } else {

            catalogo.setVisible(false);
            catalogo.setVisible(true);
        }

        return catalogo;
    }

    /**
     *
     */
    private void impuesto() {

        impuesto = muestraCatalogo(impuesto, "Impuestos", new Dimension(250, 500), new Impuesto());
    }

    /**
     *
     */
    private void marca() {

        marca = muestraCatalogo(marca, "Marcas", new Dimension(250, 500), new Marca());
    }

    /**
     *
     */
    private void mesas() {

        mesa = muestraCatalogo(mesa, "Mesas", new Dimension(400, 500), new Mesa());
    }

    /**
     *
     */
    private void tipo_empleado() {

        tipo_empleado = muestraCatalogo(tipo_empleado, "Tipos de Empleado", new Dimension(250, 500), new TipoEmpleado());
    }

    /**
     *
     */
    private void tipos_pago() {

        tipo_pago = muestraCatalogo(tipo_pago, "Tipos de Pago", new Dimension(250, 500), new TipoPago());
    }

    /**
     *
     */
    private void tipo_platillo() {

        tipo_platillo = muestraCatalogo(tipo_platillo, "Tipos de Platillo", new Dimension(250, 500), new TipoPlatillo());
    }

    /**
     *
     */
    private void tipo_producto() {

        tipo_producto = muestraCatalogo(tipo_producto, "Tipos de Articulo", new Dimension(250, 500), new TipoArticulo());
    }

    /**
     *
     */
    private void unidad_medida() {

        unidad_medida = muestraCatalogo(unidad_medida, "Unidades de Medida", new Dimension(250, 500), new UnidadMedida());
    }

    /**
     *
     */
    public void collapsed() {

        colapsed = !colapsed;

        reordenar();
    }

    /**
     *
     */
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
            frame.reacomodo(escritorio.getSize());
        }

        statusBar1.mostrar();
    }

    /**
     *
     * @param aInteralFrame
     */
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

}
