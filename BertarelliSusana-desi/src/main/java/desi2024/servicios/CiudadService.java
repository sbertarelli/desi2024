package desi2024.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import desi2024.accesoDatos.CiudadRepository;
import desi2024.entidades.Ciudad;
import java.util.List;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<Ciudad> obtenerCiudades() {
        return ciudadRepository.findAll();
    }

    public Ciudad buscarCiudadPorCodigoPostal(String codigoPostal) {
        return ciudadRepository.findByCodigoPostal(codigoPostal);
    }
}