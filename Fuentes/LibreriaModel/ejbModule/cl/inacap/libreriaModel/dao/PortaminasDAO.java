package cl.inacap.libreriaModel.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cl.inacap.libreriaModel.dto.Portamina;

/**
 * Session Bean implementation class PortaminasDAO
 */
@Stateless
@LocalBean
public class PortaminasDAO implements PortaminasDAOLocal {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaModel");

    /**
     * Default constructor. 
     */
    public PortaminasDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public void add(Portamina p) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
			em.persist(p);
			em.flush();
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }
    
    public List<Portamina> getAll(){
    
    	EntityManager em = this.emf.createEntityManager();
    	try {
			return em.createNamedQuery("Portamina.getAll", Portamina.class).getResultList();
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
    	
    }
    
    public List<Portamina> findByMarca(String marca){
    	
    	EntityManager em = this.emf.createEntityManager();
    	try {
			return em.createNamedQuery("Portamina.findByMarca", Portamina.class)
					.setParameter("marca", marca)
					.getResultList();
    		
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
    }
    
    public void remove(Portamina p) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
			//SELECT * FROM destacador d WHERE d.idDestacador = idDestacador
    		Portamina PortaminaOriginal = em.find(Portamina.class, p.getIdPortamina());
    		
    		em.remove(PortaminaOriginal);
    		em.flush();
    		
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }
    
    public void update(Portamina p) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
    		Portamina PortaminaOriginal = em.find(Portamina.class, p.getIdPortamina());
    		PortaminaOriginal.setNombre(p.getNombre());
    		PortaminaOriginal.setMarca(p.getMarca());
    		PortaminaOriginal.setCantidad(p.getCantidad());
			em.merge(PortaminaOriginal);
			em.flush(); 
    		
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }

	@Override
	public Portamina find(int idPortamina) {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.find(Portamina.class, idPortamina);
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}
    

}

