/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author jeank
 */
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Pagina {

    private int idPagina;
    private int desplazamiento;
    private boolean bitValidez;
    private String nombreArchivo;

    public Pagina(int idPagina, int desplazamiento, String nombreArchivo) {
        this.idPagina = idPagina;
        this.desplazamiento = desplazamiento;
        this.bitValidez = false;
        this.nombreArchivo = nombreArchivo;
    }

    public void escribirEnArchivo(String contenido) {
        try (FileWriter writer = new FileWriter("C:\\memoriavirtual\\" + nombreArchivo + ".txt")) {
            writer.write(contenido);
            System.out.println("Archivo creado: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en archivo: " + e.getMessage());
        }
    }

    public String leerDesdeArchivo() {
        String path = "C:\\memoriavirtual\\" + nombreArchivo + ".txt";
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
            return "";
        }
    }

    public int getIdPagina() {
        return idPagina;
    }

    public boolean isBitValidez() {
        return bitValidez;
    }

    public void setBitValidez(boolean bitValidez) {
        this.bitValidez = bitValidez;
    }

    public String getNombreArchivo() {
        return nombreArchivo.endsWith(".txt") ? nombreArchivo : nombreArchivo + ".txt";
    }

    public int getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    @Override
    public String toString() {
        return "Pagina{" + "idPagina=" + idPagina + ", bitValidez=" + bitValidez + ", nombreArchivo=" + nombreArchivo + '}';
    }

    
}
