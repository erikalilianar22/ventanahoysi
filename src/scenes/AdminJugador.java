/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scenes;

import data.dao.JugadoresDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import ventanahoysi.JugadorModel;

/**
 *
 * @author erikav
 */
public class AdminJugador {
    public VBox content(){
        JugadoresDAO jugadoresDAO= new JugadoresDAO();
        
        final ObservableList<JugadorModel>data= FXCollections.observableArrayList(
        JugadorModel.toModel(jugadoresDAO.findAll()));
        
        Label etiqueta= new Label("Administrar Jugadores");
        etiqueta.setFont(new Font("Arial",20));
        TableView table = new TableView();
        
        TableColumn id= new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<JugadorModel, Integer>("id"));
        TableColumn nombre = new TableColumn("Nombre");
        nombre.setCellValueFactory(new PropertyValueFactory<JugadorModel, String>("nombre"));
        
        table.setItems(data);
        table.getColumns().addAll(id, nombre);
        
        VBox administrador= new VBox(10);
        administrador.getChildren().addAll(etiqueta, table);
        return administrador;
        
    }
    
}
