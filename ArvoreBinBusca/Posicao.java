package ArvoreBinBusca;

public interface Posicao <E>{
    public E getElemento();
    public Posicao<E> getFilhoEsquerdo();
    public Posicao<E> getFilhoDireito();
    public Posicao<E> getPai();
    public void setFilhoEsquerdo(PosicaoArvoreBin FilhoEsquerdo);
    public void setFilhoDireito(PosicaoArvoreBin FilhoDireito);

    public void setElemento(E elemento);

}