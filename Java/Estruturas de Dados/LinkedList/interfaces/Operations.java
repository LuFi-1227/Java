package LinkedList.interfaces;

import LinkedList.domain.LinkedList;

@FunctionalInterface
public interface Operations {
    void execute(LinkedList<Integer> linkedList, Integer data, Integer newData);
}