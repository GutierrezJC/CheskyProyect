package AlgoritmosRemplazo;

import Objetos.TablaPaginas;
import Objetos.Pagina;
import java.util.LinkedList;
import java.util.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class FIFO {

    private int capacidad;
    private Queue<Pagina> cola;
    private TablaPaginas tabla;

    public FIFO(int capacidad, TablaPaginas tabla) {
        this.capacidad = capacidad;
        this.tabla = tabla;
        this.cola = new LinkedList<>();
        int paginasEnTabla = tabla.getPaginas().size();

        // INICIALIZAR LA CARGA 
        for (int i = 0; i < capacidad && i < paginasEnTabla; i++) {
            cola.add(tabla.getPaginas().get(i));
        }
    }

    public void accederPagina(Pagina pagina, String nombreArchivo) {
        if (tabla.accederPagina(pagina.getIdPagina(), nombreArchivo)) {

        } else {
            
            if (cola.size() >= capacidad) {
                Pagina paginaAEliminar = cola.poll();
                paginaAEliminar.setBitValidez(false);
                tabla.eliminarPagina(paginaAEliminar.getIdPagina());
            
            }
            // aqui agrege cambios
            cola.add(pagina);
            pagina.setBitValidez(true);
            tabla.cargarPagina(pagina.getIdPagina(), nombreArchivo);
            tabla.asignarMarco(pagina.getIdPagina(),5);
        }

    }

    public void imprimirCola() {
        System.out.println("  CLASE FIFO | METODO IMMPRIMIRCOLA  | Cola FIFO:  " + cola);
    }
}
