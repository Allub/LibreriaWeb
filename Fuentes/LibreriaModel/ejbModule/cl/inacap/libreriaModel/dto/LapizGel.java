package cl.inacap.libreriaModel.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="lapicesGel")
@NamedQueries({
	@NamedQuery(name="LapizGel.getAll", query="SELECT l FROM LapizGel l"),
	@NamedQuery(name="LapizGel.findByMarca", query="SELECT l FROM LapizGel l WHERE l.marca=:marca")
})
public class LapizGel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLapizGel;
	private String nombre;
	private String marca;
	private int cantidad;
	private int precio;
	private String gama;
	
	public int getIdLapizGel() {
		return idLapizGel;
	}
	public void setIdLapizGel(int idLapizGel) {
		this.idLapizGel = idLapizGel;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getGama() {
		return gama;
	}
	public void setGama(String gama) {
		this.gama = gama;
	}
	
	
}
