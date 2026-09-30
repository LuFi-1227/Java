package Stack.enums;

import java.util.Scanner;

import Stack.domain.*;
import Stack.exceptions.FullStackException;
import Stack.exceptions.NullStackException;
import Stack.interfaces.Operations;

public enum Operation {
    INSERT("1 - Inserir itens na pilha", (p, data, newdata) -> {
        try {
            p.insertNode(data);
        } catch (FullStackException e) {
            System.out.println(e);
        }
    }),

    REMOVE("2 - Remover itens da pilha", (p, data, newdata) -> {
        try {
            p.removeNode();
        } catch (NullStackException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }),

    FIND("3 - Buscar itens na pilha", (p, data, newdata) -> {
        try {
            String node = p.findAndOpenNode(data);
            System.out.println(node + node!="" ? "não encontrado." : "encontrado!");
        } catch (NullStackException e) {
            System.out.println(e);
            e.printStackTrace();
        }}),

    UPDATE("4 - Atualizar dados na pilha", (p, data, newdata)->{
        try {
            boolean flag = p.updateNode(data, newdata);
            if(!flag){
                System.out.println(data + " não está na pilha.");
            }
        } catch (NullStackException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }),

    GETLENGHT("5 - Ver tamanho da pilha", (p, data, newdata)->{
        System.out.println(p.getLenght());
    }),

    READ("6 - Visualizar a pilha inteira", (p, data, newdata)->{
        System.out.println(p);
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

    public void execute(Stack<Integer> stack, Scanner sc) {
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
                operation.execute(stack, null, null);
                return;
            case UPDATE:
                operation.execute(stack, input(sc, "Digite o numero do Nó que deseja alterar:"), input(sc, "Digite o novo numero do nó:"));
                return;
            case EXIT:
                return;
            default:
                return;
        }

        operation.execute(stack, input(sc, message), null);
    }
}
