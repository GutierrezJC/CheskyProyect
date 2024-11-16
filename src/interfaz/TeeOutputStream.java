/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import java.io.OutputStream;
import java.io.IOException;

public class TeeOutputStream extends OutputStream {
    private final OutputStream consoleOutputStream;
    private final OutputStream fileOutputStream;

    public TeeOutputStream(OutputStream consoleOutputStream, OutputStream fileOutputStream) {
        this.consoleOutputStream = consoleOutputStream;
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void write(int b) throws IOException {
        consoleOutputStream.write(b);
        fileOutputStream.write(b);
    }

    @Override
    public void flush() throws IOException {
        consoleOutputStream.flush();
        fileOutputStream.flush();
    }

    @Override
    public void close() throws IOException {
        consoleOutputStream.close();
        fileOutputStream.close();
    }
}
