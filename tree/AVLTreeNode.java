package tree;

import java.util.LinkedList;

public class AVLTreeNode<T> extends BinarySearchTreeNode<T>{
  private int height;

  public AVLTreeNode(T element){
    super(element);
    height = 1;
  }

  public int height(){
    return height;
  }

  public int height(AVLTreeNode<T> node){
    return node==null ? 0 : node.height;
  }

  private void updateHeight(AVLTreeNode<T> node){
    if(node != null){
      node.height = Math.max(height(node.getLeft()),
                     height(node.getRight())) + 1;
    }
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
    int compareResult = ((Comparable<T>) element).compareTo(this.element);
    if(compareResult == 0) {
      // replace current node
      this.element = element;
    }
    else if(compareResult < 0){
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
    AVLTreeNode<T> result = balance(this);
    return result;
  }

  private int balanceFactor(){
    return height(getRight()) - height(getLeft());
  }

  private AVLTreeNode<T> balance(AVLTreeNode<T> root){
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
    updateHeight(root);
    return root;
  }

  private AVLTreeNode<T> singleLeftRotation(){
    //TASK: Rotate the right child up and to the left to
    //      become the new root of this subtree
    AVLTreeNode<T> newRoot = getRight();
    right = right.left;
    newRoot.left = this;
    updateHeight(this);
    updateHeight(newRoot);
    return newRoot;
  }

  private AVLTreeNode<T> singleRightRotation(){
    //TASK: Rotate the left child up and to the right to
    //      become the new root of this subtree
    AVLTreeNode<T> newRoot = getLeft();
    left = left.right;
    newRoot.right = this;
    updateHeight(this);
    updateHeight(newRoot);
    return newRoot;
  }

  private AVLTreeNode<T> doubleLeftRightRotation(){
    //TASK: Rotate the left subtree to the left, then up
    //      and to the right to become the new root of this subtree
    left = getLeft().singleLeftRotation();
    return this.singleRightRotation();
  }

  private AVLTreeNode<T> doubleRightLeftRotation(){
    //TASK: Rotate the right subtree to the right, then up and to
    //      the left to become the new root of this subtree
    right = getRight().singleRightRotation();
    return this.singleLeftRotation();
  }

  public AVLTreeNode<T> AVLDelete(T element){
    AVLTreeNode<T> result = this;

    int compareResult = ((Comparable<T>) element).compareTo(this.element);
    if(compareResult < 0){
      // delete in left
      if (left != null){
        left = getLeft().AVLDelete(element);
      }
    }else if(compareResult > 0){
      // delete in right
      if (right != null){
        right = getRight().AVLDelete(element);
      }
    }else{
      // need to delete this node
      if(left != null & right != null){
        AVLTreeNode<T> successor = findMin(getRight());
        this.element = successor.element;
        right = getRight().AVLDelete(successor.element);
      }else if(left == null){
        result = getRight();
      }
    }
    result = balance(result);
    return result;
  }

  private AVLTreeNode<T> findMin(AVLTreeNode<T> node){
    while(node.left != null){
      node = node.getLeft();
    }
    return node;
  }

  public String toString(){
    return element.toString()+"("+height+")";
  }
}