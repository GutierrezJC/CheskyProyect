/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.io.File;

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
    
    public static void generadoFile(){
         File directorio = new File("C:\\memoriavirtual");
        if (!directorio.exists()) {
            directorio.mkdir();
        }

    }
}