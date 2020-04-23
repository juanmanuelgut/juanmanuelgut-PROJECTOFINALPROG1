/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;
/**
 *
 * @author tati
 */
public class Vista_Config_Juego {
    
   
    public static void config() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        VistaNuevaJuego juego = new VistaNuevaJuego();
        int screenWidth = (int) (screenSize.width) / 3;
        int screenHeight = screenSize.height / 3;
        JFrame ventana = new JFrame("Configuracion de juego");
        JPanel panel = new JPanel(new MigLayout("fillx"));
        JLabel nombre_usuario = new JLabel("Nombre de Usuario");
        JTextField txt_NombreUsuario = new JTextField();
        JTextField txt_DimensionX = new JTextField();
        JTextField txt_DimensionY = new JTextField();
        JTextField txt_cantMinas = new JTextField();
        JLabel DimensionX = new JLabel("Dimension en X");
        JLabel DimensionY = new JLabel("Dimension en Y");
        JLabel cant_minas = new JLabel("Digite la cantidad de minas que desea");
        JButton btn_iniciar = new JButton("Iniciar");

        ventana.add(panel);
        panel.add(nombre_usuario, "align center, wrap");
        panel.add(txt_NombreUsuario, "align center, wrap, w 50%");
        panel.add(DimensionX, "align center, wrap");
        panel.add(txt_DimensionX, "align center, wrap, w 50%");
        panel.add(DimensionY, "align center, wrap");
        panel.add(txt_DimensionY, "align center, wrap, w 50%");
        panel.add(cant_minas, "align center, wrap");
        panel.add(txt_cantMinas, "align center, wrap, w 50%");
        panel.add(btn_iniciar, "align center");

        btn_iniciar.addActionListener((e) -> {
            String nombre_Usuario = "";
            int dimX = 0;
            int dimY = 0;
            int cantMinas = 0;
            nombre_Usuario = txt_NombreUsuario.getText();
            dimX = Integer.parseInt(txt_DimensionX.getText());
            dimY = Integer.parseInt(txt_DimensionY.getText());
            cantMinas = Integer.parseInt(txt_cantMinas.getText());

            CrearHistorial historial = new CrearHistorial();
            historial.escribirHistorial(nombre_Usuario);
            
            juego.iniciar(dimX, dimY, cantMinas);

            ventana.dispose();
        });

        ventana.setVisible(true);
        ventana.setSize(screenWidth, screenHeight);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
    }
}
