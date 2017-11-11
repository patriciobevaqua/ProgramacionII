package ejercicios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Interfaces Swing
 * @author arielp
 */
public class TrabajoPractico5 {
    
    public static void main(String[] args) {
        TrabajoPractico5 ej1= new TrabajoPractico5();
        
        ej1.ejercicio1();   //frame
        ej1.ejercicio2();   // internal frame
        ej1.ejercicio3();   // internal frame
    }
    
    public void ejercicio1() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(20, 20, 600, 800);
        frame.setTitle("Trabajo Practico 5");
        frame.setVisible(true);
    }
    
    public void ejercicio2() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setBounds(20, 20, 600, 800);
        frame.setTitle("Trabajo Practico 5");
        frame.setVisible(true);
        
        JInternalFrame internalFrame = new JInternalFrame();
        internalFrame.setTitle("Internal Frame");
        internalFrame.setBackground(Color.red);
        internalFrame.setBounds(10, 20, 400, 400);
        
        frame.add(internalFrame);
        internalFrame.setVisible(true);
    }
    
    /**
     * Construir un Frame con titulo "Ejercicio 3", e incluir un internal frame
     * con titulo "Interno".
     * El internal frame tiene que ser un cuadrado, y tener fondo azul.
     */
    public void ejercicio3() {
        JFrame ventanaPrincipal = new JFrame();
        ventanaPrincipal.setBounds(300, 400, 600, 700);
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setTitle("Ejercicio 3");
        ventanaPrincipal.setLayout(null);
        
        JInternalFrame ventanaInterna = new JInternalFrame();
        ventanaInterna.setBounds(0, 0, 200, 200);
        ventanaInterna.setTitle("Ventana Interna");
        ventanaInterna.setBackground(Color.BLUE);
        
        ventanaPrincipal.add(ventanaInterna);
        ventanaInterna.setVisible(true);
        
        JInternalFrame ventanaInterna2 = new JInternalFrame();        
        ventanaInterna2.setBounds(0, 200, 200, 200);
        ventanaInterna2.setTitle("Ventana Interna 2");
        ventanaInterna2.setBackground(Color.GREEN);
        
        ventanaPrincipal.add(ventanaInterna2);
        ventanaInterna2.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.yellow);
        panel.setBounds(400, 200, 200, 200);
        ventanaPrincipal.add(panel);
        
        JButton boton1 = new JButton();
        boton1.setBounds(200, 200, 200, 50);
        boton1.setText("Cerrar Ventanas");
                    
        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Click en boton");
                try {
                    ventanaInterna.setClosed(true);
                    ventanaInterna2.setClosed(true);
                } catch (PropertyVetoException ex) {
                    System.out.println("Excepcion");
                }
            }
        });    
        
        panel.add(boton1);
        boton1.setVisible(true);
        
        JButton boton2 = new JButton();
        boton2.setBounds(100, 600, 200, 50);
        boton2.setText("Abrir Ventanas");
        
        boton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaInterna.setVisible(true);
                ventanaInterna2.setVisible(true);
            }
        });
        
        panel.add(boton2);
        boton2.setVisible(true);
        
    }
}
