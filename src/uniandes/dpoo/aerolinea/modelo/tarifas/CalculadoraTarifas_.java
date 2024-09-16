package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public abstract class CalculadoraTarifas_ {
	
	static double IMPUESTO = 0.28;
	
	CalculadoraTarifas_(){
		
	}
	
	protected abstract int calcularCostoBase​(Vuelo vuelo, Cliente cliente);
	
	protected int calcularDistanciaVuelo​(Ruta ruta) {
		return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());		
	}
	
	protected abstract double calcularPorcentajeDescuento(Cliente cliente);
	
	public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int) Math.round(costoBase * (1 - porcentajeDescuento));
        int valorImpuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + valorImpuestos;
	}
	
	protected int calcularValorImpuestos(int costoBase) {
		return (int) Math.round(costoBase * IMPUESTO);
	}
	
}
