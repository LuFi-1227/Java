package Queue.enums;

import java.util.Scanner;

import Queue.domain.*;
import Queue.exceptions.*;
import Queue.interfaces.Operations;

public enum Operation {
    INSERT("1 - Inserir itens na fila", (f, data, newdata) -> {
        try{
            System.out.println("Adicionando: " + f.insert(new Node<Integer>(data)).openNode());
        }catch(FullQueueException e){
             System.out.println(e);
        }
    }),

    REMOVE("2 - Remover itens da fila", (f, data, newdata) -> {
        try{
            System.out.println("Removendo: " + f.remove().openNode());
        }catch(NullQueueException e){
            System.out.println(e);
        }
    }),

    FIND("3 - Buscar itens na fila", (f, data, newdata) -> {
        try{
            Node<Integer> n = f.find(data);
            System.out.println(n != null ? ("Encontrado: " + n.openNode()) : "Valor não encontrado!");
        }catch(NullQueueException e){
            System.out.println(e);
        }
    }),

    UPDATE("4 - Atualizar dados na fila", (f, data, newdata)->{
        try{
            Node<Integer> n = f.update(data, newdata);
            System.out.println(n != null ? ("Atualizado: " + n.openNode()) : "Valor não pode ser alterado porque não está na fila.");
        }catch(NullQueueException e){
            System.out.println(e);
        }
    }),

    GETLENGHT("5 - Ver tamanho da fila", (f, data, newdata)->{
        System.out.println("Tamanho: " + f.getLenght());
    }),

    READ("6 - Visualizar a fila inteira", (f, data, newdata)->{
        System.out.println(f);
    }),

    EXIT("7 - Sair", (f, data, newdata)->{});

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

    public void execute(Queue<Integer> queue, Scanner sc) {
        String message = null;
        switch (this) {
            case INSERT:
                message = "Digite um número para inserir: ";
                break;

            case FIND:
                message = "Digite um número para buscar: ";
                break;

            case REMOVE:
            case GETLENGHT:
            case READ:
                operation.execute(queue, null, null);
                return;
            case UPDATE:
                operation.execute(queue, input(sc, "Digite o numero do Nó que deseja alterar:"), input(sc, "Digite o novo numero do nó:"));
                return;
            case EXIT:
                return;
            default:
                return;
        }

        operation.execute(queue, input(sc, message), null);
    }
}
