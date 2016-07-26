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
public class CajaTurno extends TablaBD{

    public String id_sucursal;
    public String  id_caja_turno;
    public Caja caja;
    public Turno turno;
    public Empleado empleado;
    public Date fecha;
    public String status;
    public Date fecha_cierre;
}
