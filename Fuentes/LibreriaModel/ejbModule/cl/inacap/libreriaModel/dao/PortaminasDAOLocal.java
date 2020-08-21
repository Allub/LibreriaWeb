package cl.inacap.libreriaModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.libreriaModel.dto.Portamina;


@Local
public interface PortaminasDAOLocal {
	public void add(Portamina d);
	public List<Portamina> getAll();
	public List<Portamina> findByMarca(String marca);
	public void remove(Portamina d);
	public void update(Portamina d);
	public Portamina find(int idPortamina);
}
