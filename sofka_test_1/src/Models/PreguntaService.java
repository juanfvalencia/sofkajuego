package Models;

import java.sql.Connection;
import java.util.ArrayList;

public class PreguntaService extends Conexion {
    
    public ArrayList<Pregunta> ListarTodo() {
        Connection cnx = getCOnnection();
        try {
            ArrayList<Pregunta> datos = new ArrayList<Pregunta>();
            ps = cnx.prepareStatement("SELECT c.id as idCategoria, c.nombre as categoria, c.complejidad, p.id, p.enunciado, p.opcionCorrecta, p.opcion1, p.opcion2, p.opcion3, p.opcion4 FROM Categorias c INNER JOIN Preguntas p ON c.id = p.idCategoria;");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                datos.add(new Pregunta(
                        rs.getInt("id"), 
                        rs.getInt("idCategoria"),
                        rs.getString("categoria"),
                        rs.getInt("complejidad"),
                        rs.getString("enunciado"),
                        rs.getInt("opcionCorrecta"),
                        rs.getString("opcion1"),
                        rs.getString("opcion2"),
                        rs.getString("opcion3"),
                        rs.getString("opcion4")
                ));
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
    
    public boolean Insertar(Pregunta dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("insert into Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) values (?, ?, ?, ?, ?, ?, ?);");
            ps.setInt(1, dto.getIdCategoria());
            ps.setString(2, dto.getEnunciado());
            ps.setInt(3, dto.getOpcionCorrecta());
            ps.setString(4, dto.getOpciones()[0]);
            ps.setString(5, dto.getOpciones()[1]);
            ps.setString(6, dto.getOpciones()[2]);
            ps.setString(7, dto.getOpciones()[3]);
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
    
    public ArrayList<Pregunta> BuscarPorCategoria(int idCategoria) {
        Connection cnx = getCOnnection();
        try {
            ArrayList<Pregunta> datos = new ArrayList<Pregunta>();
            ps = cnx.prepareStatement("SELECT c.id as idCategoria, c.nombre as categoria, c.complejidad, p.id, p.enunciado, p.opcionCorrecta, p.opcion1, p.opcion2, p.opcion3, p.opcion4 FROM Categorias c INNER JOIN Preguntas p ON c.id = p.idCategoria WHERE c.id=?;");
            ps.setInt(1, idCategoria);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                datos.add(new Pregunta(
                        rs.getInt("id"), 
                        rs.getInt("idCategoria"),
                        rs.getString("categoria"),
                        rs.getInt("complejidad"),
                        rs.getString("enunciado"),
                        rs.getInt("opcionCorrecta"),
                        rs.getString("opcion1"),
                        rs.getString("opcion2"),
                        rs.getString("opcion3"),
                        rs.getString("opcion4")
                ));
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
    
    public Pregunta BuscarPorId(int id) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("SELECT c.id as idCategoria, c.nombre as categoria, c.complejidad, p.id, p.enunciado, p.opcionCorrecta, p.opcion1, p.opcion2, p.opcion3, p.opcion4 FROM Categorias c INNER JOIN Preguntas p ON c.id = p.idCategoria WHERE p.id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return new Pregunta(
                        rs.getInt("id"), 
                        rs.getInt("idCategoria"),
                        rs.getString("categoria"),
                        rs.getInt("complejidad"),
                        rs.getString("enunciado"),
                        rs.getInt("opcionCorrecta"),
                        rs.getString("opcion1"),
                        rs.getString("opcion2"),
                        rs.getString("opcion3"),
                        rs.getString("opcion4")
                );
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
    
    public boolean Modificar(Pregunta dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("UPDATE Usuarios SET idCategoria=?, enunciado=?, opcionCorrecta=?, opcion1=?, opcion2=?, opcion3=?, opcion4=? WHERE id=?;");
            ps.setInt(1, dto.getIdCategoria());
            ps.setString(2, dto.getEnunciado());
            ps.setInt(3, dto.getOpcionCorrecta());
            ps.setString(4, dto.getOpciones()[0]);
            ps.setString(5, dto.getOpciones()[1]);
            ps.setString(6, dto.getOpciones()[2]);
            ps.setString(7, dto.getOpciones()[3]);
            ps.setInt(8, dto.getId());
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
            ps = cnx.prepareStatement("DELETE FROM Preguntas WHERE id=?;");            
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
