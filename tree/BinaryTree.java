package tree;

public class BinaryTree<T>{
  protected BinaryTreeNode<T> root;

  // create an empty tree
  public BinaryTree(){
    root = null;
  }

  public BinaryTree(T element){
    root = new BinaryTreeNode<T>(element);
  }

  public boolean isEmpty(){
    return root == null;
  }

  public BinaryTreeNode<T> getRoot(){
    return root;
  }

  public String toString(){
    return inorder();
  }

  public String inorder(){
    return root.inorder();
  }

  public String preorder(){
    return root.preorder();
  }

  public String postorder(){
    return root.postorder();
  }

  public void print(){
    root.print();
  }
}