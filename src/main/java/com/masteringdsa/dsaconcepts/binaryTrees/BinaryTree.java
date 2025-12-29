package com.masteringdsa.dsaconcepts.binaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private class Node{
        private final int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public String toString(){
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value){
        var newNode = new Node(value);
        if(root == null){
            root = newNode;
            return;
        }

        var currentNode = root;
        while(true){
            if(value < currentNode.value){
                if(currentNode.leftChild == null){
                    currentNode.leftChild = newNode;
                    break;
                }
                currentNode = currentNode.leftChild;
            }else{
                if(currentNode.rightChild == null){
                    currentNode.rightChild = newNode;
                    break;
                }
                currentNode = currentNode.rightChild;
            }
        }
    }

    public boolean find(int value){
        var currentNode = root;
        while(currentNode != null){
            if(value < currentNode.value)
                currentNode = currentNode.leftChild;
            else if(value > currentNode.value)
                currentNode = currentNode.rightChild;
            else
                return true;
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

        traverseInOrder(root.leftChild);
        traverseInOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height(){
        return height(root);
    }

    private int height(Node root){
        if(isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private static boolean isLeaf(Node root) {
        return root.leftChild == null && root.rightChild == null;
    }

    public int min(){
        return min(root);
    }

    private int min(Node root){
        if(isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(BinaryTree other){
    return equals(root, other.root);
    }

    private boolean equals(Node first, Node second){
    if(first == null && second == null)
        return true;

    if(first != null && second != null){
        return first.value == second.value &&
                equals(first.leftChild, second.leftChild) &&
                equals(first.rightChild, second.rightChild);
    }

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

    public ArrayList<Integer> getNodesAtDistance(int distance){
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList<Integer> list){
        if(root == null)
            return;

        if(distance == 0) {
            list.add(root.value);
            return;
        }

        getNodesAtDistance(root.leftChild, distance - 1, list);
        getNodesAtDistance(root.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder(){
        for(var i = 0; i <= height(); i++){
            for (var value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int size(){
        return size(root);
    }

    private int size(Node root){
        if(root == null){
            return 0;
        }

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves(){
        int count = 0;
        return countLeaves(root);
    }

    private int countLeaves(Node root){
        if (root == null) return 0;
        if (isLeaf(root)) return 1;
        return countLeaves(root.leftChild) + countLeaves(root.rightChild);
    }

    public int max(){
        return max(root);
    }

    private int max(Node root){
        if(root.rightChild == null){
            return root.value;
        }

        return max(root.rightChild);
    }

    public boolean contains(int value){
        return contains(root, value);
    }

    private boolean contains(Node root, int value){
        if(root == null)
            return false;

        if(root.value == value)
            return true;

        if(value > root.value)
            return contains(root.rightChild, value);

        return contains(root.leftChild, value);
    }

    public boolean areSibling(int left, int right){
        return areSibling(root, left, right);
    }

    private boolean areSibling(Node root, int left, int right){
        if(root == null)
            return false;

        if(root.leftChild != null && root.rightChild != null){
            int leftValue = root.leftChild.value;
            int rightValue = root.rightChild.value;

            if((leftValue == left && rightValue == right) || (rightValue == left && leftValue == right))
                return true;
        }

        return areSibling(root.leftChild, left, right) || areSibling(root.rightChild, left, right);
    }

    public List<Integer> getAncestors(int value){
        List<Integer> list = new ArrayList<>();
        return getAncestors(root, list, value);
    }

    private List<Integer> getAncestors(Node root, List<Integer> list, int value){
        if(root == null)
            return list;

        if (root.value == value) {
            return list; // stop when target is found
        }

        if (root.leftChild != null || root.rightChild != null) {
            list.add(root.value);
        }

        if(value < root.value){
            return getAncestors(root.leftChild, list, value);
        }

        return getAncestors(root.rightChild, list, value);
    }
}
