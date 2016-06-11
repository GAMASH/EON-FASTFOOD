/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.controles;

import abstractt.ComboBox;
import domain.tabla.Marca;

/**
 *
 * @author Developer GAGS
 */
public class MarcaSelector extends ComboBox{

    Marca marca;

    public MarcaSelector() {

       marca = new Marca();
    }

    public void cargar() {

        addArray(Marca.cargarMarcas());
    }

    public Marca getMarca() {

        
        try {
            
            marca.cargarPorDescripcion(this.getSelectedItem().toString());

        } catch (Exception e) {

        }
        return marca;
    }
    
    public void setMarca(Marca amarca){
        
        marca = amarca;
        
        setSelectedItem(marca.getDescripcion());
    }
    
}
