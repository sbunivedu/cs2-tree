package tree;

import tree.exceptions.NonComparableElementException;

public class BinarySearchTree<T> extends BinaryTree<T>{
  public BinarySearchTree(T element){
    super(element, null, null);
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }
  }

  public void insert(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }
    Comparable<T> current = (Comparable<T>) this.element;
    BinarySearchTree<T> node = new BinarySearchTree<T>(element);
    if(current.compareTo(element) == 0) {
      // replace current node
      this.element = element;
    }
    else if(current.compareTo(element) > 0){
      // insert in left subtree
      if (left == null){
        left = node;
      }else {
        ((BinarySearchTree<T>) left).insert(element);
      }
    }else{
      // insert in right subtree
      if (right == null){
        right = node;
      }else {
        ((BinarySearchTree<T>) right).insert(element);
      }
    }
  }

  public T search(T element){
    if(!(element instanceof Comparable)){
      throw new NonComparableElementException("BinarySearchTree");
    }
    Comparable current = (Comparable) this.element;
    if(current.compareTo(element) == 0){
      return element;
    }else if(current.compareTo(element) < 0){
      // search in left subtree
      if(left == null){
        return null;
      }else{
        return ((BinarySearchTree<T>) left).search(element);
      }
    }else{
      // search in right subtree
      if(right == null){
        return null;
      }else{
        return ((BinarySearchTree<T>) right).search(element);
      }
    }
  }
}