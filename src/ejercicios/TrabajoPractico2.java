package ejercicios;

import excepciones.ExcepcionBevaqua;
import excepciones.ExcepcionSimpatica;

/**
 * Excepciones
 *
 * @author arielp
 */
public class TrabajoPractico2 {

    public static void main(String[] args) throws Exception {  //creo el psvm para validar los metodos de la clase
        TrabajoPractico2 practico2 = new TrabajoPractico2();
        practico2.ejercicio1();
        practico2.ejercicio2();
        practico2.ejercicio3();
        //practico2.ejercicio4();
        practico2.ejercicio5();
        
        practico2.ejercicio6();
        practico2.dividir(2, 0);
       

    }

    public void ejercicio1() {
        System.out.println("EJERCICIO 1 ");

        int[] array = new int[20];
        //array[-7] = 24;
    }

    public void ejercicio2() {
        System.out.println("EJERCICIO 2 ");

        try {
            int[] array = new int[20];
            array[50] = 24;
            // Instrucciones cuando no hay una excepción
        } catch (ArrayIndexOutOfBoundsException ex) {
            // Instrucciones cuando se produce una excepcion
            System.out.println("Excepcion: " + ex);
        } finally {
            System.out.println("Finally Ejercicio 2");
            // Instruciones que se ejecutan, tanto si hay como sino hay excepciones
        }
    }

    public void ejercicio3() {
        System.out.println("EJERCICIO 3 ");

        int[] array = new int[20];
        try {
            int b = 0;
            int a = 23 / b;
            array[-10] = 24;

            String s = null;
            s.equals("QQQQ");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(" Error de índice en un array: " + ex);
        } catch (ArithmeticException ex) {
            System.out.println(" Error matematico: " + ex);
        } catch (Exception ex) {
            System.out.println(" Error matematico: " + ex);
        }
    }

    public void ejercicio4() throws Exception {
        System.out.println("EJERCICIO 4 ");
        System.out.println("Generando una excepcion");
        throw new Exception("Soy la excepcion");
    }

    /**
     * Excepcion Propia
     */
    public void ejercicio5() {
        System.out.println("EJERCICIO 5 ");
        try {
            System.out.println("Primera parte");
            throw new ExcepcionSimpatica("Soy la excepcion");
        } catch (ExcepcionSimpatica e) {
            System.out.println("excepcion" + e);
        }
    }

    /**
     * Crear una excepcion propia y capturarla y mostrar su contenido.
     */
    public void ejercicio6() throws Exception {
        System.out.println("EJERCICIO 6 ");
        try {
            System.out.println("Primera parte");
            throw new ExcepcionBevaqua("Excepción creada por mi para el ejercicio 6");

        } catch (ExcepcionBevaqua e) {  // en e guarda el objeto
            System.out.println("excepcion:" + e);
        }

    }

    /**
     *
     * @param a numrador
     * @param b denomminador
     * @return retorna la división a/b
     * @throws Exception refiere a la situacion en que el denominador b es igual
     * a cero
     */
    public double dividir(double a, double b) throws Exception {
        System.out.println("EJERCICIO 6 ");
        try {
            if (b == 0) {
                throw new ExcepcionBevaqua("El argumento b no puede ser 0");
            }
        } catch (ExcepcionBevaqua ex) {
            System.out.println(" Error matematico: " + ex);
        }
        return a / b;
    }

//Excepciones
//http://elvex.ugr.es/decsai/java/pdf/B2-excepciones.pdf
//http://cursohibernate.es/doku.php?id=patrones:excepciones
}
