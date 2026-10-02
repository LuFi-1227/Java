package DoublyLinkedList.interfaces;

import DoublyLinkedList.domain.DoublyLinkedList;

@FunctionalInterface
public interface Operations {
    void execute(DoublyLinkedList<Integer> linkedList, Integer data, Integer newData);
}