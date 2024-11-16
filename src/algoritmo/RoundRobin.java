/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmo;

/**
 *
 * @author jeank
 */
import interfaz.VentanaPrincipalPrincipal;
import Objetos.Proceso;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import javax.swing.SwingWorker;
import javax.swing.SwingUtilities;

public class RoundRobin {
    private int quantum;
    private VentanaPrincipalPrincipal ventana; // Referencia a la ventana principal para actualizar la GUI

    public RoundRobin(int quantum, VentanaPrincipalPrincipal ventana) {
        this.quantum = quantum;
        this.ventana = ventana; // Guardamos la referencia a la ventana
    }

    public void ejecutar(List<Proceso> procesos) {
        new ejecutarRoundR(procesos).execute();
    }

    private class ejecutarRoundR extends SwingWorker<Void, Proceso> {
        private List<Proceso> procesos;
        private Queue<Proceso> cola;

        public ejecutarRoundR(List<Proceso> procesos) {
            this.procesos = procesos;
            this.cola = new LinkedList<>(procesos);
        }

        @Override
        protected Void doInBackground() throws Exception {
            while (!cola.isEmpty()) {
                Proceso proceso = cola.poll();

                if (proceso.getTiempoRestante() > quantum) {
                    proceso.setTiempoRestante(proceso.getTiempoRestante() - quantum);
                    publish(proceso);

                    try {
                        Thread.sleep(2000);  // Simula que el proceso está corriendo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    cola.offer(proceso); // Volver a la cola si no ha terminado
                } else {
                    publish(proceso);
                    proceso.setTiempoRestante(0); // Proceso terminado
//                    System.out.println(proceso.getIdProceso() + " ha terminado.");

                    try {
                        Thread.sleep(2000);  // Simula que el proceso está corriendo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void process(List<Proceso> chunks) {
            for (Proceso proceso : chunks) {
                // Aquí, actualiza los componentes de tu GUI con la información del proceso
                actualizarGrafica(proceso);
            }
        }
    }

    private void actualizarGrafica(Proceso proceso) {
        SwingUtilities.invokeLater(() -> {
            ventana.actualizarBarraDeProgreso(proceso);
        });
    }
}
