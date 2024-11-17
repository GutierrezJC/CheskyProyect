/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import AlgoritmosRemplazo.FIFO;
import AlgoritmosRemplazo.LRU;
import Objetos.Pagina;
import interfaz.VentanaPrincipalPrincipal;
import java.util.ArrayList;
import Objetos.Proceso;
import algoritmo.FCFS;
import algoritmo.Prioridad;
import algoritmo.RoundRobin;
import algoritmo.SJF;
import java.util.List;
import utilidades.Calculos;
import utilidades.GeneradorPaginas;

/**
 *
 * @author jeank
 */
public class AdministradorDeMemoria {
    
    private VentanaPrincipalPrincipal ventana;
    private ArrayList<Proceso> procesos;
    GeneradorPaginas generador = new GeneradorPaginas();
    RoundRobin roundrobin;
    FCFS algoritmoFCFS;
    Prioridad algoritmoPrioridad;
    SJF algoritmoSJF;
    // Hacia abajo 
    boolean paginacionXsegmentacion;
    int idalgoritmosRemplazo;
    
    public AdministradorDeMemoria(VentanaPrincipalPrincipal ventana) {
        this.ventana = ventana;
        this.procesos = procesos;
        Calculos.generadoFile();
        
        roundrobin = new RoundRobin(2, ventana);
        algoritmoFCFS = new FCFS(ventana);
        algoritmoPrioridad = new Prioridad(ventana);
        algoritmoSJF = new SJF(ventana);
        
    }
    
    public void ejecutaralgoritmo(int idalgoritmo) {
        switch (idalgoritmo) {
            case 1:
                
                if (paginacionXsegmentacion) {
                    cargarPaginacion(procesos);
                    algoritmoFCFS.setPaginacionXsegmentacion(paginacionXsegmentacion);
                    algoritmoFCFS.setIdalgoritmosRemplazo(idalgoritmosRemplazo);
                    algoritmoFCFS.ejecutar(procesos);
                } else {
                    
                }
                
                break;
            case 2:
                
                if (paginacionXsegmentacion) {
                    cargarPaginacion(procesos);
                    roundrobin.setPaginacionXsegmentacion(paginacionXsegmentacion);
                    roundrobin.setIdalgoritmosRemplazo(idalgoritmosRemplazo);                    
                    roundrobin.ejecutar(procesos);
                } else {
                    
                }
                
                break;
            case 3:
                
                if (paginacionXsegmentacion) {
                    cargarPaginacion(procesos);
                    algoritmoSJF.setPaginacionXsegmentacion(paginacionXsegmentacion);
                    algoritmoSJF.setIdalgoritmosRemplazo(idalgoritmosRemplazo);
                    algoritmoSJF.ejecutar(procesos);
                } else {
                    
                }
                
                break;
            case 4:
                
                if (paginacionXsegmentacion) {
                    cargarPaginacion(procesos);
                    algoritmoPrioridad.setPaginacionXsegmentacion(paginacionXsegmentacion);
                    algoritmoPrioridad.setIdalgoritmosRemplazo(idalgoritmosRemplazo);
                    algoritmoPrioridad.ejecutar(procesos);
                } else {
                    
                }
                
                break;
            default:
                
                break;
        }
        
    }
    
    public void cargarPaginacion(ArrayList<Proceso> procesos) {
        for (Proceso p : procesos) {
            generador.generarPaginas(p.getCantidadPaginas(), p.getIdProceso());
            
        }
    }
    
    public void cargarSegmentacion() {
        
    }
    
    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }
    
    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }
    
    public boolean getPaginacionXsegmentacion() {
        return paginacionXsegmentacion;
    }
    
    public void setPaginacionXsegmentacion(boolean paginacionXsegmentacion) {
        this.paginacionXsegmentacion = paginacionXsegmentacion;
    }
    
    public int getIdalgoritmosRemplazo() {
        return idalgoritmosRemplazo;
    }
    
    public void setIdalgoritmosRemplazo(int idalgoritmosRemplazo) {
        this.idalgoritmosRemplazo = idalgoritmosRemplazo;
    }
    
}
