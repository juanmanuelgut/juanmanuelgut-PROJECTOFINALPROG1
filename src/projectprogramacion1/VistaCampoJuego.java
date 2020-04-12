/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VistaCampoJuego {

    public void vistaCampoJuego(int dimX, int dimY) {

        JFrame f = new JFrame();
        int dimensionX = dimX;
        int dimensionY = dimY;
        int frameWidth = 500;
        int frameHeight = 500;
        int buttonWidth;
        int buttonHeigth;

        buttonWidth = frameWidth / dimensionX;
        buttonHeigth = (frameHeight - 10) / dimensionX;

        for (int j = 0; j < dimensionY; j++) {
            for (int i = 0; i < dimensionX; i++) {

                int coordenadaY = dimensionY - j;
                int coordenadaX = i;
                BotonMina b;//creating instance of JButton
                b = new BotonMina(coordenadaX, coordenadaY);
                int xAxis;
                int yAxis;
                xAxis = 0 + (i * buttonWidth);
                yAxis = 0 + (j * buttonHeigth);
                b.setBounds(xAxis, yAxis, buttonWidth, buttonHeigth);//x axis, y axis, width, height  
                f.add(b);//adding button in JFrame 

                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                        switch(e.getModifiers()){
                        
                            case 17:
                            
                                b.setText("$");
                                break;
                                
                            default:
                                if(b.getEsMina()){
                                    
                                    b.setText("*");
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
                                    b.setText("J");
                                    
                                }
                                
                         
                        }

                    }
                });

            }
        }

        f.setSize(frameWidth, frameHeight);//400 width and 500 height  
        f.setLayout(null);//using no layout managers  
        f.setVisible(true);//making the frame visible  

    }

}