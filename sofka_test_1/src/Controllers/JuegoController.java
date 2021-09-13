package Controllers;

import Models.Categoria;
import Models.CategoriaService;
import Models.JuegoService;
import Models.Juego;
import Models.Pregunta;
import Models.PreguntaService;
import Models.Ronda;
import java.util.ArrayList;
import java.util.Random;

public class JuegoController {

    public int rondaActual;
    private Juego juegoActual;
    public int premioAcumulado;
    public Pregunta preguntaActual;
    public Categoria categoriaActual;
    private ArrayList<Categoria> categorias;
    private JuegoService servicio;
    private CategoriaService categoriaServicio;
    private PreguntaService preguntaServicio;
    private RondaController rondaCtrl;

    public JuegoController() {
        this.rondaActual = 0;
        this.premioAcumulado = 0;
        this.servicio = new JuegoService();
        this.categoriaServicio = new CategoriaService();
        this.preguntaServicio = new PreguntaService();
    }

    public Pregunta Empezar(Juego dto) {
        this.servicio.Insertar(dto);
        this.juegoActual = dto;
        this.categorias = this.categoriaServicio.ListarTodo();
        return this.EmpezarRonda();
    }

    public Pregunta EmpezarRonda() {
        this.rondaActual += 1;
        this.rondaCtrl = new RondaController();
        this.ObtenerCategoriaActual();
        this.SeleccionarPregunta();
        Ronda newRonda = new Ronda();
        newRonda.setIdPregunta(this.preguntaActual.getId());
        newRonda.setIdJuego(juegoActual.getId());
        newRonda.setOrden(this.rondaActual);
        this.rondaCtrl.Empezar(newRonda);
        return this.preguntaActual;
    }

    public boolean ValidarRespuesta(int OpcionSeleccionada) {
        boolean estado = false;
        if (this.preguntaActual.getOpcionCorrecta() == OpcionSeleccionada) {
            int premio = 100 * this.rondaActual;
            this.premioAcumulado += premio;
            this.rondaCtrl.Terminar(premio, true);
            estado = true;
            if(this.rondaActual == 5) {
                TeminaJuego(); 
            }
        } else {
            this.premioAcumulado = 0;
            this.rondaCtrl.Terminar(this.premioAcumulado, false);
            TeminaJuego();            
        }
        return estado;
    }

    public void TeminaJuego() {
        this.juegoActual.setPremio(this.premioAcumulado);
        this.juegoActual.setCompletado(this.rondaActual == 5);        
        this.servicio.Modificar(this.juegoActual);
    }

    public void ObtenerCategoriaActual() {
        for (Categoria categoria : this.categorias) {
            if (categoria.getComplejidad() == this.rondaActual) {
                this.categoriaActual = categoria;
                break;
            }
        }
    }

    public void SeleccionarPregunta() {
        ArrayList<Pregunta> preguntasPorCategoria = this.preguntaServicio.BuscarPorCategoria(this.categoriaActual.getId());
        int size = preguntasPorCategoria.size();
        Random random = new Random();
        int indiceSeleccionado = random.nextInt(size);
        this.preguntaActual = preguntasPorCategoria.get(indiceSeleccionado);
    }
}
