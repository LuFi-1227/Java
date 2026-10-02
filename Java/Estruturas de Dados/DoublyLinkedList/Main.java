package DoublyLinkedList;

import DoublyLinkedList.enums.Operation;
import DoublyLinkedList.domain.DoublyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();

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
