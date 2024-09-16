package uniandes.dpoo.aerolinea.modelo;

public class Avion {
	
	private int capacidad;
	
	private String nombre;
	
	Avion(String nombre, int capacidad){
		this.nombre = nombre;
		this.capacidad = capacidad;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getCapacidad() {
		return this.capacidad;
	}
}
