/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Sisti
 */
public class Cuenta {
    private String producto;
    private String cuenta;
    private String clabe;
    private String moneda;
    private Cliente cliente;
    private List<Movimiento> movimientos;

    public Cuenta deserializar(String json) {
        Cuenta cuenta = new Cuenta();

        try {
            cuenta = new Gson().fromJson(json, Cuenta.class);
        } catch (Exception e) {
            System.err.println("Errore: " + e.getMessage());
        }

        return cuenta;
    }
    
    public double suma(List<Movimiento> listaMovimientos){
        double resultado = 0;
        
       for(Movimiento m : listaMovimientos){
            switch (m.getTipo()) {
                case DEPOSITO:
                        resultado += m.getCantidad();
                case RETIRO:
                        resultado -= m.getCantidad();
               
            }
        }
        
        return resultado;
    }

    public Object[] getLista() {
        Object[] lista = {
            "Cuenta: " + getCuenta(),
            "Clabe: " + getClabe(),
            "Moneda: " + getMoneda()
        };
        
  
        return lista;
    }

    /**
     * @return the producto
     */
    public String getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * @return the cuenta
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return the clabe
     */
    public String getClabe() {
        return clabe;
    }

    /**
     * @param clabe the clabe to set
     */
    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    /**
     * @return the moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * @param moneda the moneda to set
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the movimientos
     */
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * @param movimientos the movimientos to set
     */
    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

}

