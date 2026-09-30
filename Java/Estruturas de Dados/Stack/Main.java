package Stack;

import Stack.enums.Operation;
import Stack.domain.Stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Stack<Integer> stack = new Stack<Integer>();

        var operations = Operation.values();
        
        int option = 0;

        do{
            System.out.println("Digite a opção desejada no menu abaixo:");

            for (Operation operation : operations) {
                System.out.println(operation.getOptionMenu());
            }

            option = sc.nextInt();

            operations[option-1].execute(stack, sc);

        }while (operations[option-1] != Operation.EXIT);

        sc.close();
    }
}    
