/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.philadelphia.entidades;

import java.util.Date;

/**
 *
 * @author Martan Gallardo Jesus Alexis
 */
public class Multa {
    
    private int id;
    private String folio;
    private String motivo;
    private Date fecha;
    private Conductor conductor;
    private Oficial oficial;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the conductor
     */
    public Conductor getConductor() {
        return conductor;
    }

    /**
     * @param conductor the conductor to set
     */
    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    /**
     * @return the oficial
     */
    public Oficial getOficial() {
        return oficial;
    }

    /**
     * @param oficial the oficial to set
     */
    public void setOficial(Oficial oficial) {
        this.oficial = oficial;
    }
    
    
}
