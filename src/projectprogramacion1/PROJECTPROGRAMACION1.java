/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectprogramacion1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author juangutierrez
 */
public class ProjectProgramacion1 {

    public static void main(String[] args) {
        //VistaCampoJuego juego = new VistaCampoJuego();
        VistaNuevaJuego juego = new VistaNuevaJuego();

//        Inicio de inicializacion de variables
        JFrame ventana = new JFrame("Inicio de juego"); // El cuadro o ventana donde van a estar los botones y los inputs

        JLabel lb_cantX = new JLabel("Ingrese la dimension en X"); // Texto que va a ir arriba del cuadro del input, mas conocido como label,  
        // esto puede ser un texto cualquiera no precisamente un label para un form

        JTextField cantX = new JTextField(); // Cuadro del input donde vamos a ingresar los datos

        JLabel lb_cantY = new JLabel("Ingrese la dimension en Y");
        JTextField cantY = new JTextField();

        JLabel lb_cantMinas = new JLabel("Ingrese la cantidad de minas");
        JTextField cantMinas = new JTextField();

        JButton btn_iniciarJuego = new JButton("Iniciar"); // Boton que va a iniciar el juego una vez precionado

        ventana.setSize(390, 300); // Aqui le decimos el tamano de la ventana o cuadro donde se va a mostrar todo

        lb_cantX.setBounds(50, 0, 150, 20); // Ubicacion en la ventana de donde queramos que este componente este ubicado
        cantX.setBounds(50, 30, 200, 20); // Al igual que el input

        lb_cantY.setBounds(50, 55, 150, 20);
        cantY.setBounds(50, 80, 200, 20);

        lb_cantMinas.setBounds(50, 110, 170, 20);
        cantMinas.setBounds(50, 140, 200, 20);

        btn_iniciarJuego.setBounds(50, 170, 200, 20);

        btn_iniciarJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Este es la accion a escuchar para el boton, cada vez que precionamos este boton
                // todo lo que este dentro del "metodo" por decirso asi, se va a ejecutar
                
                int dimX = Integer.parseInt(cantX.getText());         // Guardamos el valor del input en una variable con el metodo .getText()
                int dimY = Integer.parseInt(cantY.getText());
                int cantMina = Integer.parseInt(cantMinas.getText());
                //juego.vistaCampoJuego(dimX, dimY, cantMina);
                juego.iniciar(dimX, dimY, cantMina);
                ventana.dispose();                                    // "Cerramos" la ventana de la configuracion
            }
        });
        ventana.add(lb_cantX);  // Anadimos todos los elementos a la ventana
        ventana.add(cantX);
        ventana.add(lb_cantY);
        ventana.add(cantY);
        ventana.add(lb_cantMinas);
        ventana.add(cantMinas);
        ventana.add(btn_iniciarJuego);        

        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cuando le damos a la X de la venta se cierre y se termina el programa de una vez
        ventana.setLayout(null);   // Nos deja poder anadir componentes sin que se vean feos 
        ventana.setVisible(true); // Decimos que la ventana se vea

//        int x, y, cantMinas;
//        x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la dimension en x de tu juego"));
//        y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la dimension en y de tu juego"));
//        cantMinas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de minas con las que quiere jugar"));
//        juego.vistaCampoJuego(x, y, cantMinas);
    }

}
