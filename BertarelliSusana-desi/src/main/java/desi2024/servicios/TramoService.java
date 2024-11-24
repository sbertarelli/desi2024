package desi2024.servicios;

import desi2024.entidades.Ciudad;
import desi2024.entidades.Tramo;
import desi2024.accesoDatos.TramoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TramoService {

	@Autowired
	private TramoRepository tramoRepository;


    // Método para obtener los tramos de una ciudad origen específica
    public List<Tramo> obtenerTramosPorCiudadOrigen(Ciudad ciudadOrigen) {
        return tramoRepository.findByCiudadOrigen(ciudadOrigen); 
    }
}