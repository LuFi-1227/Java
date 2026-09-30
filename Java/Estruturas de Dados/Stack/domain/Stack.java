package Stack.domain;

import Stack.exceptions.FullStackException;
import Stack.exceptions.NullStackException;

public class Stack<T> {
    private Node<T> firstNode = null;
    private int lenght = 0;
    private int maxLenght = 0; // If maxLenght is equal 0, the stack do not have a maxlenght.

    public int getLenght() {
        return lenght;
    }

    public Stack(Node<T> firstNode, int lenght, int maxLenght) {
        this.firstNode = firstNode;
        this.lenght = lenght;
        this.maxLenght = maxLenght;
    }

    public Stack(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Stack(Node<T> firstNode, int maxLenght) {
        this.firstNode = firstNode;
        this.maxLenght = maxLenght;
    }

    public Stack() {
    }

    public Stack(int maxLenght) {
        this.maxLenght = maxLenght;
    }

    public int getMaxLenght() {
        return maxLenght;
    }

    public void setMaxLenght(int maxLenght) {
        this.maxLenght = maxLenght;
    }

    public boolean insertNode(T data) throws FullStackException{
        if (maxLenght > lenght || maxLenght==0){
            if (this.firstNode == null){
                this.firstNode = new Node<T>(data);
                lenght++;
            }else{
                Node<T> newNode = new Node<T>(data);
                newNode.setProxNode(this.firstNode);
                this.firstNode = newNode;
                lenght++;
            }
            System.out.println(openNode(this.firstNode) + "added!");
            return true;
        }else{
            throw new FullStackException("A pilha está cheia.");
        }
    }

    private String openNode(Node<T> node){
        return "Node: " + node.toString() + (node.getProxNode() != null ? " - nextNode: " + node.getProxNode().toString() : "");
    }

    public boolean removeNode() throws NullStackException{
        if (this.firstNode == null) throw new NullStackException("A pilha se encontra vazia");

        System.out.println(openNode(this.firstNode) + " removed!");
        this.firstNode = this.firstNode.getProxNode();
        lenght--;
        return true;
    }

    public boolean updateNode(T value, T newValue) throws NullStackException{
        Node<T> p = findNode(value);

        if(p==null) return false;

        System.out.println(openNode(p) + " updated to " + newValue);
        p.setData(newValue);
        System.out.println(openNode(p));
        return true;
    }

    public Node<T> findNode(T value) throws NullStackException{
        Node<T> p = this.firstNode;

        if (p == null) throw new NullStackException("A pilha se encontra vazia");

        while (!p.getData().equals(value)){
            p = p.getProxNode();
            if (p == null){
                return null;
            }
        }

        return p;
    }

    public String findAndOpenNode(T value) throws NullStackException{
        Node<T> p = findNode(value);
        if (p==null) return "";
        return openNode(p);
    }

    public String toString(){
        String resultString = "Stack len: " + this.lenght + "\n\n";
        Node<T> p = this.firstNode;

        while (p != null){
            resultString += p.getData() + (p.getProxNode() != null ? " -> " : "");
            p = p.getProxNode();
        }

        return resultString;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstNode == null) ? 0 : firstNode.hashCode());
        result = prime * result + lenght;
        result = prime * result + maxLenght;
        return result;
    }

    public boolean equals(Stack<T> obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Stack<T> other = obj;
        if (firstNode == null) {
            if (other.firstNode != null)
                return false;
        } else if (!firstNode.equals(other.firstNode))
            return false;
        if (lenght != other.lenght)
            return false;
        if (maxLenght != other.maxLenght)
            return false;
        return true;
    }

    public Stack<T> copy(){
        Node<T> p = this.firstNode;
        Node<T> node = new Node<T>(p.getData());
        Stack<T> stack = new Stack<T>(node, this.lenght, this.maxLenght);

        while (p != null){
            p = p.getProxNode();
            node.setProxNode(new Node<T>(p.getData()));
            node = node.getProxNode();
        }

        return stack;
    }
}
