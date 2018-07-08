/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author erikav
 */
public class Connection {
private static Connection instance;
    private static final String password = "";
    private static final String user = "";

    private Connection() {
        try {
            Class.forName("apache_derby_net.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getInstance() {
        if (instance == null) {
            synchronized (Connection.class) {
                if (instance == null) {
                    instance = new Connection();
                }
            }
        }

        return instance;
    }

    public java.sql.Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:derby://localhost:1527/jugador", user, password);
    }
        
}
