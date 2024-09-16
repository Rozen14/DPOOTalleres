package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Aeropuerto;

public abstract class CalculadoraTarifas {

    // Atributos de la clase
    public static final double IMPUESTO = 0.28;

    // Constructor de la clase

    public CalculadoraTarifas() {
        // Constructor vacío
    }


    // Métodos de la clase

    public int calcularTarifa(Vuelo vuelo, Cliente cliente) {
        int costoBase = calcularCostoBase(vuelo, cliente);
        double porcentajeDescuento = calcularPorcentajeDescuento(cliente);
        int costoConDescuento = (int) Math.round(costoBase * (1 - porcentajeDescuento));
        int valorImpuestos = calcularValorImpuestos(costoConDescuento);
        return costoConDescuento + valorImpuestos;
    }

    protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);

    protected abstract double calcularPorcentajeDescuento(Cliente cliente);

    protected int calcularDistanciaVuelo(Ruta ruta) {
        return Aeropuerto.calcularDistancia(ruta.getOrigen(), ruta.getDestino());
    }

    protected int calcularValorImpuestos(int costoBase) {
        return (int) Math.round(costoBase * IMPUESTO);
    }
}
