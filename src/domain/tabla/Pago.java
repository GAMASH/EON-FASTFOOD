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
public class Pago extends TablaBD{
    
    public String id_usucursal;
    public String id_pago;
    public CajaTurno caja_turno;
    public Integer folio_pago;
    Date fecha;
    Double subtotal;
    Double impuesto;
    Double total;
    Double efectivo;
    Double cambio;

}