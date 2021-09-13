/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.util.ArrayList;

public class RondaService extends Conexion {

    public ArrayList<Ronda> ListarTodo(int idJuego) {
        Connection cnx = getCOnnection();
        try {
            ArrayList<Ronda> datos = new ArrayList<Ronda>();
            ps = cnx.prepareStatement("SELECT * FROM Rondas WHERE idJuego=?;");
            ps.setInt(1, idJuego);
            rs = ps.executeQuery();

            while (rs.next()) {
                datos.add(new Ronda(
                        rs.getInt("id"),
                        rs.getInt("idPregunta"),
                        rs.getInt("orden"),
                        rs.getBoolean("resultado"),
                        rs.getInt("puntaje")
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

    public boolean Insertar(Ronda dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("insert into Rondas(idPregunta, idJuego, orden) values (?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dto.getIdPregunta());
            ps.setInt(2, dto.getIdJuego());
            ps.setInt(3, dto.getOrden());

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if (rs.next()) {
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

    public boolean Modificar(Ronda dto) {
        Connection cnx = getCOnnection();
        try {
            ps = cnx.prepareStatement("UPDATE Rondas SET resultado=?, puntaje=? WHERE id=?;");
            ps.setInt(1, (dto.isResultado() ? 1 : 0));
            ps.setInt(2, dto.getPuntaje());
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

}
