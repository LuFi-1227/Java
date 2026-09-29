package BinaryTree;

import java.util.Scanner;

import BinaryTree.domain.Tree;

public class Main{
    public static int menu(Scanner sc){
        System.out.println("Digite um numero para realizar uma ação:");
        System.out.println("1 - Inserir um Nó");
        System.out.println("2 - Ver a árvore");
        System.out.println("3 - Encontrar um nó na árvore");
        System.out.println("4 - Encerrar programa");
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

        while (option != 4){
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
                    System.out.println(tree.findNode(input("Digite o número a ser buscado na árvore:", sc)));
                    break;
                case 4: 
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }
}