/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.philadelphia.ui;

import java.util.Date;
import mx.itson.philadelphia.persistencias.ConductorDAO;

/**
 *
 * @author Martan Gallardo Jesus Alexis
 */
public class Main {
    
    public static void main(String[] args) {
        ConductorDAO c = new ConductorDAO();
        c.obtenerTodos();
        c.guardar("Javier Quintero", "4534323", new Date());
    }
}
