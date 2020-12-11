import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class App {
    public static void main(String[] args) throws IOException {
        Calculadora calc = new Calculadora();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Ingrese el primer valor:");
        double x = Double.parseDouble(br.readLine());

        System.out.println("Ingrese el segundo valor:");
        double y = Double.parseDouble(br.readLine());

        System.out.println(
                String.format("El resultado de multiplicar %.0f y %.0f es: %.2f", x, y, calc.multiplicar(x, y)));

        // Solicitar en consola un tipo de función a utilizar, por ejm: S -> sumar, R ->
        // restar, etc.
        // Solicitar el primer valor
        // Solicitar el segundo valor
        // Solicitar el tercer valor
        // Mostrar el resultado de la operación en pantalla, indicando el nombre
        // completo de la operación y el resultado.
        // Por ejm: El resultado de sumar: 5, 6, 7 es: 18
    }

    public static void saludar(String saludo) {
        System.out.println(saludo);
    }

    public static String generarSaludo(String nombre) {
        return "Bienvenido " + nombre + "!";
    }
}