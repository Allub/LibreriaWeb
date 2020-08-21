package cl.inacap.libreriaModel.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="portaminas")
@NamedQueries({
	@NamedQuery(name="Portamina.getAll", query="SELECT p FROM Portamina p"),
	@NamedQuery(name="Portamina.findByMarca", query="SELECT p FROM Portamina p WHERE p.marca=:marca")
})

public class Portamina {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPortamina;
	private String nombre;
	private String marca;
	private int cantidad;
	private int precio;
	private String punta;
	
	public int getIdPortamina() {
		return idPortamina;
	}
	public void setIdPortamina(int idPortamina) {
		this.idPortamina = idPortamina;
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
	public String getPunta() {
		return punta;
	}
	public void setPunta(String punta) {
		this.punta = punta;
	}
	
	

}
