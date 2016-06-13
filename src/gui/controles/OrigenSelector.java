/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controles;

import abstractt.ComboBox;
import static domain.General.propiedades_datahardcored;
import domain.tabla.Impuesto;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Developer GAGS
 */
public class OrigenSelector extends ComboBox {

    ArrayList<String> visible;
    ArrayList<String> data;

    public OrigenSelector() {

        visible = new ArrayList<String>();
        data = new ArrayList<String>();
    }

    public void cargar() {

        String svisible;
        String sdata;
        StringTokenizer sto;

        sdata = propiedades_datahardcored.getString("origen_platillo_data");

        sto = new StringTokenizer(sdata, ";");

        for (int i = 0; i < sto.countTokens(); i++) {

            data.add(sto.nextToken());
        }

        svisible = propiedades_datahardcored.getString("origen_platillo_visible");

        sto = new StringTokenizer(svisible, ";");

        while (sto.hasMoreTokens()) {

            visible.add(sto.nextToken());
        }

        addArray(visible);
    }

    public String getData(String svisible) {

        String sdata = "";
        int indice;

        //svisible = this.getSelectedItem().toString();
        indice = visible.indexOf(svisible);
        
        
        if (indice >= 0) {

            sdata = data.get(indice);
        }

        return sdata;
    }
}
