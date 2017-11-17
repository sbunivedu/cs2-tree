package tests;

import tree.BinarySearchTree;

public class BinarySearchTreeTest{
  public static void main(String[] args){
    BinarySearchTree tree = new BinarySearchTree("A", "A");
    tree.insert(new BinarySearchTree("B", "B"));
    tree.insert(new BinarySearchTree("C", "C"));
    tree.insert(new BinarySearchTree("D", "D"));
    tree.insert(new BinarySearchTree("E", "E"));

    // test insert
    System.out.println("expect:\tABCDE");
    System.out.println("got:\t"+tree.inorder());
  }
}