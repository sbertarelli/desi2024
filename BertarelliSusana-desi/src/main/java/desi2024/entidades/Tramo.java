package desi2024.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tramos")
public class Tramo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ciudad_origen")
    private Ciudad ciudadOrigen;

    private String estadoClima;
    
    @ManyToOne
    @JoinColumn(name = "ciudad_destino")
    private Ciudad ciudadDestino;
    
    @Enumerated(EnumType.STRING)
    private TipoCalzada tipoCalzada;

	public enum TipoCalzada {
	    TIERRA, RIPIO, ASFALTO
	}
 
	// Constructor    
	public Tramo(Long id, Ciudad ciudadOrigen, Ciudad ciudadDestino, TipoCalzada tipoCalzada, String estadoClima) {
		this.id = id;	
		this.ciudadOrigen = ciudadOrigen;
		this.ciudadDestino = ciudadDestino;
		this.tipoCalzada = tipoCalzada;
        this.estadoClima = estadoClima;
	}
	
	public Tramo() {
		
	}


	// Getters y Setters
    public Long getId() {
        return id;
    }    

	public void setId(Long id) {
        this.id = id;
    }

    public Ciudad getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(Ciudad ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Ciudad getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(Ciudad ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public TipoCalzada getTipoCalzada() {
        return tipoCalzada;
    }

    public void setTipoCalzada(TipoCalzada tipoCalzada) {
        this.tipoCalzada = tipoCalzada;
    }
    
    public String getEstadoClima() {
        return estadoClima;
    }

    public void setEstadoClima(String estadoClima) {
        this.estadoClima = estadoClima;
    }

 // Método para determinar si el tramo es transitable
    public String estadoTramo(Ciudad tramosOrigen, Ciudad tramosDestino) {
        String climaOrigen = tramosOrigen.getEstadoClima(); // Se obtiene el clima de la ciudad de origen
        String climaDestino = tramosDestino.getEstadoClima(); // Se obtiene el clima de la ciudad de destino

        switch (tipoCalzada) {
            case TIERRA:
                // Un camino de tierra es transitable solo si el clima es óptimo en ambos tramos
                return "ÓPTIMO".equals(climaOrigen) && "ÓPTIMO".equals(climaDestino) ? "Transitable" : "Intransitable";
            
            case RIPIO:
                // Un camino de ripio es transitable si al menos uno de los tramos tiene clima óptimo o lluvia
                return ("ÓPTIMO".equals(climaOrigen) || "LLUVIA".equals(climaOrigen) ||
                        "ÓPTIMO".equals(climaDestino) || "LLUVIA".equals(climaDestino)) ? "Transitable" : "Intransitable";
            
            case ASFALTO:
                // Un camino de asfalto es intransitable si al menos uno de los tramos tiene nieve intensa
                return ("NIEVE INTENSA".equals(climaOrigen) || "NIEVE INTENSA".equals(climaDestino)) ? "Intransitable" : "Transitable";
            
            default:
                return "Intransitable";
        }
    }
}