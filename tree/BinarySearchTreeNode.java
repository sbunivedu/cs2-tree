package tree;

public class BinarySearchTreeNode<T> extends BinaryTreeNode<T>{
  public BinarySearchTreeNode(T element){
    super(element);
  }

  public void insert(BinarySearchTreeNode<T> node){
    Comparable<T> newElement = (Comparable<T>) node.element;
    if(newElement.compareTo(element) == 0) {
      // replace current node
      this.element = element;
    }
    else if(newElement.compareTo(element) < 0){
      // insert in left
      if (left == null){
        left = node;
      }else {
        ((BinarySearchTreeNode<T>) left).insert(node);
      }
    }else{
      // insert in right
      if (right == null){
        right = node;
      }else {
        ((BinarySearchTreeNode<T>) right).insert(node);
      }
    }
  }

  public T search(T element){
    Comparable target = (Comparable) element;
    if(target.compareTo(this.element) == 0){
      return element;
    }else if(target.compareTo(this.element) < 0){
      // search in left
      if(left == null){
        return null;
      }else{
        return ((BinarySearchTreeNode<T>) left).search(element);
      }
    }else{
      // search in right
      if(right == null){
        return null;
      }else{
        return ((BinarySearchTreeNode<T>) right).search(element);
      }
    }
  }

  // return the updated node, which can be null.
  public BinarySearchTreeNode<T> delete(T element){
    Comparable target = (Comparable) element;
    if(target.compareTo(this.element) == 0){
      if(left == null && right == null){
        return null;
      }else if(right != null){
        // promote right child, graft left to be
        // the left most descendent of right
        BinarySearchTreeNode<T> current = (BinarySearchTreeNode<T>) right;
        while(current.left != null){
          current = (BinarySearchTreeNode<T>) current.left;
        }
        current.left = left;
        return (BinarySearchTreeNode<T>) right;
      }
    }else if(target.compareTo(this.element) < 0){
      left = ((BinarySearchTreeNode<T>) left).delete(element);
    }else{
      right = ((BinarySearchTreeNode<T>) right).delete(element);
    }
    return this;
  }
}