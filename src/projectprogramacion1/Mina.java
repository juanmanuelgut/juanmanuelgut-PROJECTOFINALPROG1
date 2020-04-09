/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

/**
 *
 * @author juangutierrez
 */
public class Mina {
    
    private int coordenadaMinaX;
    private int coordenadaMinaY;
    private String estadoMina;
    
    public int getCoordenadaMinaX() {
        return coordenadaMinaX;
    }

    public int getCoordenadaMinaY() {
        return coordenadaMinaY;
    }

    public void setCoordenadaMinaX(int coordenadaMinaX) {
        this.coordenadaMinaX = coordenadaMinaX;
    }

    public void setCoordenadaMinaY(int coordenadaMinaY) {
        this.coordenadaMinaY = coordenadaMinaY;
    }

    public Mina() {
        this.estadoMina = "Activa";
    }
    
    
    
}
