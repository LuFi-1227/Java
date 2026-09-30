package Stack.interfaces;

import Stack.domain.Stack;

@FunctionalInterface
public interface Operations {
    void execute(Stack<Integer> stack, Integer data, Integer newData);
}