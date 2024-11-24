package desi2024.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    private String codigoPostal; // Se utiliza el código postal como identificador único
    private String nombre;
    private String estadoClima;

    @OneToMany(mappedBy = "ciudadOrigen")
    private List<Tramo> tramosOrigen;

    @OneToMany(mappedBy = "ciudadDestino")
    private List<Tramo> tramosDestino;

    
    // Constructores   
    public Ciudad() {
		
	}

	public Ciudad(String codigoPostal, String nombre, String estadoClima, List<Tramo> tramosOrigen, List<Tramo> tramosDestino) {
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
		this.estadoClima = estadoClima;
		this.tramosOrigen = tramosOrigen;
		this.tramosDestino = tramosDestino;
	}

	// Getters y Setters
    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }

    public List<Tramo> getTramosOrigen() {
        return tramosOrigen;
    }

    public void setTramosOrigen(List<Tramo> tramosOrigen) {
        this.tramosOrigen = tramosOrigen;
    }

    public List<Tramo> getTramosDestino() {
        return tramosDestino;
    }

    public void setTramosDestino(List<Tramo> tramosDestino) {
        this.tramosDestino = tramosDestino;
    }
}