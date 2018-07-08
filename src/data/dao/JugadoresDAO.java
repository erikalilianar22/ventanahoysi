/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.entidades.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author erikav
 */
public class JugadoresDAO extends BaseDAO<Jugador> {
public JugadoresDAO(){
        table= new BaseDAO.TableData(
        "jugadores","id", new String[]{"nombre"});
    }

    @Override
    Jugador mapToObject(ResultSet resultSet) {
        Jugador e = new Jugador();
        try {
            e.setId(resultSet.getInt(table.PRIMARY_KEY));
            e.setNombre(resultSet.getString(table.fields[0]));
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return e;       
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Jugador find, String by) {
        String query = "SELECT * FROM " + table.TABLE_NAME + " WHERE " + by + " = ? ";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY)) {
                preparedStatement.setInt(1, find.getId());
            } else if (by.equals(table.fields[0])) {
                preparedStatement.setString(1, "%" + find.getNombre() + "%");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;        
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Jugador _new) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = con.prepareStatement(
                    "INSERT INTO " + table.TABLE_NAME +
                            "(" + table.fields[0] + "," + table.fields[1] + "," + table.fields[2] + ")"
                            + " VALUES(?,?,?)");

            preparedStatement.setString(1, _new.getNombre());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;        
    }
    public List<Jugador> findById(Jugador jugador) {
        return findBy(jugador, table.PRIMARY_KEY);
    }

    public List<Jugador> findByNombre(Jugador jugador) {
        return findBy(jugador, table.fields[0]);
    }    
    
    
}
