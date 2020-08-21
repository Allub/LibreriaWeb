package cl.inacap.libreriaModel.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="destacadores")
@NamedQueries({
	@NamedQuery(name="Destacador.getAll", query="SELECT d FROM Destacador d"),
	@NamedQuery(name="Destacador.findByMarca", query="SELECT d FROM Destacador d WHERE d.marca=:marca")
})
public class Destacador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDestacador;
	private String nombre;
	private String marca;
	private int cantidad;
	private int precio;
	private String gama;
	
	
	
	public int getIdDestacador() {
		return idDestacador;
	}
	public void setIdDestacador(int idDestacador) {
		this.idDestacador = idDestacador;
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
	
}
