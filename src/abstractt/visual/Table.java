/*
 * Table.java
 *
 * Created on 12 de octubre de 2008, 10:13 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package abstractt.visual;

import abstractt.TablaBD;
import abstractt.TableModelAbst;
import static abstractt.ClaseAbstracta.redondear;
import domain.Fecha;
import static domain.General.escalaGrises;
import static domain.General.escala_grises;
import static domain.General.manejadorBD;
import static domain.General.obtenerNumero;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Developer GAGS
 */
public class Table extends javax.swing.JTable implements DragGestureListener, DragSourceListener {

    TableRowSorter<TableModel> sorter;

    // protected Color pautado;
    private Color pautado[];
    /**
     * Da tama�o las columnas con con un arreglo de enteros
     *
     */
    private int[] tamaños;

    private boolean[] editables;

    /**
     * 2015-01-02 Formatos
     */
    public static final int letra = 0;
    public static final int numero_double = 1;
    public static final int moneda = 2;
    public static final int fecha = 3;
    public static final int numero_entero = 4;
    public static final int booleano = 5;

    private int formato[];
    private int indices[];
    private String titulos[];

    private int columna;

    private boolean orden[] = null;
    private boolean ordenar = true;

    private LinkedList columnaTabla;
    private LinkedList columnaTablaOrdenada;

    public boolean[] actualizable;

    JScrollPane scrollpane;

    /**
     * Variable para saber si hay cambios, que se necesiten guardar en BD
     */
    public boolean haycambios;

    /**
     * Objeto para realizar cambios en BD
     */
    private TablaBD tablaBD;

    /**
     * variable para saber si la tabla manejara itemstatus
     */
    public boolean itemstatus;
    /**
     * variable para saber en que columna esta el itemstatus, siempre se pone
     * hasta el final
     */
    public Integer colItemStatus;

    private boolean editable = true;

    public static final int Recuperado = 0;
    public static final int Nuevo = 1;
    public static final int NuevoModificado = 2;
    public static final int Modificado = 3;
    public static final int Eliminado = 4;

    /**
     * variable para ver solo solo que no sean eliminados itemstatus != 4
     */
    public static final String filtro = "[^4]";

    private Integer primer_campo_editable;

    private ArrayList<Integer> columnas_ocultas;

    DragSource dragSource;

    /**
     * Creates a new instance of Table
     */
    public Table() {

        JTableHeader tableHeader;

        tableHeader = getTableHeader();

        tableHeader.setFont(new Font("Trebuchet", Font.BOLD, 12));

        //Color de fondo del encabezado                        
        tableHeader.setBackground(escalaGrises(new Color(0, 0, 128)));

        //Color de fuente del encabezado
        tableHeader.setForeground(new Color(255, 225, 255));
        tableHeader.setOpaque(false);

        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);

        setFont(new Font("Trebuchet", 0, 12));
//        addJTableHeaderListener();
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setSelectionBackground(escalaGrises(new Color(51, 153, 255)));

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e) {
                mouseMove(e);
            }
        });
        /*
         addKeyListener(new java.awt.event.KeyAdapter() {
            
            
         public void keyReleased(java.awt.event.KeyEvent e) {
         if (!isEditing() && editCellAt(getSelectedRow(), getSelectedColumn())) {

         getEditorComponent().requestFocusInWindow();
                    
         }
         }
            
         public void keyPressed(java.awt.event.KeyEvent e){
         if (!isEditing() && editCellAt(getSelectedRow(), getSelectedColumn())) {
                    
         System.out.println("Escribiendo en tabla");
                    
         }
         }
         });
         */
        pautado = new Color[]{
            escalaGrises(new Color(220, 255, 220)), // 
            escalaGrises(new Color(255, 255, 255)), // 
        };

        //pautado = new Color(220, 255, 220);
        haycambios = false;
        itemstatus = false;

        dragSource = new DragSource();

        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE,
                this);

        setRowHeight(20);
    }

    public boolean getRender = false;

    /**
     *
     * @param row
     * @param col
     * @return
     */
    public TableCellEditor getCellEditor(int row, int col) {

        if (!editables[col]) {

            return this.getCellEditor();
        }

        getRender = true;

        TableModelAbst modelo = (TableModelAbst) getModel();

        boolean valor_check;
        String valor;

        DefaultCellEditor edit;

        if (modelo.isBoolean(col)) {

            if (getValueAt(row, col) == null) {

                valor_check = false;
            } else {

                valor_check = (boolean) getValueAt(row, col);
            }

            final JCheckBox check = new JCheckBox();

            check.setSelected(valor_check);

            edit = new DefaultCellEditor(check);
        } else {

            if (getValueAt(row, col) == null) {

                valor = "";
            } else {

                valor = getValueAt(row, col).toString();
            }

            if (isComboBox(col)) {

                ComboBox combobox;

                combobox = getComboBox(col);
                //final DefaultCellEditor                                                
                edit = new DefaultCellEditor(combobox);

            } else {

                final JTextField field = new JTextField(valor);

                switch (formato[col]) {
                    case Table.letra:

                        field.setHorizontalAlignment(javax.swing.JTextField.LEFT);
                        break;
                    case Table.numero_double:

                        field.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                        break;
                    case Table.numero_entero:

                        field.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                        break;
                    case Table.fecha:

                        field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        break;
                    default:

                        field.setHorizontalAlignment(javax.swing.JTextField.CENTER);
                        break;
                }

                edit = new DefaultCellEditor(field);
                edit.setClickCountToStart(1);

                field.addFocusListener(new FocusAdapter() {
                    public void focusGained(FocusEvent e) {

                        field.selectAll();//Con esto al solicitar el editor, el texto queda seleccionado
                    }

                    public void focusLost(FocusEvent e) {
                        field.select(0, 0);//De-selecciono el texto al perder el foco.
                    }
                });
            }
        }

        getRender = false;

        return edit;
    }

    /**
     *
     * @param rowIndex
     * @param colIndex
     * @return
     */
    public boolean isCellEditable(int rowIndex, int colIndex) {

        if (editables == null) {
            return false;
        }

        return editables[colIndex];

        //return isEditable();
    }

    /**
     *
     * @param combobox
     * @param columna
     */
    public void agregarComboBox(ComboBox combobox, int columna) {

        combobox.cargar();
        DefaultCellEditor defaultCellEditor = new DefaultCellEditor(combobox);
        getColumnModel().getColumn(columna).setCellEditor(defaultCellEditor);

        if (columnasComboBox == null) {

            columnasComboBox = new ArrayList<ColumnaComboBox>();
        }

        ColumnaComboBox columnaComboBox = new ColumnaComboBox(combobox, columna);

        columnasComboBox.add(columnaComboBox);
    }

    /**
     *
     */
    public class ColumnaComboBox {

        public ComboBox combobox;
        public Integer columna;

        public ColumnaComboBox(ComboBox aComboBox, int aColumna) {

            combobox = aComboBox;
            columna = aColumna;
        }
    }

    /**
     *
     * @param columna
     * @return
     */
    public boolean isComboBox(Integer columna) {

        ColumnaComboBox columnaComboBox;

        if (columnasComboBox == null) {

            return false;
        }

        for (int i = 0; i < columnasComboBox.size(); i++) {

            columnaComboBox = columnasComboBox.get(i);

            if (columnaComboBox.columna == columna) {

                return true;
            }
        }

        return false;
    }

    /**
     *
     * @param columna
     * @return
     */
    public ComboBox getComboBox(Integer columna) {

        ColumnaComboBox columnaComboBox;

        for (int i = 0; i < columnasComboBox.size(); i++) {

            columnaComboBox = columnasComboBox.get(i);

            if (columnaComboBox.columna == columna) {
                return columnaComboBox.combobox;
            }
        }

        return new ComboBox();
    }

    public ArrayList<ColumnaComboBox> columnasComboBox;

    /**
     *
     * @param columna
     */
    public void agregarCheckBox(int columna) {

        TableModelAbst modelo = (TableModelAbst) getModel();

        for (int i = 0; i < this.getRowCount(); i++) {

            if (this.getValorString(i, columna).equals("S")) {

                this.setValueAt(true, i, columna);

            } else {

                this.setValueAt(false, i, columna);
            }
        }

        modelo.agregarBoolean(columna);
        setModel(modelo);

        haycambios = false;
    }

    /**
     * Devuelve el valor double de la consulta
     */
    public double getValorDouble(int fila, int columna) {

        //System.out.println(getValueAt(fila, columna).toString());
        // return Double.parseDouble(obtenerNumero(getValueAt(fila, columna).toString()));
        if (getRowCount() > 0 && this.getColumnCount() > columna ) {
            if (getValueAt(fila, columna) != null) {

                return Double.parseDouble(getValueAt(fila, columna).toString());
            }
        }

        return 0.00;
    }

    /**
     * Devuelve el valor entero de la consulta
     */
    public int getValorInt(int fila, int columna) {

        if (getRowCount() > 0) {
            return Integer.parseInt(getValueAt(fila, columna).toString());
        }
        return 0;
    }

    /**
     * Devuelve el valor en un String de la consulta
     */
    public String getValorString(int fila, int columna) {

        if (getRowCount() > 0) {
            if (getValueAt(fila, columna) != null) {

                return getValueAt(fila, columna).toString();
            }
        }
        return "";
    }

    /**
     * Devuelve el valor en un Boolean(String) de la consulta
     *
     * true = S false = N
     */
    public String getValorBoolean(int fila, int columna) {

        if (getRowCount() > 0) {
            if (getValueAt(fila, columna) != null) {

                if ((boolean) getValueAt(fila, columna)) {

                    return "S";
                } else {
                    return "N";
                }
            }
        }
        return "N";
    }

    /**
     *
     * @param autoresize
     */
    public void autoResize(boolean autoresize) {

        if (autoresize) {

            setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        } else {

            setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        }
    }

    /**
     *
     * @return
     */
    public int validaCambios() {

        acceptText();

        int respuesta;

        if (haycambios) {

            respuesta = 0;

            respuesta = JOptionPane.showConfirmDialog(null, "¿Desea guardar los cambios?", "Mensaje del sistema", JOptionPane.YES_NO_CANCEL_OPTION);
            //mensaje desea grabar los cambios            

            switch (respuesta) {
                case 0:
                    //si grabar y salir
                    grabar();
                    return 0;
                case 1:
                    //no grabar y salir
                    return 0;
                case 2:
                    //cancelar no salir
                    return 1;
            }
        }
        return 0;
    }

    /**
     *
     * @param modelo
     */
    public void asignarModelo(TableModelAbst modelo) {

        if (sorter == null) {
            sorter = new TableRowSorter<TableModel>(modelo);
            setRowSorter(sorter);
        }

        modelo.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {

                cambioTabla(e);
            }
        });

        setModel(modelo);
    }

    /**
     *
     * @param e
     */
    public void cambioTabla(TableModelEvent e) {

        if ((!itemstatus || getRender)) {

            return;
        }

        int firstRow = e.getFirstRow();
        int lastRow = e.getLastRow();
        int index = e.getColumn();
        int valueItemStatus;

        filtrar(null);

        switch (e.getType()) {
            case TableModelEvent.INSERT:
                for (int i = firstRow; i <= lastRow; i++) {
                    // System.out.println("INSERT " + i);

                    if (itemstatus) {
                        //Agregar el item status nuevo sin valor
                        this.setValueAt("1", i, colItemStatus);
                    }
                }

                break;
            case TableModelEvent.UPDATE:
                if (firstRow == TableModelEvent.HEADER_ROW) {
                    if (index == TableModelEvent.ALL_COLUMNS) {
                        // System.out.println("A column was added");
                    } else {
                        // System.out.println(index + "in header changed");
                    }
                } else {
                    for (int i = firstRow; i <= lastRow; i++) {
                        if (index == TableModelEvent.ALL_COLUMNS) {
                            // System.out.println("All columns have changed");
                        } else {

                            if (colItemStatus != index) {

                                valueItemStatus = Integer.parseInt(this.getValueAt(i, colItemStatus).toString());

                                // System.out.println("UPDATE " + index + " " + valueItemStatus);
                                switch (valueItemStatus) {
                                    case Recuperado:

                                        this.setValueAt(Modificado, i, colItemStatus);
                                        haycambios = true;
                                        break;
                                    case Nuevo:

                                        this.setValueAt(NuevoModificado, i, colItemStatus);
                                        haycambios = true;
                                        break;
                                    case NuevoModificado:
                                        break;

                                    case Modificado:
                                        haycambios = true;
                                        break;
                                }

                            }
                        }
                    }
                }
                break;
            case TableModelEvent.DELETE:

                for (int i = firstRow; i <= lastRow; i++) {
                    // System.out.println("DELETE " + i);

                }
                break;
        }

        filtrar(filtro);
        // System.out.println("hay cambios: "+haycambios);
        //sorter.setRowFilter(RowFilter.regexFilter(filtro, colItemStatus));
    }

    /**
     *
     * @param e
     */
    public void mouseMove(MouseEvent e) {

        Point p = e.getPoint();
        int row = rowAtPoint(p);
        int column = columnAtPoint(p);
        String texto = String.valueOf(Table.this.getValueAt(row, column));
        if (texto == null) {
            texto = " ";
        }
        setToolTipText(texto);
        TableColumn nColumn = Table.this.getColumnModel().getColumn(column);
    }

    /**
     *
     */
    public void colorPane() {

        if (getParent() != null) {

            Container parent = getParent().getParent();
            scrollpane = (JScrollPane) parent;
            scrollpane.getViewport().setBackground(new Color(255, 255, 255));
        }

    }

    /**
     *
     * @param valor
     * @param columna
     * @param jScrollPane
     * @return
     */
    public int buscar(String valor, int columna, JScrollPane jScrollPane) {

        for (int i = 0; i < getRowCount(); i++) {
            if (valor.equals(this.getValueAt(i, columna).toString())) {

                setRowSelectionInterval(i, i);
                Rectangle r = getCellRect(i, columna, true);
                jScrollPane.getViewport().scrollRectToVisible(r);
                return i;
            }
        }

        return -1;

    }

    /**
     *
     * @param valor
     * @param columna
     * @return
     */
    public int buscar(String[] valor, int columna) {

        for (int i = 0; i < getRowCount(); i++) {

            for (int j = 0; j < valor.length; j++) {
                if (valor[j].equals(this.getValueAt(i, columna).toString())) {

                    return i;
                }
            }
        }

        return -1;
    }

    /**
     *
     * @param jScrollPane
     */
    private void scrollToRow(JScrollPane jScrollPane) {

        Integer ultimaFila;

        ultimaFila = this.getRowCount() - 1;

        Rectangle r = getCellRect(ultimaFila, columna, true);
        setRowSelectionInterval(ultimaFila, ultimaFila);

        jScrollPane.getViewport().scrollRectToVisible(r);
    }

    /**
     *
     * @param fila
     */
    public void eliminarFila(Integer fila) {

        int valuesItemStatus;

        if (itemstatus) {

            valuesItemStatus = Integer.parseInt(getValueAt(fila, this.colItemStatus).toString());

            //   System.out.println("eliminando[" + fila + "] " + valuesItemStatus);
            switch (valuesItemStatus) {
                case Recuperado:

                    this.setValueAt(Eliminado, fila, colItemStatus);
                    haycambios = true;
                    break;
                case Nuevo:
                    eliminarFila_2(fila);
                    break;
                case NuevoModificado:
                    eliminarFila_2(fila);
                    break;
                case Modificado:
                    this.setValueAt(Eliminado, fila, colItemStatus);
                    haycambios = true;
                    break;
            }

            filtrar(filtro);
            //sorter.setRowFilter(RowFilter.regexFilter(filtro, colItemStatus));

        } else {

            eliminarFila_2(fila);
        }
    }

    /**
     *
     * @param fila
     */
    public void eliminarFila_2(Integer fila) {

        DefaultTableModel modelo = (DefaultTableModel) getModel();
        modelo.removeRow(fila);
        setModel(modelo);
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        /*
         colors = new Color[]{
         color,
         new Color(120, 118, 93) // gray
         };
         */
    }

    /**
     * Pautado
     *
     * @param renderer
     * @param row
     * @param column
     * @return
     */
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component rendererComponent = super.prepareRenderer(renderer, row, column);

        if (!isCellSelected(row, column)) {
            // If the cell is NOT selected, then calculates the index
            // in the color array and sets the background.
            int index = row % getPautado().length;

            rendererComponent.setBackground(getPautado()[index]);
        }

        return rendererComponent;
    }

    /**
     *
     */
    public void centrar() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < this.getColumnCount(); i++) {

            getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    /**
     *
     */
    public void alinear() {

        Integer columnas;

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);

        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(JLabel.LEFT);

        columnas = this.getColumnCount();

        if (this.itemstatus) {

            columnas -= 1;
        }

        for (int i = 0; i < columnas; i++) {

            if (this.formato[i] == Table.letra) {

                getColumnModel().getColumn(i).setCellRenderer(leftRenderer);

            } else if (this.formato[i] == Table.numero_double || this.formato[i] == Table.numero_entero) {
                getColumnModel().getColumn(i).setCellRenderer(rightRenderer);

            } else if (this.formato[i] == Table.fecha) {

                getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
    }

    /**
     *
     * @param columna
     */
    public void ocultarColumna(int columna) {

        getColumnModel().getColumn(columna).setMinWidth(0);
        getColumnModel().getColumn(columna).setMaxWidth(0);

        primerColumna(columna);
    }

    /**
     *
     * @param columnas
     */
    public void ocultarColumnas(int[] columnas) {

        for (int i = 0; i < columnas.length; i++) {

            ocultarColumna(columnas[i]);
            editables[columnas[i]] = false;
        }
    }

    /**
     * funcion para obtener la primer columna editable,
     *
     * @param columna
     */
    private void primerColumna(int columna) {

        boolean encontro = false;

        if (columnas_ocultas == null) {

            columnas_ocultas = new ArrayList<Integer>();
        }

        columnas_ocultas.add(columna);

        Collections.sort(columnas_ocultas);

        primer_campo_editable = -1;
        for (int i = 0; i < getColumnCount(); i++) {
            encontro = false;
            for (int j = 0; j < columnas_ocultas.size(); j++) {

                if (columnas_ocultas.get(j) == i) {
                    encontro = true;
                    continue;
                }
            }

            if (!encontro) {

                primer_campo_editable = i;
                return;
            }
        }
    }

    /**
     *
     * @param as_titulos
     */
    public void setTitulos(String as_titulos[]) {

        titulos = as_titulos;
        cambiarTitulos();
        /*se Añadio el color de la tabla para que sea automatico y no poner el evento en cada instancia*/
        colorPane();
    }

    /**
     *
     */
    public void cambiarTitulos() {

        TableColumnModel tcm = this.getColumnModel();

        for (int col = 0; col < titulos.length; col++) {

            tcm.getColumn(col).setHeaderValue(titulos[col]);
        }

    }

    /**
     *
     */
    public void quitarSeleccion() {

        int filaSeleccionada = getSelectedRow();

        if (filaSeleccionada != -1) {

            Object arr[] = new Object[getColumnCount()];

            //Se copia la fila
            for (int i = 0; i < getColumnCount(); i++) {

                arr[i] = getValueAt(filaSeleccionada, i);
            }

            DefaultTableModel modelo = (DefaultTableModel) getModel();
            //se remueve la fila de la tabla
            modelo.removeRow(filaSeleccionada);
            //Se vuelve a insertar en la fila donde estaba
            modelo.insertRow(filaSeleccionada, arr);

            setModel(modelo);
        }
    }

    /**
     * Ordena la tabla por la columna dada intercalando Descendente <->
     * Ascendente una a la vez, por columna Emp�eza ordenando Ascendente
     *
     */
    private void ordenarPorColumna() {

        int filas = getRowCount();
        int columnas = getColumnCount();

        columnaTabla = new LinkedList();
        columnaTablaOrdenada = new LinkedList();

        for (int i = 0; i < filas; i++) {

            columnaTabla.add(getValueAt(i, columna));
            columnaTablaOrdenada.add(getValueAt(i, columna));
        }

        ordenar();

        indices = new int[filas];
        for (int i = 0; i < filas; i++) {
            indices[i] = -1;
        }

        for (int i = 0; i < filas; i++) {

            if (!orden[columna]) {
                //Ascendente
                indices[i] = obtenerIndiceUnico(columnaTablaOrdenada.get(i).toString());
            } else {
                //Descendente
                indices[i] = obtenerIndiceUnico(columnaTablaOrdenada.get((filas - 1) - i).toString());
            }
        }

        if (orden[columna]) {

            orden[columna] = false;
        } else {

            orden[columna] = true;
        }

        TableModelAbst modelo = (TableModelAbst) getModel();
        //TableModel modelo =  getModel();
        // int removidas = 0;

        Object arr[];

        try {

            for (int i = 0; i < indices.length; i++) {

                arr = new Object[columnas];
                for (int j = 0; j < columnas; j++) {

                    arr[j] = modelo.getValueAt(indices[i], j);
                }

                modelo.addRow(arr);
            }
        } catch (java.lang.ArrayIndexOutOfBoundsException err) {
        }

        for (int i = 0; i < indices.length; i++) {

            modelo.removeRow(0);
        }

        setModel(modelo);
    }

    /**
     *
     * @param jScrollPane1
     * @return numero de fila
     */
    public Integer agregarFila(JScrollPane jScrollPane1) {

        this.acceptText();

        int columnas = getColumnCount();
        int filas = this.getRowCount();
        Object arr[];
        arr = new Object[columnas];
        DefaultTableModel modelo = (DefaultTableModel) getModel();

        modelo.addRow(arr);
        setModel(modelo);

        scrollToRow(jScrollPane1);

        if (!this.isFocusOwner()) {
            this.requestFocus();
        }

        this.changeSelection(filas, primer_campo_editable, false, true);

        return filas;

    }

    /**
     *
     */
    private void ordenar() {

        switch (formato[columna]) {
            //letra
            case 0:
                Collections.sort(columnaTablaOrdenada);
                break;
            //numero
            case 1:
                ordenarNumero();
                break;
            //moneda
            case 2:
                ordenarMoneda();
                break;
            //fecha
            case 3:
                ordenarFecha();
                break;
            //numero Entero
            case 4:
                ordenarNumeroEntero();
                break;
        }
    }

    /**
     *
     */
    private void ordenarFecha() {

        Fecha fecha = new Fecha();
        //String Sfecha;

        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {

            //columnaTablaOrdenada.set(i, fecha.cambiarFormato(columnaTablaOrdenada.get(i).toString()));
            columnaTablaOrdenada.set(i, columnaTablaOrdenada.get(i).toString());
        }

        Collections.sort(columnaTablaOrdenada);

        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {

            //  columnaTablaOrdenada.set(i, fecha.obtenerFecha(columnaTablaOrdenada.get(i).toString()));
            columnaTablaOrdenada.set(i, columnaTablaOrdenada.get(i).toString());
        }
    }

    /**
     *
     */
    private void ordenarMoneda() {

        String campo;
        StringTokenizer stt;

        //Se le quita el caracter $
        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {

            campo = columnaTablaOrdenada.get(i).toString();
            stt = new StringTokenizer(campo, " ");
            stt.nextToken();
            campo = stt.nextToken();
            columnaTablaOrdenada.set(i, campo);
        }

        //Se ordena por numero
        ordenarNumero();

        //Se le regresa el caracter $
        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {
            campo = "$ ";
            campo += columnaTablaOrdenada.get(i).toString();
            columnaTablaOrdenada.set(i, campo);
        }
    }

    /**
     *
     */
    private void ordenarNumero() {

        double numero;

        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {

            numero = Double.parseDouble(obtenerNumero(columnaTablaOrdenada.get(i).toString()));
            columnaTablaOrdenada.set(i, numero);
        }

        Collections.sort(columnaTablaOrdenada);

        //Regresar Formato de dos decimales
        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {

            numero = Double.parseDouble(columnaTablaOrdenada.get(i).toString());
            columnaTablaOrdenada.set(i, redondear(numero));
        }
    }

    /**
     *
     */
    private void ordenarNumeroEntero() {

        //  String campo;
        int numero;

        for (int i = 0; i < columnaTablaOrdenada.size(); i++) {

            numero = Integer.parseInt(columnaTablaOrdenada.get(i).toString());
            columnaTablaOrdenada.set(i, numero);
        }

        Collections.sort(columnaTablaOrdenada);
    }

    /**
     *
     * @param ob
     * @return
     */
    private int obtenerIndiceUnico(String ob) {

        for (int i = 0; i < columnaTabla.size(); i++) {

            if (columnaTabla.get(i).toString().equals(ob)) {

                if (!repetido(i)) {
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     *
     * @param i
     * @return
     */
    private boolean repetido(int i) {

        for (int j = 0; j < indices.length; j++) {
            if (indices[j] == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * Quita todas las filas de un tabla
     *
     */
    public void limpiarTabla() {

        DefaultTableModel modelo = (DefaultTableModel) getModel();
        int filas = getRowCount();

        for (int i = 0; i < filas; i++) {

            modelo.removeRow(0);
        }

        setModel(modelo);
    }

    /**
     * Quita todas las filas de un tabla menos una
     *
     */
    protected void limpiarTabla1() {

        DefaultTableModel modelo = (DefaultTableModel) getModel();
        int filas = getRowCount();

        for (int i = 0; i < filas - 1; i++) {

            modelo.removeRow(0);
        }

        setModel(modelo);
    }

    /**
     *
     * @param Aactualizables
     */
    public void actualizable(boolean[] Aactualizables) {

        actualizable = Aactualizables;
    }

    /**
     *
     * @param Atamaños
     */
    public void tamañoColumna(int[] Atamaños) {

        tamaños = Atamaños;

        TableColumn nColumn;

        if (editables == null) {

            editables = new boolean[tamaños.length];
        }

        for (int i = 0; i < tamaños.length; i++) {

            nColumn = getColumnModel().getColumn(i);
            nColumn.setPreferredWidth(tamaños[i]);

            if (tamaños[i] == 0) {
                editables[i] = false;
            } else {
                editables[i] = true;
            }
        }
    }

    /**
     *
     * @param Atamaños
     */
    public void setEditables(boolean[] Aeditables) {

        editables = Aeditables;
    }

    /**
     *
     */
    public void reasignaTamaños() {

        TableColumn nColumn;

        if (tamaños != null) {

            for (int i = 0; i < tamaños.length; i++) {

                nColumn = getColumnModel().getColumn(i);
                nColumn.setPreferredWidth(tamaños[i]);
            }
        }
    }

    /**
     * Formatos de columna 0 = letras; 1 = numeros (dobles); 2 = monedas; 3 =
     * fecha 4 = numeros(enteros)
     */
    public void setFormato(int format[]) {

        formato = new int[format.length];
        for (int i = 0; i < formato.length; i++) {

            formato[i] = format[i];
        }

        orden = new boolean[formato.length];
    }

    /**
     *
     * @param orden
     */
    public void setOrdenar(boolean orden) {

        ordenar = orden;
    }

    /**
     *
     */
    public int  grabar() {

        int fila;
        acceptText();

        if (!haycambios) {

           // JOptionPane.showConfirmDialog(null, "No hay cambios por guardar", "Mensaje del sistema", JOptionPane.DEFAULT_OPTION);
            return 0;
        }

        filtrar(null);

        fila = buscar(new String[]{"2", "3"}, colItemStatus);

        while (fila >= 0) {

            tablaBD.setRegistro(this, fila);
            if (!tablaBD.grabar()) {

              //  JOptionPane.showConfirmDialog(null, "Ocurrio un error al grabar\n" + manejadorBD.errorSQL, "Mensaje del sistema", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                filtrar(null);
                return -1;
            }

            setValueAt("0", fila, colItemStatus);
            fila = buscar(new String[]{"2", "3"}, colItemStatus);
        }

        filtrar(null);

        fila = buscar(new String[]{"4"}, colItemStatus);

        while (fila >= 0) {

            tablaBD.setRegistro(this, fila);
            tablaBD.borrar();
            this.eliminarFila_2(fila);
            filtrar(null);
            fila = buscar(new String[]{"4"}, colItemStatus);
        }

      //  JOptionPane.showConfirmDialog(null, "Se guardaron los cambios correctamente", "Mensaje del sistema", JOptionPane.DEFAULT_OPTION);

        //ya se guardo no hay cambios pendientes de guardar
        haycambios = false;
        
        return 0;
    }

    /**
     *
     * @param filtro
     */
    public void filtrar(String filtro) {

        if (filtro == null) {

            sorter.setRowFilter(null);
        } else {

            sorter.setRowFilter(RowFilter.regexFilter(filtro, colItemStatus));
        }
    }

    /**
     * Agrega el itemStatus como una columna al final para identidicar su estado
     * al actualizar la tabla
     *
     * <TABLE  BORDER=1 WIDTH=300>
     * <TR><TD>Tipo</TD><TD>Descripción</TD><TD>Accion al grabar</TD></TR>
     * <TR><TD>0</TD><TD>Recuperado</TD><TD>Nada</TD></TR>
     * <TR><TD>1</TD><TD>Nuevo sin valor</TD><TD>Nada</TD></TR>
     * <TR> <TD>2</TD><TD>Nuevo con valor</TD><TD>Insert</TD></TR>
     * <TR> <TD>3</TD><TD>Recuperado modificado</TD><TD>Update</TD></TR>
     * <TR> <TD>4</TD><TD>Recuperada Eliminada</TD><TD>Delete</TD></TR>
     * </TABLE>
     *
     */
    public void agregarItemStatus() {

        String titulos_nvos[];

        colItemStatus = getColumnCount();
        Integer filas;
        filas = getRowCount();

        DefaultTableModel modelo = (DefaultTableModel) getModel();

        Object arr[];
        arr = new Object[filas];

        for (int i = 0; i < filas; i++) {

            arr[i] = 0;
        }

        modelo.addColumn("ItemStatus", arr);
        setModel(modelo);

        titulos_nvos = new String[titulos.length];

        for (int i = 0; i < titulos.length; i++) {

            titulos_nvos[i] = titulos[i];
        }
        // titulos_nvos[colItemStatus] = "ItemStatus";

        this.setTitulos(titulos_nvos);
        tamañoColumna(tamaños);

        itemstatus = true;
        ocultarColumna(colItemStatus);
    }

    /**
     *
     */
    public void acceptText() {

        // if (isEditing()) {
        if (getCellEditor() != null) {
            this.getRender = true;

            getCellEditor().stopCellEditing();

            this.getRender = false;
        }
        //}
    }

    /**
     * @return the tablaBD
     */
    public TablaBD getTablaBD() {
        return tablaBD;
    }

    /**
     * @param tablaBD the tablaBD to set
     */
    public void setTablaBD(TablaBD tablaBD) {
        this.tablaBD = tablaBD;
    }

    /**
     * @return the pautado
     */
    public Color[] getPautado() {
        return pautado;
    }

    @Override
    public void dragGestureRecognized(DragGestureEvent dge) {
        /*
         Transferable t = new StringSelection("aString");
         dragSource.startDrag(dge, DragSource.DefaultCopyDrop, t, this);
         System.out.println(this.tableHeader.toString());
         */
    }

    @Override
    public void dragEnter(DragSourceDragEvent dsde) {
        /*
         System.out.println("enters");
         System.out.println(this.tableHeader.toString());
         */
    }

    @Override
    public void dragOver(DragSourceDragEvent dsde) {
        /*
         System.out.println("over");
         System.out.println(this.tableHeader.toString());
         */
    }

    @Override
    public void dropActionChanged(DragSourceDragEvent dsde) {
        /*
         System.out.println("changes the drag action between copy or move");
         System.out.println(this.tableHeader.toString());
         */
    }

    @Override
    public void dragExit(DragSourceEvent dse) {
        /*
         System.out.println("leaves");
         System.out.println(this.tableHeader.toString());
         */
    }

    @Override
    public void dragDropEnd(DragSourceDropEvent dsde) {
        /*
         System.out.println("finishes or cancels the drag operation");
         System.out.println(this.tableHeader.toString());
         */
    }

    /**
     * @return the editable
     */
    public boolean isEditable() {
        return editable;
    }

    /**
     * @param editable the editable to set
     */
    public void setEditable(boolean editable) {
        this.editable = editable;
    }
}
