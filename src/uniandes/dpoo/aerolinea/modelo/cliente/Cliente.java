package uniandes.dpoo.aerolinea.modelo.cliente;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	private java.util.List<Tiquete>	tiquetesSinUsar;
	
	private java.util.List<Tiquete>	tiquetesUsados;
	
	public Cliente() {
		this.tiquetesSinUsar = tiquetesSinUsar;
		
		this.tiquetesUsados = tiquetesUsados;
	}
	
	public void agregarTiquete(Tiquete tiquete) {
		tiquetesSinUsar.addLast(tiquete);
	}
	
	public int 	calcularValorTotalTiquetes() {
		int suma = 0;
		for (Tiquete tiquete: tiquetesSinUsar) {
			suma += tiquete.getTarifa();
		}
		for (Tiquete tiquete: tiquetesUsados) {
			suma += tiquete.getTarifa();
		}
		return suma;
	}
	
	public abstract String getIdentificador();
	
	public abstract String getTipoCliente();
	
	public void usarTiquetes​(Vuelo vuelo) {
		for (Tiquete tiquete: tiquetesSinUsar) {
			if (tiquete.getVuelo() == vuelo) {
				tiquete.marcarComoUsado();
				tiquetesSinUsar.remove(tiquete);
				tiquetesUsados.addLast(tiquete);
			}
		}
	}
}
