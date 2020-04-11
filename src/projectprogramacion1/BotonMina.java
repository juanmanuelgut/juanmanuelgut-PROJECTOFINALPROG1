/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author juangutierrez
 */
public class BotonMina extends JButton{
    
    private String status;
    private int coordenadaBotonX;
    private int coordenadaBotonY;
    private String mascara;
    private Boolean esMina;
    private Boolean esMeta;
    private Boolean esJugador;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCoordenadaBotonX(int coordenadaBotonX) {
        this.coordenadaBotonX = coordenadaBotonX;
    }

    public void setCoordenadaBotonY(int coordenadaBotonY) {
        this.coordenadaBotonY = coordenadaBotonY;
    }

    public void setMascara(String mascara) {
        this.mascara = mascara;
    }

    public void setEsMina(Boolean esMina) {
        this.esMina = esMina;
    }

    public void setEsMeta(Boolean esMeta) {
        this.esMeta = esMeta;
    }

    public void setEsJugador(Boolean esJugador) {
        this.esJugador = esJugador;
    }

    public String getStatus() {
        return status;
    }

    public int getCoordenadaBotonX() {
        return coordenadaBotonX;
    }

    public int getCoordenadaBotonY() {
        return coordenadaBotonY;
    }

    public String getMascara() {
        return mascara;
    }

    public Boolean getEsMina() {
        return esMina;
    }

    public Boolean getEsMeta() {
        return esMeta;
    }

    public Boolean getEsJugador() {
        return esJugador;
    }

    public BotonMina(int coordenadaBotonX, int coordenadaBotonY) {
        this.coordenadaBotonX = coordenadaBotonX;
        this.coordenadaBotonY = coordenadaBotonY;
        this.esMina = false;
        this.esMeta = false;
        this.esJugador = false;
        this.status = "Listo";
        this.mascara = "";        
    }
    
}
