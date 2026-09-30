package Queue.enums;

import java.util.Scanner;

import Queue.domain.*;

import Queue.interfaces.Operations;

public enum Operation {
    INSERT("1 - Inserir itens na pilha", (p, data, newdata) -> {
       
    }),

    REMOVE("2 - Remover itens da pilha", (p, data, newdata) -> {
        
    }),

    FIND("3 - Buscar itens na pilha", (p, data, newdata) -> {
       }),

    UPDATE("4 - Atualizar dados na pilha", (p, data, newdata)->{
        
    }),

    GETLENGHT("5 - Ver tamanho da pilha", (p, data, newdata)->{
        
    }),

    READ("6 - Visualizar a pilha inteira", (p, data, newdata)->{
        
    }),

    EXIT("7 - Sair", (p, data, newdata)->{});

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
