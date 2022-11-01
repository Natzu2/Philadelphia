/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.catrina.entidades;

import com.google.gson.Gson;
import java.util.List;
import mx.itson.catrina.enumeradores.Tipo;

/**
 * Almacena todos los datos del Estado de Cuenta
 * @author Sisti
 */
public class Cuenta {
    private String producto;
    private String cuenta;
    private String clabe;
    private String moneda;
    private Cliente cliente;
    private List<Movimiento> movimientos;
    /**
     * 
     * @param json
     * @return cuenta
     */
    public Cuenta deserializar(String json) {
        Cuenta cuenta = new Cuenta();

        try {
            cuenta = new Gson().fromJson(json, Cuenta.class);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        return cuenta;
    }
    
    /**
     * 
     * @param listaMovimientos
     * @return Total de los depositos
     */
    
    public double getSumaDeposito(List<Movimiento> listaMovimientos){
        double totalDeposito = 0;
       for(Movimiento m : listaMovimientos){
            if(m.getTipo() == Tipo.DEPOSITO) {
                totalDeposito += m.getCantidad();
            }
        }
        return totalDeposito;
    }
    
    /**
     * 
     * @param listaMovimientos
     * @return Total de los retiros
     */
   public double getSumaRetiro(List<Movimiento> listaMovimientos) {
        double totalRetiro = 0;
        
        for(Movimiento m : listaMovimientos) {
            if(m.getTipo() == Tipo.RETIRO) {
                totalRetiro += m.getCantidad();
            }
        }
        return totalRetiro;
   }
   
   /**
    * 
    * @param suma
    * @return Saldo final del pedido
    */
    public double getTotal(Movimiento suma) {
        double total = getSumaDeposito(movimientos) - getSumaRetiro(movimientos);
        return total;
    }
    
    /**
     * 
     * @return Cuenta, Clabe bancaria y moneda en forma de lista
     */
    public Object[] getLista() {
        Object[] lista = {
            "Cuenta: " + getCuenta(),
            "Clabe: " + getClabe(),
            "Moneda: " + getMoneda()
        };
        return lista;
    }
    
    /**
     * 
     * @param mes
     * @return El saldo inicial (Suma del total de los meses anteriores)
     */
    public double getSaldoInicial(int mes) {
        double saldoInicial = 0;
        
        for (Movimiento m : this.movimientos) {
            for (int i = 0; i < mes; i++) {
                if (m.getFecha().getMonth() == i && m.getTipo() == Tipo.DEPOSITO) {
                    saldoInicial += m.getCantidad();
                }else if (m.getFecha().getMonth() == i && m.getTipo() == Tipo.RETIRO) {
                    saldoInicial -= m.getCantidad();
                }
            }
        }
        return saldoInicial;
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

