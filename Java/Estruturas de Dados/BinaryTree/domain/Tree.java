package BinaryTree.domain;

import BinaryTree.Exceptions.NoneNodeException;
import BinaryTree.Exceptions.RootNodeException;

public class Tree<T extends Comparable<? super T>> {
    Node<T> rootNode = null;

    private boolean setRootNode(Node<T> node){
        if (this.rootNode == null){
            this.rootNode = node;
            return true;
        }else{
            return false;
        }
    }

    private Node<T> decisionNode(T value, Node<T> node){
        if(node == null) return null;

        int comparison = node.getData().compareTo(value);
        if (comparison == 0){
            return node;
        }else{
            Node<T> sNode = node;
            if(comparison >= 0){
                sNode = decisionNode(value, node.getLeft());
            }else{
                sNode = decisionNode(value, node.getRight());
            }

            if(sNode == null){
                return node;
            }
            return sNode;
        }
    }

    public Node<T> findNode(T value){
        if (this.rootNode == null) return null;

        Node<T> node = decisionNode(value, this.rootNode);

        int comparison = node.getData().compareTo(value);
        if (comparison==0) return node;
    
        return null;
    }

    public String openNode(T value) throws RootNodeException{
        Node<T> node = findNode(value);

        if (node == null && this.rootNode == null) {
            throw new RootNodeException("Não é possivel pesquisar em uma árvore nula.");
        }

        if (node == null) return "Valor não encontrado na árvore";

        return (
            "Node: " + 
            node.toString() + 
            " - HashCode: " + 
            node.hashCode() + 
            (
                node.getRight() != null ?
                " - Filho direito: " + 
                node.getRight().toString() :
                ""
            ) + 
            (
                node.getLeft() != null ? 
                " - Filho Esquerdo: " + 
                node.getLeft().toString() :
                ""
            )
        );
    }

    public String openNode(Node<T> node){
        return (
            "Node: " + 
            node.toString() + 
            " - HashCode: " + 
            node.hashCode() + 
            (
                node.getRight() != null ?
                " - Filho direito: " + 
                node.getRight().toString() :
                ""
            ) +
            (
                node.getLeft() != null ?
                " - Filho Esquerdo: " + 
                node.getLeft().toString() :
                ""
            )
        );
    }

    public boolean insertNode(T value){
        if(this.rootNode == null){
            return setRootNode(new Node<T>(value));
        }

        Node<T> node = decisionNode(value, this.rootNode);

        int comparison = node.getData().compareTo(value);

        if (comparison >= 0){
            Node<T> son = new Node<T>(value);
            son.setFather(node);
            return node.setLeft(son);
        }else{
            Node<T> son = new Node<T>(value);
            son.setFather(node);
            return node.setRight(son);
        }
    }

    private boolean removeRootNode(){
        if(this.rootNode.getLeft() == null){
            Node<T> node = this.rootNode.getRight();
            if(node != null) node.setFather(null);
            System.out.println(openNode(this.rootNode) + "removido com sucesso");
            this.rootNode = node;
            return true;
        }

        Node<T> p = this.rootNode;
        Node<T> q = this.rootNode.getLeft();

        while(q.getRight() != null){
            p = q;
            q = q.getRight();
        }

        if(!p.equals(this.rootNode)){
            Node<T> child = q.getLeft();

            p.setRight(child);

            if(child != null){
                child.setFather(p);
            }

            q.setLeft(this.rootNode.getLeft());
        }

        q.setRight(this.rootNode.getRight());
        System.out.println(openNode(this.rootNode) + "removido com sucesso");
        this.rootNode = q;
        q.setFather(null);
        return true;
    }

    private Node<T> removeCommonNode(Node<T> r){
        if(r.getLeft() == null){
            Node<T> q = r.getRight();
            q.setFather(r.getFather());
            return q;
        }

        Node<T> p = r;
        Node<T> q = r.getLeft();

        while(q.getRight() != null){
            p = q;
            q = q.getRight();
        }

        if(!p.equals(r)){
            Node<T> child = q.getLeft();

            p.setRight(child);

            if(child != null){
                child.setFather(p);
            }

            q.setLeft(r.getLeft());
        }

        q.setRight(r.getRight());
        q.setFather(r.getFather());
        return q;
    }

    public boolean removeNode(T value) throws NoneNodeException{
        Node<T> node = findNode(value);
        
        if (node == null){
            throw new NoneNodeException("Não é possível remover o nó pois ele não existe.");
        }

        if(node.equals(this.rootNode)){
            return removeRootNode();
        }else{
            if (node.getLeft() == null && node.getRight() == null){
                Node<T> p = node.getFather();
                if(p.getLeft().equals(node)){
                    p.setLeft(null);
                }else{
                    p.setRight(null);
                }
            }else{
                Node<T> p = node.getFather();
                if(p.getLeft().equals(node)){
                    p.setLeft(removeCommonNode(node));
                }else{
                    p.setRight(removeCommonNode(node));
                }
            }
        }
        System.out.println(openNode(node) + "removido com sucesso");
        return true;
    }

    public boolean updateNode(T value, T newValue){
        boolean a = false;
        try{
            a = removeNode(value);
        }catch (NoneNodeException e){
            System.out.print(e);
            return false;
        }
        boolean b = insertNode(newValue);
        System.out.print(value + " -> " + newValue);
        return a && b;
    }

    public String terminal(Node<T> x, String prefixo){
        String resultString = "";
        String Nprefix = "";

        if (this.rootNode == null){
            resultString = "null\n";
        }else{
            if (x.getFather() == null){
                resultString = x.toString();
            }else{
                String ponteiro;
                String segmento;
                if (x.getFather().getRight() != null && x.getFather().getLeft() != null && !x.getFather().getRight().equals(x)) {
                    ponteiro = "├── ";
                    segmento = "│   ";
                } else {
                    ponteiro = "└── ";
                    segmento = "    ";
                }
                resultString = resultString + (prefixo + (ponteiro)) + (x.toString());
                Nprefix = prefixo + segmento; 
            }

            if(x.getLeft() != null){
                resultString +=  (this.terminal(x.getLeft(), Nprefix));
            }

            if(x.getRight() != null){
                resultString += (this.terminal(x.getRight(), Nprefix));
            }
        }

        return resultString;
    }

    public String toString(){
        return this.terminal(rootNode, "");
    }
}
