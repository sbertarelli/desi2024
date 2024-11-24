package desi2024.accesoDatos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import desi2024.entidades.*;

@Repository
public interface TramoRepository extends JpaRepository<Tramo, Long> {
	List<Tramo> findByCiudadOrigen(Ciudad ciudadOrigen); // Método para encontrar tramos tomando como referencia la ciudad de origen
}