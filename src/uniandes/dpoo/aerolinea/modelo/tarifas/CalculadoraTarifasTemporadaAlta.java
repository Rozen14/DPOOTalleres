package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;

public class CalculadoraTarifasTemporadaAlta extends CalculadoraTarifas{
    
    protected final int COSTO_POR_KM = 1000; // Costo por km en temporada alta

    public CalculadoraTarifasTemporadaAlta() {
        // Constructor vacío
    }

    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        // Calculamos la distancia del vuelo usando el metodo heredado calcularDistanciavuelo
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());

        // Si el cliente es corporativo, se usa el costo corporativo, si es natural, se usa el costo natural
        return distancia * COSTO_POR_KM;
    }

    public double calcularPorcentajeDescuento(Cliente cliente) {
        return 0; // En temporada alta no hay descuentos
    }
}
