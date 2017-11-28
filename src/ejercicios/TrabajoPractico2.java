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

        try {
            practico2.ejercicio4();
        } catch (Exception e) {
            System.out.println("excepcion ejercicio4: " + e);
        }
        practico2.ejercicio5();

        practico2.ejercicio6();     //este método puede tirar una excepcion no tratada por eso obliga a informarlo en la firma del metodo a traves del throws
        
        double resultado=  practico2.dividir(2, 2); //este método puede tirar una excepcion no tratada por eso obliga a informarlo en la firma del metodo a traves del throws
        System.out.println("resultado ejercicio dividir: "+ resultado);

    }

    public void ejercicio1() {
        System.out.println("Título EJERCICIO 1 ");

        int[] array = new int[20];
        //array[-7] = 24;     //indice del elemento fuera del limite del array
    }

    public void ejercicio2() {
        System.out.println("Título EJERCICIO 2 ");

        try { // Instrucciones cuando no hay una excepción
            int[] array = new int[20];
            array[50] = 24;  //indice del elemento fuera del limite del array

        } catch (ArrayIndexOutOfBoundsException ex) {  //se pone el tipo de excepción y un objeto que va a cotener loss datoss del objeto
            // Instrucciones cuando se produce una excepcion
            System.out.println("Excepcion: " + ex);
        } finally {
            // Instruciones que se ejecutan, tanto si hay como sino hay excepciones
            System.out.println("Finalizacion Ejercicio 2");

        }
    }

    public void ejercicio3() {
        System.out.println("Título EJERCICIO 3 ");

        int[] array = new int[20];
        try {
            int b = 0;
            int a = 23 / b;

            array[-10] = 24;

            String s = null;
            s.equals("QQQQ");
            //Aquí podemos observar la jerarquía de excepciones:
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(" Error de índice en un array: " + ex);
        } catch (ArithmeticException ex) {
            System.out.println(" Error matematico: " + ex);
        } catch (Exception ex) {
            System.out.println(" Excepción: " + ex);
        }
    }
    
    /**
     * se crea una escepcion que no está capturada entonces debe informarse ne la firma del metodo a través del throws
     * y no está tratada por eso se informa en la firma del método con "throws tipo de excepcion"
     * @throws Exception 
     */
    
    public void ejercicio4() throws Exception {  //tengo que poner el throws para informar que este metodo tira una excepción. si estuvieraa atrapada (try_catch) no haría falta el throws
        System.out.println("Título EJERCICIO 4 ");
        System.out.println("Generando una excepcion");
        throw new Exception("Soy la excepcion");  //acá se crea una excepción del tipo Exception
    }

    /**
     * Excepcion Propia
     * y está tratada con un try catch (por eso no hace falta informarla en la firma del metodo)
     */
    public void ejercicio5() {
        System.out.println("Título EJERCICIO 5 ");
        try {
            System.out.println("Primera parte");
            throw new ExcepcionSimpatica("Soy la excepcion"); //esta excepcion admite un string para indicar un mensaje
        } catch (ExcepcionSimpatica e) {
            System.out.println("excepcion: " + e);
        }
    }

    /**
     * Crear una excepcion propia y capturarla y mostrar su contenido.
     */
    public void ejercicio6() throws ExcepcionBevaqua {
        System.out.println("Título EJERCICIO 6 ");
        try {
            System.out.println("Primera parte");
            throw new ExcepcionBevaqua("Excepción creada por mi para el ejercicio 6");  //esta excepcion admite un string para indicar un mensaje

        } catch (ExcepcionBevaqua e) {  // en e guarda el objeto
            System.out.println("excepcion: " + e);
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
    public double dividir(double a, double b) throws ExcepcionBevaqua { //este throws no es necesario ya que la excepción está capturada, tratada (try catch)
        System.out.println("Título EJERCICIO 6 error matematico");
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
