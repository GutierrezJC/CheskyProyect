/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgortitmosSegmentacion;

import Objetos.Proceso;
import java.util.ArrayList;
import segmentacion.Particion;

public class MejorAjuste {

    public boolean asignar(Proceso proceso, ArrayList<Particion> particiones) {
        int tamañoRestante = proceso.getTamañoEnBytes();
        Particion mejorParticion = null;
        for (Particion particion : particiones) {
            if (particion.getEstadoP() == 'L' && particion.getnUnidades() >= tamañoRestante) {
                if (mejorParticion == null || particion.getnUnidades() < mejorParticion.getnUnidades()) {
                    mejorParticion = particion;
                }
            }
        }
        if (mejorParticion != null) {
            mejorParticion.setNombreProceso(proceso.getNombre());
            mejorParticion.setEstadoP('O');
            mejorParticion.setUTiempo(proceso.getTiempoRafaga());
            return true; // Proceso asignado
        }
        return false; // No se encontró una partición adecuada
    }

    public void desasignar(Proceso proceso, ArrayList<Particion> particiones) {
        for (Particion particion : particiones) {
            if (proceso.getNombre().equals(particion.getNombreProceso())) {
                particion.setEstadoP('L');
                particion.setNombreProceso("SN");
            }
        }
    }
}
