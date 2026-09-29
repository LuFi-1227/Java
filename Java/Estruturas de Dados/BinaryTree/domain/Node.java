package BinaryTree.domain;

public class Node<T> {
    private Node<T> left = null;
    private Node<T> right = null;
    private Node<T> father = null;
    private T data;

    public Node(T data) {
        this.data = data;
    }

    public Node(Node<T> left, Node<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public Node(Node<T> father, Node<T> left, Node<T> right, T data) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.father = father;
    }

    public T getData(){
        return this.data;
    }

    public boolean setData(T data){
        try{
            this.data = data;
            return true;
        }catch (Exception e){
            System.out.println("Erro ao tentar definir data.in.node: " + e);
            return false;
        }
    }

    public Node<T> getLeft(){
        return this.left;
    }

    public Node<T> getRight(){
        return this.right;
    }

    public Node<T> getFather(){
        return this.father;
    }

    public boolean setFather(Node<T> father){
        try{
            this.father = father;
            return true;
        }catch(Exception e){
            System.out.println("Erro ao tentar definir father.in.node: " + e);
            return false;
        }
    }

    public boolean setLeft(Node<T> left){
        try{
            this.left = left;
            return true;
        }catch(Exception e){
            System.out.println("Erro ao tentar definir left.in.node: " + e);
            return false;
        }
    }

    public boolean setRight(Node<T> right){
        try{
            this.right = right;
            return true;
        }catch(Exception e){
            System.out.println("Erro ao tentar definir right.in.node: " + e);
            return false;
        }
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
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
        if (left == null) {
            if (other.left != null)
                return false;
        } else if (!left.equals(other.left))
            return false;
        if (right == null) {
            if (other.right != null)
                return false;
        } else if (!right.equals(other.right))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        return true;
    }

    public String toString(){
        return this.data.toString() + "\n";
    }
}
