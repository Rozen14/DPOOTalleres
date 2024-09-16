package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteNatural;


public class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
    
    protected final int COSTO_POR_KM_CORPORATIVO = 900;
    protected final int COSTO_POR_KM_NATURAL = 600;

    protected final double DESCUENTO_GRANDES = 0.2;
    protected final double DESCUENTO_MEDIANAS = 0.1;
    protected final double DESCUENTO_PEQUENAS = 0.05;

    // Constructor de la clase

    public CalculadoraTarifasTemporadaBaja() {
        // Constructor vacío
    }

    // Métodos de la clase

    public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
        // Calculamos la distancia del vuelo usando el metodo heredado calcularDistanciavuelo
        int distancia = calcularDistanciaVuelo(vuelo.getRuta());

        // Si el cliente es corporativo, se usa el costo corporativo, si es natural, se usa el costo natural
        if (cliente instanceof ClienteCorporativo) {
            return distancia * COSTO_POR_KM_CORPORATIVO;
        } else if (cliente instanceof ClienteNatural) {
            return distancia * COSTO_POR_KM_NATURAL;
        }
        return 0; // Valor predeterminado si el cliente no es valido
    }

    public double calcularPorcentajeDescuento(Cliente cliente) {
        // Si el cliente es corporativo, aplicamos el descuento según el tamaño de la empresa
        if (cliente instanceof ClienteCorporativo) {
            ClienteCorporativo corporativo = (ClienteCorporativo) cliente;
            if (corporativo.getTamanoEmpresa() == ClienteCorporativo.GRANDE) {
                return DESCUENTO_GRANDES;
            } else if (corporativo.getTamanoEmpresa() == ClienteCorporativo.MEDIANA) {
                return DESCUENTO_MEDIANAS;
            } else if (corporativo.getTamanoEmpresa() == ClienteCorporativo.PEQUENA) {
                return DESCUENTO_PEQUENAS;
            }
        }
        // Para clientes naturales no se aplica descuento
        return 0;
    }



}
