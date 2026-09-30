package Queue.interfaces;

import Queue.domain.Queue;

@FunctionalInterface
public interface Operations {
    void execute(Queue<Integer> queue, Integer data, Integer newData);
}