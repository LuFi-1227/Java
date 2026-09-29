package Stack.domain;

public class Stack<T> {
    private Node<T> firstNode = null;

    public boolean insertNode(T data){
        if (this.firstNode == null){
            this.firstNode = new Node<T>(data);
            return true;
        }else{
            Node<T> newNode = new Node<T>(data);
            newNode.setProxNode(this.firstNode);
            this.firstNode = newNode;
            return true;
        }
    }

    public boolean removeNode(){
        if (this.firstNode == null) return false;
        this.firstNode = this.firstNode.getProxNode();
        return true;
    }

    public boolean updateNode(T value, T newValue){
        Node<T> p = findNode(value);
        p.setData(newValue);
        return true;
    }

    public Node<T> findNode(T value){
        Node<T> p = this.firstNode;

        if (p == null) return null;

        while (!p.getData().equals(value)){
            p = p.getProxNode();
            if (p == null){
                return null;
            }
        }

        return p;
    }

    public String toString(){
        String resultString = "";
        Node<T> p = this.firstNode;

        while (p != null){
            resultString += p.getData() + (p.getProxNode() != null ? " -> " : "");
        }

        return resultString;
    }
}
