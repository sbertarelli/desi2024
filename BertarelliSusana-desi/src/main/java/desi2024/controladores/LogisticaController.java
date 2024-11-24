package desi2024.controladores;

import desi2024.entidades.*;
import desi2024.servicios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class LogisticaController {

	@Autowired
	private CiudadService ciudadService;

	@Autowired
	private TramoService tramoService;

	@GetMapping("/")
	public String mostrarFormulario(Model model) {
		model.addAttribute("ciudades", ciudadService.obtenerCiudades());
		return "index";
	}

	@PostMapping("/consultar")
	public String consultarCaminos(@RequestParam("codigoPostal") String codigoPostal, Model model) {
	    Ciudad ciudad = ciudadService.buscarCiudadPorCodigoPostal(codigoPostal);
	    if (ciudad == null) {
	        model.addAttribute("error", "Ingrese un código postal válido");
	        return "index";
	    }

	 // Obtener los tramos filtrados tomando como referencia la ciudad de origen
        List<Tramo> tramos = tramoService.obtenerTramosPorCiudadOrigen(ciudad);
	    model.addAttribute("ciudad", ciudad);
	    model.addAttribute("tramos", tramos);
	    return "resultado";
	}	
}