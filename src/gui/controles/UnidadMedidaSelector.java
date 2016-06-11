/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.controles;

import abstractt.ComboBox;
import domain.tabla.UnidadMedida;

/**
 *
 * @author Developer GAGS
 */
public class UnidadMedidaSelector extends ComboBox{

    UnidadMedida unidad_medida;

    public UnidadMedidaSelector() {

       // tipo_aborto = new TipoAborto();
    }

    public void cargar() {

        addArray(UnidadMedida.cargarUnidadesMedida());
    }

    public UnidadMedida getUnidadMedida() {

        unidad_medida = new UnidadMedida();
        try {
            
            unidad_medida.cargarPorDescripcion(this.getSelectedItem().toString());

        } catch (Exception e) {

        }
        return unidad_medida;
    }
    
    public void setUnidadMedida(UnidadMedida aunidad_medida){
        
        unidad_medida = aunidad_medida;
        
        setSelectedItem(unidad_medida.getDescripcion());
    }
    
}
