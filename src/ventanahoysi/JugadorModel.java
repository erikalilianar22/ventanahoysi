/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanahoysi;

import data.entidades.Jugador;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author erikav
 */
public class JugadorModel {
private final SimpleIntegerProperty id;
    private final SimpleStringProperty nombre;
    
    public static List<JugadorModel> toModel(List<Jugador> jugadores){
        List<JugadorModel> jugadorModels =new ArrayList<>();
        
        for(Jugador e: jugadores){
            jugadorModels.add(new JugadorModel(e));
        }
        return jugadorModels;
    } 
    
    private JugadorModel(int id, String nombre){
        this.id= new  SimpleIntegerProperty(id);
        this.nombre= new SimpleStringProperty(nombre);
    }
    private JugadorModel(Jugador e) {
        this.id = new SimpleIntegerProperty(e.getId());
        this.nombre = new SimpleStringProperty(e.getNombre());        
    }

    public int getId(){
        return id.get();
    }
    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }   
}
