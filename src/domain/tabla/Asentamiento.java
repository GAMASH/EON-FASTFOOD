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
class Asentamiento extends TablaBD{

    public String id_asentamiento;
    public AsentamientoTipo asentamiento_tipo;
    public String cp;
    public String descripcion_asentamiento;
    public Municipio municipio;
}
