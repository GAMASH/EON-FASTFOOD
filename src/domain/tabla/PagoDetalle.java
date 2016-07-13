/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;

/**
 *
 * @author Developer GAGS
 */
public class PagoDetalle extends TablaBD {

    public String id_sucursal;
    public String id_pago;
    public String id_pago_detalle;
    public TipoPago tipo_pago;
    public Double importe;

    /**
     * 
     */
    public PagoDetalle() {
        
        id_pago = "";
        id_pago_detalle = "";
        tipo_pago = new TipoPago();
        importe = 0.00;
    }
    
    
    /*
    select pd.id_sucursal, pd.id_pago, pd.id_pago_detalle, tp.id_tipo_pago, tp.descripcion,
       COALESCE(pd.importe, 0.00) as importe
from  pago_detalle pd right join tipo_pago tp on
		pd.id_tipo_pago = tp.id_tipo_pago
	and pd.id_sucursal = ''
and   pd.id_pago		=	''
and	  pd.id_pago_detalle  = ''; 
    */
    
}
