package tree;

import tree.exceptions.NonComparableElementException;
import tree.exceptions.EmptyCollectionException;

public class BinarySearchTree<T> extends BinaryTree<T>{
  public BinarySearchTree(){
    super();
  }

  public BinarySearchTree(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }
    root = new BinarySearchTreeNode<T>(element);
  }

  public void insert(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }
    BinarySearchTreeNode<T> node = new BinarySearchTreeNode<T>(element);
    if(isEmpty()){
      root = node;
    }else{
      ((BinarySearchTreeNode<T>) root).insert(node);
    }
  }

  public T search(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }

    return ((BinarySearchTreeNode<T>) root).search(element);
  }

  public void delete(T element){
    if(isEmpty()){
      throw new EmptyCollectionException("BinarySearchTree");
    }

    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }

    root = ((BinarySearchTreeNode<T>) root).delete(element);
  }
}