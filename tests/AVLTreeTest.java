package tests;

import tree.AVLTree;

public class AVLTreeTest{
  public static void main(String[] args){
    //Create the empty tree
    AVLTree tree = new AVLTree<String>();

    // test AVLInsert
    String keys = "ABCDEFGHIJ";
    for (char key: keys.toCharArray()) {
      tree.insert(""+key);
      System.out.println("The depth is: "+tree.depth());
    }
    System.out.println("expect:\tABCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    //Display the tree
    tree.print();

    tree = new AVLTree<String>();
    keys = "JIHGFEDCBA";
    for (char key: keys.toCharArray()) {
      tree.insert(""+key);
      System.out.println("The depth is: "+tree.depth());
    }
    System.out.println("expect:\tABCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    //Display the tree
    tree.print();
  }
}