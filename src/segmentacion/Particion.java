/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segmentacion;
/**
 * Clase que representa una partición en un sistema de gestión de memoria.
 */
public class Particion {

    private String nombreProceso; // Nombre del proceso asignado
    private int inicioP; // Inicio de la partición
    private int finalP;  // Fin de la partición
    private int nUnidades; // Número de unidades en la partición
    private int uTiempo; // Tiempo de uso
    private char estadoP; // Estado: L (Libre) o O (Ocupado)
    private int apuntador; // Apuntador para otras referencias

    /**
     * Constructor de la partición.
     * 
     * @param inicioP Inicio de la partición
     * @param finalP Fin de la partición
     * @param nUnidades Número de unidades
     */
    public Particion(int inicioP, int finalP, int nUnidades) {
        this.nombreProceso = "SN"; // Sin nombre por defecto
        this.inicioP = inicioP;
        this.finalP = finalP;
        this.nUnidades = nUnidades;
        this.uTiempo = 0;
        this.estadoP = 'L'; // Libre por defecto
        this.apuntador = 0;    
    }

    /**
     * Obtiene los detalles de la partición en formato tabular.
     * 
     * @return Cadena con los detalles de la partición
     */
    public String detallesParticion(){
        return String.format("%s\t%d\t%d\t%d\t%c\t%d", 
                              nombreProceso, inicioP, finalP, nUnidades, estadoP, apuntador);
    }

    // Getters y Setters
    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public int getInicioP() {
        return inicioP;
    }

    public void setInicioP(int inicioP) {
        this.inicioP = inicioP;
    }

    public int getFinalP() {
        return finalP;
    }

    public void setFinalP(int finalP) {
        this.finalP = finalP;
    }

    public int getnUnidades() {
        return nUnidades;
    }

    public void setnUnidades(int nUnidades) {
        this.nUnidades = nUnidades;
    }

    public int getUTiempo() {
        return uTiempo;
    }

    public void setUTiempo(int uTiempo) {
        this.uTiempo = uTiempo;
    }

    public char getEstadoP() {
        return estadoP;
    }

    public void setEstadoP(char estadoP) {
        if (estadoP == 'L' || estadoP == 'O') {
            this.estadoP = estadoP;
        } else {
            throw new IllegalArgumentException("Estado no válido: debe ser 'L' o 'O'.");
        }
    }

    public int getApuntador() {
        return apuntador;
    }

    public void setApuntador(int apuntador) {
        this.apuntador = apuntador;
    }

    @Override
    public String toString() {
        return String.format("Particion{nombreProceso='%s', inicioP=%d, finalP=%d, nUnidades=%d, uTiempo=%d, estadoP=%c, apuntador=%d}", 
                              nombreProceso, inicioP, finalP, nUnidades, uTiempo, estadoP, apuntador);
    }
}
