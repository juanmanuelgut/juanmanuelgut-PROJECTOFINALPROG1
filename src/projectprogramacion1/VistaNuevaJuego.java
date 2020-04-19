
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
    public static void iniciar(int dimX, int dimY) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int) (screenSize.width / 2);
        int screenHeight = screenSize.height / 2;
        
    
        JFrame ventana = new JFrame("Busca Minas");
        JLabel lbl_cantVidasTitulo = new JLabel("Cantidad de vidas restantes: ");
        JLabel lbl_cantVidas = new JLabel("3");
        JLabel lbl_cantMinasPisadasTitulo = new JLabel("Cantidad de minas pisadas");
        JLabel lbl_cantMinasPisadas = new JLabel("4");
        JButton btn_reiniciar = new JButton("Reiniciar juego");
        JPanel mainPanel = new JPanel(new MigLayout("fillx"));
        JPanel pnl_btn = new JPanel(new MigLayout("fillx"));
        JPanel pnl_info = new JPanel(new MigLayout("fillx"));
        JTextArea historial = new JTextArea("Mi amor 18/4/2020 10:13:00pm\n" +
                                            "Mi amor 18/4/2020 10:20:00pm\n" +
                                            "Mi amor 18/4/2020 10:25:00pm",50, 50);
        JScrollPane scroll = new JScrollPane(historial);
        

//        mainPanel.setBackground(Color.red);
//        pnl_btn.setBackground(Color.LIGHT_GRAY);
//        pnl_info.setBackground(Color.DARK_GRAY);


        lbl_cantMinasPisadasTitulo.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        lbl_cantVidasTitulo.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        lbl_cantMinasPisadas.setFont(new Font("TimesRoman", Font.BOLD, 25));
        
        lbl_cantVidas.setForeground(Color.red);
        lbl_cantVidas.setFont(new Font("TimesRoman", Font.BOLD, 25));
        
        
        
        btn_reiniciar.setFont(new Font("SerTimesRomanif", Font.PLAIN, 25));
        
        //        Icono para el boton de reiniciar
         ImageIcon iconoReset = new ImageIcon("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\PruebaJframeBotones\\img\\reset.png");
         btn_reiniciar.setIcon(iconoReset);
        
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        historial.setEditable(false);
        

        for (int i = 0; i < 50; i++) {
            JButton b;
            b = new JButton("" + i);
            pnl_btn.add(b, "");
        }

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
        pnl_info.add(scroll,"align center");

        ventana.setVisible(true);
        ventana.setSize(screenWidth, screenHeight);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

    }
}
