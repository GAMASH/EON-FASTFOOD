/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.tabla;

import abstractt.TablaBD;
import static domain.ConexionBD.conectarBD;
import static domain.ConexionBD.desconectarBD;
import static domain.General.formatoDateTime_11;
import static domain.General.manejadorBD;
import static domain.General.sucursal;
import domain.ParametrosSP;
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

    public String toString() {

        String aPago;

        aPago = ""
                + "id_pago = " + id_pago + ", "
                + "caja_turno = " + this.caja_turno.id_caja_turno + ", "
                + "folio_pago = " + folio_pago.toString() + ", "
                + "fecha = " + formatoDateTime_11.format(this.fecha) + " {" + fecha.toString() + "}, "
                + "subtotal = " + subtotal.toString() + ", "
                + "impuesto = " + impuesto.toString() + ", "
                + "total = " + total.toString() + ", "
                + "efectivo = " + efectivo.toString() + ", "
                + "cambio = " + cambio.toString();

        return aPago;

    }

    /**
     *
     * @return
     */
    public boolean grabar() {

        boolean error = true;

        conectarBD();

        System.out.println(this);

        manejadorBD.parametrosSP = new ParametrosSP();
        manejadorBD.parametrosSP.agregarParametro(sucursal.id_sucursal, "varId_sucursal", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_pago, "varId_pago", "STRING", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(caja_turno.id_caja_turno, "varId_caja_turno", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(folio_pago.toString(), "varFolio_pago", "INT", "INOUT");
        manejadorBD.parametrosSP.agregarParametro(formatoDateTime_11.format(this.fecha), "varFecha", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(subtotal.toString(), "varSubtotal", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(impuesto.toString(), "varImpuesto", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(total.toString(), "varTotal", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(efectivo.toString(), "varEfectivo", "DOUBLE", "IN");
        manejadorBD.parametrosSP.agregarParametro(cambio.toString(), "varCambio", "DOUBLE", "IN");

        if (manejadorBD.ejecutarSP("grabarPago") == 0) {

            error = true;
            id_pago = manejadorBD.parametrosSP.get(1).getValor();
            folio_pago = Integer.parseInt(manejadorBD.parametrosSP.get(3).getValor());
        } else {

            error = false;
        }

        desconectarBD();

        return error;
    }

}
