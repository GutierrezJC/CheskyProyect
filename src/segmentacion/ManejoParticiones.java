/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package segmentacion;

import java.util.ArrayList;


public class ManejoParticiones {

    private ArrayList<Particion> listaParticiones;
    private String nombreLP;

    public ManejoParticiones() {
        this.listaParticiones = new ArrayList<>();
        this.nombreLP = "general";
    }

    public ManejoParticiones(int cantidadMemoriaTotal, int tamañoParticiones) {
        this();
        this.cargarParticionesTamañoFijo(cantidadMemoriaTotal, tamañoParticiones);
    }


    public void cargarParticionesTamañoFijo(int cantidadMemoriaTotal, int tamañoParticiones) {
        int inicioP = 0;
        int finalP = tamañoParticiones;

        while (inicioP < cantidadMemoriaTotal) {
            if (finalP > cantidadMemoriaTotal) {
                finalP = cantidadMemoriaTotal; // Asegurar que la última partición no exceda el total
            }
            listaParticiones.add(new Particion(inicioP, finalP, finalP - inicioP));
            inicioP = finalP;
            finalP += tamañoParticiones;
        }
    }

    public ManejoParticiones(int memoriaTotal, ArrayList<Integer> cantidadParticiones) {
        this();
        if (!puedeCargarParticiones(memoriaTotal, cantidadParticiones)) {
            throw new IllegalArgumentException("El espacio necesario excede el tamaño total de la memoria.");
        }
        this.cargarParticionesTamañoVariable(memoriaTotal, cantidadParticiones);
    }

    public boolean puedeCargarParticiones(int memoriaTotal, ArrayList<Integer> cantidadParticiones) {
        int[] tamañosParticiones = {16, 32, 64, 128, 256, 512};
        int espacioNecesario = 0;

        for (int i = 0; i < cantidadParticiones.size() && i < tamañosParticiones.length; i++) {
            espacioNecesario += cantidadParticiones.get(i) * tamañosParticiones[i];
        }

        return espacioNecesario <= memoriaTotal;
    }

    public void cargarParticionesTamañoVariable(int memoriaTotal, ArrayList<Integer> cantidadParticiones) {
        int inicioP = 0;
        int[] tamañosParticiones = {16, 32, 64, 128, 256, 512};
        int finalP = 0;

        for (int i = 0; i < cantidadParticiones.size() && i < tamañosParticiones.length; i++) {
            int tamañoP = tamañosParticiones[i];
            for (int j = 0; j < cantidadParticiones.get(i); j++) {
                finalP = inicioP + tamañoP;

                if (finalP > memoriaTotal) {
                    throw new IllegalArgumentException("No hay suficiente memoria para completar las particiones.");
                }

                listaParticiones.add(new Particion(inicioP, finalP, tamañoP));
                inicioP = finalP;
            }
        }
    }

    public String listarParticiones() {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < listaParticiones.size(); i++) {
            salida.append(i).append(" ");
            salida.append(listaParticiones.get(i).detallesParticion()).append("\n");
        }
        return salida.toString();
    }

    // Getters y Setters
    public ArrayList<Particion> getListaParticiones() {
        return listaParticiones;
    }

    public void setListaParticiones(ArrayList<Particion> listaParticiones) {
        this.listaParticiones = listaParticiones;
    }

    public String getNombreLP() {
        return nombreLP;
    }

    public void setNombreLP(String nombreLP) {
        this.nombreLP = nombreLP;
    }
}
