public class NoArvoreBinInteiro<T> {
    private T elemento;
    private NoArvoreBinInteiro<T> filhoEsquerda;
    private NoArvoreBinInteiro<T> filhoDireita;

    public NoArvoreBinInteiro(T novoElemento){
        this.elemento = novoElemento;
        this.filhoEsquerda = null;
        this.filhoDireita = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoArvoreBinInteiro<T> getFilhoEsquerda() {
        return filhoEsquerda;
    }

    public void setFilhoEsquerda(NoArvoreBinInteiro<T> filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public NoArvoreBinInteiro<T> getFilhoDireita() {
        return filhoDireita;
    }

    public void setFilhoDireita(NoArvoreBinInteiro<T> filhoDireita) {
        this.filhoDireita = filhoDireita;
    }
}
