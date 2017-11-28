package tests;

import tree.BinarySearchTree;

public class BinarySearchTreeTest{
  public static void main(String[] args){
    BinarySearchTree tree = new BinarySearchTree("K");
    String keys = "AODHJ";
    for (char key: keys.toCharArray()) {
      tree.insert(""+key);
    }

    // test insert
    System.out.println("expect:\tADHJKO");
    System.out.println("got:\t"+tree.inorder());
    tree.printTree();

    // test search
    System.out.println("expect:\tD");
    System.out.println("got:\t"+tree.search("D"));

    System.out.println("expect:\tnull");
    System.out.println("got:\t"+tree.search("F"));
  }
}