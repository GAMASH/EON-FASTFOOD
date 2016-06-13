/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractt;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Developer GAGS
 */
public class TableModelAbst extends DefaultTableModel {

    public ArrayList<Integer> booleans;
 
    public void TableModelAbst() {

        booleans = new ArrayList<Integer>();       
        
    }
    public void agregarBoolean(Integer columna){
        
        if( booleans == null ){ 
            
            booleans = new ArrayList<Integer>();        
        }
        
        booleans.add(columna);
        
    }

    public Class getColumnClass(int columnIndex) {
        if (booleans != null) {

            for (int i = 0; i < booleans.size(); i++) {

                if (columnIndex == booleans.get(i)) {

                    return Boolean.class;
                }
            }
        }

        return super.getColumnClass(columnIndex);
    }
}
