package Controllers;

import Models.Ronda;
import Models.RondaService;
import java.util.HashSet;
import java.util.Set;

public class RondaController {
    private Ronda ronda;
    private RondaService servicio;
    
    public RondaController() {
        this.servicio = new RondaService();
    }
    
    public int Empezar(Ronda dto) {
        this.servicio.Insertar(dto);
        this.ronda = dto;
        return dto.getId();
    }
    
    public void Terminar(int premio, boolean estado) {
        this.ronda.setPuntaje(premio);
        this.ronda.setResultado(estado);        
        this.servicio.Modificar(this.ronda);
    }
    
    public boolean Save(Ronda dto) {
        if(dto.getId() > 0) {
            return this.servicio.Modificar(dto);
        } else {
            return this.servicio.Insertar(dto);
        }
    }
}
