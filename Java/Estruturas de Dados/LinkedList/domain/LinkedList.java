package LinkedList.domain;

import LinkedList.exceptions.*;

public class LinkedList<T> {
    private Node<T> firstNode = null;
    private Node<T> lastNode = null;
    private int lenght = 0;

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
    
    public Node<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<T> lastNode) {
        this.lastNode = lastNode;
    }

    public LinkedList() {
    }

    public Node<T> addNode(T data){
        if(getFirstNode() == null){
            setFirstNode(new Node<T>(data));
            setLenght(getLenght() + 1);
            setLastNode(getFirstNode());
            return getFirstNode();
        }else{
            getLastNode().setProxNode(new Node<T>(data));
            setLastNode(getLastNode().getProxNode());
            return getLastNode();
        }
    }

    @SuppressWarnings("unchecked")
    public Node<T>[] find(T data) throws NodeNotFoundException, LinkedListEmpty {
        Node<T> node = getFirstNode();
        if(node == null){
            throw new LinkedListEmpty("LinkedList is empty");
        }
        Node<T>[] nodes = (Node<T>[]) new Node[2];
        while(node != null){
            if(node.getData().equals(data)){
                nodes[0] = null;
                nodes[1] = node;
                return nodes;
            }
            if(node.getProxNode() != null && node.getProxNode().getData().equals(data)){
                nodes[0] = node;
                nodes[1] = node.getProxNode();
                return nodes;
            }
            node = node.getProxNode();
        }
        throw new NodeNotFoundException("Node not found");
    }

    public Node<T> removeNode(T data) throws NodeNotFoundException, LinkedListEmpty {
        Node<T>[] nodes = find(data);
        if(nodes == null){
            throw new NodeNotFoundException("Node not found");
        }
        if(nodes[0] == null){
            setFirstNode(nodes[1].getProxNode());
            setLenght(getLenght() - 1);
            return nodes[1];
        }else{
            nodes[0].setProxNode(nodes[1].getProxNode());
            setLenght(getLenght() - 1);
            return nodes[1];
        }
    }

    public Node<T> updateNode(T data, T newData) throws NodeNotFoundException, LinkedListEmpty {
        Node<T>[] nodes = find(data);
        if(nodes == null){
            throw new NodeNotFoundException("Node not found");
        }
        nodes[1].setData(newData);
        return nodes[1];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = getFirstNode();
        if (node == null) {
            return "null";
        }
        while(node != null){
            sb.append(node.getData().toString());
            sb.append(" -> ");
            node = node.getProxNode();
        }
        sb.append("null");
        return sb.toString();
    }


}