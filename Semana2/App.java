import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class App {
    public static void main(String[] args) throws IOException {
        NumeroEntero numero = new NumeroEntero(10);
        numero.mostrarValor();
        numero.metodoAbstracto();

        // CalculadoraCientifica calc = new CalculadoraCientifica();

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // calc.fibonacci(50);

        // Solicitar en consola un tipo de función a utilizar, por ejm: S -> sumar, R ->
        // restar, etc.
        // Solicitar el primer valor
        // Solicitar el segundo valor
        // Solicitar el tercer valor
        // Mostrar el resultado de la operación en pantalla, indicando el nombre
        // completo de la operación y el resultado.
        // Por ejm: El resultado de sumar: 5, 6, 7 es: 18

        // System.out.println("Ingrese el tipo de operacion:");
        // String operacion = br.readLine();

        // System.out.println("Ingrese el primer valor:");
        // double x = Double.parseDouble(br.readLine());

        // System.out.println("Ingrese el segundo valor:");
        // double y = Double.parseDouble(br.readLine());

        // System.out.println("Ingrese el tercer valor:");
        // double z = Double.parseDouble(br.readLine());

        // double resultado = 0;
        // String nombreOperacion = "";

        // switch (operacion) {
        // case "S":
        // resultado = calc.sumar(x, y, z);
        // nombreOperacion = "sumar";
        // break;
        // case "R":
        // resultado = calc.restar(x, y, z);
        // nombreOperacion = "restar";
        // break;
        // case "M":
        // resultado = calc.multiplicar(x, y, z);
        // nombreOperacion = "multiplicar";
        // break;
        // case "D":
        // resultado = calc.dividir(x, y, z);
        // nombreOperacion = "dividir";
        // break;
        // }

        // System.out.println(
        // String.format("El resultado de %s %.0f, %.0f y %.0f es: %.2f",
        // nombreOperacion, x, y, z, resultado));
    }

    public static void saludar(String saludo) {
        System.out.println(saludo);
    }

    public static String generarSaludo(String nombre) {
        return "Bienvenido " + nombre + "!";
    }
}