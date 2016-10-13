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
public class ComandaPago extends TablaBD {

  //  public String id_sucursal;
    public String id_comanda;
    public String id_pago;
    public Integer num_comensal;

    /**
     *
     */
    public ComandaPago() {

        // id_sucursal = sucursal.id_sucursal;
        id_pago = "";
        id_comanda = "";
        num_comensal = 0;
    }

    public String toString() {

        String aPago;

        aPago = ""
                + "id_pago = " + id_pago + ", "
                + "id_comanda = " + id_comanda + ", "
                + "num_comensal = " + num_comensal.toString() + "} ";

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
        manejadorBD.parametrosSP.agregarParametro(id_comanda, "varId_comanda", "STRING", "IN");
        manejadorBD.parametrosSP.agregarParametro(id_pago, "varId_pago", "STRING", "IN");        
        manejadorBD.parametrosSP.agregarParametro(num_comensal.toString(), "varNum_comensal", "INT", "IN");

        if (manejadorBD.ejecutarSP("grabarComandaPago") == 0) {

            error = true;
        } else {

            error = false;
        }

        desconectarBD();

        return error;
    }
}
