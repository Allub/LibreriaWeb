package cl.inacap.libreriaModel.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import cl.inacap.libreriaModel.dto.LapizGel;

/**
 * Session Bean implementation class LapizGelDAO
 */
@Stateless
@LocalBean
public class LapicesGelDAO implements LapicesGelDAOLocal {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaModel");

    /**
     * Default constructor. 
     */
    public LapicesGelDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public void add(LapizGel l) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
    		//equivalente al INSERT
			em.persist(l);
			em.flush();
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }
    
    public List<LapizGel> getAll(){
    	//equivalente al SELECT
    	EntityManager em = this.emf.createEntityManager();
    	try {
			return em.createNamedQuery("LapizGel.getAll", LapizGel.class).getResultList();
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
    	
    }
    
    public List<LapizGel> findByMarca(String marca){
    	
    	EntityManager em = this.emf.createEntityManager();
    	try {
			return em.createNamedQuery("LapizGel.findByMarca", LapizGel.class)
					.setParameter("marca", marca)
					.getResultList();
    		
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
    }
    
    public void remove(LapizGel l) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
			//SELECT * FROM destacador d WHERE d.idDestacador = idDestacador
    		LapizGel lapizGelOriginal = em.find(LapizGel.class, l.getIdLapizGel());
    		
    		em.remove(lapizGelOriginal);
    		em.flush();
    		
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }
    
    public void update(LapizGel l) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
			LapizGel lapizGelOriginal = em.find(LapizGel.class, l.getIdLapizGel());
			lapizGelOriginal.setNombre(l.getNombre());
			lapizGelOriginal.setMarca(l.getMarca());
			lapizGelOriginal.setCantidad(l.getCantidad());
			lapizGelOriginal.setPrecio(l.getPrecio());
			lapizGelOriginal.setGama(l.getGama());
			em.merge(lapizGelOriginal);
			em.flush(); 
    		
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }

	@Override
	public LapizGel find(int idLapizGel) {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.find(LapizGel.class, idLapizGel);
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}

}
