/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.ArrayList;

import java.util.Random;

public class Proceso {

    private int idProceso;
    private String nombre;  // falta
    private int tamañoEnBytes;
    private int cantidadPaginas;  
   
    private int tiempoInicio;
    private int tiempoFinalizacion;
    private int tiempoLlegada;
    private int tiempoRafaga;
    private int tiempoRestante;
    private String estado;  
    private int prioridad;

    private TablaPaginas tablaPaginas;   // Referencia a la tabla de páginas para este proceso

    // Constructor
    public Proceso(int idProceso, String nombre, int tamañoEnBytes, int tamañoPagina, int tiempoLlegada, int tiempoRafaga, int prioridad,int maxMarcos) {
        this.idProceso = idProceso;
        this.nombre = nombre;
        this.tamañoEnBytes = tamañoEnBytes;
        this.cantidadPaginas = (int) Math.ceil((double) tamañoEnBytes / tamañoPagina);// paginas del proceso osea las virtuales 
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoRafaga = tiempoRafaga;
        this.tiempoRestante = tiempoRafaga;
        this.prioridad = prioridad;
        this.estado = "Listo";           // TablaPaginas(int idTabla, int maxPaginas,int maxMarcos, )
        this.tablaPaginas = new TablaPaginas(idProceso, cantidadPaginas,maxMarcos );

        generarPaginas();
    }

    
    private void generarPaginas() {
        Random random = new Random();
        for (int i = 1; i <= cantidadPaginas; i++) {
            String nombreArchivo = "P" + idProceso + "_Pagina" + i;
            Pagina nuevaPagina = new Pagina(i, random.nextInt(100), nombreArchivo);
            tablaPaginas.agregarPagina(nuevaPagina); // Solo se agrega a la tabla de páginas
        }
    }

    // Métodos Getters y Setters
    public int getIdProceso() {
        return idProceso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTamañoEnBytes() {
        return tamañoEnBytes;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public int getTiempoRafaga() {
        return tiempoRafaga;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    public int getTiempoInicio() {
        return tiempoInicio;
    }

    public void setTiempoInicio(int tiempoInicio) {
        this.tiempoInicio = tiempoInicio;
    }

    public int getTiempoFinalizacion() {
        return tiempoFinalizacion;
    }

    public void setTiempoFinalizacion(int tiempoFinalizacion) {
        this.tiempoFinalizacion = tiempoFinalizacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TablaPaginas getTablaPaginas() {
        return tablaPaginas;
    }

    @Override
    public String toString() {
        return "Proceso{"
                + "idProceso=" + idProceso
                + ", nombre='" + nombre + '\''
                + ", tamañoEnBytes=" + tamañoEnBytes
                + ", cantidadPaginas=" + cantidadPaginas
                + ", prioridad=" + prioridad
                + ", tiempoRafaga=" + tiempoRafaga
                + ", tiempoLlegada=" + tiempoLlegada
                + ", tiempoRestante=" + tiempoRestante
                + ", tiempoInicio=" + tiempoInicio
                + ", tiempoFinalizacion=" + tiempoFinalizacion
                + ", estado='" + estado + '\''
                + '}';
    }
}
