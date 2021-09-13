package Models;

import java.sql.Connection;
import java.util.ArrayList;

public class UsuarioService extends Conexion {
    
    public ArrayList<Usuario> ListarTodo() {
        Connection cnx = getCOnnection();
        try {
            ArrayList<Usuario> datos = new ArrayList<Usuario>();
            ps = cnx.prepareStatement("SELECT * FROM Usuarios;");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                datos.add(new Usuario(rs.getInt("id"), rs.getString("nombre")));
            }
            return datos;
            
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                cnx.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return null;
    }
    
    public boolean Insertar(Usuario dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("insert into Usuarios(nombre) values (?);");
            ps.setString(1, dto.getNombre());
            return ps.executeUpdate() > 0; 
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                cnx.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }
    
    public Usuario BuscarPorId(Usuario dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("SELECT * FROM Usuarios WHERE id=?;");
            ps.setInt(1, dto.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                dto.setNombre(rs.getString("nombre"));
                return dto;
            }
            
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                cnx.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return null;
    }
    
    public boolean Modificar(Usuario dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("UPDATE Usuarios SET nombre=? WHERE id=?;");
            ps.setString(1, dto.getNombre());
            ps.setInt(2, dto.getId());
            return ps.executeUpdate() > 0;            
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                cnx.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }
    
    public boolean Eliminar(int id) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("DELETE FROM Usuarios WHERE id=?;");            
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;            
        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                cnx.close();
            } catch (Exception e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }
}
