/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author jeank
 */
public class Marco {
    private int idMarco;         // Identificador único del marco en memoria
    private int idPagina;        // Identificador de la página almacenada en el marco
    private int desplazamiento;

    public Marco(int idMarco, int idPagina, int desplazamiento) {
        this.idMarco = idMarco;
        this.idPagina = idPagina;
        this.desplazamiento = desplazamiento;
    }

    public int getIdMarco() {
        return idMarco;          // Devuelve el ID del marco
    }

    public int getIdPagina() {
        return idPagina;         // Devuelve el ID de la página en el marco
    }

    public int getDesplazamiento() {
        return desplazamiento;
    }
}

