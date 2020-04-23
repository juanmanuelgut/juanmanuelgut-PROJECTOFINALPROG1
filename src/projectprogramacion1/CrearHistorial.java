/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tati
 */
public class CrearHistorial {

    final static String path = System.getProperty("user.dir");
    final static String nombre_archivo = "\\historial.txt";

    public CrearHistorial() {
        crearArchivo();
    }

    public void crearArchivo() {

        File archivo = new File(path + nombre_archivo);
        BufferedWriter bw;

        if (!archivo.exists()) {
            try {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("*****Historial de personas que jugaron*****" + "\n\n");
                bw.close();
                System.out.println("Archivo creado con exito");
            } catch (IOException e) {
            }
        }

    }

    public void escribirHistorial(String nombre) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/M/yyyy HH:mm:ss");
        Date date = new Date();
        try {
            FileWriter archivo = new FileWriter(path + nombre_archivo, true);
            try (BufferedWriter bw = new BufferedWriter(archivo)) {
                bw.write(nombre + " " + formatter.format(date));
                bw.newLine();
            } catch (IOException e) {
            }
        } catch (IOException e) {
        }
    }

    public String leer() {
        String texto = "";
        try {
            FileReader reader = new FileReader(path + nombre_archivo);
            BufferedReader br = new BufferedReader(reader);

            String line;

            while ((line = br.readLine()) != null) {
                texto += line + "\n";
            }
        } catch (IOException e) {
        }
        return texto;
    }

}
