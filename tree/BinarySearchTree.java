package tree;

public class BinarySearchTree extends BinaryTree{
  private String key;

  public BinarySearchTree(String key, Object element){
    super(element, null, null);
    this.key = key;
  }

  public void insert(BinarySearchTree tree){
    if (tree.key.compareTo (this.key) == 0) {
      // replace current node
      this.setElement(tree.getElement());
    }
    else if (tree.key.compareTo (this.key) < 0){
      // insert in left subtree
      if (left == null){
        this.setLeft(tree);
      }else {
        ((BinarySearchTree) getLeft()).insert(tree);
      }
    }else{
      // insert in right subtree
      if (right == null){
        this.setRight(tree);
      }else {
        ((BinarySearchTree) getRight()).insert(tree);
      }
    }
  }

  public String toString(){
    return key;
  }
}