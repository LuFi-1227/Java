package Stack.enums;

import Stack.domain.*;
import Stack.exceptions.FullStackException;
import Stack.exceptions.NullStackException;
import Stack.interfaces.StackOperation;;

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
            p.findAndOpenNode(data);
        } catch (NullStackException e) {
            System.out.println(e);
            e.printStackTrace();
        }}),

    UPDATE("4 - Atualizar dados na pilha", (p, data, newdata)->{
        try {
            p.updateNode(data, newdata);
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

    EXIT("7 - Sair", (p, data, newdata)->{System.exit(0);});

    private final String optionMenu;
    private final StackOperation operation;

    Operation(String optionMenu, StackOperation operation) {
        this.optionMenu = optionMenu;
        this.operation = operation;
    }

    public String getOptionMenu() {
        return optionMenu;
    }

    public void execute(Stack<Integer> stack, Integer data, Integer newData) {
        operation.execute(stack, data, newData);
    }
}
