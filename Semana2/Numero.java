abstract class Numero {
    protected int valor = 3;

    public void mostrarValor() {
        System.out.println(this.valor);
    }

    abstract void metodoAbstracto();
}