/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.controles;

import abstractt.ComboBox;
import static domain.General.propiedades_datahardcored;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Developer GAGS
 */
public class StatusMesaSelector extends ComboBox {

    ArrayList<String> visible;
    ArrayList<String> data;

    public StatusMesaSelector() {

        visible = new ArrayList<String>();
        data = new ArrayList<String>();
    }

    public void cargar() {

        String svisible;
        String sdata;
        StringTokenizer sto;

        sdata = propiedades_datahardcored.getString("status_mesa_data");

        sto = new StringTokenizer(sdata, ";");

         while (sto.hasMoreTokens()) {
            
            data.add(sto.nextToken());
        }

        svisible = propiedades_datahardcored.getString("status_mesa_visible");

        sto = new StringTokenizer(svisible, ";");

        while (sto.hasMoreTokens()) {

            visible.add(sto.nextToken());
        }

        addArray(visible);
    }

    public String getData(String svisible) {

        String sdata = "";
        int indice;
        
        indice = visible.indexOf(svisible);
        
         if (indice >= 0) {

            sdata = data.get(indice);
        }

        return sdata;
    }
}
