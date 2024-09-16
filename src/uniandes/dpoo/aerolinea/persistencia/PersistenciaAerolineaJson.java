package uniandes.dpoo.aerolinea.persistencia;

import java.io.IOException;

import uniandes.dpoo.aerolinea.exceptions.InformacionInconsistenteException;
import uniandes.dpoo.aerolinea.modelo.Aerolinea;

public class PersistenciaAerolineaJson implements IPersistenciaAerolinea{

	@Override
	public void cargarAerolinea(String archivo, Aerolinea aerolinea)
			throws IOException, InformacionInconsistenteException {
		
	}

	@Override
	public void salvarAerolinea(String archivo, Aerolinea aerolinea) throws IOException {
	}
	
}
