/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accesos;

import gui.Catalogos.*;
import abstractt.visual.CatalogoAbstracto;
import java.awt.Dimension;

/**
 *
 * @author Developer GAGS
 */
public class TipoEmpleadoCatalogo extends CatalogoAbstracto {

    
    public TipoEmpleadoCatalogo(){
        this.setTitle("Tipos Empleado");
        
    }
    public void Dimensionar() {

        Dimension d = new Dimension();

        d.height = 500;
        d.width = 250;

        this.setSize(d);
    }
}
