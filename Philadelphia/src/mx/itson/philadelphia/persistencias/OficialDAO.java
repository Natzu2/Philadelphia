/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.philadelphia.persistencias;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.philadelphia.entidades.Oficial;
import mx.itson.philadelphia.utilerias.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 * Accede a los datos del conuctor
 * @author Martan Gallardo Jesus Alexis
 */
public class OficialDAO {
    
    /**
     * Obtiene los datos del oficial
     * @return La lista de conductores
     */
    public static List<Oficial> obtenerTodos(){
        List<Oficial>  oficiales = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Oficial> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Oficial.class);
            criteriaQuery.from(Oficial.class);
            
            oficiales = session.createQuery(criteriaQuery).getResultList();
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return oficiales;
    }
    /**
     * Guarda nuevos registros
     * @param nombre
     * @param telefono
     * @param fechaAlta
     * @return el nuevo registro
     */
    public boolean guardar(String nombre, String telefono){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Oficial o = new Oficial();
            o.setNombre(nombre);
            o.setTelefono(telefono);
            
            session.save(o);
            
            session.getTransaction().commit();
            
            resultado = o.getId() != 0;
        } catch (Exception ex) {
            System.err.println("Ocurrio un error" + ex.getMessage());
        }
        return resultado;
    }
   /**
    * Obtiene el oficial específico por su id
    * @param id
    * @return El oficial deseado
    */
    public Oficial obtenerPorId(int id){
        Oficial oficial = null;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            oficial = session.get(Oficial.class, id);
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return oficial;
    }
    /**
     * Edita el registro
     * @param id
     * @param nombre
     * @param numeroLicencia
     * @param fechaAlta
     * @return El registro editado
     */
    public boolean editar(int id, String nombre, String telefono){
        boolean resultado = false;
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            
            Oficial oficial = obtenerPorId(id);
            if(oficial != null){
                oficial.setNombre(nombre);
                oficial.setTelefono(telefono);
                
                session.saveOrUpdate(oficial);              
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
            
            Oficial oficial = obtenerPorId(id);
            if(oficial != null){
                session.delete(oficial);
                session.getTransaction().commit();
            }
        } catch (HibernateException ex) {
            System.err.println("Ocurrio un error: " + ex.getMessage());
        }
        return false;
    }
    
}
