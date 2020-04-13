/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.swing.*;

public class VistaCampoJuego {

    public void vistaCampoJuego(int dimX, int dimY, int numMinas) {

        JFrame f = new JFrame();
        CampoDeJuego campo = new CampoDeJuego(dimX, dimY, numMinas);
        int dimensionX = dimX;
        int dimensionY = dimY;
        int numeroMinas = numMinas;
        int frameWidth = 500;
        int frameHeight = 500;
        int buttonWidth;
        int buttonHeigth;
        ArrayList<BotonMina> listaBotones = new ArrayList<BotonMina>();
        

        buttonWidth = frameWidth / dimensionX;
        buttonHeigth = (frameHeight - 10) / dimensionX;

        for (int j = 0; j < dimensionY; j++) {
            for (int i = 0; i < dimensionX; i++) {

                int coordenadaY = dimensionY - j;
                int coordenadaX = i;
                BotonMina b;//creating instance of JButton
                b = new BotonMina(coordenadaX, coordenadaY);
                int[] coordenadasBoton = {coordenadaX , coordenadaY};
                int xAxis;
                int yAxis;
                xAxis = 0 + (i * buttonWidth);
                yAxis = 0 + (j * buttonHeigth);
                b.setBounds(xAxis, yAxis, buttonWidth, buttonHeigth);//x axis, y axis, width, height  
                f.add(b);//adding button in JFrame
                listaBotones.add(b);
                
                for (Mina minas : campo.getMinas()){
                    
                    int[] coordenadasMina = minas.traerCoordenadasMina();
                    
                    if(Arrays.equals(coordenadasMina, coordenadasBoton)) {
                        b.setEsMina(Boolean.TRUE);
                        break;
                    }
                    
                }

                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                       
                        switch(e.getModifiers()){
                        
                            case 17:
                            
                                b.setText("$");
                                break;
                                
                            default:
                                if(b.getEsMina()){
                                    
                                    b.setText("*");
                                    b.setStatus("Detonada");
                                    //b.setBackground(Color.red);
                                    //b.setOpaque(true);
                                    JOptionPane.showMessageDialog(null, "Perdiste!!!");
                                    break;
                                    
                                }
                                else if(b.getEsJugador()){
                                
                                    JOptionPane.showMessageDialog(null, "Seleccione otra Celda");
                                
                                }
                                else if(b.getEsMeta()){
                                    
                                    b.setText("<>");
                                    JOptionPane.showMessageDialog(null, "Ganador!!!!");
                                
                                }
                                else{
                                
                                    b.setEsJugador(Boolean.TRUE);
                                    //b.setBackground(Color.green);
                                    //b.setOpaque(true);
                                    b.setText("J");
                                    
                                }
                                
                         
                        }

                    }
                });       
            }
        }
        
        /*for (Iterator<BotonMina> it = listaBotones.iterator(); it.hasNext();) {
            BotonMina = it.next();
        }*/
        
        
        f.setSize(frameWidth, frameHeight);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    

}
