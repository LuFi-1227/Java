package LinkedList.enums;

import java.util.Scanner;

import LinkedList.domain.*;
import LinkedList.exceptions.*;
import LinkedList.interfaces.Operations;

public enum Operation {
    INSERT("1 - Inserir itens na lista", (l, data, newdata) -> {
        System.out.println("Adicionando: " + l.addNode((data)).openNode());
    }),

    REMOVE("2 - Remover itens da lista", (l, data, newdata) -> {
        try{
            System.out.println("Removendo: " + l.removeNode(data).openNode());
        }catch(NodeNotFoundException e){
            System.out.println(e);
        }catch(LinkedListEmpty e){
            System.out.println(e);
        }
    }),

    FIND("3 - Buscar itens na lista", (l, data, newdata) -> {
        try{
            Node<Integer>[] n = l.find(data);
            System.out.println(n[1] != null ? ("Encontrado: " + n[1].openNode()) : "Valor não encontrado!");
        }catch(LinkedListEmpty e){
            System.out.println(e);
        }catch(NodeNotFoundException k){
            System.out.println(k);
        }
    }),

    UPDATE("4 - Atualizar dados na lista", (l, data, newdata)->{
        try{
            Node<Integer> n = l.updateNode(data, newdata);
            System.out.println(n != null ? ("Atualizado: " + n.openNode()) : "Valor não pode ser alterado porque não está na lista.");
        }catch(NodeNotFoundException e){
            System.out.println(e);
        }catch(LinkedListEmpty e){
            System.out.println(e);
        }
    }),

    GETLENGHT("5 - Ver tamanho da lista", (l, data, newdata)->{
        System.out.println("Tamanho: " + l.getLenght());
    }),

    READ("6 - Visualizar a lista inteira", (l, data, newdata)->{
        System.out.println(l);
    }),

    EXIT("7 - Sair", (l, data, newdata)->{});

    private final String optionMenu;
    private final Operations operation;

    Operation(String optionMenu, Operations operation) {
        this.optionMenu = optionMenu;
        this.operation = operation;
    }

    public String getOptionMenu() {
        return optionMenu;
    }

    public static Integer input(Scanner sc, String s){
        System.out.print(s);
        return sc.nextInt();
    }

    public void execute(LinkedList<Integer> l, Scanner sc) {
        String message = null;
        switch (this) {
            case INSERT:
                message = "Digite um número para inserir: ";
                break;

            case FIND:
                message = "Digite um número para buscar: ";
                break;

            case REMOVE:
                message = "Digite um número para remover: ";
                break;
            
            case GETLENGHT:
            case READ:
                operation.execute(l, null, null);
                return;
            case UPDATE:
                operation.execute(l, input(sc, "Digite o numero do Nó que deseja alterar:"), input(sc, "Digite o novo numero do nó:"));
                return;
            case EXIT:
                return;
            default:
                return;
        }

        operation.execute(l, input(sc, message), null);
    }
}
