/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jeank
 */
public class Calculos {

    public Calculos() {
    }

    public static int generarNumeroAleatorio(int maximo, int minimo) {
        int numero = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return numero;
    }

    public static void generadoFile() {
        File directorio = new File("C:\\memoriavirtual");
        if (!directorio.exists()) {
            directorio.mkdir();
        }

    }

//    
//    public static ArrayList<Integer> dividirEnPartes(int numero, int partes) {
//        ArrayList<Integer> puntosFinales = new ArrayList<>();
//        int longitudParte = numero / partes;
//        int residuo = numero % partes;
//
//        int acumulador = 0;
//        for (int i = 0; i < partes; i++) {
//            acumulador += longitudParte;
//            if (i < residuo) {
//                acumulador++;
//            }
//            puntosFinales.add(acumulador - 1); // Ajuste para evitar desbordamiento
//        }
//
//        return puntosFinales;
//    }
//    public static ArrayList<Integer> obtenerPuntosInicio(ArrayList<Integer> puntosFinales) {
//        ArrayList<Integer> puntosInicio = new ArrayList<>();
//        puntosInicio.add(0); // Comenzando desde 0
//
//        for (int i = 1; i < puntosFinales.size(); i++) {
//            puntosInicio.add(puntosFinales.get(i - 1) + 1);
//        }
//
//        return puntosInicio;
//    }
    public static ArrayList<Integer> calcularPuntosInicio(int paginas, int tiempo, int quantum) {
        ArrayList<Integer> puntosInicio = new ArrayList<>();
        int bloques = tiempo / quantum; // Redondeo hacia abajo
        int paginasPorBloque = paginas / bloques; // Páginas por bloque
        int resto = paginas % bloques; // Páginas sobrantes

        int inicio = 0;
        for (int i = 0; i < bloques; i++) {
            puntosInicio.add(inicio);
            inicio += paginasPorBloque;

            // Distribuir las páginas sobrantes (si las hay)
            if (i < resto) {
                inicio++;
            }
        }

        return puntosInicio;
    }

    public static ArrayList<Integer> calcularPuntosFinal(ArrayList<Integer> puntosInicio, int paginas) {
        ArrayList<Integer> puntosFinal = new ArrayList<>();

        for (int i = 0; i < puntosInicio.size(); i++) {
            int inicio = puntosInicio.get(i);
            int finalBloque;

            // Si no es el último bloque, el final es el inicio del siguiente bloque - 1
            if (i + 1 < puntosInicio.size()) {
                finalBloque = puntosInicio.get(i + 1) - 1;
            } else {
                // Si es el último bloque, el final es la última página (paginas - 1)
                finalBloque = paginas - 1;
            }

            puntosFinal.add(finalBloque);
        }

        return puntosFinal;
    }

}
