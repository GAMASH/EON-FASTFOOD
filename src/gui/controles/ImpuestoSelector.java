/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.controles;

import abstractt.ComboBox;
import domain.tabla.Impuesto;

/**
 *
 * @author Developer GAGS
 */
public class ImpuestoSelector extends ComboBox{

    Impuesto impuesto;

    public ImpuestoSelector() {

       impuesto = new Impuesto();
    }

    public void cargar() {

        addArray(Impuesto.cargarImpuesto());
    }

    public Impuesto getImpuesto() {

       
        try {
            
            impuesto.cargarPorDescripcion(this.getSelectedItem().toString());

        } catch (Exception e) {

        }
        return impuesto;
    }
    
    public void setImpuesto(Impuesto aimpuesto){
        
        impuesto = aimpuesto;
        
        setSelectedItem(impuesto.descripcion);
    }
    
}
