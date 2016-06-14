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
public class Persona extends TablaBD{

    public String id_persona;
    public String nombres;
    public String apellido_paterno;
    public String apellido_materno;
    public DatosFiscales datos_fiscales;
    public EMailGrupo eMail_grupo;
    public TelefonoGrupo telefono_grupo;
    public String nss;        
}
