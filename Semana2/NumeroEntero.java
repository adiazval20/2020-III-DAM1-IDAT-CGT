class NumeroEntero extends Numero {
    public NumeroEntero(int valorExterno) {
        this.mostrarValor();
        this.valor = valorExterno;
    }

    void metodoAbstracto() {
        System.out.println("Invocando al método abstracto");
    }
}
