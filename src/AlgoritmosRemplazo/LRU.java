/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgoritmosRemplazo;

import Objetos.Pagina;
import Objetos.TablaPaginas;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
    private int capacidad;
    private LinkedHashMap<Integer, Pagina> cache;
    private TablaPaginas tabla;

    public LRU(int capacidad, TablaPaginas tabla) {
        this.capacidad = capacidad;
        this.tabla = tabla;
         int paginasEnTabla = tabla.getPaginas().size();
        this.cache = new LinkedHashMap<>(capacidad, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Pagina> eldest) {
                return size() > capacidad;
            }
        };
        
           for (int i = 0; i < capacidad && i < paginasEnTabla; i++) {
            cache.put(i+1,tabla.getPaginas().get(i));
        }
    }
    
  

    public void referenciarPagina(Pagina pagina, String nombreArchivo) {
        if (!cache.containsKey(pagina.getIdPagina())) {
            
            if (cache.size() >= capacidad) {
                Integer idPaginaAEliminar = cache.entrySet().iterator().next().getKey();
                cache.remove(idPaginaAEliminar);
                tabla.eliminarPagina(idPaginaAEliminar);
            }
            
            cache.put(pagina.getIdPagina(), pagina);
            pagina.setBitValidez(true);
            tabla.asignarMarco(pagina.getIdPagina(), 5);
            tabla.cargarPagina(pagina.getIdPagina(), nombreArchivo);
            
        } else {
            // Si la página ya está en cache, actualiza su uso
            tabla.accederPagina(pagina.getIdPagina(), nombreArchivo);
            cache.put(pagina.getIdPagina(), pagina);
            
            
        }
    }

    public void mostrarCache() {
        System.out.println("Cache LRU: CLASE LRU | METODO MOSTRARCACHE " + cache.keySet());
    }
}
