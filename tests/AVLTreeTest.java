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

    // test search
    System.out.println("expect:\tE");
    System.out.println("got:\t"+tree.search("E"));
    System.out.println("expect:\tnull");
    System.out.println("got:\t"+tree.search("K"));

    // test AVLDelete
    tree.delete("A");
    System.out.println("expect:\tBCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    tree.delete("B");
    System.out.println("expect:\tCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    tree.delete("C");
    System.out.println("expect:\tDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    tree.delete("G");
    System.out.println("expect:\tDEFHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();
  }
}