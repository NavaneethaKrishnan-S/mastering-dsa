package com.masteringdsa.dsaconcepts.binaryTrees;

public class AVLTree {
    private class AVLNode{
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    private AVLNode root;

    public void insert(int value){
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value){
        if(root == null){
            return new AVLNode(value);
        }

        if(value > root.value)
            root.rightChild = insert(root.rightChild, value);
        else
            root.leftChild = insert(root.leftChild, value);

        return root;
    }
}
