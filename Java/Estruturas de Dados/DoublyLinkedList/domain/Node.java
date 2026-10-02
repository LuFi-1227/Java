package DoublyLinkedList.domain;

public class Node<T> {
    private T data;
    private Node<T> proxNode = null;
    private Node<T> prevNode = null;

    public Node<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }

    public Node(T data){
        this.data = data;
    }

    public Node(T data, Node<T> proxNode){
        this.data = data;
        this.proxNode = proxNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getProxNode() {
        return proxNode;
    }

    public void setProxNode(Node<T> proxNode) {
        this.proxNode = proxNode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((proxNode == null) ? 0 : proxNode.hashCode());
        result = prime * result + ((prevNode == null) ? 0 : prevNode.hashCode());
        return result;
    }

    public boolean equals(Node<T> obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Node<T> other = obj;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (proxNode == null) {
            if (other.proxNode != null)
                return false;
        } else if (!proxNode.equals(other.proxNode))
            return false;
        if (prevNode == null) {
            if (other.prevNode != null)
                return false;
        } else if (!prevNode.equals(other.prevNode))
            return false;
        return true;
    }

    public String toString(){
        return this.data.toString();
    }

    public String openNode(){
        return ("Data: " + this.data.toString() + (this.getProxNode() != null ? (" Next: " + this.getProxNode().toString()) : "") + (this.getPrevNode() != null ? (" Previous: " + this.getPrevNode().toString()) : ""));
    }
}