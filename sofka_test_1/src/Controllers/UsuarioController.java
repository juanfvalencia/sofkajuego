package Controllers;

import Models.Usuario;
import Models.UsuarioService;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class UsuarioController {
    
    private UsuarioService servicio;
    
    public UsuarioController() {
        this.servicio = new UsuarioService();
    }

    public DefaultTableModel ListarTodo() {
        DefaultTableModel dataModel = new DefaultTableModel();
        ArrayList<Usuario> usuarios = this.servicio.ListarTodo();
        System.out.println("Usuarios ====>" + usuarios.size());
        dataModel.addColumn("ID");
        dataModel.addColumn("Nombre");
        for(Usuario dto : usuarios) {
            Object[] fila = new Object[2];  
            fila[0] = dto.getId();
            fila[1] = dto.getNombre();
            dataModel.addRow(fila);
        }
        
        return dataModel;
    }
    
    public Vector<Usuario> ListarOpciones() {
        ArrayList<Usuario> usuarios = this.servicio.ListarTodo();
        Vector<Usuario> vector = new Vector<Usuario>();
        vector.add(new Usuario(0, "Seleccione"));
        for (Usuario dto : usuarios) {
            vector.add(dto);
        }
        return vector;
    }
    
    public Usuario BuscarPorId(int id) {
        Usuario dto = new Usuario(id, "");        
        return this.servicio.BuscarPorId(dto);
    }
    
    public boolean Save(Usuario dto) {
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
