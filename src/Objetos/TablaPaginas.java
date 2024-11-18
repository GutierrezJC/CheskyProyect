/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TablaPaginas {

    private int idTabla;
    private ArrayList<Pagina> paginas;
    private ArrayList<Marco> marcos;
    private int maxPaginas;
    private int maxMarcos;
    private int fifoIndex = 0; // Índice para el reemplazo FIFO

    public TablaPaginas(int idTabla, int maxPaginas, int maxMarcos) {
        this.idTabla = idTabla;
        this.maxPaginas = maxPaginas;
        this.maxMarcos = maxMarcos;
        this.paginas = new ArrayList<>();
        this.marcos = new ArrayList<>();

        this.marcos = new ArrayList<>();

        llenarMarcos();

    }

    public void llenarMarcos() {
        for (int i = 1; i < maxMarcos + 1; i++) {
            //Marco(int idMarco, int idPagina, int desplazamiento)
            marcos.add(new Marco(i, i, 5));
        }
    }

    public void agregarPagina(Pagina nuevaPagina) {
        if (paginas.size() >= maxPaginas) {
            System.out.println("Se ha alcanzado el máximo de páginas.");
            return;
        }
        paginas.add(nuevaPagina);
    }

    public boolean accederPagina(int idPagina, String nombreArchivo) {
        String rutaCompleta = "C:\\memoriavirtual\\" + nombreArchivo;
        
        for (Marco marco : marcos) {
            if (marco != null && marco.getIdPagina() == idPagina) {
               
                System.out.println("Página " + idPagina + " ya está en memoria.");

                return true;
            }
        }
        return false;
    }


    public void asignarMarco(Integer idPagina, int desplazamiento) {
        int idMarco = -1;
        for (int i = 0; i < marcos.size(); i++) {
            if (marcos.get(i) == null) {
                idMarco = i;
                break;
            }
        }

        if (idMarco < 0 || idMarco > marcos.size()) {
            System.out.println("Error: Índice fuera de rango en asignación de marco."+idMarco);
            return;
        }

        if (desplazamiento == -1) { // Indicador para liberar el marco
            marcos.set(idMarco, null); // Libera el marco
            System.out.println("Liberado Marco " + idMarco);
        } else {
            Marco nuevoMarco = new Marco(idMarco, idPagina, desplazamiento);
            marcos.set(idMarco, nuevoMarco);
            System.out.println("Asignado Marco " + idMarco + " a Página ID " + idPagina);
        }
    }

    public void cargarPagina(int idPagina, String rutaCompleta) {
        try {
            Path path = Paths.get(rutaCompleta);
            if (Files.exists(path)) {
                Files.readAllBytes(path);
                System.out.println("Página " + idPagina + " cargada desde disco: " + rutaCompleta);
            } else {
                System.out.println("Archivo no encontrado en la ruta: " + rutaCompleta);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar la página desde disco: " + e.getMessage());
        }
    }

    public void eliminarPagina(int idPagina) {
        for (int i = 0; i < marcos.size(); i++) {
            Marco marco = marcos.get(i);
            if (marco != null && marco.getIdPagina() == idPagina) {
                marcos.set(i, null); // Elimina la página de la memoria
                System.out.println("Página " + idPagina + " eliminada de la memoria.");
                return;
            }
        }
        System.out.println("Página " + idPagina + " no se encontró en la memoria.");
    }

    public ArrayList<Pagina> getPaginas() {
        return paginas;
    }

    public void imprimirEstadoMemoria() {
        System.out.println("Estado actual de los marcos en memoria:");
        for (int i = 0; i < marcos.size(); i++) {
            Marco marco = marcos.get(i);

            if (marco != null) {
                System.out.println("Marco " + i + ": Página ID " + marco.getIdPagina() + ", Desplazamiento " + marco.getDesplazamiento());
            } else {
                System.out.println("Marco " + i + ": vacío");
            }

        }
    }

    public void guardarPaginaEnDisco(int idPagina, String contenido) {
        String path = "C:\\memoriavirtual\\pagina" + idPagina + ".txt";
        try {
            // Verificación adicional del contenido
            if (contenido == null || contenido.isEmpty()) {
                contenido = "Contenido predeterminado de la página " + idPagina;
            }

            // Escritura en el archivo
            Files.write(Paths.get(path), contenido.getBytes());
            System.out.println("Página " + idPagina + " guardada en disco en: " + path);
        } catch (IOException e) {
            System.out.println("Error al guardar la página en disco: " + e.getMessage());
        }
    }

    public int getMaxMarcos() {
        return maxMarcos;
    }

    public void setMaxMarcos(int maxMarcos) {
        this.maxMarcos = maxMarcos;
    }

}
