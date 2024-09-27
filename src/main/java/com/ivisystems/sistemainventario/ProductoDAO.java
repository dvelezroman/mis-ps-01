/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ivisystems.sistemainventario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dvelezroman
 */
public class ProductoDAO {
    // Método para agregar un producto a la base de datos
    public void agregarProducto(String nombre, String descripcion, double precio, int stock) {
        Connection conn = null;
        PreparedStatement ps = null; // Declarar el PreparedStatement fuera del bloque try

        try {
            // Establecer conexión a la base de datos
            conn = ConexionBD.getConnection();
            String sql = "INSERT INTO productos (nombre, descripcion, precio, stock) VALUES (?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setDouble(3, precio);
            ps.setInt(4, stock);
            ps.executeUpdate();
            System.out.println("Producto agregado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
        } finally {
            // Cerrar los recursos en el bloque finally
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public void actualizarProducto(String nombre, String descripcion, double precio, int stock) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexionBD.getConnection();
            String sql = "UPDATE productos SET descripcion = ?, precio = ?, stock = ? WHERE nombre = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, descripcion);
            ps.setDouble(2, precio);
            ps.setInt(3, stock);
            ps.setString(4, nombre);
            ps.executeUpdate();
            System.out.println("Producto actualizado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public void eliminarProducto(String nombre) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexionBD.getConnection();
            String sql = "DELETE FROM productos WHERE nombre = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            ps.executeUpdate();
            System.out.println("Producto eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    
    public Producto leerProducto(String nombre) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Producto producto = null;

        try {
            conn = ConexionBD.getConnection();
            String sql = "SELECT * FROM productos WHERE nombre = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();

            if (rs.next()) {
                String descripcion = rs.getString("descripcion");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                producto = new Producto(nombre, descripcion, precio, stock); // Suponiendo que tienes una clase Producto
            }
        } catch (SQLException e) {
            System.out.println("Error al leer producto: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return producto;
    }
}
