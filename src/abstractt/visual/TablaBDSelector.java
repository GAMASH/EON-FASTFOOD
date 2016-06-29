package abstractt.visual;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import abstractt.TablaBD;
import abstractt.visual.ComboBox;

/**
 *
 * @author Developer GAGS
 */
public class TablaBDSelector extends ComboBox {

    TablaBD tablabd;

    public TablaBDSelector() {

    }

    public void setTablaBD(TablaBD tablabd) {

        this.tablabd = tablabd;
        cargar();
        setSelectedItem(tablabd.getDescripcion());        
    }

    public void cargar() {

        addArray(tablabd.cargar());
    }

    public TablaBD getTablaBD() {

        try {

            tablabd.cargarPorDescripcion(this.getSelectedItem().toString());

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return tablabd;
    }  
}
