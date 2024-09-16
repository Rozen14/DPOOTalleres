package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;

public class CalculadoraTarifasTemporadaBaja_ extends CalculadoraTarifas_{
	protected final int COSTO_POR_KM_CORPORATIVO = 900;
    
	protected final int COSTO_POR_KM_NATURAL = 600;

    protected final double DESCUENTO_GRANDES = 0.2;
    
    protected final double DESCUENTO_MEDIANAS = 0.1;
    
    protected final double DESCUENTO_PEQUENAS = 0.05;

    public CalculadoraTarifasTemporadaBaja_() {
    }

    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {       
        int distancia = calcularDistanciaVuelo​(vuelo.getRuta());

        if (cliente instanceof ClienteCorporativo) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        } else if (cliente instanceof ClienteNatural) {
            return distancia * COSTO_POR_KM_NATURAL;
        }
        return 0; 
    }
    
    public double calcularPorcentajeDescuento(Cliente cliente) {
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            if (corporativo.getTamanoEmpresa() == 1) {
                return DESCUENTO_GRANDES;
            } else if (corporativo.getTamanoEmpresa() == 2) {
                return DESCUENTO_MEDIANAS;
            } else if (corporativo.getTamanoEmpresa() == 3) {
                return DESCUENTO_PEQUENAS;
            }
        }        
        return 0;
    }
}
