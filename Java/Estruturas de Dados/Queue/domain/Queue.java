package Queue.domain;

import Queue.exceptions.*;

public class Queue<T> {
    private Node<T> firstNode = null;
    private Node<T> lastNode = null;
    private int lenght = 0;
    private int maxLenght = 10; // If maxLenght is equal 0, the stack do not have a maxlenght.

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<T> lastNode) {
        this.lastNode = lastNode;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
    }

    public int getLenght(){
        return this.lenght;
    }

    public boolean isFull(){
        return this.getLenght() >= this.getMaxLenght() && !(this.getMaxLenght() == 0);
    }

    public boolean isEmpty(){
        return this.firstNode == null;
    }

    public Node<T> insert(Node<T> node) throws FullQueueException{
        if(!this.isFull()){
            if(this.isEmpty()){
                this.firstNode = node;
                this.lastNode = node;
                this.lenght++;
                return node;
            }else{
                this.lastNode.setProxNode(node);
                this.lastNode = node;
                this.lenght++;
                return node;
            }
        }else{
            throw new FullQueueException("Fila se encontra cheia.");
        }
    }

    public Node<T> remove() throws NullQueueException{
        if (this.isEmpty()){
            throw new NullQueueException("Fila está vazia."); 
        }else{
            Node<T> rm = this.firstNode;
            this.firstNode = this.firstNode.getProxNode();
            this.lenght--;
            return rm;
        }
    }

    public Node<T> find(T value) throws NullQueueException{
        Node<T> node = this.firstNode;

        if (node == null) throw new NullQueueException("Fila está vazia.");

        while(node != this.lastNode){
            if (node.getData().equals(value)) return node;
            node = node.getProxNode();
        }

        if(node.getData().equals(value)) return node;
        else return null;
    }

    public Node<T> update(T value, T newValue) throws NullQueueException{
        Node<T> node = this.find(value);

        if (node == null){
            if (this.firstNode == null) throw new NullQueueException("Fila está vazia.");
            else return null;
        }

        node.setData(newValue);

        return node;
    }

    public String toString(){
        Node<T> node = this.firstNode;
        String resultString = "";

        if (node == null) return "null";

        while(!node.equals(this.lastNode)){
            resultString += (node.toString() + " -> ");
            node = node.getProxNode();
        }

        resultString += (node.toString());

        return resultString;
    }

}
