package BinaryTree;

import java.util.Scanner;

import BinaryTree.Exceptions.NoneNodeException;
import BinaryTree.Exceptions.RootNodeException;
import BinaryTree.domain.Tree;

public class Main{
    public static int menu(Scanner sc){
        System.out.println("Digite um numero para realizar uma ação:");
        System.out.println("1 - Inserir um Nó");
        System.out.println("2 - Ver a árvore");
        System.out.println("3 - Encontrar um nó na árvore");
        System.out.println("4 - Remover um nó na árvore");
        System.out.println("5 - Atualizar (reordenar) um nó na árvore");
        System.out.println("6 - Encerrar programa");
        return sc.nextInt();
    }

    public static Integer input(String s, Scanner sc){
        System.out.println(s);
        return sc.nextInt();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;

        Tree<Integer> tree = new Tree<Integer>();

        while (option != 6){
            option = menu(sc);

            switch (option) {
                case 1:
                    tree.insertNode(input("Digite o número a ser inserido na árvore:", sc));
                    break;
                case 2:
                    System.out.print("\n====================\n\n");
                    System.out.print(tree);
                    System.out.print("\n====================\n\n");
                    break;
                case 3:
                    try{
                        System.out.println(tree.openNode(input("Digite o número a ser buscado na árvore:", sc)));
                    }catch(RootNodeException e){
                        System.out.println("Não há árvore para podermos efetuar a pesquisa.");
                    }
                    break;
                case 4: 
                    System.out.print("\n====================\n\n");
                    try{
                        boolean v = tree.removeNode(input("Digite o número a ser removido na árvore:", sc));
                        System.out.println(v == true ? "Remoção feita com sucesso." : "Falha ao remover");
                    }catch (NoneNodeException e){
                        System.out.println(e);
                    }
                    System.out.print("\n====================\n\n");
                    break;
                case 5:
                    System.out.print("\n====================\n\n");
                    boolean v = tree.updateNode(input("Digite o número a ser atualizado na árvore:", sc), input("Digite o novo número a ser inserido na árvore:", sc));
                    System.out.println(v == true ? "Atualização feita com sucesso." : "Falha ao atualizar");
                    System.out.print("\n====================\n\n");
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}