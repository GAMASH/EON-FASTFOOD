/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import abstractt.visual.Table;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.formatoDateTime_11;
import static domain.General.formatoDate_2;
import static domain.General.manejadorBD;
import static domain.General.mensaje;
import static domain.General.sucursal;
import domain.ParametrosSP;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Developer GAGS
 */
public class Comanda extends TablaBD {

    public String id_sucursal;
    public String id_comanda;
    public String folio;
    public Date fecha;
    public Mesa mesa;
    public Empleado mesero;
    public String status;
    public Pago pago;
    public Double Subtotal;
    Double impuesto;
    Double total;
    Double propina;
    Date fecha_termino;
    Integer numero_comensales;

    public Comanda(){
        
       id_comanda = "";
       folio = "";
       fecha = new Date();
       mesa = new Mesa();
       mesero = new Empleado();
       
    }
    
    public void setRegistro(Table table, Integer i) {

        conectarBD();
        
        try {
            String id_mesa;
            
            id_comanda = table.getValorString(i, 0);
            id_mesa = table.getValorString(i, 1);                         
            fecha = formatoDateTime_11.parse(table.getValorString(i, 5)); 
            status = table.getValorString(i, 6); 
            
            
            mesa.obetenerPorId(id_mesa);
            
            //status = statusMesaSelector.getData(table.getValorString(i, 4));
        } catch (ParseException ex) {
            
            mensaje(ex.getMessage());
          //  Logger.getLogger(Comanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        desconectarBD();
    }

    public static void cargarFrameMesaComanda(Table tabla) {

        crearTablaFrameMesaComanda(tabla);
        conectarBD();

        manejadorBD.consulta(""
                + "select c.id_comanda, m.id_mesa, numero_mesa, \n"
                + "       case m.status \n"
                + "         when 'D' then 'Disponible'\n"
                + "         when 'O' then 'Ocupada'\n"
                + "         when 'R' then 'Reservada' end mes_status,\n"
                + "         coalesce(c.folio,'') com_folio, \n"
                + "         coalesce(c.fecha,NOW()) com_fecha, \n"
                + "         coalesce( case c.status \n"
                + "                   when 'PE' then 'Pendiente'\n"
                + "                   when 'PT' then 'Pedido Tomado'\n"
                + "                   when 'PR' then 'Proceso'\n"
                + "                   when 'SE' then 'Servido' \n"
                + "                   when 'PA' then 'Pagado'                    \n"
                + "                   end, 'Disponible') com_status\n"
                + "from mesa m left outer join comanda c on\n"
                + "         m.id_sucursal = c.id_sucursal\n"
                + "	 and m.id_mesa     = c.id_mesa\n"
                + "where m.id_sucursal = '"+sucursal.id_sucursal+"'\n"                
                + "order by numero_mesa; ");

        manejadorBD.asignarTable(tabla);

        tabla.agregarItemStatus();
        tabla.alinear();

        tabla.ocultarcolumna(0);
        tabla.ocultarcolumna(1);

        desconectarBD();

    }

    private static Table crearTablaFrameMesaComanda(Table tabla) {

        if (tabla == null) {
            tabla = new Table();
        }

        String titulos[] = {
            "Id Sucursl", "Id Mesa", "Numero Mesa", "Estatus Mesa",
            "Folio", "Fecha", "Estatus Comanda"};

        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                titulos
        ));

        tabla.setTitulos(titulos);
        tabla.cambiarTitulos();
        tabla.setFormato(new int[]{
            Table.letra, Table.letra, Table.letra, Table.letra,
            Table.letra, Table.fecha, Table.letra});

        tabla.tamañoColumna(new int[]{
            0, 100, 120, 600,
            50, 100, 100
        });

        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
/*
        Comanda comanda = new Comanda();

        tabla.setTablaBD(comanda);
*/
        return tabla;
    }
    
    public boolean grabar() {

        boolean error = true;
        /*
        conectarBD();

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_mesa, "varId_mesa", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(numero_mesa, "varNumero_mesa", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(num_comensales.toString(), "varNum_comensales", "INT", "IN");
        manejadorBD.parametrosSP.agregarParametro(status, "varStatus", "STRING", "IN");

        if (manejadorBD.ejecutarSP("{ call grabarMesa(?,?,?,?,?) }") == 0) {

            error = true;
        } else {
            error = false;
        }

        desconectarBD();
*/
        return error;
    }
    

}
