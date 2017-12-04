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
      //System.out.println("Inserting: "+key);
      //tree.print();
      System.out.println("The height is: "+tree.height());
    }
    System.out.println("expect:\tABCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    //Display the tree
    tree.print();

    tree = new AVLTree<String>();
    keys = "JIHGFEDCBA";
    for (char key: keys.toCharArray()) {
      tree.insert(""+key);
      System.out.println("The height is: "+tree.height());
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
    System.out.println("**** test AVLDelete ****");
    System.out.println("delete: A");
    tree.delete("A");
    System.out.println("expect:\tBCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: B");
    tree.delete("B");
    System.out.println("expect:\tCDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: C");
    tree.delete("C");
    System.out.println("expect:\tDEFGHIJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("insert: H1");
    tree.insert("H1");
    System.out.println("expect:\tDEFGHH1IJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: G");
    tree.delete("G");
    System.out.println("expect:\tDEFHH1IJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: H");
    tree.delete("H");
    System.out.println("expect:\tDEFH1IJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: E");
    tree.delete("E");
    System.out.println("expect:\tDFH1IJ");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: I");
    tree.delete("I");
    System.out.println("expect:\tDFH1J");
    System.out.println("got:\t"+tree.inorder());
    tree.print();

    System.out.println("delete: J");
    tree.delete("J");
    System.out.println("expect:\tDFH1");
    System.out.println("got:\t"+tree.inorder());
    tree.print();
  }
}