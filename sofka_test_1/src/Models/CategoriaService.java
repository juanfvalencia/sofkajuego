/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaService extends Conexion{    
    
    public ArrayList<Categoria> ListarTodo() {
        Connection cnx = getCOnnection();
        try {
            ArrayList<Categoria> datos = new ArrayList<Categoria>();
            ps = cnx.prepareStatement("SELECT * FROM Categorias;");
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                datos.add(new Categoria(rs.getInt("id"), rs.getString("nombre"), rs.getInt("complejidad")));
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
    public boolean Insertar(Categoria dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("insert into Categorias(nombre, complejidad) values (?,?);");
            ps.setString(1, dto.getNombre());
            ps.setInt(2, dto.getComplejidad());
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
    public Categoria BuscarPorId(int id) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("SELECT * FROM Categorias WHERE id=?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return new Categoria(
                        id, 
                        rs.getString("nombre"), 
                        rs.getInt("complejidad")
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
    public boolean Modificar(Categoria dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("UPDATE Categorias SET nombre=?, complejidad=? WHERE id=?;");
            ps.setString(1, dto.getNombre());
            ps.setInt(2, dto.getComplejidad());
            ps.setInt(3, dto.getId());
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
            ps = cnx.prepareStatement("DELETE FROM Categorias WHERE id=?;");            
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

