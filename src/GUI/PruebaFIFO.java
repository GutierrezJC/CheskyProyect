/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import AlgoritmosRemplazo.FIFO;
import AlgoritmosRemplazo.FIFO;
import AlgoritmosRemplazo.LRU;
import AlgoritmosRemplazo.OPT;
import utilidades.GeneradorPaginas;
import Objetos.Pagina;
import Objetos.Proceso;
import Objetos.TablaPaginas;
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

public class PruebaFIFO {

    public static void main(String[] args) {
        // Crear el directorio
        File directorio = new File("C:\\memoriavirtual");
        if (!directorio.exists()) {
            directorio.mkdir();
        }

        Proceso proceso3 = new Proceso(3, "Proceso3", 2000, 100, 2, 3, 1, 5);
        List<Proceso> listaDeProcesos = new ArrayList<>();
        listaDeProcesos.add(proceso3);

        GeneradorPaginas generador = new GeneradorPaginas();

//         Generar las páginas para cada proceso ESTE ESTA FUNCIONANDO FIJO 
        generador.generarPaginas(proceso3.getCantidadPaginas(), proceso3.getIdProceso());
        FIFO fifio = new FIFO(proceso3.getTablaPaginas().getMaxMarcos(), proceso3.getTablaPaginas());

        //// Imprimir el estado final de la memoria
        //Simulación de acceso a páginas con FIFO
        //System.out.println("Accediendo a páginas con FIFO:");
        for (Proceso proceso : listaDeProcesos) {
            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) { // su arrayList De paginas que esta en su tabla 
                fifio.accederPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());

            }
        }
        fifio.imprimirCola();

    }
}
