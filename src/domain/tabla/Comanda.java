/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.tabla;

import abstractt.TablaBD;
import java.util.Date;

/**
 *
 * @author Developer GAGS
 */
public class Comanda extends TablaBD{
    
    public String id_sucursal ;
    public String id_comanda;
    public String folio;
    public Date fecha;
    public Mesa mesa;
    public Mesero mesero;
    public String status;
    public Pago pago;
    public Double Subtotal;
    Double impuesto;
    Double total;
    Double propina;
    Date fecha_termino;
    Integer numero_comensales;    
}
