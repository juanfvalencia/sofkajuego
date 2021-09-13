/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Felipe
 */
public class Pregunta {    
    private int id;
    private String enunciado;
    private int opcionCorrecta;
    private int idCategoria;
    private Categoria categoria;
    private String[] opciones;
    
    public Pregunta() {}
    
    public Pregunta(int id, int idCategoria, String categoria, int complejidad, String enunciado, int opcionCorrecta, String opcion1, String opcion2, String opcion3, String opcion4) {
        this.id = id;
        this.enunciado = enunciado;
        this.opcionCorrecta = opcionCorrecta;
        this.categoria = new Categoria(idCategoria, categoria, complejidad);
        this.opciones = new String[] {
            opcion1, opcion2, opcion3, opcion4, 
        };
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(int opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
     public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }
}
