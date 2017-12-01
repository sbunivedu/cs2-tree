package tree;

import tree.exceptions.NonComparableElementException;

public class AVLTree<T> extends BinarySearchTree<T>{
  public AVLTree(){
    super();
  }

  public AVLTree(T element){
    root = new AVLTreeNode<T>(element);
  }

  public AVLTreeNode<T> getRoot(){
    return (AVLTreeNode<T>) root;
  }

  public int depth(){
    if(isEmpty()){
      return 0;
    }else{
      return getRoot().depth();
    }
  }

  public void insert(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("AVLTree");
    }
    AVLTreeNode<T> node = new AVLTreeNode<T>(element);
    if(isEmpty()){
      root = node;
    }else{
      // returns a potential new root due to rotations.
      root = getRoot().AVLInsert(element);
    }
  }

  public void delete(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("AVLTree");
    }
    if(!isEmpty()){
      // returns a potential new root due to rotations.
      root = getRoot().AVLDelete(element);
    }
  }
}