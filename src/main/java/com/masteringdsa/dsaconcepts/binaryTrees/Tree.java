package com.masteringdsa.dsaconcepts.binaryTrees;

public class Tree {
    private static class Node{
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int item){

        var newNode = new Node(item);

        if(root == null){
            root = newNode;
            return;
        }

        var currentNode = root;
        while(true){
            if(item > currentNode.value){
                if(currentNode.rightChild == null){
                    currentNode.rightChild = newNode;
                    break;
                }
                currentNode = currentNode.rightChild;
            }
            else{
                if(currentNode.leftChild == null){
                    currentNode.leftChild = newNode;
                    break;
                }
                currentNode = currentNode.leftChild;
            }

        }
    }

    public boolean find(int item){

        var currentNode = root;

        while(currentNode != null){

            if(currentNode.value == item){
                return true;
            }

            if(item > currentNode.value)
                currentNode = currentNode.rightChild;
            else
                currentNode = currentNode.leftChild;
        }

        return false;
    }

    public void traversePreOrder(){
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root){
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder(){
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root){
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(root == null)
            return 0;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public boolean isEqual(Tree other){
        return isEqual(root, other.root);
    }

    private boolean isEqual(Node first, Node second){
        if(first == null && second == null)
            return true;

        if(first != null && second != null)
            return (first.value == second.value)
                && isEqual(first.leftChild, second.leftChild)
                && isEqual(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree(){
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max){
        if(root == null)
            return true;

        if(root.value < min && root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value-1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max );
    }

    private static boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }
}
