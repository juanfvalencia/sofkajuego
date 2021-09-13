package Controllers;

import Models.PreguntaService;
import Models.Pregunta;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class PreguntaController {
    private PreguntaService servicio;
    
    public PreguntaController() {
        this.servicio = new PreguntaService();
    }

    public DefaultTableModel ListarTodo() {
        DefaultTableModel dataModel = new DefaultTableModel();
        ArrayList<Pregunta> preguntas = this.servicio.ListarTodo();
        dataModel.addColumn("ID");
        dataModel.addColumn("CATEGORIA");
        dataModel.addColumn("ENUNCIADO");
        dataModel.addColumn("OPCION CORRECTA");
        dataModel.addColumn("OPCION 1");
        dataModel.addColumn("OPCION 2");
        dataModel.addColumn("OPCION 3");
        dataModel.addColumn("OPCION 4");
        
        for(Pregunta dto : preguntas) {
            Object[] fila = new Object[8];  
            fila[0] = dto.getId();
            fila[1] = dto.getCategoria().getNombre();
            fila[2] = dto.getEnunciado();
            fila[3] = dto.getOpcionCorrecta();
            fila[4] = dto.getOpciones()[0];
            fila[5] = dto.getOpciones()[1];
            fila[6] = dto.getOpciones()[2];
            fila[7] = dto.getOpciones()[3];
            dataModel.addRow(fila);
        }
        
        return dataModel;
    }
    
    public Pregunta BuscarPorId(int id) {      
        return this.servicio.BuscarPorId(id);
    }
    
    public boolean Save(Pregunta dto) {
        if(dto.getId() > 0) {
            return this.servicio.Modificar(dto);
        } else {
            return this.servicio.Insertar(dto);
        }
    }
    
    public boolean Eliminar(int id) {
        return this.servicio.Eliminar(id);
    }
}
