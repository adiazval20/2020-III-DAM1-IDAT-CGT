import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String[] args) {
        // System.out.println("Hola otra vez!");

        // double numeroA = 5;
        // double numeroB = 6;
        // double numeroC = numeroA + numeroB;

        // boolean condicion = numeroC < 10;
        // if (condicion) {
        // System.out.println("Resultado: " + numeroC);
        // } else {
        // System.out.println("El número es mayor a 10");
        // }

        // String tipo = "C";

        // switch (tipo) {
        // case "A":
        // System.out.println("El tipo de variable es A");
        // break;
        // case "B":
        // System.out.println("El tipo de variable es B");
        // break;
        // case "C":
        // System.out.println("El tipo de variable es C");
        // break;
        // }

        // for (int i = 0; i < 10; i++) {
        // System.out.println(i);
        // }

        // List<String> numeros = new ArrayList<>();
        // numeros.add("Uno");
        // numeros.add("Dos");
        // numeros.add("Tres");
        // numeros.add("Cuatro");
        // numeros.add("Cinco");
        // numeros.add("Seis");
        // numeros.add("Siete");

        // for (String numero : numeros) {
        // // System.out.println(numero);
        // }

        // int x = 0;
        // while (x < 10) {
        // System.out.println("Sigo en el loop - " + x);
        // x++;
        // }

        // saludar(generarSaludo("Andy"));
        // if (esPar(6)) {
        // System.out.println("El número es par");
        // } else {
        // System.out.println("El número es inpar");
        // }

        mostrarDesdeHasta(150, 155);
        // CTRL + }
    }

    public static void saludar(String saludo) {
        System.out.println(saludo);
    }

    public static String generarSaludo(String nombre) {
        return "Bienvenido " + nombre + "!";
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Crear un método que muestre los números desde X hasta Y (enteros)
    public static void mostrarDesdeHasta(int x, int y) {
        while (x <= y) {
            System.out.println(x);
            x++;
        }
    }

    // Crear un método que muestre la serie de fibonacci hasta un número X definido
    public static void fibonacci(int x) {

    }
}