/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import utilidades.GeneradorPaginas;
import AlgoritmosRemplazo.FIFO;
import AlgoritmosRemplazo.LRU;
import AlgoritmosRemplazo.OPT;
import Objetos.Pagina;
import Objetos.Proceso;
import Objetos.TablaPaginas;
import java.io.File;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jeank
 */
public class PruebaOPT {

    public static void main(String[] args) {
        // Crear el directorio
        File directorio = new File("C:\\memoriavirtual");
        if (!directorio.exists()) {
            directorio.mkdir();
        }
        Proceso proceso3 = new Proceso(3, "Proceso3", 2000, 100, 2, 3, 1, 5);

        // Crear el generador de páginas
        GeneradorPaginas generador = new GeneradorPaginas();
        generador.generarPaginas(proceso3.getCantidadPaginas(), proceso3.getIdProceso());
        List<Proceso> listaDeProcesos = new ArrayList<>();
        listaDeProcesos.add(proceso3);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Lista de referencias futuras para OPT
        List<Integer> futurasReferencias = new ArrayList<>();
        for (Proceso proceso : listaDeProcesos) {
            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
                futurasReferencias.add(pagina.getIdPagina());
            }
        }

        OPT opt = new OPT(5, proceso3.getTablaPaginas(), futurasReferencias);
        // Simulación de acceso a páginas con OPT
        //System.out.println("\nAccediendo a páginas con OPT:");
        for (Proceso proceso : listaDeProcesos) {
            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
                opt.referenciarPagina(pagina,  "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
            }
        }
        opt.mostrarPaginas();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
