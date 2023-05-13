package ArvoreBinBusca;

import java.util.Iterator;

public class ArvoreBuscaEncadeada<E extends Comparable<E>> implements ArvoreBinBusca<E> {
    private PosicaoArvoreBin<E> raiz;
    int tamanho =0;
    public int tamanho() {
        return this.tamanho;
    }
    //Retorna a quantidade de nodos da Árvore.
    public boolean estaVazia() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }
    //Verifica se a Árvore está vazia. Se estiver vazia retorna true, caso contrário retorna false.

    public Iterator<E> iterator() {
        return null;
    }

    //Retorna um iterator dos nodos armazenados na Árvore.
    public Iterable<Posicao<E>> posicoes() {
        return null;
    }

    //Retorna uma coleção navegável de nodos da Árvore.
    public E substituir(Posicao<E> posicao, E elemento) throws PosicaoInvalidaException {
        if (posicao == raiz) {
            if ((posicao.getFilhoDireito() != null && elemento.compareTo(posicao.getFilhoDireito().getElemento()) >= 0) ||
                    (posicao.getFilhoEsquerdo() != null && elemento.compareTo(posicao.getFilhoEsquerdo().getElemento()) < 0)) {
                throw new PosicaoInvalidaException("Posicao Inválida.");
            }
        } else {
            if ((posicao.getPai().getFilhoEsquerdo() != null && posicao == posicao.getPai().getFilhoEsquerdo() && elemento.compareTo(posicao.getPai().getElemento()) >= 0) ||
                    (posicao.getPai().getFilhoDireito() != null && posicao == posicao.getPai().getFilhoDireito() && elemento.compareTo(posicao.getPai().getElemento()) < 0)) {
                throw new PosicaoInvalidaException("Posicao Inválida.");
            }
        }
        E aux = posicao.getElemento();
        posicao.setElemento(elemento);
        return aux;
    }
    //Substitui o elemento armazenado na posição especificada.
    public Posicao<E> getRaiz() throws ArvoreVaziaException {
        return raiz;
    }

    //Retorna a raiz da Árvore.
    public Posicao<E> pai(Posicao<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posição Inválida.");
        } else if (posicao == raiz) {
            throw new LimiteVioladoException("Limite Violado.");
        }
        return posicao.getPai();
    }

    // Retorna o pai de um determinado nodo.
    public Iterable<Posicao<E>> filhos(Posicao<E> posicao) throws PosicaoInvalidaException {
        return null;
    }

    //Retorna uma coleção navegável contendo os filhos de um determinado nodo.

    public boolean ehInterno(Posicao<E> posicao) throws PosicaoInvalidaException {
        if (posicao.getFilhoDireito() != null || posicao.getFilhoEsquerdo() != null) {
            return true;
        } else {
            return false;}}
    // Verifica se a posição do elemento representa um nó é interno. Se for um nó interno retorna true, caso contrário retorna false.
    public boolean ehFolha(Posicao<E> posicao) throws PosicaoInvalidaException {
        if (posicao.getFilhoDireito() == null && posicao.getFilhoEsquerdo() == null) {
            return true;
        } else {
            return false;}}
    //Verifica se a posição do elemento representa um nó folha. Se for um nó folha retorna true, caso contrário retorna false.
    public boolean ehRaiz(Posicao<E> posicao) throws PosicaoInvalidaException {
        return false;
    }

    //Verifica se a posição do elemento é a raiz da Árvore. Se for a raiz da Árvore retorna true, caso contrário retorna false.
    public PosicaoArvoreBin<E> filhoEsq(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if (posicao == null || posicao.getFilhoEsquerdo() == null) {
            throw new PosicaoInvalidaException("Posicao Inválida");
        }
        return posicao.getFilhoEsquerdo();
    }
    // Retorna o filho esquerdo de uma determinada posição na árvore binária.
    public PosicaoArvoreBin<E> filhoDir(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException, LimiteVioladoException {
        if (posicao == null || posicao.getFilhoDireito() == null) {
            throw new PosicaoInvalidaException("Posicao Inválida ou limite violado.");
        }
        return posicao.getFilhoDireito();
    }
    //Retorna o filho direito de uma determinada posição na árvore binária.

    public boolean existeFilhoEsq(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao inválida.");
        }
        return posicao.getFilhoEsquerdo() != null;
    }

    // Verifica se existe filho esquerdo em uma determinada posição na árvore binária.
    public boolean existeFilhoDir(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null) {
            throw new PosicaoInvalidaException("Posicao inválida.");
        }
        return posicao.getFilhoDireito() != null;
    }
    //Verifica se existe filho direito em uma determinada posição na árvore binária.
    public boolean ehFilhoEsq(PosicaoArvoreBin<E> pai, PosicaoArvoreBin<E> filho) throws PosicaoInvalidaException {
        if (pai == null || filho == null) {
            throw new PosicaoInvalidaException("Posicao Inválida.");
        }
        return filho.equals(pai.getFilhoEsquerdo());
    }
    //Verifica se a posição é filho esquerdo do pai.
    public boolean ehFilhoDir(PosicaoArvoreBin<E> pai, PosicaoArvoreBin<E> filho) throws PosicaoInvalidaException {
        if (pai == null || filho == null) {
            throw new PosicaoInvalidaException("Posicao Inválida.");
        }
        return filho.equals(pai.getFilhoDireito());
    }
    //Verifica se a posição é filho direito do pai.
    public boolean inserir(PosicaoArvoreBin<E> posicao) throws ArvoreNaoVaziaException, PosicaoInvalidaException, ArvoreVaziaException {
        if (raiz == null){
            this.raiz = posicao;
        }else{
            PosicaoArvoreBin<E> atual = this.raiz;
            while(true){
                if (posicao.getElemento().compareTo(atual.getElemento()) == -1){
                    if (atual.getFilhoEsquerdo() != null){
                        atual = atual.getFilhoEsquerdo();
                    }else{
                        atual.setFilhoEsquerdo(posicao);
                        break;
                    }
                }else{
                    if (atual.getFilhoDireito() != null){
                        atual = atual.getFilhoDireito();
                    }else{
                        atual.setFilhoDireito(posicao);
                        break;
                    }
                }
            }
        }
        return false;
    }
    //Insere uma nova posição na árvore binária de busca, garantindo sua propriedade.
    public boolean remover(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        return false;
    }
    //Remove uma posição da árvore binária de busca, garantindo sua propriedade.
    protected PosicaoArvoreBin<E> maior(PosicaoArvoreBin<E> posicao) throws PosicaoInvalidaException {
        if (posicao == null || posicao.getFilhoEsquerdo() == null) {
            throw new PosicaoInvalidaException("Posicao Inválida");
        }
        PosicaoArvoreBin<E> aux = posicao.getFilhoEsquerdo();
        PosicaoArvoreBin<E> maior = aux;

        while (aux.getFilhoDireito() != null) {
            aux = aux.getFilhoDireito();
            if (aux.getElemento().compareTo(maior.getElemento()) > 0) {
                maior = aux;
            }
        }
        return maior;
    }
    //Busca o nó com a maior chave na subárvore esquerda de um determino nó.
    private void removerComDoisFilhos(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {

    }

    // Remove um nó que possui dois filhos.
    private void removerFilhoUnico(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {

    }

    // Remove um nó que possui um único filho.
    private void removerFolha(PosicaoArvoreBin<E> no) throws PosicaoInvalidaException {

    }
    // Remove um nó que não possui filhos.
    public PosicaoArvoreBin<E> busca(Posicao<E> posicao) {
        if (raiz == null) {
            return null;
        }
        PosicaoArvoreBin<E> aux = raiz;
        while (aux != null) {
            int comparacao = posicao.getElemento().compareTo(aux.getElemento());
            if (comparacao == 0) {
                return aux;
            } else if (comparacao < 0) {
                aux = aux.getFilhoEsquerdo();
            } else {
                aux = aux.getFilhoDireito();
            }}
        return null;
    }
    //Busca um determinado nó na árvore.
    public boolean existe(Posicao<E> posicao) {
        PosicaoArvoreBin<E> aux = raiz;
        while (aux != null) {
            int comparacao = posicao.getElemento().compareTo(aux.getElemento());
            if (comparacao == 0) {
                return true; // nó encontrado
            } else if (comparacao < 0) {
                aux = aux.getFilhoEsquerdo();
            } else {
                aux = aux.getFilhoDireito();
            }
        }
        return false; // nó não encontrado
        // Verifica se um determinado nó existe na árvore.
    }
}
