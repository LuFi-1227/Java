package BinaryTree.domain;

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
            if(comparison <= 0){
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
        Node<T> node = decisionNode(value, this.rootNode);

        int comparison = node.getData().compareTo(value);
        if (comparison==0) return node;
    
        return null;
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

            String tempString = prefixo;

            if(x.getLeft() != null){
                resultString +=  tempString + (this.terminal(x.getLeft(), Nprefix));
            }

            if(x.getRight() != null){
                resultString += tempString + (this.terminal(x.getRight(), Nprefix));
            }
        }

        return resultString;
    }

    public String toString(){
        return this.terminal(rootNode, "");
    }
}
