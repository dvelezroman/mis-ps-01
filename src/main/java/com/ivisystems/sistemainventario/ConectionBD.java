/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivisystems.sistemainventario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dvelezroman
 */
public class ConectionBD {
    private static final String URL = "jdbc:postgresql://<127.0.0.1>:<5432>/<inventory>";
    private static final String USER = "<postgres>";
    private static final String PASSWORD = "<password>";
    private static Connection connection = null;

    // Método para obtener la conexión
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            System.err.println("Error al establecer la conexión: " + e.getMessage());
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
