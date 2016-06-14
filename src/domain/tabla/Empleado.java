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
public class Empleado extends TablaBD{

    public String id_sucursal;
    public String id_empleado;
    public TipoEmpleado tipo_empleado;
    public Usuario usuario;
}
