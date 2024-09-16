package uniandes.dpoo.aerolinea.tiquetes;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class Tiquete extends java.lang.Object{
	
	private Cliente cliente;
	
	private java.lang.String codigo;
	
	private int tarifa;
	
	private boolean usado;
	
	private Vuelo vuelo;
	
	public Tiquete(java.lang.String codigo, Vuelo vuelo, Cliente clienteComprador, int tarifa){
		this.cliente = cliente;
		this.codigo = codigo;
		this.tarifa = tarifa;
		this.usado = usado;
		this.vuelo = vuelo;
	}
	
	public boolean esUsado() {
		return this.usado;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public String getCodigo(){
		return this.codigo;
	}
	
	public int getTarifa() {
		return this.tarifa;
	}
	
	public Vuelo getVuelo() {
		return this.vuelo;
	}
	
	public void marcarComoUsado() {
		this.usado = true;
	}
}
