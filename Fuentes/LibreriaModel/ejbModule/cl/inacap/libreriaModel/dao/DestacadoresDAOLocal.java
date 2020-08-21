package cl.inacap.libreriaModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.libreriaModel.dto.Destacador;

@Local
public interface DestacadoresDAOLocal {
	public void add(Destacador d);
	public List<Destacador> getAll();
	public List<Destacador> findByMarca(String marca);
	public void remove(Destacador d);
	public void update(Destacador d);
	public Destacador find(int idDestacador);
}
