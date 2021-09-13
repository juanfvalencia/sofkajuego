/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JuegoService extends Conexion{
    
    public ArrayList<Juego> ListarTodo() {
        Connection cnx = getCOnnection();
        try {
            ArrayList<Juego> datos = new ArrayList<Juego>();
            ps = cnx.prepareStatement("SELECT * FROM Juegos;");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                datos.add(new Juego(rs.getInt("id"), rs.getInt("idUsuario"), rs.getString("fecha"), rs.getFloat("premio"), rs.getBoolean("completado")));
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
    
    public boolean Insertar(Juego dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("insert into Juegos(idUsuario) values (?);", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dto.getIdUsuario());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                dto.setId(rs.getInt(1));
                return true;
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
        return false;
    }
    
    public Juego BuscarPorId(Juego dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("SELECT * FROM Juegos WHERE id=?;");
            ps.setInt(1, dto.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                dto.setFecha(rs.getString("fecha"));
                dto.setPremio(rs.getFloat("premio"));
                dto.setCompletado(rs.getBoolean("completado"));
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
    public boolean Modificar(Juego dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("UPDATE Juegos SET premio=?, completado=? WHERE id=?;");
            ps.setString(1, dto.getFecha());
            ps.setFloat(2, dto.getPremio());
            ps.setBoolean(3, dto.isCompletado());
            ps.setInt(4, dto.getId());
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
            ps = cnx.prepareStatement("DELETE FROM Juegos WHERE id=?;");            
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
