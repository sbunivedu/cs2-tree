package tests;

import tree.BinaryTree;

public class BinaryTreeTest{
  public static void main(String[] args){
    /* create a tree as follows

             /----- E
     /----- C
     |       \----- D
    A
     \----- B

    */
    BinaryTree<String> t1 = new BinaryTree<String>("D", null, null);
    BinaryTree<String> t2 = new BinaryTree<String>("E", null, null);
    BinaryTree<String> t3 = new BinaryTree<String>("C", t1, t2);
    BinaryTree<String> t4 = new BinaryTree<String>("B", null, null);
    BinaryTree<String> tree = new BinaryTree<String>("A", t4, t3);

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

    // test pretty print
    tree.printTree();
  }
}