class CalculadoraCientifica extends Calculadora {
    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    // Crear un método que muestre los números desde X hasta Y (enteros)
    public void mostrarDesdeHasta(int x, int y) {
        while (x <= y) {
            System.out.println(x);
            x++;
        }
    }

    // Crear un método que muestre la serie de fibonacci hasta un número X definido
    // 0, 1, 1, 2, 3
    public void fibonacci(int x) {
        int prevNum = 0;
        int actualNum = 1;
        int nextNum;

        System.out.println(prevNum);
        System.out.println(actualNum);

        nextNum = prevNum + actualNum;

        while (nextNum <= x) {
            System.out.println(nextNum);
            prevNum = actualNum;
            actualNum = nextNum;
            nextNum = prevNum + actualNum;
        }
    }
}
