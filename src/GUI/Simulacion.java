/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

//import AlgoritmosRemplazo.FIFO;
//import AlgoritmosRemplazo.LRU;
//import AlgoritmosRemplazo.OPT;
//import Objetos.Pagina;
//import Objetos.Proceso;
//import Objetos.TablaPaginas;
//import java.io.File;
//import static java.lang.System.out;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Simulacion {
//
//    public static void main(String[] args) {
//        // Crear el directorio
//        File directorio = new File("C:\\memoriavirtual");
//        if (!directorio.exists()) {
//            directorio.mkdir();
//        }
//
//        // Modifica el acceso en el bucle para FIFO, LRU y OPT
//        // TablaPaginas(int idTabla, int maxMarcos, int maxPaginas)
//        //TablaPaginas tabla = new TablaPaginas(1, 5, 10);
//// Proceso(int idProceso, String nombre, int tamañoEnBytes, int tamañoPagina, int tiempoLlegada, int tiempoRafaga, int prioridad,maxMarcos)// siempre es lo mismo marcos
//        // Crear procesos
//        //Proceso proceso1 = new Proceso(1, "Proceso1", 1000, 100, 0, 5, 1,5);
////        Proceso proceso2 = new Proceso(2, "Proceso2", 1500, 100, 1, 7, 2);
//        Proceso proceso3 = new Proceso(3, "Proceso3", 2000, 100, 2, 3, 1, 5);
//
//        // Crear el generador de páginas
//        GeneradorPaginas generador = new GeneradorPaginas();
//
//        // Generar las páginas para cada proceso ESTE ESTA FUNCIONANDO FIJO 
////        generador.generarPaginas(proceso1.getCantidadPaginas(), proceso1.getIdProceso());
////        generador.generarPaginas(proceso2.getCantidadPaginas(), proceso2.getIdProceso());
//        generador.generarPaginas(proceso3.getCantidadPaginas(), proceso3.getIdProceso());
//
//        // Añadir procesos a una lista
//        List<Proceso> listaDeProcesos = new ArrayList<>();
//        listaDeProcesos.add(proceso3);
////        listaDeProcesos.add(proceso2);
////        listaDeProcesos.add(proceso3);
//
//        // Crear instancias de los algoritmos de reemplazo de páginas
//        // proceso1.getTablaPaginas() segun yo es asi a proceso tengo que pasarle esa tabla 
//        //FIFO fifio=new FIFO(proceso1.getTablaPaginas().getMaxMarcos(),proceso1.getTablaPaginas());
//        //FIFO fifo = new FIFO(5, proceso1.getTablaPaginas());
//        //LRU lru = new LRU(5, proceso3.getTablaPaginas());
//        OPT opt = new OPT(5, proceso3.getTablaPaginas());
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //// Imprimir el estado final de la memoria
////                //Simulación de acceso a páginas con FIFO
////                System.out.println("Accediendo a páginas con FIFO:");
////                for (Proceso proceso : listaDeProcesos) {
////                    for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) { // su arrayList De paginas que esta en su tabla 
////                        fifo.accederPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
////        
////                    }
////                }
////                fifo.imprimirCola();
////          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//        //Lista de referencias futuras para OPT
//        List<Integer> futurasReferencias = new ArrayList<>();
//        for (Proceso proceso : listaDeProcesos) {
//            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
//                futurasReferencias.add(pagina.getIdPagina());
//            }
//        }
//        // Simulación de acceso a páginas con OPT
//        //System.out.println("\nAccediendo a páginas con OPT:");
//        for (Proceso proceso : listaDeProcesos) {
//            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
//                opt.referenciarPagina(pagina, futurasReferencias, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
//            }
//        }
//        opt.mostrarPaginas();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//        //Simulación de acceso a páginas con LRU
////        System.out.println("\nAccediendo a páginas con LRU:");
////        for (Proceso proceso : listaDeProcesos) {
////            for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
////                lru.referenciarPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
////            }
////        }
////        lru.mostrarCache();
////
////        System.out.println("\nEstado final de la memoria:");
////        proceso3.getTablaPaginas().imprimirEstadoMemoria();
//    }
//}
