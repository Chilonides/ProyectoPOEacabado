/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Registro;

import java.sql.*;

public class Blockbuster {
    //Conecxion a la Base de Datos
    
    private Registro objRegis=new Registro();
    
    private Connection conexion;
    
    private PreparedStatement stInsertar;
    private PreparedStatement stConsultar;
    private PreparedStatement stModificar;
    private PreparedStatement stEliminar;
    
    public Blockbuster() throws Exception{
        
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        
    
    public void abrirConexion()throws Exception{
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/blockbuster?serverTimezone=GMT-5","root","");       
        stInsertar = conexion.prepareStatement("INSERT INTO Registro values (?,?,?,?,?,?)");
        stConsultar = conexion.prepareStatement("SELECT * From Registro WHERE id=?");
        stModificar = conexion.prepareStatement("UPDATE Registro set nombre=?, apellido=?, pelicula=? genero=?, tiempo=?, sexo=?, observacion=? WHERE id=?");
        stEliminar = conexion.prepareStatement("DELETE FROM Registro WHERE id=?");
     
    }
    
    public void cerrarConexion() throws Exception{
        conexion.close();
    }
    
    public Registro getobjRegis(){
        return objRegis;
    }
    
    public void setobjRegis(Registro objRegis){
        this.objRegis=objRegis;
    }
    
    public void cargarRegistro(String nombre,String apellido,String pelicula,int tiempo,String observacion,int id){
       
    objRegis.setNombre(nombre);
    objRegis.setApellido(apellido);
    objRegis.setPelicula(pelicula);
    objRegis.setTiempo(tiempo);
    objRegis.setObservacion(observacion);
    objRegis.setId(id);
    }
    
    public void insertarRegistro(){
        try {
            stInsertar.setString(1, objRegis.getNombre());
            stInsertar.setString(2, objRegis.getApellido());
            stInsertar.setString(3, objRegis.getPelicula());
            stInsertar.setInt(4, objRegis.getTiempo());
            stInsertar.setString(5, objRegis.getObservacion());
             stInsertar.setInt(6, objRegis.getId());
            
            stInsertar.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar un registro en el Controlador");
            System.out.println(ex.getMessage());
        }
    }
    
    public void ConsultarResgistro(int id){
        ResultSet rs=null;
        try {
            stConsultar.setInt(1, id);
            rs=stConsultar.executeQuery();
            if (rs.next()) 
                cargarRegistro(rs.getString("nombre"),rs.getString("apellido"),rs.getString("pelicula"),rs.getInt("tiempo"),rs.getString("observacion"),rs.getInt("id")
                );
            else
                cargarRegistro("","","",0,"",0);
            
        } catch (SQLException ex) {
            System.out.println("Error al consultar registro en el Controlador");
            System.out.println(ex.getMessage());
        }
        
    }
    
    public void ModificarRegistro(){
        try {
            stModificar.setString(1, objRegis.getNombre());
            stModificar.setString(2, objRegis.getApellido());
            stModificar.setString(3, objRegis.getPelicula());
            stModificar.setInt(4, objRegis.getTiempo());
            stModificar.setString(5, objRegis.getObservacion());
            stModificar.setInt(6,objRegis.getId());
            
            stModificar.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al Actualizar registro en el Controlador");
            ex.getMessage();
        }
    }
    
    public void EliminarRegistro(int id){
        try {
            stEliminar.setInt(1, id);
            stEliminar.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error al Eliminar un registro en el Controlador");
            ex.getMessage();
        }
    }
}