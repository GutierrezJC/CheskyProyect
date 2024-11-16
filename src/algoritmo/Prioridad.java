package algoritmo;

import AlgoritmosRemplazo.FIFO;
import AlgoritmosRemplazo.LRU;
import AlgoritmosRemplazo.OPT;
import Objetos.Pagina;
import interfaz.VentanaPrincipalPrincipal;
import Objetos.Proceso;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.SwingUtilities;

public class Prioridad {

    private int tiempoActual = 0;
    private VentanaPrincipalPrincipal ventana;
    public boolean paginacionXsegmentacion;
    public int idalgoritmosRemplazo;

    public Prioridad(VentanaPrincipalPrincipal ventana) {
        this.ventana = ventana;
    }

    public void ejecutar(List<Proceso> procesos) {
        new ejecutarAPrioridad(procesos).execute();
    }

    private class ejecutarAPrioridad extends SwingWorker<Void, Proceso> {

        private List<Proceso> procesosOrdenados;

        public ejecutarAPrioridad(List<Proceso> procesos) {
            procesosOrdenados = new ArrayList<>(procesos);
            Collections.sort(procesosOrdenados, (p1, p2) -> Integer.compare(p1.getPrioridad(), p2.getPrioridad()));
        }

        @Override
        protected Void doInBackground() throws Exception {
            for (Proceso proceso : procesosOrdenados) {
                correrTimempo(proceso);
                cronometrarProceso(proceso);

                FIFO fifo = new FIFO(proceso.getTablaPaginas().getMaxMarcos(), proceso.getTablaPaginas());
                LRU lru = new LRU(5, proceso.getTablaPaginas());
                ArrayList<Integer> futurasReferencias = obtenerFuturasReferencias(proceso);
                OPT opt = new OPT(5, proceso.getTablaPaginas(), futurasReferencias);
                int rafaga = proceso.getTiempoRafaga();
                
                if (paginacionXsegmentacion & idalgoritmosRemplazo == 1) {

                    for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) { // su arrayList De paginas que esta en su tabla 
                        fifo.accederPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());

                    }
                    while (rafaga > 0) {

                        rafaga = cpu(rafaga, proceso);

                        publish(proceso);
                    }

                }
                if (paginacionXsegmentacion & idalgoritmosRemplazo == 2) {
                    for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
                        lru.referenciarPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
                    }

                    while (rafaga > 0) {

                        rafaga = cpu(rafaga, proceso);

                        publish(proceso);
                    }

                }
                if (paginacionXsegmentacion & idalgoritmosRemplazo == 3) {
                    for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
                        opt.referenciarPagina(pagina, "C:\\memoriavirtual\\" + pagina.getNombreArchivo());
                    }

                    while (rafaga > 0) {

                        rafaga = cpu(rafaga, proceso);

                        publish(proceso);
                    }

                }

                proceso.setTiempoRestante(0);
//                System.out.println(proceso.getIdProceso() + " ha terminado.");

            }
            return null;
        }

        @Override
        protected void process(List<Proceso> chunks) {
            for (Proceso proceso : chunks) {
                actualizarGrafica(proceso);
            }
        }
    }

    private void correrTimempo(Proceso proceso) {
        if (tiempoActual < proceso.getTiempoLlegada()) {
            tiempoActual = proceso.getTiempoLlegada();
        }
    }

    public int cpu(int rafaga, Proceso proceso) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
        }
        rafaga--;
        proceso.setTiempoRestante(rafaga);
        return rafaga;
    }

    public void cronometrarProceso(Proceso proceso) {
        proceso.setTiempoInicio(tiempoActual);
        proceso.setTiempoFinalizacion(tiempoActual + proceso.getTiempoRafaga());
        tiempoActual += proceso.getTiempoRafaga();

    }

    public ArrayList<Integer> obtenerFuturasReferencias(Proceso proceso) {
        ArrayList<Integer> futurasReferencias = new ArrayList<>();

        for (Pagina pagina : proceso.getTablaPaginas().getPaginas()) {
            futurasReferencias.add(pagina.getIdPagina());
        }

        return futurasReferencias;
    }

    private void actualizarGrafica(Proceso proceso) {
        SwingUtilities.invokeLater(() -> {
            ventana.actualizarBarraDeProgreso(proceso);
        });
    }

    public int getTiempoActual() {
        return tiempoActual;
    }

    public void setTiempoActual(int tiempoActual) {
        this.tiempoActual = tiempoActual;
    }

    public boolean isPaginacionXsegmentacion() {
        return paginacionXsegmentacion;
    }

    public void setPaginacionXsegmentacion(boolean paginacionXsegmentacion) {
        this.paginacionXsegmentacion = paginacionXsegmentacion;
    }

    public int getIdalgoritmosRemplazo() {
        return idalgoritmosRemplazo;
    }

    public void setIdalgoritmosRemplazo(int idalgoritmosRemplazo) {
        this.idalgoritmosRemplazo = idalgoritmosRemplazo;
    }
}
