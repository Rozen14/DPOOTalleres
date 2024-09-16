package uniandes.dpoo.aerolinea.modelo.cliente;

public class ClienteNatural extends Cliente{
	
	static String NATURAL = "Natural";
	
	private String nombre;
	
	ClienteNatural(String Nombre){
	}

	@Override
	public String getIdentificador() {
		return nombre;
	}

	@Override
	public String getTipoCliente() {
		return ClienteNatural.NATURAL;
	}	
}
