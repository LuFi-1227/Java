package Stack.interfaces;

import Stack.domain.Stack;

@FunctionalInterface
public interface StackOperation {
    void execute(Stack<Integer> stack, Integer data, Integer newData);
}