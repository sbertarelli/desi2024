package desi2024.accesoDatos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desi2024.entidades.Ciudad;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, String> {
    Ciudad findByCodigoPostal(String codigoPostal);
    Ciudad findByNombre(String nombre);
}