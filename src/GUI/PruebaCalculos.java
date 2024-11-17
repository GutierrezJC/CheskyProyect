/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import static utilidades.Calculos.calcularPuntosFinal;
import static utilidades.Calculos.calcularPuntosInicio;

/**
 *
 * @author jeank
 */
public class PruebaCalculos {

    public static void main(String[] args) {
//        int numero = 10; // Puedes cambiar este número a cualquier valor 
//        int partes = 5; // Puedes cambiar este valor a cualquier cantidad de partes 
//        ArrayList<Integer> puntosFinales = dividirEnPartes(numero, partes);
//        ArrayList<Integer> puntosInicio = obtenerPuntosInicio(puntosFinales);
//
//        System.out.println("Puntos finales de cada parte: " + puntosFinales);
//        System.out.println("Puntos de inicio de cada parte: " + puntosInicio);
//        
//        

        int paginas = 16;  // Cantidad total de páginas
        int tiempo = 3;    // Ráfaga de tiempo
        int quantum = 2;   // Quantum de tiempo
        ArrayList<Integer> inicios = calcularPuntosInicio(paginas, tiempo, quantum);
        ArrayList<Integer> finales = calcularPuntosFinal(inicios, 16);
        System.out.println("" + inicios);
        System.out.println("" + finales);
    }

}