package ejercicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Arreglos y Listas
 *
 * @author
 */
public class TrabajoPractico1 {

    public static void main(String[] args) { //creo el psvm para validar los metodos de la clase
        TrabajoPractico1 practico1 = new TrabajoPractico1();
        practico1.ejercicio1();
        practico1.ejercicio3();
        practico1.ejercicio4();

    }

    /**
     *  crea un arreglo de string
     */
    public void ejercicio1() {
        String[] palabras = new String[4];
        palabras[0] = "Esto";
        palabras[1] = "es";
        palabras[2] = "una";
        palabras[3] = "frase";

        System.out.println("Iterando Arreglos forma 1 (con un for i)");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            System.out.println(palabra);
        }
        System.out.println("\n");
        
        System.out.println("Iterando Arreglos forma 2 (con un for each)");
        /**en el for each
         * se crea una variable del tipo que contiene el arreglo, en este caso String
         * la variable palabra cumple a funcion de palabra[i]
         * luego de los dos puntos (:) va el nombre del arreglo
        */
        for (String palabra : palabras) { 
            System.out.println(palabra);
        }
    }

    public void ejercicio2() {
        List<String> palabras = new ArrayList();
        palabras.add("Esto");
        palabras.add("es");
        palabras.add("una");
        palabras.add("frase");

        System.out.println("Iterando Listas forma 1");
        for (int i = 0; i < palabras.size(); i++) {
            String palabra = palabras.get(i);
            System.out.println(palabra);
        }
        System.out.println("\n");

        System.out.println("Iterando Listas forma 2");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }

        System.out.println("Iterando Listas forma 3 (Iterador)");
        Iterator<String> iterador = palabras.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
    }

    /**
     * Crear un arreglo de numeros enteros del 1 al 5, recorrerlos y mostralos
     * de las 2 formas
     */
    public void ejercicio3() {
        //int[] Enteros = new int[4];
        int[] Enteros = {1, 2, 3, 4, 5};

        System.out.println("Iterando Arreglos forma 1");
        for (int i = 0; i < Enteros.length; i++) {
            int numero = Enteros[i];
            System.out.println(numero);
        }
        System.out.println("\n");

        System.out.println("Iterando Arreglos forma 2");
        for (int numeroi : Enteros) {
            System.out.println(numeroi);
        }
        System.out.println("-------------------------\n");

    }

    /**
     * Crear una lista de numeros enteros del 1 al 5, recorrerlos y mostarlos de
     * las 3 formas
     */
    public void ejercicio4() {
        List<Integer> listaEnteros = new ArrayList();
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(3);
        listaEnteros.add(4);
        listaEnteros.add(5);

        System.out.println("Iterando Listas forma 1 -con un for i-");
        for (int i = 0; i < listaEnteros.size(); i++) {
            Integer numero = listaEnteros.get(i);
            System.out.println(numero);
        }
        System.out.println("\n");

        System.out.println("Iterando Listas forma 2 -con un for each-");
        for (Integer numeroi : listaEnteros) {
            System.out.println(numeroi);
        }
        System.out.println("\n");

        System.out.println("Iterando Listas forma 3 (Iterador)");
        Iterator<Integer> iterador = listaEnteros.iterator();
        while (iterador.hasNext()) {
            System.out.println(iterador.next());
        }
        System.out.println("\n");

    }
}
