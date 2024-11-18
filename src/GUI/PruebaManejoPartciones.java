/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.util.ArrayList;
import segmentacion.ManejoParticiones;

public class PruebaManejoPartciones {

    public static void main(String[] args) {
//        System.out.println("=== Prueba de ManejoParticiones ===");
//
//        // Caso 1: Cargar particiones de tamaño fijo
//        System.out.println("Caso 1: Particiones de tamaño fijo");
//        ManejoParticiones manejoFijo = new ManejoParticiones(100, 20);
//        System.out.println(manejoFijo.listarParticiones());

        // Caso 2: Cargar particiones de tamaño variable
        System.out.println("Caso 2: Particiones de tamaño variable");
        ArrayList<Integer> cantidadParticiones = new ArrayList<>();
        cantidadParticiones.add(2); // Dos particiones de 16
        cantidadParticiones.add(1); // Una partición de 32
        cantidadParticiones.add(1); // Una partición de 64
        ManejoParticiones manejoVariable = new ManejoParticiones(200, cantidadParticiones);
        System.out.println(manejoVariable.listarParticiones());

        // Caso 3: Intentar cargar particiones con memoria insuficiente
        System.out.println("Caso 3: Memoria insuficiente");
//        try {
//            cantidadParticiones.clear();
//            cantidadParticiones.add(10); // Diez particiones de 16 (160)
//            cantidadParticiones.add(3);  // Tres particiones de 32 (96)
//            ManejoParticiones manejoError = new ManejoParticiones(200, cantidadParticiones);
//            System.out.println(manejoError.listarParticiones());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Error esperado: " + e.getMessage());
//        }
    }
}
