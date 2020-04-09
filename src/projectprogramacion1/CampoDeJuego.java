/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

import java.util.*;

/**
 *
 * @author juangutierrez
 */
public class CampoDeJuego {
    
    private String forma;
    private int dimensionX;
    private int dimensionY;
    private int numeroMinas;
    private ArrayList<Mina> minas = new ArrayList<Mina>();
    private Jugador player1 = new Jugador();
    private Meta meta = new Meta();

    public void setDimensionX(int dimensionX) {
        this.dimensionX = dimensionX;
    }

    public void setDimensionY(int dimensionY) {
        this.dimensionY = dimensionY;
    }

    public void setNumeroMinas(int numeroMinas) {
        this.numeroMinas = numeroMinas;
    }

    public void setPlayer1(Jugador player1) {
        this.player1 = player1;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    public int getNumeroMinas() {
        return numeroMinas;
    }

    public ArrayList<Mina> getMinas() {
        return minas;
    }

    public Jugador getPlayer1() {
        return player1;
    }

    public Meta getMeta() {
        return meta;
    }
    
    
  
    @SuppressWarnings("empty-statement")
    
    private static Boolean verificarCoordenadasRepetidas(int[] coordenadasMina, ArrayList<int[]> listaCoordenadas){
        
        Boolean result = null;
        
        for (int[] index:listaCoordenadas){
                
            
            if (listaCoordenadas.isEmpty()) {
                
                result = false;
                       
            }
            else if (index == coordenadasMina){
                    
                result = true; 
                    
                }
                
            else {
            
                result = false;
                
            }
                
        }
        
        return result;
        
      }
    
    
    public static ArrayList<Mina> generarListaMinas(int numMinas, int dimensionX, int dimensionY){
        
        ArrayList<Mina> listaMinas = new ArrayList<Mina>();
        ArrayList<int[]> listaCoordenadas = new ArrayList<int[]>();
        
        for (int i = 0; i < numMinas; i++){
            
            Mina mina = new Mina();
            Random r = new Random();
                        
            do {
            
            int x = r.nextInt(dimensionX - 1);
            int y = r.nextInt(dimensionY - 1);
            mina.setCoordenadaMinaX(x);
            mina.setCoordenadaMinaY(y);
            
            }
            
            while(verificarCoordenadasRepetidas(mina.traerCoordenadasMina(),listaCoordenadas));
            
            listaCoordenadas.add(mina.traerCoordenadasMina());          
            listaMinas.add(mina);
            
        }
        
        
        return listaMinas;
        
    }

    public CampoDeJuego(int dimensionX, int dimensionY, int numeroMinas) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.numeroMinas = numeroMinas;
        this.minas = generarListaMinas(numeroMinas, dimensionX, dimensionY);
        this.player1 = new Jugador();
        this.meta = new Meta();
    }
    
    
    
    
    
}
