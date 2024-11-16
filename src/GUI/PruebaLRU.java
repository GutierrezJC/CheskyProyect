/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import utilidades.GeneradorPaginas;
import AlgoritmosRemplazo.LRU;
import Objetos.Pagina;
import Objetos.Proceso;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeank
 */
public class PruebaLRU {

    public static void main(String[] args) {

        File directorio = new File("C:\\memoriavirtual");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
// Proceso(int idProceso, String nombre, int tamañoEnBytes, int tamañoPagina, int tiempoLlegada, int tiempoRafaga, int prioridad,int maxMarcos) 
        Proceso proceso3 = new Proceso(3, "Proceso3", 2000, 100, 2, 3, 1, 5);
        // Crear el generador de páginas
        GeneradorPaginas generador = new GeneradorPaginas();

        generador.generarPaginas(proceso3.getCantidadPaginas(), proceso3.getIdProceso());
        LRU lru = new LRU(5, proceso3.getTablaPaginas());
        List<Proceso> listaDeProcesos = new ArrayList<>();
        //Simulación de acceso a páginas con LRU
        //System.out.println("\nAccediendo a páginas con LRU:");
        listaDeProcesos.add(proceso3);
        
        for (Proceso proceso : listaDeProcesos) {
            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
                lru.referenciarPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
            }
        }
        lru.mostrarCache();

        System.out.println("\nEstado final de la memoria:");
        proceso3.getTablaPaginas().imprimirEstadoMemoria();
    }

}
