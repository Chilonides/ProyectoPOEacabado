/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Fam aguayo mariscal
 */
public class login {
    
    private String usuario;
    private String password;
    
    public login(String usuario,String password){
        this.usuario=usuario;
        this.password=password;
    }
    public login(){
        this.usuario="";
        this.password="";
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setPassword(String password){
        this.password=password;
    }
    
}
