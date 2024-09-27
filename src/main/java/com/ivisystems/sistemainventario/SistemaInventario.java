/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ivisystems.sistemainventario;

import javax.swing.SwingUtilities;
import java.sql.Connection;
/**
 *
 * @author dvelezroman
 */
public class SistemaInventario {

    public static void main(String[] args) {
        // Utilizar SwingUtilities para asegurar que la GUI se ejecute en el hilo de despacho de eventos
        // Connection conexion = ConexionBD.getConnection();
        // if (conexion != null) {
            // System.out.println("Conexión exitosa a la base de datos.");
        // }
        // ConexionBD.closeConnection();
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Crear y mostrar el formulario de inventario
                InventarioForm inventarioForm = new InventarioForm();
                inventarioForm.setVisible(true);
            }
        });
    }
}
