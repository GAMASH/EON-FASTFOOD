/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controles;

import abstractt.ComboBox;
import domain.tabla.TipoArticulo;

/**
 *
 * @author Developer GAGS
 */
public class TipoArticuloSelector extends ComboBox {

    TipoArticulo tipo_articulo;

    public TipoArticuloSelector() {

         tipo_articulo = new TipoArticulo();
    }

    public void cargar() {

        addArray(TipoArticulo.cargarTiposArticulo());
    }

    public TipoArticulo getTipoArticulo() {

       
        try {

            tipo_articulo.cargarPorDescripcion(this.getSelectedItem().toString());

        } catch (Exception e) {

        }
        return tipo_articulo;
    }

    public void setTipoArticulo(TipoArticulo atipo_articulo) {

        tipo_articulo = atipo_articulo;

        setSelectedItem(tipo_articulo.getDescripcion());
    }
}
