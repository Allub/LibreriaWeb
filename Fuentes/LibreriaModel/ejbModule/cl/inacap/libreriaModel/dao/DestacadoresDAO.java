package cl.inacap.libreriaModel.dao;


import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import cl.inacap.libreriaModel.dto.Destacador;

/**
 * Session Bean implementation class DestacadoresDAO
 */
@Stateless
@LocalBean
public class DestacadoresDAO implements DestacadoresDAOLocal {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaModel");
	
    /**
     * Default constructor. 
     */
    public DestacadoresDAO() {
        // TODO Auto-generated constructor stub
    }
    
    public void add(Destacador d) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
    		//equivalente al INSERT
			em.persist(d);
			em.flush();
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }
    
    public List<Destacador> getAll(){
    	//equivalente al SELECT
    	EntityManager em = this.emf.createEntityManager();
    	try {
			return em.createNamedQuery("Destacador.getAll", Destacador.class).getResultList();
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
    	
    }
    
    public List<Destacador> findByMarca(String marca){
    	
    	EntityManager em = this.emf.createEntityManager();
    	try {
			return em.createNamedQuery("Destacador.findByMarca", Destacador.class)
					.setParameter("marca", marca)
					.getResultList();
    		
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
    }
    
    public void remove(Destacador d) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
			//SELECT * FROM destacador d WHERE d.idDestacador = idDestacador
    		Destacador destacadorOriginal = em.find(Destacador.class, d.getIdDestacador());
    		
    		em.remove(destacadorOriginal);
    		em.flush();
    		
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }
    
    public void update(Destacador d) {
    	EntityManager em = this.emf.createEntityManager();
    	try {
			Destacador destacadorOriginal = em.find(Destacador.class, d.getIdDestacador());
			destacadorOriginal.setNombre(d.getNombre());
			destacadorOriginal.setMarca(d.getMarca());
			destacadorOriginal.setCantidad(d.getCantidad());
			em.merge(destacadorOriginal);
			em.flush(); 
    		
		} catch (Exception ex) {
			
		}finally {
			em.close();
		}
    }

	@Override
	public Destacador find(int idDestacador) {
		EntityManager em = this.emf.createEntityManager();
		try {
			return em.find(Destacador.class, idDestacador);
		} catch (Exception ex) {
			return null;
		}finally {
			em.close();
		}
	}
    

}
