/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;



public class Juego {    
    private int id;
    private int idUsuario;
    private String fecha;
    private float premio;
    private boolean completado;
    private Ronda[] rondas;

    public Juego() {
    }

    public Juego(int id, int idUsuario, String fecha, float premio, boolean completado){
        this.id = id;
        this.idUsuario = idUsuario;
        this.fecha = fecha;
        this.premio = premio;
        this.completado = completado;
    }
        
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPremio() {
        return premio;
    }

    public void setPremio(float resultado) {
        this.premio = resultado;
    }

    public boolean isCompletado() {
        return completado;
    }

    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
    
    public Ronda[] getRondas() {
        return this.rondas;
    }

    public void setRondas(Ronda[] rondas) {
        this.rondas = rondas;
    }
}
