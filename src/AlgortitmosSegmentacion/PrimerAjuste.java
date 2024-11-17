/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AlgortitmosSegmentacion;

import Objetos.Proceso;
import java.util.ArrayList;
import segmentacion.Particion;

public class PrimerAjuste {

    public boolean asignar(Proceso proceso, ArrayList<Particion> particiones) {
        int tamañoRestante = proceso.getTamañoEnBytes();
        for (Particion particion : particiones) {
            if (particion.getEstadoP() == 'L' && particion.getnUnidades() >= tamañoRestante) {
                particion.setNombreProceso(proceso.getNombre());
                particion.setEstadoP('O');
                particion.setUTiempo(proceso.getTiempoRafaga());
                return true; // Proceso asignado completamente
            }
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

