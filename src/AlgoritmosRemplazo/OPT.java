/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmosRemplazo;

import Objetos.Pagina;
import Objetos.TablaPaginas;
import java.util.ArrayList;
import java.util.List;

public class OPT {

    private int capacidad;
    private ArrayList<Pagina> cache;
    private TablaPaginas tabla;
    private List<Integer> futurasReferencias;

    public OPT(int capacidad, TablaPaginas tabla, List<Integer> futurasReferencias) {
        this.capacidad = capacidad;
        this.tabla = tabla;
        this.futurasReferencias = futurasReferencias;
        int paginasEnTabla = tabla.getPaginas().size();
        this.cache = new ArrayList<>(capacidad);
        for (int i = 0; i < capacidad && i < paginasEnTabla; i++) {
            Pagina p = tabla.getPaginas().get(i);
            p.setBitValidez(true);
            cache.add(p);
        }
    }


    public void referenciarPagina(Pagina pagina, String nombreArchivo) {
        if (!cache.contains(pagina)) { // Fallo de página
            if (cache.size() >= capacidad) { // Caché llena, se requiere reemplazo
                int paginaAEliminarIndex = encontrarPaginaAEliminar(this.futurasReferencias);
                Pagina paginaAEliminar = cache.remove(paginaAEliminarIndex);
                tabla.eliminarPagina(paginaAEliminar.getIdPagina());

                // Llamar a `asignarMarco` para liberar el marco de la página eliminada
                tabla.asignarMarco(paginaAEliminar.getIdPagina(), -1); // -1 o null para liberar el marco
            }

            // Asignar un nuevo marco a la página que se va a cargar
            //int desplazamiento = calcularDesplazamiento(pagina); // Método para calcular desplazamiento
            tabla.asignarMarco(pagina.getIdPagina(), 4);

            cache.add(pagina); // Añadir la página a la caché
            tabla.cargarPagina(pagina.getIdPagina(), nombreArchivo);
            pagina.setBitValidez(true); // Indicar que está en memoria
        }

        // Confirmar que la página está en memoria
        tabla.accederPagina(pagina.getIdPagina(), nombreArchivo);

        // Actualizar las futuras referencias, eliminando la página actual
        this.futurasReferencias.remove(Integer.valueOf(pagina.getIdPagina()));
        System.out.println("Estado de la caché: " + cache);
    }

    private int encontrarPaginaAEliminar(List<Integer> futurasReferencias) {
        int maxDistancia = -1;
        int paginaAEliminarIndex = -1;

        for (int i = 0; i < cache.size(); i++) {
            int distancia = futurasReferencias.indexOf(cache.get(i).getIdPagina());
            if (distancia == -1) {
                return i;
            } else if (distancia > maxDistancia) {
                maxDistancia = distancia;
                paginaAEliminarIndex = i;
            }
        }
        return paginaAEliminarIndex;
    }

    public void mostrarPaginas() {
        System.out.println("Cache OPT: " + cache);
    }
}
