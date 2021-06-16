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
public class Registro {
    //Atributos
    private int id;
    private String nombre;
    private String apellido;
    private String pelicula;
    private int tiempo;
    private String observacion;
    
    public Registro(int Id,String Nombre,String Apellido,String Pelicula,int Tiempo,String Observacion){
        this.id=Id;
        this.nombre=Nombre;
        this.apellido=Apellido;
        this.pelicula=Pelicula;
        this.tiempo=Tiempo;
        this.observacion=Observacion;
    }
    public Registro(){
        this.id=0;
        this.nombre="";
        this.apellido="";
        this.pelicula="";
        this.tiempo= 0;
        this.observacion="";
    }
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public String getPelicula(){
        return pelicula;
    }
    
    public void setPelicula(String pelicula){
        this.pelicula=pelicula;
    }
    
    public int getTiempo(){
        return tiempo;
    }
    
    public void setTiempo(int tiempo){
        this.tiempo=tiempo;
    }
    
    public String getObservacion(){
        return observacion;
    }
    
    public void setObservacion(String observacion){
        this.observacion=observacion;
    }
     
}
