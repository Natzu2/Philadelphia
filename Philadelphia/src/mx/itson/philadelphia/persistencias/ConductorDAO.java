/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.philadelphia.persistencias;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Conductor;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Accede a los datos del conuctor
 * @author Martan Gallardo Jesus Alexis
 */
public class ConductorDAO {
    
    /**
     * Obtiene los datos del conductor
     * @return La lista de conductores
     */
    public static List<Conductor> obtenerTodos(){
        List<Conductor>  conductores = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Conductor> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Conductor.class);
            criteriaQuery.from(Conductor.class);
            
            conductores = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return conductores;
    }
    /**
     * Guarda nuevos registros
     * @param nombre
     * @param numeroLicencia
     * @param fechaAlta
     * @return el nuevo registro
     */
    public boolean guardar(String nombre, String numeroLicencia, Date fechaAlta){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Conductor c = new Conductor();
            c.setNombre(nombre);
            c.setNumeroLicencia(numeroLicencia);
            c.setFechaAlta(fechaAlta);
            
            session.save(c);
            
            session.getTransaction().commit();
            
            resultado = c.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
   /**
    * Obtiene el conductor específico por su id
    * @param id
    * @return El conductor deseado
    */
    public Conductor obtenerPorId(int id){
        Conductor conductor = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            conductor = session.get(Conductor.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return conductor;
    }
    /**
     * Edita el registro
     * @param id
     * @param nombre
     * @param numeroLicencia
     * @param fechaAlta
     * @return El registro editado
     */
    public boolean editar(int id, String nombre, String numeroLicencia, Date fechaAlta){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Conductor conductor = obtenerPorId(id);
            if(conductor != null){
                conductor.setNombre(nombre);
                conductor.setNumeroLicencia(numeroLicencia);
                conductor.setFechaAlta(fechaAlta);
                
                session.saveOrUpdate(conductor);              
                session.getTransaction().commit();
                resultado = true;
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return resultado;
    }
    /**
     * Elimina el registro
     * @param id
     * @return 
     */
    public boolean eliminar(int id){
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Conductor conductor = obtenerPorId(id);
            if(conductor != null){
                session.delete(conductor);
                session.getTransaction().commit();
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return false;
    }
    
}
