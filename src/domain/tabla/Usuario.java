/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain.tabla;

import abstractt.TablaBD;

/**
 *
 * @author Developer GAGS
 */
public class Usuario extends TablaBD {

    public String id_usuario;
    public Persona persona;
    public String login;
    public String password;
    
    public Usuario(){
        
        id_usuario = "";
        persona = new Persona();
        login = "";
        password = "";                
    }                    
}
