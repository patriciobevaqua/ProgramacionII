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
        practico1.ejercicio2();
        practico1.ejercicio3();
        practico1.ejercicio4();

    }

    /**
     * Crea un arreglo de string
     * luego se reccorre de dos formas, for i (fori) y for each (fore)
     */
    public void ejercicio1() {
        System.out.println("Ejercicio 1");
        String[] palabras = new String[4];
        palabras[0] = "Esto";
        palabras[1] = "es";
        palabras[2] = "una";
        palabras[3] = "frase";

        System.out.println("\nIterando Arreglos forma 1 (con un for i)");
        for (int i = 0; i < palabras.length; i++) {
            String palabra = palabras[i];
            System.out.println(palabra);
        }
        //System.out.println("\n");
        
        System.out.println("\nIterando Arreglos forma 2 (con un for each)");
        /**en el for each
         * se crea una variable del tipo que contiene el arreglo, en este caso String
         * la variable palabra cumple a funcion de palabra[i]
         * luego de los dos puntos (:) va el nombre del arreglo
        */
        for (String palabra : palabras) { 
            System.out.println(palabra);
        }
    
    }
      /**
       * crea una lista. la lista (a diferencia de un arreglo) contiene objetos
       * para adicionar datos se utiliza add, para determinar el tamaño size
       */
    public void ejercicio2() {
        System.out.println("\nEjercicio 2");
        List<String> palabras = new ArrayList();
        palabras.add("Esto");
        palabras.add("es");
        palabras.add("una");
        palabras.add("frase");
        

        System.out.println("Iterando Listas forma 1 (for i)");
        for (int i = 0; i < palabras.size(); i++) {
            String palabra = palabras.get(i);
            System.out.println(palabra);
        }
        System.out.println("\n");

        System.out.println("Iterando Listas forma 2 (for each)");
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
            /**
             * usa el metodo iterator() de la lista
             * luego asigna ese dato a una variable iterador (string)
             * y esa variable iterador utiliza los metodos hasNext() y next()
             */
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
        System.out.println("\nEjercicio 3");
        //int[] Enteros = new int[4];
        int[] enteros = {1, 2, 3, 4, 5};

        System.out.println("Iterando Arreglos forma 1");
        for (int i = 0; i < enteros.length; i++) {
            int numero = enteros[i];
            System.out.println(numero);
        }
        //System.out.println("\n");

        System.out.println("\nIterando Arreglos forma 2");
        for (int numeroi : enteros) {
            System.out.println(numeroi);
        }
        
        
        System.out.println("-------------------------\n");

        //hago una lista de enteros. 
        List<Integer> listaEnteros = new ArrayList();
        listaEnteros.add(11);
        listaEnteros.add(12);
        listaEnteros.add(13);
        listaEnteros.add(14);
        System.out.println("Iterando Lista de enteros forma 3 (Iterador)");
        
        Iterator<Integer> iteradorNumero = listaEnteros.iterator();
        while (iteradorNumero.hasNext()) {
            System.out.println(iteradorNumero.next());
        }
    }

    /**
     * Crear una lista de numeros enteros del 1 al 5, recorrerlos y mostarlos de
     * las 3 formas
     */
    public void ejercicio4() {
        System.out.println("\nEjercicio 4");
        List<Integer> listaEnteros = new ArrayList();  //es dinamico ppal diferencia
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
