/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.Connection;
import java.util.List;

/**
 *
 * @author erikav
 */
public interface DAO<T> {
Connection con= Connection.getInstance();
    
    List<T> findAll();
    
    List<T> findBy(T find, String by);
    
    boolean insert(T insertObject);
    
}
