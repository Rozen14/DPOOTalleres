package uniandes.dpoo.aerolinea.modelo;

import java.util.Map;
import java.util.Collection;

import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private Avion avion;
	
	private String fecha;
	
	private Ruta ruta;
	
	private Map<String,​Tiquete> tiquetes;
	
	public Vuelo(Ruta ruta, String fecha, Avion avion)
	{
		this.avion = avion;
		this.ruta = ruta;
		this.fecha = fecha;
	}
	
	public Ruta getRuta() {
		return this.ruta;
	}
	
	public java.lang.String getFecha(){
		return this.fecha;
	}
	
	public Avion getAvion() {
		return this.avion;
	}
	
	public java.util.Collection<Tiquete> getTiquetes(){		
		return this.tiquetes.values();
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad) throws VueloSobrevendidoException {
		int capacidadDispobible = avion.getCapacidad() - tiquetes.size();
           if (cantidad > capacidadDispobible)
           {
               throw new VueloSobrevendidoException(this);
           }
           int total = 0;          
           for (int i = 0; i < cantidad; i++)
           {
               String codigoTiquete = generarCodigoTiquete();
               Tiquete tiquete = new Tiquete(codigoTiquete, this, cliente, calculadora.calcularTarifa(this, cliente));
               tiquetes.put(codigoTiquete, tiquete);
               total += tiquete.getTarifa();
           }
           return total;
	}
	
	public boolean equals(Object obj) {
		if (this == obj){
            return true;
        }

        if (obj instanceof Vuelo){
            Vuelo otroVuelo = (Vuelo) obj;
            return this.ruta.equals(otroVuelo.getRuta()) && this.fecha.equals(otroVuelo.getFecha());
        }
        return false;
	}

}
