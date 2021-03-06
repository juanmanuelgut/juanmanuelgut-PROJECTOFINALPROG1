package projectprogramacion1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.*;
import net.miginfocom.layout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tati
 */
public class VistaNuevaJuego {

    public static int Vidas = 3;
    public static int minasPisadas = 0;
    final static String path = System.getProperty("user.dir");
    final static String nombre_archivo = "\\img\\reset.png";
    public static void iniciar(int dimX, int dimY, int numMinas) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        CampoDeJuego campo = new CampoDeJuego(dimX, dimY, numMinas);
        int dimensionX = dimX;
        int dimensionY = dimY;
        int numeroMinas = numMinas;

        int buttonWidth;
        int buttonHeigth;
        ArrayList<BotonMina> listaBotones = new ArrayList<BotonMina>();

        /*buttonWidth = frameWidth / dimensionX;
        buttonHeigth = (frameHeight - 10) / dimensionX;*/
        buttonWidth = screenWidth / dimensionX;
        buttonHeigth = (screenHeight - 10) / dimensionX;

        JFrame ventana = new JFrame("Busca Minas");
        JLabel lbl_cantVidasTitulo = new JLabel("Cantidad de vidas restantes: ");
        JLabel lbl_cantVidas = new JLabel(Integer.toString(Vidas));
        JLabel lbl_cantMinasPisadasTitulo = new JLabel("Cantidad de minas pisadas");
        JLabel lbl_cantMinasPisadas = new JLabel(Integer.toString(minasPisadas));
        JButton btn_reiniciar = new JButton("Reiniciar juego");
        JPanel mainPanel = new JPanel(new MigLayout("fillx"));
        JPanel pnl_btn = new JPanel(new MigLayout("fillx"));
        JPanel pnl_info = new JPanel(new MigLayout("fillx"));
        JTextArea historial = new JTextArea(50, 50);
        JScrollPane scroll = new JScrollPane(historial);
        CrearHistorial historialTexto = new CrearHistorial();

        lbl_cantMinasPisadasTitulo.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        lbl_cantVidasTitulo.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        lbl_cantMinasPisadas.setFont(new Font("TimesRoman", Font.BOLD, 25));

        lbl_cantVidas.setForeground(Color.red);
        lbl_cantVidas.setFont(new Font("TimesRoman", Font.BOLD, 25));

        btn_reiniciar.setFont(new Font("SerTimesRomanif", Font.PLAIN, 25));

        //        Icono para el boton de reiniciar
        ImageIcon iconoReset = new ImageIcon(path + nombre_archivo);
        btn_reiniciar.setIcon(iconoReset);

        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        historial.setEditable(false);
        historial.append(historialTexto.leer());

        for (int j = 0; j < dimensionY; j++) {
            for (int i = 0; i < dimensionX; i++) {

                int coordenadaY = (dimensionY - 1) - j;
                //Descomentar siguiente linea para deguguear
                //System.out.println("DEBUG: COORDENADAS " + coordenadaY);
                int coordenadaX = i;
                BotonMina b;//creating instance of JButton
                b = new BotonMina(coordenadaX, coordenadaY);
                int[] coordenadasBoton = {coordenadaX, coordenadaY};
                int xAxis;
                int yAxis;
                xAxis = 0 + (i * buttonWidth);
                yAxis = 100 + (j * buttonHeigth);
                b.setBounds(xAxis, yAxis, buttonWidth, buttonHeigth);//x axis, y axis, width, height  
                pnl_btn.add(b, "");//adding button in JFrame
                listaBotones.add(b);
                //Descomentar siguiente linea para deguguear
                //System.out.println("DEBUG: Coordenadas Boton [" + Integer.toString(b.getCoordenadaBotonX()) + " , " + Integer.toString(b.getCoordenadaBotonY()) + "]");

                for (Mina minas : campo.getMinas()) {

                    int[] coordenadasMina = minas.traerCoordenadasMina();

                    if (Arrays.equals(coordenadasMina, coordenadasBoton)) {
                        b.setEsMina(Boolean.TRUE);
                        //Descomentar siguiente linea para deguguear
                        //System.out.println("DEBUG: Coordenadas Mina" + Arrays.toString(coordenadasMina));
                        break;
                    }

                }

                b.addActionListener((e) -> {
                    if (Vidas == 0) {
                        if (perdido() == JOptionPane.YES_OPTION) {
                            ventana.dispose();
                            Vidas = 3;
                            Vista_Config_Juego.config();
                        } else {
                            System.exit(0);
                        }
                    }
                });

               

                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        switch (e.getModifiers()) {

                            case 17:

                                b.setText("$");
                                b.setBackground(Color.blue);
                                b.setOpaque(true);
                                break;

                            default:
                                if (b.getEsMina()) {

                                    b.setText("*");
                                    b.setStatus("Detonada");
                                    b.setBackground(Color.red);
                                    b.setOpaque(true);
                                    JOptionPane.showMessageDialog(null, "Perdiste!!!");
                                    minasPisadas++;
                                    Vidas = Vidas - 1;
                                    lbl_cantMinasPisadas.setText(Integer.toString(minasPisadas));
                                    lbl_cantVidas.setText(Integer.toString(Vidas));
                                    break;

                                } else if (b.getEsJugador()) {

                                    JOptionPane.showMessageDialog(null, "Seleccione otra Celda");

                                } else if (b.getEsMeta()) {

                                    b.setText("<>");
                                    JOptionPane.showMessageDialog(null, "Ganador!!!!");

                                } else {

                                    b.setEsJugador(Boolean.TRUE);
                                    b.setBackground(Color.green);
                                    b.setOpaque(true);
                                    b.setText("J");

                                }
                        }

                    }
                });
            }
        }

        btn_reiniciar.addActionListener((e) -> {
            //Descomentar siguiente linea para deguguear
            //int test = e.getID();
            //System.out.println(test);

                    Vista_Config_Juego.config();
                    ventana.dispose();
                    Vidas = 3;
//                  Aquí está el error
        });
        
        /*for (int i = 0; i < 50; i++) {
            JButton b;
            b = new JButton("" + i);
            pnl_btn.add(b, "");
        }*/
        pnl_btn.setLayout(new GridLayout(dimX, dimY));
        pnl_btn.setSize(200, 500);

        mainPanel.add(pnl_btn, "west, w 80%, h 100%");
        mainPanel.add(pnl_info, "east, w 80%, h 100%");

        ventana.add(mainPanel);

        pnl_info.add(lbl_cantVidasTitulo, "align center");
        pnl_info.add(lbl_cantVidas, "wrap");
        pnl_info.add(lbl_cantMinasPisadasTitulo, "align center");
        pnl_info.add(lbl_cantMinasPisadas, "wrap");
        pnl_info.add(btn_reiniciar, "align center, span 2, wrap");
        pnl_info.add(scroll, "align center");

        ventana.setVisible(true);
        ventana.setSize(screenWidth, screenHeight);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

    }

    public static int perdido() {
        Object[] opciones = {
            "OK",
            "SALIR DEL JUEGO"
        };

        int respuesta = JOptionPane.showOptionDialog(
                null,
                "Oooops, has perdido todas tus vidas, debes de reiniciar el juego",
                "Buscaminas",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);
        return respuesta;
    }
}
