/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;



import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneradorPaginas {

    private List<String> rutasGeneradas = new ArrayList<>();

    public void generarPaginas(int numPaginas, int idProceso) {
        String directorioBase = "C:\\memoriavirtual\\";
        
        for (int i = 1; i <= numPaginas; i++) {
            String nombreArchivo = String.format("P%d_Pagina%d.txt", idProceso, i);
            String rutaCompleta = directorioBase + nombreArchivo;

            if (archivoYaGenerado(rutaCompleta)) {
                System.out.println("El archivo " + nombreArchivo + " ya existe, omitiendo creación.");
                continue;
            }

            String contenido = generarContenido(nombreArchivo);
            crearArchivo(rutaCompleta, contenido);
        }
    }

// Verifica si la ruta ya fue generada
    private boolean archivoYaGenerado(String rutaCompleta) {
        if (rutasGeneradas.contains(rutaCompleta)) {
            return true;
        }
        rutasGeneradas.add(rutaCompleta);
        return false;
    }

// Genera el contenido de la página
    private String generarContenido(String nombreArchivo) {
        int numLineas = (int) Math.pow(2, (int) (Math.random() * 3) + 2);  // 4, 8 o 16 líneas
        StringBuilder contenido = new StringBuilder();
        for (int j = 1; j <= numLineas; j++) {
            contenido.append("Linea ").append(j).append(" ").append(nombreArchivo).append("\n");
        }
        return contenido.toString();
    }

// Crea el archivo en la ruta especificada con el contenido
    private void crearArchivo(String rutaCompleta, String contenido) {
        try (FileWriter writer = new FileWriter(rutaCompleta)) {
            writer.write(contenido);
            System.out.println("Archivo creado: " + rutaCompleta);
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public List<String> getRutasGeneradas() {
        return rutasGeneradas;
    }
}
