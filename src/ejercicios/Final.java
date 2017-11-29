/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.util.ArrayList;
import java.util.List;
import modelos.Auto;

/**
 * clase creada para final 2017
 * @author Estudio
 */
public class Final {

    public void ejercicio1() {

        List<String> nombres = new ArrayList();
        nombres.add("patricio");
        nombres.add("ariel");
        nombres.add("daniel");
        nombres.add("santiago");

        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        for (int i = (nombres.size()-1); i >=0 ; i--) {
            String nombre = nombres.get(i);
            System.out.println(nombre);

        }

    }

    public void ejercicio2(){
    Auto auto1= new Auto();
    auto1.setMarca("Ford");
    
    
    Auto auto2= new Auto();
    auto2.setModelo(1983);
    
        System.out.println("marca del auto 1:"+ auto1.getMarca());
    
    }
    
    
}


