package DoublyLinkedList.domain;

import DoublyLinkedList.exceptions.*;

public class DoublyLinkedList<T> {
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

    public DoublyLinkedList() {
    }

    public Node<T> addNode(T data){
        if(getFirstNode() == null){
            setFirstNode(new Node<T>(data));
            setLenght(getLenght() + 1);
            setLastNode(getFirstNode());
            return getFirstNode();
        }else{
            getLastNode().setProxNode(new Node<T>(data));
            getLastNode().getProxNode().setPrevNode(getLastNode());
            setLastNode(getLastNode().getProxNode());
            setLenght(getLenght() + 1);
            return getLastNode();
        }
    }

    public Node<T> find(T data) throws NodeNotFoundException, DoublyLinkedListEmpty {
        Node<T> node = getFirstNode();
        if(node == null){
            throw new DoublyLinkedListEmpty("LinkedList is empty");
        }
        Node<T> noder = null;
        while(node != null){
            if(node.getData().equals(data)){
                noder = node;
                return noder;
            }
            node = node.getProxNode();
        }
        throw new NodeNotFoundException("Node not found");
    }

    public Node<T> removeNode(T data) throws NodeNotFoundException, DoublyLinkedListEmpty {
        Node<T> noder = find(data);
        if(noder == null){
            throw new NodeNotFoundException("Node not found");
        }
        if(noder == getFirstNode()){
            setFirstNode(noder.getProxNode());
            getFirstNode().setPrevNode(null);
            setLenght(getLenght() - 1);
            return noder;
        }else{
            if(noder == getLastNode()){
                setLastNode(noder.getPrevNode());
                getLastNode().setProxNode(null);
                setLenght(getLenght() - 1);
                return noder;
            }else{
                noder.getPrevNode().setProxNode(noder.getProxNode());
                noder.getProxNode().setPrevNode(noder.getPrevNode());
                setLenght(getLenght() - 1);
                return noder;
            }
        }
    }

    public Node<T> updateNode(T data, T newData) throws NodeNotFoundException, DoublyLinkedListEmpty {
        Node<T> noder = find(data);
        if(noder == null){
            throw new NodeNotFoundException("Node not found");
        }
        noder.setData(newData);
        return noder;
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