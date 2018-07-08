/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.Connection;
import data.entidades.Jugador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author erikav
 */
public class Jugadores {
    private final String TABLE_NAME = "jugadores";
    private final String ID = "_id";
    private final String NOMBRE = "nombre";    
    
    //obtiene a los jugadores
    //@return lista de jugadores
    
    public ArrayList<Jugador> getJugadores(){
        java.sql.Connection con= null;
        ArrayList<Jugador> jugadores= new ArrayList<>();
        try{
            con= Connection.getInstance().getConnection();
            Statement statement= con.createStatement();
            
            ResultSet resultSet= statement.executeQuery("SELECT * FROM"+TABLE_NAME);
            
            while(resultSet.next()){
                Jugador jugador= new Jugador();
                jugador.setId(resultSet.getInt(ID));
                jugador.setNombre(resultSet.getString(NOMBRE));
                jugadores.add(jugador);
            }
            resultSet.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(con!=null){
                try{
                    con.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
        return jugadores;
    }

    public ArrayList<Jugador> getByNombre(String nombre) {
        java.sql.Connection con = null;
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            con = Connection.getInstance().getConnection();

            String query = "SELECT * FROM " + TABLE_NAME
                    + " WHERE " + NOMBRE + " LIKE ?";

            PreparedStatement statement = con.prepareStatement(query);

            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Jugador jugador = new Jugador();

                jugador.setId(resultSet.getInt(ID));
                jugador.setId(resultSet.getInt(ID));
                jugador.setNombre(resultSet.getString(NOMBRE));
                jugadores.add(jugador);
            }

            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return jugadores;
    }   
    
   public void insert(Jugador jugador) {
        java.sql.Connection con = null;
        try {
            con = Connection.getInstance().getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(
                    "INSERT INTO " + TABLE_NAME +
                            "(" + NOMBRE + "," + NOMBRE + ","+ ")"
                            + " VALUES(?,?)");
            preparedStatement.setString(1, jugador.getNombre());
            preparedStatement.execute();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
   
}
