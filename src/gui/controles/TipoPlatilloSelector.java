/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.controles;

import abstractt.visual.ComboBox;
import domain.tabla.TipoPlatillo;

/**
 *
 * @author Developer GAGS
 */
public class TipoPlatilloSelector extends ComboBox{

    TipoPlatillo tipo_platillo;

    public TipoPlatilloSelector() {

       tipo_platillo = new TipoPlatillo();
    }

    public void cargar() {

        addArray(TipoPlatillo.cargarTipoPlatillos());
    }

    public TipoPlatillo getTipoPlatillo() {

        
        try {
            
            tipo_platillo.cargarPorDescripcion(this.getSelectedItem().toString());

        } catch (Exception e) {
            
        }
        
        return tipo_platillo;
    }
    
    public void setTipoPlatillo(TipoPlatillo atipo_platillo){
        
        tipo_platillo = atipo_platillo;        
        setSelectedItem(tipo_platillo.getDescripcion());
    }    
}
