import java.util.Scanner;
public class TestArvoreBinInteiro {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opicao;

        ArvoreBinInteiro arvore = new ArvoreBinInteiro();
        do {
            System.out.println("""
                    ---------------Menu---------------------------
                   
                    1.   Inserir um número
                    2.   Retornar o maior número
                    3.   Retornar o menor número
                    4.   Retornar a altura da árvore
                    5.   Listar números (percurso Pré-Ordem)
                    6.   Listar números (percurso Pós-Ordem)
                    7.   Listar números (percurso Simétrico)
                    8.   Listar números (percurso em níveis)
                    9.   Listar os números internos
                    10.  Listar folhas
                    11.  Exibir caminho da raiz a um número
                    12.  Retorna raiz
                    0.   Sair
                    -----------------------------------------------
                    """);

            opicao = scanner.nextInt();
            switch (opicao) {
                case 1:
                    System.out.println("Adicione um número : ");
                    int numero = scanner.nextInt();
                    arvore.adicionar(numero);
                    break;
                case 2:
                    System.out.println("O maior número é: " + arvore.MaiorNumero() );
                    break;
                case 3:
                    System.out.println("O menor número é: " + arvore.MenorNumero());
                    break;
                case 4:
                    System.out.println("A altura da árvore é: " + arvore.alturaArvore());
                    break;
                case 5:
                    System.out.println("Listar pré-ordem: ");
                    arvore.percursoPreOrdem(arvore.getRaiz());
                    break;
                case 6:
                    System.out.println("Listar pós-ordem: ");
                    arvore.percursoPosOrdem(arvore.getRaiz());
                    break;
                case 7:
                    System.out.println("Listar em ordem simétrica: ");
                    arvore.percursoSimetrico(arvore.getRaiz());
                    break;
                case 8:
                    System.out.println("Listar percursso em nível: ");
                   arvore.percorrerNiveis();
                    break;

                case 9:
                    System.out.println("Listar números internos: ");
                    System.out.println(arvore.listarInternos());
                    break;
                case 10:
                    System.out.println("Listar folhas da árvore: ");
                    arvore.listarFolhas();
                    break;

                case 11:
                    System.out.println("Digite o caminho : ");
                    int caminho = scanner.nextInt();
                    System.out.println(arvore.caminhoRaiz(caminho));
                    break;
                case 12:
                    System.out.println("A raiz é: " + arvore.getRaiz().getElemento());
                case 0:
                    break;
            }
        }
        while (opicao != 0);
    }
    }

