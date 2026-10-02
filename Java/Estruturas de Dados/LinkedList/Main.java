package LinkedList;

import LinkedList.enums.Operation;
import LinkedList.domain.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        LinkedList<Integer> list = new LinkedList<Integer>();

        var operations = Operation.values();
        
        int option = 0;

        do{
            System.out.println("Digite a opção desejada no menu abaixo:");

            for (Operation operation : operations) {
                System.out.println(operation.getOptionMenu());
            }

            option = sc.nextInt();

            operations[option-1].execute(list, sc);

        }while (operations[option-1] != Operation.EXIT);

        sc.close();
    }
}    
