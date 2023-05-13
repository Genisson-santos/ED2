package ArvoreBinBusca;
public class PosicaoArvoreBin<T extends Comparable<T>> implements Posicao {
    private T elemento;
    private PosicaoArvoreBin<T> FilhoEsquerdo;
    private PosicaoArvoreBin<T> FilhoDireito;
    private Posicao<T> Pai;
    public T getElemento() {return elemento;
    }
    public void setElemento(T elemento) {this.elemento = elemento;
    }
    public PosicaoArvoreBin<T> getFilhoEsquerdo() {return FilhoEsquerdo;
    }
    public PosicaoArvoreBin<T> getFilhoDireito() {return FilhoDireito;
    }

    public Posicao<T> getPai() {return Pai;
    }
    public void setPai(Posicao<T> pai) {this.Pai = pai;
    }
    public void setFilhoEsquerdo(PosicaoArvoreBin filhoEsquerdo) {this.FilhoEsquerdo = filhoEsquerdo;
    }
    public void setFilhoDireito(PosicaoArvoreBin filhoDireito) {this.FilhoDireito = filhoDireito;
    }
    public void setElemento(Object elemento) {elemento = (T) elemento;
    }
}
