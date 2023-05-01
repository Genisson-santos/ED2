public class ArvoreBinInteiro {
    private NoArvoreBinInteiro<Integer> raiz;

    public ArvoreBinInteiro(){
        this.raiz = null;
    }
    public void adicionar(Integer elemento){
        NoArvoreBinInteiro<Integer> novoElemento = new NoArvoreBinInteiro<Integer>(elemento);
        if (raiz == null){
            this.raiz = novoElemento;
        }else{
            NoArvoreBinInteiro<Integer> atual = this.raiz;
            while(true){
                if (novoElemento.getElemento().compareTo(atual.getElemento()) == -1){
                    if (atual.getFilhoEsquerda() != null){
                        atual = atual.getFilhoEsquerda();
                    }else{
                        atual.setFilhoEsquerda(novoElemento);
                        break;
                    }
                }else{
                    if (atual.getFilhoDireita() != null){
                        atual = atual.getFilhoDireita();
                    }else{
                        atual.setFilhoDireita(novoElemento);
                        break;
                    }
                }
            }
        }
    }
    public void listarFolhas() {
        if (raiz == null) {
            System.out.println("Árvore vazia!");
        } else {
            listarFolhas(raiz);
        }
    }
    private void listarFolhas(NoArvoreBinInteiro<Integer> no) {
        if (no != null) {
            if (no.getFilhoEsquerda() == null && no.getFilhoDireita() == null) {
                System.out.println(no.getElemento());
            } else {
                listarFolhas(no.getFilhoEsquerda());
                listarFolhas(no.getFilhoDireita());
            }
        }
    }
    public String caminhoRaiz(Integer elemento) {
        if (raiz == null) {
            return "Árvore vazia.";
        }
        String caminho = "";
        NoArvoreBinInteiro<Integer> atual = raiz;
        while (atual != null) {
            if (elemento == atual.getElemento()) {
                caminho += atual.getElemento();
                break;
            }
            caminho += atual.getElemento() + " -> ";
            if (elemento < atual.getElemento()) {
                atual = atual.getFilhoEsquerda();
            } else {
                atual = atual.getFilhoDireita();
            }
        }
        if (atual == null) {
            return "O número não está na árvore.";
        }
        return "Caminho da raiz até o número " + elemento + ": " + caminho;
    }
    public String listarInternos() {
        return listarInternos(this.raiz);
    }
    private String listarInternos(NoArvoreBinInteiro<Integer> noAtual) {
        String resultado = "";
        if (noAtual != null) {
            if (noAtual.getFilhoEsquerda() != null || noAtual.getFilhoDireita() != null) {
                resultado += noAtual.getElemento() + " ";
            }
            resultado += listarInternos(noAtual.getFilhoEsquerda());
            resultado += listarInternos(noAtual.getFilhoDireita());
        }
        return resultado;
    }
    public int alturaArvore() {
        return alturaArvore(this.raiz);
    }
    private int alturaArvore(NoArvoreBinInteiro<Integer> noAtual) {
        if(raiz==null) return 0;
        if (noAtual == null) {
            return -1;
        }
        int alturaEsquerda = alturaArvore(noAtual.getFilhoEsquerda());
        int alturaDireita = alturaArvore(noAtual.getFilhoDireita());
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }
    public Integer MenorNumero() {
        if (raiz == null) {
            return null;
        }
        NoArvoreBinInteiro<Integer> noAtual = raiz;
        while (noAtual.getFilhoEsquerda() != null) {
            noAtual = noAtual.getFilhoEsquerda();
        }
        return noAtual.getElemento();
    }

    public Integer MaiorNumero() {
        if (raiz == null) {
            return null;
        }
        NoArvoreBinInteiro<Integer> noAtual = raiz;
        while (noAtual.getFilhoDireita() != null) {
            noAtual = noAtual.getFilhoDireita();
        }
        return noAtual.getElemento();
    }
    public NoArvoreBinInteiro<Integer> getRaiz() {
        return raiz;
    }
    public int retornarRaiz() {
        if (raiz== null) {
            return 0;
        } else {
            return raiz.getElemento();
        }
    }
    public void percursoSimetrico(NoArvoreBinInteiro<Integer> atual){
        if (atual != null){
            percursoSimetrico(atual.getFilhoEsquerda());
            System.out.println(atual.getElemento());
            percursoSimetrico(atual.getFilhoDireita());
        }
    }

    public void percursoPreOrdem(NoArvoreBinInteiro<Integer> atual){
        if (atual != null){
            System.out.println(atual.getElemento());
            percursoPreOrdem(atual.getFilhoEsquerda());
            percursoPreOrdem(atual.getFilhoDireita());
        }
    }
    public void percursoPosOrdem(NoArvoreBinInteiro<Integer> atual){
        if (atual != null){
            percursoPosOrdem(atual.getFilhoEsquerda());
            percursoPosOrdem(atual.getFilhoDireita());
            System.out.println(atual.getElemento());
        }
    }
    public void listarNiveis(NoArvoreBinInteiro no, int nivelAtual, int nivelDesejado) {
        if (no == null) {
            return;
        }
        if (nivelAtual == nivelDesejado) {
            System.out.print(no.getElemento() + " ");
        } else {
            listarNiveis(no.getFilhoEsquerda(), nivelAtual + 1, nivelDesejado);
            listarNiveis(no.getFilhoDireita(), nivelAtual + 1, nivelDesejado);
        }
    }
    public void percorrerNiveis() {
        int altura = this.alturaArvore();
        for (int i = 1; i <= altura; i++) {
            listarNiveis(this.raiz, 1, i);
        }
        System.out.println(" ");
    }

}