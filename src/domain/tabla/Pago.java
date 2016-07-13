/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import static domain.General.sucursal;
import java.util.Date;

/**
 *
 * @author Developer GAGS
 */
public class Pago extends TablaBD {

    public String id_sucursal;
    public String id_pago;
    public CajaTurno caja_turno;
    public Integer folio_pago;
    public Date fecha;
    public Double subtotal;
    public Double impuesto;
    public Double total;
    public Double efectivo;
    public Double cambio;

    /**
     * 
     */
    public Pago() {

        // id_sucursal = sucursal.id_sucursal;
        id_pago = "";
        caja_turno = new CajaTurno();
        folio_pago = 0;
        fecha = new Date();
        subtotal = 0.00;
        impuesto = 0.00;
        total = 0.00;
        efectivo = 0.00;
        cambio = 0.00;
    }

}
