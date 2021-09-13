package Models;

public class Categoria {
    
    private int id;
    private String nombre;
    private int complejidad;
    
        public Categoria() {
    }

    public Categoria(int id, String nombre, int complejidad) {
        this.id = id;
        this.nombre = nombre;
        this.complejidad = complejidad;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getComplejidad() {
        return complejidad;
    }

    public void setComplejidad(int complejidad) {
        this.complejidad = complejidad;
    }
    
    public String toString() {
     return this.nombre;
    }
}
