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
public class Direccion extends TablaBD{

    public String id_direccion;
    public String calle;
    public String  num_exterior;
    public String  num_interior;
    public String  referencia;
    public Asentamiento asentamiento;
}
