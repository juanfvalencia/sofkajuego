package Controllers;

import Models.Categoria;
import Models.CategoriaService;
import Models.Usuario;
import Models.UsuarioService;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class CategoriaController {

    private CategoriaService servicio;

    public CategoriaController() {
        this.servicio = new CategoriaService();
    }

    public DefaultTableModel ListarTodo() {
        DefaultTableModel dataModel = new DefaultTableModel();
        ArrayList<Categoria> categorias = this.servicio.ListarTodo();
        dataModel.addColumn("ID");
        dataModel.addColumn("Nombre");
        dataModel.addColumn("Complejidad");
        for (Categoria dto : categorias) {
            Object[] fila = new Object[3];
            fila[0] = dto.getId();
            fila[1] = dto.getNombre();
            fila[2] = dto.getComplejidad();
            dataModel.addRow(fila);
        }

        return dataModel;
    }

    public Vector<Categoria> ListarOpciones() {
        ArrayList<Categoria> categorias = this.servicio.ListarTodo();
        Vector<Categoria> vector = new Vector<Categoria>();
        vector.add(new Categoria(0, "Seleccione", 0));
        for (Categoria dto : categorias) {
            vector.add(dto);
        }
        return vector;
    }

    public Categoria BuscarPorId(int id) {
        return this.servicio.BuscarPorId(id);
    }

    public boolean Save(Categoria dto) {
        if (dto.getId() > 0) {
            return this.servicio.Modificar(dto);
        } else {
            return this.servicio.Insertar(dto);
        }
    }

    public boolean Eliminar(int id) {
        return this.servicio.Eliminar(id);
    }

}
