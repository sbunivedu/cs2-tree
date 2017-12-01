package tree;

public class AVLTreeNode<T> extends BinarySearchTreeNode<T>{
  private int depth;

  public AVLTreeNode(T element){
    super(element);
    depth = 1;
  }

  public int depth(){
    return depth;
  }
  public int depth(AVLTreeNode<T> node){
    return node==null ? 0 : node.depth;
  }

  public AVLTreeNode<T> getLeft(){
    return (AVLTreeNode<T>) left;
  }

  public AVLTreeNode<T> getRight(){
    return (AVLTreeNode<T>) right;
  }

  public AVLTreeNode<T> AVLInsert(T element){
    AVLTreeNode<T> node = new AVLTreeNode<T>(element);
    Comparable<T> newElement = (Comparable<T>) element;
    if(newElement.compareTo(this.element) == 0) {
      // replace current node
      this.element = element;
    }
    else if(newElement.compareTo(this.element) < 0){
      // insert in left
      if (left == null){
        left = node;
      }else {
        left = getLeft().AVLInsert(element);
      }
    }else{
      // insert in right
      if (right == null){
        right = node;
      }else {
        right = getRight().AVLInsert(element);
      }
    }
    AVLTreeNode<T> result = balance();

    // update depth!
    result.depth = Math.max(depth(result.getLeft()),
                            depth(result.getRight())) + 1;

    return result;
  }

  private int balanceFactor(){
    return depth(getRight()) - depth(getLeft());
  }

  private AVLTreeNode<T> balance(){
    AVLTreeNode<T> root = this;
    if(balanceFactor() == -2){
      // case 1: left subtree too tall
      // decide what sort of rotation will fix the problem
      if(getLeft().balanceFactor() < 0 ){
        // left subtree of left child is too tall
        // fix with a single right rotation
        root = singleRightRotation();
      }else{
        // right subtree of left child is too tall
        // so double rotation is necessary
        root = doubleLeftRightRotation();
      }
    }else if (balanceFactor() == 2){
      // case 2: right subtree too tall
      // decide what sort of rotation will fix the problem
      if(getRight().balanceFactor() > 0 ){
        // right subtree of right child is too tall
        // fix with a single right rotation
        root = singleLeftRotation();
      }else{
        // left subtree of right child is too tall
        // so double rotation is necessary
        root = doubleRightLeftRotation();
      }
    }
    return root;
  }

  private AVLTreeNode<T> singleLeftRotation(){
    //TASK: Rotate the right child up and to the left to
    //      become the new root of this subtree
    AVLTreeNode<T> newRoot = getRight();
    right = right.left;
    newRoot.left = this;

    depth = Math.max(depth(getLeft()), depth(getRight())) + 1;
    newRoot.depth = Math.max(depth(newRoot.getLeft()),
                             depth(newRoot.getRight())) + 1;
    return newRoot;
  }

  private AVLTreeNode<T> singleRightRotation(){
    //TASK: Rotate the left child up and to the right to
    //      become the new root of this subtree
    AVLTreeNode<T> newRoot = getLeft();
    left = left.right;
    newRoot.right = this;
    depth = Math.max(depth(getLeft()), depth(getRight())) + 1;
    newRoot.depth = Math.max(depth(newRoot.getLeft()),
                             depth(newRoot.getRight())) + 1;
    return newRoot;
  }

  private AVLTreeNode<T> doubleLeftRightRotation(){
    //TASK: Rotate the left subtree to the left, then up
    //      and to the right to become the new root of this subtree
    left = getLeft().singleLeftRotation();
    return singleRightRotation();
  }

  private AVLTreeNode<T> doubleRightLeftRotation(){
    //TASK: Rotate the right subtree to the right, then up and to
    //      the left to become the new root of this subtree
    right = getRight().singleRightRotation();
    return singleLeftRotation();
  }
}