package tests;

import tree.BinaryTree;

public class BinaryTreeTest{
  public static void main(String[] args){
    /* create a tree as follows

    */
    BinaryTree t1 = new BinaryTree("D", null, null);
    BinaryTree t2 = new BinaryTree("E", null, null);
    BinaryTree t3 = new BinaryTree("C", t1, t2);
    BinaryTree t4 = new BinaryTree("B", null, null);
    BinaryTree tree = new BinaryTree("A", t4, t3);

    // test traversal methods
    System.out.println("test inorder traversal");
    System.out.println("expect:\tBADCE");
    System.out.println("got:\t"+tree.inorder());
    System.out.println("test preorder traversal");
    System.out.println("expect:\tABCDE");
    System.out.println("got:\t"+tree.preorder());
    System.out.println("test postorder traversal");
    System.out.println("expect:\tBDECA");
    System.out.println("got:\t"+tree.postorder());
  }
}