package cl.inacap.libreriaModel.dao;

import java.util.List;

import javax.ejb.Local;


import cl.inacap.libreriaModel.dto.LapizGel;

@Local
public interface LapicesGelDAOLocal {
	public void add(LapizGel l);
	public List<LapizGel> getAll();
	public List<LapizGel> findByMarca(String marca);
	public void remove(LapizGel l);
	public void update(LapizGel l);
	public LapizGel find(int idLapizGel);
}
