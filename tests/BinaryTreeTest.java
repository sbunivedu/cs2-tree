package tests;

import tree.BinaryTree;
import tree.BinaryTreeNode;

public class BinaryTreeTest{
  public static void main(String[] args){
    /* create a tree as follows
             /----- E
     /----- C
     |       \----- D
    A
     \----- B
    */
    BinaryTree<String> tree = new BinaryTree<String>("A");
    BinaryTreeNode<String> root = tree.getRoot();

    BinaryTreeNode<String> nodeE = new BinaryTreeNode<String>("E");
    BinaryTreeNode<String> nodeD = new BinaryTreeNode<String>("D");
    BinaryTreeNode<String> nodeC = new BinaryTreeNode<String>("C");
    nodeC.setLeft(nodeD);
    nodeC.setRight(nodeE);
    BinaryTreeNode<String> nodeB = new BinaryTreeNode<String>("B");
    root.setLeft(nodeB);
    root.setRight(nodeC);

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
    tree.print();
  }
}